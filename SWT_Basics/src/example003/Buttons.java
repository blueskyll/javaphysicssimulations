package example003;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;

public class Buttons {
    public static void main(String[] args) {
	Display display = new Display();
	Shell shell = new Shell(display);

	shell.setSize(500, 500);
	shell.setText("Przyciski");

	Button button1 = new Button(shell, SWT.PUSH);
	button1.setText("Click me");
	button1.setLocation(0, 0);
	button1.setSize(100, 20);
	button1.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		System.out.println("Button1 was clicked");
	    }
	});
	
	Button button2 = new Button(shell, SWT.FLAT | SWT.TOGGLE);
	button2.setSize(50, 50);
	button2.setLocation(0, 150);
	
	Button button3 = new Button(shell, SWT.ARROW | SWT.UP);
	button3.setSize(20, 20);
	button3.setLocation(250, 200);
	
	Button button4 = new Button(shell, SWT.ARROW | SWT.DOWN);
	button4.setSize(20, 20);
	button4.setLocation(250, 250);

	shell.open();
	while (!shell.isDisposed()) {
	    if (!display.readAndDispatch()) {
		display.sleep();
	    }
	}
	display.dispose();
    }
}