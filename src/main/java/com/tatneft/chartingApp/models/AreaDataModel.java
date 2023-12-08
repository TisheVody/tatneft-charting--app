package com.tatneft.chartingApp.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AreaDataModel {
    private final ObservableList<AreaValues> areaValues;
    public AreaDataModel() {
        this.areaValues = FXCollections.observableArrayList();
    }
    public ObservableList<AreaValues> getAreaValues() {
        return areaValues;
    }

    public void delete(AreaValues selectedPerson) {
        this.areaValues.remove(selectedPerson);
    }

    public void add(AreaValues v) {
        this.areaValues.add(v);
    }
}
