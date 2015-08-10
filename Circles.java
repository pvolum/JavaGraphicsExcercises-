
import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Circles extends JPanel{
	JFrame frame;
	JOptionPane option;
	float radius, x , y;
	
	public void paintComponent (Graphics g){
		
		super.paintComponent(g);
		

		g.fillOval((int)this.x, (int)this.y, (int)this.radius, (int)this.radius);

	}
	
	public void getInfo(){
		JPanel myPanel = new JPanel();
		JTextField rad= new JTextField(4);
		JTextField x = new JTextField(4);
		JTextField y = new JTextField(4);

		myPanel.add(new JLabel("Radius: "));
		myPanel.add(rad);
		
	    myPanel.add(Box.createHorizontalStrut(15)); 
	    
		myPanel.add(new JLabel("X-Cordiante: "));
		myPanel.add(x);
		
	    myPanel.add(Box.createHorizontalStrut(15)); 
		
		myPanel.add(new JLabel("Y-Cordinate: "));
		myPanel.add(y);
		
		JOptionPane.showConfirmDialog(null, myPanel, 
	               "Please Enter Radius, X, and Y Values for desired circle", JOptionPane.OK_CANCEL_OPTION);

		this.radius = Integer.parseInt(rad.getText());
		this.x = Integer.parseInt(x.getText());
		this.y = Integer.parseInt(y.getText());
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circles cpanel= new Circles();
		
		cpanel.getInfo();
		float d =  ((cpanel.radius) *2);
		float c =  (float) ((cpanel.radius) * 2 * Math.PI);
		float a = (float) ((cpanel.radius) * (cpanel.radius) * Math.PI);
		
		String s = ("Diameter = " + d + "  Circumference= " + c + "  area= " + a);
		
		JFrame f = new JFrame();
		final int width = 800, height = 600;
		f.setSize(width, height);
		f.setTitle("Circles.java");
		f.add(cpanel);
		f.add(new JLabel( s ), BorderLayout.SOUTH);
		f.setVisible(true);    

	}
}
