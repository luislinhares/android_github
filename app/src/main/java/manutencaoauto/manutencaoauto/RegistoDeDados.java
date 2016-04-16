package manutencaoauto.manutencaoauto;

import android.support.annotation.NonNull;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RegistoDeDados {

    private static final String FICHEIRO_DE_DADOS = "dados_da_apo.json";
    private final File directoria;

    public RegistoDeDados(File directoria) throws IOException {
        this.directoria = directoria;
        File file = getFile();
        if(!file.exists()) {
            file.createNewFile();
        }
    }

    public void gravar(DadosDoRegisto dadosDoRegisto) throws IOException {
        FileWriter fileWriter = new FileWriter(getFile());
        fileWriter.write(new Gson().toJson(dadosDoRegisto));
        fileWriter.close();
    }

    public DadosDoRegisto ler() throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(getFile()));
        String json = fileReader.readLine();
        fileReader.close();
        return new Gson().fromJson(json, DadosDoRegisto.class);
    }

    @NonNull
    private File getFile() {
        return new File(directoria, FICHEIRO_DE_DADOS);
    }

}
