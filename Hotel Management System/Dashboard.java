import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {

	
	
	Dashboard() {

		setBounds(0, 0, 1550, 1000);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1550, 1000);
		getContentPane().add(image);


		JLabel text = new JLabel("WE WELCOME YOU");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Tahoma", Font.BOLD, 46));
		text.setBounds(560, 80, 450, 50);
		image.add(text);


		JMenuBar mb = new JMenuBar();
		mb.setBounds(0, 0, 1550, 30);
		image.add(mb);

		JMenu hotel = new JMenu("HOTEL MANAGEMENT");
		hotel.setForeground(Color.red);
		mb.add(hotel);

		JMenu admin = new JMenu("ADMIN");
		admin.setForeground(Color.blue);
		mb.add(admin);
		
		JMenuItem reception = new JMenuItem("RECEPTION");
		reception.addActionListener(this);
		hotel.add(reception);
		
		

		JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
		addemployee.addActionListener(this);
		admin.add(addemployee);

		JMenuItem addrooms = new JMenuItem("ADD ROOMS");
		addrooms.addActionListener(this);
		admin.add(addrooms);

		JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
		adddrivers.addActionListener(this);
		admin.add(adddrivers);


		setVisible(true);
	}

	
	public void actionPerformed(ActionEvent ae) {


		if(ae.getActionCommand().equals("ADD EMPLOYEE")) {
			new AddEmployee();
		}
		else if(ae.getActionCommand().equals("ADD ROOMS")) {
			new AddRooms();
		}
		else if(ae.getActionCommand().equals("ADD DRIVERS")) {
			new AddDriver();
		}
		else if(ae.getActionCommand().equals("RECEPTION")) {
			new Reception();
		}
		

	}



	public static void main(String[] args) {


		new Dashboard();
	}

}
