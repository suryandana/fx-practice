/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicefx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Eugene
 */
public class WindowWithAction {
    static boolean result;
    
    public static boolean display() {
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Choice");
        window.setMinHeight(250);
        window.setMinWidth(300);
        
        Label label = new Label("Are you sure you want to close this application");
        Button button1 = new Button("Yes");
        button1.setOnAction(e -> {
            result = true;
            window.close();
        });
        
        Button button2 = new Button("No");
        button2.setOnAction(e -> {
            result = false;
            window.close();
        });
        
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label, button1, button2);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        
        return result;
    }
}
