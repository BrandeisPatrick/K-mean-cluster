package pa06;

import java.io.FileNotFoundException;

public class Optimization {
	
	private static int ITERATIONS = 100;
	
    public static void main(String[] args) throws FileNotFoundException {
        KMeans kmeans = new KMeans();
        System.out.println(kmeans);
        System.out.println(kmeans.originalData);
        System.out.println();
        
        for(int i=0; i < ITERATIONS; i++) {
        	kmeans.fillClusters();
            System.out.println(kmeans);
            kmeans.tick();
            System.out.println(kmeans);
        }
    }


}
