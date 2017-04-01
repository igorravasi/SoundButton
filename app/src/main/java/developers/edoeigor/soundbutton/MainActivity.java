package developers.edoeigor.soundbutton;

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

        pulsante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!perla){
                    pulsante.setText(getResources().getString(R.string.btn_text));
                    perla=true;
                }
                else{
                    pulsante.setText("Cojone");
                    perla=false;
                }

            }
        });

    }
}
