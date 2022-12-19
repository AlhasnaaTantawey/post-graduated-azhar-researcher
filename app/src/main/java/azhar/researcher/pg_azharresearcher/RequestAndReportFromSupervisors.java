package azhar.researcher.pg_azharresearcher;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pg_azharresearcher.R;
import com.example.pg_azharresearcher.databinding.FragmentRequestAndReportFromSupervisorsBinding;


public class RequestAndReportFromSupervisors extends Fragment {

    FragmentRequestAndReportFromSupervisorsBinding fragmentRequestAndReportFromSupervisorsBinding;
    NoteFragmentForSupervisors noteFragmentForSupervisors;
    ReportsFromSupervisors reportsFromSupervisors;
    RequestsFromSupervisors requestsFromSupervisors;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentRequestAndReportFromSupervisorsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_request_and_report_from_supervisors, container, false);
        noteFragmentForSupervisors = new NoteFragmentForSupervisors();
        reportsFromSupervisors=new ReportsFromSupervisors();
        requestsFromSupervisors=new RequestsFromSupervisors();
        clickFloatingButton();
        clickOnStruction(fragmentRequestAndReportFromSupervisorsBinding.reports, reportsFromSupervisors);
        clickOnStruction(fragmentRequestAndReportFromSupervisorsBinding.requests, requestsFromSupervisors);
        return fragmentRequestAndReportFromSupervisorsBinding.getRoot();
    }


    public void clickFloatingButton() {
        fragmentRequestAndReportFromSupervisorsBinding.floatingButtonNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendId(recieveSuperviosrId(),noteFragmentForSupervisors);
                setFragment(noteFragmentForSupervisors);
            }
        });
    }

    public void clickOnStruction(TextView textView, Fragment fragment) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendId(recieveSuperviosrId(),fragment);
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

    //send supervisors Id
    public void sendId(int id,Fragment fragment) {
        Bundle bundle = new Bundle();
        bundle.putInt("SupervisorID", id);
        fragment.setArguments(bundle);
    }


    public int recieveSuperviosrId() {
        int id = 0;
        if (getArguments() != null) {
            id = getArguments().getInt("SupervisorID");
        }
        android.util.Log.i("islam", id + "     +islm");

        return id;
    }
}