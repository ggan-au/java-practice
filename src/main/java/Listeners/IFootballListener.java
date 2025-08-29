package Listeners;

public interface IFootballListener {
    void gameStarted(FootballGame game);
    void gameEnded(FootballGame game);
    void goalScored(FootballGame game);
    void halfTimeEnded(FootballGame game);
    void halfTimeStarted(FootballGame game);
}
