package pa06;
import java.util.ArrayList;
import java.util.Random;

/**
 * A cluster is a cluster point (which is itself a sample)
 * and a list of Samples (the one's closest to that sample point, ideally).
 * @author presenting
 *
 */
public class Cluster implements Assignment<Cluster>{
    public ArrayList<Sample> cluster;
    public Sample clusterpt;

    public Cluster(){
           cluster = new ArrayList<Sample>();
           //clusterpt = new Sample();
    }

    public void assign(Cluster other){
        //assign sample points in the ArrayList<Sample> cluster
    }

    public void add(double[] values){
        Sample newsample = new Sample(values);
        cluster.add(newsample);
    }

    //randomly a sample from orginal data, then put it as clusterpt.
    public void setClusterpt(Cluster originaldata) {
        Random rd = new Random();

    }
}
