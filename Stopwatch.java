/*
 *Date: August 31, 2018
 *Filename: Stopwatch.java
 *Language: Java
 *Editor: Notepad++
 *Compiler: javac
 *Operating System Used: Windows 10
 */
 
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

/*
 *This class creates a stopwatch for counting time in seconds, to one decimal place.
 *The user can start, stop and reset the stopwatch at any time by clicking
 *the buttons with the mouse or by using keyboard shortcuts.
 */
public class Stopwatch {
	
/*
 *The main method contains all the methods for the class,
 *notably adding the StopwatchPanel which contains all the 
 *code that makes the stopwatch work.
 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Stopwatch");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new StopwatchPanel());
		
		frame.pack();
		frame.setVisible(true);
	}
}
