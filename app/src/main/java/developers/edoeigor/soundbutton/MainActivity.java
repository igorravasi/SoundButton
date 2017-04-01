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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button pulsante = (Button)findViewById(R.id.pulsante_0);
        final ConstraintLayout constID=(ConstraintLayout)findViewById(R.id.constID);
        mp = MediaPlayer.create(this, R.raw.audio);

        pulsante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pulsante.setText(getResources().getString(peerla_switch()));
                if (mp.isPlaying()){
                    mp.pause();
                }
                mp.seekTo(0);
                mp.start();
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                int colorN = Color.argb(255, 255-Color.red(color), 255-Color.green(color),255-Color.blue(color));
                constID.setBackgroundColor(color);
                pulsante.setTextColor(color);
                pulsante.setBackgroundColor(colorN);

            }
        });

    }

    private int peerla_switch(){
        perla = !perla;
        if(perla){
            return R.string.btn_text1;
        }else{
            return R.string.btn_text2;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_VOLUME_DOWN){

            mp.start();

        }

        return true;
    }
}
