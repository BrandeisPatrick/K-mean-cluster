package pa06;
import java.util.ArrayList;
import java.util.Iterator;
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

    public Cluster(Cluster originaldata){
           cluster = new ArrayList<Sample>();
           setClusterpt(originaldata);
    }

    public Cluster(){
        cluster = new ArrayList<Sample>();
        clusterpt = new Sample();
    }

    public void setClusterpt(Cluster originaldata) {
        this.clusterpt = RdClusterpt(originaldata);
    }

    public void setClusterpt(Sample newpoint) {
        this.clusterpt = newpoint;
    }

    //randomly chooses a sample from orginal data, then put it as clusterpt.
    public Sample RdClusterpt(Cluster originaldata) {
        Random rd = new Random();
        int rdindex = rd.nextInt(originaldata.cluster.size());
        return originaldata.cluster.get(rdindex);
    }

    public void add(double[] values){
        Sample newsample = new Sample(values);
        cluster.add(newsample);
    }

    public void add(int[] values){
        Sample newsample = new Sample(values);
        cluster.add(newsample);
    }

    public void add(Sample newsample){
        cluster.add(newsample);
    }

    //prints the cluster as a series of samples
    public String toString(){
        int i = 0;
        String output = "";
        if(clusterpt != null) {
            output += "Cluster pt. : " + clusterpt.toString() +  " Cluster samples : ";
        }else{
            output +=  "originalData samples : ";
        }

        for(Sample sample : this.cluster){
            if(i<100){output += sample.toString() + " ";}
            i++;
        }
        return output;
    }

    public void optimize(){
        this.setClusterpt(this.average());
    }

    //finds and returns the average of all the samples in the cluster
    public Sample average(){
    	int length = this.clusterpt.sample.size();
        double[] aveParameter = new double[length];

    	for(int i = 0; i < length; i++) {
        	double sum = 0.0;
    		for(Sample sample : this.cluster){
    		    sum += sample.sample.get(i);
    		}
            aveParameter[i] = sum/this.cluster.size(); // averaging all over all samples in cluster array
        }
        Sample ave = new Sample(aveParameter);
    	return ave;
    }
}
