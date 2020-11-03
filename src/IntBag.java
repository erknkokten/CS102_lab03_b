/**
 * IntBag class
 * @author Ozmen Erkin Kokten
 * @date 09.10.2020
 */
import java.util.Arrays;
import java.util.Iterator;

public class IntBag {

    int[] bag;
    /**
     * IntBag constructor
     * */
    public IntBag() {
        this.bag = new int[4];
        this.bag[0] = -1;
    }

    public IntBag(int step){
        this.bag = new int[4];
        this.bag[0] = -1;
        Iterator intBagStepIterator = iterator(step);
    }



    /**
     *  adds a value at a particular index location.
     * @param value the value that is going to be added
     * @param index index location that the value is going to be added.
     * */
    public void add(int value, int index){
        if(value >= 0){
            //size of array including -1 in it
            int size =getSize() + 1;

            if(index + 1 >= this.bag.length){
                //increases until the value fits to the index
                do{
                    /* New value won't fit, create a temporary array to not lose the values and double the size of the bag*/
                    int[] temp = bag;
                    this.bag = new int[this.bag.length * 2];
                    for(int i = 0; i < temp.length ; i++){
                        bag[i] = temp[i];
                    }
                }while(index + 1 >= this.bag.length);

                for(int i = bag.length - 1; i >= index+1 ;i--){
                    bag[i] = bag[i-1];
                }
                bag[index] = value;

            }
            else{
                for(int i = bag.length - 1; i >= index+1 ;i--){
                    bag[i] = bag[i-1];
                }
                bag[index] = value;
            }
        }
        else
            System.out.println("You shouldn't enter negative values.");
    }

    /**
     *  adds a value to the end of the collection
     * @param value the value that is going to be added
     * */
    public void add(int value){
        if(value >= 0){
            //size of array including -1 in it
            int size =getSize() + 1;

            if(size == this.bag.length){
                /* New value won't fit, create a temporary array to not lose the values and double the size of the bag*/
                int[] temp = new int[bag.length];
                for(int i = 0; i<bag.length;i++){
                    temp[i] = bag[i];
                }
                this.bag = new int[this.bag.length * 2];
                for(int i = 0; i < temp.length ; i++){
                    bag[i] = temp[i];
                }
                bag[size - 1] = value;
                bag[size] = -1;
            }
            else{
                bag[size - 1] = value;
                bag[size] = -1;
            }
        }
        else
            System.out.println("You shouldn't enter negative values.");
    }
    /**
     * removes the value at a given index
     * @param index index location to be removed.
     * */
    public void remove(int index){
        //size of array including -1 in it
        int size =getSize() + 1;

        bag[index] = bag[size -2];
        bag[size - 2] = bag[size - 1];
        bag[size - 1] = 0;
    }

    /**
     * checks if the bag contains the given value.
     * @param value value to be checked
     * @return true if contains, false if not
     * */
    public boolean checker(int value){
        //size of array including -1 in it
        int size =getSize() + 1;

        for(int i = 0; i < size-1; i++){
            if(bag[i] == value){
                return true;
            }
        }

        return false;
    }

    /**
     * toString method
     * @return returns the bag info.
     * */
    public String toString(){
        String str="";
        str = str + "[ ";

        for(int i = 0; getSize() - 1 > i; i++){
            str = str + this.bag[i] + ", ";
        }
        str = str +this.bag[getSize() - 1] + " ]";
        return str;
    }

    /**
     * method that gets the size of array not including -1 in the end
     * @return size of bag
     * */
    public int getSize(){
        int size = 0;
        /* Finding the size of the array*/
        for(int i = 0; i<this.bag.length; i++){
            if (this.bag[i] == -1){
                size = i;//size -1 is where '-1' exists
            }
        }
        //number of elements without -1 in it
        return size;
    }

    /**
     * method that returns the value at a specific location
     * @param index index location
     * @return value at the index location
     * */
    public int getValue(int index){
        return this.bag[index];
    }

    /**
     * removes all of the given value from the bag
     * @param value value to be removed
     * */
    public void removeAll(int value){

        int count = 0;
        int size = getSize() + 1;//include -1's index
        //get the number of elements corresponding 'value'
        for(int i = 0; i<size; i++){
            if(bag[i] == value){
                count ++;
            }
        }

        for(int i = 0; i<size; i++){
            if(( bag[i] == value)&& (count != 0)){
                count--;
                int[] temp = new int[bag.length];
                for(int j = i; j <= size; j++){
                    temp[j] = bag[j];//-1 dahil
                }
                for(int j = i; j<size;j++){
                    bag[j] = temp[j+1];
                }
            }
        }
    /*
    int size = getSize();
    for(int i = 0; i < size; i++){
      if(bag[i] == value){
        remove(i);
        i = 0;
      }
    }*/
    }
    public Iterator iterator(){
        IntBagIterator intBagIterator = new IntBagIterator(this);
        return intBagIterator;
    }
    public Iterator iterator(int m){
        IntBagStepIterator intBagStepIterator = new IntBagStepIterator(this, m);
        return intBagStepIterator;
    }

    public class IntBagIterator implements IntIterator {
        IntBag aBag;
        int index;

        public IntBagIterator(IntBag bag){
            aBag = bag;
            index = 0;
        }
        @Override
        public boolean hasNext() {
            if(index< aBag.getSize())
                return true;
            return false;
        }

        @Override
        public Object next() {
            Integer integer = bag[index];
            index++;
            return integer;
        }

        @Override
        public void remove() {
            aBag.remove(index-1);
        }
        public int nextInt() {
            int integer = bag[index];
            index++;
            return integer;

        }



    }



}


