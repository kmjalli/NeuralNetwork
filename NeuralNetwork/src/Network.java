import java.util.ArrayList;

public class Network {

    private Layer[] hiddenLayers;
    private Layer inputLayer;
    private Layer outputLayer;
    private ArrayList<Connection>[] connections;

    public Network(Layer input, Layer... hiddenLayers){
        inputLayer = input;
        this.hiddenLayers = hiddenLayers;
        Neuron[] neurons = new Neuron[10];
        for(int i = 0; i<neurons.length; i++){
            neurons[i] = new Neuron(i);
        }
        outputLayer = new Layer("output", neurons);
        connections = new ArrayList[3];
        connections[0] = new ArrayList<>();
        connections[1] = new ArrayList<>();
        connections[2] = new ArrayList<>();
    }

    public void setConnections(){

        Neuron[] inputNeurons = inputLayer.getNeurons();
        Neuron[] layer1Neurons = hiddenLayers[0].getNeurons();
        Neuron[] layer2Neurons = hiddenLayers[1].getNeurons();
        Neuron[] outputNeurons = outputLayer.getNeurons();

        for(int i = 0; i<inputNeurons.length; i++){
            for(int j = 0; j<layer1Neurons.length; j++){
                connections[0].add(new Connection(inputNeurons[i], layer1Neurons[j], Math.random()));
            }
        }
        for(int i = 0; i<layer1Neurons.length; i++){
            for(int j = 0; j<layer2Neurons.length; j++){
                connections[1].add(new Connection(layer1Neurons[i], layer2Neurons[j], Math.random()));
            }
        }
        for(int i = 0; i<layer2Neurons.length; i++){
            for(int j = 0; j<outputNeurons.length; j++){
                connections[2].add(new Connection(layer2Neurons[i], outputNeurons[j], Math.random()));
            }
        }

    }

    public void forwardPropagate(){
        for(int j = 0; j<hiddenLayers.length; j++) {
            for (int i = 0; i < hiddenLayers[j].getNeurons().length; i++) {
                double sum = 0;
                for (Connection connection : connections[j]) {
                    if (connection.getToNeuron() == hiddenLayers[j].getNeurons()[i]) {
                        Neuron from = connection.getFromNeuron();

                        sum += connection.getWeight() * from.getNeuronValue();
                    }
                }
                hiddenLayers[j].getNeurons()[i].setNeuronValue(activation(sum));
            }
        }


        for(int i = 0; i<outputLayer.getNeurons().length; i++){
            double sum = 0;
            for (Connection connection : connections[2]) {
                if (connection.getToNeuron() == outputLayer.getNeurons()[i]) {
                    Neuron from = connection.getFromNeuron();

                    sum += connection.getWeight() * from.getNeuronValue();
                }
            }
            outputLayer.getNeurons()[i].setNeuronValue(activation(sum));
            System.out.println(outputLayer.getNeurons()[i].getNeuronValue());
        }

    }

    public double activation(double sum){

        double temp = 1/(1+Math.pow(Math.E, -sum));

        return temp;
    }

}
