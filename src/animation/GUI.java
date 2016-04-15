package animation;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.BasicStroke;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void drawGrid(Graphics g, int x1, int y1, int x2, int y2)
	{
		//creates a copy of the Graphics instance
        Graphics2D g2d = (Graphics2D) g.create();

        //Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        Stroke dotted = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, new float[]{9}, 0);
        g2d.setStroke(dotted);
        g2d.drawLine(x1, y1, x2, y2);
        //gets rid of the copy
        g2d.dispose();
	}	
	public void drawDashedLine(Graphics g, int x1, int y1, int x2, int y2)
	{
		//creates a copy of the Graphics instance
        Graphics2D g2d = (Graphics2D) g.create();

        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        //Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.drawLine(x1, y1, x2, y2);
        
        //gets rid of the copy
        g2d.dispose();
	}

    private void doDrawing(Graphics g)
    {
    	Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));
        
        //Boundary Lines
        g2d.drawLine(5, 150, 200, 150); 
        g2d.drawLine(5, 450, 200, 450);        
        g2d.drawLine(200, 450, 200, 600);        
        g2d.drawLine(500, 600, 500, 450);        
        g2d.drawLine(500, 450, 695, 450);        
        g2d.drawLine(500, 150, 695, 150);
        g2d.drawLine(500, 150, 500, 5);        
        g2d.drawLine(200, 5, 200, 150);
        
        //Dividers
        g2d.drawLine(350, 150, 350, 5);
        g2d.drawLine(350, 450, 350, 600);
        g2d.drawLine(200, 300, 5, 300);
        g2d.drawLine(500, 300, 695, 300);
        
        //West Dashed Lines
        drawDashedLine(g2d, 5, 200, 200, 200);
        drawDashedLine(g2d, 5, 250, 200, 250);
        drawDashedLine(g2d, 5, 350, 200, 350);
        drawDashedLine(g2d, 5, 400, 200, 400);
        
        //North Dashed Lines
        drawDashedLine(g2d, 250, 150, 250, 5);
        drawDashedLine(g2d, 300, 150, 300, 5);
        drawDashedLine(g2d, 400, 150, 400, 5);
        drawDashedLine(g2d, 450, 150, 450, 5);
        
        //East Dashed Lines 
        drawDashedLine(g2d, 500, 200, 695, 200);
        drawDashedLine(g2d, 500, 250, 695, 250);
        drawDashedLine(g2d, 500, 350, 695, 350);
        drawDashedLine(g2d, 500, 400, 695, 400);
        
        //South Dashed Lines
        drawDashedLine(g2d, 250, 450, 250, 600);
        drawDashedLine(g2d, 300, 450, 300, 600);
        drawDashedLine(g2d, 400, 450, 400, 600);
        drawDashedLine(g2d, 450, 450, 450, 600);
        
        //Draw Grid
        drawGrid(g2d, 200, 150, 500, 150);
        drawGrid(g2d, 200, 200, 500, 200);
        drawGrid(g2d, 200, 250, 500, 250);
        drawGrid(g2d, 200, 300, 500, 300);
        drawGrid(g2d, 200, 350, 500, 350);
        drawGrid(g2d, 200, 400, 500, 400);
        drawGrid(g2d, 200, 450, 500, 450);
        
        drawGrid(g2d, 200, 150, 200, 450);
        drawGrid(g2d, 250, 150, 250, 450);
        drawGrid(g2d, 300, 150, 300, 450);
        drawGrid(g2d, 350, 150, 350, 450);
        drawGrid(g2d, 400, 150, 400, 450);
        drawGrid(g2d, 450, 150, 450, 450);
        drawGrid(g2d, 500, 150, 500, 450);
        
    }
    
    public void paintComponent(Graphics g)
    {
    	super.paintComponent(g);
        doDrawing(g);
    }
}

public class GUI extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GUI()
	{
		add(new Surface());

        setTitle("Lines");
        setSize(750, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
    	EventQueue.invokeLater(new Runnable()
    	{
    		public void run()
    		{
    			GUI ex = new GUI();
                ex.setVisible(true);
            }
        });
    }

}