package pa06;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class KMeans {
    public ArrayList<Cluster> kCluster;  //an array of size k of Clusters with randomly generated cluster points

    public static void main(String[] args) {

        Cluster originalData = new Cluster();

        Scanner in = new Scanner(System.in);
        System.out.print("Filename: ");
        String filename = in.nextLine();
        System.out.print("Number of clusters: ");
        int numClusters = in.nextInt();

        Scanner data = new Scanner(new file(filename));
        ArrayList<int[]> parametersList = new ArrayList<int[]>();
        while(data.hasNextInt()) {
            int num = data.nextInt(); //663441
            int[] digits = Integer.toString(num).chars().map(c -> c - '0').toArray();  // int[] 6,6,3,4,4,1
            originalData.add(digits);
        }
    }

    //static add method
}
