package com.tatneft.chartingApp;

import com.tatneft.chartingApp.Charts.*;
import com.tatneft.chartingApp.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;


public class Controller implements Initializable {

    @FXML
    private Button btnAddGroup;

    @FXML
    private Button btnAddGroup1;

    @FXML
    private ToggleButton btnAreaChart;

    @FXML
    private Button btnDrawChart;

    @FXML
    private Button btnDrawChart1;

    @FXML
    private Button btnDrawChart12;

    @FXML
    private ToggleGroup btnGroup;

    @FXML
    private ToggleButton btnPolarChart;

    @FXML
    private ToggleButton btnSankeyChart;

    @FXML
    private TableColumn<?, ?> clmnACGroupName;

    @FXML
    private TableColumn<?, ?> clmnACX;

    @FXML
    private TableColumn<?, ?> clmnACY;

    @FXML
    private TableColumn<?, ?> clmnPCGroupName;

    @FXML
    private TableColumn<?, ?> clmnPCX;

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
    private Tab tabPolarChart;

    @FXML
    private Tab tabSankeyChart;

    @FXML
    private Tab tabSelectChart;

    @FXML
    private TableView<AreaValues> tblViewArea;

    @FXML
    private TableView<PolarValues> tblViewPolar;

    @FXML
    private TextField tfACGName;

    @FXML
    private TextField tfACX;

    @FXML
    private TextField tfACY;

    @FXML
    private TextField tfPCGName;

    @FXML
    private TextField tfPCX;

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

    private final AreaDataModel areaDataModel = new AreaDataModel();
    private final PolarDataModel polarDataModel = new PolarDataModel();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblViewArea.setItems(areaDataModel.getAreaValues());
        clmnACGroupName.setCellValueFactory(new PropertyValueFactory<>("groupName"));
        clmnACX.setCellValueFactory(new PropertyValueFactory<>("x"));
        clmnACY.setCellValueFactory(new PropertyValueFactory<>("y"));

        tblViewPolar.setItems(polarDataModel.getPolarValues());
        clmnPCGroupName.setCellValueFactory(new PropertyValueFactory<>("segmentName"));
        clmnPCX.setCellValueFactory(new PropertyValueFactory<>("x"));
    }
    @FXML
    private void clickAddGroup(ActionEvent event) {
        if (tabAreaChart.isSelected()) {
            AreaValues v = new AreaValues(tfACGName.getText(), tfACX.getText(), tfACY.getText());
            areaDataModel.add(v);
        }
        if (tabPolarChart.isSelected()) {
            PolarValues v = new PolarValues(tfPCGName.getText(), tfPCX.getText());
            polarDataModel.add(v);
        }
    }

    @FXML
    private void clickDelete(ActionEvent event) {
        if (tabAreaChart.isSelected()) {
            AreaValues selectedValues = tblViewArea.getSelectionModel().getSelectedItem();
            areaDataModel.delete(selectedValues);
        }
        if (tabPolarChart.isSelected()) {
            PolarValues selectedValues = tblViewPolar.getSelectionModel().getSelectedItem();
            polarDataModel.delete(selectedValues);
        }
    }

    @FXML
    private void toggleButtonSelect (ActionEvent event) {
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
            mainTabPane.getTabs().add(tabSankeyChart);
            image = new ImageView("C:\\Users\\trust\\IdeaProjects\\chartingApp\\src\\main\\resources\\images\\image_sankey_chart.png");
            mainTabPane.getSelectionModel().select(tabSankeyChart);
        }
        assert image != null;
        //imgExample.setImage(image.getImage());
    }

    @FXML
    private void clickDrawAreaChart (ActionEvent event) {
        AreaChart.drawAreaChart(areaDataModel.getAreaValues());
    }

    @FXML
    private void clickDrawPolarChart (ActionEvent event) {
        PolarChart.drawPolarChart(polarDataModel.getPolarValues());
    }

    @FXML
    private void btnDrawFlowChart (ActionEvent event) {
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
}