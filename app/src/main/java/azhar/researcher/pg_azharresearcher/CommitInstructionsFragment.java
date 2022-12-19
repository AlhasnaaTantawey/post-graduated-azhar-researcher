package azhar.researcher.pg_azharresearcher;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pg_azharresearcher.R;
import com.example.pg_azharresearcher.databinding.FragmentCommitInstructionsBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class CommitInstructionsFragment extends Fragment {
    FragmentCommitInstructionsBinding fragmentCommitInstructionsBinding;
    Retrofit retrofit;
    EndPoint endPoint;
    AllDataForCommit allDataForCommit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentCommitInstructionsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_commit_instructions, container, false);
        retrofit = Client.getRetrofit();
        endPoint = retrofit.create(EndPoint.class);
        getInstructionsForCommit();
        return fragmentCommitInstructionsBinding.getRoot();
    }


    public void getInstructionsForCommit() {
        Call<AllDataForCommit> call = endPoint.getInstructionsForCommit();
        call.enqueue(new Callback<AllDataForCommit>() {
            @Override
            public void onResponse(Call<AllDataForCommit> call, Response<AllDataForCommit> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                allDataForCommit = response.body();
                fragmentCommitInstructionsBinding.image.setVisibility(View.VISIBLE);
                handleData(allDataForCommit.getTitle(), fragmentCommitInstructionsBinding.mainTitle);
                handleData("اولا : " + allDataForCommit.getFormationPartOne().getTitle(), fragmentCommitInstructionsBinding.firstSupTitle);
                handleData(getTextFromObject(allDataForCommit.getFormationPartOne().conditions).toString(), fragmentCommitInstructionsBinding.firstRequired);
                handleData("ثانيا : " + allDataForCommit.getFormationPartTwo().getTitle(), fragmentCommitInstructionsBinding.secondtSupTitle);
                handleData(getTextFromObject(allDataForCommit.getFormationPartTwo().conditions,allDataForCommit.getFormationPartTwo().AdditionalInformation).toString(), fragmentCommitInstructionsBinding.secondRequired);
            }

            @Override
            public void onFailure(Call<AllDataForCommit> call, Throwable t) {

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

    public StringBuffer getTextFromObject(ArrayList<Item> list, ArrayList<String> listOfString) {
        StringBuffer totalString = new StringBuffer("");
        for (int i = 0; i < list.size(); i++) {
            if (i == 3) {
                for (int y = 0; y < listOfString.size(); y++) {
                    totalString.append("  " + listOfString.get(y) + "\n");
                }

            } else {
                totalString.append(list.get(i).getNum() + "-" + list.get(i).getText() + "\n");
            }
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