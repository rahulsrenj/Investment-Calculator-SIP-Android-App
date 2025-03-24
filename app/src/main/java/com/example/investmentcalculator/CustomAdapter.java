package com.example.investmentcalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<InvestmentModel> {

    private Context context;
    private ArrayList<InvestmentModel> investmentModels;
    public CustomAdapter(@NonNull Context context, int resource, ArrayList<InvestmentModel> investmentModels) {
        super(context, resource, investmentModels);
        this.context=context;
        this.investmentModels=investmentModels;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        InvestmentModel model=getItem(position);
        if (convertView==null)
        {
            convertView=LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
            holder=new ViewHolder();
            holder.investmentIcon=convertView.findViewById(R.id.investmentIcon);
            holder.investmentType=convertView.findViewById(R.id.investmentType);
            convertView.setTag(holder);
        }
        else{
            holder=(ViewHolder) convertView.getTag();
        }
        holder.investmentType.setText(model.getInvestmentType());
        holder.investmentIcon.setImageResource(model.getImageRes());
        return convertView;
    }
    static class ViewHolder{
        private ImageView investmentIcon;
        private TextView investmentType;
    }
}
