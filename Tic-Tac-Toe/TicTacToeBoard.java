import java.util.Scanner;

public class TicTacToeBoard {

    private final int size = 3;
    private String[][] boardPositions;

    private String nextMoveIs = "X";

    private PlayerX playerX;
    private PlayerO playerO;

    private int stepCount = 0;

    boolean playerXWon = false;
    boolean playerOWon = false;




    public TicTacToeBoard()
    {
        boardPositions = new String[size][size];
        playerX = new PlayerX();
        playerO = new PlayerO();
        System.out.println("Initiating board.. Valid Board Positions will be denoted by numbers.");
        InitializeBoard();
        PrintBoard();
    }



    public void StartGame()
    {
        while ( !(playerOWon || playerXWon))
        {
            ShowAvailableMoves();
            GetUserMove();
            PrintBoard();
            CheckIfAnyWinner();
        }
    }




    public void InitializeBoard()
    {
        int p = 1;
        for (int i = 0; i < size; i++)
        {
            boardPositions[i][0] = String.valueOf(" " + p );
            for (int z = 0; z < size; z++)
            {
                boardPositions[i][z] = String.valueOf(" " + p++);
            }
        }
    }


    public void PrintBoard()
    {
        System.out.println("\n-----------------");
        for (int i = 0; i < size; i++)
        {
            if( playerX.boardPosition[i][0].equals("X"))
                System.out.print(" X ");
            else if(playerO.boardPosition[i][0].equals("O"))
                System.out.print(" O ");
            else
                System.out.print(boardPositions[i][0] + " ");

            System.out.print(" | ");
            for (int z = 1; z < size; z++)
            {
                if( playerX.boardPosition[i][z].equals("X"))
                    System.out.print(" X ");
                else if(playerO.boardPosition[i][z].equals("O"))
                    System.out.print(" O ");
                else
                    System.out.print(boardPositions[i][z] + " ");
                System.out.print(" | ");
            }
            if(i != 2) {
                System.out.println();
                System.out.println("_________________");

            }
            System.out.println();
        }
        System.out.println("-----------------");
    }


    public void ShowAvailableMoves()
    {
        if(stepCount >= 9)
        {
            System.out.println("Uh oh...Seems like no one of you won!");
            System.exit(1);
        }

        int c = 1;
        System.out.println("Available Moves are: ");
        for(int z = 0; z < size; z++)
        {
            if( playerX.boardPosition[z][0].equals("X") || playerO.boardPosition[z][0].equals("O") )
                c++;
            else
                System.out.print(c++ + " ");
            for (int k = 1; k < size; k++)
            {
                if( playerX.boardPosition[z][k].equals("X") || playerO.boardPosition[z][k].equals("O"))
                    c++;
                else
                    System.out.print(c++ + " ");
            }
        }
        System.out.print("\n-----------------");
    }

    public void GetUserMove()
    {
        int userMove = 0;

        Scanner input = new Scanner(System.in);

        if(nextMoveIs.equals("X"))
        {
            System.out.println();
            System.out.println("Player X to Move: ");
            userMove = input.nextInt();
            playerX.move(userMove);
            nextMoveIs = "O";
            stepCount++;
        }
        else if(nextMoveIs.equals("O"))
        {
            System.out.println();
            System.out.println("Player O to Move: ");
            userMove = input.nextInt();
            playerO.move(userMove);
            nextMoveIs = "X";
            stepCount++;
        }
    }

    public void CheckIfAnyWinner()
    {
        if(stepCount > 4)
        {
            if(playerX.isWinner())
            {
                System.out.println();
                System.out.println(" * - . * - . * - . *");
                System.out.println("YaY!! X is the winner!");
                System.out.println(" * - . * - . * - . *");
                System.exit(1);
            }
            else if(playerO.isWinner())
            {
                System.out.println();
                System.out.println(" * - . * - . * - . * - . *");
                System.out.println("YaY!! O is the winner");
                System.out.println(" * - . * - . * - . * - . *");
                System.exit(1);
            }
        }
    }
}
