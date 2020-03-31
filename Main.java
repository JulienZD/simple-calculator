package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    private ArrayList<TextField> inputFields;
    private Label answer;
    private final int amtOfInputFields = 2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = createRootPane();
        Scene primaryScene = new Scene(pane);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }

    private Pane createRootPane() {
        VBox root = new VBox();
        root.setSpacing(5);
        root.setPadding(new Insets(5));
        answer = new Label("0");
        root.getChildren().addAll(createInputFields(), createButtons(), answer);
        return root;
    }

    private Pane createInputFields() {
        VBox inputFields = new VBox();
        this.inputFields = new ArrayList<>();
        inputFields.setSpacing(5);
        for (int i = 1; i <= amtOfInputFields; i++) {
            HBox row = new HBox();
            row.setSpacing(15);
            row.getChildren().add(new Label("Number " + i + ":"));
            TextField t = new TextField();
            this.inputFields.add(t);
            row.getChildren().add(t);
            inputFields.getChildren().add(row);
        }
        return inputFields;
    }

    private Pane createButtons() {
        HBox buttons = new HBox();
        buttons.setPadding(new Insets(10, 0, 0, 0));
        buttons.setSpacing(5);
        String[] labels = {"+", "-", "*", "/"};
        for (String label : labels) {
            Button b = new Button(label);
            b.setOnAction(event -> calculateAnswer(b.getText()));
            b.setMinWidth(75);
            buttons.getChildren().add(b);
        }
        return buttons;
    }

    private void calculateAnswer(String operator) {
        ArrayList<Double> numbers = new ArrayList<>();
        String shownValue;
        for (TextField t : inputFields) {
            try {
                double num = Double.parseDouble(t.getText());
                numbers.add(num);
            }
            catch (Exception e) {
                System.out.println("Not a number");
            }
        }
        double newAnswer = Double.parseDouble(answer.getText());
        for (double num : numbers) {
            switch (operator) {
                case "+":
                    newAnswer += num;
                    break;
                case "-":
                    newAnswer -= num;
                    break;
                case "*":
                    newAnswer *= num;
                    break;
                case "/":
                    newAnswer /= num;
                    break;
            }
        }
        shownValue = newAnswer % 1 == 0 ? String.format("%.0f", newAnswer) : String.format("%.2f", newAnswer);
        this.answer.setText(shownValue + "");
    }
}