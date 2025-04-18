import java.util.*;

public class Sets {
    



 public static void main(String[] args) {
    HashSet<String>  cities = new HashSet<>();

    cities.add("Delhi");
    cities.add("Chennai");
    cities.add("Nagpur");
    cities.add("Mumbai");
    cities.add("Nashik");
    System.out.println(cities);

    LinkedHashSet<String> lhs = new LinkedHashSet<>();
    lhs.add("Delhi");
    lhs.add("Chennai");
    lhs.add("Nagpur");
    lhs.add("Mumbai");
    lhs.add("Nashik");
    System.out.println(lhs);

    TreeSet<String> ts = new TreeSet<>();
    ts.add("Delhi");
    ts.add("Chennai");
    ts.add("Nagpur");
    ts.add("Mumbai");
    ts.add("Nashik");
    System.out.println(ts);


}
}
