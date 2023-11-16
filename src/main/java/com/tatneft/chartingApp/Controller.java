package com.tatneft.chartingApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;

import java.awt.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.chart.fx.interaction.ChartMouseEventFX;
import org.jfree.chart.fx.interaction.ChartMouseListenerFX;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Controller implements Initializable {

    @FXML
    private ToggleButton btnAreaChart;

    @FXML
    private ToggleGroup btnGroup;

    @FXML
    private ToggleButton btnPolarChart;

    @FXML
    private ToggleButton btnSankeyChart;

    @FXML
    private ImageView imgExample;
    @FXML
    private Label lbl;

    public void toggleButtonSelect (ActionEvent event) {
        ImageView image = null;
        if (btnAreaChart.isSelected()) {
            image = new ImageView("C:\\Users\\trust\\IdeaProjects\\chartingApp\\src\\main\\resources\\images\\image_area_chart.png");
        }
        if (btnPolarChart.isSelected()) {
            image = new ImageView("C:\\Users\\trust\\IdeaProjects\\chartingApp\\src\\main\\resources\\images\\image_polar_chart.png");
        }
        if (btnSankeyChart.isSelected()) {
            image = new ImageView("C:\\Users\\trust\\IdeaProjects\\chartingApp\\src\\main\\resources\\images\\image_sankey_chart.png");
        }
        assert image != null;
        imgExample.setImage(image.getImage());
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(7445, "JFreeSVG", "Warm-up");
        dataset.addValue(24448, "Batik", "Warm-up");
        dataset.addValue(4297, "JFreeSVG", "Test");
        dataset.addValue(21022, "Batik", "Test");
        return dataset;
    }

    /**
     * Creates a sample chart.
     *
     * @param dataset  the dataset.
     *
     * @return The chart.
     */
    private static JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Performance: JFreeSVG vs Batik", null /* x-axis label*/,
                "Milliseconds" /* y-axis label */, dataset);
        chart.addSubtitle(new TextTitle("Time to generate 1000 charts in SVG "
                + "format (lower bars = better performance)"));
        chart.setBackgroundPaint(Color.white);
        CategoryPlot plot = chart.getCategoryPlot();

        // set transparent background paint, so the background color of the parent is used
//        java.awt.Color transparent = new java.awt.Color(1.0f, 1.0f, 1.0f, 0f);
//        chart.setBackgroundPaint(transparent);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        chart.getLegend().setFrame(BlockBorder.NONE);
        return chart;
    }

    private static XYSeries createRandomData(final String name, final double baseRadius, final double thetaInc) {
        final XYSeries series = new XYSeries(name);
        for (double coeff = 0.0; coeff < 365.0; coeff += thetaInc) {
            final double radius = baseRadius * (1.1 + Math.random());
            series.add(coeff, radius);
        }
        return series;
    }
    private static XYSeriesCollection createPolarDataset() {

        XYSeriesCollection dataSet = new XYSeriesCollection();
        XYSeries series1 = createRandomData("Series 1", 77.0, 8.0);
        XYSeries series2 = createRandomData("Series 2", 52.0, 6.0);
        XYSeries series3 = createRandomData("Series 3", 32.0, 2.0);
        dataSet.addSeries(series1);
        dataSet.addSeries(series2);
        dataSet.addSeries(series3);
        return dataSet;
    }

    /**
     * Creates a sample chart.
     *
     * @param dataSet  the dataset.
     *
     * @return The chart.
     */
    private static JFreeChart createPolarChart(XYDataset dataSet) {
        JFreeChart chart = ChartFactory.createPolarChart("Polar Chart Example", dataSet, true, true, false);
        chart.addSubtitle(new TextTitle("Time to generate 1000 charts in SVG "
                + "format (lower bars = better performance)"));
        chart.setBackgroundPaint(Color.white);
        //CategoryPlot plot = chart.getCategoryPlot();

        // set transparent background paint, so the background color of the parent is used
//        java.awt.Color transparent = new java.awt.Color(1.0f, 1.0f, 1.0f, 0f);
//        chart.setBackgroundPaint(transparent);

//        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
//        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
//        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        //renderer.setDrawBarOutline(false);
        chart.getLegend().setFrame(BlockBorder.NONE);
        return chart;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartFrame frame = new ChartFrame("BarChart,,,,,,,,,", chart);
        frame.setVisible(true);
        frame.setSize(800, 600);

        XYSeriesCollection dataSet = createPolarDataset();
        JFreeChart chart1 = createPolarChart(dataSet);
        ChartFrame frame1 = new ChartFrame("BarChart,,,,,,,,,", chart1);
        frame1.setVisible(true);
        frame1.setSize(800, 600);
    }
}