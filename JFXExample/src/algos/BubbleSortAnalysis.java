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
public class BubbleSortAnalysis extends EmpiricalAnalysis {

    public BubbleSortAnalysis() {
        super("Bubble Sort");
    }

    @Override
    protected void run(int[] testdata) {
        bubbleSort(testdata);
    }

    public void bubbleSort(int[] data) {
        for (int i = data.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                //added comparion method from super to increment counter each time
                if (super.greaterThan(data[j],data[j + 1])) {
                    //added swap method from super to count the total number of swaps
                    super.swap(data, j, j+1);
                }
            }
        }
    }
    
    public void swapp(int[] data, int i1, int i2) {

        int tmp = data[i1];
        data[i1] = data[i2];
        data[i2] = tmp;
    }
}
