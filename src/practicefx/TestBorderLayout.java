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
}
