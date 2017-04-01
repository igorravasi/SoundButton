package developers.edoeigor.soundbutton;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    boolean perla=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button pulsante = (Button)findViewById(R.id.pulsante_0);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.audio);

        pulsante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pulsante.setText(getResources().getString(peerla_switch()));
                mp.start();
            }
        });

    }

    //ciao

    private int peerla_switch(){
        perla = !perla;
        if(perla){
            return R.string.btn_text1;
        }else{
            return R.string.btn_text2;
        }
    }

}
