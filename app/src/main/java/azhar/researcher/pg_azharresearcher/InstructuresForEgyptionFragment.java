package azhar.researcher.pg_azharresearcher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.pg_azharresearcher.R;
import com.example.pg_azharresearcher.databinding.FragmentInstructuresForEgyptionBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class InstructuresForEgyptionFragment extends Fragment {

   FragmentInstructuresForEgyptionBinding fragmentInstructuresForEgyptionBinding;
   AllDataForEgyptionInstructions allDataForEgyptionInstructions;
   Retrofit retrofit;
   EndPoint endPoint;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentInstructuresForEgyptionBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_instructures_for_egyption, container, false);
        retrofit=Client.getRetrofit();
        endPoint=retrofit.create(EndPoint.class);
        getInstructionsForEgyptions();
        return fragmentInstructuresForEgyptionBinding.getRoot();
    }
    public void getInstructionsForEgyptions(){
        Call<AllDataForEgyptionInstructions> call=endPoint.getInstructionsForEgyptions();
        call.enqueue(new Callback<AllDataForEgyptionInstructions>() {
            @Override
            public void onResponse(Call<AllDataForEgyptionInstructions> call, Response<AllDataForEgyptionInstructions> response) {
                if(!response.isSuccessful()){
                    return;
                }
                allDataForEgyptionInstructions=response.body();
                  fragmentInstructuresForEgyptionBinding.line1.setVisibility(View.VISIBLE);
                  fragmentInstructuresForEgyptionBinding.line2.setVisibility(View.VISIBLE);
                handleData(allDataForEgyptionInstructions.getEgyptianPartOne().getTitle(),fragmentInstructuresForEgyptionBinding.mainTitle);
                handleData("-"+allDataForEgyptionInstructions.getEgyptianPartOne().getRegistration().get(0)+"\n"+"-"+allDataForEgyptionInstructions.getEgyptianPartOne().getRegistration().get(1),fragmentInstructuresForEgyptionBinding.firstNote);
                handleData(allDataForEgyptionInstructions.getEgyptianPartTwo().getTitle(),fragmentInstructuresForEgyptionBinding.firstSupTitle);
                handleData(allDataForEgyptionInstructions.getEgyptianPartTwo().getAdditionalInformation().get(0)+"\n"+"*"+allDataForEgyptionInstructions.getEgyptianPartTwo().getAdditionalInformation().get(1),fragmentInstructuresForEgyptionBinding.secondNote);
                handleData(getTextFromObject(allDataForEgyptionInstructions.getEgyptianPartTwo().getConditions()).toString(),fragmentInstructuresForEgyptionBinding.firstRequired);
                handleData("*"+allDataForEgyptionInstructions.getEgyptianPartTwo().getAdditionalInformation().get(2)+"\n"+"*"+allDataForEgyptionInstructions.getEgyptianPartTwo().getAdditionalInformation().get(3),fragmentInstructuresForEgyptionBinding.thirdNote);

                handleData(allDataForEgyptionInstructions.getEgyptianPartThree().getTitle(),fragmentInstructuresForEgyptionBinding.firstSupTitlePartTwo);
                handleData(allDataForEgyptionInstructions.getEgyptianPartThree().getAdditionalInformation().get(2)+"\n"+"*"+allDataForEgyptionInstructions.getEgyptianPartThree().getAdditionalInformation().get(3),fragmentInstructuresForEgyptionBinding.secondNotePartTwo);
                handleData(getTextFromObject(allDataForEgyptionInstructions.getEgyptianPartThree().getConditions()).toString(),fragmentInstructuresForEgyptionBinding.firstRequiredPartTwo);
                handleData("*"+allDataForEgyptionInstructions.getEgyptianPartThree().getAdditionalInformation().get(0)+"\n"+"*"+allDataForEgyptionInstructions.getEgyptianPartThree().getAdditionalInformation().get(1),fragmentInstructuresForEgyptionBinding.thirdNotePartTwo);
                fragmentInstructuresForEgyptionBinding.finalNote.setVisibility(View.VISIBLE);
                handleData("*"+allDataForEgyptionInstructions.getEgyptianPartOne().getRegistration().get(2)+"\n"+"*"+allDataForEgyptionInstructions.getEgyptianPartOne().getRegistration().get(3),fragmentInstructuresForEgyptionBinding.finalNote);
            }

            @Override
            public void onFailure(Call<AllDataForEgyptionInstructions> call, Throwable t) {

            }
        });
    }
    public StringBuffer getTextFromObject(ArrayList<Item> list) {
        StringBuffer totalString = new StringBuffer("");
        for (int i = 0; i < list.size(); i++) {
            totalString.append(list.get(i).getNum() + "-" + list.get(i).getText() + "\n");
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

    public StringBuffer getTextFromArrayOfString(ArrayList<String> list){
        StringBuffer totalString=new StringBuffer("");
        for(int i=0;i<list.size();i++){

                totalString.append("- "+list.get(i)+"\n");
        }
        return totalString;
    }
}