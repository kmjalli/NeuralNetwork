public class Neuron {

    private int id;
    private Connection[] inputConnections;
    private Connection[] outputConnections;
    private double neuronValue;

    public Neuron(int id){
        this.id = id;
    }

    public Neuron(int id, double value){
        this(id);
        neuronValue = value;
    }

    public void setInputConnections(Connection... inputConnections){
        this.inputConnections = inputConnections;
    }

    public void setOutputConnections(Connection... outputConnections){
        this.outputConnections = outputConnections;
    }

    public void setNeuronValue(double neuronValue) {
        this.neuronValue = neuronValue;
    }

    public double getNeuronValue() {
        return neuronValue;
    }
}
