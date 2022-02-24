package com.example.gestiunechirii;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Date;

//Activitate adaugare Apartament nou
public class AddApartamentActivity extends AppCompatActivity {

    public static final String APARTAMENT_ADD_KEY="apartament_add_key";
    private EditText etDescriptionAp;
    private Spinner spnLocation;
    private EditText etPrice;
    private Button btnSave;
    private EditText etDateAp;
    private Button btnCancel;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_apartament);

        initComponents();
        intent = getIntent();
    }

    private void initComponents() {
         etDescriptionAp=findViewById(R.id.et_add_descriptionTextAp);
         spnLocation=findViewById(R.id.spn_addAP_location);
         etDateAp=findViewById(R.id.et_add_dateAddApartament);
        etPrice=findViewById(R.id.et_add_priceAp);
        btnCancel=findViewById(R.id.btn_add_cancelAp);
        btnCancel.setOnClickListener(v -> {
            setResult(RESULT_CANCELED,intent);
            finish();
        });
        btnSave=findViewById(R.id.btn_add_saveAp);

        btnSave.setOnClickListener(getbtnSaveAddApartamentClickListener());
        //pt spinner
        addSpinnerLocationAdapter();

    }
//spinner
    private void addSpinnerLocationAdapter() {
        //creare adapter cu vector constant static in strings.xml
         ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(AddApartamentActivity.this,
                       R.array.spn_add_location,
                               R.layout.support_simple_spinner_dropdown_item);//?????

        //spinner setam adapterul
        spnLocation.setAdapter(adapter);
    }

    private View.OnClickListener getbtnSaveAddApartamentClickListener() {
        return v -> {
            if(isValid()) {
                Apartments apartments = createObjectApartament();
                intent.putExtra(APARTAMENT_ADD_KEY, apartments);
                setResult(RESULT_OK, intent);
                finish();
            }
        };
    }

    private boolean isValid() {
        if(etDescriptionAp.getText().toString().trim().isEmpty()||etDescriptionAp.getText() == null||etDescriptionAp.getText().toString().trim().length() < 2) {
            Toast.makeText(getApplicationContext(), R.string.comp_descp
                    , Toast.LENGTH_LONG).show();
            return false;
        }
        if(etPrice.getText().toString().trim().isEmpty()||etPrice.getText() == null||etPrice.getText().toString().trim().length() < 1) {
            Toast.makeText(getApplicationContext(), R.string.comp_in_price
                    , Toast.LENGTH_LONG).show();
            return false;
        }
        if(etDateAp.getText().toString()==null||
                DateConverter.fromString(etDateAp.getText().toString().trim())==null){
            Toast.makeText(getApplicationContext(),
                    R.string.comp_date, Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    private Apartments createObjectApartament() {
    String apartamentDescription=etDescriptionAp.getText().toString();
    String location=spnLocation.getSelectedItem().toString();
    Float price=Float.parseFloat(etPrice.getText().toString());
    Date date=DateConverter.fromString(etDateAp.getText().toString());
       // String date=etDateAp.getText().toString();

    return new Apartments(apartamentDescription, location, price, date);

    }


}