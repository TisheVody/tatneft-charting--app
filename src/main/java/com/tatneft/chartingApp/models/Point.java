package com.tatneft.chartingApp.models;

import javafx.beans.property.SimpleStringProperty;

public class Point {

    private SimpleStringProperty x;
    private SimpleStringProperty y;

    public Point(SimpleStringProperty x, SimpleStringProperty y) {
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return x.get();
    }

    public SimpleStringProperty xProperty() {
        return x;
    }

    public void setX(String x) {
        this.x.set(x);
    }

    public String getY() {
        return y.get();
    }

    public SimpleStringProperty yProperty() {
        return y;
    }

    public void setY(String y) {
        this.y.set(y);
    }
}
