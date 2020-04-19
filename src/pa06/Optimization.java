package pa06;

import java.io.FileNotFoundException;

/*
 * This class executes the algorithm and out prints the result
 * Each tick is one step in solving the algorithm which iterates through
 * each Sample point and assigns it to a Cluster, then find the average of the 
 * Cluster, sets a new Clusterpt, and reassigns the Sample points to new Clusters
 */
public class Optimization {
	
	public static final int ITERATIONS = 100;
	
    public static void main(String[] args) throws FileNotFoundException {
        KMeans kmeans = new KMeans();
     //   System.out.println(kmeans);
     //   System.out.println(kmeans.originalData);
     //   System.out.println();

        for(int i=0; i < ITERATIONS; i++) {
        	kmeans.fillClusters();
          //  System.out.println(kmeans);
            kmeans.tick();
          //  System.out.println(kmeans);
        }
        System.out.println(kmeans);
    }
}