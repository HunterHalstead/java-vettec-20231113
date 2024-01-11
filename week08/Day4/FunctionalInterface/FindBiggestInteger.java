package Day4.FunctionalInterface;

public class FindBiggestInteger implements FindBiggest<Integer> {
    @Override
    public Integer compare(Integer item1, Integer item2, Integer item3) {
        if(item1 < item2) {
            if(item2 < item3) {
                return item3;
            } else {
                return item2;
            }
        } else {
            if(item1 > item3) {
                return item1;
            } else {
                return item3;
            }
        }
    }
    
}
