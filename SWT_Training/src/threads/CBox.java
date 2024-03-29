package threads;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import java.util.concurrent.*;
import java.util.*;

public class CBox extends Canvas implements Runnable {
    private static Random rand = new Random();
    private int pause;
    private RGB cColor = newColor();
    
    class CBoxPaintListener implements PaintListener {
	public void paintControl(PaintEvent e) {
	    Color color = new Color(e.display, cColor);
	    e.gc.setBackground(color);
	    Point size = getSize();
	    e.gc.fillRectangle(0, 0, size.x, size.y);
	    color.dispose();
	}
    }

    private static RGB newColor() {
	return new RGB(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
    }

    public CBox(Composite parent, int pause) {
	super(parent, SWT.NONE);
	this.pause = pause;
	addPaintListener(new CBoxPaintListener());
    }

    public void run() {
	try {
	    while(!Thread.interrupted()) {
		cColor = newColor();
		getDisplay().asyncExec(new Runnable() {
		    public void run() {
			try {
			    redraw();
			} catch(SWTException e) {
			    //
			}
		    }
		});
		TimeUnit.MILLISECONDS.sleep(pause);
	    }
	} catch (InterruptedException e) {
	    //
	} catch (SWTException e) {
	    // 
	}
    }
}