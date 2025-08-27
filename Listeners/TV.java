public class TV implements IFootballListener {
    @Override
    public void gameStarted(FootballGame game) {
        System.out.println("TV: Game between " + game.getHomeTeam() + " and " + game.getAwayTeam() + " has started");

    }

    @Override
    public void gameEnded(FootballGame game) {
        System.out.println("TV: Game Ended");
    }

    @Override
    public void goalScored(FootballGame game) {
        System.out.println("TV: GOAL SCORED");
    }

    @Override
    public void halfTimeEnded(FootballGame game) {
        System.out.println("TV: HALF TIME ENDED");
    }

    @Override
    public void halfTimeStarted(FootballGame game) {
        System.out.println("TV: HALF TIME STARTED");
    }
}
