package com.example.investmentcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<InvestmentModel> models=new ArrayList<>();
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Adapter View
        gridView=findViewById(R.id.gridView);
        //Data Source
        models.add(
                new InvestmentModel("SIP",R.drawable.sip)
        );
        models.add(
                new InvestmentModel("Lumpsum",R.drawable.lumpsum)
        );

        CustomAdapter adapter =new CustomAdapter(this,R.layout.list_item,models);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    Intent intent =new Intent(getApplicationContext(), SipInvestment.class);
                    startActivity(intent);

                }
                else if (i==1)
                {
                    Intent intent =new Intent(getApplicationContext(), LumpsumInvestment.class);
                    startActivity(intent);

                }
            }
        });
    }
}