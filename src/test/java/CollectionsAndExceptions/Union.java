package CollectionsAndExceptions;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Union {
    private int numberUnion;
    public Union(int number) {this.numberUnion = number;}
    public static void unionMethod(Set<Integer> firstSet, Set<Integer> secondSet) {
        Set<Integer> emptyUnionSet = new HashSet<>();
        for (Integer firstSetItem : firstSet) {
            emptyUnionSet.add(firstSetItem);
        }
        for (Integer secondSetItem : secondSet){
            emptyUnionSet.add(secondSetItem);
        }
        for (Integer emptySetItem:emptyUnionSet){
            System.out.println(emptySetItem);
        }
    }
    public int hashCode() {
        return Objects.hash(numberUnion);
    }
}

