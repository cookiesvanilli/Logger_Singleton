package org.example;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        for (Integer i : source) {
            if (i < threshold) {
                logger.log("Element " + i + " passes");
                result.add(i);
            } else {
                logger.log("Element " + i + " does not pass");
            }
        }
        logger.log("Passed the filter " + result.size() + " of the element from " + source.size());
        return result;
    }
}
