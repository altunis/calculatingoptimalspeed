/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhendislikuygulamadeneme1;

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
import classlar.vtprocess;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author nerseh
 */
public class VirajFXMLController implements Initializable {

    @FXML
    private TextField txt_virajadi;
    @FXML
    private TextField txt_sk;
    @FXML
    private TextField txt_egim;
    @FXML
    private TextField txt_yaricap;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        String virajad =txt_virajadi.getText();
        double SurtunmeKatsayisi =Double.parseDouble(txt_sk.getText());
        if(SurtunmeKatsayisi>1){
            JOptionPane.showMessageDialog(null, "Sürtünme Katsayisi 1 den küçük olmalıdır!!");
        }
        else{
        double egim =Double.parseDouble(txt_egim.getText());
        double yaricap =Double.parseDouble(txt_yaricap.getText());
        vtprocess vt = new vtprocess();
        try{
            vt.virajEkle(virajad, SurtunmeKatsayisi, egim, yaricap);
            
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Eklenemedi");
        }}
        
    }
    
}
