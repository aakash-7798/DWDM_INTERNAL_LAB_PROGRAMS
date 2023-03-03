//https://stackoverflow.com/questions/70102302/why-occur-runtime-exception-when-call-buildclassifier-with-weka-for-java
//https://stackoverflow.com/questions/41265266/how-to-solve-inaccessibleobjectexception-unable-to-make-member-accessible-m/41265267#41265267
//https://stackoverflow.com/questions/8112041/error-while-using-weka-api-in-java-code-class-attribute-not-set
//https://stackoverflow.com/questions/26096086/weka-decision-tree-java
//https://stackoverflow.com/questions/15637553/weka-simplekmeans-cannot-handle-string-attributes
//https://www.tabnine.com/code/java/classes/weka.classifiers.evaluation.Evaluation

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

// For Intellij
// Click on edit configurations which is present right upper corner adjacent to hammer symbol click on drop down list
// Then you see modify options in right dialogue box after clicking that there will be option called     Add Vm Options


// For VisualStudioCode
// When  you open dwdm_internal_lab_program you will see options in explorer like you folder name ,outline,timelines,javaprojects
// select javaprojects dropdown after clicking that you will see anothor drop down called referenced library there click on + symbol
// add weka jar file

//  After this right click on any opened file then click debug java
// then at left side you will see you will see run and debug button below there will a option call launch json file click it
//  then add below option to program 06_updated ,program_07,program_08,program_09 below to projectname

                      // "vmArgs": "--add-opens java.base/java.lang=ALL-UNNAMED"

                    //   Now right click on file then you will see debug java option click on it
                    // you will get the output


//8. Write a program to create decision tree classifier for given training data and find accuracy of the
//        decision tree using test data set.

//https://weka.sourceforge.io/doc.dev/weka/associations/FPGrowth.html

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Program_08 {
        //     Don't Forget to mentions throws Exception otherwise you keep getting errors
    public static void main(String[] args) throws Exception {

//            DataSet Names in Weka Folder Data Folder  -> Check this folder in
//            Windows C  ProgramFiles Search Weka Folder click on it and after then click on Data Folder
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
