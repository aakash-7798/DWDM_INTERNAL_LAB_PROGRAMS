
// Firstly Download Weka Software in your laptop or desktop
// After Installing go to windows c folder
// look for program_files then check weka-9 or weka-8 version folder
//  Double click that file then you will see a jar file called weka-jar
// add weka-jar file to the dependencies or classpath of your java program


// For Every Program add this vm option
//add the below option in VM options:
//        --add-opens java.base/java.lang=ALL-UNNAMED


// For Eclipse

// right click the project. Click Run as then Run Configurations. You can change the parameters passed to the JVM in the Arguments tab in the VM Arguments box.
//         That configuration can then be used as the default when running the project.
//http://www.java2s.com/example/java/machine-learning-ai/use-weka-association-rules.html
// For Intellij
// Click on edit configurations which is present right upper corner adjacent to hammer symbol click on drop down list
// Then you see modify options in right dialogue box after clicking that there will be option called     Add Vm Options


//https://weka.sourceforge.io/doc.dev/weka/associations/FPGrowth.html#setMetricType-weka.core.SelectedTag


//7. Write a program to mine frequent patterns using FP-Growth.


import weka.associations.FPGrowth;
import weka.core.*;
import weka.core.converters.ConverterUtils.DataSource;

import java.util.Arrays;

public class Program_07 {
//     Don't Forget to mentions throws Exception otherwise you keep getting errors
    public static void main(String[] args) throws Exception {

        DataSource source = new DataSource("C:\\Program Files\\Weka-3-9-6\\data\\supermarket.arff");
        Instances data =  source.getDataSet();

        FPGrowth  fp = new FPGrowth();
        fp.buildAssociations(data);

        System.out.println(fp);

        System.out.println(fp.getMetricType());

        Tag[] tags  = fp.getMetricType().getTags();
        System.out.println(Arrays.toString(tags));

        String[] metricnames = fp.getRuleMetricNames();
        System.out.println(Arrays.toString(metricnames));

        Capabilities cp = fp.getCapabilities();
        System.out.println(cp);

        System.out.println(fp.findAllRulesForSupportLevelTipText());

        SelectedTag sltag = new SelectedTag(2,tags);

        System.out.println("Sltag = "+sltag);

//        fp.setOptions(Utils.splitOptions("-P 2 -I -1 -N 10 -T 1 -C 0.9 -D 0.05 -U 1.0 -M 0.1"));
        fp.setOptions(Utils.splitOptions("-T 3 "));
        fp.buildAssociations(data);
        System.out.println(fp);

    }
}
