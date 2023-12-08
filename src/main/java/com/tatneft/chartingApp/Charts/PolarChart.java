package com.tatneft.chartingApp.Charts;

import com.tatneft.chartingApp.ThemesForCharts;
import com.tatneft.chartingApp.models.AreaValues;
import com.tatneft.chartingApp.models.PolarValues;
import javafx.collections.ObservableList;
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

    private static java.util.List<XYSeries> generateSegments(ObservableList<PolarValues> radius) {
        java.util.List<XYSeries> seriesList = new ArrayList<>();
        double segmentsAmount = radius.size();
        double segmentSize = 360.0 / segmentsAmount;
        for(int s = 0; s < segmentsAmount; s++) {
            //radius = radius - s * 10;
            //radius = new Double[]{radius[s]};
            XYSeries series = new XYSeries("Series " + radius.get(s).getSegmentName());
            for(double i = segmentSize * s + 0.5; i < segmentSize * (s + 1) - 0.5; i++) {
                for (int j = 0; j < Double.parseDouble(radius.get(s).getX()); j++) {
                    series.add(i, j);
                }
            }
            seriesList.add(series);
        }
        return seriesList;
    }

    private static XYSeriesCollection createPolarDataset(ObservableList<PolarValues> listOfValues) {
        XYSeriesCollection dataSet = new XYSeriesCollection();

        java.util.List<XYSeries> seriesList = generateSegments(listOfValues);
        for (XYSeries series : seriesList) {
            dataSet.addSeries(series);
        }
        return dataSet;
    }

    public static void drawPolarChart(ObservableList<PolarValues> listOfValues){
        XYSeriesCollection polarDataset = createPolarDataset(listOfValues);
        JFreeChart polarChart = createPolarChart(polarDataset);
        ChartFrame polarFrame = new ChartFrame("Polar Chart", polarChart);
        polarFrame.setVisible(true);
        polarFrame.setSize(800, 600);
    }
}
