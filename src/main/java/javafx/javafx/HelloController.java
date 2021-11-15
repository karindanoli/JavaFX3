package javafx.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Button btTest;

    @FXML
    public void onBtTestAction() {
        Alerts.showAlert("Alert title", "Alert header","Hello!", Alert.AlertType.INFORMATION);
            }
}