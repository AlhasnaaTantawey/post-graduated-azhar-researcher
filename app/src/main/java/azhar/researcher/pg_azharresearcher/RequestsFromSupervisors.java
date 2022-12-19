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
import com.example.pg_azharresearcher.databinding.FragmentRequestsFromSupervisorsBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class RequestsFromSupervisors extends Fragment {

  FragmentRequestsFromSupervisorsBinding fragmentRequestsFromSupervisorsBinding;
  Retrofit retrofit;
  EndPoint endPoint;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentRequestsFromSupervisorsBinding= DataBindingUtil. inflate(inflater, R.layout.fragment_requests_from_supervisors, container, false);
        retrofit=Client.getRetrofit();
        endPoint=retrofit.create(EndPoint.class);
        getAllRequestFromOneSupervisor(recieveSuperviosrId(),ResearcherActivity.ResearcherId);
        return fragmentRequestsFromSupervisorsBinding.getRoot();
    }


    public void setRecyclerView(ArrayList<RecievedRequestModel> data){
        RecyclerViewForRequest recyclerViewForRequest=new RecyclerViewForRequest(data,this);
        fragmentRequestsFromSupervisorsBinding.recyclerViewForRequests.setAdapter(recyclerViewForRequest);
        fragmentRequestsFromSupervisorsBinding.recyclerViewForRequests.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
        recyclerViewForRequest.notifyDataSetChanged();
    }
    public void getAllRequestFromOneSupervisor(int supId,int resId){
           Call<ArrayList <RecievedRequestModel>> call= endPoint.getAllRequestsFromOneSupervisorToOneResearcher(supId,resId);
           call.enqueue(new Callback<ArrayList<RecievedRequestModel>>() {
               @Override
               public void onResponse(Call<ArrayList<RecievedRequestModel>> call, Response<ArrayList<RecievedRequestModel>> response) {
                   if(!response.isSuccessful()){
                       return;
                   }
                   ArrayList<RecievedRequestModel> allData=response.body();
                   setRecyclerView(allData);
               }

               @Override
               public void onFailure(Call<ArrayList<RecievedRequestModel>> call, Throwable t) {

               }
           });

    }
    public int recieveSuperviosrId() {
        int id = 0;
        if (getArguments() != null) {
            id = getArguments().getInt("SupervisorID");
        }
        android.util.Log.i("islam", id + "     +islm");

        return id;
    }
}