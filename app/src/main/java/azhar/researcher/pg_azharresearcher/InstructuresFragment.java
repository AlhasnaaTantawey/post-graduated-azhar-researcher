package azhar.researcher.pg_azharresearcher;

import static azhar.researcher.pg_azharresearcher.SupervisorsForOneResearcher.goBackToPersonalInformation;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pg_azharresearcher.R;
import com.example.pg_azharresearcher.databinding.FragmentInstructuresBinding;


public class InstructuresFragment extends Fragment {

    FragmentInstructuresBinding fragmentInstructuresBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentInstructuresBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructures, container, false);
        clickOnStruction(fragmentInstructuresBinding.forGrant, new GrantInstructureFragment());
        clickOnStruction(fragmentInstructuresBinding.forEgyption, new InstructuresForEgyptionFragment());
        clickOnStruction(fragmentInstructuresBinding.forCommit, new CommitInstructionsFragment());
        clickOnStruction(fragmentInstructuresBinding.forExternal, new InstructionsForExternalFragment());
        goBackToPersonalInformation(this);

        return fragmentInstructuresBinding.getRoot();
    }

    public void clickOnStruction(TextView textView, Fragment fragment) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(fragment);
            }
        });
    }

    public void setFragment(Fragment fragment) {
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.nav_host_fragment_activity_supervisor, fragment)
                .addToBackStack(null)
                .commit();
    }
}