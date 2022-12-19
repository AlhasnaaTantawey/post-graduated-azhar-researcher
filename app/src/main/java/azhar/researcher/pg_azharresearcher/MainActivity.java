package azhar.researcher.pg_azharresearcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.pg_azharresearcher.R;
import com.example.pg_azharresearcher.databinding.ActivityMainBinding;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    EndPoint endPoint;
    Retrofit retrofit;


    @Override
    protected void onPause() {
        super.onPause();
        saveUsernameAndPassword();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        retrofit = Client.getRetrofit();
        endPoint = retrofit.create(EndPoint.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setLocale(this, "ar");
        getSupportActionBar().hide();

        touchListenerPassword();
        touchListenerUsername();
    }

    //show message to write username and password if not exist
    public void checkUsernameAndPassowrd() {
        String username = binding.editTextUsername.getText().toString().trim();
        String password = binding.editTextPassword.getText().toString().trim();

        if (username.isEmpty() && password.isEmpty()) {
            binding.textviewUsernameIsEmpty.setVisibility(View.VISIBLE);
            binding.textViewPasswordIsEmpty.setVisibility(View.VISIBLE);
        } else if (username.isEmpty() && !password.isEmpty()) {
            binding.textviewUsernameIsEmpty.setVisibility(View.VISIBLE);
            binding.textViewPasswordIsEmpty.setVisibility(View.INVISIBLE);
        } else if (!username.isEmpty() && password.isEmpty()) {
            binding.textviewUsernameIsEmpty.setVisibility(View.INVISIBLE);
            binding.textViewPasswordIsEmpty.setVisibility(View.VISIBLE);
        } else if (!username.isEmpty() && !password.isEmpty()) {
            checkLoginSupervisor(username, password);
        }
    }

    // make textviewUsernameISEmpty INVISABLE when user write text in editTextUsername
    public void touchListenerUsername() {
        binding.editTextUsername.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                binding.textviewUsernameIsEmpty.setVisibility(View.INVISIBLE);
                return false;
            }
        });
    }

    // make textviewPassowrdISEmpty INVISABLE when user write text in editTextpassword
    public void touchListenerPassword() {
        binding.editTextPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                binding.textViewPasswordIsEmpty.setVisibility(View.INVISIBLE);
                return false;
            }
        });
    }

    //OnClick for login Button
    public void loginAction(View view) {
        checkUsernameAndPassowrd();
    }

    //get username and password from API and compare between current username and password also send id to ResearcherActivity
    public void checkLoginSupervisor(String userName, String password) {
        Call<ResearcherModel> call = endPoint.getResearcherByUsernameAndPassword(userName, password);
        call.enqueue(new Callback<ResearcherModel>() {
            @Override
            public void onResponse(Call<ResearcherModel> call, Response<ResearcherModel> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "ادخل البيانات بشكل صحيح", Toast.LENGTH_SHORT).show();
                    return;
                }
                ResearcherModel researcherModel = response.body();

                int id = researcherModel.getId();
                Intent intent = new Intent(getApplicationContext(), ResearcherActivity.class);
                intent.putExtra("ResearcherId", researcherModel.getId());
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(Call<ResearcherModel> call, Throwable t) {
            }
        });
    }


    // set specific language (arabic)
    public static void setLocale(Activity activity, String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }

    //strore username and password in sharedPreferences
    public void saveUsernameAndPassword() {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPrefForResearcher", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("username", binding.editTextUsername.getText().toString().trim());
        myEdit.putString("password", binding.editTextPassword.getText().toString().trim());
        myEdit.apply();
    }
}
