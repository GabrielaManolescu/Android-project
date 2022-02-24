package com.example.gestiunechirii;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Date;
import java.util.List;

//Adapter lista Apartamente

public class ApartamentsAdapter extends ArrayAdapter <Apartments>{
    private Context context;
    private int resource;
    private List <Apartments> apartments;
    private LayoutInflater inflater;

    public ApartamentsAdapter(@NonNull Context context, int resource, @NonNull List<Apartments> apartments,
                              LayoutInflater inflater) {//constructor, penultimul//LayoutInflater incarca in xml fisierul
      super(context, resource, apartments);//apeleaza constructorul parinte
        //initializare variabile
        this.context=context;
        this.resource=resource;
        this.apartments=apartments;
        this.inflater=inflater;
    }




    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            @SuppressLint("ViewHolder") View view=inflater.inflate(resource,parent, false );
            //populare tv
        Apartments ap=apartments.get(position);
        if(ap==null){
            return view;
        }
        addApartmentsName(view, ap.getNameApartament());
        addPrice(view, ap.getPrice());
        addDate(view, ap.getDateValidity());
            return view;

    }

    private void addDate(View view, Date dateValidity) {
        TextView textView=view.findViewById(R.id.lv_list_date);
        //setez in text
        if(dateValidity!=null){
            textView.setText(DateConverter.fromDate(dateValidity));
           // textView.setText(dateValidity);
        }else{
            textView.setText(R.string.name_adapter_defoult_value);
        }
    }
//popilez price
    private void addPrice(View view, Float price) {
        TextView textView=view.findViewById(R.id.lv_list_price);
        //setez in text
        if(price!=null){
            textView.setText(String.valueOf(price));
        }else{
            textView.setText(R.string.name_adapter_defoult_value);
        }
    }

    //populez lv_name din listview
    private void addApartmentsName(View view, String nameApartament) {
        TextView textView=view.findViewById(R.id.lv_list_nameEstate);
        //setez in text
        if(nameApartament!=null&&!nameApartament.trim().isEmpty()){
            textView.setText(nameApartament);
        }else{
            textView.setText(R.string.name_adapter_defoult_value);
        }
    }



}
