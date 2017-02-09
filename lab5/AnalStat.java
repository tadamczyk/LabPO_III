import java.io.*;
import java.util.*;
import java.math.*;

public class AnalStat{
  public static File file;
  public static Scanner inputToCL, inputToGD;
  public static double[] A;
  void readFile(String filename){
    file = new File (filename);
    try{
      inputToCL = new Scanner(file);
      inputToGD = new Scanner(file);
    }
    catch (FileNotFoundException ex){
      System.out.println("File Not Found");
      System.exit(0);
    }
  }
  int countLines(){
    int lines = 0;
    while (inputToCL.hasNextLine()){
      lines++;
      String line = inputToCL.nextLine();
    }
    return lines;
  }
  void getData(){
    int i = 0;
    while (inputToGD.hasNextLine()){
      String line = inputToGD.nextLine();
      A[i] = Double.parseDouble(line);
      i++;
    }
  }
  public static double avg(double[] nums){
    double wyn = 0;
    for (int i=0; i<nums.length; i++)
      wyn += nums[i];
    wyn /= nums.length;
    return wyn;
  }
  public static double standardDev(double[] nums){
    double wyn = 0;
    for (int i=0; i<nums.length; i++){
      double r = (nums[i] - avg(nums));
      wyn += (r*r);
      //wyn = Math.sqrt(variance(nums));                    //wersja S
    }
    wyn /= nums.length;
    wyn = Math.sqrt(wyn);
    return wyn;
  }
  public static double variance(double[] nums){
    double wyn = 0;
    double wynAvg = avg(nums);
    for (int i=0; i<nums.length; i++){
      //wyn += (nums[i] - wynAvg) * (nums[i] - wynAvg);     //wersja S
      wyn = Math.pow(standardDev(nums), 2);
    }
    //wyn /= (nums.length-1);                               //wersja S
    return wyn;
  }
  public static String precision(double str){
    java.text.DecimalFormat df = new java.text.DecimalFormat();
    df.setMinimumFractionDigits(2);
    df.setMaximumFractionDigits(4);
    return df.format(str);
  }
  void calc(int len){
    double[] B = new double[10];
    for (int i=0; i<=len; i++){
      if (i>=10){
        for (int j=i-10, k=0; k<10; j++, k++)
          B[k] = A[j];
        System.out.println((i-9) + ". " + precision(avg(B)) + "\t\t" +
                          precision(standardDev(B)) + "\t\t" + precision(variance(B)));
      }
    }
  }
  public static void main(String[] filename) throws FileNotFoundException{
    AnalStat as = new AnalStat();
    as.readFile(filename[0]);
    int len = as.countLines();
    A = new double[len];
    as.getData();
    as.calc(len);
  }
}
