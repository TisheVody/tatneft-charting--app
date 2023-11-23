package com.tatneft.chartingApp.Charts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Timer;
import java.util.TimerTask;


import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.PolarChartPanel;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.*;

public class PolarChartDemo extends ApplicationFrame {

    private static final long serialVersionUID = 1L;
    //
    private static String series1Name = "series 1";
    private static double lastRadius = 40;
    //dataset
    private static XYDataset dataset1 = createDataset1();
    private static XYDataset dataset2 = createDataset2();
    //chart
    private static JFreeChart polarChart1 = createPolarChart(dataset1);
    private static JFreeChart polarChart2 = createPolarChart(dataset2);

    public PolarChartDemo(String title) {
        super(title);
        PolarChartPanel chartPanel = new PolarChartPanel(polarChart1);
        //have a bug after show tooltips
        //        chartPanel.setHorizontalAxisTrace(true);
        //        chartPanel.setVerticalAxisTrace(true);
        chartPanel.setFillZoomRectangle(true);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.addMouseListener(chartPanel);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        getContentPane().add(chartPanel);
        getContentPane().add(chartPanel, BorderLayout.SOUTH);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                addValue();

            }

        }, 0, 200);
    }

    private static void addValue() {
        XYSeriesCollection datasetUpdate = (XYSeriesCollection) dataset1;
        datasetUpdate.getSeries(series1Name).add(lastRadius, lastRadius / 5);
        lastRadius += 40;
    }

    private static XYDataset createDataset1() {

        boolean notify = false;
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1 = new XYSeries(series1Name);
        //(theta,radius)
        series1.add(10, 2, notify);
        series1.add(20, 4, notify);
        series1.add(30, 6, notify);
        dataset.addSeries(series1);
        return dataset;
    }

    private static XYDataset createDataset2() {

        DefaultXYDataset dataset = new DefaultXYDataset();
        //{{theta1,theta2,theta3, },{radius1,radius2,radius3,}}
        double[][] series1 = new double[2][30];
        for (int i = 0; i < 30; i++) {
            series1[0][i] = 90 + i * 10;
            series1[1][i] = i * 10;
        }
        double[][] series2 = new double[2][30];
        for (int i = 0; i < 30; i++) {
            series2[0][i] = i * 10;
            series2[1][i] = 100;
        }
        dataset.addSeries("series 1", series1);
        dataset.addSeries("series 2", series2);

        return dataset;
    }

    private static JFreeChart createPolarChart(XYDataset dataset) {
        boolean legend = true;
        PolarPlot plot = new PolarPlot();
        plot.setDataset(dataset);
        NumberAxis rangeAxis = new NumberAxis();
        rangeAxis.setAxisLineVisible(false);
        rangeAxis.setTickMarksVisible(false);
        rangeAxis.setTickLabelInsets(new RectangleInsets(0.0, 0.0, 0.0, 0.0));
        plot.setAxis(rangeAxis);
        plot.setRenderer(new DefaultPolarItemRenderer());
        JFreeChart chart = new JFreeChart("Polar Chart Demo", JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
        chart.setBackgroundPaint(Color.white);

        plot.setBackgroundPaint(Color.lightGray);

        plot.setAngleGridlinesVisible(true);
        plot.setAngleLabelsVisible(true);
        plot.setAngleTickUnit(new NumberTickUnit(5));

        return chart;
    }

//    public static void main(String[] args) {
//        PolarChartDemo demo = new PolarChartDemo("Polar Chart Demo");
//        demo.pack();
//        //RefineryUtilities.centerFrameOnScreen(demo);
//        demo.setVisible(true);
//    }

}
