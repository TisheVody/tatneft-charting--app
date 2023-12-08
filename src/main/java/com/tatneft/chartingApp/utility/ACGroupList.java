package com.tatneft.chartingApp.utility;

import com.tatneft.chartingApp.models.ACGroupModel;
import com.tatneft.chartingApp.models.Point;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class ACGroupList extends VBox {
    private final ListView<ACGroupModel> listViewOfGroups;
    private final Button addGroupButton = new Button("Add group");
    private final Button deleteGroupButton = new Button("Delete");
    private final VBox vbox;

    public ACGroupList(ObservableList<ACGroupModel> groupListModel) {
        ObservableList<Point> valuesList = FXCollections.observableArrayList();
        this.listViewOfGroups = new ListView<>(groupListModel);
        listViewOfGroups.setCellFactory(param -> new ACGroupListCell());
        listViewOfGroups.setMinWidth(1000);
        this.addGroupButton.setOnAction(event -> this.listViewOfGroups.getItems()
                .add(new ACGroupModel("new group",
                        //"0", "0",
                        valuesList)));
        this.deleteGroupButton.setOnAction(event -> this.listViewOfGroups.getItems()
                .remove(listViewOfGroups.getItems().size() - 1));
        this.vbox = new VBox(listViewOfGroups, addGroupButton, deleteGroupButton);
        vbox.setSpacing(10);
        getChildren().add(vbox);
    }
}
