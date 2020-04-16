package pa06;

import java.util.ArrayList;
import java.util.Scanner;

public class KMeans {
    ArrayList<Cluster> kcluster;  //an array of size k of Clusters with randomly generated cluster points
    Cluster originalData;         //an element originalData which is a cluster of all original data with the single sample point (0,0,....)

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Filename: ");
        String filename = in.nextLine();
        System.out.print("Number of clusters: ");
        int numClusters = in.nextInt();

    }

}
