package pa06;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class KMeans {
    
    public static void main(String[] args) throws FileNotFoundException {
    	ArrayList<Cluster> kCluster = new ArrayList<Cluster>();  //an array of size k of Clusters with randomly generated cluster points

        Scanner in = new Scanner(System.in);
        System.out.print("Filename: ");
        String filename = in.nextLine();
        System.out.print("Number of clusters: ");
        int numClusters = in.nextInt();

        Cluster originalData = setupOriginalData(filename, numClusters);
        
        //KMeans k = new KMeans();
        setup(kCluster, originalData, numClusters);
        
        System.out.println(originalData);
        System.out.println(kCluster);
    }
    
	//reads the file and puts the data from it into the cluster orginaldata
    public static Cluster setupOriginalData(String filename, int numClusters) throws FileNotFoundException{
    	Cluster originalData = new Cluster();
    	Scanner data = new Scanner(new File(filename));
        while(data.hasNextInt()) {
            int num = data.nextInt(); //663441
            int[] digits = Integer.toString(num).chars().map(c -> c - '0').toArray();  // int[] 6,6,3,4,4,1  //???? ask tim if that is in the range
            originalData.add(digits);
        }
        return originalData;
    }
    
    //sets up kCluster to have k Clusters, each with an associated Sample point
    public static void setup(ArrayList<Cluster> kCluster, Cluster originalData, int numClusters) {  
    	for (int i = 0; i<numClusters; i++) {
          	Cluster c = new Cluster();
          	c.setClusterpt(originalData);
          	kCluster.add(c);
          }
    }
    
    public Cluster findCluster(Sample s, Cluster kCluster) {
    	Double minDistance = 0.0;
    	Cluster closest = kCluster.get(0);
    	for (int i = 0; i < kCluster.size(); i++) {
    		if (i == 0) {
    			minDistance = s.DistanceTo(kCluster.get(i).clusterpt);
    			closest = kCluster.get(i);
    		} else {
	    		Double distance = s.DistanceTo(kCluster.get(i).clusterpt);
	    		if (distance < minDistance) {
	    			minDistance = distance;
	    			closest = kCluster.get(i);
    		}
    	}
    }
    	return closest;
  }
    
    public void reclassify(Cluster originalData) {
    	for (int i = 0; i<originalData.cluster.size(); i++) {
    		Cluster closest = findCluster(originalData.cluster.get(i));
    		closest.add(originalData.cluster.get(i));
    	}
    }

    //static add method
}
