package com.example.bmicalculater;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private EditText edtweigth,edthightfeet,edthightench ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.idTxt);
        button= findViewById(R.id.idBtn);
        edtweigth = findViewById(R.id.edtWeight);
        edthightfeet = findViewById(R.id.edtHightFeet);
        edthightench = findViewById(R.id.edtHightInch);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtweigth.getText().toString());
                int htFeet = Integer.parseInt(edthightfeet.getText().toString());
                int htench =  Integer.parseInt(edthightench.getText().toString());

                int totalInch = htFeet*12 + htench ;
                double totalCm = totalInch * 2.53 ;
                double totalMeter = totalCm/100 ;

                double bmi = wt/(totalMeter*totalMeter);

                if (bmi>25){
                    textView.setText("you are OvderWeight");
                    textView.setTextColor(getColor(R.color.red));
                }else if (bmi<18){
                    textView.setText("you are underweight ");
                    textView.setTextColor(getColor(R.color.yello));
                }else {
                    textView.setText("you are Helthy");
                    textView.setTextColor(getColor(R.color.green));
                }


            }
        });
    }
}

