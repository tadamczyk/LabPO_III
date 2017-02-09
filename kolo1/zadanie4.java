// Program, który zwraca informacje, czy podany tekst jako argument funkcji jest palindromem

import java.io.*;                                                               // dołączenie klas z pakietu io
import java.util.*;                                                             // dołączenie klas z pakietu util

class Palindrome{                                                               // rozpoczęcie klasy Palindrome
  String s;                                                                     // zadeklarowanie obiektu s klasy String
  Palindrome(){}                                                                // utworzenie domyślnego konstruktora klasy Palindrome
  Palindrome(String s){                                                         // utworzenie konstruktora klasy Palindrome z parametrem będącym obiektem klasy String
    this.s = s;                                                                 // przypisanie zmiennej s parametru przekazywanego do konstruktora
  }
  boolean isPalindrome(){                                                       // rozpoczęcie metody sprawdzającej, czy podany wyraz jest palindromem
    int size = s.length();                                                      // zadeklarowanie i zdefiniowanie zmiennych size i halfSize typu int
    int halfSize = s.length()/2;
    for (int i=halfSize; i>=0; i--)                                             // pętla porównująca kolejne litery w lewo i w prawo od środka leżące w równej odległości
      if (s.charAt(i) != s.charAt(size-i-1)) return false;                      // jeśli dwie litery równo odległe od środka sie różnią zwróć fałsz
    return true;                                                                // jeśli nie zwrócił wcześniej fałszu to zwróć prawde
  }
  public static String standard(String s){                                      // rozpoczęcie metody, która ustawia wszystkie znaki w podanym tekście na małe litery
    return (s.toLowerCase());                                                   // zwróć podany napis w postaci zapisanej tylko na małych literach
  }
}

class CheckIsPalindrome extends Palindrome{                                     // rozpoczęcie głównej klasy CheckIsPalindrome dziedziczącej po klasie Palindrome
  public static void main(String[] args){                                       // rozpoczęcie funkcji main klasy CheckIsPalindrome
    String total = new String();                                                // utworzenie obiektu total klasy String
    for (int i=0; i<args.length; i++) total+=args[i];                           // przepisanie do obiektu total argumentów podanych podczas uruchamiania programu
    total = standard(total);                                                    // wywołanie metody standard dla obiektu total klasy String i zwrócenie wyniku metody do obiektu total, więc zapisanie podanego tesktu jako argumenty tylko małymi literami
    Palindrome p = new Palindrome(total);                                       // utworzenie obiektu p klasy Palindrome z wykorzystaniem konstruktora z parametrem total
    if (p.isPalindrome()) System.out.println("Podany wyraz JEST palindromem."); // wywołanie metody isPalindrome klasy Palindrome dla obiektu p i wypisanie tekstu na ekran jesli jest prawdą
    else System.out.println("Podany wyraz NIE JEST palindromem.");              // a tutaj wypisanie odpowiedzi jeśli metoda isPalindrome dla obiektu p zwraca fałsz
  }
}
