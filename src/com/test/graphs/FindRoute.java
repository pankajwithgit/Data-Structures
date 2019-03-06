package com.test.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a directed graph, design an algorithm to find out whether there is a route between tw
 * nodes.
 */
public class FindRoute {

  public static void main(String[] args) {
    GraphNode node40 = new GraphNode(40);
    GraphNode node10 = new GraphNode(10);
    GraphNode node20 = new GraphNode(20);
    GraphNode node30 = new GraphNode(30);
    GraphNode node60 = new GraphNode(60);
    GraphNode node50 = new GraphNode(50);
    GraphNode node70 = new GraphNode(70);
    GraphNode node80 = new GraphNode(80);

    node40.addNeighbour(node10);
    node40.addNeighbour(node20);
    node10.addNeighbour(node30);
    node20.addNeighbour(node10);
    node20.addNeighbour(node30);
    node20.addNeighbour(node60);
    node20.addNeighbour(node50);
    node30.addNeighbour(node60);
    node60.addNeighbour(node70);
    node50.addNeighbour(node70);
    node80.addNeighbour(node70);

    System.out.println("Has Route case: " + search(node40, node70));
    System.out.println("No Route case: " + search(node40, node80));
  }

  private static boolean search(GraphNode startNode, GraphNode endNode) {
    if (startNode == endNode) {
      return true;
    }
    Queue<GraphNode> queue = new LinkedList<>();
    queue.add(startNode);
    while (!queue.isEmpty()) {
      GraphNode node = queue.poll();
      if (node != null) {
        node.setVisited(true);
        for (GraphNode child : node.getNeighbours()) {
          if (!child.isVisited()) {
            if (child == endNode) {
              return true;
            }
            queue.add(child);
          }
        }
      }
    }
    return false;
  }
}
