public class Main {
    public static void main(String[] args) {
        FootballGame game1 = new FootballGame("Saints", "Sydney");
        Web web = new Web();
        TV tv = new TV();
        Radio radio= new Radio();
        game1.addListeners(web, tv, radio);
        game1.start();


       // FootballGame game2 = new FootballGame("Richmond", "Brisbane");
      //  game2.start();

    }
}
