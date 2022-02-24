package com.example.gestiunechirii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewHousesActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_houses);

        recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass= new DatabaseHelperClass(this);
        List<Houses> housesList= databaseHelperClass.getHousesList();
       // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
       //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if(housesList.size()>0){
            HousesAdapterClass housesAdapterClass = new HousesAdapterClass(housesList,ViewHousesActivity.this);
      // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
      // linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
           // housesList.get(linearLayoutManager);
            //housesList.(housesAdapterClass);
            recyclerView.setAdapter(housesAdapterClass);
           // recyclerView.setLayoutManager(new LinearLayoutManager(this));

         //   startActivity(housesAdapterClass);
            //return housesAdapterClass;
        }else{
            Toast.makeText(getApplicationContext(), R.string.adaugati_view,
                  Toast.LENGTH_LONG)
                  .show();
        }


    }
}