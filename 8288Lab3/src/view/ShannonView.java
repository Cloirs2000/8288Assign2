
/*
Student Name: Chang Liu
Student Number: 040919803
Course & Section #: 22S_CST8288_020
Declaration:
This is the Lab 3 of CST8288. It is a practice of JavaFX with GUI.
*/
package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * The ShannonView class provides the user interface for the ShannonsTheorem application,
 * It contains labels, text fields, and a button to allow the user to input bandwidth and signal-to-noise ratio values,
 * and to calculate the maximum data rate.
 *
 * @author Cloris
 * @see ShannonView
 * @version 1.0
 * @since 1.0
 */
public class ShannonView extends GridPane {
    Label bWidthLable = new Label ("Bandwidth:");
    Label nRatioLable = new Label ("Signal to Noise Ratio:");
    Label maxDataRateLabel = new Label ("Max Data Rate:");
    
    
    TextField bWidthField = new TextField();
    TextField nRatioField = new TextField();
    TextField maxDataRateField = new TextField();
    
    
    // Buttons
    Button calcBtn = new Button("Calculate");
    
    /**
     * Constructs the user interface for the ShannonsTheorem application,
     * Calls the layoutForm method to create the UI.
     */
    public ShannonView(){
        layoutForm();
    }
    
    /**
     * Creates and sets the layout for the UI using a GridPane.
     */
    private void layoutForm() {
		this.setHgap(5);
		this.setVgap(5);

		this.add(bWidthLable, 1, 2);
		this.add(nRatioLable, 1, 3);
                this.add(maxDataRateLabel,1,4);

		this.add(bWidthField, 2, 2);
		this.add(nRatioField, 2, 3);
                this.add(maxDataRateField,2,4);
                maxDataRateField.setEditable(false);

		// Add buttons and make them the same width
		VBox buttonBox = new VBox(calcBtn);
		calcBtn.setMaxWidth(Double.MAX_VALUE);

		this.add(buttonBox, 3, 3);
	}
    
}
