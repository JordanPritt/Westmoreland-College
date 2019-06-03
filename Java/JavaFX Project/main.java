/**
 * Created by: Jordan Pritt
 * Date: 06/04/2017
 *
 * Purpose: This application is intended to be a base or start for the development of a
 * point of sales system geared towards restaurants. A portable JAVAFX desktop platform
 * is the goal of this application with intent on eventually adding connectivity to
 * Android, iOS, and database embedded or server.
 *
 */

package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.NumberFormat;

public class Main extends Application {

    // variables to hold order subtotal, tax rate, and total
    double subTotal = 0, tax = 0, total = 0, order = 1;

    // list to hold order details and totals
    ObservableList<String> items = FXCollections.observableArrayList("Point of Sale v1.0", " ", "Tax Rate: .09", " ");

    // list view declaration
    ListView<String> list;

    // this method sets up and starts the application
    public void start(Stage primaryStage) throws Exception {

        // create border layout for scene's root
        BorderPane border = new BorderPane();

        // add panes to border layout
        border.setTop(addTopButtons());
        border.setLeft(addMenuOptions());
        border.setCenter(orderBox());

        primaryStage.setTitle("Demo UI");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(border, 600, 500));
        primaryStage.show();
    }

    /**
     * The following methods build the GUI panes to be added to the border layout in
     * the apps scene and stage set up
     */

    // method that creates an HBox to hold buttons
    private HBox addTopButtons() {

        // create an HBox to hold buttons
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #333333;");

        // button to calculate total of purchase
        Button buttonCalculate = new Button("Calculate");
        buttonCalculate.setPrefSize(80, 20);
        buttonCalculate.setOnAction(e -> calculate());

        // button to clear selections made
        Button buttonClear = new Button("Clear");
        buttonClear.setPrefSize(80, 20);
        buttonClear.setOnAction(e -> clear());

        // add all buttons to HBox pane
        hbox.getChildren().addAll(buttonCalculate, buttonClear);

        return hbox;
    }

    // method that builds tabs for menu items
    private TabPane addMenuOptions() {

        // creates a TabPane to hold menu tabs
        // removes default close on all tabs
        TabPane options = new TabPane();
        options.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // tab for burger items
        Tab burger = new Tab();
        burger.setText("Burgers");
        burger.setContent(addBurger());

        // tab for side items
        Tab sides = new Tab();
        sides.setText("Sides");
        sides.setContent(addSides());

        // tab for drink items
        Tab drinks = new Tab();
        drinks.setText("Drinks");
        drinks.setContent(addDrinks());

        // add all tabs to TabPane options
        options.getTabs().addAll(burger, sides, drinks);

        return options;
    }

    // VBox that holds burger options
    private VBox addBurger() {

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        Button buttonBurger = new Button("Plain");
        buttonBurger.setPrefSize(80, 20);
        buttonBurger.setOnAction(e -> addPlain());

        Button buttonCheeseBurger = new Button("Cheese");
        buttonCheeseBurger.setPrefSize(80, 20);
        buttonCheeseBurger.setOnAction(e -> addCheeseBurger());

        Button buttonRodeoBurger = new Button("Rodeo");
        buttonRodeoBurger.setPrefSize(80, 20);
        buttonRodeoBurger.setOnAction(e -> addRodeo());

        vbox.getChildren().addAll(buttonBurger, buttonCheeseBurger, buttonRodeoBurger);

        return vbox;
    }

    // VBox that holds side options
    private VBox addSides() {

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        Button buttonFries = new Button("French Fries");
        buttonFries.setPrefSize(110, 20);
        buttonFries.setOnAction(e -> addFries());

        Button buttonOnionRings = new Button("Onion Rings");
        buttonOnionRings.setPrefSize(110, 20);
        buttonOnionRings.setOnAction(e -> addOnionRings());

        Button buttonCheeseSticks = new Button("Cheese Sticks");
        buttonCheeseSticks.setPrefSize(110, 20);
        buttonCheeseSticks.setOnAction(e -> addCheeseSticks());

        vbox.getChildren().addAll(buttonFries, buttonOnionRings, buttonCheeseSticks);

        return vbox;
    }

    // VBox that holds drink options
    private VBox addDrinks() {

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        Button buttonSoda = new Button("Soda Pop");
        buttonSoda.setPrefSize(80, 20);
        buttonSoda.setOnAction(e -> addSoda());

        Button buttonTea = new Button("Tea");
        buttonTea.setPrefSize(80, 20);
        buttonTea.setOnAction(e -> addTea());

        Button buttonBeer = new Button("Beer");
        buttonBeer.setPrefSize(80, 20);
        buttonBeer.setOnAction(e -> addBeer());

        vbox.getChildren().addAll(buttonSoda, buttonTea, buttonBeer);

        return vbox;
    }

    // list box to hold order info and prices
    private ListView orderBox() {

        list = new ListView<String>();

        list.setItems(items);

        return list;
    }

    /**
     * These methods add, remove and calculate the order options in the list view
     * and button clicks
     */

    private void addPlain() {
        subTotal += 1.5;
        String plain = "Plain Burger    $3.50";
        items.add(plain);
    }

    private void addCheeseBurger() {
        subTotal += 2.5;
        String cheese = "Cheese Burger    $4.50";
        items.add(cheese);
    }

    private void addRodeo() {
        subTotal += 2;
        String rodeo = "Rodeo Burger    $4.00";
        items.add(rodeo);
    }

    private void addFries() {
        subTotal += 1;
        String fry = "Fries    $1.00";
        items.add(fry);
    }

    private void addOnionRings() {
        subTotal += 1.5;
        String rodeo = "Onion Rings    $1.50";
        items.add(rodeo);
    }

    private void addCheeseSticks() {
        subTotal += 2;
        String mozSticks = "Mozzarella Sticks    $2.00";
        items.add(mozSticks);
    }

    private void addSoda() {
        subTotal += 1.75;
        String pop = "Soda Pop    $1.75";
        items.add(pop);
    }

    private void addTea() {
        subTotal += 1.5;
        String tea = "Tea    $1.50";
        items.add(tea);
    }

    private void addBeer() {
        subTotal += 2;
        String bier = "Beer    $2.00";
        items.add(bier);
    }

    private void calculate() {
        NumberFormat dollar = NumberFormat.getCurrencyInstance();
        double taxP = 0.09 * subTotal, totalPrice = taxP + subTotal;
        String totalP = "Order Total: " + dollar.format(totalPrice);
        String subPrice = "Subtotal: " + dollar.format(subTotal);
        String taxPrice = "Amount Tax: " + dollar.format(taxP);
        items.add(" ");
        items.add("Order Number: " + order);
        items.add(taxPrice);
        items.add(subPrice);
        items.add(totalP);
        items.add(" ");
        order++;
        subTotal = 0;
        tax = 0;
        total = 0;
    }

    private void clear() {
        list.getItems().clear();
        subTotal = 0;
        tax = 0;
        total = 0;
        order = 1;
        items = FXCollections.observableArrayList("Point of Sale v1.0", " ", "Tax Rate: .09", " ");
        list.setItems(items);
    }

    /**
     * Application entry point that runs app
     * 
     * @param args
     */

    public static void main(String[] args) {
        launch(args);
    }
}