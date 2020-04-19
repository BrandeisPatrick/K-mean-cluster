package pa06;

import java.io.FileNotFoundException;

public class Optimization {
    public static void main(String[] args) throws FileNotFoundException {
        KMeans kmeans = new KMeans();
        System.out.println(kmeans);
        System.out.println(kmeans.originalData);
        System.out.println();
        kmeans.fillClusters();
        System.out.println(kmeans);
        kmeans.tick();
        System.out.println(kmeans);
        kmeans.fillClusters();
        System.out.println(kmeans);
        kmeans.tick();
        System.out.println(kmeans);

    }


}
