package Stop.model;

import java.util.Timer;
import java.util.TimerTask;

import Stop.model.Jogador;

public class StopTimerTask extends TimerTask {
    private int timeLimit;
    private Jogador jogador;
    private Timer timer;

    public StopTimerTask(int timeLimit, Jogador jogador, Timer timer) {
        this.timeLimit = timeLimit;
        this.jogador = jogador;
        this.timer = timer;
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
            timer.cancel();
            System.exit(0);
        }
    }
}
