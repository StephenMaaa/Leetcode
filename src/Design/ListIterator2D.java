package Design;

import java.util.*;

public class ListIterator2D implements Iterator<Integer> {
    Iterator<List<Integer>> iteratorL1;
    Iterator<Integer> iteratorL2;
    public ListIterator2D(List<List<Integer>> list) {
        this.iteratorL1 = list.iterator();
        this.iteratorL2 = null;
    }

    @Override
    public boolean hasNext() {
        // case 1: L2 iterator null -> check next
        // case 2: L2 iterator no next && L1 iterator has next
        while (iteratorL2 == null || !iteratorL2.hasNext() && iteratorL1.hasNext()) {
            List<Integer> list = iteratorL1.next();
            iteratorL2 = list.iterator();
        }
        return iteratorL2 != null && iteratorL2.hasNext();
    }

    @Override
    public Integer next() {
        // check
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return iteratorL2.next();
    }

    @Override
    public void remove() {
        // get the next valid L2 iterator
        while (iteratorL2 == null && iteratorL1.hasNext()) {
            iteratorL2 = iteratorL1.next().iterator();
        }

        // remove
        if (iteratorL2 != null) {
            iteratorL2.remove();
        }
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3));
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);

        ListIterator2D iterator = new ListIterator2D(list);
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        iterator.remove();
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());

        for (List<Integer> subList : list) {
            System.out.println(subList);
        }
    }
}
