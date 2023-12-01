package com.tatneft.chartingApp;

import com.tatneft.chartingApp.Charts.AreaChart;
import com.tatneft.chartingApp.Charts.FlowChart;
import com.tatneft.chartingApp.Charts.PolarChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.net.URL;
import java.util.ResourceBundle;


import static javafx.beans.binding.Bindings.bindContent;

public class Controller implements Initializable {
    @FXML
    private Button btnACAddGroupOfValues;

    @FXML
    private ToggleButton btnAreaChart;

    @FXML
    private Button btnDrawAreaChart;

    @FXML
    private Button btnDrawFlowChart;

    @FXML
    private Button btnDrawPolarChart;

    @FXML
    private ToggleGroup btnGroup;

    @FXML
    private ToggleButton btnPolarChart;

    @FXML
    private ToggleButton btnSankeyChart;

    @FXML
    private ImageView imgExample;

    @FXML
    private ImageView imgExample11;

    @FXML
    private ImageView imgExample2;

    @FXML
    private ImageView imgExample3;

    @FXML
    private TabPane mainTabPane;

    @FXML
    private Tab tabAreaChart;

    @FXML
    private Tab tabFlowChart;

    @FXML
    private Tab tabPolarChart;

    @FXML
    private Tab tabSelectChart;

    @FXML
    private TextField txtFieldGroupValue1;

    @FXML
    private TextField txtFieldGroupValue2;

    @FXML
    private TextField txtFieldOx11;

    @FXML
    private TextField txtFieldOx12;

    @FXML
    private TextField txtFieldOx13;

    @FXML
    private TextField txtFieldOx14;

    @FXML
    private TextField txtFieldOx21;

    @FXML
    private TextField txtFieldOx22;

    @FXML
    private TextField txtFieldOx23;

    @FXML
    private TextField txtFieldOx24;

    @FXML
    private TextField txtFieldOy11;

    @FXML
    private TextField txtFieldOy12;

    @FXML
    private TextField txtFieldOy13;

    @FXML
    private TextField txtFieldOy14;

    @FXML
    private TextField txtFieldOy21;

    @FXML
    private TextField txtFieldOy22;

    @FXML
    private TextField txtFieldOy23;

    @FXML
    private TextField txtFieldOy24;

    @FXML
    private TextField txtFieldPolarValue1;

    @FXML
    private TextField txtFieldPolarValue2;

    @FXML
    private TextField txtFieldPolarValue3;

    @FXML
    private TextField txtFieldPolarValue4;

    @FXML
    private TextField txtFieldS1Dest1;

    @FXML
    private TextField txtFieldS1Dest2;

    @FXML
    private TextField txtFieldS1Dest3;

    @FXML
    private TextField txtFieldS1Dest4;

    @FXML
    private TextField txtFieldS1Flow1;

    @FXML
    private TextField txtFieldS1Flow2;

    @FXML
    private TextField txtFieldS1Flow3;

    @FXML
    private TextField txtFieldS1Flow4;

    @FXML
    private TextField txtFieldS1Src1;

    @FXML
    private TextField txtFieldS1Src2;

    @FXML
    private TextField txtFieldS1Src3;

    @FXML
    private TextField txtFieldS1Src4;

    @FXML
    private TextField txtFieldS2Dest1;

    @FXML
    private TextField txtFieldS2Dest2;

    @FXML
    private TextField txtFieldS2Dest3;

    @FXML
    private TextField txtFieldS2Dest4;

    @FXML
    private TextField txtFieldS2Flow1;

    @FXML
    private TextField txtFieldS2Flow2;

    @FXML
    private TextField txtFieldS2Flow3;

    @FXML
    private TextField txtFieldS2Flow4;

    @FXML
    private TextField txtFieldS2Src1;

    @FXML
    private TextField txtFieldS2Src2;

    @FXML
    private TextField txtFieldS2Src3;

    @FXML
    private TextField txtFieldS2Src4;

    @FXML
    private TextField txtFieldS3Dest1;

    @FXML
    private TextField txtFieldS3Dest2;

    @FXML
    private TextField txtFieldS3Dest3;

    @FXML
    private TextField txtFieldS3Dest4;

    @FXML
    private TextField txtFieldS3Flow1;

    @FXML
    private TextField txtFieldS3Flow2;

    @FXML
    private TextField txtFieldS3Flow3;

    @FXML
    private TextField txtFieldS3Flow4;

    @FXML
    private TextField txtFieldS3Src1;

    @FXML
    private TextField txtFieldS3Src2;

    @FXML
    private TextField txtFieldS3Src3;

    @FXML
    private TextField txtFieldS3Src4;

    @FXML
    private TextField txtFieldStage1;

    @FXML
    private TextField txtFieldStage2;

    @FXML
    private TextField txtFieldStage3;
    @FXML
    private RowConstraints row2AC;

    @FXML
    private GridPane areaGridPane;



    public void toggleButtonSelect (ActionEvent event) {
        ImageView image = null;

        if (btnAreaChart.isSelected()) {
            mainTabPane.getTabs().add(tabAreaChart);
            image = new ImageView("C:\\Users\\trust\\IdeaProjects\\chartingApp\\src\\main\\resources\\images\\image_area_chart.png");
            mainTabPane.getSelectionModel().select(tabAreaChart);
        }else if (btnPolarChart.isSelected()) {
            mainTabPane.getTabs().add(tabPolarChart);
            image = new ImageView("C:\\Users\\trust\\IdeaProjects\\chartingApp\\src\\main\\resources\\images\\image_polar_chart.png");
            mainTabPane.getSelectionModel().select(tabPolarChart);
        }else if (btnSankeyChart.isSelected()) {
            mainTabPane.getTabs().add(tabFlowChart);
            image = new ImageView("C:\\Users\\trust\\IdeaProjects\\chartingApp\\src\\main\\resources\\images\\image_sankey_chart.png");
            mainTabPane.getSelectionModel().select(tabFlowChart);
        }
        assert image != null;
        //imgExample.setImage(image.getImage());
    }

//    public void buttonDrawAreaChart (ActionEvent event) {
//        String groupValue1 = txtFieldGroupValue1.getText();
//
//        String g1ox1 = txtFieldOx11.getText();
//        String g1ox2 = txtFieldOx12.getText();
//        String g1ox3 = txtFieldOx13.getText();
//        String g1ox4 = txtFieldOx14.getText();
//
//        String g1oy1 = txtFieldOy11.getText();
//        String g1oy2 = txtFieldOy12.getText();
//        String g1oy3 = txtFieldOy13.getText();
//        String g1oy4 = txtFieldOy14.getText();
//
//        String groupValue2 = txtFieldGroupValue2.getText();
//
//        String g2ox1 = txtFieldOx21.getText();
//        String g2ox2 = txtFieldOx22.getText();
//        String g2ox3 = txtFieldOx23.getText();
//        String g2ox4 = txtFieldOx24.getText();
//
//        String g2oy1 = txtFieldOy21.getText();
//        String g2oy2 = txtFieldOy22.getText();
//        String g2oy3 = txtFieldOy23.getText();
//        String g2oy4 = txtFieldOy24.getText();
//
//        AreaChart.drawAreaChart(groupValue1, groupValue2, g1ox1, g1ox2,
//                g1ox3, g1ox4, g1oy1, g1oy2,
//                g1oy3, g1oy4, g2ox1, g2ox2,
//                g2ox3, g2ox4, g2oy1, g2oy2,
//                g2oy3, g2oy4);
//    }

    public void buttonDrawFlowChart (ActionEvent event) {
        String stage1Text = txtFieldStage1.getText();
        String stage2Text = txtFieldStage2.getText();
        String stage3Text = txtFieldStage3.getText();
        String txtS1Src1 = txtFieldS1Src1.getText();
        String txtS1Src2 = txtFieldS1Src3.getText();
        String txtS1Src3 = txtFieldS1Src3.getText();
        String txtS1Src4 = txtFieldS1Src4.getText();
        String txtS2Src1 = txtFieldS2Src1.getText();
        String txtS2Src2 = txtFieldS2Src3.getText();
        String txtS2Src3 = txtFieldS2Src3.getText();
        String txtS2Src4 = txtFieldS2Src4.getText();
        String txtS3Src1 = txtFieldS3Src1.getText();
        String txtS3Src2 = txtFieldS3Src3.getText();
        String txtS3Src3 = txtFieldS3Src3.getText();
        String txtS3Src4 = txtFieldS3Src4.getText();
        String txtS1Dest1 = txtFieldS1Dest1.getText();
        String txtS1Dest2 = txtFieldS1Dest3.getText();
        String txtS1Dest3 = txtFieldS1Dest3.getText();
        String txtS1Dest4 = txtFieldS1Dest4.getText();
        String txtS2Dest1 = txtFieldS2Dest1.getText();
        String txtS2Dest2 = txtFieldS2Dest3.getText();
        String txtS2Dest3 = txtFieldS2Dest3.getText();
        String txtS2Dest4 = txtFieldS2Dest4.getText();
        String txtS3Dest1 = txtFieldS3Dest1.getText();
        String txtS3Dest2 = txtFieldS3Dest3.getText();
        String txtS3Dest3 = txtFieldS3Dest3.getText();
        String txtS3Dest4 = txtFieldS3Dest4.getText();
        String txtS1Flow1 = txtFieldS1Flow1.getText();
        String txtS1Flow2 = txtFieldS1Flow3.getText();
        String txtS1Flow3 = txtFieldS1Flow3.getText();
        String txtS1Flow4 = txtFieldS1Flow4.getText();
        String txtS2Flow1 = txtFieldS2Flow1.getText();
        String txtS2Flow2 = txtFieldS2Flow3.getText();
        String txtS2Flow3 = txtFieldS2Flow3.getText();
        String txtS2Flow4 = txtFieldS2Flow4.getText();
        String txtS3Flow1 = txtFieldS3Flow1.getText();
        String txtS3Flow2 = txtFieldS3Flow3.getText();
        String txtS3Flow3 = txtFieldS3Flow3.getText();
        String txtS3Flow4 = txtFieldS3Flow4.getText();

        FlowChart.drawFlowChart("JFreeChart: FlowPlotDemo.java",
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
    }

    public void buttonDrawPolarChart (ActionEvent event) {
        Double[] value = new Double[5];
        value[0] = Double.valueOf(txtFieldPolarValue1.getText());
        value[1] = Double.valueOf(txtFieldPolarValue2.getText());
        value[2] = Double.valueOf(txtFieldPolarValue3.getText());
        value[3] = Double.valueOf(txtFieldPolarValue4.getText());

        PolarChart.drawPolarChart(value);
    }
//    public void buttonDrawChartSelect (ActionEvent event) {
//        if (btnAreaChart.isSelected()) {
//            String groupValue1 = txtFieldGroupValue1.getText();
//
//            String g1ox1 = txtFieldOx11.getText();
//            String g1ox2 = txtFieldOx12.getText();
//            String g1ox3 = txtFieldOx13.getText();
//            String g1ox4 = txtFieldOx14.getText();
//
//            String g1oy1 = txtFieldOy11.getText();
//            String g1oy2 = txtFieldOy12.getText();
//            String g1oy3 = txtFieldOy13.getText();
//            String g1oy4 = txtFieldOy14.getText();
//
//            String groupValue2 = txtFieldGroupValue2.getText();
//
//            String g2ox1 = txtFieldOx21.getText();
//            String g2ox2 = txtFieldOx22.getText();
//            String g2ox3 = txtFieldOx23.getText();
//            String g2ox4 = txtFieldOx24.getText();
//
//            String g2oy1 = txtFieldOy21.getText();
//            String g2oy2 = txtFieldOy22.getText();
//            String g2oy3 = txtFieldOy23.getText();
//            String g2oy4 = txtFieldOy24.getText();
//
//            AreaChart.drawAreaChart(groupValue1, groupValue2, g1ox1, g1ox2,
//                    g1ox3, g1ox4, g1oy1, g1oy2,
//                    g1oy3, g1oy4, g2ox1, g2ox2,
//                    g2ox3, g2ox4, g2oy1, g2oy2,
//                    g2oy3, g2oy4);
//        }
//
//        if (btnPolarChart.isSelected()) {
////            String value1 = txtFieldValue1.getText();
////            String value2 = txtFieldValue2.getText();
////            String value3 = txtFieldValue3.getText();
////            String value4 = txtFieldValue4.getText();
//
//            //PolarChart.drawPolarChart(value1, value2, value3, value4);
//
//            //tests.drawPolarChart();
//
////            PolarChartDemo demo = new PolarChartDemo("Polar Chart Demo");
////            demo.pack();
////            demo.setVisible(true);
//        }
//
//        if (btnSankeyChart.isSelected()) {
//            String stage1Text = txtFieldStage1.getText();
//            String stage2Text = txtFieldStage2.getText();
//            String stage3Text = txtFieldStage3.getText();
//            String txtS1Src1 = txtFieldS1Src1.getText();
//            String txtS1Src2 = txtFieldS1Src3.getText();
//            String txtS1Src3 = txtFieldS1Src3.getText();
//            String txtS1Src4 = txtFieldS1Src4.getText();
//            String txtS2Src1 = txtFieldS2Src1.getText();
//            String txtS2Src2 = txtFieldS2Src3.getText();
//            String txtS2Src3 = txtFieldS2Src3.getText();
//            String txtS2Src4 = txtFieldS2Src4.getText();
//            String txtS3Src1 = txtFieldS3Src1.getText();
//            String txtS3Src2 = txtFieldS3Src3.getText();
//            String txtS3Src3 = txtFieldS3Src3.getText();
//            String txtS3Src4 = txtFieldS3Src4.getText();
//            String txtS1Dest1 = txtFieldS1Dest1.getText();
//            String txtS1Dest2 = txtFieldS1Dest3.getText();
//            String txtS1Dest3 = txtFieldS1Dest3.getText();
//            String txtS1Dest4 = txtFieldS1Dest4.getText();
//            String txtS2Dest1 = txtFieldS2Dest1.getText();
//            String txtS2Dest2 = txtFieldS2Dest3.getText();
//            String txtS2Dest3 = txtFieldS2Dest3.getText();
//            String txtS2Dest4 = txtFieldS2Dest4.getText();
//            String txtS3Dest1 = txtFieldS3Dest1.getText();
//            String txtS3Dest2 = txtFieldS3Dest3.getText();
//            String txtS3Dest3 = txtFieldS3Dest3.getText();
//            String txtS3Dest4 = txtFieldS3Dest4.getText();
//            String txtS1Flow1 = txtFieldS1Flow1.getText();
//            String txtS1Flow2 = txtFieldS1Flow3.getText();
//            String txtS1Flow3 = txtFieldS1Flow3.getText();
//            String txtS1Flow4 = txtFieldS1Flow4.getText();
//            String txtS2Flow1 = txtFieldS2Flow1.getText();
//            String txtS2Flow2 = txtFieldS2Flow3.getText();
//            String txtS2Flow3 = txtFieldS2Flow3.getText();
//            String txtS2Flow4 = txtFieldS2Flow4.getText();
//            String txtS3Flow1 = txtFieldS3Flow1.getText();
//            String txtS3Flow2 = txtFieldS3Flow3.getText();
//            String txtS3Flow3 = txtFieldS3Flow3.getText();
//            String txtS3Flow4 = txtFieldS3Flow4.getText();
//
//            FlowChart.drawFlowChart("JFreeChart: FlowPlotDemo.java",
//                    stage1Text,
//                    stage2Text,
//                    stage3Text,
//                    txtS1Src1,
//                    txtS1Src2,
//                    txtS1Src3,
//                    txtS1Src4,
//                    txtS2Src1,
//                    txtS2Src2,
//                    txtS2Src3,
//                    txtS2Src4,
//                    txtS3Src1,
//                    txtS3Src2,
//                    txtS3Src3,
//                    txtS3Src4,
//                    txtS1Dest1,
//                    txtS1Dest2,
//                    txtS1Dest3,
//                    txtS1Dest4,
//                    txtS2Dest1,
//                    txtS2Dest2,
//                    txtS2Dest3,
//                    txtS2Dest4,
//                    txtS3Dest1,
//                    txtS3Dest2,
//                    txtS3Dest3,
//                    txtS3Dest4,
//                    txtS1Flow1,
//                    txtS1Flow2,
//                    txtS1Flow3,
//                    txtS1Flow4,
//                    txtS2Flow1,
//                    txtS2Flow2,
//                    txtS2Flow3,
//                    txtS2Flow4,
//                    txtS3Flow1,
//                    txtS3Flow2,
//                    txtS3Flow3,
//                    txtS3Flow4);
//        }
//    }

    public static ObservableList<TextField> createAreaTextFields() {
        int amount = 9;
        ObservableList<TextField> textFields = FXCollections.observableArrayList();

        for (int i = 0; i < amount; i++) {
            textFields.add(new TextField());
        }
        return textFields;
    }
    public void buttonACAddGroupOfValues (ActionEvent event) {
        int amount = 9;
        ObservableList<TextField> textFields = createAreaTextFields();

        for (int i = 0; i < amount; i++) {
            assert false;
            areaGridPane.add(textFields.get(i),1,i + 3);
        }
    }

    public void buttonDrawAreaChart (ActionEvent event) {
        int amount = 9;
        ObservableList<TextField> textFields = FXCollections.observableArrayList();
        for (int i = 0; i < amount; i++) {
            textFields.add(new TextField());
        }
        AreaChart.drawAreaChart(textFields);

        //btnDrawAreaChart.disabledProperty().bind(txtFieldGroupValue1.textProperty().isEmpty());
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}