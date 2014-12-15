import java.util.*;

public class Node {
    private float value;
    private float error;
    private ArrayList<Connection> inConnections = new ArrayList<Connection>();
    private ArrayList<Connection> outConnections = new ArrayList<Connection>();
    public Node() {
	Random r = new Random();
	this.value = r.nextFloat() * 2 - 1;
    }
    public Node(Node[] prevNodes) {
	for (Node prevNode : prevNodes) {
	    Connection c = new Connection(prevNode, this);
	    this.inConnections.add(c);
	    prevNode.setOutConnection(c);
	}
	this.propagate();
    }
    public void propagate() {
	float activation = 0.0f;
	for (Connection c : inConnections) {
	    activation += c.getValueContribution();
	}
	this.value = 1.0f / (1.0f + (float)Math.exp(-1.0f*activation));
    }
    public void setOutConnection(Connection c) {
	this.outConnections.add(c);
    }
    public void setValue(float value) {
	this.value = value;
    }
    public float getValue() {
	return this.value;
    }
    public ArrayList<Connection> getInConnections() {
	return this.inConnections;
    }
    public void setError() {
	float totalError = 0.0f;
	for (Connection c : this.outConnections) {
	    totalError += c.getErrorContribution();
	}
	this.error = this.value * (1 - this.value) * totalError;
    }
    public void setError(float error) {
	this.error = error;
    }
    public float getError() {
	return this.error;
    }
}