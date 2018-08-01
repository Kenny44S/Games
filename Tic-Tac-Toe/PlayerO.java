public class PlayerO implements PlayerMove {

    public String[][] boardPosition;

    public PlayerO()
    {
        boardPosition = new String[3][3];

        for (int i = 0; i < 3; i++)
        {
            boardPosition[i][0] = " ";
            for (int z = 1; z < 3; z++)
            {
                boardPosition[i][z] = " ";
            }
        }
    }

    @Override
    public void move(int move) {
        switch (move) {
            case 1:
                boardPosition[0][0] = "O";
                break;
            case 2:
                boardPosition[0][1] = "O";
                break;
            case 3:
                boardPosition[0][2] = "O";
                break;
            case 4:
                boardPosition[1][0] = "O";
                break;
            case 5:
                boardPosition[1][1] = "O";
                break;
            case 6:
                boardPosition[1][2] = "O";
                break;
            case 7:
                boardPosition[2][0] = "O";
                break;
            case 8:
                boardPosition[2][1] = "O";
                break;
            case 9:
                boardPosition[2][2] = "O";
                break;
        }
    }

    @Override
    public boolean isWinner() {

        for (int i = 0; i < 3; i++)
        {
            if(CheckVertical(i))
                return true;
            if(CheckHorizontal(i))
                return true;
            if(CheckDiagonal(i))
                return true;
        }
        return false;
    }

    private boolean CheckVertical(int i)
    {
        return ( boardPosition[i][i].equals("O") && boardPosition[i][1].equals("O") && boardPosition[i][2].equals("O")  );
    }

    private boolean CheckHorizontal(int i)
    {
        return ( boardPosition[i][i].equals("O") && boardPosition[1][i].equals("O") && boardPosition[2][i].equals("O") );
    }

    private boolean CheckDiagonal(int i)
    {
        if(i == 1)
            return false;
        return ( boardPosition[0][i].equals("O") && boardPosition[1][1].equals("O") && boardPosition[2][2-i].equals("O") );
    }
}
