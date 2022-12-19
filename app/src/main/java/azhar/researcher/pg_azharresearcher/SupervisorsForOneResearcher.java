package azhar.researcher.pg_azharresearcher;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pg_azharresearcher.R;
import com.example.pg_azharresearcher.databinding.FragmentSupervisorsForOneResearcherBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class SupervisorsForOneResearcher extends Fragment {
FragmentSupervisorsForOneResearcherBinding fragmentSupervisorsForOneResearcherBinding;
RecyclerViewForSupervisor recyclerViewForSupervisor;
ArrayList<SupervisorModel> listOfSupervisors;
Retrofit retrofit;
EndPoint endPoint;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentSupervisorsForOneResearcherBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_supervisors_for_one_researcher,container,false) ;
        retrofit=Client.getRetrofit();
        endPoint=retrofit.create(EndPoint.class);
        getSupervisors_res(ResearcherActivity.ResearcherId);
        goBackToPersonalInformation(this);
        return fragmentSupervisorsForOneResearcherBinding.getRoot();
    }
    //pass the data to adapter and attach recyclerView and defind layout
    public void setAdapter(ArrayList<SupervisorModel> data) {
        recyclerViewForSupervisor = new RecyclerViewForSupervisor(data,this);
        fragmentSupervisorsForOneResearcherBinding.fragmentResearcherforsupervisorRecyclerview.setAdapter(recyclerViewForSupervisor);
        fragmentSupervisorsForOneResearcherBinding.fragmentResearcherforsupervisorRecyclerview.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recyclerViewForSupervisor.notifyDataSetChanged();
    }
    public void getSupervisors_res(int id) {

        Call<ArrayList<SupervisorModel>> call = endPoint.getAllSupervisor_res(id);
        call.enqueue(new Callback<ArrayList<SupervisorModel>>() {
            @Override
            public void onResponse(Call<ArrayList<SupervisorModel>> call, Response<ArrayList<SupervisorModel>> response) {
                if (!response.isSuccessful()) {
                    return;
                }

                listOfSupervisors = response.body();
                setAdapter(listOfSupervisors);

            }

            @Override
            public void onFailure(Call<ArrayList<SupervisorModel>> call, Throwable t) {
            }
        });

    }
    public static void goBackToPersonalInformation(Fragment fragment) {
        fragment. requireActivity().getOnBackPressedDispatcher().addCallback(fragment.getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                fragment.getFragmentManager().
                        beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_supervisor,new PersonalInformationForResearcher())
                        .commit();
            }
        });
    }

}