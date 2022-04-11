package pl.lublin.wsei.java.cwiczenia.lab2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;

public class HelloController {
    public Label lbFile;
    public ImageView imgMiniaturka;
    public Button btnPokazInfografike;
    public TextField txtAdresStrony;
    public Button btnPrzejdzDoStrony;

    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter xmlFilter = new FileChooser.ExtensionFilter("Pliki XML (*.xml)","*.xml");

    public ListView<String> lstInfografiki;
    ObservableList<String> tytuly = FXCollections.observableArrayList();
    GusInfographicList igList;

    @FXML
    public  void initialize(){
        fileChooser.getExtensionFilters().add(xmlFilter);
        lstInfografiki.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number old_val, Number new_val) {
                        int index = new_val.intValue();
                        if(index != -1){
                            txtAdresStrony.setText(igList.infographics.get(index).addressUrl);
                            Image image = new Image(igList.infographics.get(index).thumbNailUrl);
                            imgMiniaturka.setImage(image);
                        }
                        else{
                            txtAdresStrony.setText("");
                            imgMiniaturka.setImage(null);
                        }
                    }
                }
        );
    }
    public void btnOpenFileAction(ActionEvent actionEvent) {
        File file = fileChooser.showOpenDialog(null);
        if(file !=null){
            igList = new GusInfographicList(file.getAbsolutePath());
            lbFile.setText(file.getAbsolutePath());
            for (Infografika ig: igList.infographics){
                tytuly.add(ig.title);
                lstInfografiki.setItems(tytuly);
            }
        }
        else{
            lbFile.setText("Proszę wczytać plik ...");
        }

    }
}
//C:\Users\emili\Desktop\JAVA-projects\Studia\lab3\src\main\java\pl\lublin\wsei\java\cwiczenia\lab2