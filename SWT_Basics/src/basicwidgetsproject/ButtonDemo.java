package basicwidgetsproject;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;

public class ButtonDemo {
	
	public static Display myDisplay;
	public static boolean internalCall = false;

	public static void main(String[] args) {
		internalCall = true;
		myDisplay = new Display();
		ButtonDemo bd = new ButtonDemo();
		bd.runDemo(myDisplay);
	}

	public void runDemo(Display display) {
		myDisplay = display;
		Shell shell = new Shell(display);
		shell.setSize(300,300);
		shell.setText("Button Demo");

		Button button1 = new Button(shell,SWT.PUSH);
		button1.setText("Click me");
		button1.setLocation(0,0);
		button1.setSize(100,20);
		button1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Button was clicked");
			}
		});

		Button button2 = new Button(shell, SWT.ARROW);
		button2.setSize(20,20);
		button2.setLocation(250,200);

		Button button3 = new Button(shell, SWT.FLAT|SWT.TOGGLE);
		button3.setSize(50,50);
		button3.setLocation(0,150);

		shell.open();

		while(!shell.isDisposed()){
		if(!display.readAndDispatch())
			display.sleep();
		}
		if (internalCall) display.dispose();
	}
}

