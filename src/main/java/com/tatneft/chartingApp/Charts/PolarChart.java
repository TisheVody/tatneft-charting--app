package com.tatneft.chartingApp.Charts;

import com.tatneft.chartingApp.Colors.FlowColors;
import com.tatneft.chartingApp.ThemesForCharts;
import com.tatneft.chartingApp.models.AreaValues;
import com.tatneft.chartingApp.models.PolarValues;
import javafx.collections.ObservableList;
import javafx.util.Pair;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.util.ArrayList;

import static com.tatneft.chartingApp.utility.Utility.createRandomData;

public class PolarChart {

    private static JFreeChart createPolarChart(XYDataset dataSet) {
        JFreeChart chart = ChartFactory.createPolarChart("Polar Chart", dataSet, true, true,
                false);
        chart.setBackgroundPaint(Color.white);
        chart.getLegend().setFrame(BlockBorder.NONE);

        PolarPlot plot = (PolarPlot) chart.getPlot();
        DefaultPolarItemRenderer r = (DefaultPolarItemRenderer) plot.getRenderer();
        //r.setFillComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR,1f));

        for(int i =0; i<dataSet.getSeriesCount(); i++){
            //r.setSeriesFilled(i, true);
            r.setSeriesPaint(i, FlowColors.createCustomTatneftColors().get(i));
            //r.setShapesVisible(false);
            r.setDrawOutlineWhenFilled(false);
        }

//        DefaultPolarItemRenderer ren = new DefaultPolarItemRenderer();
//        PolarPlot polarPlot = new PolarPlot();
//        for (int i = 0; i < polarPlot.getAxisCount(); i++) {
//            for (int j = 0; j < FlowColors.getBrewerQualitativePairedN12Colors().size(); j++) {
//                ren.setSeriesPaint(i, FlowColors.getBrewerQualitativePairedN12Colors().get(j));
//            }
//        }
//        polarPlot.setRenderer(ren);
        return chart;
    }

    private static java.util.List<XYSeries> generateSegments(ObservableList<PolarValues> radius) {
        java.util.List<XYSeries> seriesList = new ArrayList<>();
        double segmentsAmount = radius.size();
        double segmentSize = 360.0 / segmentsAmount;
        for(int s = 0; s < segmentsAmount; s++) {
            //radius = radius - s * 10;
            //radius = new Double[]{radius[s]};
            XYSeries series = new XYSeries(radius.get(s).getSegmentName());
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
        polarFrame.setBackground(FlowColors.createFancyLightColors().get(4));
        polarFrame.setForeground(FlowColors.createFancyLightColors().get(5));
        polarFrame.setVisible(true);
        polarFrame.setSize(800, 600);
    }
}
