import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LabyrinthGenerator
{
    Labyrinth generate(Labyrinth l)
    {
        //generate a labyrinth with prim's algorithm

        frontierWalls = new ArrayList<LabCoord>();
        this.temp = l;

        //choose a startingplace in the maze at the start coords
        temp.grid[temp.startY][temp.startX+1] = 2;
        addNeighboursToWalls(new LabCoord(temp.startY, temp.startX+1));

        //iterate as long as there are possible paths to take
        while( !(frontierWalls.isEmpty()))
        {
            //choose a random element from the array
            int randomIndexNumber = new Random().nextInt(frontierWalls.size());
            List<LabCoord> availablePaths = checkForPaths(frontierWalls.get(randomIndexNumber));
            int randomPathChoice = new Random().nextInt(availablePaths.size());
            while(!(availablePaths.isEmpty()))
            {
                /***
                 * Checks which way the randomly chosen path is in relation to the wall.
                 * after that it checks if the next element in order is a wall, and if it is it will connect the path and
                 * update the new possible frontiers.
                 *
                 * if the next element is not a wall it will remove the path as a possibility
                 **/
                //PATH NORTH OF WALL
                if(availablePaths.get(randomPathChoice).Y < frontierWalls.get(randomIndexNumber).Y)
                {
                    if(temp.grid[frontierWalls.get(randomIndexNumber).Y+1][frontierWalls.get(randomIndexNumber).X]==0)
                    {
                        LabCoord tempWallCoord = new LabCoord(frontierWalls.get(randomIndexNumber).Y, frontierWalls.get(randomIndexNumber).X);
                        temp.grid[tempWallCoord.Y+1][tempWallCoord.X]=2;
                        temp.grid[tempWallCoord.Y][tempWallCoord.X]=2;

                        //frontierWalls.remove(randomIndexNumber);

                        addNeighboursToWalls(new LabCoord(tempWallCoord.Y+1, tempWallCoord.X));
                        availablePaths.clear();
                        break;
                    }
                }
                //PATH WEST OF WALL
                if(availablePaths.get(randomPathChoice).X < frontierWalls.get(randomIndexNumber).X)
                {
                    if(temp.grid[frontierWalls.get(randomIndexNumber).Y][frontierWalls.get(randomIndexNumber).X+1]==0)
                    {
                        LabCoord tempWallCoord = new LabCoord(frontierWalls.get(randomIndexNumber).Y, frontierWalls.get(randomIndexNumber).X);
                        temp.grid[tempWallCoord.Y][tempWallCoord.X+1]=2;
                        temp.grid[tempWallCoord.Y][tempWallCoord.X]=2;

                        addNeighboursToWalls(new LabCoord(tempWallCoord.Y, tempWallCoord.X+1));
                        availablePaths.clear();
                        break;
                    }
                }
                //PATH SOUTH OF WALL
                if(availablePaths.get(randomPathChoice).Y > frontierWalls.get(randomIndexNumber).Y)
                {
                    if(temp.grid[frontierWalls.get(randomIndexNumber).Y-1][frontierWalls.get(randomIndexNumber).X]==0)
                    {
                        LabCoord tempWallCoord = new LabCoord(frontierWalls.get(randomIndexNumber).Y, frontierWalls.get(randomIndexNumber).X);
                        temp.grid[tempWallCoord.Y-1][tempWallCoord.X]=2;
                        temp.grid[tempWallCoord.Y][tempWallCoord.X]=2;

                        //frontierWalls.remove(randomIndexNumber);

                        addNeighboursToWalls(new LabCoord(tempWallCoord.Y-1, tempWallCoord.X));
                        availablePaths.clear();
                        break;
                    }
                }

                //PATH EAST OF WALL
                if(availablePaths.get(randomPathChoice).X > frontierWalls.get(randomIndexNumber).X)
                {
                    if(temp.grid[frontierWalls.get(randomIndexNumber).Y][frontierWalls.get(randomIndexNumber).X-1]==0)
                    {
                        LabCoord tempWallCoord = new LabCoord(frontierWalls.get(randomIndexNumber).Y, frontierWalls.get(randomIndexNumber).X);
                        temp.grid[tempWallCoord.Y][tempWallCoord.X-1]=2;
                        temp.grid[tempWallCoord.Y][tempWallCoord.X]=2;

                        addNeighboursToWalls(new LabCoord(tempWallCoord.Y, tempWallCoord.X-1));
                        availablePaths.clear();
                        break;
                    }
                }

                //NO PATHS WITH WALLS AS THE NEXT ELEMENT
                availablePaths.remove(randomPathChoice);
                if(!(availablePaths.isEmpty()))
                {
                    randomPathChoice = new Random().nextInt(availablePaths.size());
                }
            }
            frontierWalls.remove(randomIndexNumber);

        }



        return temp;
    }
    Labyrinth temp;
    List<LabCoord> frontierWalls;

    private void addNeighboursToWalls(LabCoord i)
    {
        //go through the 4 possibilities, add any 0 to possible candidates
        //NORTH
        if(temp.grid[i.Y-1][i.X]==0)
        {
            frontierWalls.add(new LabCoord(i.Y-1, i.X));
        }
        //WEST
        if(temp.grid[i.Y][i.X-1]==0)
        {
            frontierWalls.add(new LabCoord(i.Y, i.X-1));
        }
        //SOUTH
        if(temp.grid[i.Y+1][i.X]==0)
        {
            frontierWalls.add(new LabCoord(i.Y+1, i.X));
        }
        //EAST
        if(temp.grid[i.Y][i.X+1]==0)
        {
            frontierWalls.add(new LabCoord(i.Y, i.X+1));

        }
    }
    private List<LabCoord> checkForPaths(LabCoord i)
    {
        //assumes you get a wall coord, check the neighbouring tiles for paths
        List<LabCoord> openPaths = new ArrayList<LabCoord>();

        //NORTH
        if(temp.grid[i.Y-1][i.X]==2)
        {
            openPaths.add(new LabCoord(i.Y-1,i.X));
        }
        //WEST
        if(temp.grid[i.Y][i.X-1]==2)
        {
            openPaths.add(new LabCoord(i.Y, i.X-1));
        }
        //SOUTH
        if(temp.grid[i.Y+1][i.X]==2)
        {
            openPaths.add(new LabCoord(i.Y+1, i.X));
        }
        //EAST
        if(temp.grid[i.Y][i.X+1]==2)
        {
            openPaths.add(new LabCoord(i.Y, i.X+1));
        }
        return openPaths;
    }
}
