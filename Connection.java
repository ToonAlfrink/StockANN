import java.util.*;
public class Connection {
    private Random r = new Random();
    private float weight;
    private Node from;
    private Node to;
    public Connection(Node from, Node to) {	
	this.from = from;
	this.to = to;
	this.weight = r.nextFloat() * 2 - 1;
    }
    public float getValueContribution() {
	return this.weight * this.from.getValue();
    }
}