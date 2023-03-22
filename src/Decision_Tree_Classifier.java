import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Decision_Tree_Classifier {

    public static LinkedHashMap<String, HashMap<String,Long>> CompareAttributeAndTarget(List attribute, List target){
//        LinkedHashMap<String,List> data = new LinkedHashMap<>();
        LinkedHashMap<String,HashMap<String,Long>> data = new LinkedHashMap<>();
        List distinct = (List) attribute.stream().distinct().collect(Collectors.toList());
        for(int i=0;i<distinct.size();i++){
            List l1 = new ArrayList<>();
            for(int j=0;j<attribute.size();j++){
                if(attribute.get(j)==distinct.get(i)) {
                    l1.add(target.get(j));
                }
            }
//            data.put((String) distinct.get(i),l1);
            HashMap<String,Long> ct = (HashMap<String,Long>) l1.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
            data.put((String) distinct.get(i),ct);
        }
        return data;
    }

    public static float Info_D(Map<String,Long> target){
        float info_d = 0.0f;
        float target_sum = (float) target.values().stream().mapToLong(Long::longValue).sum();
        for(Long i:target.values()){
            info_d+=(-((i/target_sum)*(Math.log((i/target_sum))/Math.log(2))));
        }
        return info_d;
//        System.out.println("INFO_D = "+info_d);
    }
    public static float Info_D_attribute(LinkedHashMap<String, List> data,String attribute,String Target){
        List<Map<String,Long>> lt = new ArrayList<Map<String,Long>>(CompareAttributeAndTarget(data.get(attribute),data.get(Target)).values());
        float Info_D_attr = 0.0f;
        float total_sum = data.get(Target).size();
        for(int i=0;i<lt.size();i++){
            int sum = (int) lt.get(i).values().stream().mapToLong(Long::longValue).sum();
            Info_D_attr+=(((float) sum/total_sum)*Info_D(lt.get(i)));
        }
        return Info_D_attr;
    }


    public static void main(String[] args) {
        LinkedHashMap<String, List> data = new LinkedHashMap<>();
        String[] attributes = {"Outlook","Temperature","Humidity","Windy"};
        String[][] attribute_values = new String[][]{{"sunny","sunny","overcast","rain","rain","rain","overcast","sunny","sunny","rain","sunny","overcast","overcast","rain"},
                {"hot","hot","hot","mild","cool","cool","cool","mild","cool","mild","mild","mild","hot","mild"},
                {"high","high","high","high","normal","normal","normal","high","normal","normal","normal","high","normal","high"},
                {"false","true","false","false","false","true","true","false","false","false","true","true","false","true"}
        };
        String Target = "Play?";
        String[] Target_values = new String[]{"NO","NO","YES","YES","YES","NO","YES","NO","YES","YES","YES","YES","YES","NO"};


        for(int i=0;i<attributes.length;i++){
            data.put(attributes[i],Arrays.asList(attribute_values[i]));
        }
        data.put(Target,Arrays.asList(Target_values));
        System.out.println(data);

        for(int i=0;i<attributes.length;i++){
            System.out.println(attributes[i]+" --> "+CompareAttributeAndTarget(data.get(attributes[i]),data.get(Target)));
        }

        Map<String,Long> TargetDistinctCounts = (Map<String, Long>) data.get(Target).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(TargetDistinctCounts);
        System.out.println(TargetDistinctCounts.values());
        System.out.println(TargetDistinctCounts.values().stream().mapToLong(Long::longValue).sum());
        System.out.println(Info_D(TargetDistinctCounts));

        System.out.println("Information Gain For Each Attribute ");
        for(String i:attributes){
            Float Information_Gain = (Info_D(TargetDistinctCounts)-Info_D_attribute(data,i,Target));
            System.out.println(i+" --> "+String.format("%.3f",Information_Gain));
        }











//        System.out.println(Target+" --> "+TargetDistinctCounts.values().getClass().getName());
//        System.out.println(TargetDistinctCounts.values());


//        String[] attributes = {"ChestPain","GoodBloodCirculation","BlockedArteries"};
//        LinkedHashMap<String, List> data = new LinkedHashMap<>();
//        data.put("ChestPain", Arrays.asList(new String[]{"yes","yes","no","yes","no","no","yes","yes","no","yes"}));
//        data.put("GoodBloodCirculation", Arrays.asList(new String[]{"no","yes","yes","yes","no","no","yes","no","no","yes"}));
//        data.put("BlockedArteries", Arrays.asList(new String[]{"yes","yes","yes","yes","no","no","yes","yes","no","no"}));
//        data.put("HeartDisease", Arrays.asList(new String[]{"no","yes","no","yes","no","yes","no","yes","yes","no"}));

//        System.out.println(data.get("ChestPain").stream().distinct().collect(Collectors.toList()));
//        System.out.println(data.get("ChestPain"));
//        HashMap<String,Integer> ct = (HashMap<String, Integer>) data.get("ChestPain").stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//        System.out.println(ct);
//        System.out.println(data.get("ChestPain").stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
//        System.out.println("ChestPain --> "+CompareAttributeAndTarget(data.get("ChestPain"),data.get("HeartDisease")));





    }
}
