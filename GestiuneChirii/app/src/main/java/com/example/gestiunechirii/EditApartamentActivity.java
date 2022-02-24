package com.example.gestiunechirii;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EditApartamentActivity extends AppCompatActivity {
    public static final String APARTAMENT_EDIT_KEY="apartament_edit_key";
    public static final String APARTAMENT_DELETE_KEY="apartament_delete_key";
    private EditText etDescriptionAp;
    private Spinner spnLocation;
    private EditText etPrice;
    private EditText etDateAp;
    private Button btnCancel;
    private Button btnSave;
    private Button btnDelete;

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_apartament);

        initComponents();
        intent = getIntent();//preia ce am lansat in lunch in list
    }

    private void initComponents() {
        etDescriptionAp=findViewById(R.id.et_edit_descriptionTextAp);
        spnLocation=findViewById(R.id.spn_editAP_location);
        etDateAp=findViewById(R.id.et_edit_dateAddApartament);
        etPrice=findViewById(R.id.et_edit_priceAp);

        btnCancel=findViewById(R.id.btn_edit_cancelAp);
        btnSave=findViewById(R.id.btn_edit_saveAp);
        btnDelete=findViewById(R.id.btn_edit_delete);
        btnCancel.setOnClickListener(v -> {
            setResult(RESULT_CANCELED,intent);
            finish();
        });


        btnSave.setOnClickListener(getbtnSaveAddApartamentClickListener());
        btnDelete.setOnClickListener(v -> {
            AlertDialog alertDialog = dialogDelete();
            alertDialog.show();
            finish();
        });
        //pt spinner
        addSpinnerLocationAdapter();
    }

    private AlertDialog dialogDelete() {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle(getString(R.string.btn_delete))
                .setMessage(getString(R.string.alert_delete))

                .setPositiveButton
                        (getString(R.string.btn_delete), (dialog, whichButton) -> {
                            if(isValid()) {
                                Apartments fitness = creareObiectApartament();
                                intent.putExtra(APARTAMENT_DELETE_KEY,fitness);
                                setResult(RESULT_FIRST_USER, intent);
                                finish();
                            }
                        })

                .setNegativeButton
                        (getString(R.string.btn_delete), (dialog, whichButton) -> dialog.dismiss())
                .create();

        return alertDialog;
    }

    private Apartments creareObiectApartament() {
        String apartamentDescription=etDescriptionAp.getText().toString();
        String location=spnLocation.getSelectedItem().toString();
        Float price=Float.parseFloat(etPrice.getText().toString());
        Date date=DateConverter.fromString(etDateAp.getText().toString());
        // String date=etDateAp.getText().toString();

        return new Apartments(apartamentDescription, location, price, date);
    }

    private boolean isValid() {
        if(etDescriptionAp.getText().toString().trim().isEmpty()||etDescriptionAp.getText() == null||etDescriptionAp.getText().toString().trim().length() < 2) {
            Toast.makeText(getApplicationContext(),
                    R.string.complete_the_descrip,
                    Toast.LENGTH_LONG).show();
            return false;
        }
        if(etPrice.getText().toString().trim().isEmpty()||etPrice.getText() == null||etPrice.getText().toString().trim().length() < 1) {
            Toast.makeText(getApplicationContext(), R.string.complete_theprice
                    , Toast.LENGTH_LONG).show();
            return false;
        }
        if(etDateAp.getText().toString()==null||
                DateConverter.fromString(etDateAp.getText().toString().trim())==null){
            Toast.makeText(getApplicationContext(),
                    R.string.date_complete
                    , Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    private void addSpinnerLocationAdapter() {
        //creare adapter cu vector constant static in strings.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(EditApartamentActivity.this,
                        R.array.spn_add_location,
                        R.layout.support_simple_spinner_dropdown_item);//?????

        //spinner setam adapterul
        spnLocation.setAdapter(adapter);
    }

    //buton save
    private View.OnClickListener getbtnSaveAddApartamentClickListener() {
        return v -> {
            if(isValid()) {
                Apartments apartments = creareObiectApartament();
                intent.putExtra(APARTAMENT_EDIT_KEY, apartments);
                setResult(RESULT_OK, intent);
                finish();
            }
        };
    }



}