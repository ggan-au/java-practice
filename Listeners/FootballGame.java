import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class FootballGame extends Thread {

    private static final AtomicInteger threadCounter = new AtomicInteger(0);
    private String homeTeam, awayTeam;
    private int homeScore, awayScore;
    private int myThreadNumber;
    private List<IFootballListener> listeners;

    public FootballGame(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.listeners = new ArrayList<>();
        myThreadNumber = threadCounter.incrementAndGet();
    }

    @Override
    public void run() {
        System.out.println("Thread " + myThreadNumber + " Started");
        beginGame();
    }

    public void beginGame() {
        System.out.println("GAME HAS STARTED");
        notifyListenersAboutGameStarted();
        for (int gameMinutes = 0; gameMinutes <= 90; gameMinutes++) {
            System.out.println(".");
            sleep(100);
            if (gameMinutes == 45) {
                notifyListenersAboutHalfTimeStarted();
                System.out.println("---------------------------");
                System.out.println("----HALF TIME - STARTED ---");
                sleep(500);
                System.out.println("---------------------------");
                System.out.println("----HALF TIME - ENDED -----");
                System.out.println("---------------------------");
                notifyListenersAboutHalfTimeEnded();
            }
            if (isScore(gameMinutes)) {
                if (isGoalHost()) {
                    this.homeScore++;
                    System.out.println("HOME TEAM: " + homeTeam + " HAS SCORED!!");
                } else {
                    this.awayScore++;
                    System.out.println("AWAY TEAM: " + awayTeam + " HAS SCORED!!");
                }
                notifyListenersAboutGoalScored();
            }
        }
        System.out.println("GAME HAS ENDED");
        System.out.println("SCORE: HOME - " + homeScore + "|| AWAY - " + awayScore);
        String winner = homeScore > awayScore ? "HOME TEAM WINS" : homeScore == awayScore ? "DRAW" : "AWAY TEAM WINS";
        System.out.println(winner);
        notifyListenersAboutGameEnded();
    }

    public void addListeners(IFootballListener... listeners) {
        this.listeners.addAll(Arrays.asList(listeners));
    }

    private void notifyListenersAboutGameStarted() {
        for (IFootballListener listener : this.listeners) {
            listener.gameStarted(this);
        }
    }

    private void notifyListenersAboutGameEnded() {
        for (IFootballListener listener : this.listeners) {
            listener.gameEnded(this);
        }
    }

    private void notifyListenersAboutGoalScored() {
        for (IFootballListener listener : this.listeners) {
            listener.goalScored(this);
        }
    }

    private void notifyListenersAboutHalfTimeEnded() {
        for (IFootballListener listener : this.listeners) {
            listener.halfTimeEnded(this);
        }
    }

    private void notifyListenersAboutHalfTimeStarted() {
        for (IFootballListener listener : this.listeners) {
            listener.halfTimeStarted(this);
        }
    }

    private boolean isGoalHost() {
        int random = ThreadLocalRandom.current().nextInt(1, 11);
        return random <= 6;
    }

    private boolean isScore(int minute) {
        int random = ThreadLocalRandom.current().nextInt(1, 91);
        return random == minute;
    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }
}
