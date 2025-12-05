public class Main {
  public static void main(String[] args) {
    int a = 10;
    int b = 5;
    int c = 7;
    int tmp = 0;

    if (a < b) {
      tmp = a;
      a = b;
      b = tmp;
    }
    if (b < c) {
      tmp = b;
      b = c;
      c = tmp;
    }
    if (a < b) {
      tmp = a;
      a = b;
      b = tmp;
    }
    System.out.println(tmp);
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);

  }
}
