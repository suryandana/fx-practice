/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicefx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Eugene
 */
public class PracticeFX extends Application implements EventHandler<ActionEvent>{
    Button btn;
    Stage window;
    Scene scenePrimary;
    Scene sceneSecondary;
            
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("PracticeFX!");
        
        window = primaryStage;

        Label label = new Label("Welcome to PracticeFX New");
        
        btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(this);
        
        Button btnAnon = new Button();        
        btnAnon.setText("Say 'Hello World' from btnAnon");
        /* set btn event handler - anonymous inner class */        
        btnAnon.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World! from btnAnon");
            }
        });

        Button btnLambda = new Button();    
        btnLambda.setText("Say 'Hello World' from btnLambda");     
        /* set btn event handler - lambda expression */
        btnLambda.setOnAction(e -> System.out.println("Hello World! from btnLambda"));
        
        Button btnLambdaMultiline = new Button();    
        btnLambdaMultiline.setText("Say 'Hello World' from btnLambdaMultiline");     
        /* set btn event handler - lambda expression */
        btnLambdaMultiline.setOnAction(e -> {
                System.out.println("Hello World!");
                System.out.println("from btnLambdaMultiline");
        });
        
        Button btnChangeScene1 = new Button();
        btnChangeScene1.setText("Say 'Change Scene'");
        btnChangeScene1.setOnAction(e -> changeScene());
        
        Button btnChangeScene2 = new Button();
        btnChangeScene2.setText("Say 'Change Scene'");
        btnChangeScene2.setOnAction(e -> changeScene());
        
        
        Button btnNewWindow = new Button("Show New Window");
        btnNewWindow.setOnAction(e -> NewWindow.display("New Window", "This is the message"));
        
        
        Button btnWindowWithAction = new Button("Show Window With Action");
        btnWindowWithAction.setOnAction(e -> {
            if(WindowWithAction.display()){
                System.out.println("You pressed Yes");
                System.out.println("You don't close the app because this button doesn't execute closeConfirmation() like the proper buttons ");
            } else {
                System.out.println("You pressed No");
            }
        });
        
        Button btnClose = new Button("Close");
        btnClose.setOnAction(e -> closeConfirmation());
        
        Button btnBorderLayout = new Button("Show new window implementing Border Layout");
        btnBorderLayout.setOnAction(e -> {
            window.hide();
            if(TestBorderLayout.display()){
                window.show();
            }
        });
        
        Button btnGridLayout = new Button("Show new window implementing Grid Layout");
        btnGridLayout.setOnAction(e -> {
            window.hide();
            if(TestGridLayout.display()){
                window.show();
            }
        });

        
        // Layout 1
        VBox primaryLayout = new VBox();
        primaryLayout.setAlignment(Pos.CENTER);
        primaryLayout.setSpacing(5);
//        primaryLayout.getChildren().addAll(label, btnAnon, btnLambda, btnLambdaMultiline);
        primaryLayout.getChildren().addAll(label, btnLambdaMultiline, btnChangeScene1, btnAnon, btnNewWindow, btnWindowWithAction, btnClose, btnBorderLayout, btnGridLayout);
        scenePrimary = new Scene(primaryLayout, 400, 300);
        
        /* You can't add the same children on different layout */
        
        // Layout 2
        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().addAll(btnChangeScene2);
        sceneSecondary = new Scene(secondaryLayout, 500, 400);
        
        // Set Main Layout and Show
        window.setScene(scenePrimary);
        window.setOnCloseRequest(e -> {
            e.consume(); // remove the default close, this is necessary because in default, it will still close the program
            closeConfirmation();
        });
        window.show();
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == btn){
            System.out.println("Hello World! from btn");
        }
    }
    
    public void changeScene(){
        System.out.println("Change Scene");
        if(window.getScene() == scenePrimary){
            window.setScene(sceneSecondary);
        } else if(window.getScene() == sceneSecondary){
            window.setScene(scenePrimary);
        }
    }
    
    public void closeConfirmation(){
        if(WindowWithAction.display()){
            window.close();
        }
    }
    
}
