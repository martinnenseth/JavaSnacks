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
public class MergesortAnalysis extends EmpiricalAnalysis {

    public MergesortAnalysis() {
        super("Merge Sort");
    }

    @Override
    protected void run(int[] testdata) {
        mSort(testdata);
    }
    
    

    /**
     * Mergesort, rather naive implementation with excessive
     * memory usage
     */
    public void mSort(int[] data) {
        if (data.length > 1) {
            int m = data.length / 2;
            int[] d1 = new int[m];
            int[] d2 = new int[data.length - m];
            for (int i = 0; i < m; i++)
                d1[i] = assign(data[i]);
            for (int i = m; i < data.length; i++)
                d2[i - m] = assign(data[i]);
            if (d1.length > 1) mSort(d1);
            if (d2.length > 1) mSort(d2);
            merge(data, d1, d2);
        }
    }


    public void merge(int[] data, int[] part1, int part2[]) {
        int im = 0;
        int i1 = 0;
        int i2 = 0;
            int vmin = 0;
        while (i1 < part1.length && i2 < part2.length) {
            if (lessThan(part1[i1], part2[i2])) vmin = part1[i1++];
            else vmin = part2[i2++];
                data[im++] = assign(vmin);
        }
        while (i1 < part1.length)
            data[im++] = assign(part1[i1++]);
        while (i2 < part2.length)
            data[im++] = assign(part2[i2++]);
    }


    private static void pp(int[] data) {
        for (int i = 0; i < data.length; i++)
            System.out.print(" " + data[i]);
        System.out.println();
        System.out.flush();
    }
    
}
