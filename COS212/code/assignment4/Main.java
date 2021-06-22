/**
 * Name:
 * Student Number:
 */

public class Main {

    public static void main(String[] args) {


        DungeonGraph myDungeon = new DungeonGraph();

        myDungeon.createGraph("test.txt");

        myDungeon.toString();
        myDungeon.printVertices();
    }
}
