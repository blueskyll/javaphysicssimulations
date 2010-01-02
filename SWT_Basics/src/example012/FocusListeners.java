package example012;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class FocusListeners {
    private static Display display = new Display();

    public static void main(String[] args) {
	Shell shell = new Shell(display);

	shell.setSize(500, 500);
	shell.setText("Focus Listeners");

	Button b1 = new Button(shell, SWT.PUSH);
	Button b2 = new Button(shell, SWT.PUSH);
	Button b3 = new Button(shell, SWT.PUSH);
	Button b4 = new Button(shell, SWT.PUSH);
	Button b5 = new Button(shell, SWT.PUSH);
	Button b6 = new Button(shell, SWT.PUSH);

	b1.setBounds(10, 10, 50, 50);
	b2.setBounds(100, 10, 50, 50);
	b3.setBounds(200, 10, 50, 50);
	b4.setBounds(10, 100, 50, 50);
	b5.setBounds(100, 100, 50, 50);
	b6.setBounds(200, 100, 50, 50);
	b1.setText("1");
	b2.setText("2");
	b3.setText("3");
	b4.setText("4");
	b5.setText("5");
	b6.setText("6");

	FocusListener focusListener = new FocusListener() {
	    public void focusGained(FocusEvent e) {
		System.out.println(e.widget + " has focus");
	    }

	    public void focusLost(FocusEvent e) {
		System.out.println("And now has lost it.");
	    }
	};

	TraverseListener traverseListener = new TraverseListener() {
	    public void keyTraversed(TraverseEvent e) {
		if (e.detail == SWT.TRAVERSE_TAB_PREVIOUS) {
		    System.out.println("You can't go back!");
		    e.doit = false;
		}
		System.out.println(e.widget + " was traversed");
	    }
	};
	
	b1.addFocusListener(focusListener);
	b4.addTraverseListener(traverseListener);
	b4.addFocusListener(focusListener);
	b6.addTraverseListener(traverseListener);

	shell.open();
	while (!shell.isDisposed()) {
	    if (!display.readAndDispatch()) {
		display.sleep();
	    }
	}
	display.dispose();
    }
}