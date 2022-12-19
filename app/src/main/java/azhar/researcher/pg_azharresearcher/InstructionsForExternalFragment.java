package azhar.researcher.pg_azharresearcher;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pg_azharresearcher.R;
import com.example.pg_azharresearcher.databinding.FragmentInsturctionsForExternalBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class InstructionsForExternalFragment extends Fragment {
Retrofit retrofit;
EndPoint endPoint;
AllDataForExternalInstructions allDataForExternalInstructions;
FragmentInsturctionsForExternalBinding fragmentInsturctionsForExternalBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentInsturctionsForExternalBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_insturctions_for_external, container, false);
        retrofit=Client.getRetrofit();
        endPoint=retrofit.create(EndPoint.class);
        getInstructionsForExternal();
        return fragmentInsturctionsForExternalBinding.getRoot();
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
public void getInstructionsForExternal(){
        Call<AllDataForExternalInstructions> call=endPoint.getInstructionsForExternal();
        call.enqueue(new Callback<AllDataForExternalInstructions>() {
            @Override
            public void onResponse(Call<AllDataForExternalInstructions> call, Response<AllDataForExternalInstructions> response) {
                if(!response.isSuccessful()){
                    return;
                }
                allDataForExternalInstructions=response.body();
                 fragmentInsturctionsForExternalBinding.line.setVisibility(View.VISIBLE);
                 fragmentInsturctionsForExternalBinding.image.setVisibility(View.VISIBLE);
                handleData(allDataForExternalInstructions.getTitle(), fragmentInsturctionsForExternalBinding.mainTitle);
                handleData("اولا : "+allDataForExternalInstructions.getPartOne().getTitle(),fragmentInsturctionsForExternalBinding.firstSupTitle);
                handleData(getTextFromArrayOfString(allDataForExternalInstructions.getPartOne().getRegistration_Terms()).toString(),fragmentInsturctionsForExternalBinding.firstRequired);
                handleData("ثانيا : "+allDataForExternalInstructions.getPartTwo().getTitle(),fragmentInsturctionsForExternalBinding.secondtSupTitle);
                handleData(getTextFromObject(allDataForExternalInstructions.getPartTwo().getRegistrationFiles()).toString(),fragmentInsturctionsForExternalBinding.secondRequired);
                handleData(allDataForExternalInstructions.getPartThree().getTitle(),fragmentInsturctionsForExternalBinding.thirdSupTitle);
                handleData(getTextFromObject(allDataForExternalInstructions.getPartThree().getFees()).toString(),fragmentInsturctionsForExternalBinding.thirdRequired);
                handleData("-"+allDataForExternalInstructions.getPartThree().getAdditionalInformation().get(0)+"\n"+"-"+allDataForExternalInstructions.getPartThree().additionalInformation.get(1),fragmentInsturctionsForExternalBinding.mountofMoney);
                handleData(allDataForExternalInstructions.getPartThree().getAdditionalInformation().get(2),fragmentInsturctionsForExternalBinding.palastin);

            }

            @Override
            public void onFailure(Call<AllDataForExternalInstructions> call, Throwable t) {

            }
        });
}
    public StringBuffer getTextFromArrayOfString(ArrayList<String> list){
        StringBuffer totalString=new StringBuffer("");
        for(int i=0;i<list.size();i++){
            if(i==0){
                totalString.append(list.get(i)+"\n");
            }else
            totalString.append("- "+list.get(i)+"\n");
        }
        return totalString;
    }
}