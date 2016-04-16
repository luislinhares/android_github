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

import java.io.IOException;


/**
 * Created by Luis Carlos on 05/04/2016.
 */
public class RegistoActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registo);
        Spinner staticSpinner = (Spinner) findViewById(R.id.carro);


        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.carros, android.R.layout.simple_spinner_item);


        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        staticSpinner.setAdapter(staticAdapter);

        Spinner dynamicSpinner = (Spinner) findViewById(R.id.cor);

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
        buttonSalvarRegisto.setOnClickListener(new RegistarOnClickListener());

    }

    private class RegistarOnClickListener implements View.OnClickListener {

        EditText propriatrio = (EditText) findViewById(R.id.editTextPropriatarioNome);
        EditText matricula = (EditText) findViewById(R.id.editTextMatricula);
        EditText kilometros = (EditText) findViewById(R.id.editTextCor);
        Spinner carro =  (Spinner)findViewById(R.id.carro);
        Spinner cor =  (Spinner)findViewById(R.id.cor);

        @Override
        public void onClick(View v) {
            DadosDoRegisto dadosDoRegisto = new DadosDoRegisto();
            dadosDoRegisto.setProprietario(propriatrio.getText().toString());
            dadosDoRegisto.setMatricula(matricula.getText().toString());
            dadosDoRegisto.setKilometros(kilometros.getText().toString());
            dadosDoRegisto.setCarro(carro.getSelectedItem().toString());
            dadosDoRegisto.setCor(cor.getSelectedItem().toString());

            if(!validarInput(dadosDoRegisto)) {
                return;
            }

            efectuarRegisto(dadosDoRegisto);
            notificarRegisto();
        }

        private boolean validarInput(DadosDoRegisto dadosDoRegisto) {
            boolean valido = true;
            if (!isValid(dadosDoRegisto.getProprietario())) {
                propriatrio.setError("Requer nome");
                valido = false;
            }
            if (!isValid(dadosDoRegisto.getMatricula())) {
                matricula.setError("Requer matricula");
                valido = false;
            }
            if (!isValid(dadosDoRegisto.getKilometros())) {
                kilometros.setError("Requer Km atual");
                valido = false;
            }
            return valido;
        }

        private boolean isValid(String value) {
            return value != null && !value.isEmpty();
        }

        private void efectuarRegisto(DadosDoRegisto dadosDoRegisto) {
            try {
                new RegistoDeDados(getApplicationContext().getFilesDir()).gravar(dadosDoRegisto);
            } catch (IOException e) {
                System.err.println("Occorreu um erro durante a gravação dos dados do registo.");
                e.printStackTrace();
            }
        }

        private void notificarRegisto() {
            AlertDialog.Builder myAlert = new AlertDialog.Builder(RegistoActivity.this);
            myAlert.setMessage("Registado com Sucesso..")
                    .setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent mudar2 = new Intent(RegistoActivity.this, Result2.class);
                            startActivity(mudar2);
                        }
                    })
                    .setTitle("Bem Vindo..")
                    .setIcon(R.drawable.registar)
                    .create();

            myAlert.show();
        }
    }
}
