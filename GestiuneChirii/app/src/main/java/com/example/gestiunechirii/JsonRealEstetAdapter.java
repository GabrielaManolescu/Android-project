package com.example.gestiunechirii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.List;

public class JsonRealEstetAdapter extends ArrayAdapter<JsonRealEstate> {
    private Context context;
    private int resource;
    private List<JsonRealEstate> realEstate;
    private LayoutInflater inflater;

//dupa ce fac extends
     public JsonRealEstetAdapter(@NonNull Context context, int resource, List<JsonRealEstate> objects,
                                 LayoutInflater inflater) {
        super(context, resource, objects);
         this.context = context;
         this.resource = resource;
         this.realEstate = objects;
         this.inflater = inflater;
    }
//caut getV
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ///return super.getView(position, convertView, parent);
        View view = inflater.inflate(resource, parent, false);
        JsonRealEstate account = realEstate.get(position);
        if (account == null) {
            return view;
        }
        addImage(view, account.getImagine());
        addName(view, account.getNume());
        addPrice(view, account.getPret());
        return view;

    }

    private void addPrice(View view, String price) {
        TextView textView = view.findViewById(R.id.lv_json_tv_price_real_estate);
        if (price != null && !price.trim().isEmpty()) {
            textView.setText(price);
        } else {
            textView.setText("--");
        }
    }

    private void addName(View view, String nume) {
        TextView textView = view.findViewById(R.id.lv_json_tv_name_real_estate);
        if (nume != null && !nume.trim().isEmpty()) {
            textView.setText(nume);
        } else {
            textView.setText("--");
        }
    }

    private void addImage(View view, String imagine) {
        ImageView imageView = view.findViewById(R.id.lv_json_real_estate_image);
        if (imagine != null) {
            Picasso.get().load(imagine).into(imageView);

        }
    }
}
