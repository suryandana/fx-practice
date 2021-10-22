/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicefx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Eugene
 */
public class TestTableView {
    
    public static boolean display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Table View");
        
        
//        TableView<Book, String, int, String, String, double>

        TableColumn<Book, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(250);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        

        TableColumn<Book, Integer> yearColumn = new TableColumn<>("Year");
        yearColumn.setMinWidth(50);
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn<Book, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setMinWidth(50);
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Book, String> publisherColumn = new TableColumn<>("Publisher");
        publisherColumn.setMinWidth(50);
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));

        TableColumn<Book, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(50);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        TableView<Book> tableView = new TableView<>();
        tableView.setItems(getBooks());
        tableView.getColumns().addAll(titleColumn, yearColumn, authorColumn, publisherColumn, priceColumn);
        
        
        
        TextField tfTitle = new TextField();
        tfTitle.setPromptText("Title");
        
        TextField tfYear = new TextField();
        tfYear.setPromptText("Year");
        
        TextField tfAuthor = new TextField();
        tfAuthor.setPromptText("Author");
        
        TextField tfPublisher = new TextField();
        tfPublisher.setPromptText("Publisher");
        
        TextField tfPrice = new TextField();
        tfPrice.setPromptText("Price");
        
        Button btnInsert = new Button("Insert");
        btnInsert.setOnAction(e -> {
            insertItem(tableView, tfTitle, tfYear, tfAuthor, tfPublisher, tfPrice);
        });
        
        Button btnUpdate = new Button("Update");
        
        Button btnDelete = new Button("Delete");
        btnDelete.setOnAction(e -> deleteItem(tableView));
        
        HBox hBoxTf = new HBox();
        hBoxTf.getChildren().setAll(tfTitle, tfYear, tfAuthor, tfPublisher, tfPrice);
        hBoxTf.setSpacing(5);
        hBoxTf.setPadding(new Insets(5));
        hBoxTf.setAlignment(Pos.BASELINE_LEFT);
        
        HBox hBoxBtn = new HBox();
        hBoxBtn.getChildren().setAll(btnInsert, btnUpdate, btnDelete);
        hBoxBtn.setSpacing(5);
        hBoxBtn.setPadding(new Insets(5));
        hBoxBtn.setAlignment(Pos.BASELINE_RIGHT);

        VBox vBox = new VBox();
        vBox.getChildren().setAll(tableView, hBoxTf, hBoxBtn);
                
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.showAndWait();
        return true;
    }
    
    public static ObservableList<Book> getBooks(){
        // usually you load db table here
        ObservableList<Book> books = FXCollections.observableArrayList();
        books.add(new Book("What Coronavirus Taught Us", 2021, "Andi", "A-Publisher", 32000));
        books.add(new Book("Silver Bird", 2021, "Jake", "B-Publisher", 18000));
        books.add(new Book("Imperium in 2021", 2021, "Morty", "A-Publisher", 34000));
        books.add(new Book("How To Create 3D Models For Dummies", 2020, "Litera", "B-Publisher", 56000));
        books.add(new Book("Sugar Fruit", 2020, "Calorie", "C-Publisher", 26000));
        books.add(new Book("A Bottle of Fairy", 2019, "Link", "A-Publisher", 72000));
        return books;
    }
    public static void insertItem(TableView tableView, TextField tfTitle, TextField tfYear, TextField tfAuthor, TextField tfPublisher, TextField tfPrice){
        Book book = new Book();
        book.setTitle(tfTitle.getText());
        book.setYear(Integer.parseInt(tfYear.getText()));
        book.setAuthor(tfAuthor.getText());
        book.setPublisher(tfPublisher.getText());
        book.setPrice(Double.parseDouble(tfPrice.getText()));
        tableView.getItems().add(book);
        tfTitle.clear();
        tfYear.clear();
        tfAuthor.clear();
        tfPublisher.clear();
        tfPrice.clear();
    }
    
    public static void deleteItem(TableView tableView){
        ObservableList<Book> initalItems, selectedItems;
        initalItems = tableView.getItems();
        
        selectedItems = tableView.getSelectionModel().getSelectedItems();
        // functional operation version and member reference
        selectedItems.forEach(initalItems::remove);
        
        /* // functional operation version
        selectedItems.forEach((selectedItem) -> {
            initalItems.remove(selectedItem);
        }); */
        
        /* // for version
        for (Book selectedItem : selectedItems) {
            initalItems.remove(selectedItem);
        } */
        
    }

    
}
