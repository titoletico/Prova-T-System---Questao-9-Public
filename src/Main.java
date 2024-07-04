import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaMonitoramentoAlienigenas sistema = new SistemaMonitoramentoAlienigenas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Sistema de Monitoramento de Alienígenas");
            System.out.println("1. Registrar Espécie");
            System.out.println("2. Registrar Alienígena");
            System.out.println("3. Gerar Relatório");
            System.out.println("4. Exibir Ranking de Periculosidade");
            System.out.println("5. Exibir Alienígenas em Quarentena");
            System.out.println("6. Exibir Todas as Espécies");
            System.out.println("7. Exibir Alienígenas por Espécie");
            System.out.println("8. Exibir Alienígenas que Entraram nos Últimos 6 Meses");
            System.out.println("9. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome da espécie:");
                    String nomeEspecie = scanner.nextLine();
                    System.out.println("Digite o planeta de origem:");
                    String planetaOrigem = scanner.nextLine();
                    System.out.println("Digite o nível base de periculosidade:");
                    int nivelBasePericulosidade = scanner.nextInt();
                    sistema.registrarEspecie(nomeEspecie, planetaOrigem, nivelBasePericulosidade);
                    break;
                case 2:
                    System.out.println("Digite o nome do alienígena:");
                    String nomeAlienigena = scanner.nextLine();
                    System.out.println("Digite o nome da espécie:");
                    String nomeEspecieAlienigena = scanner.nextLine();
                    System.out.println("Digite o nível de periculosidade:");
                    int nivelPericulosidade = scanner.nextInt();
                    sistema.registrarAlienigena(nomeAlienigena, nomeEspecieAlienigena, nivelPericulosidade);
                    break;
                case 3:
                    sistema.gerarRelatorio();
                    break;
                case 4:
                    sistema.exibirRankingPericulosidade();
                    break;
                case 5:
                    sistema.exibirAlienigenasQuarentena();
                    break;
                case 6:
                    sistema.exibirTodasEspecies();
                    break;
                case 7:
                    System.out.println("Digite o nome da espécie:");
                    String pesquisaEspecie = scanner.nextLine();
                    sistema.exibirAlienigenasPorEspecie(pesquisaEspecie);
                    break;
                case 8:
                    sistema.exibirAlienigenasUltimosSeisMeses();
                    break;
                case 9:
                    System.out.println("Saindo do programa...");
                    return;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }
}