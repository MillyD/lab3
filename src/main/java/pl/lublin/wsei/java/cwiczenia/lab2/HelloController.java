package pl.lublin.wsei.java.cwiczenia.lab2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import java.io.File;

public class HelloController {
    public Label lbFile;
    public ListView IstInfografiki;
    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter xmlFilter = new FileChooser.ExtensionFilter("Pliki XML (*.xml)","*.xml");

    @FXML
    public  void initialize(){
        fileChooser.getExtensionFilters().add(xmlFilter);
    }
    public void btnOpenFileAction(ActionEvent actionEvent) {
        File file = fileChooser.showOpenDialog(null);
        if(file !=null){
            lbFile.setText(file.getAbsolutePath());
        }
        else{
            lbFile.setText("Proszę wczytać plik ...");
        }

    }
}