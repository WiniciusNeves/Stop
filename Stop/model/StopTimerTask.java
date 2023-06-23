package Stop.model;

import java.util.TimerTask;

public class StopTimerTask extends TimerTask {
    private int timeLimit;
    private Jogador jogador;

    public StopTimerTask(int timeLimit, Jogador jogador) {
        this.timeLimit = timeLimit;
        this.jogador = jogador;
    }

    @Override
    public void run() {
        if (timeLimit > 0) {
            timeLimit = timeLimit - 1;

            if (timeLimit % 15 == 0) {
                System.out.println("\nTempo restante: " + timeLimit + " segundos");
            }

            jogador.setTempo(timeLimit);
        } else {
            System.out.println("Tempo esgotado!");
            cancel();
            System.exit(0);
        }
    }
}