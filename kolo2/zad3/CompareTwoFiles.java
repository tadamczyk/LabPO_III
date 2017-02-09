// Program w formie "okienkowej" sprawdza,
// czy podane nazwy plików mają taką samą zawartość znakową.
// W uruchomionym oknie podajemy nazwy plików znajdujących się w tym samym folderze co program.
// Program sprawdza, czy zawartość podanych plików jest tak sama i wyświetla odpowiedź.
// Program może okazać się pomocny w porównaniu odpowiedzi przekierowanych z wyjścia Twojego dowolnego programu
// z prawidłowymi odpowiedziami znajdującymi się w innym pliku.
// Dodatkowe pliki do testowania programu: test1.txt, test2 (taka sama zawartość jak test1.txt)
// oraz test3.tx (inna zawartość niż poprzednie pliki).

// importowanie klas z podanych poniżej pakietów
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CompareTwoFiles extends JFrame implements ActionListener {                // utworzenie klasy CompareTwoFiles dziedziczącej po klasie JFrame zawierająca elementy interfejsu ActionListener
  JTextField first, second;                                                     // deklarujemy pola tekstowe dla wporwadzenia nazw pierwszego i drugiego pliku
  JButton compare;                                                              // deklarujemy przycisk porównania plików
  JLabel labFirst, labSecond;                                                   // deklarujemy pola do wpisywania nazw plików
  JLabel labResult;                                                             // deklarujemy pole, gdzie będzie wypisywany wynik

  CompareTwoFiles(){                                                            // rozpoczęcie konstruktora klasy
    setTitle("Compare two text files");                                         // ustawienie tytułu tworzonego okna
    setLayout(new FlowLayout());                                                // ustawienie nowego obiektu FlowLayout jako menedżera układu okna
    setSize(240, 240);                                                          // ustawienie początkowych rozmiarów okna
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                             // ustawienie zakończenia działania okna na skutek jego zamknięcia
    setIconImage(new ImageIcon("icon.png").getImage());                         // ustawienie ikony okna
    first = new JTextField(16);                                                 // utworzenie pola tekstowego do wprowadzenia pierwszej nazwy pliku i ustawienie domyślnej liczby kolumn na 16
    second = new JTextField(16);                                                // utworzenie pola tekstowego do wprowadzenia drugiej nazwy pliku i ustawienie domyślnej liczby kolumn na 16
    first.setActionCommand("FirstFile");                                        // ustawienie tekstu dla pola tekstowego first
    second.setActionCommand("SecondFile");                                      // ustawienie tesktu dla pola tekstowego second
    compare = new JButton("Compare");                                           // utworzenie przycisku porównania dwóch plików
    compare.addActionListener(this);                                            // dodanie słuchacza zdarzeń dla przycisku compare
    getRootPane().setDefaultButton(compare);                                    // ustawienie compare jako domyślny przycisk i umożliwienie jego "wciśniecie" klawiszem Enter
    labFirst = new JLabel("First file: ");                                      // utworzenie etykiety labFirst
    labSecond = new JLabel("Second file: ");                                    // utworzenie etykiety labSecond
    labResult = new JLabel("");                                                 // utworzenie etykiety labResult
    // umieszczenie elementów w oknie bez określenia ich pozycji,
    // aby mogły one dostosowywać swoje położenie w zależności od zmian rozmiaru okna
    add(labFirst);                                                              // umieszczenie etykiety labFirst w oknie
    add(first);                                                                 // umieszczenie pola tekstowego first w oknie
    add(labSecond);                                                             // umieszczenie etykiety labSecond w oknie
    add(second);                                                                // umieszczenie pola tekstowego second w oknie
    add(compare);                                                               // umieszczenie przycisku compare w oknie
    add(labResult);                                                             // umieszczenie etykiety wynikowej w oknie
    setVisible(true);                                                           // ustawienie widoczności okna
  }

  public void actionPerformed(ActionEvent e){                                   // utworzenie metody wykonującej akcję po naciśnięciu przycisku compare
    int i = 0, j = 0;                                                           // zadeklarowanie i zdefinowanie zmiennych pomocniczych typu całkowitego
    if (first.getText().equals("") && second.getText().equals("")){             // sprawdzenie czy zostały podane obie nazwy pliku
      labResult.setText("No filenames!");                                       // ustawienie tekstu etykiety labResult, czyli wyświetlenie go w oknie
      labResult.setForeground(new Color(255, 0, 0));                            // ustawienie koloru napisu etykiety labResult na czerwony
      labResult.setFont(new Font("Arial", Font.BOLD, 20));                      // ustawienie czcionki etykiety labResult
      return;                                                                   // return
    }
    if (first.getText().equals("")){                                            // sprawdzenie czy została podana pierwsza nazwa pliku
      labResult.setText("No name of the first file!");                          // ustawienie tekstu etykiety labResult, czyli wyświetlenie go w oknie
      labResult.setForeground(new Color(255, 0, 0));                            // ustawienie koloru napisu etykiety labResult na czerwony
      labResult.setFont(new Font("Arial", Font.BOLD, 14));                      // ustawienie czcionki etykiety labResult
      return;                                                                   // return
    }
    if (second.getText().equals("")){                                           // sprawdzenie czy została podana druga nazwa pliku
      labResult.setText("No name of the second file!");                         // ustawienie tekstu etykiety labResult, czyli wyświetlenie go w oknie
      labResult.setForeground(new Color(255, 0, 0));                            // ustawienie koloru napisu etykiety labResult na czerwony
      labResult.setFont(new Font("Arial", Font.BOLD, 14));                      // ustawienie czcionki etykiety labResult
      return;                                                                   // return
    }
    // porównanie plików o nazwach podanych w oknie przy użyciu
    // rozszerzonej instrukcji try do zarządzania plikami
    try (FileInputStream f1 = new FileInputStream(first.getText());             // utworzenie nowego obiektu f1 klasy FileInputStream i przypisanie do niego zawartości pierwszego pliku
         FileInputStream f2 = new FileInputStream(second.getText())){           // utworzenie nowego obiektu f2 klasy FileInputStream i przypisanie do niego zawartości drugiego pliku
    // porównanie zawartości plików
      do{                                                                       // początek pętli while
        i = f1.read();                                                          // przypisanie zmiennej pomocniczej i wartości liczbowej kodu ASCII danego znaku z pliku pierwszego
        j = f2.read();                                                          // przypisanie zmiennej pomocniczej j wartości liczbowej kodu ASCII danego znaku z pliku drugiego
        if (i!=j) break;                                                        // sprawdzenie czy wartości i oraz j są różne, jeśli tak to wyskakuje z pętli
      } while (i!=-1 && j!=-1);                                                 // ustawienie warunku w pętli while (dopóki i oraz j są różne od -1, czyli końca pliku)
      if (i!=j){                                                                // sprawdzenie czy i oraz j są różne, czyli czy zawartość plików się różni; jeśli tak to:
        labResult.setText("Files are different");                               // ustawienie tekstu etykiety labResult, czyli wyświetlenie go w oknie
        labResult.setForeground(new Color(0, 0, 200));                          // ustawienie koloru napisu etykiety labResult na niebieski
        labResult.setFont(new Font("Arial", Font.BOLD, 20));                    // ustawienie czcionki etykiety labResult
      }
      else{                                                                     // jeśli i oraz j się nie różnią to:
        labResult.setText("Files are the same");                                // ustawienie tekstu etykiety labResult, czyli wyświetlenie go w oknie
        labResult.setForeground(new Color(0, 200, 0));                          // ustawienie koloru napisu etykiety labResult na zielony
        labResult.setFont(new Font("Arial", Font.BOLD, 20));                    // ustawienie czcionki etykiety labResult
      }
    } catch(IOException exc){                                                   // ustawienie wyjątku
      labResult.setText("File(s) do(es) not exist!");                           // ustawienie tekstu etykiety labResult, czyli wyświetlenie go w oknie
      labResult.setForeground(new Color(255, 0, 0));                            // ustawienie koloru napisu etykiety labResult na czerwony
      labResult.setFont(new Font("Arial", Font.BOLD, 14));                      // ustawienie czcionki etykiety labResult
    }
  }

  public static void main(String[] args){                                       // rozpoczęcie funkcji głównej klasy
    EventQueue.invokeLater(new Runnable(){                                      // rozpoczęcie funkcji invokeLater klasy EventQueue
      public void run(){                                                        // rozpoczęcie funkcji run
        new CompareTwoFiles();                                                  // utworzenie nowego obiektu klasy CompareTwoFiles
      }
    });
  }
}
