/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicefx;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Eugene
 */
public class TestBorderLayout {
    
    public static boolean display() {
        Stage window = new Stage();
                        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("NewBorderLayout");
        window.setMinWidth(800);
        window.setMinHeight(600);
        
        Button buttonTop1 = new Button("Top 1");
        Button buttonTop2 = new Button("Top 2");
        Button buttonTop3 = new Button("Top 3");
        Button buttonLeft1 = new Button("Left 1");
        Button buttonLeft2  = new Button("Left 1");
        Button buttonLeft3 = new Button("Left 1");
        Button buttonRight1 = new Button("Right 1");
        Button buttonRight2 = new Button("Right 2");
        Button buttonRight3 = new Button("Right 3");
        Button buttonCenter1 = new Button("Center 1");
        Button buttonCenter2 = new Button("Center 2");
        Button buttonCenter3 = new Button("Center 3");
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add(0, "Option 1");
        choiceBox.getItems().add("Option 2");
        choiceBox.getItems().add("Option 3");
        choiceBox.setValue("Option 1");
        choiceBox.setOnAction(e -> chosenBox(choiceBox));
        
        ChoiceBox<String> choiceBoxListener = new ChoiceBox<>();
        choiceBoxListener.getItems().addAll("Option 1 choiceBoxListener", "Option 2 choiceBoxListener", "Option 3 choiceBoxListener");
        choiceBoxListener.setValue("Option 3 choiceBoxListener");
        choiceBoxListener.getSelectionModel().selectedItemProperty().addListener(
                (v, oldValue, newValue) -> {System.out.println("Changing " + oldValue + " to " + newValue);}
        );
        
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Option 1", "Option 2", "Option 3");
        comboBox.setPromptText("Select your option");
        comboBox.getSelectionModel().selectedItemProperty().addListener(
                (v, oldValue, newValue) -> {System.out.println("Changing " + oldValue + " to " + newValue);}
        );
        
        ComboBox<String> comboBoxEditable = new ComboBox<>();
        comboBoxEditable.getItems().addAll("Option 1 comboBoxEditable", "Option 2 comboBoxEditable", "Option 3 comboBoxEditable");
        comboBoxEditable.setEditable(true);

        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("Option 1", "Option 2", "Option 3",  "Option 4",  "Option 5",  "Option 6");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        Button buttonListView = new Button("Bottom List View");
        buttonListView.setOnAction(e -> chosenListView(listView));
        
        Button buttonBottom1 = new Button("Bottom 1");
        Button buttonBottom2 = new Button("Bottom 2");
        Button buttonBottom3 = new Button("Bottom 3");
        
        HBox layoutTop = new HBox();
        VBox layoutLeft = new VBox();
        VBox layoutCenter = new VBox();
        VBox layoutRight = new VBox();
        HBox layoutBottom = new HBox();
        
        layoutTop.getChildren().addAll(buttonTop1, buttonTop2, buttonTop3);
        layoutLeft.getChildren().addAll(buttonLeft1, buttonLeft2, buttonLeft3);
        layoutCenter.getChildren().addAll(buttonCenter1, buttonCenter2, buttonCenter3, choiceBox, choiceBoxListener, comboBox, listView, buttonListView);
        layoutRight.getChildren().addAll(buttonRight1, buttonRight2, buttonRight3);
        layoutBottom.getChildren().addAll(buttonBottom1, buttonBottom2, buttonBottom3);
        
        layoutTop.setAlignment(Pos.BASELINE_LEFT);
        layoutLeft.setAlignment(Pos.TOP_LEFT);
        layoutCenter.setAlignment(Pos.CENTER);
        layoutRight.setAlignment(Pos.BOTTOM_RIGHT);
        layoutBottom.setAlignment(Pos.BASELINE_RIGHT);
        
        layoutTop.setStyle("-fx-background-color: #775533;");
        layoutLeft.setStyle("-fx-background-color: #553377;");
        layoutCenter.setStyle("-fx-background-color: #773355;");
        layoutRight.setStyle("-fx-background-color: #557733;");
        layoutBottom.setStyle("-fx-background-color: #337755;");
        
        layoutTop.setSpacing(5);
        layoutLeft.setSpacing(5);
        layoutCenter.setSpacing(5);
        layoutRight.setSpacing(5);
        layoutBottom.setSpacing(5);
        
        layoutTop.setPadding(new Insets(10, 10, 10, 10));
        layoutLeft.setPadding(new Insets(10, 10, 10, 10));
        layoutCenter.setPadding(new Insets(10, 10, 10, 10));
        layoutRight.setPadding(new Insets(10, 10, 10, 10));
        layoutBottom.setPadding(new Insets(10, 10, 10, 10));
        
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(layoutTop);
        borderPane.setLeft(layoutLeft);
        borderPane.setCenter(layoutCenter);
        borderPane.setRight(layoutRight);
        borderPane.setBottom(layoutBottom);
        
//        BorderPane.setMargin(layoutTop, new Insets(10, 10, 10, 10));
//        BorderPane.setMargin(layoutLeft, new Insets(10, 10, 10, 10));
//        BorderPane.setMargin(layoutCenter, new Insets(10, 10, 10, 10));
//        BorderPane.setMargin(layoutRight, new Insets(10, 10, 10, 10));
//        BorderPane.setMargin(layoutBottom, new Insets(10, 10, 10, 10));
        
        Scene scene = new Scene(borderPane);
        window.setScene(scene);
        window.showAndWait();
        
        return true;
    }
    
    private static void chosenBox(ChoiceBox choiceBox){
        System.out.println(choiceBox.getValue());
    }
    
    private static void chosenListView(ListView listView){
        ObservableList observableList = listView.getSelectionModel().getSelectedItems();
        for (Object object : observableList) {
            System.out.println(object);
        }
    }
}
