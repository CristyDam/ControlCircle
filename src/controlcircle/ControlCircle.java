/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlcircle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author crist
 */
public class ControlCircle extends Application {
    
    Circle circle = new Circle();
    
     @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("ControlCircle");
        
        // Creo circulo y propiedades
         
        circle.setCenterX(200);
        circle.setCenterY(200);
        circle.setRadius(100);
        circle.setStroke(Color.BLACK);
        circle.setFill(null);
        
        //Creo botones
        Button btn1 = new Button ("Enlarge");  
        Button btn2 = new Button ("Shrink");
        
        //Eventos
        btn1.setOnAction(new EnlargeHandler());
        btn2.setOnAction(new ShrinkHandler());
       
        //Creo una caja horizontal para meter los botones 
        HBox cajaBotones = new HBox(btn1,btn2);
        //Creo una caja vertical para meter el circulo y la caja horizontal
        VBox cajaPpal = new VBox(circle, cajaBotones);
       
        Scene scene = new Scene(cajaPpal, 250, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public class EnlargeHandler implements EventHandler<ActionEvent> 
    {

        @Override
        public void handle(ActionEvent event) 
        {
            circle.setRadius(circle.getRadius()+10);
        }
    }

    public class ShrinkHandler implements EventHandler<ActionEvent> 
    {
        
        @Override
        public void handle(ActionEvent event) 
        {
            circle.setRadius(circle.getRadius()-10);
        }
    }
    
    
}
