package basics;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class Menus {
    static Listener listener = new Listener() {
	public void handleEvent(Event arg0) {
	    System.out.println("Wywo³ane przez: " + arg0.toString());
	}
    };
    
    public static void main(String[] args) {
	Display display = new Display();
	Shell shell = new Shell(display);
	shell.setText("Menus with submenus");
	Menu bar = new Menu(shell, SWT.BAR);
	shell.setMenuBar(bar);
	MenuItem[] menuItems = new MenuItem[3];
	for (int i = 0; i < menuItems.length; i++) {
	    menuItems[i] = new MenuItem(bar, SWT.CASCADE);
	    menuItems[i].setText("Menu #" + i);
	    Menu subMenu = new Menu(shell, SWT.DROP_DOWN);
	    menuItems[i].setMenu(subMenu);
	    MenuItem[] subMenuItems = new MenuItem[3];
	    for (int j = 0; j < subMenuItems.length; j++) {
		subMenuItems[j] = new MenuItem(subMenu, SWT.PUSH);
		subMenuItems[j].setText("Sub menu #" + j + " of menu # " + i);
		subMenuItems[j].setData("kaka");
		subMenuItems[j].addListener(SWT.Selection, listener);
	    }
	}
	shell.open();
	while (!shell.isDisposed()) {
	    if (!display.readAndDispatch()) {
		display.sleep();
	    }
	}
	display.dispose();
    }
}