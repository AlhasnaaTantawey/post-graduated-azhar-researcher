package azhar.researcher.pg_azharresearcher;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pg_azharresearcher.R;
import com.example.pg_azharresearcher.databinding.FragmentOneSupervisorForResearcherBinding;


public class OneSupervisorForResearcher extends Fragment {
FragmentOneSupervisorForResearcherBinding fragmentOneSupervisorForResearcherBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentOneSupervisorForResearcherBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_one_supervisor_for_researcher, container, false);
        floatingNoteButton();

        return fragmentOneSupervisorForResearcherBinding.getRoot();
    }
    public void floatingNoteButton() {
        fragmentOneSupervisorForResearcherBinding.personalInformationForResearcherFloatingButtonNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new NoteFragmentForSupervisors());
            }
        });
    }
    public  void setFragment(Fragment fragment){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment_activity_supervisor, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}