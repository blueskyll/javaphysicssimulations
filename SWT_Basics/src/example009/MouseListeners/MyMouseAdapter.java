package example009.MouseListeners;

import org.eclipse.swt.events.*;

public class MyMouseAdapter extends MouseAdapter {
    String etykieta;
    
    public MyMouseAdapter(String etykieta) {
	super();
	this.etykieta = etykieta;
    }

    public void mouseDown(MouseEvent e) {
	System.out.println("Button " + e.button + " pressed on button " + etykieta);
	System.out
		.println("Mouse pressed at (" + e.x + "," + e.y + ")");
    }

    public void mouseUp(MouseEvent e) {
	System.out.println("Mouse released at (" + e.x + "," + e.y
		+ ")");
    }
}
