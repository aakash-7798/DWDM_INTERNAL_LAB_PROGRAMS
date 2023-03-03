//https://stackoverflow.com/questions/41265266/how-to-solve-inaccessibleobjectexception-unable-to-make-member-accessible-m/41265267#41265267
//https://stackoverflow.com/questions/8112041/error-while-using-weka-api-in-java-code-class-attribute-not-set
//https://stackoverflow.com/questions/26096086/weka-decision-tree-java
//https://stackoverflow.com/questions/15637553/weka-simplekmeans-cannot-handle-string-attributes



// Firstly Download Weka Software
// After Installing go to windows c folder
// look for program_files then check weka-9 or weka-8 version folder
//  Double click that file then you will see a jar file called weka-jar
// add weka-jar file to the dependencies or classpath of your java program


//add the below option in VM options:
//        --add-opens java.base/java.lang=ALL-UNNAMED


// For Eclipse

// right click the project. Click Run as then Run Configurations. You can change the parameters passed to the JVM in the Arguments tab in the VM Arguments box.
//         That configuration can then be used as the default when running the project.

// For Intellij
// Click on edit configurations which is present right upper corner adjacent to hammer symbol click on drop down list
// Then you see modify options in right dialogue box after clicking that there will be option called     Add Vm Options


import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import java.util.Random;

public class DecisionTreeDemo  {
    public static void main(String[] args) throws Exception {
//            breast-cancer
//            credit-g
//            ReutersCorn
//            ReutersGrain

            DataSource train_source = new DataSource("C:\\Program Files\\Weka-3-9-6\\data\\segment-challenge.arff");
            DataSource test_source = new DataSource("C:\\Program Files\\Weka-3-9-6\\data\\segment-test.arff");

            Instances train = train_source.getDataSet();
            Instances test = test_source.getDataSet();

            train.setClassIndex(train.numAttributes()-1);
            test.setClassIndex(test.numAttributes()-1);




//            J48 tree = new J48();
            Classifier cls = new J48();
            cls.buildClassifier(train);

            Evaluation eval = new Evaluation(train);
            eval.crossValidateModel(cls,train,10,new Random(1));
            eval.evaluateModel(cls,test);


//           System.out.println("Correlation Coefficient = "+eval.correlationCoefficient());
//            System.out.println("Area Under ROC "+eval.areaUnderROC(3));
//           System.out.println("Accuracy = "+eval.pctCorrect());

           System.out.println(eval.toMatrixString());
           System.out.println(eval.toClassDetailsString());

            System.out.println(eval.toSummaryString("\nResults\n======\n", false));

//            tree.buildClassifier(data);
//            System.out.println(tree.graph());
//            System.out.println(J48.);
//            System.out.println(tree.toString());
//            System.out.println(data.numAttributes());
//            System.out.println(data.attributeStats(1));
        }

    }

