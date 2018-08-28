package com.test.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Graph Breadth first search (BFS) implementation.
 * 
 * <p>
 * Uses Queue as temp DS.
 * <ul>
 * <li>Step 1: Define a Queue of size total number of vertices in the graph.</li>
 * <li>Step 2: Select any vertex as starting point for traversal. Visit that vertex and insert it
 * into the Queue.</li>
 * <li>Step 3: Visit all the adjacent vertices of the verex which is at front of the Queue which is
 * not visited and insert them into the Queue.</li>
 * <li>Step 4: When there is no new vertex to be visit from the vertex at front of the Queue then
 * delete that vertex from the Queue.</li>
 * <li>Step 5: Repeat step 3 and 4 until queue becomes empty.</li>
 * <li>Step 6: When queue becomes Empty, then produce final spanning tree by removing unused edges
 * from the graph</li>
 * </ul>
 */
public class BFS2 {

  private Queue<GraphNode> queue;

  public BFS2() {
    queue = new LinkedList<>();
  }

  public void search(GraphNode node) {
    node.setVisited(true);
    queue.add(node);
    while (!queue.isEmpty()) {
      GraphNode element = queue.remove();
      System.out.println(element.getData());
      for (GraphNode neighbour : element.getNeighbours()) {
        if (!neighbour.isVisited()) {
          queue.add(neighbour);
          neighbour.setVisited(true);
        }
      }
    }
  }
}
