package co.icesi.edu.comparators;

import java.util.Comparator;

import co.icesi.edu.model.Billboard;

public class WidthComparator implements Comparator<Billboard> {

    @Override
    public int compare(Billboard o1, Billboard o2) {
        return Double.compare(o1.getWidth(), o2.getWidth());
    }

}
