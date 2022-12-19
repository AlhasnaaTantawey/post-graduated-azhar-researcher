package azhar.researcher.pg_azharresearcher;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.pg_azharresearcher.R;
import com.example.pg_azharresearcher.databinding.FragmentChangeSupervisorRequestDetailsBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ChangeSupervisorRequestDetails extends Fragment {

  FragmentChangeSupervisorRequestDetailsBinding fragmentChangeSupervisorRequestDetailsBinding;
  Retrofit retrofit;
  EndPoint endPoint;
ChangeSupervisorsRequestModel changeSupervisorsRequestModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentChangeSupervisorRequestDetailsBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_change_supervisor_request_details, container, false);
        retrofit=Client.getRetrofit();
        endPoint=retrofit.create(EndPoint.class);
        getChangeSupervisorReqest(recivedId());
        return fragmentChangeSupervisorRequestDetailsBinding.getRoot();
    }
    public void getChangeSupervisorReqest(int requestId){
        Call<ChangeSupervisorsRequestModel> call=endPoint.getOneChangeSupervisorRequest(requestId);
        call.enqueue(new Callback<ChangeSupervisorsRequestModel>() {
            @Override
            public void onResponse(Call<ChangeSupervisorsRequestModel> call, Response<ChangeSupervisorsRequestModel> response) {
                if(!response.isSuccessful()){
                    return;
                }

                changeSupervisorsRequestModel=response.body();
                handleData(changeSupervisorsRequestModel.getTypeName(),fragmentChangeSupervisorRequestDetailsBinding.requestTextViewRequestType);
                fragmentChangeSupervisorRequestDetailsBinding.requestTextViewRequestNum.setText(changeSupervisorsRequestModel.getOrder_id()+"");
                handleData(changeSupervisorsRequestModel.getResearcherName(),fragmentChangeSupervisorRequestDetailsBinding.requestTextViewResearcherName);
                handleData(changeSupervisorsRequestModel.getSupervisorName(),fragmentChangeSupervisorRequestDetailsBinding.requestTextViewSupervisorName);
                fragmentChangeSupervisorRequestDetailsBinding.requestTextViewResearcherNum.setText(changeSupervisorsRequestModel.getRes_id()+"");
                handleData(changeSupervisorsRequestModel.getSent_date(),fragmentChangeSupervisorRequestDetailsBinding.requestTextViewRequestDate);
                handleData(changeSupervisorsRequestModel.getUviversity_approvement(),fragmentChangeSupervisorRequestDetailsBinding.requestTextViewUniversityApprovement);
                handleData(changeSupervisorsRequestModel.getFaculity_approvement(),fragmentChangeSupervisorRequestDetailsBinding.requestTextViewFaculityApprovement);
                handleData(changeSupervisorsRequestModel.getDepartment_approvement(),fragmentChangeSupervisorRequestDetailsBinding.requestTextViewDepartmentApprovement);

            }

            @Override
            public void onFailure(Call<ChangeSupervisorsRequestModel> call, Throwable t) {

            }
        });
    }
    public void handleData (String text, TextView textView){
        if (text == null) {
            textView.setText("_______");
        } else {
            textView.setText(text.toString());
        }
    }
    public int recivedId(){
        int id=0;
        if(getArguments()!=null){
            id=getArguments().getInt("RequestId");
        }
        return id;
    }
}