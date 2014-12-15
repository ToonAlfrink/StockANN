import java.util.*;
public class Connection {
    private float newWeight;
    private float weight;
    private Node from;
    private Node to;
    public Connection(Node from, Node to) {	
	this.from = from;
	this.to = to;
	Random r = new Random();
	this.weight = r.nextFloat() * 2 - 1;
    }
    public float getValueContribution() {
	return this.weight * this.from.getValue();
    }
    public float getErrorContribution() {
	return this.weight * this.to.getError();
    }
    public void setNewWeight(float learningRate) {
	this.newWeight = this.weight + learningRate * to.getError() * from.getValue();
    }
    public float getWeight() {
	return this.weight;
    }
    public void updateWeight() {
	this.weight = this.newWeight;
    }
}