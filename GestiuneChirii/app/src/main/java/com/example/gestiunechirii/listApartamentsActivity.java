package com.example.gestiunechirii;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;



public class listApartamentsActivity extends AppCompatActivity {
    public static final String EXPENSES_KEY = "EXPENSES_KEY";
    public static final int REQUEST_KEY_ADD_AP = 100;
    public static final String OKEY_INSERT_AP="okeyInsertAp";


    private Button btn;
    public LayoutInflater layoutInflater;
    private ListView lvApartments;
    private List<Apartments> apartments = new ArrayList<>();
    // private ActivityResultLauncher <Intent>addApartamentLuncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_apartaments);
        initComponents();
        // addApartamentLuncher=registerAddAppartamentLuncher();
    }

//    //Luncher+++
//    private ActivityResultLauncher<Intent> registerAddAppartamentLuncher() {
//        ActivityResultCallback<ActivityResult> callback = getAddApartamentActivityResulCallback();
//        return registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), callback);
//    }

//    //++++
//    private ActivityResultCallback<ActivityResult>getAddApartamentActivityResulCallback(){
//        return new ActivityResultCallback<ActivityResult>() {
//            @Override
//            public void onActivityResult(ActivityResult result) {
//                //procesare informatii primite din AddActivity
//                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
//                    Apartments ap = (Apartments) result.getData().getSerializableExtra(AddApartamentActivity.APARTAMENT_ADD_KEY);
//                    if (ap != null) {
//                        apartments.add(ap);
//                        //notificare adapter
//                      notifyLvStudentAdapter();//pt vizualiare
//                    }
//                }
//            }
//
//
//        };
//    }

//    private void notifyLvStudentAdapter() {
//        ArrayAdapter adapter = (ArrayAdapter) lvApartments.getAdapter();
//        adapter.notifyDataSetChanged();
//    }

    private void initComponents() {
        lvApartments = findViewById(R.id.lv_list_apartamets);//activiti_list_apart.xml
        btn = findViewById(R.id.btn_list_add_new_apartament);
        btn.setOnClickListener(getAddApartamentClickListener());

        layoutInflater=getLayoutInflater();
        addListApartamentAdapter(apartments);

//addApartamentsAdapter();
    }

//    private void addApartamentsAdapter() {
//        ArrayAdapter adapter = new ArrayAdapter
//                (getApplicationContext(),
//                        android.R.layout.simple_list_item_1,
//                        apartments);
//        lvApartments.setAdapter(adapter);
//       // adapter.notifyDataSetChanged();
//    }

    private View.OnClickListener getAddApartamentClickListener() {
        return v -> {
            Intent intent = new Intent
                    (listApartamentsActivity.this, AddApartamentActivity.class);
            startActivityForResult(intent, REQUEST_KEY_ADD_AP);
            //   addApartamentLuncher.launch(intent);//+++++
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_KEY_ADD_AP
                && resultCode == RESULT_OK && data != null) {

            //Apartments apar = data.getParcelableExtra(AddApartamentActivity.APARTAMENT_ADD_KEY);
            Apartments apar = data.getParcelableExtra(AddApartamentActivity.APARTAMENT_ADD_KEY);
            apartments.add(apar);
            ArrayAdapter adapter=(ArrayAdapter) lvApartments.getAdapter();
            adapter.notifyDataSetChanged();
        }
    }

    public void addListApartamentAdapter(List<Apartments> listAp) {
        ApartamentsAdapter adapter = new ApartamentsAdapter
                (getApplicationContext(),
                        R.layout.lv_list_apartament,
                        listAp,
                        layoutInflater);
        lvApartments.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


}