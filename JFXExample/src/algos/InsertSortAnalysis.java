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
public class InsertSortAnalysis extends EmpiricalAnalysis {

    public InsertSortAnalysis() {
        super("Insertion sort");
    }



    protected void run(int[] shuffledData) {
        insertSort(shuffledData);   
    }

    public void insertSort(int[] data) {
        int n = data.length;

        //outer loop picks the next value to insert
        for (int i = 1; i < n; i++) {
            //inner loop inserts it
            // added assign counter from super
            int nextval = super.assign(data[i]);
            int j = i-1;
            //added comparison counter from super
            while (j >= 0 && super.greaterThan(data[j], nextval)) {
                data[j + 1] = data[j];
                j--;
            }
            data[j+1] = nextval;
        }
    }

    private static void pp(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(" " + data[i]);
        }
        System.out.println();
        System.out.flush();
    }
}
