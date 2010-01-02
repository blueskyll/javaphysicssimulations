package example007;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class Groups {
    public static void main(String[] args) {
	Display display = new Display();
	Shell shell = new Shell(display);

	shell.setSize(500, 500);
	shell.setText("Grupy");

	Group group1 = new Group(shell, SWT.BORDER);
	group1.setBounds(30, 30, 200, 200);
	group1.setText("Group 1");
	Button button = new Button(group1, SWT.PUSH);
	button.setBounds(10, 20, 80, 20);
	button.setText("I'm in a group");
	Label label = new Label(group1, SWT.NONE);
	label.setBounds(10, 50, 80, 20);
	label.setText("So am I!!");
	
	Group group2 = new Group(group1, SWT.NONE);
	group2.setBounds(10, 100, 150, 50);
	group2.setBackground(new Color(display, 233, 20, 233));
	group2.setText("I'm a group inside a group");
	Button button2 = new Button(group2, SWT.PUSH);
	button2.setBounds(10, 20, 50, 20);
	button2.setText("Twice..");

	shell.open();
	while (!shell.isDisposed()) {
	    if (!display.readAndDispatch()) {
		display.sleep();
	    }
	}
	display.dispose();
    }
}