
/*
Student Name: Chang Liu
Student Number: 040919803
Course & Section #: 22S_CST8288_020
Declaration:
This is the Lab 3 of CST8288. It is a practice of JavaFX with GUI.
*/
package launch;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;
import model.ShannonsTheorem;
import view.ShannonPresenter;
import view.ShannonView;

/**
 * The ShannonLaunch class contains a Main method 
 * that is responsible for launching the ShannonsTheorem application.
 *
 * @author Cloris
 * @see ShannonLaunch
 * @version 1.0
 * @since 1.0
 */
public class ShannonLaunch extends Application {
    /**
     * This method sets up the primary stage of the Shannons Theorem application,
     * The stage is set with the view, size, and title, and shown to the user.
     * 
     * @param primaryStage   the primary stage of the application
     * @throws Exception   if an error occurs while launching the application
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

            // Create the view
            ShannonView view = new ShannonView();

            // Create the model
            ShannonsTheorem model = new ShannonsTheorem();

            // Create the presenter and link to view and model
            ShannonPresenter presenter = new ShannonPresenter(model, view);

            // Set the stage with scene and title
            primaryStage.setScene(new Scene(view, 500, 150));
            primaryStage.setTitle("Shannons Theorem");
            primaryStage.show();
    }

    public static void main(String[] args) {
            launch(args);
    }
    
}
