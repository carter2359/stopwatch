/*
 *Date: August 31, 2018
 *Filename: StopwatchPanel.java
 *Language: Java
 *Editor: Notepad++
 *Compiler: javac
 *Operating System Used: Windows 10
 */ 
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

/*
 *This class creates the panel which contains all the code that makes the stopwatch work as intended.
 */
public class StopwatchPanel extends JPanel {
	
	private JButton start;
	private JButton stop;
	private JButton reset;
	
	private JPanel timeDisplay;
	private JPanel buttonDisplay;
	
	private JLabel time;
	private Timer timer;
	private double clock;
	private double startTime;
	
/*
 *This method is the constructor for the StopwatchPanel.
 *It sets up most of the stopwatch.
 */
	public StopwatchPanel() {
		
		time = new JLabel("Time: 0.0"); //initial time user sees
		timeDisplay = new JPanel(); //display time in its own panel for aesthetic purposes
		buttonDisplay = new JPanel(); //display buttons in their own panel for aesthetic purposes
		timer = new Timer(100, new TimerListener());
		
		//set up all buttons with names and their keyboard shortcuts (mnemonics)
		start = new JButton("START");
		start.setMnemonic('s');
		start.addActionListener(new JButtonListener());
		stop = new JButton("STOP");
		stop.setMnemonic('t');
		stop.addActionListener(new JButtonListener());
		reset = new JButton("RESET");
		reset.setMnemonic('r');
		reset.addActionListener(new JButtonListener());
		
		//aesthetics
		timeDisplay.setBackground(Color.cyan);
		timeDisplay.setPreferredSize(new Dimension(75, 50));
		buttonDisplay.setBackground(Color.cyan);
		buttonDisplay.setLayout(new BoxLayout(buttonDisplay, BoxLayout.X_AXIS));
		this.setBackground(Color.blue);
		this.setPreferredSize(new Dimension(280,100));
		
		//add all components to the panels
		timeDisplay.add(time);
		buttonDisplay.add(start);
		buttonDisplay.add(stop);
		buttonDisplay.add(reset);
		add(timeDisplay);
		add(buttonDisplay);
	}

/*
 *This class is the listener class for each of the JButtons.
 */
	private class JButtonListener implements ActionListener {
		
/*
 *This method is the required method for the ActionListener interface; 
 *it determines what happens in the program when each of the buttons are selected.
 */
		public void actionPerformed(ActionEvent event) {
			Object source = event.getSource();
							startTime = event.getWhen();

			if (source == start) {
				timer.start();
			} else if (source == stop) {
				timer.stop();
			} else {
				timer.stop();
				time.setText("Time: 0.0");
				clock = 0;//reset clock to 0 so that when START is pressed again, time begins at 0:0
			}
		}
	}

/*
 *This class is the listener class for the Timer.	
 */
	private class TimerListener implements ActionListener {
		
/*
 *This method is the required method for the ActionListener interface; 
 *it updates the timer's display to the user.
 */
		public void actionPerformed(ActionEvent event2) {
			clock = clock + (event2.getWhen()-startTime)/1000;
			NumberFormat nf = new DecimalFormat("#0.0");
			time.setText("Time: " + nf.format(clock));
		}
	}
}