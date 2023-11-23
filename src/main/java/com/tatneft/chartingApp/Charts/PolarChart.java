package com.tatneft.chartingApp.Charts;

import com.tatneft.chartingApp.ThemesForCharts;
import javafx.util.Pair;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.util.ArrayList;

import static com.tatneft.chartingApp.utility.Utility.createRandomData;

public class PolarChart {

    private static JFreeChart createPolarChart(XYDataset dataSet) {
        JFreeChart chart = ChartFactory.createPolarChart("Polar Chart Example", dataSet, true, true,
                false);
        chart.addSubtitle(new TextTitle("Time to generate 1000 charts in SVG "
                + "format (lower bars = better performance)"));
        ThemesForCharts.setStandardChartTheme();
        chart.setBackgroundPaint(Color.white);
        chart.getLegend().setFrame(BlockBorder.NONE);
        return chart;
    }

    private static java.util.List<XYSeries> generateSegments(Double radius, double segmentsAmount) {
        java.util.List<XYSeries> seriesList = new ArrayList<>();
        double segmentSize = 360.0 / segmentsAmount;
        for(int s = 0; s < segmentsAmount; s++) {
            radius = radius - s * 10;
            XYSeries series = new XYSeries("Series " + s);
            for(double i = segmentSize * s + 0.5; i < segmentSize * (s + 1) - 0.5; i++) {
                for (int j = 0; j < radius; j++) {
                    series.add(i, j);
                }
            }
            seriesList.add(series);
        }

        return seriesList;
    }
    private static XYSeriesCollection createPolarDataset(String value1, String value2, String value3, String value4) {
        XYSeriesCollection dataSet = new XYSeriesCollection();

        java.util.List<XYSeries> seriesList = generateSegments(100.0, 4.0);

        dataSet.addSeries(seriesList.get(0));
        dataSet.addSeries(seriesList.get(1));
        dataSet.addSeries(seriesList.get(2));
        dataSet.addSeries(seriesList.get(3));
        return dataSet;
    }

    public static void drawPolarChart(String value1, String value2, String value3, String value4){
        XYSeriesCollection polarDataset = createPolarDataset(value1, value2, value3, value4);
        JFreeChart polarChart = createPolarChart(polarDataset);
        ChartFrame polarFrame = new ChartFrame("Polar Chart", polarChart);
        polarFrame.setVisible(true);
        polarFrame.setSize(800, 600);
    }
}
