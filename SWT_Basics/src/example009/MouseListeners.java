package example009;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class MouseListeners {
    private static Display display = new Display();

    public static void main(String[] args) {
	Shell shell = new Shell(display);

	shell.setSize(500, 500);
	shell.setText("Mouse Listener");

	Button button1 = new Button(shell, SWT.PUSH);
	button1.setText("Push Me");
	button1.setBounds(50, 50, 100, 20);

	Button button2 = new Button(shell, SWT.PUSH);
	button2.setText("Push Me Too");
	button2.setBounds(50, 100, 100, 20);

	MyMouseAdapter mouseAdapter1 = new MyMouseAdapter("1");
	MyMouseAdapter mouseAdapter2 = new MyMouseAdapter("2");
	
	button1.addMouseListener(mouseAdapter1);
	button2.addMouseListener(mouseAdapter2);

	Label label = new Label(shell, SWT.NONE);
	label.setText("Double Click Me");
	label.setBounds(50, 150, 100, 20);

	label.addMouseListener(new MouseAdapter() {
	    public void mouseDoubleClick(MouseEvent e) {
		Shell shell2 = new Shell(display);
		shell2.setSize(200, 200);
		Label label2 = new Label(shell2, SWT.CENTER);
		label2.setText("Hello New Window!");
		label2.setBounds(0, 50, 150, 20);
		shell2.open();
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