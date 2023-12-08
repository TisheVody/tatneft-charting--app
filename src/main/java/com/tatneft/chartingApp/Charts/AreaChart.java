package com.tatneft.chartingApp.Charts;

import com.tatneft.chartingApp.models.*;
import javafx.collections.ObservableList;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class AreaChart {
    private static CategoryDataset createAreaDataset(ObservableList<AreaValues> listOfGroups) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (AreaValues group : listOfGroups) {
            dataset.addValue(Double.parseDouble(group.getY()), group.getGroupName(), group.getX());
        }
        return dataset;
    }
    private static JFreeChart createAreaChart(CategoryDataset dataset) {
        JFreeChart areaChart = ChartFactory.createAreaChart(
                "JFreeChart Area Chart", // Chart title
                "Time", // X-Axis Label
                "Popularity", // Y-Axis Label
                dataset // Dataset for the Chart
        );
        areaChart.setBackgroundPaint(ChartColor.white);
        CategoryPlot plot = areaChart.getCategoryPlot();

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        areaChart.getLegend().setFrame(BlockBorder.NONE);
        return areaChart;
    }
    public static void drawAreaChart(ObservableList<AreaValues> listOfGroups) {
        CategoryDataset areaDataset = createAreaDataset(listOfGroups);
        JFreeChart areaChart = createAreaChart(areaDataset);
        ChartFrame areaFrame = new ChartFrame("Area Chart", areaChart);
        areaFrame.setVisible(true);
        areaFrame.setSize(800, 600);
    }
}

