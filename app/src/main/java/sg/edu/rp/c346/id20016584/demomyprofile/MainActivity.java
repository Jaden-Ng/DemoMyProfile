package sg.edu.rp.c346.id20016584.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etName, etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGPA=findViewById(R.id.editTextGPA);
        etName=findViewById(R.id.editTextTextPersonName);

    }

    @Override
    protected void onPause() {
        super.onPause();
        String gpa= etGPA.getText().toString();
        float fgpa=0;
        if(gpa.length()>0){
            fgpa= Float.parseFloat(gpa);
        }

        SharedPreferences prefs= getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEdit= prefs.edit();
        prefsEdit.putString("name", etName.getText().toString());
        prefsEdit.putFloat("gpa", fgpa);
        prefsEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs= getPreferences(MODE_PRIVATE);
        String name= prefs.getString("name", "");
        float gpa= prefs.getFloat("gpa", 0f);
        etName.setText(name);
        etGPA.setText(gpa+"");
    }
}