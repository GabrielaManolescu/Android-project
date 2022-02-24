package com.example.gestiunechirii;
//ViewHousesActivity
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HousesRentActivity extends AppCompatActivity {
   private EditText editText_houseDesc;
    private EditText editText_houseLocat;
    private Button btn_add;
    private Button btn_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_houses_rent);

        initComponents();
    }

    private void initComponents() {
        editText_houseDesc= findViewById(R.id.edittext_houseDescription);
        editText_houseLocat=findViewById(R.id.edittext_locationOwner);
        btn_add=findViewById(R.id.button_add_house);
        btn_view=findViewById(R.id.button_view_house);

        btn_add.setOnClickListener(v -> {
            String stringDesc= editText_houseDesc.getText().toString();
            String stringLocation= editText_houseLocat.getText().toString();

            if(stringDesc.length()<=0||stringLocation.length()<=0){
                Toast.makeText(getApplicationContext(),
                        R.string.enter_all_data,
                        Toast.LENGTH_LONG).show();
            }else{
                DatabaseHelperClass databaseHelperClass= new DatabaseHelperClass(getApplicationContext());
                Houses houses= new Houses(stringDesc, stringLocation);
                databaseHelperClass.addHouses(houses);
                Toast.makeText(getApplicationContext(), R.string.add_house_succ, Toast.LENGTH_LONG).show();
                finish();
                startActivity(getIntent());
            }


        });

        btn_view.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),ViewHousesActivity.class);//afisare feedback
            startActivity(intent);
        });

    }
}