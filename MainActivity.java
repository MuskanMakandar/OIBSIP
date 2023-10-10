package com.example.unit_converter;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private EditText valueInput;
    private Spinner unitSpinner;
    private Button convertButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueInput = findViewById(R.id.valueInput);
        unitSpinner = findViewById(R.id.unitSpinner);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.unit_options, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        unitSpinner.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertUnits();
            }
        });
    }


    private void convertUnits() {
        // Get input value and selected unit
        double inputValue = Double.parseDouble(valueInput.getText().toString());
        String selectedUnit = unitSpinner.getSelectedItem().toString();

        double result = 0.0;

        // Conversion logic
        switch (selectedUnit) {
            case "Centimeters to Meters":
                result = inputValue / 100;
                break;
            case "Meters to Centimeters":
                result = inputValue * 100;
                break;
            case "Grams to Kilograms":
                result = inputValue / 1000;
                break;
            case "Kilograms to Grams":
                result = inputValue * 1000;
                break;
        }

        // Set the result text
        resultText.setText(String.format("%.2f", result));

}
}
