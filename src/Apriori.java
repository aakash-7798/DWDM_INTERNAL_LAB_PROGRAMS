
//https://stackoverflow.com/questions/29122394/word-frequency-count-java-8

import java.util.LinkedHashMap;

public class Apriori {
    public static void main(String[] args) {
        LinkedHashMap<String ,String> itemsets = new LinkedHashMap<>();
        itemsets.put("T1","I1,I2,I5");
        itemsets.put("T2","I2,I4");
        itemsets.put("T3","I2,I3");
        itemsets.put("T4","I1,I2,I4");
        itemsets.put("T5","I1,I3");
        itemsets.put("T6","I2,I3");
        itemsets.put("T7","I1,I3");
        itemsets.put("T8","I1,I2,I3,I5");
        itemsets.put("T9","I1,I2,I3");
//        System.out.println(itemsets);
//        System.out.println(itemsets.values());
//        System.out.println(itemsets.values().stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
    }
}
