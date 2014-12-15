import java.util.*;
public class ANN {
    private InputLayer inputLayer;
    private HiddenLayer[] hiddenLayers;
    private OutputLayer outputLayer;
    private float learningRate;
    public static float normaal(float abnormaal) {
	return 1 / (float)Math.exp(-1*abnormaal);
    }

    public static void main(String[] argv) {
	ANN annie = new ANN(0.1f);
    }
    public ANN(float learningRate) {
	this.learningRate = learningRate;
	hiddenLayers = new HiddenLayer[2];

	inputLayer = new InputLayer(3);
	hiddenLayers[0] = new HiddenLayer(20, inputLayer);
	hiddenLayers[1] = new HiddenLayer(20, hiddenLayers[0]);
	outputLayer = new OutputLayer(hiddenLayers[1]);

	
	Random r = new Random();
	for (int i = 0; i < 10000; i++) {
	    float[] input = new float[] {
		ANN.normaal(r.nextFloat()),
		ANN.normaal(r.nextFloat()),
		ANN.normaal(r.nextFloat())};
	    float answer = (input[0] * input[1]) / input[2];
	    answer = ANN.normaal(answer);
	    backpropagate(input, answer);
	    System.out.println("answer: " + answer 
			       +". approx: " + outputLayer.getNode().getValue()
			       +". error: " + outputLayer.getNode().getError() + ".");
	}
    }
    private void propagate() {
	for (Layer l : hiddenLayers) {
	    l.propagate();
	}
	outputLayer.propagate();
    }
    private void setNewWeights(Node n) {
	for (Connection c : n.getInConnections()) {
	    c.setNewWeight(learningRate);
	    toUpdate.add(c);
	}
    }
    //toUpdate: list of connections that need their weights updated
    private List<Connection> toUpdate = new ArrayList<Connection>();
    private void backpropagate(float[] input, float answer) {
	// set input values
	inputLayer.setInputs(input);
	// propagate values
	this.propagate();
	// set output layer error
	outputLayer.setError(answer);
	// set output layer weights
	this.setNewWeights(outputLayer.getNode());
	// do the same for all hidden layers
	for (int i = hiddenLayers.length - 1; i >= 0; i--) {
	    for (Node n : hiddenLayers[i].getNodes()) {
		n.setError();
		setNewWeights(n);
	    }
	}
	// actualize new weights
	for (Connection c : toUpdate) {
	    c.updateWeight();
	}
    }
}