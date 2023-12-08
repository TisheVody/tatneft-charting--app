package com.tatneft.chartingApp.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FlowDataModel {
    private final ObservableList<FlowValues> flowValues;

    public FlowDataModel() {
        this.flowValues = FXCollections.observableArrayList();
    }

    public ObservableList<FlowValues> getFlowValues() {
        return flowValues;
    }

    public void delete(FlowValues selectedValues) {
        this.flowValues.remove(selectedValues);
    }

    public void add(FlowValues v) {
        this.flowValues.add(v);
    }
}
