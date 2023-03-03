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



//https://weka.sourceforge.io/doc.dev/weka/clusterers/SimpleKMeans.html
//https://www.tabnine.com/code/java/classes/weka.clusterers.SimpleKMeans

//9. Write a program to cluster given data using k-means.

import weka.clusterers.SimpleKMeans;
import weka.core.Capabilities;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Program_09 {
    //     Don't Forget to mentions throws Exception otherwise you keep getting errors
    public static void main(String[] args) throws Exception {

        DataSource source = new DataSource("C:\\Program Files\\Weka-3-9-6\\data\\iris.arff");
        Instances data  = source.getDataSet();

        SimpleKMeans kmeans = new SimpleKMeans();
        kmeans.buildClusterer(data);
        System.out.println(kmeans);

        System.out.println("Number of Clusters = "+kmeans.getNumClusters());
        System.out.println("Cluster Standard Deviations = "+kmeans.getClusterStandardDevs());

//        Instances stdevs = kmeans.getClusterStandardDevs();
//        System.out.println(stdevs.attributeStats(0));

//
        System.out.println("Cluster Centroids = "+kmeans.getClusterCentroids());

//        System.out.println(kmeans.displayStdDevsTipText());

//        int[] assignments = kmeans.getAssignments();
//        System.out.println(Arrays.toString(assignments));
//        int i = 0;
//        for (int clusterNum : assignments) {
//            System.out.printf("Instance %d -> Cluster %d", i, clusterNum);
//            i++;
//        }


        kmeans.setNumClusters(3);
        kmeans.setMaxIterations(100);
        kmeans.buildClusterer(data);
        System.out.println(kmeans);

        System.out.println("Number of Clusters = "+kmeans.getNumClusters());

        Instances clusterCentroids = kmeans.getClusterCentroids();
        for (int j = 0; j < clusterCentroids.numInstances(); j++) {
            Instance centroid = clusterCentroids.instance(j);
            System.out.println(centroid);

        }

        System.out.println("\nSum of Squared Errors = "+ kmeans.getSquaredError());

        Capabilities cp = kmeans.getCapabilities();
        System.out.println(cp);
    }
}
