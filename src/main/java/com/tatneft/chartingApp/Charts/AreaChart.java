package com.tatneft.chartingApp.Charts;

import com.tatneft.chartingApp.ThemesForCharts;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;

public class AreaChart {
    public static void drawAreaChart(String value1, String value2, String value3, String value4) {
        CategoryDataset areaDataset = createAreaDataset(value1, value2, value3, value4);
        JFreeChart areaChart = createAreaChart(areaDataset);
        ChartFrame areaFrame = new ChartFrame("Area Chart", areaChart);
        areaFrame.setVisible(true);
        areaFrame.setSize(800, 600);
    }

    private static CategoryDataset createAreaDataset(String value1, String value2, String value3, String value4) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(Double.parseDouble(value1), "Python", "2010");
        dataset.addValue(Double.parseDouble(value2), "Python", "2015");
        dataset.addValue(Double.parseDouble(value3), "Python", "2020");
        dataset.addValue(Double.parseDouble(value4), "Python", "2025");

        return dataset;
    }

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
}
