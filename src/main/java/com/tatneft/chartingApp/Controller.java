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
    private Button btnAddGroup11;

    @FXML
    private ToggleButton btnAreaChart;

    @FXML
    private Button btnDrawChart;

    @FXML
    private Button btnDrawChart1;

    @FXML
    private Button btnDrawChart11;

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
    private TableColumn<?, ?> clmnFCDestination;

    @FXML
    private TableColumn<?, ?> clmnFCFlow;

    @FXML
    private TableColumn<?, ?> clmnFCSource;

    @FXML
    private TableColumn<?, ?> clmnFCStage;

    @FXML
    private TableColumn<?, ?> clmnPCGroupName;

    @FXML
    private TableColumn<?, ?> clmnPCX;

    @FXML
    private ImageView imgExample;

    @FXML
    private ImageView imgExample11;

    @FXML
    private ImageView imgExample111;

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
    private TableView<AreaValues> tblViewArea;

    @FXML
    private TableView<PolarValues> tblViewPolar;

    @FXML
    private TableView<FlowValues> tblViewFlow;

    @FXML
    private TextField tfACGName;

    @FXML
    private TextField tfACX;

    @FXML
    private TextField tfACY;

    @FXML
    private TextField tfFCDestination;

    @FXML
    private TextField tfFCFlow;

    @FXML
    private TextField tfFCSource;

    @FXML
    private TextField tfFCStage;

    @FXML
    private TextField tfPCGName;

    @FXML
    private TextField tfPCX;

    private final AreaDataModel areaDataModel = new AreaDataModel();
    private final PolarDataModel polarDataModel = new PolarDataModel();
    private final FlowDataModel flowDataModel = new FlowDataModel();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblViewArea.setItems(areaDataModel.getAreaValues());
        clmnACGroupName.setCellValueFactory(new PropertyValueFactory<>("groupName"));
        clmnACX.setCellValueFactory(new PropertyValueFactory<>("x"));
        clmnACY.setCellValueFactory(new PropertyValueFactory<>("y"));

        tblViewPolar.setItems(polarDataModel.getPolarValues());
        clmnPCGroupName.setCellValueFactory(new PropertyValueFactory<>("segmentName"));
        clmnPCX.setCellValueFactory(new PropertyValueFactory<>("x"));

        tblViewFlow.setItems(flowDataModel.getFlowValues());
        clmnFCStage.setCellValueFactory(new PropertyValueFactory<>("stage"));
        clmnFCSource.setCellValueFactory(new PropertyValueFactory<>("source"));
        clmnFCDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        clmnFCFlow.setCellValueFactory(new PropertyValueFactory<>("flow"));
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
        if (tabFlowChart.isSelected()) {
            FlowValues v = new FlowValues(Integer.parseInt(tfFCStage.getText()),
                    tfFCSource.getText(), tfFCDestination.getText(), Double.parseDouble(tfFCFlow.getText()));
            flowDataModel.add(v);
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
        if (tabFlowChart.isSelected()) {
            FlowValues selectedValues = tblViewFlow.getSelectionModel().getSelectedItem();
            flowDataModel.delete(selectedValues);
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
            mainTabPane.getTabs().add(tabFlowChart);
            image = new ImageView("C:\\Users\\trust\\IdeaProjects\\chartingApp\\src\\main\\resources\\images\\image_sankey_chart.png");
            mainTabPane.getSelectionModel().select(tabFlowChart);
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
    private void clickDrawFlowChart (ActionEvent event) {
        FlowChart.drawFlowChart(flowDataModel.getFlowValues());
    }
}