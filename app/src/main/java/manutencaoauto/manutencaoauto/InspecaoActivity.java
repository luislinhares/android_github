package manutencaoauto.manutencaoauto;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by Linhares on 12-04-2016.
 */
public class InspecaoActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inspecao);

        DadosDoRegisto dadosDoRegisto = lerRegisto();
        mostrarDados(dadosDoRegisto);
    }

    private void mostrarDados(DadosDoRegisto dadosDoRegisto) {
        String mensagem = "Não foi possivel carregar os dados";
        if(dadosDoRegisto != null) {
            mensagem = dadosDoRegisto.toString();
        }
        TextView textViewDia = (TextView) findViewById(R.id.textViewDia);
        textViewDia.setText(mensagem);
    }

    private DadosDoRegisto lerRegisto() {
        try {
            return new RegistoDeDados(getApplicationContext().getFilesDir()).ler();
        } catch (IOException e) {
            System.err.println("Ocorreu eum erro ao ler o registo de dados.");
            e.printStackTrace();
        }
        return null;
    }

}
