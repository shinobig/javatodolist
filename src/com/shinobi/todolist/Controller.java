package com.shinobi.todolist;

import com.shinobi.todolist.datamodel.ToDoData;
import com.shinobi.todolist.datamodel.ToDoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<ToDoItem> toDoItems;

    @FXML
    private ListView<ToDoItem> toDoListView;

    @FXML
    private TextArea itemDetailsTextArea;

    @FXML
    private Label deadlineLabel;

    // Initialize Controller
    public void initialize() {
//        ToDoItem item1 = new ToDoItem("Mail Birthday Card", "Buy birthday card for Maria", LocalDate.of(2021,
//                Month.APRIL, 25));
//        ToDoItem item2 = new ToDoItem("Eat poop", "Eat lots of poop", LocalDate.of(2021,
//                Month.APRIL, 25));
//        ToDoItem item3 = new ToDoItem("Go to bathroom", "Never forget Bathroom", LocalDate.of(2021,
//                Month.MAY, 25));
//        ToDoItem item4 = new ToDoItem("Kill everyone", "Never forget, never forgive", LocalDate.of(2021,
//               Month.JUNE, 25));
//
//      toDoItems = new ArrayList<ToDoItem>();
//
//        toDoItems.add(item1);
//        toDoItems.add(item2);
//        toDoItems.add(item3);
//        toDoItems.add(item4);
//
//
//         ToDoData.getInstance().setToDoItems(toDoItems);



        toDoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ToDoItem>() {
            @Override
            public void changed(ObservableValue<? extends ToDoItem> observable, ToDoItem oldValue, ToDoItem newValue) {
                if (newValue != null) {
                    ToDoItem item = toDoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    deadlineLabel.setText(df.format(item.getDeadline()));
                    // System.out.println(item.getDetails());
                }
            }
        });

        toDoListView.getItems().setAll(ToDoData.getInstance().getToDoItems());
        toDoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        toDoListView.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleClickListView() {
        ToDoItem item = toDoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());
        /*
        StringBuilder sb = new StringBuilder(item.getDetails());
        sb.append("\n\n\n\n");
        sb.append("Due: ");
        sb.append(item.getDeadline());
         */
    }

}
