package graphics;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

import swt.util.SWTApplication;
import swt.util.SWTConsole;

public class SineWave implements SWTApplication {
    private SineDraw sines;
    private Slider slider;
    
    public void createContents(Composite parent) {
	parent.setLayout(new GridLayout(1, true));
	sines = new SineDraw(parent, SWT.NONE);
	sines.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	sines.setFocus();
	slider = new Slider(parent, SWT.HORIZONTAL);
	slider.setValues(5, 1, 30, 1, 1, 1);
	slider.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false));
	slider.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent event) {
		sines.setCycles(slider.getSelection());
	    }
	});
	
    }   
    
    public static void main(String[] args) {
	SWTConsole.run(new SineWave(), 700, 400);
    }
}