package com.tatneft.chartingApp.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AreaValues {
    private final StringProperty groupName = new SimpleStringProperty();
    private final StringProperty x = new SimpleStringProperty();
    private final StringProperty y = new SimpleStringProperty();

    public AreaValues() {
    }

    public AreaValues(String name) {
        setGroupName(name);
    }

    public AreaValues(String name, String x, String y) {
        setGroupName(name);
        setX(x);
        setY(y);
    }

    public String getGroupName() {
        return groupName.get();
    }

    public StringProperty groupNameProperty() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName.set(groupName);
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

    public String getY() {
        return y.get();
    }

    public StringProperty yProperty() {
        return y;
    }

    public void setY(String y) {
        this.y.set(y);
    }
}
