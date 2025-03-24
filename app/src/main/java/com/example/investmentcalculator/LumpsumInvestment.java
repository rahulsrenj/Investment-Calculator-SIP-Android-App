package com.example.investmentcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class LumpsumInvestment extends AppCompatActivity {
    private SeekBar seekBar;
    private EditText principal,returns;
    private TextView yearDisplay;
    private int year=12;

    private double futureVal;


    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lumpsum_investment);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        seekBar=findViewById(R.id.timePeriod);
        yearDisplay=findViewById(R.id.year);
        principal=findViewById(R.id.principal);
        returns=findViewById(R.id.returns);
        btn=findViewById(R.id.resultCalculate);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                yearDisplay.setText(i+" years");
                year=i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(principal.getText().toString().isEmpty()||returns.getText().toString().isEmpty())
                {
                    Toast.makeText(LumpsumInvestment.this, "Please fill all the forms", Toast.LENGTH_SHORT).show();
                }
                else{
                    double p=Double.parseDouble(principal.getText().toString());
                    double r=Double.parseDouble(returns.getText().toString());
                    InvestmentData invest=new InvestmentData(p,r,year);
                    futureVal=invest.calculateLumpsumInvestment();
                    String stringFormat=String.format("%.2f",futureVal);
                    futureVal=Double.parseDouble(stringFormat);
//                    Toast.makeText(LumpsumInvestment.this, "Val = "+futureVal, Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(), ResultPage.class);
                    intent.putExtra("FutureVal",futureVal);
                    intent.putExtra("TOTAL",(invest.getPrincipal()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        });
    }

}