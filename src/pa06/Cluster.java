package pa06;
import java.util.ArrayList;

/**
 * A cluster is a cluster point (which is itself a sample)
 * and a list of Samples (the one's closest to that sample point, ideally).
 * @author presenting
 *
 */
public class Cluster extends Sample implements Assignment<Cluster>{
    public ArrayList<Sample> cluster;

    public Cluster(double[] values){
        super(values);
        cluster = new ArrayList<Sample>();
    }

    public void assign(Cluster other){
        //assign sample points in the ArrayList<Sample> cluster
    }

    public void add(double[] values){
        Sample newsample = new Sample(values);
        cluster.add(newsample);
    }
}
