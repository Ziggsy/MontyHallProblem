package com.upgradedsoftware.android.montyhallproblem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private Button mCalculateButton;
    private String variantsString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.variantsText);



        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                variantsString = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        mCalculateButton = (Button) findViewById(R.id.calculateButton);
        mCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Calculate.class);
                intent.putExtra("NUMBER", variantsString);
                startActivity(intent);
            }
        });



    }
}
