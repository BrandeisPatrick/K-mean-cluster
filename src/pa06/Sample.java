package pa06;

import java.util.ArrayList;

/**
 * A Sample represents a vector of doubles to be used in a clustering algorithm...
 * @author presenting
 *Added a toString() and a Distance() method
 */

public class Sample {
	ArrayList<Double> sample;
	
	public Sample(double[] values) {
		this.sample = new ArrayList<Double>();
		for (int i=0; i<values.length; i++) {
			sample.add(values[i]);
		}
		
	}
	
	public String toString() {
		/**toString method for printing out Sample ArrayList*/
		String string = "{";
		int size = this.sample.size();
		for(int i=0; i<size-1; i++) {
			string += this.sample.get(i) + ", ";
		}
		string += this.sample.get(size-1) + "}";
		return string;
	}
	
	public double Distance(Sample s2) {
		double total = 0;
		for(int i = 0; i<s2.sample.size(); i++) {
			total += Math.sqrt(Math.abs(this.sample.get(i)-s2.sample.get(i)));
		}
		return Math.sqrt(total);
	}

	
	public static void main(String[] args) {
		System.out.println("testing for the Sample class.");
		double[] p1 = {1d, 2d, 3.14, 2.71};
		double[] p2 = {0.1, 1.1, 2.1, 3.1};
		Sample s1 = new Sample(p1);
		Sample s2 = new Sample(p2);
		System.out.println("s1="+s1.toString());
		System.out.println("s2="+s2.toString());
		
	}
	


}