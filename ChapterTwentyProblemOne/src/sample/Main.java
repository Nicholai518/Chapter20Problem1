package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        // Create and instance of a Deque class
        Deque coolNamesDeque = new Deque();

        // Text
        Text topDescription = new Text("Cool Name Deque");
        topDescription.setFont(new Font("Verdana", 20));
        topDescription.setFill(Color.BLACK);

        // Labels & TextField controls
        Label dequeLabel = new Label();

        // VBox for top Description and Deque display
        VBox displayDataVBox = new VBox(10,topDescription, dequeLabel );
        displayDataVBox.setAlignment(Pos.CENTER);
        displayDataVBox.setPadding(new Insets(10));

        // Buttons
        // Add Front
        Button addFrontButton = new Button("addFront");
        TextField addFrontTextField = new TextField();
        addFrontButton.setOnAction(e->
        {
            String userString = addFrontTextField.getText();

            // Call addFront method
            coolNamesDeque.addFront(userString);

            // Update Label to show new results
            dequeLabel.setText(coolNamesDeque.toString());
        });

        HBox addFrontHBox = new HBox(10, addFrontButton, addFrontTextField);
        addFrontHBox.setAlignment(Pos.CENTER);
        addFrontHBox.setPadding(new Insets(10));

        // Remove Front
        Button removeFrontButton = new Button("removeFront");
        removeFrontButton.setOnAction(e->
        {
            // Call removeFront method
            coolNamesDeque.removeFront();

            // Update Label to show new results
            dequeLabel.setText(coolNamesDeque.toString());
        });


        VBox frontControlsVBox = new VBox(10,addFrontHBox, removeFrontButton );
        frontControlsVBox.setAlignment(Pos.CENTER);
        frontControlsVBox.setPadding(new Insets(10));

        // Add Rear
        Button addRearButton = new Button("addRear");
        TextField addRearTextField = new TextField();

        addRearButton.setOnAction(e->
        {
            String userString = addRearTextField.getText();

            // Call addFront method
            coolNamesDeque.addRear(userString);

            // Update Label to show new results
            dequeLabel.setText(coolNamesDeque.toString());
        });
        HBox addRearHBox = new HBox(10, addRearButton, addRearTextField);
        addRearHBox.setAlignment(Pos.CENTER);
        addRearHBox.setPadding(new Insets(10));


        // Remove Rear
        Button removeRearButton = new Button("removeRear");

        removeRearButton.setOnAction(e->
        {
            // Call removeRear method
            coolNamesDeque.removeRear();

            // Update Label to show new results
            dequeLabel.setText(coolNamesDeque.toString());
        });

        VBox rearControlsVBox = new VBox(10,addRearHBox, removeRearButton );
        rearControlsVBox.setAlignment(Pos.CENTER);
        rearControlsVBox.setPadding(new Insets(10));

        HBox allFrontRearControls = new HBox(10, frontControlsVBox, rearControlsVBox );
        allFrontRearControls.setAlignment(Pos.CENTER);
        allFrontRearControls.setPadding(new Insets(10));

        // Button  Event Handling
        Button searchButton = new Button("Search");
        searchButton.setOnAction(e->{


        });

        // Main container
        VBox mainContainer = new VBox(10, displayDataVBox, allFrontRearControls );
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setPadding(new Insets(10));

        // Scene
        Scene scene = new Scene(mainContainer, 600, 600);

        // Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Chapter 20 Problem 1");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
