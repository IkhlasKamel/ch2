/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeworke1.q1;

import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author ikhlas
 */
public class homeworke1q1 extends Application {
    
 private ListView<String> listViewf;
  private ListView<String> listViewcop;
   
    private Button copy;
    @Override
    public void start(Stage primaryStage) throws Exception {
        listViewf = new ListView<>();
        listViewf.getItems().addAll("Black","Red","Cyen","Dark Gray"," Gray","Orange","Blue");
        listViewcop = new ListView<>();
        copy=new Button("Copy >>>");
        listViewf.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
         BorderPane por=new BorderPane();
       por.setLeft(listViewf);
       por.setRight(listViewcop);
       por.setCenter(copy);
        EventHandler2 eventHandler2 = new EventHandler2();
      
        copy.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
      
 
        Scene scene = new Scene(por,560,300);
        primaryStage.setTitle("Multiple selection Lists");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
     private class EventHandler2 implements EventHandler<Event>{

        @Override
        public void handle(Event event) {
           
            if(event.getSource() == copy)
                if(listViewf.getSelectionModel().getSelectedItems().isEmpty()){
                    Alert alert =new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("Yor no Selected any Item");
                    alert.show();
                }else{
               listViewcop.getItems().clear();
              listViewcop.getItems().addAll(listViewf.getSelectionModel().getSelectedItems());  
             listViewf.getSelectionModel().clearSelection();

                }
        }
        
    }
}
