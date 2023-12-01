package com.tatneft.chartingApp.Charts;

import com.tatneft.chartingApp.Colors.FlowColors;
import com.tatneft.chartingApp.ThemesForCharts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Color;

import static javafx.beans.binding.Bindings.bindContent;


public class AreaChart {

    public static ObservableList<String> getTextFromAreaTextFields(ObservableList<TextField> textFields) {
        int amount = 9;
        Text[] groupNumber;
        //ObservableList<TextField> textFields = createAreaTextFields();
        ObservableList<String> text = FXCollections.observableArrayList();
        //bindContent(textFields, createAreaTextFields());


        for (int i = 0; i < amount; i++) {
            text.add(i, textFields.get(i).getText());
        }
        return text;
    }
    private static CategoryDataset createAreaDataset(ObservableList<TextField> textFields) {
        ObservableList<String> text = getTextFromAreaTextFields(textFields);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        dataset.addValue(Double.parseDouble(text.get(1)), text.get(0), text.get(5));
        dataset.addValue(Double.parseDouble(text.get(2)), text.get(0), text.get(6));
        dataset.addValue(Double.parseDouble(text.get(3)), text.get(0), text.get(7));
        dataset.addValue(Double.parseDouble(text.get(4)), text.get(0), text.get(8));
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
    public static void drawAreaChart(ObservableList<TextField> textFields) {
        CategoryDataset areaDataset = createAreaDataset(textFields);
        JFreeChart areaChart = createAreaChart(areaDataset);
        ChartFrame areaFrame = new ChartFrame("Area Chart", areaChart);
        areaFrame.setVisible(true);
        areaFrame.setSize(800, 600);
    }
}
