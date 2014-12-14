import java.util.*;

public class Node {
    private float value;
    private Random r = new Random();
    private ArrayList<Connection> inConnections = new ArrayList<Connection>();
    private ArrayList<Connection> outConnections = new ArrayList<Connection>();
    public Node() {
	this.value = r.nextFloat() * 2 - 1;
    }
    public Node(Node[] prevNodes) {
	for (Node prevNode : prevNodes) {
	    Connection c = new Connection(prevNode, this);
	    this.outConnections.add(c);
	    prevNode.setOutConnection(c);
	}
    }
    public void setOutConnection(Connection c) {
	this.outConnections.add(c);
    }
    public void setValue(float value) {
	this.value = value;
    }
}