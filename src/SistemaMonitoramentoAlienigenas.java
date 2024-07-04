import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class SistemaMonitoramentoAlienigenas {
    private List<Alienigena> alienigenas = new ArrayList<>();
    private Map<String, Especie> registroEspecies = new HashMap<>();
    private int contadorIdAlienigena = 1;

    public void registrarEspecie(String nome, String planetaOrigem, int nivelBasePericulosidade) {
        registroEspecies.put(nome, new Especie(nome, planetaOrigem, nivelBasePericulosidade));
        System.out.println("Espécie " + nome + " registrada com sucesso.");
    }

    public void registrarAlienigena(String nome, String nomeEspecie, int nivelPericulosidade) {
        Especie especie = registroEspecies.get(nomeEspecie);
        if (especie != null) {
            Alienigena alienigena = new Alienigena(contadorIdAlienigena++, nome, especie, nivelPericulosidade, LocalDateTime.now());
            alienigenas.add(alienigena);
            System.out.println("Alienígena " + nome + " registrado com sucesso.");
        } else {
            System.out.println("Espécie " + nomeEspecie + " não encontrada.");
        }
    }

    public void gerarRelatorio() {
        System.out.println("=== Relatório de Entrada de Alienígenas ===");
        for (Alienigena alienigena : alienigenas) {
            alienigena.exibirDetalhes();
        }
    }

    public void exibirRankingPericulosidade() {
        System.out.println("=== Ranking de Periculosidade dos Alienígenas ===");
        alienigenas.stream()
                .sorted((a1, a2) -> Integer.compare(a2.getNivelPericulosidade() + a2.getEspecie().getNivelBasePericulosidade(), a1.getNivelPericulosidade() + a1.getEspecie().getNivelBasePericulosidade()))
                .forEach(Alienigena::exibirDetalhes);
    }

    public void exibirAlienigenasQuarentena() {
        System.out.println("=== Alienígenas em Quarentena ===");
        alienigenas.stream()
                .filter(Alienigena::isEmQuarentena)
                .forEach(Alienigena::exibirDetalhes);
    }

    public void exibirTodasEspecies() {
        System.out.println("=== Todas as Espécies ===");
        registroEspecies.values().forEach(especie -> {
            System.out.println("Nome: " + especie.getNome());
            System.out.println("Planeta de Origem: " + especie.getPlanetaOrigem());
            System.out.println("Nível Base de Periculosidade: " + especie.getNivelBasePericulosidade());
            System.out.println("===================================");
        });
    }

    public void exibirAlienigenasPorEspecie(String nomeEspecie) {
        System.out.println("=== Alienígenas da Espécie " + nomeEspecie + " ===");
        alienigenas.stream()
                .filter(alienigena -> alienigena.getEspecie().getNome().equals(nomeEspecie))
                .forEach(Alienigena::exibirDetalhes);
    }

    public void exibirAlienigenasUltimosSeisMeses() {
        System.out.println("=== Alienígenas que Entraram nos Últimos 6 Meses ===");
        alienigenas.stream()
                .filter(alienigena -> alienigena.getDataHoraEntrada().isAfter(LocalDateTime.now().minus(6, ChronoUnit.MONTHS)))
                .forEach(Alienigena::exibirDetalhes);
    }

}

