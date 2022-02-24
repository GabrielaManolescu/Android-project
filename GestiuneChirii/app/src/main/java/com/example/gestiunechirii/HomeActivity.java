package com.example.gestiunechirii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private Button listRentsEstate;//vizualizare imobile de inchiriat
    private Button listAddRentsEstate;
    private Button btnAddHouse;
    private Button btnAboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initComponents();
    }

    private void initComponents(){
        listAddRentsEstate=findViewById(R.id.btn_home_addRentsEstate);
        listRentsEstate=findViewById(R.id.btn_home_viewRealEstate);
        btnAboutUs=findViewById(R.id.btn_home_AboutUs);
        btnAddHouse=findViewById(R.id.btn_home_addHouses);

//        listRentsEstate.setOnClickListener((v)->{
//            Intent intent = new Intent(getApplicationContext(),FeedbackActivity.class);
//            startActivity(intent);
//        });


        listAddRentsEstate.setOnClickListener((v)->{
            Intent intent = new Intent(getApplicationContext(),listApartamentsActivity.class);//adaugare apartament
            startActivity(intent);
        });
        listRentsEstate.setOnClickListener((v)->{
            Intent intent = new Intent(getApplicationContext(),DisplayJsonRealEstateActivity.class);//afisare json imagini
            startActivity(intent);
        });
        btnAddHouse.setOnClickListener((v) -> {
            Intent intent = new Intent(getApplicationContext(),HousesRentActivity.class);//casa inchiriat
//            Toast.makeText(getApplicationContext(),"nu merge!",
//                    Toast.LENGTH_LONG)
//                    .show();
            startActivity(intent);

        });
        btnAboutUs.setOnClickListener((v)->{
            Intent intent = new Intent(getApplicationContext(),FeedbackActivity.class);//afisare feedback
            startActivity(intent);
        });


    }

}