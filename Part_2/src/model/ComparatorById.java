package model;

import java.util.Comparator;

public class ComparatorById implements Comparator<Toy>  {
    @Override
    public int compare(Toy o1, Toy o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
