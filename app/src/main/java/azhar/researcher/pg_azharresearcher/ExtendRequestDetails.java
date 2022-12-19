package azhar.researcher.pg_azharresearcher;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.pg_azharresearcher.R;
import com.example.pg_azharresearcher.databinding.FragmentExtendRequestDetailsBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ExtendRequestDetails extends Fragment {

    FragmentExtendRequestDetailsBinding fragmentRequestDetailsBinding;
    Retrofit retrofit;
    EndPoint endPoint;
    ExtensionRequestModel extensionRequestModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentRequestDetailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_extend_request_details, container, false);
        retrofit = Client.getRetrofit();
        endPoint = retrofit.create(EndPoint.class);
        getExtendReqest(recivedId());

        return fragmentRequestDetailsBinding.getRoot();
    }

    public void getExtendReqest(int requestId) {
        Call<ExtensionRequestModel> call = endPoint.getOneExtendRequest(requestId);
        call.enqueue(new Callback<ExtensionRequestModel>() {
            @Override
            public void onResponse(Call<ExtensionRequestModel> call, Response<ExtensionRequestModel> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                extensionRequestModel = response.body();
                handleData(extensionRequestModel.getTypeName(), fragmentRequestDetailsBinding.requestTextViewRequestType);
                fragmentRequestDetailsBinding.requestTextViewRequestNum.setText(extensionRequestModel.getOrder_id() + "");
                handleData(extensionRequestModel.getResearcherName(), fragmentRequestDetailsBinding.requestTextViewResearcherName);
                handleData(extensionRequestModel.getSupervisorName(), fragmentRequestDetailsBinding.requestTextViewSupervisorName);
                fragmentRequestDetailsBinding.requestTextViewResearcherNum.setText(extensionRequestModel.getRes_id() + "");
                handleData(extensionRequestModel.getSent_date(), fragmentRequestDetailsBinding.requestTextViewRequestDate);
                handleData(extensionRequestModel.getUviversity_approvement(), fragmentRequestDetailsBinding.requestTextViewUniversityApprovement);
                handleData(extensionRequestModel.getFaculity_approvement(), fragmentRequestDetailsBinding.requestTextViewFaculityApprovement);
                handleData(extensionRequestModel.getDepartment_approvement(), fragmentRequestDetailsBinding.requestTextViewDepartmentApprovement);
                int extendPeriod = extensionRequestModel.getExtend_period();
                if (extendPeriod == 1) {
                    fragmentRequestDetailsBinding.requestTextViewExtendsPeriod.setText("مد عام سادس");
                } else if (extendPeriod == 2) {
                    fragmentRequestDetailsBinding.requestTextViewExtendsPeriod.setText("مد عام سابع");
                } else if (extendPeriod == 3) {
                    fragmentRequestDetailsBinding.requestTextViewExtendsPeriod.setText("مد عام ثامن");
                }


            }

            @Override
            public void onFailure(Call<ExtensionRequestModel> call, Throwable t) {

            }
        });
    }

    public void handleData(String text, TextView textView) {
        if (text == null) {
            textView.setText("_______");
        } else {
            textView.setText(text.toString());
        }
    }

    public int recivedId() {
        int id = 0;
        if (getArguments() != null) {
            id = getArguments().getInt("RequestId");
        }
        return id;
    }
}