# Dijkstra Maze
Simple Java application to find the output path of a given maze.

## 1. The goal
Given the maze provided, find the output path using graph-based modeling.

To do so, we will create a vertex for each "intersection" of the maze and, whenever there is a "passage", there must be an edge between the two corresponding vertices.

Once the graph is created, we will apply the Dijkstra algorithm to obtain the path from the beginning of the maze (marked in green) to the end (marked in red).

![alt text][maze-img]

## 2. Constructing the graph
In order to find the way out of the maze, we draw a graph based on the map of the maze, placing vertices at decision points (points where we can choose more than one path), and at points where it is no longer possible follow the path due to some block), and we connect these vertices through edges, which represent the possible routes, all with the same weight.

This approach generated the following graph that can be observed in the image below, we can also observe that there are three routes of exits to the maze, the fastest highlighted in green, the intermediate highlighted in yellow, and the slowest highlighted in red. The other edges that are not part of the exit route do not keep in black color.

The beginning vertex is in the green color point and the final vertex is in the red color point.

![alt text][maze-graph-img]

## 3. The result

As a result, we can see that the Dijkstra algorithm has chosen the path: 0 -> 11 -> 12 -> Freedom !!!

Which is the best way out of the maze.

## 4. Running
In the src directory run the command below to generate the .class files.
```
javac *.java
```

Then run the command below to run the program and the output will be displayed in the terminal.
```
java Main
```

The result should be
```
Best path:
0 -> 11 -> 12 -> Freedom!!!
```

[maze-img]: https://raw.githubusercontent.com/claudiodietrich/dijkstra-maze/master/assets/img/maze.png "The Maze"
[maze-graph-img]: https://raw.githubusercontent.com/claudiodietrich/dijkstra-maze/master/assets/img/maze-graph.png "The Graph"