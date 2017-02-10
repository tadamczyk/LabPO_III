import java.io.*;
class HackPesel{
  class Pesel{
    String str;
    int len;
    int[] val;

    Pesel(String p){
    	str = p;
    	len = str.length();
    	val = new int[len];
    	for (int i=0; i<len; i++)
        val[i] = Integer.valueOf(str.charAt(i)) - 48;
    }

    String toStr(){
    	String out = str+":[";
    	for (int i=0; i<len; i++){
    		out += val[i];
    		out += (i==len-1) ? "]" : ",";
    	}
    	return out;
    }

    String fromVal(){
    	String s = "";
    	for (int i=0; i<len; i++){
    		s += (char) (val[i]+48);
    	}
    	return s;
    }
  }

  Pesel pesel;
  String error;

  HackPesel(String p){
  	pesel = new Pesel(p);
  }

  void print(){
  	System.out.println(pesel.toStr());
  }

  void print(String s){
  	System.out.println(s);
  }

  boolean validLen(Pesel p){
  	if (p.len != 11){
  		error = "Zła długość, nie jest 11 znaków.";
  		return false;
  	}
  	else{
  		error = "";
  		return true;
  	}
  }

  boolean valid(Pesel p){
  	if (validLen(p)){
  		int[] m = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
  		int sum = 0;
  		for (int i=0; i<m.length; i++){
  			sum += m[i] * p.val[i];
  		}
  		sum = 10 - sum % 10;
  		if (sum == p.val[p.len-1]){
  			error = "";
  			return true;
  		}
  		else{
  			error = "Zła suma kontrolna.";
  			return false;
  		}
  	}
  	else{
  		return false;
  	}
  }
  public String RESET = "\u001B[0m";
  public String RED   = "\u001B[1;31m";
  public String GREEN = "\u001B[1;32m";
  public String BLUE  = "\u001B[0;36m";
  void hack(){
  	print("hack: Rozpoczynam hakowanie.");
  	for (int i=0; i<pesel.len-1; i++){
  		int cyfra = pesel.val[i];
  		pesel.val[i] = (cyfra+1)%10;
  		Pesel p = new Pesel(pesel.fromVal());
  		print("test dla " + color(p.toStr(),i,RED) + " " + (valid(p) ? BLUE + "POZYTYWNY" + RESET : "NEGATYWNY"));
  		pesel.val[i] = (cyfra-1+10)%10;
  		p = new Pesel(pesel.fromVal());
  		print("test dla " + color(p.toStr(),i,GREEN) + " " + (valid(p) ? BLUE + "POZYTYWNY" + RESET : "NEGATYWNY"));
  		pesel.val[i] = cyfra;
  	}
  	print("hack: Koniec testów");
  }

  String color(String s, int n, String c){
  	return new StringBuilder(s).insert(n+1, RESET).insert(n, c).toString();
  }
  public static void main(String[] args){
  	if (args.length!=1){
  		System.out.println("Podaj pesel.");
  		System.exit(1);
  	}
  	HackPesel p = new HackPesel(args[0]);
  	System.out.print("Podano PESEL: ");
    p.print();
  	if (p.valid(p.pesel)){
  		System.out.println("Ten numer jest PRAWIDŁOWY.");
  	}
  	else{
  		System.out.println("Numer nieprawidłowy: "+p.error);
  	}
  	p.hack();
  }
}
