//https://inf.ug.edu.pl/~piotao/java/
import java.io.*;
// główna klasa do hakowania numeru PESEL
class HackPesel{
  class Pesel{   // klasa wewnętrzna, "ukryta" przed światem
    String str;
    int len;
    int[] val;
    Pesel(String p){     // konstruktor, bierze napis i przypisuje go do pól
    	str = p;           // napis do napisu (oryginalny)
    	len = str.length(); // oblicza długość napisu
    	val = new int[len]; // definiuje nową pustą tablicę
    	for(int i=0; i<len; i++)
        val[i] = Integer.valueOf(str.charAt(i)) - 48;  // i przepisuje do niej cyfry
    }
    String toStr(){      // zwraca napis zawierający treść numeru pesel tekstowo i liczbowo
    	String out = str+":[";         // napis to "PESEL:[", gdzie PESEL to numer
    	for(int i=0; i<len; i++){
    		out += val[i];         // dodaje do całego napisu cyfrę kolejną
    		out += (i==len-1) ? "]" : ","; // dodaje ",", a tylko na końcu dodaje "]"
    	}
    	return out;
    }
    String fromVal(){     // tworzy napis taki jak pesel, ale z tablicy liczb, które są w val[]
    	String s = ""; // niepotrzebne przypisanie, ale poprawia samopoczucie programistom C
    	for(int i=0; i<len; i++){
    		s += (char) (val[i]+48);
    	}
    	return s;
    }
  }
  Pesel pesel;     // reprezentacja klasowa - bebechy pesela - 11 cyfr jako ASCII i liczby
  String error;    // komunikat błędu dot. PESEL
  HackPesel(String p){       // konstruktor głównej klasy
  	pesel = new Pesel(p); // proste zdefiniowanie numeru pesel trzymanego w klasie wewnętrznej
  }
  void print(){
  	System.out.println(pesel.toStr());
  }                                                     // wypisanie pesel
  void print(String s){
  	System.out.println(s);
  }                                                     // wypisanie czegokolwiek
  // sprawdzanie długości (i ustawienie rodzaju błędu)
  boolean validLen(Pesel p){
  	if(p.len != 11) {
  		error = "Zła długość, nie jest 11 znaków.";
  		return false;
  	}
  	else{
  		error = "";
  		return true;
  	}
  }
  // sprawdzanie poprawności PESEL robione metodą z WIKI
  // 1×a + 3×b + 7×c + 9×d + 1×e + 3×f + 7×g + 9×h + 1×i + 3×j, a potem 10-sum%10
  // https://pl.wikipedia.org/wiki/PESEL
  // funkcja BIERZE klasę wewnętrzną jako ARGUMENT
  boolean valid(Pesel p){
  	if(validLen(p)) {
  		int[] m = {1,3,7,9,1,3,7,9,1,3}; // tablica mnożników zgodnie ze wzorem
  		int sum = 0;
  		for(int i=0; i<m.length; i++){
  			sum += m[i] * p.val[i];
  		}
  		sum = 10 - sum % 10;
  		if( sum == p.val[p.len-1] ){
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
  void hack(){    // sprawdza wszystkie cyfry PESELu +-1 czy będzie dobry numer
  	print("hack: Rozpoczynam hakowanie.");
  	// tutaj mamy zmienną pesel, która zawiera tablicę numerów pesel.val, które możemy "mutować"
  	// mutowanie polega na tym,że zmieniamy każdą wartość o 1 w górę lub w dół, otrzymując "nowy"
  	// numer pesel, który sprawdzimy za pomocą funkcji valid
  	for(int i=0; i<pesel.len-1; i++){ // lecimy przez pierwsze 10 cyfr
  		int cyfra = pesel.val[i];
  		pesel.val[i] = (cyfra+1)%10;
  		Pesel p = new Pesel(pesel.fromVal());
  		print("test dla "+color(p.toStr(),i,RED)+" "+(valid(p) ? BLUE+"POZYTYWNY"+RESET : "NEGATYWNY"));
  		pesel.val[i] = (cyfra-1+10)%10;
  		p = new Pesel(pesel.fromVal());
  		print("test dla "+color(p.toStr(),i,GREEN)+" "+(valid(p) ? BLUE+"POZYTYWNY"+RESET : "NEGATYWNY"));
  		pesel.val[i] = cyfra; // przywrócenie do poprzedniego stanu danej cyfry w oryginalnym peselu
  	}
  	print("hack: Koniec testów");
  }
  // robi 1 znak z napisu na pozycji n kolorowym wg. koloru c i zwraca cały napis
  String color(String s,int n,String c){
  	// tego typu prosty zapis NIE DZIAŁA zbyt dobrze. --> dlaczego?
  	//return s.substring(0,n)+c+s.substring(n,1)+RESET+s.substring(n+1);
  	//String txt = new StringBuilder(s).insert(n+1,RESET).toString();
  	//return new StringBuilder(txt).insert(n,c).toString();
  	return new StringBuilder(s).insert(n+1,RESET).insert(n,c).toString();
  }
  // program główny
  public static void main(String[] args){
  	// jeżeli nie podaliśmy numeru jako argument do programu, krzycz i zdechnij z błędem
  	if (args.length!=1) {
  		System.out.println("Podaj pesel.");
  		System.exit(1);
  	}
  	// zrób klasę do hakowania i podaj jej pierwszy argument wywołania, czyli nasz pesel
  	HackPesel p = new HackPesel(args[0]);
  	System.out.print("Podano PESEL: "); p.print();
  	if(p.valid(p.pesel)){
  		System.out.println("Ten numer jest PRAWIDŁOWY.");
  	}
  	else{
  		System.out.println("Numer nieprawidłowy: "+p.error);
  	}
  	p.hack();
  }
}
