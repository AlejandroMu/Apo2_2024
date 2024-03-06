package co.icesi.edu.comparators;

import java.util.Comparator;

import co.icesi.edu.model.Billboard;

public class HeightComparator implements Comparator<Billboard> {

    @Override
    public int compare(Billboard o1, Billboard o2) {
        return Double.compare(o1.getHeight(), o2.getHeight());
    }
}
