public class Connection {

    private Neuron fromNeuron;
    private Neuron toNeuron;
    private double weight;

    public Connection(Neuron fromNeuron, Neuron toNeuron, double weight){
        this.fromNeuron = fromNeuron;
        this.toNeuron = toNeuron;
        this.weight = weight;
    }

    public Neuron getFromNeuron() {
        return fromNeuron;
    }

    public Neuron getToNeuron() {
        return toNeuron;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
