import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener {

	Choice cCustomer;
	JTextField tfroom, tfavailable, tfstatus, tfpaid, tfpending;
	JButton check, update, back;
	
	UpdateRoom() {
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		
		JLabel text = new JLabel("Update Room Status");
		text.setFont(new Font("Tahoma", Font.PLAIN, 25));
		text.setBounds(30, 20, 250, 30);
		text.setForeground(Color.blue);
		add(text);
		
		JLabel lblid = new JLabel("Customer ID");
		lblid.setBounds(30, 80, 100, 20);	
		add(lblid);
		
		cCustomer = new Choice();
		cCustomer.setBounds(200, 80, 150, 25);
		add(cCustomer);
		
		try {
			
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while(rs.next()) {
				cCustomer.add(rs.getString("number"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		JLabel lblroom = new JLabel("Room Number");
		lblroom.setBounds(30, 130, 100, 20);	
		add(lblroom);
		
		tfroom =new JTextField();
		tfroom.setBounds(200, 130, 150, 25);
		add(tfroom);
		
		JLabel lblavailabl = new JLabel("Availability");
		lblavailabl.setBounds(30, 180, 100, 20);	
		add(lblavailabl);
		
		tfavailable =new JTextField();
		tfavailable.setBounds(200, 180, 150, 25);
		add(tfavailable);
		
		JLabel lblstatus = new JLabel("Cleaning Status");
		lblstatus.setBounds(30, 230, 100, 20);	
		add(lblstatus);
		
		tfstatus =new JTextField();
		tfstatus.setBounds(200, 230, 150, 25);
		add(tfstatus);
		
		
		check = new JButton("Check");
		check.setBackground(Color.black);
		check.setForeground(Color.white);
		check.setBounds(30, 300, 100, 30);
		check.addActionListener(this);
		add(check);
		
		update = new JButton("Update");
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.setBounds(150, 300, 100, 30);
		update.addActionListener(this);
		add(update);
		
		back = new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(270, 300, 100, 30);
		back.addActionListener(this);
		add(back);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/updateroom.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400, 50, 500, 300);
		add(image);
		
		
		setBounds(300, 200, 980, 450);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == check) {
			
			String id = cCustomer.getSelectedItem();
			String query = "select * from customer where number = '"+id+"'";
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				while(rs.next()) {
					tfroom.setText(rs.getString("room"));
				}
				
				ResultSet rs1 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
				while(rs1.next()) {
					tfavailable.setText(rs1.getString("availability"));
					tfstatus.setText(rs1.getString("cleaning_status"));
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(ae.getSource() == update) {
			String number = cCustomer.getSelectedItem();
			String room = tfroom.getText();
			String availabble = tfavailable.getText();
			String status = tfstatus.getText();
			
			
			try {
				Conn c = new Conn();				
				c.s.executeUpdate("update room set availability = '"+availabble+"', cleaning_status = '"+status+"' where roomnumber = '"+room+"'");
				JOptionPane.showMessageDialog(null, "Data Updated Successfully");
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			}
		else if(ae.getSource() == back) {
			setVisible(false);
			new Reception();
		}
	}
	
	
	public static void main(String[] args) {
		
		new UpdateRoom();
	}

}
