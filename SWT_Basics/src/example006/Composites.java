package example006;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class Composites {
    public static void main(String[] args) {
	Display display = new Display();
	Shell shell = new Shell(display);

	shell.setSize(500, 500);
	shell.setText("Etykiety");

	Composite composite1 = new Composite(shell, SWT.BORDER);
	composite1.setBounds(10, 10, 270, 250);
	composite1.setBackground(new Color(display, 31, 133, 31));
	
	Label label = new Label(composite1, SWT.NONE);
	label.setText("Here is a green composite");
	label.setBounds(10, 10, 200, 20);
	
	Composite composite2 = new Composite(composite1, SWT.H_SCROLL
		| SWT.V_SCROLL);
	composite2.setBounds(10, 40, 200, 200);
	
	List list = new List(composite2, SWT.MULTI);
	for (int i = 0; i < 50; i++) {
	    list.add("Item " + i);
	}
	list.setSize(300,300);

	shell.open();
	while (!shell.isDisposed()) {
	    if (!display.readAndDispatch()) {
		display.sleep();
	    }
	}
	display.dispose();
    }
}