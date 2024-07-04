import java.time.LocalDateTime;

public class Alienigena {
    private int id;
    private String nome;
    private Especie especie;
    private int nivelPericulosidade;
    private LocalDateTime dataHoraEntrada;
    private boolean emQuarentena;

    public Alienigena(int id, String nome, Especie especie, int nivelPericulosidade, LocalDateTime dataHoraEntrada) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.nivelPericulosidade = nivelPericulosidade;
        this.dataHoraEntrada = dataHoraEntrada;
        this.emQuarentena = avaliarPericulosidade(nivelPericulosidade);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Especie getEspecie() {
        return especie;
    }

    public int getNivelPericulosidade() {
        return nivelPericulosidade;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public boolean isEmQuarentena() {
        return emQuarentena;
    }

    private boolean avaliarPericulosidade(int nivelPericulosidade) {
        return (nivelPericulosidade + especie.getNivelBasePericulosidade()) > 5;
    }

    public void exibirDetalhes() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Espécie: " + especie.getNome());
        System.out.println("Nível de Periculosidade: " + nivelPericulosidade);
        System.out.println("Data/Hora de Entrada: " + dataHoraEntrada);
        System.out.println("Em Quarentena: " + (emQuarentena ? "Sim" : "Não"));
        System.out.println("===================================");
    }
}
