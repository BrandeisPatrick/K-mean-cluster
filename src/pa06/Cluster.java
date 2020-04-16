package pa06;
import java.util.ArrayList;
import java.util.Random;

/**
 * A cluster is a cluster point (which is itself a sample)
 * and a list of Samples (the one's closest to that sample point, ideally).
 * @author presenting
 *
 */
public class Cluster {
    public ArrayList<Sample> cluster;
    public Sample clusterpt;

    public Cluster(){
           cluster = new ArrayList<Sample>();
           setClusterpt(cluster);
    }

    public void add(double[] values){
        Sample newsample = new Sample(values);
        cluster.add(newsample);
    }

    public void add(int[] values){
        Sample newsample = new Sample(values);
        cluster.add(newsample);
    }
    
    public void add(Sample s){
        cluster.add(s);
    }

    //randomly picks a sample from orginal data, then put it as clusterpt.
    public void setClusterpt(ArrayList<Sample> originaldata) {
        Random rd = new Random();
        int rdindex = rd.nextInt(originaldata.size());
        this.clusterpt = originaldata.get(rdindex);
    }

    public String toString(){
        int i = 0;
        String output = "";
        for(Sample n : this.cluster){
            if(i<100){output += n.toString() + "\n";}
            i++;
        }
        return output;
    }
    
    public Double average() { //idk how to return an arraylist lol
    	int count = 0;
    	ArrayList<Double> total;
    	for (Sample s : cluster) {
    		for (Double i : s.sample) {
    			//needs to add up respective points of every sample, then divide each by count
    		}
    	}
    }
}
