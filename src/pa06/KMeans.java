package pa06;

import java.util.ArrayList;
import java.util.Scanner;

public class KMeans {
    public ArrayList<Cluster> kcluster;                                //an array of size k of Clusters with randomly generated cluster points

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
            int num = data.nextInt();
            int[] digits = Integer.toString(num).chars().map(c -> c - '0').toArray();
            originalData.add(digits);
        }
    }

    //static add method
}
