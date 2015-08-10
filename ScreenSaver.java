
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ScreenSaver extends JPanel implements ActionListener{
	JFrame frame;
	Timer timer;
	
	public ScreenSaver(){
		  timer = new Timer(1000, this);
		  timer.start();
	}
	
	
	public void paintComponent (Graphics g){
		Rectangle rec = new Rectangle();
		rec = this.getBounds();
		Random r = new Random(); 

		int x = rec.width;
		int y = rec.height;
		
		super.paintComponents(g);
		
		Graphics2D g2 = (Graphics2D) g;		
				
		for (int i = 0; i < 100 ; i++){	
			g2.setColor(new Color( r.nextInt( 256 ),           
	               r.nextInt( 256 ), r.nextInt( 256 )));
			
			int xc =  r.nextInt(x);
			int xy =  r.nextInt(y);

			g2.setStroke(new BasicStroke(r.nextInt(20)));
			g2.draw( new Line2D.Double(r.nextInt(x), r.nextInt(y), xc, xy));
			
		}
		
	}
	
	
	public static void main (String [] args){
		ScreenSaver spanel = new ScreenSaver();
		spanel.frame = new JFrame();

		int height = 600, width = 800;
		spanel.frame.setSize(width, height);
		spanel.frame.setTitle("ScreenSaver.java");
		spanel.frame.add(spanel);
		spanel.frame.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

}
