/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos;

/**
 *
 * @author evenal
 */
public class BinarySearchAnalysis extends EmpiricalAnalysis {
    int[] data;
    int numCompare;
    
    public BinarySearchAnalysis() {
        super("Binary Search");
    }
            
            
    @Override
    protected void run(int[] testdata) {
        numCompare = 0;
        // make sure we have a sorted array of the right size
        
        if (data == null || data.length != testdata.length) {
            data = new int[testdata.length];
            for (int i=0; i<data.length; i++) data[i] = i;
        }
        
        // use the shuffled testdata as values to search for
        for (int i=0; i<testdata.length; i++) {
            binarySearch(testdata[i]);
        }
    }
        
    public void binarySearch(int v) {
        bsearch(data, 0, data.length, v);
    }
    
    private boolean bsearch(int[] data, int lo, int hi, int v) {
        if (lo < hi) {
            int mid = (lo+hi)/2;
            if (v < data[mid]) {
                numCompare++;
                return bsearch(data, lo, mid, v);
            }
            else if (v > data[mid]) {
                numCompare +=2;
                return bsearch(data, mid+1, hi, v);
            }
            else return true;
        }
        return false;
    }
}
