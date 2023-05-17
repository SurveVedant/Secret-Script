package com.vedant.passwordmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Switch;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import android.content.SharedPreferences;


public class Real_Page extends AppCompatActivity {
    private static final String FILE_NAME = "Notes.txt";

    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_page);
        mEditText = findViewById(R.id.editTextTextMultiLine);

        // Restore the state of the Switch
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        boolean switchState = sharedPreferences.getBoolean("switch_state", false);
        Switch switch1 = findViewById(R.id.switch1);
        switch1.setChecked(switchState);
    }

            public void SAVENOTE(View v) {
            String text = mEditText.getText().toString();
            FileOutputStream fos = null;

            try {
                fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                fos.write(text.getBytes());

                mEditText.getText().clear();
                Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
                        Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
                Switch switch1 = findViewById(R.id.switch1);
                switch1.setChecked(true);

                // Save the state of the Switch
                SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("switch_state", true);
                editor.apply();
        }
        public void LOADNOTE(View v) {
            FileInputStream fis = null;

            try {
                fis = openFileInput(FILE_NAME);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                StringBuilder sb = new StringBuilder();
                String text;

                while ((text = br.readLine()) != null) {
                    sb.append(text).append("\n");
                }

                mEditText.setText(sb.toString());

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
}
