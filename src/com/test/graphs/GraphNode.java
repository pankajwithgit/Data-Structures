package com.test.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent Graph node.
 */
public class GraphNode {
  private int data;
  private List<GraphNode> neighbours;
  private boolean visited;

  public GraphNode(int data) {
    this.data = data;
    neighbours = new ArrayList<>();
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public List<GraphNode> getNeighbours() {
    return neighbours;
  }

  public void setNeighbours(List<GraphNode> neighbours) {
    this.neighbours = neighbours;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  public void addNeighbour(GraphNode node) {
    this.neighbours.add(node);
  }
}
