import java.util.Iterator;

public class IntBagStepIterator implements Iterator {
    int m;
    IntBag aBag;
    int index;
    public IntBagStepIterator(IntBag bag, int step){
        aBag = bag;
        m = step;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        if(index*m< aBag.getSize())
            return true;
        return false;
    }

    @Override
    public Object next() {
        Integer integer = aBag.getValue(index*m);
        index++;
        return integer;
    }

    @Override
    public void remove() {
        aBag.remove(index-1);
    }
}
