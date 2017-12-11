public class Main {

  public static void main(String[] args) {
    Graph labirinto = new Graph(18);

    labirinto.makeEdge(0, 1, 1);
    labirinto.makeEdge(0, 11, 1);
    labirinto.makeEdge(1, 2, 1);
    labirinto.makeEdge(1, 3, 1);
    labirinto.makeEdge(3, 4, 1);
    labirinto.makeEdge(3, 10, 1);
    labirinto.makeEdge(4, 5, 1);
    labirinto.makeEdge(4, 6, 1);
    labirinto.makeEdge(6, 7, 1);
    labirinto.makeEdge(6, 8, 1);
    labirinto.makeEdge(8, 9, 1);
    labirinto.makeEdge(8, 10, 1);
    labirinto.makeEdge(10, 11, 1);
    labirinto.makeEdge(11, 12, 1);
    labirinto.makeEdge(12, 13, 1);
    labirinto.makeEdge(13, 14, 1);
    labirinto.makeEdge(13, 15, 1);
    labirinto.makeEdge(15, 17, 1);
    labirinto.makeEdge(15, 16, 1);

    System.out.println("Best path:");
    for (Integer vertice : labirinto.path(0, 12)) {
      System.out.print((vertice) + " -> ");
    }
    System.out.println("Freedom!!!");
  }
}
