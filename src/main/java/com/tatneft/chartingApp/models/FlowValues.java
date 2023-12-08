package com.tatneft.chartingApp.models;

import javafx.beans.property.*;

public class FlowValues {
    private final IntegerProperty stage = new SimpleIntegerProperty();
    private final StringProperty source = new SimpleStringProperty();
    private final StringProperty destination = new SimpleStringProperty();
    private final DoubleProperty flow = new SimpleDoubleProperty();

    public FlowValues(int stage, String source, String destination, double flow) {
        setStage(stage);
        setSource(source);
        setDestination(destination);
        setFlow(flow);
    }

    public int getStage() {
        return stage.get();
    }

    public IntegerProperty stageProperty() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage.set(stage);
    }

    public String getSource() {
        return source.get();
    }

    public StringProperty sourceProperty() {
        return source;
    }

    public void setSource(String source) {
        this.source.set(source);
    }

    public String getDestination() {
        return destination.get();
    }

    public StringProperty destinationProperty() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination.set(destination);
    }

    public double getFlow() {
        return flow.get();
    }

    public DoubleProperty flowProperty() {
        return flow;
    }

    public void setFlow(double flow) {
        this.flow.set(flow);
    }
}
