package com.example.translator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import org.tensorflow.lite.Interpreter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Text Translation");
        final TextView txtTextInput =  (TextView) findViewById(R.id.txtTextInput);
        final EditText txtInput = (EditText)findViewById(R.id.txtInput);
        ImageButton btnSpeak = (ImageButton)findViewById(R.id.btnSpeak);

        txtInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER)
                {
                    txtTextInput.setText(txtInput.getText());
                    return true;
                }
                return false;
            }
        });
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSpeechActivity();
            }
        });

    }

    public void openSpeechActivity() {
        Intent intent = new Intent(this, SpeechActivity.class);
        startActivity(intent);
    }
}
