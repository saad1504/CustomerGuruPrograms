package com.saad.algorithms.customerguruquestionfour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner DropDownMenu;
    private EditText NameField;
    private EditText PhoneField;
    private EditText EmailField;
    private Button Validate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NameField=(EditText)findViewById(R.id.NameField);
        PhoneField=(EditText)findViewById(R.id.PhoneField);
        EmailField=(EditText)findViewById(R.id.EmailField);
        DropDownMenu=(Spinner)findViewById(R.id.CityMenu);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.city_arrays, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        DropDownMenu.setAdapter(adapter);
        DropDownMenu.setOnItemSelectedListener(MainActivity.this);
        Validate=(Button)findViewById(R.id.ValidateInput);
        Validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    Toast.makeText(MainActivity.this,"Input is valid",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Input is invalid,try again",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean validate() {
        boolean validationFlag=true;
        if(NameField.getText().length() ==0 || PhoneField.getText().length()==0 || EmailField.getText().length()==0){

            validationFlag=false;
            if(NameField.getText().length()==0){
                NameField.setError("Please enter the name");

            }
            if(PhoneField.getText().length()==0){
                PhoneField.setError("Please enter phone number");

            }
            if(EmailField.getText().length()==0) {
                EmailField.setError("Please enter the email id");

            }
        }

        String nameOfUser= NameField.getText().toString();
        String emailOfUser= EmailField.getText().toString();
        if(!(isAlpha(nameOfUser))) {
            NameField.setError("Name can consist of only alphabets");
            validationFlag=false;
        }
        if(!(isEmailValid(emailOfUser))){
            EmailField.setError("Email id is not of correct form");
            validationFlag=false;
        }

        return true;


    }
    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
