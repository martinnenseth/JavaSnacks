
package algos;



/**
 *
 * @author evenal
 */
public class QuickSortAnalysis extends EmpiricalAnalysis 
{
    
    public QuickSortAnalysis() {
        super("Quicksort");
    }

    @Override
    protected void run(int[] testdata) {
        qSort(testdata);
    }

    
    /**
     * A straightforward and slightly naive
     * implementation of QuickSort
     */
    public void qSort(int[] data) {
        qSort(data, 0, data.length);
    }


    public void qSort(int[] data, int lo, int hi) {
        if (lo < hi) {
            int p = partition(data, lo, hi);
            qSort(data, lo, p);
            qSort(data, p + 1, hi);
        }
    }


    public int partition(int[] data, int lo, int hi) {
        int ilo = lo;
        int ihi = hi - 1;
        int p = data[ihi];

        for (ilo = lo; ilo < ihi;) {
            while (lessThan(data[ilo], p)) ilo++;
            while (greaterThan(data[ihi], p))
                ihi--;
            swap(data, ilo, ihi);
        }
        return ihi;
    }

    private static void pp(int[] data) {
        for (int i = 0; i < data.length; i++)
            System.out.print(" " + data[i]);
        System.out.println();
        System.out.flush();
    }
}
