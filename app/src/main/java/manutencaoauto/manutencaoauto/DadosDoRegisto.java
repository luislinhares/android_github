package manutencaoauto.manutencaoauto;

public class DadosDoRegisto {
    private String proprietario;
    private String matricula;
    private String kilometros;
    private String carro;
    private String cor;

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getKilometros() {
        return kilometros;
    }

    public void setKilometros(String kilometros) {
        this.kilometros = kilometros;
    }

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DadosDoRegisto that = (DadosDoRegisto) o;

        if (!proprietario.equals(that.proprietario)) return false;
        if (!matricula.equals(that.matricula)) return false;
        if (!kilometros.equals(that.kilometros)) return false;
        if (!carro.equals(that.carro)) return false;
        return cor.equals(that.cor);

    }

    @Override
    public int hashCode() {
        int result = proprietario.hashCode();
        result = 31 * result + matricula.hashCode();
        result = 31 * result + kilometros.hashCode();
        result = 31 * result + carro.hashCode();
        result = 31 * result + cor.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "DadosDoRegisto{" +
                "proprietario='" + proprietario + '\'' +
                ", matricula='" + matricula + '\'' +
                ", kilometros='" + kilometros + '\'' +
                ", carro='" + carro + '\'' +
                ", cor='" + cor + '\'' +
                '}';
    }
}
