import java.util.Arrays;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * The <tt>BinarySearch</tt> class provides a static method for binary searching for an integer in a sorted array of
 * integers.
 * <p>
 * The <em>rank</em> operations takes logarithmic time in the worst case.
 * <p>
 * For additional documentation, see <a href="http://algs4.cs.princeton.edu/11model">Section 1.1</a> of <i>Algorithms,
 * 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 * 
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class BinarySearch
{

    /**
     * This class should not be instantiated.
     */
    private BinarySearch()
    {
    }

    /**
     * Searches for the integer key in the sorted array a[].
     * 
     * @param key the search key
     * @param a the array of integers, must be sorted in ascending order
     * @return index of key in array a[] if present; -1 if not present
     */
    public static int rank(int key, int[] a)
    {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    /**
      * @Title: rank
      * @Description: 
      * @param @param key
      * @param @param a
      * @param @param lo
      * @param @param hi
      * @param @return   
      * @return index of key in array a[] if present; -1 if not present
      * @throws
      *
      * @Author xiaosonglin
      * @Date Jan 16, 2015 3:27:17 PM
      */
    public static int rank(int key, int[] a, int lo, int hi)
    {
        int mid = (lo + hi) / 2;
        if (lo > hi)
            return -1;
        else if (key < a[mid])
        {

            return rank(key, a, lo, hi - 1);
        }
        else if (key > a[mid])
        {
            return rank(key, a, lo + 1, hi);

        }
        else
        {
            return mid;
        }

    }

    /**
     * Reads in a sequence of integers from the whitelist file, specified as a command-line argument. Reads in integers
     * from standard input and prints to standard output those integers that do *not* appear in the file.
     */

    public static void main(String[] args)
    {

        // read the integers from a file
        In in = new In(args[0]);
        StdOut.println(args[0]);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);

        // read integer key from standard input; print if not in whitelist
//        while (!StdIn.isEmpty())
//        {
//            int key = StdIn.readInt();
//            if (rank(key, whitelist) == -1)
//                StdOut.println(key);
//        }
        while (!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if (rank(key, whitelist,0,whitelist.length-1) == -1)
                StdOut.println(key);
        }
      
        

    }
}
