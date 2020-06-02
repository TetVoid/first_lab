import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

public class ChangerListener extends SelectionAdapter {

    Composite composite;
    Combo combo;
    Text text;
    public ChangerListener(Composite composite,Combo combo,Text text)
    {

       this.composite =composite;
      this.combo=combo;
      this.text=text;
    }

    public void widgetSelected(SelectionEvent event1)
    {

            composite.getChildren()[0].dispose();
            CircleButton add = new CircleButton(composite, SWT.NONE);
            add.setText("add");
            add.addSelectionListener(new AddListener(text,combo));

          composite.getShell().setSize(300, 220);

    }
}
