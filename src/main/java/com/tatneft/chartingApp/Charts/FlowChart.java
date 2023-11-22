package com.tatneft.chartingApp.Charts;

import com.tatneft.chartingApp.Colors.FlowColors;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.flow.FlowPlot;
import org.jfree.chart.ui.UIUtils;
import org.jfree.data.flow.DefaultFlowDataset;
import org.jfree.data.flow.FlowDataset;

import javax.swing.*;
import java.awt.*;

public class FlowChart extends JFrame {
    public FlowChart(String title) {
        super(title);
        JPanel chartPanel = createDemoPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(760, 500));
        setContentPane(chartPanel);
    }

    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     *
     * @return A panel.
     */
    public static JPanel createDemoPanel() {
        FlowDataset<String> dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        return new ChartPanel(chart);
    }

    /**
     * Creates a dataset.
     *
     * @return a dataset.
     */
    private static FlowDataset<String> createDataset() {
        DefaultFlowDataset<String> dataset = new DefaultFlowDataset<>();
        dataset.setFlow(0, "A", "W", 5.0);
        dataset.setFlow(0, "A", "X", 5.0);
        dataset.setFlow(0, "A", "Y", 2.0);
        dataset.setFlow(0, "A", "Z", 1.0);
        dataset.setFlow(0, "B", "X", 2.0);
        dataset.setFlow(0, "B", "Y", 2.0);
        dataset.setFlow(0, "B", "Z", 2.0);

        //dataset.setFlow(1, "W", "D", 6);
        dataset.setFlow(1, "X", "D", 3);
        dataset.setFlow(1, "X", "E", 4);
        dataset.setFlow(1, "Y", "D", 5);
        dataset.setFlow(1, "Y", "E", 3);
        dataset.setFlow(1, "Z", "D", 2);
        dataset.setFlow(1, "Z", "E", 1);

        dataset.setFlow(2, "D", "H", 3);
        dataset.setFlow(2, "D", "I", 3);
        dataset.setFlow(2, "D", "J", 0);
        dataset.setFlow(2, "E", "H", 3);
        dataset.setFlow(2, "E", "I", 2);
        dataset.setFlow(2, "E", "J", 3);
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

    /**
     * Creates a sample chart.
     *
     * @param dataset  the dataset.
     *
     * @return A sample chart.
     */
    private static JFreeChart createChart(FlowDataset<String> dataset) {
        JFreeChart chart = createFlowPlot("Flow Plot", dataset);
        return chart;
    }

    public static void drawFlowChart(String title) {
        FlowChart demo = new FlowChart(title);
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        demo.pack();
        UIUtils.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
