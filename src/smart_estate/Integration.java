package smart_estate;

import java.awt.EventQueue;
import java.util.Scanner;

/**
 * This is the main class that integrates all other modules
 * 
 * @author tahakhan
 *
 */
public class Integration {
	
	public static void main(String[] args) {
		//launch the application
		run_Smart_Estate();
	}
	
	/**
	 * Generate a Window object which outputs a GUI to the screen
	 */
	private static void run_Smart_Estate()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
