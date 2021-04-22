package list;
/**
 * Especificación del TAD ListInterface
 * @since 07/03/2018  
 * @version 1.0.1   14/03/2018  JGF
 * @author JMB y JGF
 */
public interface ListInterface <E> 
{
  
  /**
   * add (index : int; element : E) 
   * PRE: index in {0..size()-1}
   * EFECTO: Coloca <element> en <index> y desplaza los elementos 
   *         que había una posición a la derecha.
   */
  public void add (int index, E element) 
    throws IndexOutOfBoundsException;
  /**
   * get (index : int) : E
   * PRE: index in {0..size()-1}
   * POST: Devuelve el elemento que est en la posicion <index>.
   */ 
  public E get (int index) throws IndexOutOfBoundsException;
  /**
   * size () : int
   * POST: Devuelve el número de elems que hay en la lista.
   */
  public int size ();
  /**
   * set (index : int; element : E)
   * PRE: index in {0..size()-1}
   * POST: Coloca <element> en la posición index de la lista 
   *       destruyendo el elemento que había en esa posición.
   */
  public void set (int index, E element)
    throws IndexOutOfBoundsException;
  /**
   * indexOf (element : E) : int
   * POST: Devuelve la posición que ocupar el primer elemento 
   *       de la lista que es igual a <element>, o -1 si no existe.
   */
  public int indexOf (E element);
  /**
   * removeElementAt (index : int) 
   * PRE: index in {0..size()-1}
   * EFECTO: Quita de la lista el elemento que est en la posicion 
   *         <index>.
   */
  public void removeElementAt (int index) 
    throws IndexOutOfBoundsException;
  /**
   * remove (element : E) : boolean
   * EFECTO: Si existe un elemento igual a <element> en la lista, 
   *         lo elimina y devuelve true. En caso contrario devuelve 
   *         false.
   */ 
  public boolean remove (E element);
  
}
