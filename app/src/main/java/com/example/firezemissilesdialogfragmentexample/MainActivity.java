package com.example.firezemissilesdialogfragmentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnOpenDialog;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpenDialog = findViewById(R.id.button_open_dialog);
        textView = findViewById(R.id.textView);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new FireMissilesDialogFragment().show(getSupportFragmentManager(), "yourUniqueTagName"); //In this minimal example the tag could be left empty: ""
            }
        });

        Intent yourIntentVariable = getIntent();

        //Depending on your project checking whether extras is not null, is not strictly necessary. The difference would be that textView would be set to "" instead of "Default text", because getStringExtra would return null
        Bundle extras = yourIntentVariable.getExtras();

        //Depending on your project checking whether extras is not null, is not strictly necessary. If line 34 would be removed, the if-statement would have to be removed too, since there would be no variable 'extras'. Lines 38 en 39 should be preserved.
        if(extras != null) {
            String textToDisplay = yourIntentVariable.getStringExtra("yourUniqueIntentKey"); //This key should correspond to the key in line 27 of the FireMissilesDialogFragment class
            textView.setText(textToDisplay);
        }
    }
}
