public class InputLayer extends Layer {
    public InputLayer(int size) {
	super(size);
    }
    public void setInputs(float[] input) {
	for (int i = 0; i < this.getSize(); i++) {
	    this.nodes[i].setValue(input[i]);
	}
    }
}
