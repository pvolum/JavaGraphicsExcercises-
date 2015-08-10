
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.util.Random;
import java.math.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Triangles extends JPanel{

	JFrame frame;
	Rectangle rec;
	
	public void paintComponent (Graphics g){
		
		this.rec = this.getBounds();

				
		int x = this.rec.width;
		int y = this.rec.height;
				
		super.paintComponent(g);
				
		Graphics2D g2d = ( Graphics2D ) g;  
			 
		Random R = new Random();
								

				
		
		for(int i = 0 ; i < 5 ; i++){
			
			int endx = Math.abs(R.nextInt() % x);
			int endy = Math.abs(R.nextInt() % y);
					
			int x1 = Math.abs(R.nextInt() % x);
			int x2 = Math.abs(R.nextInt() % x);
			int y1 = Math.abs(R.nextInt() % y);
			int y2 = Math.abs(R.nextInt() % y);

		
			int yPoints[] = { endy, y1, y2, endy };
			int xPoints[] = { endx, x1, x2, endx };
		
			GeneralPath triangle = new GeneralPath();
		
			triangle.moveTo(xPoints[ 0 ], yPoints[ 0 ]);
		
			for ( int count = 1 ; count < xPoints.length; count++ )     
				triangle.lineTo( xPoints[ count ], yPoints[ count ] ); 
			
		
			triangle.closePath();
			
			g2d.setColor( new Color( R.nextInt( 256 ),           
					R.nextInt( 256 ), R.nextInt( 256 ) ) );     

			g2d.fill( triangle );   
		}
	} 
	
	public static void main(String[] args) {
	    
		Triangles tpanel= new Triangles();
		tpanel.frame = new JFrame();
	    
	    final int width = 500, height = 500;
	    tpanel.frame.setSize(width, height);
	    tpanel.frame.setTitle("Trangles.java");
	    tpanel.frame.add(tpanel);
	    tpanel.frame.setVisible(true);
	    
	}

}
