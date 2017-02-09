import java.io.*;
import java.util.Scanner;

class DwaUlamki{
  Ulamek ulam1, ulam2;
  DwaUlamki(Ulamek u1, Ulamek u2){
    ulam1=u1;
    ulam2=u2;
	}
  int NWD(int a, int b){
    while (a!=b)
      if (a>b) a-=b;
      else b-=a;
    return a;
  }
  double wyn_add, wyn_min, wyn_mul, wyn_div;
  String add(Ulamek u1, Ulamek u2){
    int l=u1.licznik*u2.mianownik+u2.licznik*u1.mianownik;
    int m=u1.mianownik*u2.mianownik;
    int z=0;
    if (l<0 || m<0) z=1;
    if (l<0 && m<0) z=0;
    if (l<0) l*=-1;
    if (m<0) m*=-1;
    int p=NWD(l, m);
    l/=p;
    m/=p;
    if (z==1) l*=-1;
    wyn_add=(double)l/(double)m;
    return (l + "/" + m);
  }
  String min(Ulamek u1, Ulamek u2){
    int l=u1.licznik*u2.mianownik-u2.licznik*u1.mianownik;
    int m=u1.mianownik*u2.mianownik;
    int z=0;
    if (l<0 || m<0) z=1;
    if (l<0 && m<0) z=0;
    if (l<0) l*=-1;
    if (m<0) m*=-1;
    int p=NWD(l, m);
    l/=p;
    m/=p;
    if (z==1) l*=-1;
    wyn_min=(double)l/(double)m;
    return (l + "/" + m);
  }
  String mul(Ulamek u1, Ulamek u2){
    int l=u1.licznik*u2.licznik;
    int m=u1.mianownik*u2.mianownik;
    int z=0;
    if (l<0 || m<0) z=1;
    if (l<0 && m<0) z=0;
    if (l<0) l*=-1;
    if (m<0) m*=-1;
    int p=NWD(l, m);
    l/=p;
    m/=p;
    if (z==1) l*=-1;
    wyn_mul=(double)l/(double)m;
    return (l + "/" + m);
  }
  String div(Ulamek u1, Ulamek u2){
    int l=u1.licznik*u2.mianownik;
    int m=u2.licznik*u1.mianownik;
    int z=0;
    if (l<0 || m<0) z=1;
    if (l<0 && m<0) z=0;
    if (l<0) l*=-1;
    if (m<0) m*=-1;
    int p=NWD(l, m);
    l/=p;
    m/=p;
    if (z==1) l*=-1;
    wyn_div=(double)l/(double)m;
    return (l + "/" + m);
  }
  String printDecimal(Ulamek u1, Ulamek u2){
    java.text.DecimalFormat df=new java.text.DecimalFormat(); //tworzymy obiekt DecimalFormat
    df.setMinimumFractionDigits(2); //dla df ustawiamy najmniejszą ilość miejsc po przecinku
    df.setMaximumFractionDigits(4); //dla df ustawiamy największą ilość miejsc po przecinku
    return ("Wynik dodawania:\t" + df.format(wyn_add) + "\nWynik odejmowania:\t" + df.format(wyn_min) +
            "\nWynik mnożenia:\t\t" + df.format(wyn_mul) + "\nWynik dzielenia:\t" + df.format(wyn_div));
  }
}

class Ulamek{
  int licznik, mianownik;
  Ulamek(int l, int m){
    licznik=l;
    mianownik=m;
  }
  Ulamek(){
    this(0, 1);
  }
  int switchPrint(){
    Scanner in=new Scanner(System.in);
    System.out.println("Jak wypisywać dane?");
    System.out.println("1 - ulamkowo (np. 1/2)");
    System.out.println("2 - dziesietnie (np. 0.5)");
    int x=in.nextInt();
    if (x!=1 && x!=2){
      System.out.println("Oszukujesz!");
      System.exit(0);
    }
    return x;
  }
  static void takeNum(){
    System.out.println("Podaj licznik i mianownik ulamka:");
  }
  void isZero(){
    if (mianownik==0){
      System.out.println("Mianownik musi byc rozny od 0!");
      System.exit(0);
    }
  }
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    Ulamek ulam1=new Ulamek();
    Ulamek ulam2=new Ulamek();
    DwaUlamki total=new DwaUlamki(ulam1, ulam2);
    int out=ulam1.switchPrint();
    takeNum();
    ulam1.licznik = in.nextInt();
    ulam1.mianownik = in.nextInt();
    ulam1.isZero();
    takeNum();
    ulam2.licznik = in.nextInt();
    ulam2.mianownik = in.nextInt();
    ulam2.isZero();
    if (out==1){
      System.out.println("Wynik dodawania:\t" + total.add(ulam1, ulam2));
      System.out.println("Wynik odejmowania:\t" + total.min(ulam1, ulam2));
      System.out.println("Wynik mnożenia:\t\t" + total.mul(ulam1, ulam2));
      System.out.println("Wynik dzielenia:\t" + total.div(ulam1, ulam2));
    }
    if (out==2){
      total.add(ulam1, ulam2);
      total.min(ulam1, ulam2);
      total.mul(ulam1, ulam2);
      total.div(ulam1, ulam2);
      System.out.println(total.printDecimal(ulam1, ulam2));
    }
  }
}
