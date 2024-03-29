package example013.BasicWidgetsProject;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class TextDemo {

	public static Display myDisplay;
	public static boolean internalCall = false;

	public static void main(String[] args) {
		internalCall = true;
		myDisplay = new Display();
		TextDemo td = new TextDemo();
		td.runDemo(myDisplay);
	}

	public void runDemo(Display display) {
		myDisplay = display;
		Shell shell = new Shell(display);
		shell.setSize(300,300);
		shell.setText("Text Demo");

		Text text1 = new Text(shell, SWT.BORDER);
		text1.setText("Type something in here");
		text1.setBounds(10,10,200,20);
		text1.setTextLimit(30);

		Text text2 = new Text(shell, SWT.NONE);
		text2.setEchoChar('*');
		text2.setBounds(10,50,200,20);
		text2.setText("Password");

		Text text3 = new Text(shell, SWT.BORDER|SWT.H_SCROLL|SWT.V_SCROLL);
		text3.setBounds(10,90,200,100);
		text3.setEditable(false);
		text3.setText("Bet you can't type in here");

		shell.open();

		while(!shell.isDisposed()){
		if(!display.readAndDispatch())
			display.sleep();
		}
		if (internalCall) display.dispose();
	}
}
