package example004.Lists;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;

public class Lists {
    public static void main(String[] args) {
	Display display = new Display();
	Shell shell = new Shell(display);

	shell.setSize(500, 500);
	shell.setText("Listy wyboru");

	List list1 = new List(shell, SWT.MULTI | SWT.H_SCROLL);
	list1.setItems(new String[] { "Strawberry", "Banana", "Apple" });
	list1.add("Pickle");
	list1.setBounds(0, 0, 60, 100);
	
	final List list2 = new List(shell, SWT.SINGLE | SWT.BORDER);
	list2.setItems(new String[] { "Rock", "Paper", "Scissors" });
	list2.setBounds(110, 0, 50, 50);
	list2.addMouseListener(new MouseAdapter() {
	    public void mouseDown(MouseEvent e) {
		System.out.println(list2.getSelection()[0] + " wins");
	    }

	    public void mouseUp(MouseEvent e) {
		System.out.println("Try again!");
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