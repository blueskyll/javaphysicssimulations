package example008;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class KeyListeners {
    public static void main(String[] args) {
	Display display = new Display();
	Shell shell = new Shell(display);

	shell.setSize(500, 500);
	shell.setText("Key Listener");

	Text text = new Text(shell, SWT.MULTI | SWT.BORDER);
	text.setBounds(10, 10, 100, 100);
	text.addKeyListener(new KeyListener() {
	    public void keyPressed(KeyEvent e) {
		String string = "";
		switch (e.character) {
		case 0:
		    string += " '\\0'";
		    break;
		case SWT.BS:
		    string += " '\\b'";
		    break;
		case SWT.CR:
		    string += " '\\r'";
		    break;
		case SWT.DEL:
		    string += " DEL";
		    break;
		case SWT.ESC:
		    string += " ESC";
		    break;
		case SWT.LF:
		    string += " '\\n'";
		    break;
		default:
		    string += " '" + e.character + "'";
		    break;
		}
		System.out.println(string);
	    }

	    public void keyReleased(KeyEvent e) {
		if (e.stateMask == SWT.CTRL && e.keyCode != SWT.CTRL)
		    System.out.println("Command can execute here");
	    }
	});

	shell.open();
	while (!shell.isDisposed()) {
	    if (!display.readAndDispatch()) {
		display.sleep();
	    }
	}
	display.dispose();
    }
}