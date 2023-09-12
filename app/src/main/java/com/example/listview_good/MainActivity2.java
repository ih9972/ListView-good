package com.example.listview_good;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener{
    String type_of_series;
    double a1,d,sn;
    ListView listV;
    TextView a1_display, d_display, n_display,sn_display;
    ArrayAdapter<Double> adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        a1_display = (TextView) findViewById(R.id.textView5);
        d_display = (TextView) findViewById(R.id.textView7);
        n_display = (TextView) findViewById(R.id.textView9);
        sn_display = (TextView) findViewById(R.id.textView11);
        listV = findViewById(R.id.listV);

        Intent gi = getIntent();
        type_of_series = gi.getStringExtra("type_series");
        a1 = gi.getDoubleExtra("a1",-999999);
        d = gi.getDoubleExtra("d",-999999);

        a1_display.setText(""+ a1);
        d_display.setText(""+d);

        Double[] arry = new Double[20];
        if (type_of_series.equals("arithmetic")){
            for (int i = 0; i < arry.length; i++) {
                arry[i] = a1 + (i * d);
            }
        }
        else{
            for (int i = 0; i < arry.length; i++) {
                arry[i] = a1 * Math.pow(d,(i));
            }
        }
        ArrayAdapter<Double> adp = new ArrayAdapter<Double>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arry);
        listV.setAdapter(adp);
        listV.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        n_display.setText(""+(position+1) );
        if(type_of_series.equals("arithmetic")){
            sn=((2*a1+(d*position))*(position+1))/2;
        }
        else {
            if (d==1){
                sn = (position+1)*a1;
            }
            else{
                sn = a1*((Math.pow(d,(position+1))-1)/(d-1));
            }
        }
        sn_display.setText(""+sn);
    }
}