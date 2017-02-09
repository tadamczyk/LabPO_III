class Gra{
  public String nazwa;
  public String gatunek;
  public String platforma;
  public Gra(){
    nazwa = "Policja";
    gatunek = "Przygodowa";
    platforma = "Zycie";
  }
}

class Laborki{
  public static void main(String[] args){
    System.out.println("Biblioteczka");
    Gra gra0 = new Gra();
    gra0.nazwa = "Crash Bandicoot";
    gra0.gatunek = "Platformer";
    gra0.platforma = "PlayStation";
    Gra graPaly = new Gra();
    System.out.println(graPaly.toString());
    System.out.println(graPaly.nazwa);
    System.out.println(graPaly.gatunek);
    String napis = new String("Jakis napis");
    System.out.println(napis.length());
  }
}
