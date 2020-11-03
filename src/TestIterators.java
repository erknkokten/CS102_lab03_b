import java.util.Iterator;

public class TestIterators {
    public static void main(String args[]){
        IntBag bag = new IntBag();
//  … insert some elements
        bag.add(1);bag.add(2);bag.add(3);bag.add(4);bag.add(5);bag.add(6);
        bag.add(7);bag.add(8);bag.add(9);bag.add(10);bag.add(11);bag.add(12);
        Iterator i, j;
        i = bag.iterator(2);
        while ( i.hasNext() )
        {
            System.out.println( i.next() );
            j = bag.iterator(2);
            while ( j.hasNext() )
            {
                System.out.println( "--" + j.next() );
            }
        }
    }
}
