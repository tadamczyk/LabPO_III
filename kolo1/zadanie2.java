import java.io.*;

class Cyfra{
  int suma;
  String nazwa;

  Cyfra(){
    suma = 0;
    nazwa = "Tomasz Adamczyk";
  }

  public static boolean isVowel(char c){
    return "AEIOUYaeiouy".indexOf(c) != -1;
  }

  int analize(char z){
    if (isVowel(z)) suma+=3;
    if (!isVowel(z) && z%2==0) suma+=1;
    if (!isVowel(z) && z%2==1) suma-=2;
    return suma;
  }

  public static void main(String[] args){
    Cyfra magiczna = new Cyfra();
    String remWS = magiczna.nazwa.replace(" ", "");
    for (int i=0; i<remWS.length(); i++)
      magiczna.analize(remWS.charAt(i));
    System.out.println("Moja magiczna cyfra to " + magiczna.suma);
  }
}
