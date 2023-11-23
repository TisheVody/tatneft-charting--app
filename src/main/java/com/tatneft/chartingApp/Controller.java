package com.tatneft.chartingApp;

import com.tatneft.chartingApp.Charts.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.flow.FlowPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.UIUtils;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.flow.DefaultFlowDataset;
import org.jfree.data.flow.FlowDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

import static com.tatneft.chartingApp.Charts.tests.title;

public class Controller implements Initializable {

    @FXML
    private ToggleButton btnAreaChart;
    @FXML
    private ToggleGroup btnGroup;
    @FXML
    private ToggleButton btnPolarChart;
    @FXML
    private ToggleButton btnSankeyChart;
    @FXML
    private Button btnDrawChart;
    @FXML
    private ImageView imgExample;
    @FXML
    private javafx.scene.control.TextField txtFieldValue1;
    @FXML
    private javafx.scene.control.TextField txtFieldValue2;
    @FXML
    private javafx.scene.control.TextField txtFieldValue3;
    @FXML
    private javafx.scene.control.TextField txtFieldValue4;

    @FXML
    private AreaChart areaChartId;

    public void toggleButtonSelect (ActionEvent event) {
        ImageView image = null;

        if (btnAreaChart.isSelected()) {
            image = new ImageView("C:\\Users\\trust\\IdeaProjects\\chartingApp\\src\\main\\resources\\images\\image_area_chart.png");
        }
        if (btnPolarChart.isSelected()) {
            image = new ImageView("C:\\Users\\trust\\IdeaProjects\\chartingApp\\src\\main\\resources\\images\\image_polar_chart.png");
        }
        if (btnSankeyChart.isSelected()) {
            image = new ImageView("C:\\Users\\trust\\IdeaProjects\\chartingApp\\src\\main\\resources\\images\\image_sankey_chart.png");
        }
        assert image != null;
        imgExample.setImage(image.getImage());
    }

    public void buttonDrawChartSelect (ActionEvent event) {
        if (btnAreaChart.isSelected()) {
            String value1 = txtFieldValue1.getText();
            String value2 = txtFieldValue2.getText();
            String value3 = txtFieldValue3.getText();
            String value4 = txtFieldValue4.getText();

            AreaChart.drawAreaChart(value1, value2, value3, value4);
        }

        if (btnPolarChart.isSelected()) {
            String value1 = txtFieldValue1.getText();
            String value2 = txtFieldValue2.getText();
            String value3 = txtFieldValue3.getText();
            String value4 = txtFieldValue4.getText();

            PolarChart.drawPolarChart(value1, value2, value3, value4);

            //tests.drawPolarChart();

//            PolarChartDemo demo = new PolarChartDemo("Polar Chart Demo");
//            demo.pack();
//            demo.setVisible(true);
        }

        if (btnSankeyChart.isSelected()) {
            FlowChart.drawFlowChart("JFreeChart: FlowPlotDemo.java");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}