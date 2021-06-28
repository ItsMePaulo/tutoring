/**
 * Name:
 * Student Number:
 */

public class Main {

    public static void main(String[] args) {

//        DungeonGraph myDungeon = new DungeonGraph();
//
//        myDungeon.createGraph("dungeons/test.txt");
//        Vertex[] va = myDungeon.getShortestPath();
//
//        for (Vertex v : va) {
//            System.out.println("(" + v.coords.row + "," + v.coords.col + "), " + v.type);
//        }
//
//        System.out.println(
//                myDungeon.getShortestPathString()
//        );

//        testDungeon1();

//        vertexTest();
//        verySmallGraph();
        teleportGraph();
    }

    private static void teleportGraph() {
        DungeonGraph myDungeon = new DungeonGraph();
        myDungeon.createGraph("dungeons/test_with_teleport.txt");

        System.out.println(myDungeon.getShortestPathString());
    }

    private static void verySmallGraph() {
        DungeonGraph myDungeon = new DungeonGraph();
        myDungeon.createGraph("test/small_dungeon.txt");

        System.out.println(myDungeon.getShortestPathString());

        System.out.println(myDungeon.toString());

    }

    private static void vertexTest() {

        DungeonGraph myDungeon = new DungeonGraph();
        myDungeon.createGraph("test/empty_dungeon.txt");

        System.out.println("Testing adjacency Matrix");
        System.out.println();

        for (int i = 0; i < myDungeon.getHeight(); i++) {
            for (int j = 0; j < myDungeon.getLength(); j++) {

                Vertex v = myDungeon.getVertex(i, j);

                if (v == null) {
                    System.out.print("   ");
                } else {
                    System.out.print(" " + myDungeon.getAdjacentVertices(v).length + " ");
                }

            }
            System.out.println();
        }
    }

    private static void testDungeon1() {

        DungeonGraph myDungeon = new DungeonGraph();

        myDungeon.createGraph("test/dungeon_1.txt");

        // E
        Vertex[] expectedArray = new Vertex[1];
        expectedArray[0] = myDungeon.getVertex(1, 1);

        testArrays(expectedArray, myDungeon.getAdjacentVertices(myDungeon.getVertex(1, 0)));

        // 1,1
        expectedArray = new Vertex[3];
        expectedArray[0] = myDungeon.getVertex(1, 0);
        expectedArray[1] = myDungeon.getVertex(1, 2);
        expectedArray[2] = myDungeon.getVertex(2, 1);

        testArrays(expectedArray, myDungeon.getAdjacentVertices(myDungeon.getVertex(1, 1)));

        // k
        expectedArray[0] = myDungeon.getVertex(3, 1);
        expectedArray[1] = myDungeon.getVertex(2, 2);
        expectedArray[2] = myDungeon.getVertex(3, 3);

        testArrays(expectedArray, myDungeon.getAdjacentVertices(myDungeon.getVertex(3, 2)));

        // 2,6
        expectedArray = new Vertex[4];

        expectedArray[0] = myDungeon.getVertex(2, 5);
        expectedArray[1] = myDungeon.getVertex(1, 6);
        expectedArray[2] = myDungeon.getVertex(2, 7);
        expectedArray[3] = myDungeon.getVertex(3, 6);
    }


    private static void testArrays(Vertex[] expectedArray, Vertex[] actualArray) {
        try {
            for (int i = 0; i < expectedArray.length; i++) {
                assertEquals(expectedArray[i], actualArray[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <E, A> void assertEquals(E expected, A actual) throws Exception {

        if (!expected.equals(actual)) {
            throw new Exception("Not Equals exception expected value: " + expected + " was not equal to: " + actual);
        }
    }
}

