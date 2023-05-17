package com.vedant.passwordmanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class SignUp_Page extends AppCompatActivity {

    EditText ChangePasswordText,MiddleNameText;
    Button btnEnter;
    String password,middlename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        MiddleNameText = findViewById(R.id.middlename_input);
        ChangePasswordText = findViewById(R.id.ChnageP_button);

        btnEnter = findViewById(R.id.signup_page_button);
        btnEnter.setOnClickListener(view -> {
            middlename = MiddleNameText.getText().toString();
            password = ChangePasswordText.getText().toString();

            Toast.makeText(SignUp_Page.this, "Password Created Successfully !", Toast.LENGTH_SHORT).show();

            String fileName1 = "personaldata_password.txt";
            String data1 = password;

            try {
                FileOutputStream outputStream1 = openFileOutput(fileName1, Context.MODE_PRIVATE);
                outputStream1.write(data1.getBytes());
                outputStream1.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Save the middle name to a file
            String fileName2 = "personaldata_middlename.txt";
            String data2 = middlename;

            try {
                FileOutputStream outputStream2 = openFileOutput(fileName2, Context.MODE_PRIVATE);
                outputStream2.write(data2.getBytes());
                outputStream2.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


            Intent intent1 = new Intent(SignUp_Page.this, MainActivity.class);
            //Bundle bundle1 = new Bundle();
            //Bundle bundle2 = new Bundle();
            //bundle1.putString("realpassword", password);
            //bundle2.putString("realmiddlename", middlename);
            //intent1.putExtras(bundle1);
            //intent1.putExtras(bundle2);
            startActivity(intent1);

        });

    }
}