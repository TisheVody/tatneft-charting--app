package com.tatneft.chartingApp.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PolarDataModel {
    private final ObservableList<PolarValues> polarValues;
    public PolarDataModel() {
        this.polarValues = FXCollections.observableArrayList();
    }
    public ObservableList<PolarValues> getPolarValues() {
        return polarValues;
    }

    public void delete(PolarValues selectedPerson) {
        this.polarValues.remove(selectedPerson);
    }

    public void add(PolarValues v) {
        this.polarValues.add(v);
    }
}
