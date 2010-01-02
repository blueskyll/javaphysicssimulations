package example010;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class MouseMoveAndTrack {
    private static Display display = new Display();
    private static int count1 = 0;
    private static int count2 = 0;

    public static void main(String[] args) {
	Shell shell = new Shell(display);

	shell.setSize(500, 500);
	shell.setText("Key Listener");

	final Canvas canvas = new Canvas(shell, SWT.BORDER);
	canvas.setBounds(10, 10, 100, 100);
	
	Canvas canvas2 = new Canvas(shell, SWT.BORDER);
	canvas2.setBounds(150, 150, 100, 100);
	
	final Text text = new Text(canvas2, SWT.READ_ONLY);
	text.setBounds(40, 30, 20, 20);

	MouseMoveListener mouseMove = new MouseMoveListener() {
	    public void mouseMove(MouseEvent e) {
		Color color = canvas.getBackground();
		color.dispose();
		canvas.setBackground(new Color(display, count1, 0, 255));
		count1++;
		count1 = count1 % 255;
	    }
	};
	canvas.addMouseMoveListener(mouseMove);
	
	MouseTrackListener mouseTrack = new MouseTrackListener() {
	    public void mouseEnter(MouseEvent arg0) {
		text.setText(Integer.toString(count2));
	    }

	    public void mouseExit(MouseEvent arg0) {
		text.setText("");
		count2 = 0;
	    }

	    public void mouseHover(MouseEvent arg0) {
		count2++;
		text.setText(Integer.toString(count2));
	    }
	};
	canvas2.addMouseTrackListener(mouseTrack);

	shell.open();
	while (!shell.isDisposed()) {
	    if (!display.readAndDispatch()) {
		display.sleep();
	    }
	}
	display.dispose();
    }
}