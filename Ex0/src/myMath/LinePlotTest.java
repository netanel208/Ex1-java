package myMath;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.plots.points.DefaultPointRenderer2D;
import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

public class LinePlotTest extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LinePlotTest(Polynom polynom, double x0, double x1) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);

        
        DataTable data = new DataTable(Double.class, Double.class);
        DataTable extreme = new DataTable(Double.class, Double.class);
        Polynom_able der = polynom.derivative();
        
        for (double x = x0; x <= x1; x+=0.01) {
            double y = polynom.f(x);
            data.add(x, y);
        }
        double Xextreme =0;
        double Yextreme =0;
        for(double x = x0; x < x1; x+=0.01) {
        	try
        	{
        		Xextreme =(int) der.root(x, x+0.01, 0.001);
        		Yextreme =(int) polynom.f(Xextreme);
        		extreme.add(Xextreme,Yextreme);
        		System.out.println("("+Xextreme+" ,"+Yextreme+")");
        	}
        	catch(RuntimeException e)
        	{}
        }
        XYPlot plot = new XYPlot(data);
        getContentPane().add(new InteractivePanel(plot));
        LineRenderer lines = new DefaultLineRenderer2D();
        plot.setLineRenderers(data, lines); 
        Color color = new Color(0.6400f, 0.3300f, 0.2126f);
        plot.getPointRenderers(data).get(0).setColor(color);
        plot.getLineRenderers(data).get(0).setColor(color);
        
        PointRenderer points = new DefaultPointRenderer2D(); //
        Color colorExtreme = new Color(0.3000f, 0.6000f, 0.7152f); ///
//        points.setShape(new Ellipse2D.Double(Xextreme, Yextreme, 12.0, 12.0));
//        points.setColor(new Color(0.0f, 0.3f, 1.0f, 0.3f));
        plot.setPointRenderers(extreme, points); ///


       
        
       plot.getPointRenderers(extreme).get(0).setColor(colorExtreme); ///
        
//        PointRenderer points1 = new DefaultPointRenderer();
//        points1.setShape(new Ellipse2D.Double(-3.0, -3.0, 6.0, 6.0));
//        points1.setColor(new Color(0.0f, 0.3f, 1.0f, 0.3f));
//        plot.setPointRenderers(series1, points1);
        
     

    }

   }

