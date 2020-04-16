package pa06;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class KMeans {
    public ArrayList<Cluster> kCluster;  //an array of size k of Clusters with randomly generated cluster points

    public static void main(String[] args) throws FileNotFoundException {

        Cluster originalData = new Cluster();

        Scanner in = new Scanner(System.in);
        System.out.print("Filename: ");
        String filename = in.nextLine();
        System.out.print("Number of clusters: ");
        int numClusters = in.nextInt();

        Scanner data = new Scanner(new File(filename));
        ArrayList<int[]> parametersList = new ArrayList<int[]>();
        while(data.hasNextInt()) {
            int num = data.nextInt(); //663441
            int[] digits = Integer.toString(num).chars().map(c -> c - '0').toArray();  // int[] 6,6,3,4,4,1  //???? ask tim if that is in the range
            originalData.add(digits);
        }
        
        KMeans k = new KMeans();
        k.setup(originalData, numClusters);
        
        System.out.print(originalData);
    }
    
    public void setup(Cluster originalData, int numClusters) {
    	  for (int i = 0; i<numClusters; i++) {
          	Cluster c = new Cluster();
          	c.setClusterpt(originalData);
          	kCluster.add(c);
          }
    }
    
    public Cluster findCluster(Sample s) {
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

    //static add method
}
