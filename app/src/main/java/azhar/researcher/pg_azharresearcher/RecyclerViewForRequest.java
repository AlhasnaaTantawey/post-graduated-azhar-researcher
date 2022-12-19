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
import com.example.pg_azharresearcher.databinding.RequestGroupViewBinding;

import java.util.ArrayList;

public class RecyclerViewForRequest extends RecyclerView.Adapter<RecyclerViewForRequest.ViewHolder> {
    ArrayList<RecievedRequestModel> data;
RequestsFromSupervisors requestsFromSupervisors;

    public RecyclerViewForRequest(ArrayList<RecievedRequestModel> data,RequestsFromSupervisors requestsFromSupervisors) {
        this.data = data;
       this . requestsFromSupervisors=requestsFromSupervisors;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RequestGroupViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.request_group_view, parent, false);
        ViewHolder holder = new ViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            holder.binding.RequestGroupViewTxtvName.setText(data.get(position).getSupervisorName());

        if (data.get(position).getType() == 1) {
            holder.binding.RequestGroupViewImage.setImageResource(R.drawable.expanddate);
            holder.binding.RequestGroupViewTxtvSub.setText("طلب مد");
        } else if (data.get(position).getType() == 2) {
            holder.binding.RequestGroupViewTxtvSub.setText("طلب تغير مشرفين");
            holder.binding.RequestGroupViewImage.setImageResource(R.drawable.exchange_supervisor);
        } else if (data.get(position).getType() == 3) {
            holder.binding.RequestGroupViewTxtvSub.setText("طلب تغير عنوان");
            holder.binding.RequestGroupViewImage.setImageResource(R.drawable.exchange_title);
        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        RequestGroupViewBinding binding;

        public ViewHolder(@NonNull RequestGroupViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (data.get(getAdapterPosition()).getType() == 1) {
                       setFragment(requestsFromSupervisors,new ExtendRequestDetails(),R.id.nav_host_fragment_activity_supervisor);
                    } else if (data.get(getAdapterPosition()).getType() == 2) {
                        setFragment(requestsFromSupervisors,new ChangeSupervisorRequestDetails(),R.id.nav_host_fragment_activity_supervisor);

                    } else if (data.get(getAdapterPosition()).getType() == 3) {
                        setFragment(requestsFromSupervisors,new ChangeTitleRequestDetails(),R.id.nav_host_fragment_activity_supervisor);

                    }


                }
            });
        }

        // begin fragment
        public void setFragment(Fragment parent, Fragment fragment, int id) {
            sendId(fragment);
            parent.getParentFragmentManager()
                    .beginTransaction()
                    .replace(id, fragment)
                    .addToBackStack(null)
                    .commit();
        }

        //send research Id for personalInformationForOneResearcherFragment
        public void sendId(Fragment fragment) {
            Bundle bundle = new Bundle();
            bundle.putInt("RequestId", data.get(getAdapterPosition()).getOrder_id());
            fragment.setArguments(bundle);
        }
    }
}
