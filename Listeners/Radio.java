public class Radio implements IFootballListener {
    @Override
    public void gameStarted(FootballGame game) {
        System.out.println("RADIO: Game between " + game.getHomeTeam() + " and " + game.getAwayTeam() + " has started");
    }

    @Override
    public void gameEnded(FootballGame game) {
        System.out.println("RADIO: Game Ended");

    }

    @Override
    public void goalScored(FootballGame game) {
        System.out.println("RADIO: GOAL SCORED");
    }

    @Override
    public void halfTimeEnded(FootballGame game) {
        System.out.println("RADIO: HALF TIME ENDED");
    }

    @Override
    public void halfTimeStarted(FootballGame game) {
        System.out.println("RADIO: HALF TIME STARTED");
    }
}
