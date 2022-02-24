package com.example.gestiunechirii;
/* pt register user */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SignUpCreateNewAccountActivity extends AppCompatActivity {
    //public static final String NEW_CUSTOMERS_KEY = "new_customers_key";
    public  final String CREDENTIAL_KEY = "credential_key";
   // private TextInputEditText tietName;
    private TextInputEditText tietEmail;
    private TextInputEditText tietPassword;
    private TextInputEditText tietRePassword;
 //   private RadioGroup rgTypeClientOwner;
    private Button btnCreateAccount;

    SharedPreferences credentiales;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_create_new_account);

        initComponents();
     //   intent = getIntent();
    }


    private void initComponents() {
        //tietName = findViewById(R.id.tiet_signUp_name);
        tietEmail =findViewById(R.id.tiet_signUp_email);
        tietPassword = findViewById(R.id.tiet_signUp_password);
        tietRePassword =findViewById(R.id.tiet_signUp_rePassword);
        btnCreateAccount =findViewById(R.id.btn_signUp_create);
     //   rgTypeClientOwner=findViewById(R.id.rg_signUp_type);
      //  btnCreateAccount.setOnClickListener(getBtnCreateAccountClickListener());
        btnCreateAccount.setOnClickListener(v -> {
         //   String name = tietName.getText().toString();
            String email = tietEmail.getText().toString();
            String password = tietPassword.getText().toString();
            String rePassword = tietRePassword.getText().toString();
           // String typeClientOwner = findViewById(rgTypeClientOwner.getCheckedRadioButtonId()).toString();


            if(password!=null&&rePassword!=null&&password.trim().length()>4&& rePassword.trim().length()>4&&
                    password.equalsIgnoreCase(rePassword)) {
                 credentiales = getSharedPreferences(CREDENTIAL_KEY, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = credentiales.edit();
                editor.putString(getString(R.string.pass_signup), password);
                editor.putString(getString(R.string.username_signup_new), email);
                editor.commit();
                SignUpCreateNewAccountActivity.this.finish();
            }

//                if(name!=null||name.trim().length()<4||name.trim().isEmpty())
//                { //SharedPreferences credentiales=getSharedPreferences(CREDENTIAL_KEY, Context.MODE_PRIVATE);
//                    Toast.makeText(getApplicationContext(),"Invalid Name, minim 4 characters. Please insert value for Name",
//                            Toast.LENGTH_LONG).show();
//                 //   return false;
//                }
//
//                if(email!=null||email.trim().isEmpty())
//                {
//                    Toast.makeText(getApplicationContext(),"Invalid Email. Please insert an email adress!",
//                            Toast.LENGTH_LONG)
//                            .show();
//                   // return false;
//                }
//                if(!Patterns.EMAIL_ADDRESS.matcher(tietEmail.getText().toString()).matches()){
//                    Toast.makeText(getApplicationContext(),"Invalid Email. Please insert a valid email format!", Toast.LENGTH_SHORT ).show();
//                  //  return false;
//                }
//                if(password!=null||password.trim().length()<5||password.trim().isEmpty())
//                {
//                    Toast.makeText(getApplicationContext(),"Invalid Password, minim 5 characters!",
//                            Toast.LENGTH_LONG)
//                            .show();
//                 //   return false;
//                }
//                if(rePassword!=null||rePassword.trim().length()<5||rePassword.trim().isEmpty())
//                {
//                    Toast.makeText(getApplicationContext(),"Enter Re-Password!",
//                            Toast.LENGTH_LONG)
//                            .show();
//                 //   return false;
//                }
//                if(typeClientOwner != null) {
//                    Toast.makeText(getApplicationContext(),"Plese choose a type!", Toast.LENGTH_SHORT ).show();
//                   // return false;
//                }


        });
    }

    //nu mai e ok
//    private View.OnClickListener getBtnCreateAccountClickListener() {
//        return new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//               // if(isValid()){
//                String name = tietName.getText().toString();
//                String email = tietEmail.getText().toString();
//                String password = tietPassword.getText().toString();
//                String rePassword = tietRePassword.getText().toString();
//                String typeClientOwner = findViewById(rgTypeClientOwner.getCheckedRadioButtonId()).toString();
//
//
//                if(password==null&&rePassword==null&&password.trim().length()<4&& rePassword.trim().length()<4&&
//                        password.equalsIgnoreCase(rePassword))
//                { SharedPreferences credentiales = getSharedPreferences(CREDENTIAL_KEY, Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor=credentiales.edit();
//                    editor.putString("Password", password);
//                    editor.putString("Username", name);
//                    editor.commit();
//
//                    SignUpCreateNewAccountActivity.this.finish();
//
//
//
//
//                }
//
//
//                  //  finish();
//                }
//           // }
//            };
//    }

//    private Houses createCustomersView() {
//        String name = tietName.getText().toString();
//        String email = tietEmail.getText().toString();
//        String password = tietPassword.getText().toString();
//        String rePassword = tietRePassword.getText().toString();
//        String typeClientOwner = findViewById(rgTypeClientOwner.getCheckedRadioButtonId()).toString();//pt rg
//        return new Houses(name,email, password, rePassword, typeClientOwner);
//    }

    //validari
//    private boolean isValid() {
//
//        String name = tietName.getText().toString();
//        String email = tietEmail.getText().toString();
//        String password = tietPassword.getText().toString();
//        String rePassword = tietRePassword.getText().toString();
//        String typeClientOwner = findViewById(rgTypeClientOwner.getCheckedRadioButtonId()).toString();
//
//
//        if(password!=null&&rePassword!=null && password.trim().length()<4&& rePassword.trim().length()<4&&
//                password.equalsIgnoreCase(rePassword))
//        { SharedPreferences credentiales=getSharedPreferences(CREDENTIAL_KEY, Context.MODE_PRIVATE);
//            SharedPreferences.Editor editor=credentiales.edit();
//            editor.putString("Password", password);
//            editor.putString("Username", name);
//            editor.commit();
//
//            SignUpCreateNewAccountActivity.this.finish();
//
//        }
//        if(name!=null||name.trim().length()<4||name.trim().isEmpty())
//        { //SharedPreferences credentiales=getSharedPreferences(CREDENTIAL_KEY, Context.MODE_PRIVATE);
//            Toast.makeText(getApplicationContext(),"Invalid Name, minim 4 characters. Please insert value for Name",
//                    Toast.LENGTH_LONG)
//                    .show();
//            return false;
//        }
//
//        if(email!=null||email.trim().isEmpty())
//        {
//            Toast.makeText(getApplicationContext(),"Invalid Email. Please insert an email adress!",
//                    Toast.LENGTH_LONG)
//                    .show();
//            return false;
//        }
//        if(!Patterns.EMAIL_ADDRESS.matcher(tietEmail.getText().toString()).matches()){
//            Toast.makeText(getApplicationContext(),"Invalid Email. Please insert a valid email format!", Toast.LENGTH_SHORT ).show();
//            return false;
//        }
//        if(password!=null||password.trim().length()<5||password.trim().isEmpty())
//        {
//            Toast.makeText(getApplicationContext(),"Invalid Password, minim 5 characters!",
//                    Toast.LENGTH_LONG)
//                    .show();
//            return false;
//        }
//        if(rePassword!=null||rePassword.trim().length()<5||rePassword.trim().isEmpty())
//        {
//            Toast.makeText(getApplicationContext(),"Enter Re-Password!",
//                    Toast.LENGTH_LONG)
//                    .show();
//            return false;
//        }
//        if(typeClientOwner != null) {
//            Toast.makeText(getApplicationContext(),"Plese choose a type!", Toast.LENGTH_SHORT ).show();
//            return false;
//        }
//        return true;
//    }
}