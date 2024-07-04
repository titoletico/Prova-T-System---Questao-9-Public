public class Especie {
    private String nome;
    private String planetaOrigem;
    private int nivelBasePericulosidade;

    public Especie(String nome, String planetaOrigem, int nivelBasePericulosidade) {
        this.nome = nome;
        this.planetaOrigem = planetaOrigem;
        this.nivelBasePericulosidade = nivelBasePericulosidade;
    }

    public String getNome() {
        return nome;
    }

    public String getPlanetaOrigem() {
        return planetaOrigem;
    }

    public int getNivelBasePericulosidade() {
        return nivelBasePericulosidade;
    }
}

