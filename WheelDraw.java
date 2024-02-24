import java.awt.* ;
import java.awt.event.* ;
import java.awt.geom.* ; //  Classes GeneralPath etc.
import java.awt.image.* ;
import javax.swing.* ;

public class WheelDraw {
		int radius;
		int rotationIncrement;
		int currentRotation = 0;
		BufferedImage wheel_image ;
		public WheelDraw() {
			radius = 50;
			rotationIncrement = 6;
			wheel_image  =  new BufferedImage( radius*2, radius*2, BufferedImage.TYPE_INT_RGB ) ;
			}
	
		
		

		 public void draw( Graphics2D  graphics2D,  Point wheel_corner )
		 {

  Graphics2D  image_graphics  =  wheel_image.createGraphics() ;
  image_graphics.setPaint(new Color(6,12,233)) ;
  image_graphics.fill(new Rectangle2D.Double( 0, 0, radius*2, radius*2));
  image_graphics.translate( radius, radius ) ;
  int  right  =  0 ;  
  while (right < 360 )
  {
     image_graphics.setPaint( Color.red ) ;
     image_graphics.setStroke( new BasicStroke( 8) ) ;
     image_graphics.draw( new Arc2D.Double(-radius + 4, -radius + 4, radius * 2 - 8, radius * 2 - 8, right+  5, 30, Arc2D.PIE ) ) ;	
right  +=  30 ;
}
graphics2D.drawImage(wheel_image, wheel_corner.x, wheel_corner.y, null ) ;
}
		public BufferedImage getWheel_image() {
			return wheel_image;
		}




		public void setWheel_image(BufferedImage wheel_image) {
			this.wheel_image = wheel_image;
		}




		public int getRadius() {
			return radius;
		}
		public void setRadius(int radius) {
			this.radius = radius;
		}
		 
}



