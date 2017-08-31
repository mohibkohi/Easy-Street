import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MazePanel extends JPanel
{
    private static final long serialVersionUID = 7011282142772442377L;
    private ArrayList<ShapeContainer> myShapes;
    private int myPanelWidth;
    private int myPanelHeight;
    private int myWidth;
    private int myDepth;
    private int myRectWidth;
    private int myRectHeight;
    
    public MazePanel()
    {
        
    }

    public MazePanel(int thePanelWidth, int thePanelHeight, int theWidth, int theDepth)
    {
        myShapes = new ArrayList<>();
        myPanelWidth = thePanelWidth;
        myPanelHeight = thePanelHeight;
        myWidth = theWidth;
        myDepth = theDepth;
        myRectWidth = myPanelWidth / myWidth;
        myRectHeight = myPanelHeight / myDepth;
    }
    
    private void drawGrid(Graphics2D theGraphics)
    {
        theGraphics.setColor(Color.BLACK);
        
        // draw horizontal grid lines
        for (int i = 0; i < myPanelHeight; i++)
        {
            // x1, y1, x2, y2
            theGraphics.drawLine(0, i * myRectHeight, myPanelWidth, i * myRectHeight);
        }

        // draw vertical grid lines
        for (int i = 0; i < myPanelWidth; i++)
        {
            theGraphics.drawLine(i * myRectWidth, 0, i * myRectWidth, myPanelHeight);
        }
    }

    public void draw(Shape s, Color c)
    {
        myShapes.add(new ShapeContainer(s, c));
        repaint();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        drawGrid(g2d);

        for (ShapeContainer s : myShapes)
        {
            g2d.setColor(s.myColor);
            g2d.fill(s.myShape);
        }
    }

    class ShapeContainer
    {
        private final Shape myShape;
        private final Color myColor;

        public ShapeContainer(final Shape theShape, final Color theColor)
        {
            myShape = theShape;
            myColor = theColor;
        }
    }
}