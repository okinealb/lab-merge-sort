import java.util.Comparator;
import static java.lang.reflect.Array.newInstance;
import java.io.PrintWriter;

/**
 * A simple way to sort arrays using merge sort.
 *
 * @author YourName Here
 * @author Your NameHere
 * @author Samuel A. Rebelsky
 */
public class MergeSorter {

  // +------------------+--------------------------------------------
  // | Exported methods |
  // +------------------+

  /**
   * Sort an array using the merge sort algorithm.
   */
  public static <T> void sort(T[] vals, Comparator<? super T> comparator) {
    // STUB
  } // sort

  // +-----------------+---------------------------------------------
  // | Local utilities |
  // +-----------------+

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    T[] newVals = java.util.Arrays.copyOfRange(vals, 0, vals.length);
    PrintWriter pen = new PrintWriter(System.out, true);


    int index = 0;

    while ((lo < mid) && (mid < hi)) {
      if (comparator.compare(vals[lo], vals[mid]) <= 0) {
        newVals[index++] = vals[lo++];
      } else {
        newVals[index++] = vals[mid++];
      }
    }

    if (lo < mid) {
      for (int i = 0; i < mid - lo; i ++) {
        newVals[index + i] = vals[lo + i];
      }
    } else {
      for (int i = 0; i < hi - mid; i ++) {
        newVals[index + i] = vals[mid + i];
      }
    }

    //vals = newVals.clone();

    for(int i = 0; i < vals.length; i++) {
      vals[i] = newVals[i];
      pen.printf("%d", vals[i]);
    }
    pen.println();
  } // merge

} // class MergeSorter
