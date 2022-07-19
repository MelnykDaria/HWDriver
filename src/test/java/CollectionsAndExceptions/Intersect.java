package CollectionsAndExceptions;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Intersect {
    private int numberIntersect;

    public Intersect(int number){
        this.numberIntersect = number;
    }


    public static Set<Integer> intersect(Set<Integer> firstSet, Set<Integer> secondSet) {
        Set<Integer> emptySet = new HashSet<>();
        for (Integer firstItem : firstSet){
            for (Integer secondItem : secondSet){
                if (firstItem.equals(secondItem)){
                    emptySet.add(firstItem);
                }
            }
        }

        for (Integer item:emptySet){
            System.out.println(item);
        }
        return emptySet;

    }

    public int hashCode(){
        return Objects.hash(numberIntersect);
    }
}

