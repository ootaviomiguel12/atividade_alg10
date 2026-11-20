import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

public static void main(String[] args) {
    redeDeLojas();
    vagaDeEstacionamento();
    controleDeEstoque();
    competicaoDeSalto();
    mapaDoCinema();

    scan.close();
    }

    //1-Uma rede de lojas deseja registrar as vendas realizadas durante uma semana.
    public static void redeDeLojas (){

        double [][] vendas = new double[7][3];
        double [] totalPorProduto = new double[3];
        double [] totalPorDia = new double[7];
        double faturamentoSemanal = 0;

        int indiceMelhorDia = 0, indiceMelhorProduto = 0;


        for (int i = 0; i < vendas.length; i++){

            for (int j = 0; j < vendas[i].length; j++){

                System.out.println("Digite as vendas do dia " + (i + 1) + " do produto: " + (j + 1));
                double valor = scan.nextDouble();
                totalPorProduto[j] += valor;
                totalPorDia[i] += valor;
                faturamentoSemanal += valor;
                vendas[i][j] = valor;
            }
        }

        for (int i = 0; i < totalPorDia.length; i++){
            if (totalPorDia[indiceMelhorDia] < totalPorDia[i]){
                indiceMelhorDia = i;
            }
        }
        for (int i = 0; i < totalPorProduto.length; i++){
            if (totalPorProduto[indiceMelhorProduto] < totalPorProduto[i]){
                indiceMelhorProduto = i;
            }
        }


        for (int i = 0; i < totalPorProduto.length; i++) {
            System.out.printf("Total vendido do produto %d: R$ %.2f%n", (i + 1), totalPorProduto[i]);
        }

        for (int i = 0; i < totalPorDia.length; i++) {
            System.out.printf("Total do dia %d: R$ %.2f%n", (i + 1), totalPorDia[i]);
        }

        System.out.printf("O produto com mais vendas foi: %d. E o faturamento foi de: R$ %.2f%n",
                (indiceMelhorProduto + 1), totalPorProduto[indiceMelhorProduto]);

        System.out.printf("O melhor dia de vendas foi: %d. E o volume foi de: R$ %.2f%n",
                (indiceMelhorDia + 1), totalPorDia[indiceMelhorDia]);

        System.out.printf("O faturamento semanal foi: R$ %.2f%n", faturamentoSemanal);

    }

    //2- Um estacionamento possui 5 fileiras com 10 vagas cada.
    public static void vagaDeEstacionamento (){

    int [][] estacionamento = new int[5][10];

    final int LIVRE = 0, OCUPADO = 1;


        int escolha;

        do {
            System.out.println("Menu do Estacionamento");
            System.out.println("Pressione um número de 1 a 6:");
            System.out.println("1. Consultar o mapa de vagas.");
            System.out.println("2. Descobrir quantas vagas livres existem.");
            System.out.println("3. Descobrir quantas vagas estão ocupadas.");
            System.out.println("4. Exibir a fileira com maior número de veículos estacionados.");
            System.out.println("5. Alterar o estado da vaga.");
            System.out.println("6. Encerrar o sistema.");

            escolha = scan.nextInt();

            switch (escolha){
                case 1:
                    System.out.println("Mapa de vagas: ");
                    for (int i = 0; i < estacionamento.length; i++){
                        for (int j = 0; j < estacionamento[i].length; j++){
                            System.out.print(estacionamento[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    int contadorVagasLivres = 0;

                    for (int i = 0; i < estacionamento.length; i++){
                        for (int j = 0; j < estacionamento[i].length; j++){
                            if (estacionamento[i][j] == LIVRE){
                                contadorVagasLivres++;
                            }
                        }
                    }
                    System.out.println("O total de vagas livres é de: " + contadorVagasLivres);
                    break;

                case 3: int contadorVagasOcupadas = 0;

                for (int i = 0; i < estacionamento.length; i++){
                    for (int j = 0; j < estacionamento[i].length; j++){
                        if (estacionamento[i][j] == OCUPADO){
                            contadorVagasOcupadas++;
                        }
                    }
                }
                    System.out.println("O total de vagas ocupadas é de: " + contadorVagasOcupadas);
                    break;

                case 4:
                    int indiceMelhorFileira = 0, maiorQtdOcupadas = -1;

                    for (int i = 0; i < estacionamento.length; i++){
                        int vagasOcupadasNaFileira = 0;

                        for (int j = 0; j < estacionamento[i].length; j++){
                            if (estacionamento[i][j] == OCUPADO){
                                vagasOcupadasNaFileira++;
                            }
                        }
                        if (vagasOcupadasNaFileira > maiorQtdOcupadas){
                            maiorQtdOcupadas = vagasOcupadasNaFileira;
                            indiceMelhorFileira = i;
                        }
                    }
                    if (maiorQtdOcupadas == 0){
                        System.out.println("Nenhum veículo estacionado.");
                    }
                    else {
                        System.out.println("A fileira com mais veículos é: " + (indiceMelhorFileira + 1));
                        System.out.println("A quantidade de vagas ocupadas nessa fileira é: " + maiorQtdOcupadas);
                    }
                    break;

                case 5:
                    System.out.println("Escolha o numero da fileira (1 a 5): ");
                    int fileira = scan.nextInt() - 1;

                    System.out.println("Escolha o numero da vaga (1 a 10): ");
                    int vaga = scan.nextInt() - 1;

                    if (fileira >= 0 && fileira < estacionamento.length
                            && vaga >= 0 && vaga < estacionamento[0].length){
                        if (estacionamento[fileira][vaga] == LIVRE){
                            estacionamento[fileira][vaga] = OCUPADO;
                            System.out.println("A vaga agora está ocupada.");
                        }
                        else {
                            estacionamento[fileira][vaga] = LIVRE;
                            System.out.println("A vaga agora está livre.");
                        }

                    }
                    else {
                        System.out.println("Fileira ou vaga inválidas.");
                    }

                    break;

                case 6:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (escolha != 6);

    }

    //3-Uma empresa possui 10 produtos distribuídos em 4 depósitos.
    public static void controleDeEstoque(){

        int [][] estoque = new int[10][4];

        int [] totalPorProduto = new int[estoque.length];

        int [] totalPorDeposito = new int[estoque[0].length];

        int indiceMaiorDeposito = 0, indiceMaiorProduto = 0;

        for (int i = 0; i < estoque.length; i++){

            for (int j = 0; j < estoque[i].length; j++){
                System.out.println("Digite a quantidade do produto: " + (i + 1) + " no depósito: " + (j + 1));
                int qtdProduto = scan.nextInt();
                estoque[i][j] = qtdProduto;
                totalPorProduto[i] += qtdProduto;
                totalPorDeposito[j] += qtdProduto;
            }
        }
        for (int i = 1; i < totalPorProduto.length; i++){
            if (totalPorProduto[indiceMaiorProduto] < totalPorProduto[i]){
                indiceMaiorProduto = i;
            }
        }
        for (int i = 1; i < totalPorDeposito.length; i++){
            if (totalPorDeposito[indiceMaiorDeposito] < totalPorDeposito[i]){
                indiceMaiorDeposito = i;
            }
        }

        for (int i = 0; i < totalPorProduto.length; i++) {
            System.out.println("O estoque total do produto " + (i + 1)+ " é: " + totalPorProduto[i]);
        }

        for (int i = 0; i < totalPorDeposito.length; i++){
            System.out.println("O estoque total do depósito " + (i + 1) + " é: " + totalPorDeposito[i]);
        }

        System.out.println("Produto com maior quantidade armazenada: " + (indiceMaiorProduto + 1)
                + " (" + totalPorProduto[indiceMaiorProduto] + " unidades)");

        System.out.println("Depósito com maior volume de estoque: " + (indiceMaiorDeposito + 1)
                + " (" + totalPorDeposito[indiceMaiorDeposito] + " unidades)");

    }

    //4-Uma competição possui 10 atletas que realizaram 3 tentativas de salto.
    public static void competicaoDeSalto() {

        double[][] saltos = new double[10][3];
        double[] melhorSalto = new double[saltos.length];
        double[] mediaSaltos = new double[saltos.length];
        int[] ranking = new int[saltos.length];

        for (int i = 0; i < saltos.length; i++) {
            double somaAtleta = 0;
            melhorSalto[i] = -1;
            ranking[i] = i;

            for (int j = 0; j < saltos[i].length; j++) {
                System.out.println("Digite a distância do salto " + (j + 1) + " do atleta " + (i + 1));
                double distanciaDoSalto = scan.nextDouble();
                somaAtleta += distanciaDoSalto;
                saltos[i][j] = distanciaDoSalto;

                if (distanciaDoSalto > melhorSalto[i]) {
                    melhorSalto[i] = distanciaDoSalto;
                }
            }
            mediaSaltos[i] = somaAtleta / saltos[i].length;
        }

        System.out.println("\n--- RESULTADOS POR ATLETA ---");
        for (int i = 0; i < saltos.length; i++) {
            System.out.printf("Atleta %d - Melhor salto: %.2fm | Média: %.2fm%n",
                    (i + 1), melhorSalto[i], mediaSaltos[i]);
        }

        // Ordena o ranking do maior para o menor salto
        for (int i = 0; i < ranking.length - 1; i++) {
            for (int j = i + 1; j < ranking.length; j++) {
                if (melhorSalto[ranking[i]] < melhorSalto[ranking[j]]) {
                    int temp = ranking[i];
                    ranking[i] = ranking[j];
                    ranking[j] = temp;
                }
            }
        }

        int indiceCampeao = ranking[0];
        System.out.printf("%nCampeão: Atleta %d com salto de %.2fm%n",
                (indiceCampeao + 1), melhorSalto[indiceCampeao]);

        System.out.println("\nRANKING FINAL");
        for (int i = 0; i < ranking.length; i++) {
            int atletaIdx = ranking[i];
            System.out.printf("%dº lugar: Atleta %d - Melhor salto: %.2fm%n",
                    (i + 1), (atletaIdx + 1), melhorSalto[atletaIdx]);
        }
    }

    //5-Um cinema possui 8 fileiras com 6 cadeiras cada
    public static void mapaDoCinema(){

    int [][] salaDeCinema = new int[8][6];

        final int DISPONIVEL = 0, OCUPADO = 1;

        int totalLugares = salaDeCinema.length * salaDeCinema[0].length;

        int escolha, fileira, cadeira;

        int assentosOcupados = 0;

        do {
            System.out.println("Menu do Cinema");
            System.out.println("Pressione um número de 1 a 6:");
            System.out.println("1. Consultar o mapa de cadeiras.");
            System.out.println("2. Reservar uma cadeira.");
            System.out.println("3. Cancelar uma reserva");
            System.out.println("4. Exibir taxa de ocupação do cinema.");
            System.out.println("5. Exibir quantos lugares ainda estão disponíveis.");
            System.out.println("6. Encerrar o sistema.");

            escolha = scan.nextInt();

            switch (escolha){
                case 1:
                    System.out.println("Mapa de cadeiras: ");
                    for (int i = 0; i < salaDeCinema.length; i++){
                        for (int j = 0; j < salaDeCinema[i].length; j++){
                            System.out.print(salaDeCinema[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.println("Digite a fileira que quer selecionar: ");
                    fileira = scan.nextInt() - 1;

                    System.out.println("Digite a cadeira que deseja selecionar: ");
                    cadeira = scan.nextInt() - 1;

                    if (fileira >= 0 && fileira < salaDeCinema.length
                            && cadeira >= 0 && cadeira < salaDeCinema[0].length){

                        if (salaDeCinema[fileira][cadeira] == DISPONIVEL){
                            salaDeCinema[fileira][cadeira] = OCUPADO;
                            assentosOcupados++;
                            System.out.println("Reserva realizada com sucesso.");
                        }
                        else {
                            System.out.println("Essa cadeira já está ocupada.");
                        }
                    }
                    else {
                        System.out.println("Fileira ou cadeira inválida.");
                    }
                    break;

                case 3:

                    System.out.println("Digite a fileira que quer selecionar: ");
                    fileira = scan.nextInt() - 1;

                    System.out.println("Digite a cadeira que deseja selecionar: ");
                    cadeira = scan.nextInt() - 1;


                    if (fileira >= 0 && fileira < salaDeCinema.length
                            && cadeira >= 0 && cadeira < salaDeCinema[0].length) {
                        if (salaDeCinema[fileira][cadeira] == OCUPADO) {
                            salaDeCinema[fileira][cadeira] = DISPONIVEL;
                            assentosOcupados--;
                            System.out.println("Reserva cancelada com sucesso.");
                        } else {
                            System.out.println("Essa cadeira já está disponível, não há reserva a ser cancelada");
                        }
                    }
                    else {
                        System.out.println("Fileira ou cadeira inválida.");
                    }
                    break;

                case 4:

                    double taxaDeOcupacao = ((double) assentosOcupados / totalLugares) * 100;
                    System.out.printf("Taxa de ocupação: %.2f%%%n", taxaDeOcupacao);
                    break;

                case 5:

                    System.out.println("O total de lugares disponíveis é: ");
                    System.out.println(totalLugares - assentosOcupados);
                    break;

                case 6:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (escolha != 6);
    }
}
