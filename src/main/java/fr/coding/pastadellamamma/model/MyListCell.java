package fr.coding.pastadellamamma.model;

import javafx.scene.control.ListCell;
import javafx.scene.control.Button;


public class MyListCell extends ListCell<Employes> {

    private Button deleteButton = new Button("delete");

    public MyListCell() {
        super();
        deleteButton.setOnAction(event -> {
            // Code à exécuter lorsque le bouton est cliqué
        });
    }

    @Override
    protected void updateItem(Employes item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty) {
            setText(null);
            setGraphic(null);
        } else {
            setGraphic(deleteButton);
            setText(item.toString());
        }
    }
}
