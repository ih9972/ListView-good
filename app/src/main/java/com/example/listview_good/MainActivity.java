package com.example.listview_good;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText the_a1,the_d;
    RadioGroup rg;
    RadioButton arithmetic, geometric;
    double a1,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        the_a1 = (EditText) findViewById(R.id.a1);
        the_d = (EditText) findViewById(R.id.d);
        rg = (RadioGroup) findViewById(R.id.rgroup);
        arithmetic = (RadioButton) findViewById(R.id.radioButton);
        geometric = (RadioButton) findViewById(R.id.radioButton2);
        rg.check(R.id.radioButton);
    }

    public void calculate(View view) {
        if (!(the_a1.getText().toString().equals("")) && !(the_d.getText().toString().equals(""))) {
            a1 = Double.parseDouble(the_a1.getText().toString());
            d = Double.parseDouble(the_d.getText().toString());
            if (rg.getCheckedRadioButtonId() == R.id.radioButton){
                Intent si = new Intent(this, MainActivity2.class);
                si.putExtra("type_series","arithmetic");
                si.putExtra("a1",a1);
                si.putExtra("d",d);
                startActivity(si);
            }
            else if (rg.getCheckedRadioButtonId() == R.id.radioButton2) {
                Intent si = new Intent(this, MainActivity2.class);
                si.putExtra("type_series","geometric");
                si.putExtra("a1",a1);
                si.putExtra("d",d);
                startActivity(si);
            }
        }
        else
            Toast.makeText(this, "answer all the fields", Toast.LENGTH_LONG).show();
    }
}
