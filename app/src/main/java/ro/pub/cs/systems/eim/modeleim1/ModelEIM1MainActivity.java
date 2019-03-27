package ro.pub.cs.systems.eim.modeleim1;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Console;

public class ModelEIM1MainActivity extends AppCompatActivity {
    private Button button1 = null;
    private Button button2 = null;
    private EditText number1 = null;
    private EditText number2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_eim1_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        Log.e("e","here");

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("number1_count")) {
                number1.setText(savedInstanceState.getString("number1_count"));
            } else {
                number1.setText("0");
            }
            if (savedInstanceState.containsKey("number2_count")) {
                number2.setText(savedInstanceState.getString("number2_count"));
            } else {
                number2.setText("0");
            }
        } else {
            number1.setText("0");
            number2.setText("0");
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = Integer.valueOf(number1.getText().toString());
                number1.setText(String.valueOf(value + 1));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = Integer.valueOf(number2.getText().toString());
                number2.setText(String.valueOf(value + 1));
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle persistentState) {
        Log.e("e","here2");
        outState.putString("number1_count", number1.getText().toString());
        outState.putString("number2_count", number2.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        if (savedInstanceState.containsKey("number1_count")) {
            number1.setText(savedInstanceState.getString("number1_count"));
        } else {
            number1.setText("0");
        }
        if (savedInstanceState.containsKey("number2_count")) {
            number2.setText(savedInstanceState.getString("number2_count"));
        } else {
            number2.setText("0");
        }
    }
}
