import java.util.ArrayList;
import java.util.List;

// Represents a node in graph.
class Node {
  int value;
  List<Node> children;

  public Node(int value) {
    this.value = value;
  }

  public void addChild(Node child) {
    if(children == null) {
      children = new ArrayList();
    }
    children.add(child);
  }
}

import java.util.*;

/*
Given a directed graph, find the shortest path between two nodes if one exists.
It will be a BFS solution to find shortest path.

*/
class Main {
  public static void main(String[] args) {
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);

    one.addChild(two);
    one.addChild(three);
    two.addChild(five);
    four.addChild(one);
    four.addChild(three);
    five.addChild(four);

    List<Node> result = shortestPath(five, one);

    for(Node node : result) {
      System.out.println(node.value);
    }
  }

  public static List<Node> shortestPath(Node a, Node b) {
    // Check boundary cases.
    if(a == null || b == null) return null;
    if(a == b) return null;
    
    List<Node> result = new LinkedList<>();
    Queue<Node> q = new LinkedList<>(); // We need queue for BFS
    Map<Node,Node> parents = new HashMap<>(); // This map will help us backtrack the path to be printed at the end.
    q.add(a);
    parents.put(a, null);

    while(!q.isEmpty()) {
      Node current = q.remove();
      if(current == b) break;
      // If current has no children, skip it.
      if(current.children == null) continue;

      // Add children to queue
      for(Node child : current.children) {
        if(!parents.containsKey(child)) { // check if node is already visited or not.
          q.add(child);
          parents.put(child,current);
        }
      }
    }

    if(parents.get(b) == null) return null;

    Node parent = b;
    while(parent != null) {
      result.add(0, parent);
      parent = parents.get(parent);
    }

    return result;
  }
}
