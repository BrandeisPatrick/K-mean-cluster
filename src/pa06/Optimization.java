package pa06;

import java.io.FileNotFoundException;

public class Optimization {
    public static void main(String[] args) throws FileNotFoundException {
        KMeans kmeans = new KMeans();
    //  System.out.println(kmeans.originalData);
        kmeans.fillClusters();
        System.out.println(kmeans);
        kmeans.tick();
        System.out.println(kmeans);
    }


}
