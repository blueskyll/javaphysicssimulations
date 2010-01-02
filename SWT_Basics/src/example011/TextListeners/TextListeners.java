package example011.TextListeners;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class TextListeners {
    private static Display display = new Display();

    public static void main(String[] args) {
	Shell shell = new Shell(display);

	shell.setSize(500, 500);
	shell.setText("Text Listener");

	Text text = new Text(shell, SWT.MULTI | SWT.WRAP);
	text.setBounds(10, 10, 200, 100);
	text.setText("Here is some sample text");
	
	text.addModifyListener(new ModifyListener() {
	    public void modifyText(ModifyEvent e) {
		System.out.println("Modified at " + e.time);
	    }
	});
	
	text.addVerifyListener(new VerifyListener() {
	    public void verifyText(VerifyEvent e) {
		if (e.text.equals("*")) {
		    System.out.println("Cannot type *");
		    e.doit = false;
		} else {
		    e.doit = true;
		}
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