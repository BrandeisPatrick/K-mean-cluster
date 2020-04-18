package pa06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class KMeans {
    public ArrayList<Cluster> kClusters;
    public Cluster originalData;

    public KMeans() throws FileNotFoundException {
        this.kClusters = new ArrayList<Cluster>();
        this.originalData = new Cluster();
        setOriginalData();
        setKClusters();
    }


    //set originalData cluster using parameters in the File
    public void setOriginalData() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.print("Filename: ");
        String filename = in.nextLine();
        Scanner file = new Scanner(new File(filename));

        while(file.hasNextInt()) {
            int num = file.nextInt(); //663441
            int[] parameter = Integer.toString(num).chars().map(c -> c - '0').toArray();  // int[] 6,6,3,4,4,1  //???? ask tim if that is in the range
            this.originalData.add(parameter);
        }
    }

    //add k clusters to the KClusters ArrayList
    public void setKClusters(){
        Scanner in = new Scanner(System.in);
        System.out.print("Number of clusters: ");
        int numClusters = in.nextInt();
        for(int i = 0; i < numClusters; i++) {
            Cluster cluster = new Cluster(this.originalData);
            kClusters.add(cluster);
        }
    }

    //fill k clusters with samples (distributed by closest distance)
    public void fillClusters(){


    }

  }
