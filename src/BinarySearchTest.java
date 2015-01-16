import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

/**
 *
 * Copyright 2015 Cisco. All rights reserved.
 * BinarySearchTest.java
 *
 */

/**
 * @author xiaosonglin
 * @date Jan 16, 2015
 */
public class BinarySearchTest
{

    In in;

    In in2;

    int[] whitelist;

    @Before
    public void setUp() throws Exception
    {
        File file = new File("test/tinyT.txt");
        in = new In(file);
        whitelist = in.readAllInts();

        Arrays.sort(whitelist);
        File file2 = new File("test/tinyW.txt");
        in2 = new In(file2);

    }

    @Test
    public void testRankIntIntArray()
    {

        while (!in2.isEmpty())
        {
            int key = in2.readInt();
            if (BinarySearch.rank(key, whitelist) == -1)
                StdOut.println(key);
        }

    }

    @Test
    public void testRankIntIntArrayIntInt()
    {
        while (!in2.isEmpty())
        {
            int key = in2.readInt();
            if (BinarySearch.rank(key, whitelist,0,whitelist.length-1) == -1)
                StdOut.println(key);
        }
    }

}
