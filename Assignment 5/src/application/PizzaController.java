//PizzaController class provides functionality to the GUI created with the help of scene builder
package application;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextArea;

public class PizzaController {

	private Pizza pizza;
	private LineItem item;
	private int quantity = 1;
	private ArrayList<LineItem> orders = new ArrayList<>();
	// initialize all the components used in the GUI to give them functionality 
	@FXML
	private ToggleGroup group1 = new ToggleGroup();
	@FXML
	private ToggleGroup group2 = new ToggleGroup();
	@FXML
	private ToggleGroup group4 = new ToggleGroup();
	@FXML
	private ToggleGroup group3 = new ToggleGroup();
	@FXML
	private ToggleGroup group5 = new ToggleGroup();
	@FXML
	private RadioButton smallSize = new RadioButton("Small");
	@FXML
	private RadioButton mediumSize = new RadioButton("Medium");
	@FXML
	private RadioButton largeSize = new RadioButton("Large");
	@FXML
	private RadioButton nonePepper = new RadioButton("None");
	@FXML
	private RadioButton singlePepper = new RadioButton("Single");
	@FXML
	private RadioButton singleHam = new RadioButton("Single");
	@FXML
	private RadioButton noneHam = new RadioButton("None");
	@FXML
	private RadioButton singleCheese = new RadioButton("Single");
	@FXML
	private RadioButton doubleCheese = new RadioButton("Double");
	@FXML
	private RadioButton tripleCheese = new RadioButton("Triple");
	@FXML
	private RadioButton nonePineapple = new RadioButton("None");
	@FXML
	private RadioButton singlePineapple = new RadioButton("Single");
	@FXML
	private TextField quantitytxt;
	@FXML
	private TextField totalCosttxt;	
	@FXML
	private TextField costPerItemtxt;
	@FXML
	private Button addOrderbtn;
	@FXML
	private TextArea orderTextArea;


	// cost methods calculates the cost per pizza and the total cost
	//of the pizza being ordered 
	private void cost() {
		// the choices made are stored in the respective variables 
		String size = ((RadioButton) group1.getSelectedToggle()).getText();
    	String cheese = ((RadioButton) group2.getSelectedToggle()).getText();
    	String ham = ((RadioButton) group3.getSelectedToggle()).getText();
    	String greenPeppers = ((RadioButton) group4.getSelectedToggle()).getText();
    	String pineapple = ((RadioButton) group5.getSelectedToggle()).getText();
    	
     // new Pizza and LineItem object made, kept in a try catch block to catch the exceptions
		try {
			
			pizza = new Pizza(size, cheese, pineapple, greenPeppers, ham);

		} catch (IllegalPizza ip) {
			System.err.println("Illegal Pizza");
			return;
		}
		// cost per pizza is printed out in 2 decimal places
		costPerItemtxt.setText(String.format("$%.2f", pizza.getCost()));
		try { 
			item = new LineItem(quantity, pizza);
		} catch (IllegalPizza ip) {
			System.err.println("Illegal Line Item");
			return;
		}
		// total cost of order printed out in 2 decimal places
		totalCosttxt.setText(String.format("$%.2f", item.getCost()));

	}

	@FXML
	void initialize() {
		
		assert mediumSize != null : "fx:id=\"mediumSize\" was not injected: check your FXML file 'menu .fxml'.";
        assert nonePepper != null : "fx:id=\"nonePepper\" was not injected: check your FXML file 'menu .fxml'.";
        assert singleHam != null : "fx:id=\"singleHam\" was not injected: check your FXML file 'menu .fxml'.";
        assert singlePepper != null : "fx:id=\"singlePepper\" was not injected: check your FXML file 'menu .fxml'.";
        assert noneHam != null : "fx:id=\"noneHam\" was not injected: check your FXML file 'menu .fxml'.";
        assert group4 != null : "fx:id=\"group4\" was not injected: check your FXML file 'menu .fxml'.";
        assert group3 != null : "fx:id=\"group3\" was not injected: check your FXML file 'menu .fxml'.";
        assert doubleCheese != null : "fx:id=\"doubleCheese\" was not injected: check your FXML file 'menu .fxml'.";
        assert group5 != null : "fx:id=\"group5\" was not injected: check your FXML file 'menu .fxml'.";
        assert quantitytxt != null : "fx:id=\"quantitytxt\" was not injected: check your FXML file 'menu .fxml'.";
        assert largeSize != null : "fx:id=\"largeSize\" was not injected: check your FXML file 'menu .fxml'.";
        assert totalCosttxt != null : "fx:id=\"totalCosttxt\" was not injected: check your FXML file 'menu .fxml'.";
        assert tripleCheese != null : "fx:id=\"tripleCheese\" was not injected: check your FXML file 'menu .fxml'.";
        assert group2 != null : "fx:id=\"group2\" was not injected: check your FXML file 'menu .fxml'.";
        assert group1 != null : "fx:id=\"group1\" was not injected: check your FXML file 'menu .fxml'.";
        assert nonePineapple != null : "fx:id=\"nonePineapple\" was not injected: check your FXML file 'menu .fxml'.";
        assert addOrderbtn != null : "fx:id=\"addOrderbtn\" was not injected: check your FXML file 'menu .fxml'.";
        assert singlePineapple != null : "fx:id=\"singlePineapple\" was not injected: check your FXML file 'menu .fxml'.";
        assert smallSize != null : "fx:id=\"smallSize\" was not injected: check your FXML file 'menu .fxml'.";
        assert costPerItemtxt != null : "fx:id=\"costPerItemtxt\" was not injected: check your FXML file 'menu .fxml'.";
        assert orderTextArea != null : "fx:id=\"orderTextArea\" was not injected: check your FXML file 'menu .fxml'.";
        assert singleCheese != null : "fx:id=\"singleCheese\" was not injected: check your FXML file 'menu .fxml'.";

		// setting radio buttons in their respective toggle groups 
		smallSize.setToggleGroup(group1);
		mediumSize.setToggleGroup(group1);
		largeSize.setToggleGroup(group1);
		singleCheese.setToggleGroup(group2);
		doubleCheese.setToggleGroup(group2);
		tripleCheese.setToggleGroup(group2);
		singleHam.setToggleGroup(group3);
		noneHam.setToggleGroup(group3);
		singlePepper.setToggleGroup(group4);
		nonePepper.setToggleGroup(group4);
		singlePineapple.setToggleGroup(group5);
		nonePineapple.setToggleGroup(group5);

		// updating cost when a radio buttons are clicked
		// for size group
		group1.selectedToggleProperty().addListener((observableValue, oldVal, newVal) -> {
			cost();
		});
		// for cheese group
		group2.selectedToggleProperty().addListener((observableValue, oldVal, newVal) -> {
			cost();
		});
		// for ham group
		group3.selectedToggleProperty().addListener((observableValue, oldVal, newVal) -> {
	    	String pineapple = ((RadioButton) group5.getSelectedToggle()).getText();
	    	String greenPeppers = ((RadioButton) group4.getSelectedToggle()).getText();
			if (newVal.equals(noneHam) && (!pineapple.equals("None") || !greenPeppers.equals("None")))
				group4.selectToggle(nonePepper);
			    group5.selectToggle(nonePineapple);
			cost();
		});
		// for green peppers group
		group4.selectedToggleProperty().addListener((observableValue, oldVal, newVal) -> {
	    	String ham = ((RadioButton) group3.getSelectedToggle()).getText();
			if (newVal.equals(singlePepper) && ham.equals("None"))
				group3.selectToggle(singleHam);
			cost();
		});
		// for pineapple group
		group5.selectedToggleProperty().addListener((observableValue, oldVal, newVal) -> {
			String ham = ((RadioButton) group3.getSelectedToggle()).getText();
			if (newVal.equals(singlePineapple) && ham.equals("None"))
				group3.selectToggle(singleHam);
			cost();
		});
		// enter quantity number between 1 and 100 inclusive
		// error box given out if the number is outside this range
		quantitytxt.textProperty().addListener((observableValue, oldVal, newVal) -> {
			// used to backspace the number in the quantity box 
			int numPizza = 1;
			if (newVal.equals("")) {
				quantitytxt.setText("");
				return;
			}
			try {
				// changes the string to an integer 
				numPizza= Integer.parseInt(newVal);
				
			// exception thrown if not a number 
			}catch (NumberFormatException e) {
				quantitytxt.setText(oldVal);
				return;
			}
			if (numPizza < 1 || numPizza > 100) {
			   Alert alert = new Alert (AlertType.ERROR);
			   alert.setTitle("Illegal Number");
			   alert.setHeaderText("Quantity number not valid");
			   alert.setContentText("Please enter a value between 1 and 100 inclusive");
			   alert.showAndWait();
			   quantitytxt.setText(oldVal);
			   return;
			}
			quantity = numPizza;
			cost();

		});
		// adds functionality to the button and 
		//display the order in text area
		addOrderbtn.setOnAction(event -> {
			if (costPerItemtxt.getText().equals("")) {
				return;
			}
			// adding orders to the array list and printing them in the text area
			float totalCost = 0;
			String output = "" ;
			orders.add(item);
    		orders.sort(null);
			for (LineItem order : orders) {
				totalCost += order.getCost();
			    output += order +"\n";
			}
			//updates the total order list cost
			output += "Total order(s) cost: " + String.format("$%.2f.", totalCost);
			orderTextArea.setText(output);	
		});
		cost();
	}
}