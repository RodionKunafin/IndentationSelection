package com.example.indentationselection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    Button btnOk;
    TextView textView;
    String mLanguage[] = {"ru", "en"};
    Spinner indentation;
    Button btnOkForIndentation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        spinner = findViewById(R.id.spinner);
        btnOk = findViewById(R.id.btnOk);
        textView = findViewById(R.id.textView);
        indentation = findViewById(R.id.indentation);
        btnOkForIndentation = findViewById(R.id.btnOkForIndentation);
        initSpinner();




        btnOkForIndentation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (indentation.getSelectedItemPosition()){
                    case 0:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_MARGIN1);
                        break;
                    case 1:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_MARGIN2);
                        break;
                    case 2:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_MARGIN3);
                        break;
                }

            }
        });



        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale locale = new Locale(mLanguage[spinner.getSelectedItemPosition()]);
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                textView.setText(R.string.textView);
                recreate();
            }
        });

    }

    private void initSpinner() {
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition, long selectedId) {
                String[] languages = getResources().getStringArray(R.array.languages);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> adapterIndentation = ArrayAdapter.createFromResource(this, R.array.indentation, android.R.layout.simple_spinner_item);
        adapterIndentation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        indentation.setAdapter(adapterIndentation);

        indentation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] indentation = getResources().getStringArray(R.array.indentation);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }


}

