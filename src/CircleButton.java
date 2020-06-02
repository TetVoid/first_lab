

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;

public class CircleButton extends Canvas {
    private int mouse = 0;
    private boolean hit = false;
    SelectionAdapter selectionAdapter;
    public CircleButton(Composite parent, int style) {
        super(parent, style);
        this.addPaintListener(new PaintListener() {
            public void paintControl(PaintEvent e) {
                switch (mouse) {
                    case 0://normal
                        Color color1=new Color(e.gc.getDevice(),255,0,0);
                        e.gc.setBackground(color1);


                        e.gc.fillOval(0,0,35,35);
                        break;
                    case 1://choose
                        Color color2=new Color(e.gc.getDevice(),0,0,255);
                        e.gc.setBackground(color2);


                        e.gc.fillOval(0,0,35,35);
                        break;
                    case 2://hit
                        Color color3=new Color(e.gc.getDevice(),0,0,0);
                        e.gc.setBackground(color3);
                        e.gc.fillOval(-1,-1,38,38);

                        Color color4=new Color(e.gc.getDevice(),0,0,255);
                        e.gc.setBackground(color4);
                        e.gc.fillOval(0,0,35,35);

                        SelectionEvent event1=null;
                        selectionAdapter.widgetSelected(event1);
                        break;
                }
            }
        });
        this.addMouseMoveListener(new MouseMoveListener() {
            public void mouseMove(MouseEvent e) {
                if (!hit) return;
                mouse = 2;
                if (e.x < 0 || e.y < 0 || e.x > getBounds().width || e.y > getBounds().height) {
                    mouse = 0;
                }
                redraw();
            }
        });
        this.addMouseTrackListener(new MouseTrackAdapter() {
            public void mouseEnter(MouseEvent e) {
                mouse = 1;
                redraw();
            }

            public void mouseExit(MouseEvent e) {
                mouse = 0;
                redraw();
            }
        });
        this.addMouseListener(new MouseAdapter() {
            public void mouseDown(MouseEvent e) {
                hit = true;
                mouse = 2;
                redraw();
            }

            public void mouseUp(MouseEvent e) {
                hit = false;
                mouse = 1;
                if (e.x < 0 || e.y < 0 || e.x > getBounds().width || e.y > getBounds().height) {
                    mouse = 0;
                }
                redraw();
                if (mouse == 1) notifyListeners(SWT.Selection, new Event());
            }
        });
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.keyCode == '\r' || e.character == ' ') {
                    Event event = new Event();
                    notifyListeners(SWT.Selection, event);
                }
            }
        });

    }

    public void setText(String text)
    {
        this.addPaintListener(new PaintListener() {
            public void paintControl(PaintEvent e) {
                e.gc.drawText(text,5,5);
            }
        });
    }
   public void addSelectionListener(SelectionAdapter tempAdapter)
    {
        selectionAdapter=tempAdapter;
    }
}


