import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;

public class Runner {

    public static void main(String[] args) throws Exception{

        BufferedImage image = ImageIO.read(new File("Images/2.png"));
        BufferedImage img = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = img.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();

        Raster raster = image.getData();
        int[] array = new int[784];
        int index = 0;
        for (int j = 0; j < 28; j++) {
            for (int k = 0; k < 28; k++) {
                array[index] = raster.getSample(j, k, 0);
                index++;
            }
        }

        Neuron[] inputNeurons = new Neuron[784];
        for(int i = 0; i<array.length; i++){
            inputNeurons[i] = new Neuron(i, array[i]);
        }

        Layer inputLayer = new Layer("input", inputNeurons);
        Layer[] hiddenLayers = new Layer[2];
        hiddenLayers[0] = new Layer("layer1", new Neuron(0), new Neuron(1), new Neuron(2));
        hiddenLayers[1] = new Layer("layer2", new Neuron(0), new Neuron(1), new Neuron(2), new Neuron(3));
        Network network = new Network(inputLayer, hiddenLayers);
        network.setConnections();
        network.forwardPropagate();
    }

}
