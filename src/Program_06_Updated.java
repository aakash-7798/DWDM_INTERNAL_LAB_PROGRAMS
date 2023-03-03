
// Firstly Download Weka Software in your laptop or desktop

//       Download Link     https://sourceforge.net/projects/weka/files/weka-3-9/

// After Installing go to windows c folder
// look for program_files then check weka-9 or weka-8 version folder
//  Double click that file then you will see a jar file called weka-jar  not weka-src jar
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



//https://weka.sourceforge.io/doc.dev/weka/associations/Apriori.html


//6. Write a program to implement apriori algorithm.


import weka.associations.Apriori;
import weka.associations.AssociationRules;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import java.util.*;


public class Program_06_Updated {
    //     Don't Forget to mentions throws Exception otherwise you keep getting errors
    public static void main(String[] args) throws Exception {

        DataSource source = new DataSource("C:\\Program Files\\Weka-3-9-6\\data\\supermarket.arff");
        Instances data = source.getDataSet();
        Apriori ap = new Apriori();
        ap.buildAssociations(data);
        System.out.println(ap);

//        ArrayList<Object>[] allrules = ap.getAllTheRules();
//
//        System.out.println(allrules.toString());


        AssociationRules ar = ap.getAssociationRules();
        System.out.println(ar.getRules());

         String[] parameterNames = ap.getRuleMetricNames();
         System.out.println(Arrays.toString(parameterNames));

         System.out.println(ap.globalInfo());
        System.out.println(ap.getTechnicalInformation());
//        ap.getAssociationRules();

    }
}
