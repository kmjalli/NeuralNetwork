public class Layer {

    private Neuron[] neurons;
    private String layerId;

    public Layer(String layerId, Neuron... neurons){
        this.neurons = neurons;
        this.layerId = layerId;
    }

    public Neuron[] getNeurons() {
        return neurons;
    }
}
