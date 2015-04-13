package com.example.ronmel.cookbook;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Locale;


public class MainActivity extends ActionBarActivity implements
        TextToSpeech.OnInitListener {

    private TextToSpeech tts;
    private Button btnSpeak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tts = new TextToSpeech(this, this);

        btnSpeak = (Button) findViewById(R.id.button);
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }


    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                btnSpeak.setEnabled(true);
                speakOut();
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }

    }

    private void speakOut() {
        tts.speak("I'm a Barbie girl, in the Barbie world" +
                "Life in plastic, it's fantastic!" +
                "You can brush my hair, undress me everywhere" +
                "Imagination, life is your creation" +
                "Come on Barbie, let's go party!" +
                "" +
                "I'm a Barbie girl, in the Barbie world" +
                "Life in plastic, it's fantastic!" +
                "You can brush my hair, undress me everywhere" +
                "Imagination, life is your creation" +
                "" +
                "I'm a blond bimbo girl, in a fantasy world" +
                "Dress me up, make it tight, I'm your dolly" +
                "You're my doll, rock'n'roll, feel the glamour in pink," +
                "Kiss me here, touch me there, hanky panky..." +
                "You can touch, you can play, if you say: I'm always yours", TextToSpeech.QUEUE_FLUSH, null,"1");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
