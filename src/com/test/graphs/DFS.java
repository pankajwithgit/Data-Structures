package com.test.graphs;

import java.util.Stack;

/**
 * Graph Depth first search (BFS) implementation.
 * 
 * <p>
 * Uses Stack as temp DS.
 * <ul>
 * <li>Step 1: Define a Stack of size total number of vertices in the graph.</li>
 * <li>Step 2: Select any vertex as starting point for traversal. Visit that vertex and push it on
 * to the Stack.</li>
 * <li>Step 3: Visit any one of the adjacent vertex of the verex which is at top of the stack which
 * is not visited and push it on to the stack.</li>
 * <li>Step 4: Repeat step 3 until there are no new vertex to be visit from the vertex on top of the
 * stack.</li>
 * <li>Step 5: When there is no new vertex to be visit then use back tracking and pop one vertex
 * from the stack.</li>
 * <li>Step 6: Repeat steps 3, 4 and 5 until stack becomes Empty.</li>
 * <li>Step 7: When stack becomes Empty, then produce final spanning tree by removing unused edges
 * from the graph</li>
 * </ul>
 */
public class DFS {

  private Stack<GraphNode> stack;

  public DFS() {
    stack = new Stack<>();
  }

  public void search(GraphNode node) {
    node.setVisited(true);
    stack.push(node);
    while (!stack.isEmpty()) {
      GraphNode element = stack.pop();
      System.out.println(element.getData());
      for (GraphNode neighbour : element.getNeighbours()) {
        if (neighbour != null && !neighbour.isVisited()) {
          stack.push(neighbour);
          neighbour.setVisited(true);
        }
      }
    }
  }

}
