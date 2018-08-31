public class Labyrinth
{
    Labyrinth()
    {
        this(10);
    }
    Labyrinth(int size)
    {
        this.grid = new int[size][size];
        this.populate(size);
        //HARDCODED, CHANGE!
        this.startX=0;
        this.startY=18;
        this.endX=19;
        this.endY=18;
    }

    int[][] grid;
    //HARDCODED, CHANGE!
    int startX;
    int startY;
    int endX;
    int endY;

    private void populate(int size)
    {
        //fill array with zeroes, make a border of 1's
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                this.grid[i][j]=0;
            }
        }

        for(int i = 0; i < size; i++)
        {
            this.grid[i][0]=1;
            this.grid[i][size-1]=1;
            this.grid[0][i]=1;
            this.grid[size-1][i]=1;
        }
    }

    void printLabyrinth()
    {
        for(int i = 0; i <this.grid.length; i++)
        {
            for(int j = 0; j<this.grid.length; j++)
            {
                if(this.grid[i][j]==0)
                {
                    System.out.print(" ");
                }
                else
                {
                    System.out.print("#");
                }
            }
            System.out.println("");
        }
    }
}
