import java.util.*;

/**
 * A classe graph representa a nossa matriz de adjacência
 */
public class Graph {
  private static final int UNDEFINED = -1;
  private int vertices[][];

  public Graph(int numVertices) {
    vertices = new int[numVertices][numVertices];
  }

  /**
   * Adiciona vértices ao grafo de maneira bidirecional, com o peso da aresta
   */
  public void makeEdge(int vertex1, int vertex2, int time) {
    vertices[vertex1][vertex2] = time;
    vertices[vertex2][vertex1] = time;
  }

  /**
   * Remove vértices do grafo de maneira bidirecional
   */
  public void removeEdge(int vertex1, int vertex2) {
    vertices[vertex1][vertex2] = 0;
    vertices[vertex2][vertex1] = 0;
  }

  /**
   * Retorna o custo da aresta
   */
  public int getCost(int vertex1, int vertex2) {
    return vertices[vertex1][vertex2];
  }

  /**
   * Retorna todos os vértices conectados ao vértice passado por parâmetro
   */
  public List<Integer> getNeighbors(int vertex) {
    List<Integer> neighbors = new ArrayList<>();

    //Realizamos um for na linha que representa o vértice, e adicionamos os vértices cujo índice é maior do que 0
    for (int i = 0; i < vertices[vertex].length; i++)
      if (vertices[vertex][i] > 0) {
        neighbors.add(i);
      }

    return neighbors;
  }

  /**
   * Implementação do algoritmo de Dijkstra
   */
  public List<Integer> path(int from, int to) {

    //Cria listas com os custos de deslocamento até o momento
    int cost[] = new int[vertices.length];

    // Cria lista com vértices antecessores ao visitato atualmente
    int prev[] = new int[vertices.length];

    //Cria listas com os vértices não visitados,
    Set<Integer> unvisited = new HashSet<>();

    //Inicializa o custo do vértice inicial com 0
    cost[from] = 0;

    for (int v = 0; v < vertices.length; v++) {
      if (v != from) {
        //Inicializa o custo dos demais vértices inicial com um valor bem alto
        cost[v] = Integer.MAX_VALUE;
      }

      //Define todos os valores como indefinido
      prev[v] = UNDEFINED;

      //Adiciona todos os vértices a lista de não visitados
      unvisited.add(v);
    }

    //Busca
    while (!unvisited.isEmpty()) {
      //Obtem o vértice não visitado de menor custo
      int near = closest(cost, unvisited);

      //Removemos o vértice da lista de não visitados
      unvisited.remove(near);

      //Para cada vizinho calculoamos o custo total de deslocamento até ele
      for (Integer neighbor : getNeighbors(near)) {
        //Somamos o custo do nó até aqui mais o custo da aresta que liga os dois vértices
        int totalCost = cost[near] + getCost(near, neighbor);

        //Se o custo total for menor do que o custo atual a
        if (totalCost < cost[neighbor]) {
          //Atualizamos o custo
          cost[neighbor] = totalCost;

          //Marcamos o vértice antecessor
          prev[neighbor] = near;
        }
      }

      //Verifiação se o vértice processado é o destino
      if (near == to) {
        return makePathList(prev, near);
      }
    }

    //No path found
    return Collections.emptyList();
  }

  //Obtem o vértice não visitado de menor custo
  private int closest(int[] dist, Set<Integer> unvisited) {
    double minDist = Integer.MAX_VALUE;
    int minIndex = 0;
    for (Integer i : unvisited) {
      if (dist[i] < minDist) {
        minDist = dist[i];
        minIndex = i;
      }
    }
    return minIndex;
  }

  //Obtém caminho até o vértice de destino
  private List<Integer> makePathList(int[] prev, int u) {
    List<Integer> path = new ArrayList<>();
    path.add(u);
    while (prev[u] != UNDEFINED) {
      path.add(prev[u]);
      u = prev[u];
    }
    Collections.reverse(path);
    return path;
  }
}