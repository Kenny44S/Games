public class PlayerX implements PlayerMove{

    public String[][] boardPosition;

    public PlayerX()
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

        switch (move){
            case 1:
                boardPosition[0][0] = "X";
                break;
            case 2:
                boardPosition[0][1] = "X";
                break;
            case 3:
                boardPosition[0][2] = "X";
                break;
            case 4:
                boardPosition[1][0] = "X";
                break;
            case 5:
                boardPosition[1][1] = "X";
                break;
            case 6:
                boardPosition[1][2] = "X";
                break;
            case 7:
                boardPosition[2][0] = "X";
                break;
            case 8:
                boardPosition[2][1] = "X";
                break;
            case 9:
                boardPosition[2][2] = "X";
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
        return ( boardPosition[i][i].equals("X") && boardPosition[i][1].equals("X") && boardPosition[i][2].equals("X") );
    }

    private boolean CheckHorizontal(int i)
    {
        return ( boardPosition[i][i].equals("X") && boardPosition[1][i].equals("X") && boardPosition[2][i].equals("X") );
    }

    private boolean CheckDiagonal(int i)
    {
        if(i == 1)
            return false;
        return ( boardPosition[0][i].equals("X") && boardPosition[1][1].equals("X") && boardPosition[2][2-i].equals("X") );
    }
}
