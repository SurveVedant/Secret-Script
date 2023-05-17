package com.vedant.passwordmanager;

import android.content.Intent;
//import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private String realpassword;
    private String realMiddleName;

    EditText PasswordText;
    Button btnLogin,btnSignUp,btnForget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          PasswordText = findViewById(R.id.Input);

          btnLogin = findViewById(R.id.Enter_Button);
        btnLogin.setOnClickListener(view -> {
              String password = PasswordText.getText().toString();

            // Retrieve the password from the file
            String fileName3 = "personaldata_password.txt";
            String retrievedData1 = "";

            try {
                FileInputStream inputStream1 = openFileInput(fileName3);
                InputStreamReader inputStreamReader1 = new InputStreamReader(inputStream1);
                BufferedReader bufferedReader1 = new BufferedReader(inputStreamReader1);
                StringBuilder stringBuilder1 = new StringBuilder();

                String line1;
                while ((line1 = bufferedReader1.readLine()) != null) {
                    stringBuilder1.append(line1);
                }

                inputStream1.close();
                retrievedData1 = stringBuilder1.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }

// Store the retrieved password in a variable
            realpassword = retrievedData1;

              if (password.equals(realpassword)) {
                  Toast.makeText(MainActivity.this, "Logged In Successfully !", Toast.LENGTH_SHORT).show();

                  Intent intent = new Intent(getApplicationContext(), Real_Page.class);
                  startActivity(intent);
              } else {
                  Toast.makeText(MainActivity.this, "Incorrect Password !", Toast.LENGTH_SHORT).show();
              }
          });

        btnSignUp = findViewById(R.id.SignUp_Button);
          btnSignUp.setOnClickListener(view -> {

              // Retrieve the middle name from the file
              String fileName4 = "personaldata_middlename.txt";
              String retrievedData2 = "";

              try {
                  FileInputStream inputStream2 = openFileInput(fileName4);
                  InputStreamReader inputStreamReader2 = new InputStreamReader(inputStream2);
                  BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
                  StringBuilder stringBuilder2 = new StringBuilder();

                  String line2;
                  while ((line2 = bufferedReader2.readLine()) != null) {
                      stringBuilder2.append(line2);
                  }

                  inputStream2.close();
                  retrievedData2 = stringBuilder2.toString();
              } catch (Exception e) {
                  e.printStackTrace();
              }

// Store the retrieved middle name in a variable
              realMiddleName = retrievedData2;

              if (realMiddleName.equals("")) {
                  Intent intent = new Intent(getApplicationContext(), SignUp_Page.class);
                  startActivity(intent);
              } else {
                  Toast.makeText(MainActivity.this, "Already Signed Up !", Toast.LENGTH_SHORT).show();
              }
          });

        btnForget = findViewById(R.id.Forget_Button);
        btnForget.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Forget_Page.class);
            Bundle bundle3 = new Bundle();
            bundle3.putString("realmiddlename", realMiddleName);
            intent.putExtras(bundle3);
            startActivity(intent);
        });


    }
}
