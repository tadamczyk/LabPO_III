import java.io.*;

class Dane{
  int liczba;
  String napis;
  double wynik;

  Dane(){
    liczba = 8;
    napis = "Adamczyk";
    wynik = 4.0;
  }

  void printDane(){
    System.out.println(liczba);
    System.out.println(napis);
    System.out.println(wynik);
  }

  public static void main(String[] args){
    Dane ja = new Dane();
    ja.printDane();
  }
}
