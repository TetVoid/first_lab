import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.widgets.Button;

public class Main {


    public static void main(String[] args) {
        int[] index = new int[1];
        index[0]=0;
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Lab №1");
        shell.setSize(600, 500);

        shell.setLayout(new RowLayout(SWT.VERTICAL));
        Group group = new Group(shell, SWT.NONE);
        Composite composite=new Composite(group,SWT.NONE);
        composite.setLayout(new RowLayout(SWT.HORIZONTAL));

        group.setLayout(new RowLayout(SWT.HORIZONTAL));

        Button button = new Button(composite, SWT.NONE);
        Text text = new Text(group, SWT.NONE);


        button.setText("add");

        Combo combo = new Combo(group, SWT.DROP_DOWN);
        button.addSelectionListener(new AddListener(text,combo));

        CircleButton changer=new CircleButton(shell,SWT.NONE);
        changer.addSelectionListener(new ChangerListener(composite,combo,text));
        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}
