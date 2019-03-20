/**
 * Brief: Sort module uses 3-way quick sort for efficiency and space usage.
 * Prerequisite: The object to be sorted must implement Comparable interface including compareTo method and toString method.
 * Usage: Sort.sort(obj).
 * 
 * @author Aquila
 */

package smart_estate;

public class Sort
{
  /**
   * Sort the object in ascending order.
   * @param obj The object to be sorted
   */
  public static void sort(Comparable[] obj) 
  {
    shuffle(obj);
    sort(obj, 0, obj.length - 1);
  }

  /**
   * Sort the object with 3-way partitioning recursively.
   * @param obj The object to be sorted
   * @param l low index
   * @param h high index
   */
  private static void sort(Comparable[] obj, int l, int h) 
  { 
    if(h <= l)
      return;
    int lesser = l;
    int greater = h;
    int i = l + 1;
    while(i <= greater) 
    {
      if(lt(obj[i], obj[l])) 
        swap(obj, lesser++, i++);
      else if(gt(obj[i], obj[l])) 
        swap(obj, i, greater--);
      else
        i++;
    }
    sort(obj, l, lesser - 1);
    sort(obj, greater + 1, h);
  }

  /**
   * Test if v is less than w.
   * @param v One element
   * @param w Another element
   * @return True if less than, false otherwise
   */
  private static boolean lt(Comparable v, Comparable w)
  {
    return v.compareTo(w) < 0;
  }

  /**
   * Test if v is greater than w.
   * @param v One element
   * @param w Another element
   * @return True if greater than, false otherwise
   */
  private static boolean gt(Comparable v, Comparable w)
  {
    return v.compareTo(w) > 0;
  }
        
  /**
   * Swap obj[i] and obj[j].
   * @param obj A list of objects
   * @param i One index
   * @param j Another index
   */
  private static void swap(Object[] obj, int i, int j) 
  {
    Object tmp = obj[i];
    obj[i] = obj[j];
    obj[j] = tmp;
  }

  /**
   * Shuffle the object.
   * @param obj The object to be shuffled
   */
  private static void shuffle(Comparable[] obj)
  {
    int n = obj.length;
    for(int i = 0; i < n; i++) 
    {
      int j = i + (int) (Math.random() * (n - i));
      swap(obj, i, j);
    }
  }

  // There are some useful functions for testing below. 

  /**
   * Test if the object is sorted.
   * @param obj The object to be tested
   * @return True if sorted, false otherwise
   */
  private static boolean isSorted(Comparable[] obj) 
  {
    return isSorted(obj, 0, obj.length - 1);
  }

  /**
   * Test if the object is sorted.
   * @param obj The object to be tested
   * @return True if sorted, false otherwise
   */
  private static boolean isSorted(Comparable[] obj, int l, int h) 
  {
    for(int i = l + 1; i <= h; i++)
      if(lt(obj[i], obj[i - 1])) 
        return false;
    return true;
  }

  /**
   * Print the object.
   * @param obj The object to be printed
   */
  private static void printArray(Comparable[] obj) 
  {
    for (int i = 0; i < obj.length; i++)
      System.out.print(obj[i] + " ");
    System.out.println("");
  }

  public static void main(String[] args)
  {
    Integer[] list = {7, 4, 2, 3, 5, 1, 6}; 
    printArray(list);
    sort(list);
    printArray(list);
    if(isSorted(list))
      System.out.println("The object is sorted.");
    else
      System.out.println("The object is not sorted.");
  }
}
