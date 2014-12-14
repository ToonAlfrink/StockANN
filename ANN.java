public class ANN {
    public static void main(String[] argv) {
	Layer l1 = new InputLayer(100);
	Layer l2 = new HiddenLayer(100, l1);
	Layer l3 = new HiddenLayer(100,l2);
	Layer l4 = new HiddenLayer(1,l3);
	System.out.println(l4.getNodes()[0].getValue());
    }
}