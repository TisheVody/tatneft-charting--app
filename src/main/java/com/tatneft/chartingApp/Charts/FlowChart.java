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
    public FlowChart(String title,
                     String stage1Text,
                     String stage2Text,
                     String stage3Text,
                     String txtS1Src1,
                     String txtS1Src2,
                     String txtS1Src3,
                     String txtS1Src4,
                     String txtS2Src1,
                     String txtS2Src2,
                     String txtS2Src3,
                     String txtS2Src4,
                     String txtS3Src1,
                     String txtS3Src2,
                     String txtS3Src3,
                     String txtS3Src4,
                     String txtS1Dest1,
                     String txtS1Dest2,
                     String txtS1Dest3,
                     String txtS1Dest4,
                     String txtS2Dest1,
                     String txtS2Dest2,
                     String txtS2Dest3,
                     String txtS2Dest4,
                     String txtS3Dest1,
                     String txtS3Dest2,
                     String txtS3Dest3,
                     String txtS3Dest4,
                     String txtS1Flow1,
                     String txtS1Flow2,
                     String txtS1Flow3,
                     String txtS1Flow4,
                     String txtS2Flow1,
                     String txtS2Flow2,
                     String txtS2Flow3,
                     String txtS2Flow4,
                     String txtS3Flow1,
                     String txtS3Flow2,
                     String txtS3Flow3,
                     String txtS3Flow4) {
        super(title);
        JPanel chartPanel = createDemoPanel(stage1Text,
                stage2Text,
                stage3Text,
                txtS1Src1,
                txtS1Src2,
                txtS1Src3,
                txtS1Src4,
                txtS2Src1,
                txtS2Src2,
                txtS2Src3,
                txtS2Src4,
                txtS3Src1,
                txtS3Src2,
                txtS3Src3,
                txtS3Src4,
                txtS1Dest1,
                txtS1Dest2,
                txtS1Dest3,
                txtS1Dest4,
                txtS2Dest1,
                txtS2Dest2,
                txtS2Dest3,
                txtS2Dest4,
                txtS3Dest1,
                txtS3Dest2,
                txtS3Dest3,
                txtS3Dest4,
                txtS1Flow1,
                txtS1Flow2,
                txtS1Flow3,
                txtS1Flow4,
                txtS2Flow1,
                txtS2Flow2,
                txtS2Flow3,
                txtS2Flow4,
                txtS3Flow1,
                txtS3Flow2,
                txtS3Flow3,
                txtS3Flow4);
        chartPanel.setPreferredSize(new java.awt.Dimension(760, 500));
        setContentPane(chartPanel);
    }

    public static JPanel createDemoPanel(String stage1Text,
        String stage2Text,
        String stage3Text,
        String txtS1Src1,
        String txtS1Src2,
        String txtS1Src3,
        String txtS1Src4,
        String txtS2Src1,
        String txtS2Src2,
        String txtS2Src3,
        String txtS2Src4,
        String txtS3Src1,
        String txtS3Src2,
        String txtS3Src3,
        String txtS3Src4,
        String txtS1Dest1,
        String txtS1Dest2,
        String txtS1Dest3,
        String txtS1Dest4,
        String txtS2Dest1,
        String txtS2Dest2,
        String txtS2Dest3,
        String txtS2Dest4,
        String txtS3Dest1,
        String txtS3Dest2,
        String txtS3Dest3,
        String txtS3Dest4,
        String txtS1Flow1,
        String txtS1Flow2,
        String txtS1Flow3,
        String txtS1Flow4,
        String txtS2Flow1,
        String txtS2Flow2,
        String txtS2Flow3,
        String txtS2Flow4,
        String txtS3Flow1,
        String txtS3Flow2,
        String txtS3Flow3,
        String txtS3Flow4) {
        FlowDataset<String> dataset = createDataset(stage1Text,
                stage2Text,
                stage3Text,
                txtS1Src1,
                txtS1Src2,
                txtS1Src3,
                txtS1Src4,
                txtS2Src1,
                txtS2Src2,
                txtS2Src3,
                txtS2Src4,
                txtS3Src1,
                txtS3Src2,
                txtS3Src3,
                txtS3Src4,
                txtS1Dest1,
                txtS1Dest2,
                txtS1Dest3,
                txtS1Dest4,
                txtS2Dest1,
                txtS2Dest2,
                txtS2Dest3,
                txtS2Dest4,
                txtS3Dest1,
                txtS3Dest2,
                txtS3Dest3,
                txtS3Dest4,
                txtS1Flow1,
                txtS1Flow2,
                txtS1Flow3,
                txtS1Flow4,
                txtS2Flow1,
                txtS2Flow2,
                txtS2Flow3,
                txtS2Flow4,
                txtS3Flow1,
                txtS3Flow2,
                txtS3Flow3,
                txtS3Flow4);
        JFreeChart chart = createChart(dataset);
        return new ChartPanel(chart);
    }

    private static FlowDataset<String> createDataset(String stage1Text,
        String stage2Text,
        String stage3Text,
        String txtS1Src1,
        String txtS1Src2,
        String txtS1Src3,
        String txtS1Src4,
        String txtS2Src1,
        String txtS2Src2,
        String txtS2Src3,
        String txtS2Src4,
        String txtS3Src1,
        String txtS3Src2,
        String txtS3Src3,
        String txtS3Src4,
        String txtS1Dest1,
        String txtS1Dest2,
        String txtS1Dest3,
        String txtS1Dest4,
        String txtS2Dest1,
        String txtS2Dest2,
        String txtS2Dest3,
        String txtS2Dest4,
        String txtS3Dest1,
        String txtS3Dest2,
        String txtS3Dest3,
        String txtS3Dest4,
        String txtS1Flow1,
        String txtS1Flow2,
        String txtS1Flow3,
        String txtS1Flow4,
        String txtS2Flow1,
        String txtS2Flow2,
        String txtS2Flow3,
        String txtS2Flow4,
        String txtS3Flow1,
        String txtS3Flow2,
        String txtS3Flow3,
        String txtS3Flow4) {
        DefaultFlowDataset<String> dataset = new DefaultFlowDataset<>();
        dataset.setFlow(0, txtS1Src1, txtS1Dest1, Double.parseDouble(txtS1Flow1));
        dataset.setFlow(0, txtS1Src2, txtS1Dest2, Double.parseDouble(txtS1Flow2));
        dataset.setFlow(0, txtS1Src3, txtS1Dest3, Double.parseDouble(txtS1Flow3));
        dataset.setFlow(0, txtS1Src4, txtS1Dest4, Double.parseDouble(txtS1Flow4));

        dataset.setFlow(1, txtS2Src1, txtS2Dest1, Double.parseDouble(txtS2Flow1));
        dataset.setFlow(1, txtS2Src2, txtS2Dest2, Double.parseDouble(txtS2Flow2));
        dataset.setFlow(1, txtS2Src3, txtS2Dest3, Double.parseDouble(txtS2Flow3));
        dataset.setFlow(1, txtS2Src4, txtS2Dest4, Double.parseDouble(txtS2Flow4));

        dataset.setFlow(2, txtS3Src1, txtS3Dest1, Double.parseDouble(txtS3Flow1));
        dataset.setFlow(2, txtS3Src2, txtS3Dest2, Double.parseDouble(txtS3Flow2));
        dataset.setFlow(2, txtS3Src3, txtS3Dest3, Double.parseDouble(txtS3Flow3));
        dataset.setFlow(2, txtS3Src4, txtS3Dest4, Double.parseDouble(txtS3Flow4));

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

    public static void drawFlowChart(String title,
                                     String stage1Text,
                                     String stage2Text,
                                     String stage3Text,
                                     String txtS1Src1,
                                     String txtS1Src2,
                                     String txtS1Src3,
                                     String txtS1Src4,
                                     String txtS2Src1,
                                     String txtS2Src2,
                                     String txtS2Src3,
                                     String txtS2Src4,
                                     String txtS3Src1,
                                     String txtS3Src2,
                                     String txtS3Src3,
                                     String txtS3Src4,
                                     String txtS1Dest1,
                                     String txtS1Dest2,
                                     String txtS1Dest3,
                                     String txtS1Dest4,
                                     String txtS2Dest1,
                                     String txtS2Dest2,
                                     String txtS2Dest3,
                                     String txtS2Dest4,
                                     String txtS3Dest1,
                                     String txtS3Dest2,
                                     String txtS3Dest3,
                                     String txtS3Dest4,
                                     String txtS1Flow1,
                                     String txtS1Flow2,
                                     String txtS1Flow3,
                                     String txtS1Flow4,
                                     String txtS2Flow1,
                                     String txtS2Flow2,
                                     String txtS2Flow3,
                                     String txtS2Flow4,
                                     String txtS3Flow1,
                                     String txtS3Flow2,
                                     String txtS3Flow3,
                                     String txtS3Flow4) {
        FlowChart demo = new FlowChart(title,
                stage1Text,
                stage2Text,
                stage3Text,
                txtS1Src1,
                txtS1Src2,
                txtS1Src3,
                txtS1Src4,
                txtS2Src1,
                txtS2Src2,
                txtS2Src3,
                txtS2Src4,
                txtS3Src1,
                txtS3Src2,
                txtS3Src3,
                txtS3Src4,
                txtS1Dest1,
                txtS1Dest2,
                txtS1Dest3,
                txtS1Dest4,
                txtS2Dest1,
                txtS2Dest2,
                txtS2Dest3,
                txtS2Dest4,
                txtS3Dest1,
                txtS3Dest2,
                txtS3Dest3,
                txtS3Dest4,
                txtS1Flow1,
                txtS1Flow2,
                txtS1Flow3,
                txtS1Flow4,
                txtS2Flow1,
                txtS2Flow2,
                txtS2Flow3,
                txtS2Flow4,
                txtS3Flow1,
                txtS3Flow2,
                txtS3Flow3,
                txtS3Flow4);
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        demo.pack();
        UIUtils.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
