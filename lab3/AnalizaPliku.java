import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class AnalizaPliku{
  public File file;
  public Scanner input;
  public int[] arr;
  void readFile(String filename){
    file = new File (filename);
    try{
      input = new Scanner(file);
    }
    catch (FileNotFoundException ex){
      System.out.println("File Not Found\n");
    }
  }
  void countCharacters(){
    int words = 0;
    int lines = 0;
    int chars = 0;
    int character;
    while (input.hasNextLine()){
      lines++;
      String line = input.nextLine();
      for (int i=0;i<line.length();i++){
        if (line.charAt(i)!=' ' && line.charAt(i)!='\n'){
          chars ++;
          character = (int)line.charAt(i);
          arr[character]++;
        }
      }
      words += new StringTokenizer(line, " ,").countTokens();
    }
    System.out.println("Liczba wierszy: " + lines);
    System.out.println("Liczba slow: " + words);
    System.out.println("Liczba znakow: " + chars);
  }
  void timeOfFile(){
    long diff = new Date().getTime() - file.lastModified();
    System.out.println(diff/60/60/1000 + "h");
  }
  void zeroArr(){
    arr = new int[256];
    for (int i=0; i<=255; i++){
      arr[i]=0;
    }
  }
  void printArr(){
    String character = Character.toString ((char) 97);
    int max=0;
    for (int i=0; i<=255; i++){
      if (arr[i]>max){
        max=arr[i];
        character = Character.toString ((char) i);
      }
    }
    System.out.println("Najwieksza liczba znakow \"" + character + "\" : " + max);
  }
  public static void main(String[] filename) throws FileNotFoundException{
    AnalizaPliku program = new AnalizaPliku();
    program.zeroArr();
    System.out.print("Wczytuje plik tekstowy! ");
    program.readFile(filename[0]);
    System.out.println("Charakterystyka pliku:");
    program.countCharacters();
    program.printArr();
    System.out.print("Czas istnienia pliku: ");
    program.timeOfFile();
  }
}
