package com.test.graphs;

public class DFSTest {

  public static void main(String[] args) {
    GraphNode node40 = new GraphNode(40);
    GraphNode node10 = new GraphNode(10);
    GraphNode node20 = new GraphNode(20);
    GraphNode node30 = new GraphNode(30);
    GraphNode node60 = new GraphNode(60);
    GraphNode node50 = new GraphNode(50);
    GraphNode node70 = new GraphNode(70);

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

    System.out.println("The DFS traversal of the graph is ");
    DFS dfsExample = new DFS();
    dfsExample.search(node40);
  }

}
