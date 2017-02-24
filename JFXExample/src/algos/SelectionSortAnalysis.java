/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos;



/**
 *
 * @author local_evenal
 */
public class SelectionSortAnalysis extends EmpiricalAnalysis
{

    public SelectionSortAnalysis() {
        super("Selection sort");
    }


    /**
     * this method is called from the runanalysis method
     */
    @Override
    protected void run(int[] data) {
        sort(data);
    }


    /**
     * the algorithm we want to test
     */
    public void sort(int[] data) {
        int n = data.length;
        for (int j = 0; j < n; j++) {
            int minIdx = j;

            for (int i = j + 1; i < n; i++) {
                if (lessThan(data[i], data[minIdx])) minIdx = i;
            }
            if (minIdx != j) {
                swap(data, j, minIdx);
            }
        }
    }
}
