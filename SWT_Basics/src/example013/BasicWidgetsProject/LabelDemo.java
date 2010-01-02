package example013.BasicWidgetsProject;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;

public class LabelDemo {

	public static Display myDisplay;
	public static boolean internalCall = false;

	public static void main(String[] args) {
		internalCall = true;
		myDisplay = new Display();
		LabelDemo ld = new LabelDemo();
		ld.runDemo(myDisplay);
	}

	public void runDemo(Display display) {
		myDisplay = display;
		Shell shell = new Shell(display);
		shell.setSize(300,300);
		shell.setText("Label Demo");

		Label label1 = new Label(shell, SWT.BORDER);
		label1.setText("See no evil");
		label1.setSize(100,20);
		label1.setLocation(30,30);

		Label sep1 = new Label(shell, SWT.SEPARATOR| SWT.HORIZONTAL | SWT.SHADOW_IN);
		sep1.setBounds(30,60,100,20);

		Label label2 = new Label(shell, SWT.NONE);
		label2.setText("Hear no evil");
		label2.setSize(100,20);
		label2.setLocation(30,90);

		Label sep2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		sep2.setBounds(30,120,100,20);

		Label label3 = new Label(shell, SWT.NONE);
		label3.setSize(100,20);
		label3.setLocation(30,150);
		label3.setBackground(new Color(display,200,111,50));
		label3.setText("Speak no evil");

		shell.open();

		while(!shell.isDisposed()){
		if(!display.readAndDispatch())
			display.sleep();
		}
		if (internalCall) display.dispose();
	}
}
