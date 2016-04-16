package manutencaoauto.manutencaoauto;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

import java.io.File;

import static junit.framework.Assert.assertEquals;

public class RegistoDeDadosTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testGravarLer() throws Exception {

        DadosDoRegisto dadosIniciais = new DadosDoRegisto();
        dadosIniciais.setProprietario("Luis Carlos");
        dadosIniciais.setMatricula("65-18-OG");
        dadosIniciais.setKilometros("100000");
        dadosIniciais.setCarro("Audi");
        dadosIniciais.setCor("Azul");

        RegistoDeDados registoDeDados = new RegistoDeDados(folder.getRoot());

        registoDeDados.gravar(dadosIniciais);
        DadosDoRegisto dadosFinais = registoDeDados.ler();

        assertEquals(dadosFinais, dadosIniciais);
    }

}
