import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;



public class LabyrinthPrinter
{
    LabyrinthPrinter(Labyrinth l)
    {
        temp = l;
        //HARDCODED, CHANGE!
        width = 120;
        height = 120;
    }

    Labyrinth temp;
    //HARDCODED, CHANGE!
    int width;
    int height;

    void print()
    {
        File f = null;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        int pixel = 0;

        for(int i = 0; i <temp.grid.length; i++)
        {
            for(int j = 0; j<temp.grid.length; j++)
            {
                if(temp.grid[i][j]==2)
                {
                    pixel = 255*65536+255*256+255;
                    img.setRGB(i,j,pixel);
                }
                else
                {
                    pixel = 0;
                    img.setRGB(i,j,pixel);
                }
            }
        }

        try
        {
            //HARDCODED, CHANGE!
            f = new File("/home/kas/Desktop/asdf.gif");
            ImageIO.write(img, "gif", f);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }

    }
}
