/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;



/**
 * This class is meant to be a tool for empirical analysis of
 * algorithms
 *
 * To analyze an algorithm, create a subclass of this class. Add a
 * method that implements the algorithm, and override
 * run(), it should call the algorithm method.
 *
 * This particular class is more or less tailored towards testing
 * sorting algorithms, but the principle can be carried over to 
 * any kind of algorithm
 * 
 * See selectionsortAnalysis, or  for an example.
 *
 * @author local_evenal
 */
public abstract class EmpiricalAnalysis
{
// predefined counter names
    public static final String SWAP = "swap";
    public static final String COMPARE = "compare";
    public static final String ASSIGN = "assign";
    
    /**
     * The counter values are kept here
     */
    HashMap<String, Integer> counters;

    /**
     * random number generator, used to create data sets
     */
    public static Random rnd = new Random();

    /** algorithm name for display */
    private final String name;

    public EmpiricalAnalysis(String name) {
        this.name = name;
        this.counters = new HashMap<>();
        this.rnd = new Random();
    }


    /**
     * This is the core method. It runs the algorithm with input
     * arrays, of size 10, 100, 1000 ... up to nMax
     * 
     * @param nMax
     */
    public void runAnalysis(int nMax) {
        // keep the results for each n in the list results
        ArrayList<HashMap<String, Integer>> results = new ArrayList<>();
        for (int n = 10; n < nMax; n *= 10) {
            // create a new set of counters for each n
            counters = new HashMap<>();

            // Test the algorithm on 10 different inputs of each
            // size to increase accuracy of the results
            for (int iter = 0; iter < 10; iter++) {
                int[] shuffledData = createTestData(n);
                // run the algorithm
                run(shuffledData);
            }
            // add counters for this n to the result list
            results.add(counters);
        }
        presentResults(results);
    }


    /**
     * Increment a counter. Counters can have any name. They are kept
     * in a hashmap counters with the name as key
     *
     * @param counter the counter name
     */
    protected void incrementCounter(String counter) {
        Integer oldVal = counters.get(counter);
        if (null == oldVal) {
            counters.put(counter, 1);
        }
        else {
            counters.put(counter, oldVal + 1);
        }
    }
    
    ////////////////////////////////////////////////////////////////
    // Basic operation methods
    // The following methods carry out one basic operation,
    // and increment the corresponding counter.
    
    /**
     * Swap two elements in an array, and increment the swap counter
     * @param data the array in which to swap items
     * @param i index of one of the items to be swapped
     * @param j index of one of the items to be swapped
     */
    protected void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
        incrementCounter(SWAP);
    }
    
    /**
     * use to count assignments: replace var = v with
     * var = assign(v)
     * @param v
     * @return 
     */
    protected int assign(int v) {
        incrementCounter(ASSIGN);
        return v;
    }
    
    /**
     * count comparisons, replace comparison
     * operators with these
     * @param v1
     * @param v2
     * @return 
     */
    protected boolean greaterThan(int v1, int v2) {
        incrementCounter(COMPARE);
        return v1 > v2;
    }

    protected boolean lessThan(int v1, int v2) {
        incrementCounter(COMPARE);
        return v1 < v2;
    }
    
    
    protected boolean equal(int v1, int v2) {
        incrementCounter(COMPARE);
        return v1 == v2;
    }


    /**
     * Default testdata generator.
     * Create an array with shuffled data.
     * Subclasses can override this method
     * to create other types of data set
     */
    protected int[] createTestData(int n) {
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }

        for (int i = n - 1; i > 0; i--) {
            int j = rnd.nextInt(i);
            int tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }
        return data;
    }


    /**
     * Run the data collection. 
     * @param data 
     */
    protected abstract void run(int[] testdata);


    protected void presentResults(ArrayList<HashMap<String, Integer>> results) {
        Set<String> counterNames = results.get(0).keySet();
        System.out.println("Empirical results for "+name);
        for (String name : counterNames) {
            System.out.format("\n========================\nAnalysis of %s\n",
                    name);
            System.out.format("\n%8s%10s ", "n", name);
            System.out.format(" %18s", name + "/n");
            System.out.format("%18s", name + "/n^2");
            System.out.format("%18s", name + "/log(n)");
            System.out.format("%18s", name + "/n*log(n)");

            int n = 1;
            for (HashMap<String, Integer> counters : results) {
                n = n * 10;
                int count = counters.get(name);

                System.out.format("\n%8d %10d ", n, count);
                System.out.format("%18f", 1.0 * count / n);
                System.out.format("%18f", 1.0 * count / (n * n));
                System.out.format("%18f", 1.0 * count / Math.log(n));
                System.out.format("%18f", 1.0 * count / (n * Math.log(n)));
            }
            System.out.println();
        }
    }
}
