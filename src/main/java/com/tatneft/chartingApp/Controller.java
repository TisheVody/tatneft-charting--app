package com.tatneft.chartingApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
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
    private javafx.scene.control.TextField txtFieldValue1;

    @FXML
    private javafx.scene.control.TextField txtFieldValue2;

    @FXML
    private javafx.scene.control.TextField txtFieldValue3;

    @FXML
    private javafx.scene.control.TextField txtFieldValue4;

    public void toggleButtonSelect (ActionEvent event) {
        ImageView image = null;

        if (btnAreaChart.isSelected()) {
            image = new ImageView("C:\\Users\\trust\\IdeaProjects\\chartingApp\\src\\main\\resources\\images\\image_area_chart.png");

            CategoryDataset areaDataset = createAreaDataset();
            JFreeChart areaChart = createAreaChart(areaDataset);
            ChartFrame areaFrame = new ChartFrame("Area Chart", areaChart);
            areaFrame.setVisible(true);
            areaFrame.setSize(800, 600);
        }
        if (btnPolarChart.isSelected()) {
            image = new ImageView("C:\\Users\\trust\\IdeaProjects\\chartingApp\\src\\main\\resources\\images\\image_polar_chart.png");

            XYSeriesCollection polarDataset = createPolarDataset();
            JFreeChart polarChart = createPolarChart(polarDataset);
            ChartFrame polarFrame = new ChartFrame("Polar Chart", polarChart);
            polarFrame.setVisible(true);
            polarFrame.setSize(800, 600);
        }
        if (btnSankeyChart.isSelected()) {
            image = new ImageView("C:\\Users\\trust\\IdeaProjects\\chartingApp\\src\\main\\resources\\images\\image_sankey_chart.png");

            CategoryDataset barDataset = createBarDataset();
            JFreeChart barChart = createBarChart(barDataset);
            ChartFrame barFrame = new ChartFrame("Bar Chart", barChart);
            barFrame.setVisible(true);
            barFrame.setSize(800, 600);
        }
        assert image != null;
        imgExample.setImage(image.getImage());
    }

    private CategoryDataset createAreaDataset() {
        String value1 = txtFieldValue1.getText();
        String value2 = txtFieldValue2.getText();
        String value3 = txtFieldValue3.getText();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(Double.parseDouble(value1), "Python", "2010");
        dataset.addValue(Double.parseDouble(value2), "Python", "2015");
        dataset.addValue(Double.parseDouble(value3), "Python", "2020");

//        dataset.addValue(60, "Python", "2010");
//        dataset.addValue(80, "Python", "2015");
//        dataset.addValue(90, "Python", "2020");
//
//        dataset.addValue(50, "Java", "2010");
//        dataset.addValue(45, "Java", "2015");
//        dataset.addValue(32, "Java", "2020");
//
//        dataset.addValue(0,  "Rust", "2010");
//        dataset.addValue(10, "Rust", "2015");
//        dataset.addValue(23, "Rust", "2020");
        return dataset;
    }

    /**
     * Creates a sample chart.
     *
     * @param dataset  the dataset.
     *
     * @return The chart.
     */
    private static JFreeChart createAreaChart(CategoryDataset dataset) {
        JFreeChart areaChart = ChartFactory.createAreaChart(
                "JFreeChart Area Chart", // Chart title
                "Time", // X-Axis Label
                "Popularity", // Y-Axis Label
                dataset // Dataset for the Chart
        );
        ThemesForCharts.setStandardChartTheme();
        areaChart.setBackgroundPaint(Color.white);
        CategoryPlot plot = areaChart.getCategoryPlot();

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        areaChart.getLegend().setFrame(BlockBorder.NONE);
        return areaChart;
    }

    private CategoryDataset createBarDataset() {
        String value1 = txtFieldValue1.getText();
        String value2 = txtFieldValue2.getText();
        String value3 = txtFieldValue3.getText();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(Double.parseDouble(value1), "JFreeSVG", "Warm-up");
        dataset.addValue(Double.parseDouble(value2), "Batik", "Warm-up");
        dataset.addValue(Double.parseDouble(value3), "JFreeSVG", "Test");

        //dataset.addValue(21022, "Batik", "Test");
        return dataset;
    }

    /**
     * Creates a sample chart.
     *
     * @param dataset  the dataset.
     *
     * @return The chart.
     */
    private static JFreeChart createBarChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Performance: JFreeSVG vs Batik", null /* x-axis label*/,
                "Milliseconds" /* y-axis label */, dataset);
        chart.addSubtitle(new TextTitle("Time to generate 1000 charts in SVG "
                + "format (lower bars = better performance)"));

        ThemesForCharts.setStandardChartTheme();
        chart.setBackgroundPaint(Color.white);
        CategoryPlot plot = chart.getCategoryPlot();

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
    private XYSeriesCollection createPolarDataset() {
        String value1 = txtFieldValue1.getText();
        String value2 = txtFieldValue2.getText();
        String value3 = txtFieldValue3.getText();

        XYSeriesCollection dataSet = new XYSeriesCollection();
        XYSeries series1 = createRandomData("Series 1", Double.parseDouble(value1), 8.0);
        XYSeries series2 = createRandomData("Series 2", Double.parseDouble(value2), 6.0);
        XYSeries series3 = createRandomData("Series 3", Double.parseDouble(value3), 2.0);
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
        ThemesForCharts.setStandardChartTheme();
        chart.setBackgroundPaint(Color.white);
        chart.getLegend().setFrame(BlockBorder.NONE);
        return chart;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}