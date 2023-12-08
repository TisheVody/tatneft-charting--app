package com.tatneft.chartingApp.Charts;

import com.tatneft.chartingApp.Colors.FlowColors;
import com.tatneft.chartingApp.models.FlowDataModel;
import com.tatneft.chartingApp.models.FlowValues;
import javafx.collections.ObservableList;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.flow.FlowPlot;
import org.jfree.chart.ui.UIUtils;
import org.jfree.data.flow.DefaultFlowDataset;
import org.jfree.data.flow.FlowDataset;

import javax.swing.*;
import java.awt.*;

public class FlowChart extends JFrame {
    public FlowChart(ObservableList<FlowValues> flowValues) {
        JPanel chartPanel = createDemoPanel(flowValues);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    public static JPanel createDemoPanel(ObservableList<FlowValues> flowValues) {
        FlowDataset<String> dataset = createDataset(flowValues);
        JFreeChart chart = createChart(dataset);
        return new ChartPanel(chart);
    }

    private static FlowDataset<String> createDataset(ObservableList<FlowValues> flowValues) {
        DefaultFlowDataset<String> dataset = new DefaultFlowDataset<>();
        for (FlowValues series : flowValues) {
            dataset.setFlow(series.getStage(), series.getSource(), series.getDestination(), series.getFlow());
        }
        return dataset;
    }

    public static Color[] createFlowColors() {
        Color[] result = new Color[10];
        result[0] = new Color(108, 236, 137);
        result[1] = new Color(253, 187, 46);
        result[2] = new Color(56, 236, 216);
        result[3] = new Color(171, 231, 51);
        result[4] = new Color(221, 214, 74);
        result[5] = new Color(106, 238, 70);
        result[6] = new Color(172, 230, 100);
        result[7] = new Color(242, 191, 82);
        result[8] = new Color(221, 233, 56);
        result[9] = new Color(242, 206, 47);
        return result;
    }

    static final JFreeChart createFlowPlot(String title, FlowDataset dataset) {
        FlowPlot plot = new FlowPlot(dataset);
        plot.setBackgroundPaint(Color.BLACK);
        plot.setNodeColorSwatch(FlowColors.createFancyLightColors());
        //plot.setDefaultNodeLabelPaint(Color.WHITE);
        JFreeChart chart = new JFreeChart(title, plot);
        return chart;
    }

    private static JFreeChart createChart(FlowDataset<String> dataset) {
        JFreeChart chart = createFlowPlot("Flow Plot", dataset);
        return chart;
    }

    public static void drawFlowChart(ObservableList<FlowValues> flowValues) {
        FlowChart demo = new FlowChart(flowValues);
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        demo.pack();
        UIUtils.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
