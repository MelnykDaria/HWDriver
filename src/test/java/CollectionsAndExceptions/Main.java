package CollectionsAndExceptions;
import java.util.*;

public class Main {
    public static void main(String[] args) throws WrongCredentialsException {

        Set<Integer> firstSet = new HashSet<>();
        firstSet.add(12);
        firstSet.add(4);
        firstSet.add(8);

        Set<Integer> secondSet = new HashSet<>();
        secondSet.add(12);
        secondSet.add(5);
        secondSet.add(8);

        System.out.println("Intersect below");
        Intersect.intersect(firstSet, secondSet);
        System.out.println("Union below");
        Union.unionMethod(firstSet, secondSet);

        System.out.println(" ");
        System.out.println("Exceptions message below (if available)");
        System.out.print(" ");

        Exceptionstest.checkLogin("q2_#");
        Exceptionstest.checkPasswordOrConfirmPassword("password____1111#", "password____1111");
    }
}

