package ken.example.facebook;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button english, forgot,log_in, account, hausa,espanol, francais, postogues, more, hide, show;
TextView mobile, pasword, or;
EditText password,number;
    SharedPreferences sharedPreferences;
   // SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        english = findViewById(R.id.english);
        mobile = findViewById(R.id.mobile);
        pasword = findViewById(R.id.pasword);
        forgot = findViewById(R.id.forgot);
        log_in = findViewById(R.id.log_in);
        number = findViewById(R.id.number);
        or = findViewById(R.id.or);
        espanol = findViewById(R.id.espanol);
        account = findViewById(R.id.account);
        hausa = findViewById(R.id.hausa);
        francais= findViewById(R.id.francais);
       postogues= findViewById(R.id.portugues);
       more = findViewById(R.id.more);
       password = findViewById(R.id.password);
       hide = findViewById(R.id.hide);
       show = findViewById(R.id.show);
        //sharedPreferences= this.getPreferences(this.MODE_PRIVATE);
        sharedPreferences= this.getPreferences(Account_setup.MODE_PRIVATE);
        //editor= sharedPreferences.edit();

    }

    public void Homepage(View view) {
        if(number.getText().toString().trim().equals("") || password.getText().toString().trim().equals("") ) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setCancelable(true);
            dialog.setTitle("Please Enter Your Login Info");
            dialog.setMessage("To log in, enter your password and number.");
            dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            final AlertDialog alert = dialog.create();
            alert.show();
        } else  {
            String first = sharedPreferences.getString("user_firstname", "");
            String last = sharedPreferences.getString("user_lastname", "");
            String num = sharedPreferences.getString("user_number", "");
            String birth = sharedPreferences.getString("user_birthday", "");
            String gend = sharedPreferences.getString("user_gender", "");
            String passwo =sharedPreferences.getString("user_password", "");

            if (number.getText().toString().equals(num) && password.getText().toString().equals(passwo)) {
                Intent intent = new Intent(MainActivity.this, HomePage.class);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this,"Invalid password or username",Toast.LENGTH_LONG).show();

            }
        }

        
    }

    public void english(View view) {
        mobile.setText("Mobile number or email");
        pasword.setText("password");
        log_in.setText("Log in");
        forgot.setText("Forgot Password?");
        or.setText("__________________or____________________");
        account.setText("Create New Account");
        english.setTextColor(Color.rgb(0,0,0));
        hausa.setTextColor(Color.rgb(24,119,242));
        espanol.setTextColor(Color.rgb(24,119,242));
        francais.setTextColor(Color.rgb(24,119,242));
        postogues.setTextColor(Color.rgb(24,119,242));
        more.setText("More Languages...");
        more.setTextColor(Color.rgb(24,119,242));
    }

    public void Hausa(View view) {
        mobile.setText("Lambar waya ko adireshin imel");
        pasword.setText("Kalmar sirri");
        log_in.setText("shiga Ciki");
        forgot.setText("ka manta Kalmar Sirri?");
        or.setText("__________________ko____________________");
        account.setText("Kirkiri Sabon Asusu");
        english.setTextColor(Color.rgb(24,119,242));
        hausa.setTextColor(Color.rgb(0,0,0));
        espanol.setTextColor(Color.rgb(24,119,242));
        francais.setTextColor(Color.rgb(24,119,242));
        postogues.setTextColor(Color.rgb(24,119,242));
        more.setText("Karin wasu Harsuna...");
        more.setTextColor(Color.rgb(24,119,242));

    }

    public void espanol(View view) {
        mobile.setText("Numero de celular o correo electronico");
        pasword.setText("Contrasena");
        log_in.setText("Iniciar sesion");
        forgot.setText("Olvidaste tu contrasena?");
        or.setText("__________________o____________________");
        account.setText("Crear cuenta nueva");
        english.setTextColor(Color.rgb(24,119,242));
        hausa.setTextColor(Color.rgb(24,119,242));
        espanol.setTextColor(Color.rgb(0,0,0));
        francais.setTextColor(Color.rgb(24,119,242));
        postogues.setTextColor(Color.rgb(24,119,242));
        more.setText("Mas idiomas...");
        more.setTextColor(Color.rgb(24,119,242));
    }

    public void francais(View view) {
        mobile.setText("Numero de mobile ou e-mail");
        pasword.setText("Mot de passe");
        log_in.setText("Connexion");
        forgot.setText("Mot de passe oublie?");
        or.setText("__________________ou____________________");
        account.setText("Creer un compte");
        english.setTextColor(Color.rgb(24,119,242));
        hausa.setTextColor(Color.rgb(24,119,242));
        espanol.setTextColor(Color.rgb(24,119,242));
        francais.setTextColor(Color.rgb(0,0,0));
        postogues.setTextColor(Color.rgb(24,119,242));
        more.setText("Aytres lanques...");
        more.setTextColor(Color.rgb(24,119,242));
    }

    public void portugues(View view) {
        mobile.setText("Numero de cellular ou email");
        pasword.setText("senha");
        log_in.setText("Entrar");
        forgot.setText("Esqueceu a senha?");
        or.setText("__________________ou____________________");
        account.setText("criar nova conta");
        english.setTextColor(Color.rgb(24,119,242));
        hausa.setTextColor(Color.rgb(24,119,242));
        espanol.setTextColor(Color.rgb(24,119,242));
        francais.setTextColor(Color.rgb(24,119,242));
        postogues.setTextColor(Color.rgb(0,0,0));
        more.setText("Mais idiomas...");
        more.setTextColor(Color.rgb(24,119,242));
    }

    public void hide(View view) {
        show.setVisibility(View.VISIBLE);
        hide.setVisibility(View.GONE);
        password.setTransformationMethod(null);



    }

    public void show(View view) {
        show.setVisibility(View.GONE);
        hide.setVisibility(View.VISIBLE);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder backPress = new AlertDialog.Builder(MainActivity.this);
        backPress.setCancelable(true);
        backPress.setTitle("Exit Confirmation");
        backPress.setMessage("Are you sure you want to exit");
        backPress.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);

            }
        });
        backPress.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        final AlertDialog alert =backPress.create();
        alert.show();
        // super.onBackPressed();
    }

    public void account(View view) {
        Intent i = new Intent(this,Account_setup.class);
        startActivity(i);
    }
}