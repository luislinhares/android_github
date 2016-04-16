package manutencaoauto.manutencaoauto;

/**
 * Created by teste on 10/04/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


/**
 * Created by teste on 09/04/2016.
 */
public class Result2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manutencao);


        final ImageButton imageButtonInspecao = (ImageButton) findViewById(R.id.imageButton1);
        final ImageButton imageButtonAjuda = (ImageButton) findViewById(R.id.imageButtonAjuda);
        imageButtonInspecao.setOnClickListener(new View.OnClickListener() {
            protected void onCreate(Bundle savedInstanceState) {
                setContentView(R.layout.registo);
            }

            @Override
            public void onClick(View v) {

                
                Intent mudar3 = new Intent(Result2.this, InspecaoActivity.class);
                imageButtonInspecao.equals("imageButton1");
                startActivity(mudar3);
                //imageButtonAjuda.equals("imagemButtonAjuda");
                //Intent mudarAjuda = new Intent(Result2.this, ResultAjuda.class);
                //startActivity(mudarAjuda);
               }
        });
    }
}