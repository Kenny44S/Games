public abstract class Player {

    protected String[][] boardPosition;
    protected String player = "";


    protected void mark(int position) {

        switch (position){
            case 1:
                boardPosition[0][0] = player;
                break;
            case 2:
                boardPosition[0][1] = player;
                break;
            case 3:
                boardPosition[0][2] = player;
                break;
            case 4:
                boardPosition[1][0] = player;
                break;
            case 5:
                boardPosition[1][1] = player;
                break;
            case 6:
                boardPosition[1][2] = player;
                break;
            case 7:
                boardPosition[2][0] = player;
                break;
            case 8:
                boardPosition[2][1] = player;
                break;
            case 9:
                boardPosition[2][2] = player;
                break;
        }
    }


    protected boolean isWinner() {

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
        return ( boardPosition[i][i].equals(player) && boardPosition[i][1].equals(player) && boardPosition[i][2].equals(player) );
    }

    private boolean CheckHorizontal(int i)
    {
        return ( boardPosition[i][i].equals(player) && boardPosition[1][i].equals(player) && boardPosition[2][i].equals(player) );
    }

    private boolean CheckDiagonal(int i)
    {
        if(i == 1)
            return false;
        return ( boardPosition[0][i].equals(player) && boardPosition[1][1].equals(player) && boardPosition[2][2-i].equals(player) );
    }
}
