import controller.MainController;
import controller.MainView;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Kalkulator;

import java.io.IOException;

public class Main extends Application implements MainView  {

    @FXML
    Button btnPlus;
    Button btnMinus;
    Button btnTimes;
    Button btnDivision;
    Button btnCalculate;
    TextField tvFirstNumber;
    TextField tvSecondNumber;
    Text textAnswer;

    Scene scene;
    MainController mainController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Simple Calcultor");

        Parent root = FXMLLoader.load(getClass().getResource("layout/main.fxml"));
        mainController = new MainController(this);

        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.getIcons().add(new Image("img/keys.png"));

        prepare();

        btnPlus.setOnAction(e -> {
            String nilai1 = tvFirstNumber.getText();
            String nilai2 = tvSecondNumber.getText();

            try {
                mainController.hitungTambah(nilai1, nilai2);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        btnMinus.setOnAction(e -> {
            String nilai1 = tvFirstNumber.getText();
            String nilai2 = tvSecondNumber.getText();

            mainController.hitungKurang(nilai1, nilai2);
        });

        btnTimes.setOnAction(e -> {
            String nilai1 = tvFirstNumber.getText();
            String nilai2 = tvSecondNumber.getText();

            mainController.hitungKali(nilai1, nilai2);
        });

        btnDivision.setOnAction(e -> {
            String nilai1 = tvFirstNumber.getText();
            String nilai2 = tvSecondNumber.getText();

            mainController.hitungBagi(nilai1, nilai2);
        });
    }

    private void prepare() {
        btnPlus = (Button) scene.lookup("#btnPlus");
        btnMinus = (Button) scene.lookup("#btnMinus");
        btnDivision = (Button) scene.lookup("#btnDivision");
        btnTimes = (Button) scene.lookup("#btnTimes");
        tvFirstNumber = (TextField) scene.lookup("#tvFirstNumber");
        tvSecondNumber = (TextField) scene.lookup("#tvSecondNumber");
        textAnswer = (Text) scene.lookup("#tvAnswer");

        tvFirstNumber.setStyle("-fx-text-inner-color: white; -fx-background-color: #353953; -fx-border-color: white;-fx-border-radius: 10px; -fx-border-width: 4px");
        tvSecondNumber.setStyle("-fx-text-inner-color: white; -fx-background-color: #353953; -fx-border-color: white;-fx-border-radius: 10px; -fx-border-width: 4px");

    }

    @Override
    public void bindView(Kalkulator kalkulator) {
        String answer = kalkulator.getTotal().toString();
        textAnswer.setText(answer);
    }

    @Override
    public void emptyTextField() {
        tvFirstNumber.setText("");
        tvSecondNumber.setText("");
    }
}
