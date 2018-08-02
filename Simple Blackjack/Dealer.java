import java.util.Scanner;

public class Dealer {

    private Player p1;
    private Player p2;

    public boolean STOPGAME = false;

    public Dealer(Player player, Player player1)
    {
        this.p1 = player;
        this.p2 = player1;
    }



    public void initialDeal()
    {
        System.out.println("=======================");
        DealCard(p1, 2);
        printMessage(p1, p1.getTotalHandValue());

        System.out.println("=======================");

        DealCard(p2, 2);
        printMessage(p2, p2.getTotalHandValue());
        System.out.println("=========================================");
    }

    public void deal()
    {
        playerChoice(p1);

        printMessage(p2, p2.getTotalHandValue());
        playerChoice(p2);

        ShowOutcome();
    }


    public void hit(Player player)
    {
        System.out.println("You pressed HIT! Dealing card..");
        DealCard(player, 1);
        printMessage(player, player.getTotalHandValue());

        if(!(player.stay || player.busted || player.twentyOne || player.blackJack))
            playerChoice(player);
    }

    public void stay(Player player)
    {
        player.setStay();
        System.out.println("Staying..");
    }

    public void OneOrEleven()
    {

    }

    private void DealCard(Player player, int quantity)
    {
        int randomNum = 0;
        for(int i = 1; i <= quantity; i++)
        {
            randomNum = (int) (Math.random() * 13 + 1);
            player.addCardToHand(randomNum);
        }
    }

    public void printMessage(Player player, int total)
    {
        String message;

        message  = GetMessage(player);

        System.out.print(player.getPlayerName() + "'s hand: ");
        System.out.println("\n-----------------------");
        printPlayerCards(player);
        System.out.println("\n-----------------------");
        System.out.printf( "Total: %-2d| %4s  %n", total, message);
        System.out.println("-----------------------");
    }

    public void playerChoice(Player player)
    {
        String choice = "";

        Scanner in = new Scanner(System.in);

        System.out.println("( H = HIT, S = STAY) \n "+player.getPlayerName()+"'s Choose: ");
        choice = in.nextLine();

        if(choice.equalsIgnoreCase("H"))
            hit(player);
        else if(choice.equalsIgnoreCase("S"))
            stay(player);
    }


    public void printPlayerCards(Player player)
    {
        player.printCardsInHand();
    }

    public String GetMessage(Player player)
    {
        String msg = "";
        msg = player.getTotalHandValue() > 21 ? ( player.getPlayerName() + " BUSTED") : "";
        msg = player.getTotalHandValue() == 21 ? ( player.getPlayerName() + " -> Twenty One!!") : msg;

        return msg;
    }

    public void ShowOutcome()
    {
        int p1Total = 0, p2Total = 0;
        p1Total = p1.getTotalHandValue();
        p2Total =  p2.getTotalHandValue();

        System.out.println("\n===========================================");

        if(p1Total > p2Total)
            System.out.println("YaY!! " + p1.getPlayerName() + " is the WINNER!");
        else if(p2Total > p1Total)
            System.out.println("YaY!! " + p2.getPlayerName() + " is the WINNER!");
        else if(p1Total == p2Total)
            System.out.println("Uh Oh! Its a TIE!");

        System.out.println("Ending Game..");
        System.exit(1);
    }
}
