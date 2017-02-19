/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhendislikuygulamadeneme1;

import classlar.vtprocess;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author nerseh
 */
public class ArabaFXMLController implements Initializable {

    @FXML
    private TextField txt_marka;
    @FXML
    private TextField txt_uzunluk;
    @FXML
    private TextField txt_tekeruzunlugu;
    @FXML
    private TextField txt_arabagenisligi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void btn_virajgeri(ActionEvent event) throws IOException {
        Scene c = new Scene(FXMLLoader.load(getClass().getResource("FXMLDocument.fxml")));
                    Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
                    st.setScene(c);
                    st.show();
    }

    @FXML
    private void btn_virajekle(ActionEvent event) {
            String marka =txt_marka.getText();
        double uzunluk =Double.parseDouble(txt_uzunluk.getText());
        double tekeruzunluk =Double.parseDouble(txt_tekeruzunlugu.getText());
        double genislik =Double.parseDouble(txt_arabagenisligi.getText());
        vtprocess vt = new vtprocess();
        try{
            vt.arabaEkle(marka, uzunluk, tekeruzunluk, genislik);
            
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Eklenemedi");
        }
        
    }
    }
    

