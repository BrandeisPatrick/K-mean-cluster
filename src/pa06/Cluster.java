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
           clusterpt = new Sample();
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

    //randomly a sample from orginal data, then put it as clusterpt.
    public Sample setClusterpt(Cluster originaldata) {
        Random rd = new Random();
        int rdindex = rd.nextInt(originaldata.cluster.size());
        return originaldata.cluster.get(rdindex);
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
    
    public ArrayList<Double> average() { 
    	ArrayList<Double> total = new ArrayList<Double>();
    	
    	for(int i = 0; i <this.clusterpt.sample.size(); i++) {
        	int count = 0;
    		for(int j = 0; j < this.cluster.size();j++) {
    			count += this.cluster.get(j).sample.get(i);
    		}
    		double avgCount = count/this.clusterpt.sample.size();
    		total.add(avgCount);
    	}
    	return total;
    }
}
