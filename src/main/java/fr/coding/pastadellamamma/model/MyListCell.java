package fr.coding.pastadellamamma.model;

import javafx.scene.control.ListCell;
import javafx.scene.control.Button;

import java.util.List;
import java.util.Arrays;



public class MyListCell extends ListCell<Employes> {

    public MyListCell(List listEmploye) {
        super();

        System.out.println(listEmploye.get(0));
        Object[] array = listEmploye.toArray(Object[]::new);
        removeElement(array, 0);
        listEmploye = Arrays.stream(array).toList();
        System.out.println(listEmploye + " uuuuuuuuuuuuuuuuuu");
    }

    public static Object[] removeElement(Object[] arr, int index) {
        Object[] result = new Object[arr.length - 1];
        System.arraycopy(arr, 0, result, 0, index);
        if (arr.length != index) {
            System.arraycopy(arr, index + 1, result, index, arr.length - index - 1);
        }
        return result;
    }

    @Override
    protected void updateItem(Employes item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty) {
            setText(null);
            setGraphic(null);
        } else {
            setText(item.toString());
        }
    }
}
