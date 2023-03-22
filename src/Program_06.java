// Written by Aakash Nadupalli

//6. Write a program to implement apriori algorithm.

import java.util.*;


public class Program_06 {

    public static LinkedHashMap<String,Integer> C1_count(ArrayList<String> lst)
    {
        LinkedHashMap<String,Integer> count_list = new LinkedHashMap<>();
        for(int i=0;i<lst.size();i++){
            String[] split_data = lst.get(i).split(",");
            for(int j=0;j<split_data.length;j++){
                if(!count_list.containsKey(split_data[j])){
                    count_list.put(split_data[j],0);
                }
                if(count_list.containsKey(split_data[j])){
                    count_list.put(split_data[j],count_list.get(split_data[j])+1);
                }
            }
        }
        return count_list;
    }


    public static boolean pattern_check(String item,String[] split_data){
        List bl = new ArrayList<>();
        for(int i=0;i<split_data.length;i++){
            if(item.contains(split_data[i])){
                bl.add(true);
            }
            else{
                bl.add(false);
            }
        }
//        System.out.println(bl);
        return bl.stream().allMatch(e->e.equals(true));
    }
    public static LinkedHashMap<String,Integer> C2_count(ArrayList<String> items,ArrayList<String >key_list)
    {
        LinkedHashSet<String> combinations = new LinkedHashSet<>();
        for(int i=0;i<key_list.size();i++){
            for(int j=i+1;j<key_list.size();j++)
                if(!combinations.contains(key_list.get(i)+","+key_list.get(j)))
                {combinations.add(key_list.get(i)+","+key_list.get(j));}
        }

        LinkedHashMap<String,Integer> count_list = new LinkedHashMap<>();
        for(int i=0;i<items.size();i++)
        {
            for(int j=0;j<combinations.size();j++){
                ArrayList<String> al = new ArrayList<>(combinations);
                String[] split_data = al.get(j).split(",");
//                if(items.get(i).contains(split_data[0]) && items.get(i).contains(split_data[1]))
                boolean bl = pattern_check(items.get(i),split_data);
                if(bl==true)
                {
                    if(!count_list.containsKey(al.get(j))){
                        count_list.put(al.get(j),0);
                    }
                    if(count_list.containsKey(al.get(j))){
                        count_list.put(al.get(j),count_list.get(al.get(j))+1);
                    }
                }
                else{
                    if(!count_list.containsKey(al.get(j))){
                        count_list.put(al.get(j),0);
                    }
                }
            }
        }
        return count_list;
    }


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

        int support_count = 2;
        double minimum_confidence = 0.6;

        ArrayList<String> vl = new ArrayList<>(itemsets.values());
//        System.out.println(vl);
//        System.out.println(vl.get(0));
        LinkedHashMap<String,Integer> C1 = C1_count(vl);
//        System.out.println(C1);

        System.out.println("Candidate Set 1");
        System.out.println(C1);
        System.out.println("Itemset"+"  "+"Support_Count");
        C1.forEach((k,v)->System.out.println("\t"+k+"\t\t\t"+v));
        C1.entrySet().removeIf(v-> v.getValue()<support_count);


        ArrayList<String> key_list  = new ArrayList<>(C1.keySet());
//        System.out.println(key_list);


        LinkedHashMap<String,Integer> C2 = C2_count(vl,key_list);
//        System.out.println(C1);

        System.out.println("\nCandidate Set 2");
        System.out.println("Before SupportCount Check -> "+C2);
        System.out.println("Itemset"+"  "+"Support_Count");
        C2.forEach((k,v)->System.out.println(k+"\t\t"+v));
        C2.entrySet().removeIf(v-> v.getValue()<support_count);
        System.out.println("After SupportCount Check -> "+C2);
//        System.out.println(pattern_check("I1,I2,I3",new String[]{"I1","I5"}));


        LinkedHashMap<String,Integer> C3 = C2_count(vl,new ArrayList<>(C2.keySet()));

        System.out.println("\nCandidate Set 3");
        System.out.println("Before SupportCount Check -> "+C3);
        System.out.println("Itemset"+"  "+"Support_Count");
        C3.forEach((k,v)->System.out.println(k+"\t\t"+v));
        C3.entrySet().removeIf(v-> v.getValue()<support_count);
        System.out.println("After SupportCount Check -> "+C3);






//        System.out.println(vl.get(0).contains(new ArrayList<>(comb).get(0)));
//        LinkedHashMap<String,Integer> C2 = C2_count(vl,new ArrayList<>(comb));
//        System.out.println(C2);
//        System.out.println(C1.keySet());

//        System.out.println(vl.get(0).indexOf("I2,I5"));

    }
}
