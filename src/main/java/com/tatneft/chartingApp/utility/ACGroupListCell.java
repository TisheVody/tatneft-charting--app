package com.tatneft.chartingApp.utility;

import com.tatneft.chartingApp.models.ACGroupModel;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

public class ACGroupListCell extends ListCell<ACGroupModel> {
    private final TextField groupName = new TextField();
//    private final TextField valueX = new TextField();
//    private final TextField valueY = new TextField();
    private final Button btnAddTextField = new Button();
    private final ListView<Pair<TextField, TextField>> pairListView = new ListView<>();

    private VBox createVBoxList(){
        VBox vBox = new VBox();
        for (Pair<TextField, TextField> pair : pairListView.getItems()) {
            vBox.getChildren().addAll(pair.getKey(), pair.getValue());
        }
        return vBox;
    }

    private VBox createLayout(){
        VBox vBox = createVBoxList();
        return new VBox(groupName,
//                valueX, valueY,
                vBox, btnAddTextField);
    }

    //VBox layout = createLayout();

    public ACGroupListCell() {
        super();
    }

//    VBox vBoxForValues = new VBox(valueX, valueY);
    HBox layout = new HBox(groupName,
//        vBoxForValues,
        btnAddTextField);
    @Override
    protected void updateItem(ACGroupModel item, boolean empty) {
        super.updateItem(item, empty);

        setText(null);

        if (empty || item == null) {
            groupName.setText(null);

            btnAddTextField.setText(null);
            setGraphic(null);
        } else {
            groupName.setText(String.valueOf(item.getGroupName()));

            btnAddTextField.setText("+");

            groupName.textProperty().addListener((observable, oldValue, newValue) ->
                    item.groupNameProperty().set(newValue));

            btnAddTextField.setOnAction(event -> {
                pairListView.getItems().add(new Pair<>(new TextField("Value X"), new TextField("Value Y")));
                layout.getChildren().add(layout.getChildren().size() - 1, createVBoxList());
            });

            int finalI = 0;
            for (Pair<TextField, TextField> pair : pairListView.getItems()) {
                int finalI1 = finalI;
                pair.getKey().textProperty().addListener((observable, oldValue, newValue) ->
                        item.listOfPointsProperty().get(finalI1).setX(newValue));
                pair.getValue().textProperty().addListener((observable, oldValue, newValue) ->
                        item.listOfPointsProperty().get(finalI1).setY(newValue));
                finalI ++;
            }
            layout.setSpacing(10);
            setGraphic(layout);
        }
    }
}
