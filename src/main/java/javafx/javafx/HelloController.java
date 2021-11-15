package javafx.javafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    //textField: especificar o tipo de conteudo e o initializable: como vai iniciar o controller
    //listener: controla o comportamento do controle é uma funçao que vai ser executada quando o controle sofrer alguma alteraçao ou interaçao com o usuario
    @FXML
    private Button btSum;

    @FXML
    public void onBtSumAction() {
        try {
            Locale.setDefault(Locale.US);
            double height = Double.parseDouble(txtNumber1.getText());
            double width = Double.parseDouble(txtNumber2.getText());
            double sum = height + width;
            labelResult.setText(String.format("%.2f", sum));
        } catch (NumberFormatException e) {
            Alerts.showAlert("Error", "Parse error", e.getMessage(), Alert.AlertType.ERROR);
        }
        // setText vai jogar o conteúdo da variavel soma
    }

    @FXML
    private TextField txtNumber1;
    @FXML
    private TextField txtNumber2;
    @FXML
    private Label labelResult;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Constraints.setTextFieldDouble(txtNumber1);
        Constraints.setTextFieldDouble(txtNumber2);//só deixa digitar double
        Constraints.setTextFieldMaxLength(txtNumber1,12);
        Constraints.setTextFieldMaxLength(txtNumber2,12);

    }
}