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
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
