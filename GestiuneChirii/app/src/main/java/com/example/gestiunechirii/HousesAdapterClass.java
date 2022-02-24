package com.example.gestiunechirii;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HousesAdapterClass  extends RecyclerView.Adapter<HousesAdapterClass.ViewHolder>{
    List<Houses> houses;
    Context context;
    DatabaseHelperClass databaseHelperClass;

    public HousesAdapterClass(List<Houses> houses, Context context) {
        this.houses = houses;
        this.context = context;
        databaseHelperClass= new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater= LayoutInflater.from((parent.getContext()));
        View view= layoutInflater.inflate(R.layout.houses_item_list, parent, false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Houses housesClass= houses.get(position);
        holder.textViewID.setText(Integer.toString(housesClass.getId()));
        holder.editText_desc.setText(housesClass.getNameHouse());
        holder.editText_loc.setText(housesClass.getLocation());

        holder.btn_edit.setOnClickListener(v -> {
            String stringDesc= holder.editText_desc.getText().toString();
            String stringLoc= holder.editText_loc.getText().toString();

            databaseHelperClass.updateHouse(new Houses(housesClass.getId(), stringDesc, stringLoc));
            notifyDataSetChanged();
            ((Activity) context).finish();
            context.startActivity(((Activity) context).getIntent());
        });
        holder.btn_delete.setOnClickListener(v -> {
            databaseHelperClass.deleteHouse(housesClass.getId());
            houses.remove(position);
            notifyDataSetChanged();

        });
    }

    @Override
    public int getItemCount() {
        return houses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewID;
        EditText editText_desc;
        EditText editText_loc;
        Button btn_edit;
        Button btn_delete;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewID=itemView.findViewById(R.id.text_id);
            editText_desc=itemView.findViewById(R.id.edittext_houseDescription);
            editText_loc=itemView.findViewById(R.id.edittext_locationOwner);
            btn_edit=itemView.findViewById(R.id.button_edit);
            btn_delete=itemView.findViewById(R.id.button_delete);
        }
    }
}
