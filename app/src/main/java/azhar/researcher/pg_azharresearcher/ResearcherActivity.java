package azhar.researcher.pg_azharresearcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.pg_azharresearcher.R;
import com.example.pg_azharresearcher.databinding.ActivityResearcherBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ResearcherActivity extends AppCompatActivity {
ActivityResearcherBinding activityResearcherBinding;
public static int ResearcherId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.setLocale(this, "ar");;
        getSupportActionBar().setTitle("الدراسات العليا");
        activityResearcherBinding= DataBindingUtil.setContentView(this, R.layout.activity_researcher);
        activityResearcherBinding.navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        revieveData();

    }

    BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_Personal_data:
                  setFragment(new PersonalInformationForResearcher());
                    return true;
                case R.id.navigation_supervisors:
                    setFragment(new SupervisorsForOneResearcher());
                 return true;
                case R.id.navigation_instructions:
                    setFragment(new InstructuresFragment());
            }
            return false;
        }
    };

    //recieve id form MainActivity
    public void revieveData() {
        ResearcherId = getIntent().getIntExtra("ResearcherId", 0);
    }

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.nav_host_fragment_activity_supervisor, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.toolbar_menu_logout:
                setAlerDialog();
                return true;
            case R.id.toolbar_menu_changeInformation:
              Intent intent=new Intent(ResearcherActivity.this,ChangeInformation.class);
              intent.putExtra("ResearcherId",ResearcherId);
              startActivity(intent);

            default:
                return true;
        }
    }
    // make alerDialog and logout
    public void setAlerDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("تسجيل الخروج")
                .setMessage("هل تريد تسجيل الخروج؟")
                .setCancelable(false)
                .setPositiveButton(" نعم ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SplashActivity.sharedPreferences.edit().clear().commit();
                        Intent intent=new Intent(ResearcherActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
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