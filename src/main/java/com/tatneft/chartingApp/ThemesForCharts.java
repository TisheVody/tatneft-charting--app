package com.tatneft.chartingApp;

import com.tatneft.chartingApp.Colors.FlowColors;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.ui.RectangleInsets;

import java.awt.*;

public class ThemesForCharts {

    public static void setStandardChartTheme() {
        StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
        standardChartTheme.setExtraLargeFont(new Font("______", Font.BOLD, 20));
        standardChartTheme.setRegularFont(new Font("______", Font.PLAIN, 15));
        standardChartTheme.setLargeFont(new Font("______", Font.PLAIN, 15));

        standardChartTheme.setTitlePaint( Color.decode( "#4572a7" ) );

        standardChartTheme.setRangeGridlinePaint( Color.decode("#C0C0C0"));
        standardChartTheme.setPlotBackgroundPaint( Color.white );
        standardChartTheme.setChartBackgroundPaint( Color.white );
        standardChartTheme.setGridBandPaint( Color.red );
        standardChartTheme.setAxisOffset( new RectangleInsets(0,0,0,0) );
        standardChartTheme.setBarPainter(new StandardBarPainter());
        standardChartTheme.setAxisLabelPaint( Color.decode("#666666")  );

        standardChartTheme.setShadowPaint(Color.black);
        standardChartTheme.setShadowVisible(true);

        ChartFactory.setChartTheme(standardChartTheme);
//        theme.apply( chart );
//
//        chart.getCategoryPlot().setOutlineVisible( false );
//        chart.getCategoryPlot().getRangeAxis().setAxisLineVisible( false );
//        chart.getCategoryPlot().getRangeAxis().setTickMarksVisible( false );
//        chart.getCategoryPlot().setRangeGridlineStroke( new BasicStroke() );
//        chart.getCategoryPlot().getRangeAxis().setTickLabelPaint( Color.decode("#666666") );
//        chart.getCategoryPlot().getDomainAxis().setTickLabelPaint( Color.decode("#666666") );
//        chart.setTextAntiAlias( true );
//        chart.setAntiAlias( true );
//        chart.getCategoryPlot().getRenderer().setSeriesPaint( 0, Color.decode( "#4572a7" ));
//        BarRenderer rend = (BarRenderer) chart.getCategoryPlot().getRenderer();
//        rend.setShadowVisible( true );
//        rend.setShadowXOffset( 2 );
//        rend.setShadowYOffset( 0 );
//        rend.setShadowPaint( Color.decode( "#C0C0C0"));
//        rend.setMaximumBarWidth( 0.1);


    }
}
