package com.tatneft.chartingApp.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PolarValues {
    private final StringProperty segmentName = new SimpleStringProperty();
    private final StringProperty x = new SimpleStringProperty();
    public PolarValues() {
    }

    public PolarValues(String name) {
        setSegmentName(name);
    }

    public PolarValues(String name, String x) {
        setSegmentName(name);
        setX(x);
    }

    public String getSegmentName() {
        return segmentName.get();
    }

    public StringProperty segmentNameProperty() {
        return segmentName;
    }

    public void setSegmentName(String segmentName) {
        this.segmentName.set(segmentName);
    }

    public String getX() {
        return x.get();
    }

    public StringProperty xProperty() {
        return x;
    }

    public void setX(String x) {
        this.x.set(x);
    }
}
