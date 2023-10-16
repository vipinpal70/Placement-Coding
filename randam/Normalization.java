
import java.util.Arrays;

public class Normalization {
    public static double[] minMaxNormalization(double[] dataset) {
        double min = Arrays.stream(dataset).min().getAsDouble();
        double max = Arrays.stream(dataset).max().getAsDouble();
        double[] normDataset = Arrays.stream(dataset).map(x -> (x - min) / (max - min)).toArray();
        return normDataset;
    }

    public static double[] zScoreNormalization(double[] dataset) {
        double mean = Arrays.stream(dataset).average().getAsDouble();
        double std = Math.sqrt(Arrays.stream(dataset).map(x -> Math.pow(x - mean, 2)).average().getAsDouble());
        double[] normDataset = Arrays.stream(dataset).map(x -> (x - mean) / std).toArray();
        return normDataset;
    }

    public static void main(String[] args) {
        double[] dataset = {8,10,15,20};

        double[] minMaxNorm = minMaxNormalization(dataset);
        System.out.println("Min Max Normalization: " + Arrays.toString(minMaxNorm));

        double[] zScoreNorm = zScoreNormalization(dataset);
        System.out.println("Z Score Normalization: " + Arrays.toString(zScoreNorm));
    }
}

