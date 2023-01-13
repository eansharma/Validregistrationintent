package com.seeksolution.validregistrationintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {
    private EditText edit_text1,edit_text2,edit_text3,edit_text4,edit_text5;
    private TextView  textview1,textview2,textview3,textview4,textview5,txtView_city;
    private String email ,pass ,mobile ,name,address, city;
    private RadioGroup radioGroup;
    private String gender="";
    private RadioButton clickedRadioButton;
    private TextView gender_error_1;
    private AutoCompleteTextView auto_city_list;
    ArrayList<String> citydata = new ArrayList<>();
    ArrayAdapter<String> cityAdopter;





    public static final Pattern EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
    public static final Pattern PASSWORD_ADDRESS_REGEX  = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*]).{8,}$");
    public static final Pattern MOBILE_ADDRESS_REGEX  =Pattern.compile("^(\\+?\\d{1,4}[\\s-])?(?!0+\\s+,?$)\\d{10}\\s*,?$");
    public static final Pattern NAME_ADDRESS_REGEX= Pattern.compile("^[a-zA-Z\\s]+$") ;
    public static final Pattern ADDRESS_REGEX  = Pattern.compile("^[#.0-9a-zA-Z\\s,-]+$");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();
        radioGroup= (RadioGroup) findViewById(R.id.r_Gender);
        gender_error_1=(TextView) findViewById(R.id.gender_error);
        auto_city_list =(AutoCompleteTextView) findViewById(R.id.auto_city_list);

        citydata.add("Lucknow");
        citydata.add("kanpur");
        citydata.add("kanpur Dehat");
        citydata.add("Basti");
        citydata.add("Delhi");
        citydata.add("New Delhi");
        citydata.add("Hyderabad");
        citydata.add("Mirzapur");
        citydata.add("Sitapur");
        citydata.add("Gorakhpur");
        citydata.add("Banda");
        citydata.add("Mahoba");
        citydata.add("Bnada Up");
        citydata.add("Agra");
        citydata.add("Barabanki");

        ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(this, R.layout.mycoustom_layout,R.id.city_list_textView_id,citydata);
        auto_city_list.setAdapter(cityAdapter);

        edit_text1=(EditText) findViewById(R.id.edit_text_1);
        edit_text2=(EditText) findViewById(R.id.edit_text_2);
        edit_text3=(EditText) findViewById(R.id.edit_text_3);
        edit_text4=(EditText) findViewById(R.id.edit_text_4);
        edit_text5=(EditText) findViewById(R.id.edit_text_5);

        textview1=(TextView) findViewById(R.id.textview_1);
        textview2=(TextView) findViewById(R.id.textview_2);
        textview3=(TextView) findViewById(R.id.textview_3);
        textview4=(TextView) findViewById(R.id.textview_4);
        textview5=(TextView) findViewById(R.id.textview_5);

        txtView_city =(TextView) findViewById(R.id.txtView_city);
    }

    public void submit(View view) {

        name = edit_text1.getText().toString();
        email = edit_text2.getText().toString();
        pass = edit_text5.getText().toString();
        address = edit_text4.getText().toString();
        mobile = edit_text3.getText().toString();
        city = auto_city_list.getText().toString();




        if (validateName(name) & validateEmail(email) & validatePhone(mobile) & validateAddress(address) & validatePassword(pass) & validGender(gender) & validCity(city) ){


            Intent intent=new Intent(Registration.this,Dashboard.class);
            startActivity(intent);
        }

    }

    private  boolean validCity(String city){

        if (city.isEmpty()){
            txtView_city.setText("City  Is Required");
            auto_city_list.setBackgroundResource(R.drawable.error);
            return false;
        }
        txtView_city.setText("");
        auto_city_list.setBackgroundResource(R.drawable.success_layout);
        return  true;
    }

    private boolean validateName(String name){
        if (name.isEmpty()){
            textview1.setText("Name is required");
           // edit_text1.setBackgroundResource(R.drawable.error);
            return false;
        }
        if (!NAME_ADDRESS_REGEX.matcher(name).matches()){
            textview1.setText("Invalid name type");
            edit_text1.setBackgroundResource(R.drawable.error);
            return false;

        }
        textview1.setText("");
        edit_text1.setBackgroundResource(R.drawable.success_layout);
        return true;
    }

    private  boolean validateEmail(String email){
        if (email.isEmpty()){
            textview2.setText("Email is required");
            return false;
        }
        if(!EMAIL_ADDRESS_REGEX.matcher(email).matches()){
            textview2.setText("invalid email");
            edit_text2.setBackgroundResource(R.drawable.error);
            return false;
        }
        textview2.setText("");
        edit_text2.setBackgroundResource(R.drawable.success_layout);
        return true;

    }

    private boolean validatePhone(String mobile){

        if (mobile.isEmpty()){
            textview3.setText("Phone number is required");
            return false;
        }
        if (!MOBILE_ADDRESS_REGEX.matcher(mobile).matches()){
            textview3.setText("Invalid Phone number");
            edit_text3.setBackgroundResource(R.drawable.error);
            return false;

        }
        textview3.setText("");
        edit_text3.setBackgroundResource(R.drawable.success_layout);
        return true;

    }

    private boolean validateAddress(String address){
        if (address.isEmpty()){
            textview4.setText("Address is required");
            return false;
        }
        if (!ADDRESS_REGEX.matcher(address).matches()){
            textview4.setText("Invalid type address");
            edit_text4.setBackgroundResource(R.drawable.error);
            return false;
        }
        textview4.setText("");
        edit_text4.setBackgroundResource(R.drawable.success_layout);
        return true;
    }

    private  boolean validatePassword(String pass){
        if (pass.isEmpty()){
            textview5.setText("Password is required");
            return false;
        }
        if (!PASSWORD_ADDRESS_REGEX.matcher(pass).matches()){
            textview5.setText("Invalid password type");
            edit_text5.setBackgroundResource(R.drawable.error);
            return false;
        }
        textview5.setText("");
        edit_text5.setBackgroundResource(R.drawable.success_layout);
        return true;
    }

    public  boolean validGender(String gender){
        if (gender.isEmpty()){
            gender_error_1.setText("Field Is Required");
            return false;
        }
        gender_error_1.setText("");
        return true;
    }


    public void GetGender(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        clickedRadioButton =(RadioButton) findViewById(radioId);
        gender = clickedRadioButton.getText().toString();
    }
}