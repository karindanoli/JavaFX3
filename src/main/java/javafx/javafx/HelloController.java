package javafx.javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public void onComboBoxPersonAction(){
        Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
        System.out.println(person);
    }//guarda a pessoa que foi selecionada.

    @FXML
    private Button btAll;

    @FXML
    public void onBtAllAction(){
        for (Person person: comboBoxPerson.getItems())
        {
            System.out.println(person);

        }
    }

    @FXML
    private ComboBox<Person> comboBoxPerson;
//cria um componente visual entre a minha lista e o scenebuilder
    private ObservableList<Person> obsList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            List<Person> list = new ArrayList<>();
            list.add(new Person(1, "Maria", "maria@"));
        list.add(new Person(2, "João", "maria@"));
        list.add(new Person(3, "Eduardo", "maria@"));
        //agora vai pegar esta lista e colocar no observableList
        obsList = FXCollections.observableArrayList(list);
        comboBoxPerson.setItems(obsList);//coloca no combobox a lista

        Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
            @Override
            protected void updateItem(Person item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };
        comboBoxPerson.setCellFactory(factory);
        comboBoxPerson.setButtonCell(factory.call(null));
    }//editar a saida de dados do combobox
}