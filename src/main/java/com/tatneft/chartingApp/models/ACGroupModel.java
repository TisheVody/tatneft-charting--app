package com.tatneft.chartingApp.models;

import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import java.util.List;

public class ACGroupModel {
    private final SimpleStringProperty groupName = new SimpleStringProperty();
//    private final SimpleStringProperty valueX = new SimpleStringProperty();
//    private final SimpleStringProperty valueY = new SimpleStringProperty();
//
    private final SimpleListProperty<Point> listOfPoints = new SimpleListProperty<>();
//    private final SimpleListProperty<SimpleStringProperty> valuesList = new SimpleListProperty<>();

    public ACGroupModel(String groupName,
                        // String valueX, String valueY,
                        ObservableList<Point> listOfPoints) {
        this.groupName.setValue(groupName);
        this.listOfPoints.setValue(listOfPoints);
//        this.valueX.setValue(valueX);
//        this.valueY.setValue(valueY);
//        this.valuesList.setValue()
    }

    public String getGroupName() {
        return groupName.get();
    }
    public SimpleStringProperty groupNameProperty() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName.set(groupName);
    }

    public ObservableList<Point> getListOfPoints() {
        return listOfPoints.get();
    }

    public SimpleListProperty<Point> listOfPointsProperty() {
        return listOfPoints;
    }

    public void setListOfPoints(ObservableList<Point> listOfPoints) {
        this.listOfPoints.set(listOfPoints);
    }

//    public String getValueX() {
//        return valueX.get();
//    }
//    public SimpleStringProperty valueXProperty() {
//        return valueX;
//    }
//    public void setValueX(String valueX) {
//        this.valueX.set(valueX);
//    }
//    public String getValueY() {
//        return valueY.get();
//    }
//    public SimpleStringProperty valueYProperty() {
//        return valueY;
//    }
//    public void setValueY(String valueY) {
//        this.valueY.set(valueY);
//    }
//    public String getValuesList() {
//        return valuesList.get().toString();
//    }
//    public SimpleListProperty<SimpleStringProperty> valuesListProperty() {
//        return valuesList;
//    }
//    public void setValuesList(ObservableList<SimpleStringProperty> valuesList) {
//        this.valuesList.set(valuesList);
//    }
}
