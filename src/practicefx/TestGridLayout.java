/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicefx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Eugene
 */
public class TestGridLayout {
    
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
        layoutCenter.getChildren().addAll(buttonCenter1, buttonCenter2, buttonCenter3);
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
//        borderPane.setCenter(layoutCenter);
        borderPane.setRight(layoutRight);
        borderPane.setBottom(layoutBottom);
        
        
        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(2);
        gridPane.setHgap(3);
        
        Label lbUsername = new Label("Username");
        GridPane.setConstraints(lbUsername, 0, 0);

        TextField tfUsername = new TextField("User 01");
        GridPane.setConstraints(tfUsername, 1, 0);
        tfUsername.setPromptText("User 01");
        
        Label lbPassword = new Label("Password");
        GridPane.setConstraints(lbPassword, 0, 1);

        TextField tfPassword = new TextField("");
        GridPane.setConstraints(tfPassword, 1, 1);
        tfPassword.setPromptText("Password");
        
        CheckBox ckRememberme = new CheckBox("Remember me");
        GridPane.setConstraints(ckRememberme, 1, 2);
        
        Button btnLogin = new Button("Login");
        GridPane.setConstraints(btnLogin, 1, 3);
        btnLogin.setOnAction(e -> {
            login(
                tfUsername.getText(),
                tfPassword.getText(),
                ckRememberme.isSelected()
            );
        });
        
        
        
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("Option 1", "Option 2", "Option 3",  "Option 4",  "Option 5",  "Option 6");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        ScrollPane scrollPane = new ScrollPane();
//        scrollPane.getChildrenUnmodifiable().setAll(listView);
        
        GridPane.setConstraints(scrollPane, 0, 4, 2, 1);
        scrollPane.setContent(listView);
        scrollPane.setPannable(true); // it means that the user should be able to pan the viewport by using the mouse.
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
//        scrollPane.setFitToHeight(true);
//        scrollPane.setFitToWidth(true);
        scrollPane.setPrefViewportHeight(100);
        
        
        gridPane.getChildren().addAll(lbUsername, tfUsername, lbPassword, tfPassword, ckRememberme, btnLogin, scrollPane);
        gridPane.setAlignment(Pos.CENTER);
        
        borderPane.setCenter(gridPane);
        
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
    
    private static void login(String username, String password, boolean rememberme){
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Remember me: " + rememberme);
    }
}
