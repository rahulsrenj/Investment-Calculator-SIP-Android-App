package com.example.investmentcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class ResultPage extends AppCompatActivity {
    private TextView invest,returns,value;
    private double totalInvest,totalReturns,totalValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        invest=findViewById(R.id.totalInvestment);
        returns=findViewById(R.id.totalReturns);
        value=findViewById(R.id.totalValue);

        Intent intent=getIntent();
        totalValue=intent.getDoubleExtra("FutureVal",0);
        totalInvest=intent.getDoubleExtra("TOTAL",0);
        totalReturns=totalValue-totalInvest;
        invest.setText(addCommas(totalInvest));
        returns.setText(addCommas(totalReturns));
        value.setText(addCommas(totalValue));

    }
    private String addCommas(double val)
    {
        DecimalFormat decimalFormat=new DecimalFormat("##,##,##0.00");
        return  decimalFormat.format(val);
    }
}