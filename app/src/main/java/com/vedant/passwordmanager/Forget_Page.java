package com.vedant.passwordmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Forget_Page extends AppCompatActivity {

    public static String realmiddlename;
    EditText MiddleNameText;
    Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_page);

        Bundle bundle3 = getIntent().getExtras();
        if (bundle3 != null) {
            realmiddlename = bundle3.getString("realmiddlename");
        }

        MiddleNameText = (EditText) findViewById(R.id.middlename_input);


        btnEnter = (Button) findViewById(R.id.signup_page_button);
        btnEnter.setOnClickListener(view -> {
            String middlename = MiddleNameText.getText().toString();

            if(middlename.equals(realmiddlename)) {
                Toast.makeText(Forget_Page.this, "Correct Father's Middle Name", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),SignUp_Page.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(Forget_Page.this, "Incorrect Father's Middle Name", Toast.LENGTH_SHORT).show();
            }
        });

    }
}