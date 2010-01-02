package example013.BasicWidgetsProject;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;

public class BasicWidgetsDemo {
	
	public static Display display;

	public static void main(String[] args) {
		BasicWidgetsDemo bwd = new BasicWidgetsDemo();
		bwd.runDemo();
	}

	public void runDemo() {
		display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(400,400);
		shell.setText("Basic Widgets Demo");
		
		Label label1 = new Label(shell, SWT.NULL);
		label1.setText("Basic Widgets Demo");
		label1.setBounds(120, 10, 200, 30);

		Button button1 = new Button(shell,SWT.PUSH);
		button1.setText("Button Demo");
		button1.setLocation(10,50);
		button1.setSize(100,30);
		button1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				ButtonDemo bd = new ButtonDemo();
				bd.runDemo(display);
			}
		});


		Button button2 = new Button(shell,SWT.PUSH);
		button2.setText("Combo Demo");
		button2.setLocation(110,50);
		button2.setSize(100,30);
		button2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				ComboDemo cd = new ComboDemo();
				cd.runDemo(display);
			}
		});

		Button button3 = new Button(shell,SWT.PUSH);
		button3.setText("Composite Demo");
		button3.setLocation(210,50);
		button3.setSize(100,30);
		button3.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				CompositeDemo cpd = new CompositeDemo();
				cpd.runDemo(display);
			}
		});

		Button button4 = new Button(shell,SWT.PUSH);
		button4.setText("Group Demo");
		button4.setLocation(10,100);
		button4.setSize(100,30);
		button4.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				GroupDemo gd = new GroupDemo();
				gd.runDemo(display);
			}
		});

		Button button5 = new Button(shell,SWT.PUSH);
		button5.setText("Label Demo");
		button5.setLocation(110,100);
		button5.setSize(100,30);
		button5.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				LabelDemo ld = new LabelDemo();
				ld.runDemo(display);
			}
		});

		Button button6 = new Button(shell,SWT.PUSH);
		button6.setText("List Demo");
		button6.setLocation(210,100);
		button6.setSize(100,30);
		button6.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				ListDemo ld = new ListDemo();
				ld.runDemo(display);
			}
		});

		Button button7 = new Button(shell,SWT.PUSH);
		button7.setText("Text Demo");
		button7.setLocation(10,150);
		button7.setSize(100,30);
		button7.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TextDemo td = new TextDemo();
				td.runDemo(display);
			}
		});

		shell.open();

		while(!shell.isDisposed()){
		if(!display.readAndDispatch())
			display.sleep();
		}
		display.dispose();
	}
}

