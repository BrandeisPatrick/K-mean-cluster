package pa06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

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

        while (file.hasNextInt()) {
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
        for (int i = 0; i < numClusters; i++) {
            Cluster cluster = new Cluster(this.originalData);
            kClusters.add(cluster);
        }
    }

    @Override
    public String toString(){
        String output = "KMeans kClusters : \n";
        for(Cluster cluster : this.kClusters){
            output += cluster.toString() + "\n";
        }
        return output;
    }

    //optimize each cluster pt.
    public void tick(){
        for(int i = 0; i < kClusters.size(); i++){
            kClusters.get(i).optimize();
        }
    }

    //fill k clusters with samples (distributed by closest distance)
    public void fillClusters() {
        for(int i = 0; i < kClusters.size(); i++) {
            kClusters.get(i).cleanCluster();
        }
    //  System.out.println(kClusters);
        Iterator<Sample> itr = originalData.cluster.iterator();
        while(itr.hasNext()) {
            Sample element = itr.next();
            findCluster(element,kClusters).add(element);
        }
    }

    //used in fillClusters() methods.
    //find the cluster which is closest to the sample (element)
    public Cluster findCluster(Sample element, ArrayList<Cluster> kClusters) {
        double minDist = element.distanceTo(kClusters.get(0).clusterpt);
        Cluster closest = kClusters.get(0);

        Iterator<Cluster> itr = kClusters.iterator();  //Iterator used for efficiency (in case k is large)
        itr.next();
        while(itr.hasNext()){
            Cluster cluster = itr.next();
            double dist = element.distanceTo(cluster.clusterpt);
            if (dist < minDist) {
                minDist = dist;
                closest = cluster;
            }
        }
        return closest;
    }
}
