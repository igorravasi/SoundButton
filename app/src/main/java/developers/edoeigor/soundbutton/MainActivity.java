package developers.edoeigor.soundbutton;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    boolean perla=false;
    MediaPlayer mp;
    String [] testi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button pulsante = (Button)findViewById(R.id.pulsante_0);
        final ConstraintLayout constID=(ConstraintLayout)findViewById(R.id.constID);
        mp = MediaPlayer.create(this, R.raw.audio);
        testi =  getResources().getStringArray(R.array.btn_array);

        pulsante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd = new Random();
                pulsante.setText(testi[rnd.nextInt(testi.length)]);

                if (mp.isPlaying()){
                    mp.pause();
                }
                mp.seekTo(0);
                mp.start();


                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                constID.setBackgroundColor(color);
                pulsante.setTextColor(color);
                pulsante.setBackgroundColor(negativeColor(color));

            }
        });

    }


    private int negativeColor(int colorSource){
        return Color.argb(255, 255-Color.red(colorSource), 255-Color.green(colorSource),255-Color.blue(colorSource));
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_VOLUME_DOWN){

            mp.start();

        }

        return true;
    }
}
