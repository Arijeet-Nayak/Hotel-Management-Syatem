import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

	HotelManagementSystem() {
//		setSize(999, 727); 
//		setLocation(250, 50); //will not open from top left		
		setBounds(250, 50, 999, 727);
		
		setLayout(null);
		
		
		//putting image on frmae
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/welcome.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(0, 0, 999, 727); //location_x, location_y, length, breadth
		add(image);
		
		
		JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		text.setBounds(20, 600, 1000, 90);
		//text.setForeground(Color.white);
		text.setFont(new Font("serif", Font.PLAIN, 40));
		image.add(text); //to add the text above image
		
		
		JButton next = new JButton("Next");
		next.setBounds(870, 630, 100, 40);
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("serif", Font.PLAIN, 24));
		next.addActionListener(this);
		image.add(next);
		
		
		setVisible(true);
		
		
		//blinking feature of text
		while(true) {
			text.setVisible(false);
			try {
				Thread.sleep(500); //0.5 seconds sleep
			} catch(Exception e) {
				e.printStackTrace();
			}
			text.setVisible(true);
			try {   //to keep the visibility for 0.5seconds
				Thread.sleep(500);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		setVisible(false);
		new Login();
	}
	
	
	public static void main(String[] args) {
		
		new HotelManagementSystem();
	}

}
