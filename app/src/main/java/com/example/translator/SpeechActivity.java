package com.example.translator;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.Locale;
import android.widget.Toast;

public class SpeechActivity extends AppCompatActivity {

    TextToSpeech output;
    EditText txtSpeechInput;
    ImageButton btnTranslate;
    TextView txtSpeechOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech);
        setTitle("Speech Translation");

        txtSpeechInput = (EditText)findViewById(R.id.txtSpeechInput);
        txtSpeechOutput =  (TextView) findViewById(R.id.txtSpeechOutput);
        btnTranslate = (ImageButton)findViewById(R.id.btnTranslate);

        output = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    output.setLanguage(Locale.US);
                }
            }
        });

        /*txtSpeechInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER){
                    String toSpeak = txtSpeechInput.getText().toString();
                    Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    output.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    return true;
                }
                return false;
            }
        });*/

        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = txtSpeechInput.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                output.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }
    public void onPause(){
        if(output != null){
            output.stop();
            output.shutdown();
        }
        super.onPause();
    }
}
