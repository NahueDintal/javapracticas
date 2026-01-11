public class Main {
  public static void main(String[] args) {

    Camara camara1 = new Camara(01, "Cam001", "Ezviz", "C09", 3, 70000, "wifi");
    camara1.mostrarInformacion();

    Candado candado1 = new Candado(02, "Can001", "Olaen", "Art.30", 5, 30000, 2);
    candado1.mostrarInformacion();

    // Cerradura cerradura1 = new Cerradura(03, "Cer001", "Prive", "208", 6, 35000,
    // 4);
    // cerradura1.mostrarInformacion();
  }
}
