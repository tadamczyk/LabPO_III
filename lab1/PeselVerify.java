import java.io.*;

class PeselVerify{
  String pesel;

  PeselVerify(String pes){
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

  boolean alter(){
    int sum=0, t, t1=1;
    for (int m=0;m<2;m++){
      for (int l=0;l<10;l++){
        sum=0;
        t=(at(l)-t1)%10;
        if (t==-1) t=9;
        for (int k=0;k<10;k++){
          if (k==l) continue;
          if (k%4==0) sum+=at(k);
          if (k%4==1) sum+=at(k)*3;
          if (k%4==2) sum+=at(k)*7;
          if (k%4==3) sum+=at(k)*9;
        }
        sum=sum+t+at(10);
        if (sum%10==0) return true;
      }
      t1=-1;
    }
    if (sum()-1==0) return true;
    if (sum()+1==0) return true;
    return false;
  }

  public static void main(String[] args){
    PeselVerify p = new PeselVerify(args[0]);
    if (p.valid()) System.out.println("PESEL is OK");
    else System.out.println("PESEL is WRONG");
    if (p.alter()) System.out.println("PESEL has alternative");
    else System.out.println("PESEL hasn't alternative");
  }
}
