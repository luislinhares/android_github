package manutencaoauto.manutencaoauto;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * Created by Luis Carlos on 05/04/2016.
 */
public class Result extends Activity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registo);
        Spinner staticSpinner = (Spinner) findViewById(R.id.static_spinner);


        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.carros,
                        android.R.layout.simple_spinner_item);


        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        staticSpinner.setAdapter(staticAdapter);

        Spinner dynamicSpinner = (Spinner) findViewById(R.id.dropdownList);

        String[] items = new String[] { "Cor", "Preto", "Branco", "Azul" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, items);

        dynamicSpinner.setAdapter(adapter);

        dynamicSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }

        });


        Button buttonSalvarRegisto = (Button) findViewById(R.id.buttonSalvarRegisto);
        buttonSalvarRegisto.setOnClickListener(new View.OnClickListener() {
            EditText propriatrioNome = (EditText) findViewById(R.id.editTextPropriatarioNome);
            EditText carroMatricula = (EditText) findViewById(R.id.editTextMatricula);
            EditText carroKm = (EditText) findViewById(R.id.editTextCor);
            @Override
            public void onClick(View v) {

                if (propriatrioNome.getText().toString().length() == 0)
                    propriatrioNome.setError("Requer nome");
                if (carroMatricula.getText().toString().length() == 0)
                    carroMatricula.setError("Requer matricula");
                if (carroKm.getText().toString().length() == 0)
                    carroKm.setError("Requer Km atual");


                else {
                    AlertDialog.Builder myAlert = new AlertDialog.Builder(Result.this);
                    myAlert.setMessage("Registado com Sucesso..")
                            .setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent mudar2 = new Intent(Result.this, Result2.class);
                                    startActivity(mudar2);
                                }
                            })
                            .setTitle("Bem Vindo..")
                            .setIcon(R.drawable.registar)
                            .create();

                    myAlert.show();
                }
            }

        });

    }

}
