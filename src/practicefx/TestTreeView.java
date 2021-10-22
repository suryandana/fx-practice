/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicefx;

import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Eugene
 */
public class TestTreeView {
    
    public static boolean display() {
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Tree View");
        
        TreeItem<String> parent, childOne, childTwo;
        
        parent = new TreeItem<>();
        parent.setExpanded(true);

        childOne = addBranch("childOne", parent);
        addBranch("childOne-1", childOne);
        TreeItem<String> childOneTwo = addBranch("childOne-2", childOne);
        addBranch("childOne-2.A", childOneTwo);
        addBranch("childOne-2.B", childOneTwo);
        addBranch("childOne-2.C", childOneTwo);
        addBranch("childOne-3", childOne);
        
        childTwo = addBranch("childTwo", parent);
        addBranch("childTwo-1", childTwo);
        addBranch("childTwo-2", childTwo);
        
        TreeView<String> tree = new TreeView<>(parent);
        tree.setShowRoot(false);
        tree.setEditable(true);
        tree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        StackPane layout = new StackPane();
        layout.getChildren().addAll(tree);
        
        Scene scene = new Scene(layout, 800, 600);
        window.setScene(scene);
        window.showAndWait();
        return true;
    }

    private static TreeItem<String> addBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
}
