package manutencaoauto.manutencaoauto;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.*;
import android.content.*;


//filha da class activity - representa a sua classe
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonEntrar = (Button) findViewById(R.id.buttonEntrar);
        buttonEntrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        Intent mudar = new Intent(MainActivity.this, Result.class);
        startActivity(mudar);
        }

    });
    }
}





