public class LabyrinthLetter
{

    public static void main(String[] args)
    {
        Labyrinth test = new Labyrinth(120);

        LabyrinthGenerator testGen = new LabyrinthGenerator();

        //test.grid = Letter.getTestLetter();

        //test.printLabyrinth();

        Labyrinth test2 = testGen.generate(test);

        //test2.printLabyrinth();

        LabyrinthPrinter testPrint = new LabyrinthPrinter(test2);
        testPrint.print();
    }
}

