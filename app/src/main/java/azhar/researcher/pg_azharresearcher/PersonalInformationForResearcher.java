package azhar.researcher.pg_azharresearcher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.pg_azharresearcher.R;
import com.example.pg_azharresearcher.databinding.FragmentPersonalInformationForResearcherBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PersonalInformationForResearcher extends Fragment {

    FragmentPersonalInformationForResearcherBinding binding;
    Retrofit retrofit;
    EndPoint endPoint;
    public static ResearcherModel researcherModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_personal_information_for_researcher, container, false);
        retrofit = Client.getRetrofit();
        endPoint = retrofit.create(EndPoint.class);
        getResearcher(ResearcherActivity.ResearcherId);
        floatingNoteButton();
        clickBackFromPersonalInformation();
        return binding.getRoot();

    }

    public void getResearcher(int id) {
        Call<ResearcherModel> call = endPoint.getOneResearcher(id);
        call.enqueue(new Callback<ResearcherModel>() {
            @Override
            public void onResponse(Call<ResearcherModel> call, Response<ResearcherModel> response) {
                if (!response.isSuccessful()) {
                    return;
                }

                ResearcherModel researcher = response.body();
                researcherModel=researcher;
                handleData(researcher.getArabicName(), binding.personalInformationForResearcherTextViewNameValue);
               binding.textViewIdValue.setText(researcher.getId()+"");
                handleData(researcher.getCurrentPlace(), binding.personalInformationforResearcherTextViewAddressValue);
                handleData(researcher.getNationalID(), binding.personalInformationForResearchertextViewSsnValue);
                handleData(researcher.getRegsitretion_Period(), binding.personalInformationforResearcherTextViewRegisterdateValue);
                handleData(researcher.getSpecialization(), binding.personalInformationforResearcherTextViewSpecialityValue);
                handleData(researcher.getMsgArAddress(), binding.personalInformationforResearcherTextViewMsAddressValue);
                handleData(researcher.getDepartment(), binding.personalInformationforResearcherTextViewDepartmentValue);
                handleData(researcher.getMobaile(), binding.personalInformationforResearcherTextViewPhoneValue);
                handleData(researcher.getDegree(), binding.personalInformationforResearcherTextViewDegreeValue);
                handleData(researcher.getQualUnivesity(), binding.personalInformationForResearcherTextViewIsExternalValue);
                if (researcher.getIsGranted() == -1) {
                    binding.personalInformationforResearcherTextViewGrantedValue.setText("منح");
                } else if (researcher.getIsGranted() == 0) {
                    binding.personalInformationforResearcherTextViewGrantedValue.setText("مستمر");

                }
            }

            @Override
            public void onFailure(Call<ResearcherModel> call, Throwable t) {
            }
        });
    }


    private void setFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment_activity_supervisor, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    public void handleData(String text, TextView textView) {
        if (text == null) {
            textView.setText("_______");
        } else {
            textView.setText(text.toString());
        }
    }

    public void clickBackFromPersonalInformation() {
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().finish();
            }
        });
    }

    public void floatingNoteButton() {
        binding.personalInformationForResearcherFloatingButtonNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new NoteForResearcherInformationFragment());
            }
        });
    }
}
