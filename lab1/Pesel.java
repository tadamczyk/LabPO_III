import java.io.*;

class Pesel{
  String pesel;
  Pesel(String pes){
    pesel = pes;
  }
  int at(int n){
    return Character.getNumericValue(pesel.charAt(n));
  }
  int sum(){
    int sum=0;
    for (int l=0;l<10;l++){
      if (l%4==0) sum+=at(l);
      if (l%4==1) sum+=at(l)*3;
      if (l%4==2) sum+=at(l)*7;
      if (l%4==3) sum+=at(l)*9;
    }
    sum+=at(10);
    return sum;
  }
  boolean valid(){
    if (sum()%10==0) return true;
    else return false;
  }
  public static void main(String[] args){
    Pesel p = new Pesel(args[0]);
    if (p.valid()) System.out.println("PESEL is OK");
    else System.out.println("PESEL is WRONG");
  }
}
