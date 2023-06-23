package Stop;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import Stop.model.Jogador;
import Stop.model.JogadorMult;
import Stop.model.Categoria;
import Stop.model.StopTimerTask;

public class Main {
    private static final int Facil = 240; // modo facil
    private static final int Medio = 150; // modo medio
    private static final int Dificil = 100; // modo dificil
    private static final int Hardcore = 60; // modo muito dificil

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vamos cadastrar o jogador");
        System.out.println();
        Jogador jogador1 = cadastrarJogador(scanner);

        System.out.print("Informe o número de categorias para o stop: ");
        int numcat = scanner.nextInt();
        scanner.nextLine();

        String[] categorias = new String[numcat];
        for (int i = 0; i < numcat; i++) {
            System.out.print("Insira o nome da categoria: ");
            String nomeCategoria = scanner.nextLine();
            categorias[i] = nomeCategoria;
        }

        Random random = new Random();
        char letra = (char) (random.nextInt(26) + 'A');
        System.out.println("O stop é: " + letra);

        String[] respostas = new String[numcat];
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int timeLimit = getTimeLimit(numcat);

            @Override
            public void run() { // comando do tempo
                if (timeLimit > 0) {
                    timeLimit = timeLimit - 1;

                    if (timeLimit % 15 == 0) {
                        System.out.println("\nTempo restante: " + timeLimit + " segundos");

                    }

                    jogador1.setTempo(timeLimit);
                } else {
                    System.out.println("Tempo esgotado!");
                    timer.cancel();
                    scanner.close();
                    System.exit(0);
                }
            }

        };

        timer.scheduleAtFixedRate(task, 1000, 1000);

        for (int j = 0; j < numcat; j++) {
            System.out.print(categorias[j] + ": ");
            String resposta = scanner.nextLine();
            respostas[j] = resposta;
        }
        timer.cancel();

        System.out.println("Stoppp, Parabens você ganhou, chegou no pódio");
        System.out.print("Tem mais um jogador para jogar? 1- Sim 2- Não\n");
        int x = scanner.nextInt();

        if (x == 1) {
            scanner.nextLine(); // inicio para o jogador 2
            System.out.println("informe a confimação:");

            System.out.println("Vamos cadastrar o segundo jogador");
            System.out.println();
            Jogador jogador2 = cadastrarJogador(scanner);

            System.out.println("O stop é: " + letra);
            System.out.println("Não pode usar as mesmas respostas do primeiro jogador");
            String[] respostas2 = new String[numcat];
            Timer timer2 = new Timer();
            TimerTask task2 = new TimerTask() {
                int timeLimit2 = getTimeLimit(numcat);

                @Override
                public void run() { // tempo
                    if (timeLimit2 > 0) {

                        timeLimit2 = timeLimit2 - 1;

                        if (timeLimit2 % 15 == 0) {
                            System.out.println("\nTempo restante: " + timeLimit2 + " segundos");

                        }
                        jogador2.setTempo(timeLimit2);
                    } else {
                        System.out.println("Tempo esgotado!");
                        timer.cancel();
                        scanner.close();
                        System.exit(0);
                    }
                }
            };

            timer2.scheduleAtFixedRate(task2, 1000, 1000);

            for (int j = 0; j < numcat; j++) {
                System.out.print(categorias[j] + ": ");
                String resposta = scanner.nextLine();
                respostas2[j] = resposta;
            }

            timer2.cancel();

            System.out.println("Stoppp, Parabens vocês terminaram!");

            if (jogador1.getTempo() > jogador2.getTempo()) {
                System.out.println("O jogador " + jogador1.getNome() + "! Venceu com o melhor tempo!");
            } else if (jogador1.getTempo() < jogador2.getTempo()) {
                System.out.println("O jogador " + jogador2.getNome() + "! Venceu com o melhor tempo!");
            } else {
                System.out.println("Empate! Ambos os jogadores tiveram o mesmo tempo.");
            }
        } else {
            System.out.println("O jogador " + jogador1.getNome() + " teve o tempo de " + jogador1.getTempo() + " segundos");
        }

        scanner.close();
    }

    private static Jogador cadastrarJogador(Scanner scanner) { // class jogador
        System.out.println("Informe o Nome do jogador: ");
        String nome = scanner.nextLine();

        System.out.println("Informe o Apelido do jogador: ");
        String apelido = scanner.nextLine();

        System.out.println("Informe a Data de Nascimento (dd/mm/aa): ");
        String nascimento = scanner.nextLine();

        System.out.println("Informe o Sexo (Masculino, Feminino, Outro): ");
        String sexo = scanner.nextLine();
        int tempo = 0;
        return new JogadorMult(nome, apelido, nascimento, sexo, tempo);

    }

    private static int getTimeLimit(int numcat) { // modo da dificuldade
        int timeLimit;
        if (numcat <= 2) {
            timeLimit = Facil;
        } else if (numcat <= 4) {
            timeLimit = Medio;
        } else if (numcat <= 8) {
            timeLimit = Dificil;
        } else {
            timeLimit = Hardcore;
        }

        return timeLimit;
    }
}