package auxi;
/** 
 * Funciones auxiliares. 
 * @author Javier Galve
 * @version 1.3   03/04/2019
 */

public class Auxi
{ 
  /**
   * divide (a, b : int) : boolean
   * POST: Devuelve cierto si a es divisor de b y falso eoc.
   */ 
  public static boolean divide (int a, int b)
  {
    return  (a != 0) && (b % a== 0);
  }
  /**
   * esPar (n : int) : boolean
   * PRE: n>=0
   * POST: Devuelve cierto si n es par y falso eoc.
   */ 
  public static boolean esPar (int n)
  {
    return  n % 2 == 0;
  }
  /**
   * max (a, b : int) : int
   * POST: Calcula el mayor entre a y b.
   * POST: (resultado IN {a,b}) /\ (resultado >= a) /\ (resultado >= b)
   */ 
  public static int max (int a, int b)
  {
    if (a >= b) 
      return a;
    else
      return b;
  }
  /**
   * min (a, b : int) : int
   * POST: Calcula el menor entre a y b.
   * POST: (resultado IN {a,b}) /\ (resultado <= a) /\ (resultado <= b)
   */ 
  public static int min (int a, int b)
  {
    if (a<=b) 
      return a;
    else
      return b;
  } 
  /**
   enIntervalo (x, a, b : double) : boolean 
   POST: Devuelve cierto si y solo si x esta? en el intervalo [a, b] 
   POST: resultado = a <= x <= b
   */
  public static boolean enIntervalo (double x, double a, double b)
  {
    return a <= x && x <= b;
  } 
  /**
   esIgual (x, y : double) : boolean 
   POST: Comparador de igualdad entre reales por aproximaci�?
         de un EPSILON fijado localmente.
   Devuelve cierto si y solo si x = y +- EPSILON
   DONDE: EPSILON = <<error de precisi�?>>
   POST: Devuelve cierto si y solo si x est�? en el 
   intervalo [y + EPSILON, y - EPSILON] 
   */
  public static boolean esIgual (double x, double y)
  {
    final double EPSILON = 0.001;
    return enIntervalo(x, y - EPSILON, y + EPSILON);
  } 
  /**
   cuadratica (a, b, c, x : int) : int
   POST: Calcula a*x^2+b*x+c.
   */
  public static int cuadratica (int a, int b, int c, int x)
  {
    return a * (int)Math.pow(x, 2) + b * x + c;
  }
  /**
   posicionMayor (posA, valorA, posB, valorB : int) : int
   POST: Dados dos valores enteros valorA y valorB y sus 
   posicioines respectivas, posA y posB, devolver 
   la posici�? del que sea mayor de los dos valores.
   valorA >= valorB  --> posA
   eoc               --> posB
   */ 
  public static int posicionMayor (int posA, int valorA, int posB, int valorB)
  {
    if (valorA >= valorB)
      return posA;
    else
      return posB;
  }
  /**
   abs (a : int) : int
   POST: Calcula el valor absoluto de a.
   */ 
  public static int abs (int a) 
  {
    if (a >= 0) 
      return a;
    else
      return -a;
  }
  /**
   delta (p : boolean) : int
   POST: p   --> resultado = 1
         eoc --> resultado = 0
   */ 
  public static int delta (boolean p) 
  {
    if (p) 
      return 1;
    else
      return 0;
    //return p? 1 : 0;
  }
  /*
   * aleatorio (n : int) : int
   * POST: Genera un n鷐ero aleatorio en el rango [0, |n-1|] 
   */       
  public static int aleatorio (int n) { 
    return (int)(Math.random() * Math.abs(n));
  }
  /*
   * aleatorio (a, b : int) : int
   * POST: Genera un n鷐ero aleatorio en el rango [a, b] 
   */       
  public static int aleatorio (int a, int b) { 
    return (int)(Math.random() * Math.abs(b-a+1)) + a;
  }
  /*
   parteDecimal (x : double) : double
   PRE: cierto
   POST: resultado es la parte decimal del n鷐ero real <x>
   */
  public static double parteDecimal (double x)
  {
    return x - (int)x;
  }
  /*
   aMayuscula (letra : char) : char
   PRE: letra IN ['a','z']
   POST: resultado es la mayuscula correspondiente a <letra>
   */
  public static char aMayuscula (char letra)
  {
    return (char)(letra - 'a' + 'A');
  }
  /* 
   aMinuscula (letra : char) : char
   PRE: letra IN ['A','Z']
   POST: resultado es la minuscula correspondiente a <letra>
   */
  public static char aMinuscula (char letra)
  {
    return (char)(letra - 'A' + 'a');
  }
  /* 
   esperar1segundo ()
   EFECTO: Pausa la ejecuci�? durante un segundo.
   */
  private static void espera1segundo ()
  {
    double ahora = System.currentTimeMillis();
    double dentroDe1Seg = ahora + 1000; 
    while (System.currentTimeMillis() < dentroDe1Seg);
  }
  /* 
   espera (segundos : int)
   EFECTO: Pausa la ejecuci�? durante <segundos>.
   */
  public static void espera (int segundos)
  {
    for (int i = 1; i <= segundos; i++)
      espera1segundo();
  }
  /* 
   esMenor (s1, s2 : String) : boolean
   POST: Determina si <s1> es lexicogr醘icamente menor que <s2>.
   */
  public static boolean esMenor (String s1, String s2)
  {
    return s1.compareTo(s2) < 0;
  }
  

}