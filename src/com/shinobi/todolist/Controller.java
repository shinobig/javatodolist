package com.shinobi.todolist;

import com.shinobi.todolist.datamodel.ToDoItem;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<ToDoItem> toDoItems;

    @FXML
    private ListView<ToDoItem> toDoListView;

    @FXML
    private TextArea itemDetailsTextArea;

    // Initialize Controller
    public void initialize() {
        ToDoItem item1 = new ToDoItem("Mail Birthday Card", "Buy birthday card for Maria", LocalDate.of(2021,
                Month.APRIL, 25));
        ToDoItem item2 = new ToDoItem("Eat poop", "Eat lots of poop", LocalDate.of(2021,
                Month.APRIL, 25));
        ToDoItem item3 = new ToDoItem("Go to bathroom", "Never forget Bathroom", LocalDate.of(2021,
                Month.MAY, 25));
        ToDoItem item4 = new ToDoItem("Kill everyone", "Never forget, never forgive", LocalDate.of(2021,
                Month.JUNE, 25));

        toDoItems = new ArrayList<ToDoItem>();

        toDoItems.add(item1);
        toDoItems.add(item2);
        toDoItems.add(item3);
        toDoItems.add(item4);

        toDoListView.getItems().setAll(toDoItems);
        toDoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }

    @FXML
    public void handleClickListView() {
        ToDoItem item = toDoListView.getSelectionModel().getSelectedItem();

        StringBuilder sb = new StringBuilder(item.getDetails());
        sb.append("\n\n\n\n");
        sb.append("Due: ");
        sb.append(item.getDeadline());
        itemDetailsTextArea.setText(sb.toString());
    }

}
