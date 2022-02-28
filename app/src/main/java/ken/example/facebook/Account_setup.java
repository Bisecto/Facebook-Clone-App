package ken.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Account_setup extends AppCompatActivity {
    SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;
Button next;
LinearLayout nextlayout,reglayout,save_login;
    Calendar calender = Calendar.getInstance();
EditText text,firstname,lastname,number,pass;
RadioGroup radiogroup;
RadioButton radio1,radio2;
String urfirstname,urlastname,urnumber,urbirthday,urgender,urpassword;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setup);
        next= findViewById(R.id.next);
        nextlayout= findViewById(R.id.nextlayout);
        reglayout= findViewById(R.id.reglayout);
        firstname  = findViewById(R.id.firstname);
        lastname  = findViewById(R.id.lastname);
        number = findViewById(R.id.number);
        pass  = findViewById(R.id.pass);
        save_login = findViewById(R.id.save_login);
        text= findViewById(R.id.text);
        radiogroup= findViewById(R.id.radiogroup);
        radio1= findViewById(R.id.radio1);
        radio2= findViewById(R.id.radio2);
        sharedPreferences= this.getPreferences(this.MODE_PRIVATE);
        editor= sharedPreferences.edit();
        final DatePickerDialog.OnDateSetListener date  = new DatePickerDialog.OnDateSetListener() {
            private  void updateLabel (){
                String myFormat = "MM/dd/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.TRADITIONAL_CHINESE);
                text.setText(sdf.format(calender.getTime()));
            }
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calender.set(Calendar.YEAR,year);
                calender.set(Calendar.MONTH,month);
                calender.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateLabel();
            }
        };
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Account_setup.this, date, calender.get(Calendar.YEAR), calender.get(Calendar.MONTH), calender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.radio1){
                }
                switch (checkedId) {
                    case R.id.radio1:
                        gender = "male";
                        break;
                    case R.id.radio2:
                        gender = "female";
                }
            }
        });
    }

    public void gotoreg(View view) {
        nextlayout.setVisibility(View.GONE);
        reglayout.setVisibility(View.VISIBLE);
    }

    public void regBut(View view) {
        //urgender=radio1.getText().toString();
        //urgender = radio2.getText().toString();

        urfirstname= firstname.getText().toString();
        urlastname= lastname.getText().toString();
        urnumber= number.getText().toString();
        urbirthday= text.getText().toString();
        urpassword= pass.getText().toString();
        if (!urfirstname.trim().equals("")){
           if (!urlastname.trim().equals("")){
                if (!urnumber.trim().equals("")){
                    if (!urbirthday.trim().equals("")){
                        if (!urpassword.trim().equals("")){
                            if (gender !=null) {
                                editor.putString("user_firstname", urfirstname);
                                editor.putString("user_lastname", urlastname);
                                editor.putString("user_number", urnumber);
                                editor.putString("user_birthday", urbirthday);
                                editor.putString("user_password", urpassword);
                                editor.putString("user_gender", gender);
                                editor.commit();
                                Toast.makeText(this, "Successfully Registered", Toast.LENGTH_LONG).show();
                                firstname.setText("");
                                pass.setText("");
                                lastname.setText("");
                                number.setText("");
                                text.setText("");

                                reglayout.setVisibility(View.GONE);
                                save_login.setVisibility(View.VISIBLE);
                            } else {
                                Toast.makeText(Account_setup.this, "Please Check Gender ", Toast.LENGTH_LONG).show();
                            }
                            } else {
                            Toast.makeText(Account_setup.this, "Please Enter A password", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(Account_setup.this, "Please Enter Your Date of Birth", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(Account_setup.this, "Please Enter Your Mobile number", Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(Account_setup.this, "Please Enter Your Last Name", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(Account_setup.this, "Please Enter Your First Name", Toast.LENGTH_LONG).show();
        }

    }

    public void ok(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void not_now(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}