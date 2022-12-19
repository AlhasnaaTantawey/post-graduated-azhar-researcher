package azhar.researcher.pg_azharresearcher;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;

import com.example.pg_azharresearcher.R;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SplashActivity extends AppCompatActivity {
    Retrofit retrofit;
    EndPoint endPoint;
    public static SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        retrofit = Client.getRetrofit();
        endPoint = retrofit.create(EndPoint.class);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        setLocale(this, "ar");
        makeSplash();
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

    public void makeSplash() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(900);
                    checkLogin();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
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

    //check login by get username and password from sharedPreferences and move to another activity
    public void checkLogin() {
        sharedPreferences = getSharedPreferences("MySharedPrefForResearcher", MODE_PRIVATE);
        try {
            File.createTempFile("usernameAndPassowrdData", null, getBaseContext().getCacheDir());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String usernameValue = sharedPreferences.getString("username", "");
        String passwordValue = sharedPreferences.getString("password", "");
        if (!usernameValue.isEmpty() && !passwordValue.isEmpty()) {
            checkLoginSupervisor(usernameValue, passwordValue);

        } else {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}