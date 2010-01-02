package example013.BasicWidgetsProject;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class ComboDemo {

	public static Display myDisplay;
	public static boolean internalCall = false;

	public static void main(String[] args) {
		internalCall = true;
		myDisplay = new Display();
		ComboDemo cd = new ComboDemo();
		cd.runDemo(myDisplay);
	}

	public void runDemo(Display display) {
		myDisplay = display;
		Shell shell = new Shell(display);
		shell.setSize(300,300);
		shell.setText("Combo Demo");

		Combo combo1 = new Combo(shell, SWT.DROP_DOWN|SWT.READ_ONLY);
		combo1.setItems(new String[] {"One","Two","Three"});
		combo1.select(0);
		combo1.setLocation(0,0);
		combo1.setSize(100,20);

		Combo combo2 = new Combo(shell, SWT.SIMPLE);
		combo2.setItems(new String[] {"Red","Green","Blue","Yellow"});
		combo2.setBounds(50,50,200,150);
		combo2.select(1);

		Combo combo3 = new Combo(shell, SWT.DROP_DOWN);
		combo3.setLocation(200,0);
		combo3.setSize(50,50);

		shell.open();

		while(!shell.isDisposed()){
		if(!display.readAndDispatch())
			display.sleep();
		}
		if (internalCall) display.dispose();
	}
}
