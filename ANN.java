public class ANN {
    public static void main(String[] argv) {
	Layer l1 = new InputLayer(100);
	Layer l2 = new HiddenLayer(100, l1);
    }
}