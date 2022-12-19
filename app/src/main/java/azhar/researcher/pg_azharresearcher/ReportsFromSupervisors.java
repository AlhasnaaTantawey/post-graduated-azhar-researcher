package azhar.researcher.pg_azharresearcher;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pg_azharresearcher.R;
import com.example.pg_azharresearcher.databinding.FragmentReportsFromSupervisorsBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ReportsFromSupervisors extends Fragment {

    FragmentReportsFromSupervisorsBinding fragmentReportsFromSupervisorsBinding;
    Retrofit retrofit;
    EndPoint endPoint;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentReportsFromSupervisorsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_reports_from_supervisors, container, false);
        retrofit = Client.getRetrofit();
        endPoint = retrofit.create(EndPoint.class);
        getAllReportsFromOneSupervisor(recieveSuperviosrId(), ResearcherActivity.ResearcherId);
        return fragmentReportsFromSupervisorsBinding.getRoot();
    }

    public void setRecyclerView(ArrayList<ReportModel> data) {
        RecyclerViewForReport recyclerViewForReport = new RecyclerViewForReport(data, this);
        fragmentReportsFromSupervisorsBinding.recyclerViewForReports.setAdapter(recyclerViewForReport);
        fragmentReportsFromSupervisorsBinding.recyclerViewForReports.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recyclerViewForReport.notifyDataSetChanged();
    }

    public int recieveSuperviosrId() {
        int id = 0;
        if (getArguments() != null) {
            id = getArguments().getInt("SupervisorID");
        }
        return id;
    }

    public void getAllReportsFromOneSupervisor(int supId, int resId) {
        Call<ArrayList<ReportModel>> call = endPoint.getAllReportsFromOneSupervisorToOneResearcher(supId, resId);
        call.enqueue(new Callback<ArrayList<ReportModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ReportModel>> call, Response<ArrayList<ReportModel>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                ArrayList<ReportModel> allData = response.body();
                setRecyclerView(allData);
            }

            @Override
            public void onFailure(Call<ArrayList<ReportModel>> call, Throwable t) {

            }
        });

    }
}