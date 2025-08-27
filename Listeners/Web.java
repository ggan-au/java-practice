public class Web implements IFootballListener {
    @Override
    public void gameStarted(FootballGame game) {
        System.out.println("WEB: Game between " + game.getHomeTeam() + " and " + game.getAwayTeam() + " has started");

    }

    @Override
    public void gameEnded(FootballGame game) {
        System.out.println("WEB: Game Ended");
    }

    @Override
    public void goalScored(FootballGame game) {
        System.out.println("WEB: GOAL SCORED");
    }

    @Override
    public void halfTimeEnded(FootballGame game) {
        System.out.println("WEB: HALF TIME ENDED");
    }

    @Override
    public void halfTimeStarted(FootballGame game) {
        System.out.println("WEB: HALF TIME STARTED");
    }
}
