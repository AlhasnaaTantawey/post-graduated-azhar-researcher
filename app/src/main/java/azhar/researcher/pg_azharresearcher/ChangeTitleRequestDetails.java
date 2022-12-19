package azhar.researcher.pg_azharresearcher;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.pg_azharresearcher.R;
import com.example.pg_azharresearcher.databinding.FragmentChangeTitleRequestDetailsBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ChangeTitleRequestDetails extends Fragment {
FragmentChangeTitleRequestDetailsBinding fragmentChangeTitleRequestDetailsBinding;
Retrofit retrofit;
EndPoint endPoint;
ChangeTitleRequestModel changeTitleRequestModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentChangeTitleRequestDetailsBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_change_title_request_details, container, false);
        retrofit=Client.getRetrofit();
        endPoint=retrofit.create(EndPoint.class);
        getChangeTitleReqest(recivedId());
        return fragmentChangeTitleRequestDetailsBinding.getRoot();
    }
    public void getChangeTitleReqest(int requestId){
        Call<ChangeTitleRequestModel> call=endPoint.getOneChangeTitleRequest(requestId);
        call.enqueue(new Callback<ChangeTitleRequestModel>() {
            @Override
            public void onResponse(Call<ChangeTitleRequestModel> call, Response<ChangeTitleRequestModel> response) {
                if(!response.isSuccessful()){
                    return;
                }

                changeTitleRequestModel=response.body();
                handleData(changeTitleRequestModel.getTypeName(),fragmentChangeTitleRequestDetailsBinding.requestTextViewRequestType);
                fragmentChangeTitleRequestDetailsBinding.requestTextViewRequestNum.setText(changeTitleRequestModel.getOrder_id()+"");
                handleData(changeTitleRequestModel.getResearcherName(),fragmentChangeTitleRequestDetailsBinding.requestTextViewResearcherName);
                handleData(changeTitleRequestModel.getSupervisorName(),fragmentChangeTitleRequestDetailsBinding.requestTextViewSupervisorName);
                fragmentChangeTitleRequestDetailsBinding.requestTextViewResearcherNum.setText(changeTitleRequestModel.getRes_id()+"");
                handleData(changeTitleRequestModel.getSent_date(),fragmentChangeTitleRequestDetailsBinding.requestTextViewRequestDate);
                handleData(changeTitleRequestModel.getUniversity_approvement(),fragmentChangeTitleRequestDetailsBinding.requestTextViewUniversityApprovement);
                handleData(changeTitleRequestModel.getFaculity_approvement(),fragmentChangeTitleRequestDetailsBinding.requestTextViewFaculityApprovement);
                handleData(changeTitleRequestModel.getDepartment_approvement(),fragmentChangeTitleRequestDetailsBinding.requestTextViewDepartmentApprovement);
                handleData(changeTitleRequestModel.getOldAddress(),fragmentChangeTitleRequestDetailsBinding.requestTextViewOldAdrresTitle);
                handleData(changeTitleRequestModel.getNewArabicAddress(),fragmentChangeTitleRequestDetailsBinding.requestTextViewNewArabicTitle);
                handleData(changeTitleRequestModel.getNewEnglishAddress(),fragmentChangeTitleRequestDetailsBinding.requestTextViewNewEnglishTitle);
                int  isEstential=changeTitleRequestModel.getIsSubstantial();
                if(isEstential==1){
                    fragmentChangeTitleRequestDetailsBinding.requestTextViewIsSubstantial.setText("تغير جزرى");
                }else if(isEstential==0){
                    fragmentChangeTitleRequestDetailsBinding.requestTextViewIsSubstantial.setText("تغير غير جزرى");
                }

            }

            @Override
            public void onFailure(Call<ChangeTitleRequestModel> call, Throwable t) {

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