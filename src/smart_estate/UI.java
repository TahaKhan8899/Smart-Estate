/**
 * Brief: UI module provides basic functions for CLI.

 * Prerequisite: Functions for options in menu needs to be implemented separately.
 * Usage: N/A.
 * 
 * @author Aquila
 */

package smart_estate;

public class UI
{
  /**
   * Print the object in the form of a menu.
   * @param obj The object to be printed
   */
  public static void menu(String[] obj) 
  {
    for(int i = 0; i < obj.length; i++)
      System.out.println(i + ") " + obj[i]);
  }

  public static void main(String[] args)
  {
    String[] cases = {"case0", "case1", "case2"};
    menu(cases);
  }
}
