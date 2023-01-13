package com.seeksolution.validregistrationintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity2 extends AppCompatActivity {

    private EditText et_email,et_password;
    private TextView error_email, error_password;
    private  String email,password;
    public static final Pattern EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
    public static final Pattern PASSWORD_ADDRESS_REGEX = Pattern.compile("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et_email=(EditText) findViewById(R.id.et_email);
        et_password=(EditText) findViewById(R.id.et_password);
        error_email=(TextView) findViewById(R.id.error_email);
        error_password=(TextView) findViewById(R.id.error_password);

    }

    public void login (View view){
        email=et_email.getText().toString();
        password=et_password.getText().toString();
        //  validation for email
        //  validation for password
//        validateEmail(email);
//        validatePassword(password);
        if(validateEmail(email) | validatePassword(password)){

            //Toast.makeText(this, ""+email+password, Toast.LENGTH_SHORT).show();
            if (email.equals("admin@gmail.com") && password.equals("Password@123")){
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
                et_password.setBackgroundResource(R.drawable.success_layout);
                et_email.setBackgroundResource(R.drawable.success_layout);

                Intent intent=new Intent(MainActivity2.this,Dashboard.class);
                startActivity(intent);

            }
            else {
                et_email.setBackgroundResource(R.drawable.error);
                et_password.setBackgroundResource(R.drawable.error);
                Toast.makeText(this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
            }
        }


    }

    private boolean validateEmail( String email) {
        if (email.isEmpty()) {
            error_email.setText("Email Field is Required");
            et_email.setBackgroundResource(R.drawable.error);
            return false;
        }
        if (!EMAIL_ADDRESS_REGEX.matcher(email).matches()) {
            error_email.setText("Invalid Email");
            et_email.setBackgroundResource(R.drawable.error);

            return false;
        }
        et_email.setBackgroundResource(R.drawable.success_layout);
        error_email.setText("");
        return true;
    }

    private  boolean validatePassword(String password){

        if (password.isEmpty()){
            error_password.setText("Password field is Required");
            et_password.setBackgroundResource(R.drawable.error);
            return false;
        }
        if (!PASSWORD_ADDRESS_REGEX.matcher(password).matches()){
            error_password.setText("Password must occur one (A-Z)capital,one(0-9) number and one symbol");
            et_password.setBackgroundResource(R.drawable.error);
            return false;
        }
        et_password.setBackgroundResource(R.drawable.success_layout);
        error_password.setText("");
        return true;
    }


    public void click(View view) {
        Intent intent =new Intent(MainActivity2.this,Registration.class);
        startActivity(intent);
    }
}