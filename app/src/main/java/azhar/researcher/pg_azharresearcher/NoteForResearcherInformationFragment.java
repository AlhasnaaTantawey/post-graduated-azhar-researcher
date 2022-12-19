package azhar.researcher.pg_azharresearcher;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.pg_azharresearcher.R;
import com.example.pg_azharresearcher.databinding.FragmentNoteForResearcherInformationBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NoteForResearcherInformationFragment extends Fragment {
    FragmentNoteForResearcherInformationBinding fragmentNoteForResearcherInformationBinding;
    Note note;
    Retrofit retrofit;
    EndPoint endPoint;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentNoteForResearcherInformationBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_note_for_researcher_information, container, false);
        retrofit=Client.getRetrofit();
        endPoint=retrofit.create(EndPoint.class);
        clickSendNote();
        return fragmentNoteForResearcherInformationBinding.getRoot();
    }
    public void clickSendNote() {
        fragmentNoteForResearcherInformationBinding.buttonNotesFragmentFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlerDialog();
            }
        });
    }

    public void sendNote() {
        note = new Note();
        note.setNote(fragmentNoteForResearcherInformationBinding.edittextNotesFragmentNotes.getText().toString());
        note.setRes_id(ResearcherActivity.ResearcherId);
        note.setDeptId(PersonalInformationForResearcher.researcherModel.getDeptId());
        note.setNoteType(4);
        Call<Note> call = endPoint.sendNotes(note);
        call.enqueue(new Callback<Note>() {
            @Override
            public void onResponse(Call<Note> call, Response<Note> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "فشل فى ارسال الملاحظه ", Toast.LENGTH_LONG).show();
                    return;
                }
                Note note = response.body();

                if (note != null) {
                    Toast.makeText(getContext(), "تم ارسال الملاحظه ", Toast.LENGTH_LONG).show();
                    getActivity().onBackPressed();
                } else {
                    Toast.makeText(getContext(), "فشل فى ارسال الملاحظه ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Note> call, Throwable t) {
                Toast.makeText(getContext(), "فشل فى ارسال الملاحظه ", Toast.LENGTH_LONG).show();
            }
        });

    }

    // make alerDialog
    public void setAlerDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                .setTitle("تسجيل الملاحظه")
                .setMessage("هل تريد تسجيل الملاحظه؟")
                .setCancelable(false)
                .setPositiveButton(" نعم ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sendNote();

                    }
                }).setNegativeButton("لا", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}