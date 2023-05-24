
/*
Student Name: Chang Liu
Student Number: 040919803
Course & Section #: 22S_CST8288_020
Declaration:
This is the Lab 3 of CST8288. It is a practice of JavaFX with GUI.
*/
package view;

import model.ShannonsTheorem;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;



/**
 * The ShannonPresenter class binds the textfield values of Bandwidth and Signal to Noise Ratio
 * to the corresponding fields of the ShannonsTheorem model, and sets up an action for the calculate button 
 * that updates the view with the maximum data rate calculated by the model,
 * It also shows an error message in a dialog if the input values for Bandwidth and Signal to Noise Ratio are not numbers.
 *
 * @author Cloris
 * @see ShannonPresenter
 * @version 1.0
 * @since 1.0
 */
public class ShannonPresenter {
    private final  ShannonsTheorem model;
    private final ShannonView view;

    /**
     * Constructs a new ShannonPresenter object with the given ShannonsTheorem model and ShannonView view,
     * Initializes the view with the appropriate bindings and actions.
     * @param model the ShannonsTheorem model to use
     * @param view the ShannonView view to use
     */
    public ShannonPresenter(ShannonsTheorem model, ShannonView view){
        this.model = model;
        this.view = view;
        myView();
    }
    
    /**
     * Binds the textfield values of Bandwidth and Signal to Noise Ratio to the corresponding fields of the ShannonsTheorem model,
     * Sets up an action for the calculate button that updates the view with the maximum data rate calculated by the model,
     * Shows an error message in a dialog if the input values for Bandwidth and Signal to Noise Ratio are not numbers.     * 
     */
   private void myView() {
	// bind textfield values of Bandwidth to model
	view.bWidthField.textProperty().addListener(new ChangeListener<String>() {
            
	    @Override
	    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //check if the input of 'Bandwidth' is not a number, shows an error message in a dailog
	        if (!newValue.matches("\\d*")) {
                    
                    //an Error Message Alert tells user whose input is not valid
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Input Error");
                    alert.setHeaderText("Input number only");
                    alert.setContentText( newValue + " is invalid");
                    
                    //to clear input field when alert is closed. 
                    alert.setOnHidden(event -> {
                        view.bWidthField.setText("");
                    });

                    alert.showAndWait();       
                    
	        }
	        if (newValue.equals("")) {
            //if no input, set 0 as the default number to this field for calculating resulte. The default 0 won't show in the field
	        	model.setBandWidth(0.0);
	        } else {
	        	model.setBandWidth(Double.parseDouble(newValue));
	        }
	    }
	});
	
        // bind textfield values of Signal to Noise Ratio to model
	view.nRatioField.textProperty().addListener(new ChangeListener<String>() {
	    @Override
	    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //check if the input 'Signal to Noise Ratio' is not a number, shows an error message in a dailog
	    	if (!newValue.matches("\\d*")) {
                    
                    //an Error Message Alert tells user whose input is not valid 
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Input Error");
                    alert.setHeaderText("Input number only");
                    alert.setContentText( newValue + " is invalid");
                    
                    //to clear input field when alert is closed
                    alert.setOnHidden(event -> {
                        view.nRatioField.setText("");
                    });

                    alert.showAndWait();
                    
	        }
	    	if (newValue.equals("")) {
                    
    //if no input, set 0 as the default number to this field for calculating resulte. The default 0 won't show in the field
	        	model.setSignalToNoiseRatio(0.0);
	        } else {
	        	model.setSignalToNoiseRatio(Double.parseDouble(newValue));
	        }
	    }
	});
	
	// set action for calculate button
	view.calcBtn.setOnAction((ActionEvent event) -> {
            view.maxDataRateField.setText(Double.toString(model.maxDataRate()));
        });
        

    }
    
   
}
