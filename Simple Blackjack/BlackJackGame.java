public class BlackJackGame {

    private Dealer dealer;


    public BlackJackGame(String playerOneName, String playerTwoName)
    {
        dealer = new Dealer(new Player(playerOneName),  new Player(playerTwoName));
    }

    public void startGame()
    {
        dealer.initialDeal();

        while (!dealer.STOPGAME)
        {
            dealer.deal();
        }
    }
}
