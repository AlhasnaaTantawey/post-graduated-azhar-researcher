package azhar.researcher.pg_azharresearcher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pg_azharresearcher.R;
import com.example.pg_azharresearcher.databinding.SupervisorGroupViewBinding;

import java.util.ArrayList;

public class RecyclerViewForSupervisor extends RecyclerView.Adapter<RecyclerViewForSupervisor.ViewHolder> {


    ArrayList<SupervisorModel> data;
    SupervisorsForOneResearcher supervisorsForOneResearcher;
    RequestAndReportFromSupervisors requestAndReportFromSupervisors;

    public RecyclerViewForSupervisor(ArrayList<SupervisorModel> data,SupervisorsForOneResearcher supervisorsForOneResearcher) {
        this.data = data;
        this.supervisorsForOneResearcher=supervisorsForOneResearcher;
        requestAndReportFromSupervisors=new RequestAndReportFromSupervisors();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SupervisorGroupViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.supervisor_group_view, parent, false);
        ViewHolder holder = new ViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {
        holder.binding.supervisorGroupViewTxtvName.setText(data.get(position).getName());
        holder.binding.supervisorGroupViewTxtvSub.setText(data.get(position).getDegname());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        SupervisorGroupViewBinding binding;

        public ViewHolder(@NonNull SupervisorGroupViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sendId(data.get(getAdapterPosition()).getId());
                    setFragment(requestAndReportFromSupervisors);
                }
            });

        }}
        public void setFragment(Fragment fragment){

            supervisorsForOneResearcher
                    .getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment_activity_supervisor,fragment)
                    .addToBackStack(null)
                    .commit();
        }

    //send supervisors Id for NoteFragmentForSupervisors
    public void sendId(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt("SupervisorID", id);
        requestAndReportFromSupervisors.setArguments(bundle);
    }
    }
