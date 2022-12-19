package azhar.researcher.pg_azharresearcher;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pg_azharresearcher.R;
import com.example.pg_azharresearcher.databinding.FragmentGrantInstructureBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class GrantInstructureFragment extends Fragment {

    FragmentGrantInstructureBinding fragmentGrantInstructureBinding;
    AllDataForGrantInstructions allDataForGrantInstructions;
    Retrofit retrofit;
    EndPoint endPoint;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentGrantInstructureBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_grant_instructure, container, false);
        retrofit = Client.getRetrofit();
        endPoint = retrofit.create(EndPoint.class);
        getInstrutionsForGrant();
        return fragmentGrantInstructureBinding.getRoot();
    }

    public void getInstrutionsForGrant() {
        Call<AllDataForGrantInstructions> call = endPoint.getInstructionsForGrant();
        call.enqueue(new Callback<AllDataForGrantInstructions>() {
            @Override
            public void onResponse(Call<AllDataForGrantInstructions> call, Response<AllDataForGrantInstructions> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                allDataForGrantInstructions = response.body();
                fragmentGrantInstructureBinding.image.setVisibility(View.VISIBLE);
                handleData(allDataForGrantInstructions.getTitle(), fragmentGrantInstructureBinding.mainTitle);
                handleData("اولا : "+allDataForGrantInstructions.getGrantedPartOne().getTitle(),fragmentGrantInstructureBinding.firstSupTitle);
                handleData(getTextFromObject(allDataForGrantInstructions.getGrantedPartOne().conditions).toString(),fragmentGrantInstructureBinding.firstRequired);
                handleData("ثانيا : "+allDataForGrantInstructions.getGrantedPartTwo().getTitle(),fragmentGrantInstructureBinding.secondtSupTitle);
                handleData(getTextFromObject(allDataForGrantInstructions.getGrantedPartTwo().conditions).toString(),fragmentGrantInstructureBinding.secondRequired);

            }

            @Override
            public void onFailure(Call<AllDataForGrantInstructions> call, Throwable t) {

            }
        });
    }
    public StringBuffer getTextFromObject(ArrayList<Item> list){
        StringBuffer totalString=new StringBuffer("");
        for(int i=0;i<list.size();i++){
            totalString.append(list.get(i).getNum()+"-"+list.get(i).getText()+"\n");
        }
        return totalString;
    }



    public void handleData(String text, TextView textView) {
        if (text == null) {
            textView.setText("_______");
        } else {
            textView.setText(text.toString());
        }
    }
}