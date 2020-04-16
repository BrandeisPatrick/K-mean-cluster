package pa06;
import java.util.ArrayList;

/**
 * A cluster is a cluster point (which is itself a sample)
 * and a list of Samples (the one's closest to that sample point, ideally).
 * @author presenting
 *
 */
public class Cluster extends Sample{
    ArrayList<Sample> cluster;

    @Override
    public Cluster(){
        //pick a random sample and takes its value as cluster point
        //or maybe rely on external static methods to initialize
    }


}
