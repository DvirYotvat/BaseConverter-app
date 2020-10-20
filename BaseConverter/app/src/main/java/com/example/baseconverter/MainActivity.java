// Dvir Yotvat - MrRabbiT-coder

package com.example.baseconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

// the name of the Activity is not BaseConverterActivity cus the app don't run withe this name
//didn't find why this is happens
public class MainActivity extends AppCompatActivity {

    private TextView resText;
    private Button cmdButton;
    private TextView editbase10;
    private TextView editConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        cmdButton = (Button) findViewById(R.id.cmdButton);
        resText = (TextView) findViewById(R.id.resText);
        editbase10 = (TextView) findViewById(R.id.editbase10);
        editConvert = (TextView) findViewById(R.id.editConvert);

        // create a listener for the button
        cmdButton.setOnClickListener(new Listener());
    }
    // inner class that have the method "onClick" that chose what to do when the user push
    // the button
    public class Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // check if the user push the button
            if (v.getId() == cmdButton.getId()) {
                // if the user push the button check the follows...
                try {
                    int num = Integer.parseInt(editbase10.getText().toString());
                    int base = Integer.parseInt(editConvert.getText().toString());

                    // if the base < 2 the user get an error message and reset all user chose
                    if (base < 2) {
                        Toast.makeText(getApplicationContext(), "you cant convert lower base then 2", Toast.LENGTH_LONG).show();
                        resText.setText("result");
                        editConvert.setText("");
                        editbase10.setText("");
                    }
                    // if the base > 36 the user get an error message and reset all user chose
                    else if (base > 36) {
                        Toast.makeText(getApplicationContext(), "you cant convert higher base then 36", Toast.LENGTH_LONG).show();
                        resText.setText("result");
                        editConvert.setText("");
                        editbase10.setText("");
                    }
                    else
                        resText.setText(BaseConverter.convertFrom10(num, base));

                    // if the user don't pot a whole number the user get an error message and reset all user chose
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "please enter only whole numbers!!", Toast.LENGTH_LONG).show();
                    resText.setText("result");
                    editConvert.setText("");
                    editbase10.setText("");
                }
            }

        }
    }
}