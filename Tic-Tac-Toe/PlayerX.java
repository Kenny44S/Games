public class PlayerX extends Player{

    public PlayerX()
    {
        InitiateMyBoardPositions();
        this.player = "X"
    }


    private void InitiateMyBoardPositions()
    {
        this.boardPosition = new String[3][3];
        for (int i = 0; i < 3; i++)
        {
            this.boardPosition[i][0] = " ";
            for (int z = 1; z < 3; z++)
            {
                this.boardPosition[i][z] = " ";
            }
        }
    }
}
