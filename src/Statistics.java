import java.awt.Color;
import java.awt.BasicStroke;
import java.util.List;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.TickUnits;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

import javax.swing.*;

class Statistics extends  JFrame {

    /**
     * Creates a new demo instance.
     *class showing graphic stats
     * @param title  the frame title.
     */
    private Player player;


    public Statistics(final String title, Player player) {

        super(title);
        this.player=player;
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                title ,
                "Matches" ,
                "Number" ,
                createDataset() ,
                PlotOrientation.VERTICAL ,
                true , true , false);

        ChartPanel chartPanel = new ChartPanel( xylineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 1060 , 667 ) );
        final XYPlot plot = xylineChart.getXYPlot( );

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.RED );
        renderer.setSeriesPaint( 1 , Color.MAGENTA );
        renderer.setSeriesPaint( 2 , Color.ORANGE );
        renderer.setSeriesPaint( 3 , Color.BLUE );
        renderer.setSeriesPaint( 4 , Color.GREEN );
        renderer.setSeriesPaint( 5 , Color.CYAN );
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer( renderer );


        setContentPane( chartPanel );
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());


    }

    public XYDataset createDataset( ) {
        final XYSeries attacks = new XYSeries( "Attacks" );
        final XYSeries blocks = new XYSeries( "Blocks" );
        final XYSeries badAttacks = new XYSeries( "Bad Attacks" );
        final XYSeries badServices = new XYSeries( "Bad Services" );
        final XYSeries mistakes = new XYSeries( "Mistakes" );
        final XYSeries result = new XYSeries( "Result" );

        addToSeries(attacks,this.player.getAttacks());
        addToSeries(blocks,this.player.getBlocks());
        addToSeries(badAttacks,this.player.getBadAttacks());
        addToSeries(badServices,this.player.getBadServices());
        addToSeries(mistakes,this.player.getMistakes());
        addToSeries(result, this.player.getResults());

        final XYSeriesCollection dataset = new XYSeriesCollection( );
        dataset.addSeries( attacks );
        dataset.addSeries( blocks );
        dataset.addSeries( badAttacks );
        dataset.addSeries( badServices );
        dataset.addSeries( mistakes );
        dataset.addSeries( result );


        return dataset;
    }

    public void addToSeries(XYSeries series, List list){

        int numOfRecords=this.player.getAttacks().size();


        for (int i=0; i<numOfRecords; i++){
            series.add(i+1, (Number) list.get(i));

        }

    }

}