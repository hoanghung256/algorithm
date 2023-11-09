package implement;

// Java Program to Implement Dijkstra's Algorithm
// Using Priority Queue

// Importing utility classes
import java.util.*;

// Main class DPQ
public class DijkstraAlgorithm {
	
	
	

	// Main driver method
	public static void main(String arg[]) {
	}
}

// Class 2
// Helper class implementing Comparator interface
// Representing a node in the graph
class Node implements Comparator<Node> {

	// Member variables of this class
	public int node;
	public int value;

	// Constructors of this class

	// Constructor 1
	public Node() {
	}

	// Constructor 2
	public Node(int node, int value) {
		// This keyword refers to current instance itself
		this.node = node;
		this.value = value;
	}

	// Method 1
	@Override
	public int compare(Node node1, Node node2) {

		if (node1.value < node2.value)
			return -1;

		if (node1.value > node2.value)
			return 1;

		return 0;
	}
}
