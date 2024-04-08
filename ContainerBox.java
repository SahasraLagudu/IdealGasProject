package IdealGasSimulator;

import java.awt.*; 

public class ContainerBox {
	
	int minX; int minY; int maxX; int maxY; 
	private static final Color boxBorder = Color.BLACK; 
	private static final Color boxColor = Color.BLUE; 

	public ContainerBox() {
		minX = 0; minY = 0; 
		maxX = 20; maxY = 30; 
	}

	public ContainerBox(int x, int y, int width, int height) {
		minX = x; minY = y; 
		maxX = x + width - 1; maxY = y + height - 1; 
	}

	public void set(int new_height) {
		maxY = new_height; 
	}


	public void draw(Graphics g) {
		g.setColor(boxColor);
	    g.fillRect(minX, minY, maxX - minX - 1, maxY - minY - 1);
	    g.setColor(boxBorder);
	    g.drawRect(minX, minY, maxX - minX - 1, maxY - minY - 1);
	}	
}
