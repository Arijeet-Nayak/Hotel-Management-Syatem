import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import javax.swing.*;

public class Checkout extends JFrame implements ActionListener {

	Choice cCustomer;
	JLabel lblroomnumber, lblcheckintime, lblcheckouttime;
	JButton checkout, back;
	
	Checkout() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel text = new JLabel("Checkout");
		text.setBounds(100, 20, 100, 30);
		text.setForeground(Color.blue);
		text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(text);
		
		JLabel lblid = new JLabel("Customer ID");
		lblid.setBounds(30, 80, 100, 30);
		add(lblid);
		
		cCustomer = new Choice();
		cCustomer.setBounds(150, 80, 150, 25);
		add(cCustomer);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
		Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(310, 80, 20, 20);
		add(image);
		
		
		JLabel lblroom = new JLabel("Room Number");
		lblroom.setBounds(30, 130, 100, 30);
		add(lblroom);
		
		lblroomnumber = new JLabel();
		lblroomnumber.setBounds(150, 130, 100, 30);
		add(lblroomnumber);
		
		JLabel lblcheckin = new JLabel("Check-in Time");
		lblcheckin.setBounds(30, 180, 100, 30);
		add(lblcheckin);
		
		lblcheckintime = new JLabel();
		lblcheckintime.setBounds(150, 180, 100, 30);
		add(lblcheckintime);
		
		
		JLabel lblcheckout = new JLabel("Check-out Time");
		lblcheckout.setBounds(30, 230, 100, 30);
		add(lblcheckout);
		
		
		Date date = new Date();
		
		
		lblcheckouttime = new JLabel(date+"");
		lblcheckouttime.setBounds(150, 230, 160, 30);
		add(lblcheckouttime);
		
		
		checkout = new JButton("Check-out");
		checkout.setBackground(Color.black);
		checkout.setForeground(Color.white);
		checkout.setBounds(30, 280, 120, 30);
		checkout.addActionListener(this);
		add(checkout);
		
		back = new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(170, 280, 120, 30);
		back.addActionListener(this);
		add(back);
		
		
		try {
			
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while(rs.next()) {
				cCustomer.add(rs.getString("number"));
				lblroomnumber.setText(rs.getString("room"));
				lblcheckintime.setText(rs.getString("checkintime"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/checkout.jpg"));
		Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image1 = new JLabel(i6);
		image1.setBounds(350, 50, 400, 250);
		add(image1);
		
		
		setBounds(300, 200, 800, 400);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == checkout) {
			
			String query = "delete from customer where number = '"+cCustomer.getSelectedItem()+"'";
			String query1 = "update room set availability = 'Available' where roomnumber = '"+lblroomnumber.getText()+"'";
			
			try {
				Conn c = new Conn();
				
				c.s.executeUpdate(query);
				c.s.executeUpdate(query1);
				
				JOptionPane.showMessageDialog(null, "Check-out Successfull");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			setVisible(false);
			new Reception();
		}
	}
	
	
	public static void main(String[] args) {

		new Checkout();
	}

}
