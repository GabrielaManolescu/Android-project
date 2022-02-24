package com.example.gestiunechirii;
//pt Login
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    public  final String CREDENTIAL_KEY = "credential_key";
    private Button btnSignIn;
    private Button btnSignCreate;
    private TextInputEditText password;
    private TextInputEditText email;

    SharedPreferences credentiales;

    //public static int ADD_REQUEST_CODE = 1;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
       // intent = getIntent();//preluare intet
    }
    private void initComponents(){
        btnSignIn= findViewById(R.id.btn_main_signIn);
        btnSignCreate=findViewById(R.id.btn_main_signInCreate);
        password=findViewById(R.id.tiet_add_password);
        email=findViewById(R.id.tiet_add_email);
       btnSignIn.setOnClickListener(getBtnSignInClickListener());
//        btnSignIn.setOnClickListener(v -> {
//            SharedPreferences credentiales=getSharedPreferences(CREDENTIAL_KEY, Context.MODE_PRIVATE);
//            String strUsername=credentiales.getString("Username", null);
//            String strPassword=credentiales.getString("Password", null);
//
//            String emailUser= email.getText().toString();
//            String passwordLogin= password.getText().toString();
//
//
//            if(strUsername==null && emailUser==null && emailUser.trim().length()<4 && strUsername.trim().length()<4&&
//                    strUsername.equalsIgnoreCase(emailUser))
//            {
//                Toast.makeText(getApplicationContext(),"Invalid Email/User. Minim 4 characters",
//                        Toast.LENGTH_LONG)
//                        .show();
//                //return false;
//            }
//            if(passwordLogin==null&& strPassword==null&& passwordLogin.trim().length()<4&&strPassword.trim().length()<4&&
//                    strPassword.equalsIgnoreCase(passwordLogin)) {
//                Toast.makeText(getApplicationContext(), "Invalid Password. Minim 4 characters",
//                        Toast.LENGTH_LONG)
//                        .show();
//            }
//      });
 btnSignCreate.setOnClickListener(getBtnSignCreateClickListener());
//        btnSignCreate.setOnClickListener(view);
    }



    //BUTONN
    //buton sign up creare cont nou DE FACUT NU E OK
    private View.OnClickListener getBtnSignCreateClickListener() {//pt btn creatre signin
        return v -> {
            //cand sterg if ul cu validare de sters si finish de jos!

                //click declansat
                //deschidere activitate/pagina NOUA:
                Intent intent= new Intent(getApplicationContext(), SignUpCreateNewAccountActivity.class);//HomeActivity e clasa catre vreau sa navighez
                startActivity(intent);
            //Log.i("MainActivity", intent.toString());
//                    intent.putExtra(ADD_LOGIN_KEY,intent);
//                    setResult(RESULT_OK, intent);
                //distrugere activitate secundara + fortare apel callback din MainActivity
        };
    }

    private boolean isValid() {//Validari email si parola
         credentiales=getSharedPreferences(CREDENTIAL_KEY, Context.MODE_PRIVATE);
        String strUsername=credentiales.getString(getString(R.string.username_main), null);
        String strPassword=credentiales.getString(getString(R.string.password_main), null);

        String emailUser= email.getText().toString();
        String passwordLogin= password.getText().toString();


    if(strUsername==null && emailUser==null && emailUser.trim().length()<4 && strUsername.trim().length()<4&&
    strUsername.equalsIgnoreCase(emailUser))
        {
            Toast.makeText(getApplicationContext(), R.string.invalid_emial_usef,
                    Toast.LENGTH_LONG)
                    .show();
            return false;
        }
        if(passwordLogin==null&& strPassword==null&& passwordLogin.trim().length()<4&&strPassword.trim().length()<4&&
                strPassword.equalsIgnoreCase(passwordLogin))
        {
            Toast.makeText(getApplicationContext(), R.string.invalid_password,
                    Toast.LENGTH_LONG)
                    .show();
            return false;
        }

        return true;
    }

///buton logare in Home btnSignIn
    private View.OnClickListener getBtnSignInClickListener() {//pt btnSignIn intrare in Home
        return v -> {
            //validare
         //   if(isValid()){

               // Intent intent= new Intent(getApplicationContext(), HomeActivity.class);
               //startActivity(intent);//ssau asta?

           // }


            SharedPreferences credentiales=getSharedPreferences(CREDENTIAL_KEY, Context.MODE_PRIVATE);
            String strUsername=credentiales.getString(getString(R.string.usernn), null);
            String strPassword=credentiales.getString(getString(R.string.passwordd), null);

            String emailUser= email.getText().toString();
            String passwordLogin= password.getText().toString();


            if(strUsername!=null && emailUser!=null && strUsername.equalsIgnoreCase(emailUser)){
                if(strPassword!=null && passwordLogin!=null && strPassword.equalsIgnoreCase(passwordLogin))
                 {
                Toast.makeText(MainActivity.this, R.string.login_succ, Toast.LENGTH_LONG).show();
                Intent intent= new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                }
            }
            else{
                Toast.makeText(MainActivity.this, R.string.inv_user_faild, Toast.LENGTH_LONG).show();

            }
//           else if(strUsername==null|| emailUser==null)
//            {
//                Toast.makeText(getApplicationContext(),"Invalid Email/User. Minim 4 characters",
//                        Toast.LENGTH_LONG)
//                        .show();
//            }
//            if( strPassword==null)
//            {
//                Toast.makeText(MainActivity.this,"Invalid Password.",
//                        Toast.LENGTH_LONG).show();
//                //return false;
//            }

        };
    }
}