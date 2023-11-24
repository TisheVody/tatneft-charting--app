package com.tatneft.chartingApp.Charts;

import com.tatneft.chartingApp.Colors.FlowColors;
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
    public static void drawAreaChart(String groupValue1, String groupValue2, String g1ox1, String g1ox2,
                                     String g1ox3, String g1ox4, String g1oy1, String g1oy2,
                                     String g1oy3, String g1oy4, String g2ox1, String g2ox2,
                                     String g2ox3, String g2ox4, String g2oy1, String g2oy2,
                                     String g2oy3, String g2oy4) {
        CategoryDataset areaDataset = createAreaDataset(groupValue1, groupValue2, g1ox1, g1ox2,
                g1ox3, g1ox4, g1oy1, g1oy2,
                g1oy3, g1oy4, g2ox1, g2ox2,
                g2ox3, g2ox4, g2oy1, g2oy2,
                g2oy3, g2oy4);
        JFreeChart areaChart = createAreaChart(areaDataset);
        ChartFrame areaFrame = new ChartFrame("Area Chart", areaChart);
        areaFrame.setVisible(true);
        areaFrame.setSize(800, 600);
    }

    private static CategoryDataset createAreaDataset(String groupValue1, String groupValue2, String g1ox1, String g1ox2,
                                                     String g1ox3, String g1ox4, String g1oy1, String g1oy2,
                                                     String g1oy3, String g1oy4, String g2ox1, String g2ox2,
                                                     String g2ox3, String g2ox4, String g2oy1, String g2oy2,
                                                     String g2oy3, String g2oy4) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(Double.parseDouble(g1oy1), groupValue1, g1ox1);
        dataset.addValue(Double.parseDouble(g1oy2), groupValue1, g1ox2);
        dataset.addValue(Double.parseDouble(g1oy3), groupValue1, g1ox3);
        dataset.addValue(Double.parseDouble(g1oy4), groupValue1, g1ox4);

        dataset.addValue(Double.parseDouble(g2oy1), groupValue2, g2ox1);
        dataset.addValue(Double.parseDouble(g2oy2), groupValue2, g2ox2);
        dataset.addValue(Double.parseDouble(g2oy3), groupValue2, g2ox3);
        dataset.addValue(Double.parseDouble(g2oy4), groupValue2, g2ox4);

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
        FlowColors.createFancyLightColors();

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        areaChart.getLegend().setFrame(BlockBorder.NONE);
        return areaChart;
    }
}
