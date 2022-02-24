package com.example.gestiunechirii;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DisplayJsonRealEstateActivity extends AppCompatActivity {
    private final static String REAL_ESTATE_URL = "https://jsonkeeper.com/b/FHCN";
    public ListView lvRealEstate;
  private List<JsonRealEstate> realEstate = new ArrayList<>();
 // private JsonRealEstetAdapter adapter;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_json_real_estate);
            realEstate.add(new JsonRealEstate("FAKE2",
                    "ddd", "22"));
           // addRealEstateAdapter();
       //initComponents();
      // loadRealEstateFromUrl();
            lvRealEstate = findViewById(R.id.lv_display_json_real_estate);
            // addRealEstateAdapter();
            new HttpManager() {
                @SuppressLint("StaticFieldLeak")
                protected void onPostExecute(String s) {
                    realEstate = JsonRealEstateParser.parseJson(s);
                    LayoutInflater layoutInflater = getLayoutInflater();
        JsonRealEstetAdapter adapter = new JsonRealEstetAdapter
                (DisplayJsonRealEstateActivity.this,
                        R.layout.lv_real_estate_view, realEstate,
                        layoutInflater);
        lvRealEstate.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }.execute(REAL_ESTATE_URL);
    }

//    private void initComponents() {
//        lvRealEstate = findViewById(R.id.lv_display_json_real_estate);
//        addRealEstateAdapter();
//    }

//    private void addRealEstateSAdapter() {
//        JsonRealEstetAdapter adapter = new  JsonRealEstetAdapter(getApplicationContext(),
//                R.layout.lv_real_estate_view, realEstate, getLayoutInflater());
//        lvRealEstate.setAdapter(adapter);
//
//    }
//    private void addRealEstateAdapter() {
//        //realEstate = JsonRealEstateParser.parseJson(s);
//        LayoutInflater layoutInflater = getLayoutInflater();
//        JsonRealEstetAdapter adapter = new JsonRealEstetAdapter
//                (getApplicationContext(),
//                        R.layout.lv_real_estate_view, realEstate,
//                        layoutInflater);
//        lvRealEstate.setAdapter(adapter);
// adapter.notifyDataSetChanged();//??
//    }

//    private void loadRealEstateFromUrl() {
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                HttpManager manager = new HttpManager(REAL_ESTATE_URL);
//                String result = manager.doInBackground();
//                new Handler(getMainLooper()).post(new Runnable() {
//                    @Override
//                    public void run() {
//                       // Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
//                        //realEstate.addAll(JsonRealEstateParser.parseJson(result));//???
//                      //  realEstate = JsonRealEstateParser.parseJson(result);
//                        mainThreadGetBankAccountsFromHttpCallback(result);
//                    }
//                });
//            }
//        };
//        thread.start();
//    }

//    private void mainThreadGetBankAccountsFromHttpCallback(String result) {
//       Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
//      //realEstate.addAll(JsonRealEstateParser.parseJson(result));
//        realEstate = JsonRealEstateParser.parseJson(result);//??
//      //  realEstate.addAll(JsonRealEstateParser.parseJson(result));
//          notifyAdapter();
//      // addRealEstateAdapter();
//    }
//    private void notifyAdapter() {
//        JsonRealEstetAdapter adapter = (JsonRealEstetAdapter) lvRealEstate.getAdapter();
//       // adapter.notifyDataSetChanged();
//        adapter.notifyDataSetChanged();
//      //  lvRealEstate.setAdapter(adapter);
//    }


}