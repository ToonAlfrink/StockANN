public abstract class Layer {
    protected Node[] nodes;
    protected Layer(int size) {
	nodes = new Node[size];
	for (int i = 0; i < size; i++) {
	    nodes[i] = new Node();
	}
    }
    protected Layer(int size, Layer prevLayer) {
	nodes = new Node[size];
	for (int i = 0; i< size; i++) {
	    nodes[i] = new Node(prevLayer.getNodes());
	}
    }
    protected void propagate() {
	for (Node n : nodes) {
	    n.propagate();
	}
    }
    public Node[] getNodes() {
	return this.nodes;
    }
    public int getSize() {
	return this.nodes.length;
    }
}