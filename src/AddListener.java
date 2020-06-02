import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class AddListener extends SelectionAdapter
{
   Text text;
   Combo combo;
    public AddListener(Text text,Combo combo)
    {
       this.text=text;
       this.combo=combo;
    }

    public void widgetSelected(SelectionEvent event1) {
        String tempForText;
        tempForText = text.getText();
        String[] elementsOfCombo;
        elementsOfCombo=combo.getItems();
        Boolean flag =true;
        for(int i=0;i<elementsOfCombo.length;i++)
        {

            if(elementsOfCombo[i].equals(tempForText))
            {
                flag = false;
                RowLayout layout =new RowLayout();
                Shell newShell = new Shell();
                newShell.setLayout(layout);

                Label textOfNewWindow = new Label(newShell, SWT.NONE);
                textOfNewWindow.setText("Error");
                Font font =new Font(textOfNewWindow.getDisplay(),"Arial",14,SWT.NONE);
                textOfNewWindow.setFont(font);
                RowData rowData =new RowData();
                rowData.height=100;
                rowData.width=200;
                textOfNewWindow.setLayoutData(rowData);


                newShell.pack();
                newShell.open();
            }
        }
        if(flag==true)
            combo.add(tempForText);
        flag=true;

    }
}