/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhendislikuygulamadeneme1;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class CizimController implements Initializable {

    Path anaYol = new Path();
    Path anayol1=new Path();    
    Path anayol2=new Path();
    @FXML
    private AnchorPane anc_cizim;
    @FXML
    private ImageView img_utban;
    private int sayac;
    private ImageView arac;
    @FXML
    private Button btngeri;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            Image aracresim = new Image("/pictures/minibus.jpg");
            arac = new ImageView();
            arac.setImage(aracresim);
            arac.setFitHeight(50);
            arac.setFitWidth(44);
            arac.toFront();
            arac.setPreserveRatio(true);
            arac.setSmooth(true);
            arac.setCache(true);
            anc_cizim.getChildren().add(arac);
            anc_cizim.getChildren().add(anaYol);
            anaYol.setStrokeWidth(15);
            anaYol.setStroke(Color.BLACK);
            anc_cizim.getChildren().add(anayol1);
            anayol1.setStrokeWidth(5);
            anayol1.setStroke(Color.WHITE);
            anc_cizim.getChildren().add(anayol2);
            anayol2.setStrokeWidth(15);
            anayol2.setStroke(Color.BLACK);
            anayol2.toBack();
            anaYol.toBack();
            anayol1.toBack();
            
    }    

    @FXML
    private void birakildi(MouseEvent event) {
         PathTransition pts1 = new PathTransition();
         anayol1.setLayoutX(anaYol.getLayoutX()-5);
         
        pts1.setPath(anayol1);
        pts1.setNode(arac);
        pts1.setDuration(Duration.millis(3000));
        pts1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pts1.play();
    }

    @FXML
    private void basiliyor(MouseEvent event) {
        anaYol.getElements().add(new LineTo(event.getX(), event.getY()));
        anayol1.getElements().add(new LineTo(event.getX()+15, event.getY()));        
        anayol2.getElements().add(new LineTo(event.getX()+20, event.getY()));
//        Random rnd=new Random();
//        
//
//            int sayi = rnd.nextInt(50000);
//            Image yol = new Image("/pictures/utban.jpg");
//            ImageView iv = new ImageView();
//            iv.setImage(yol);
//            iv.setFitHeight(50);
//            iv.setFitWidth(44);
//            iv.setPreserveRatio(true);
//            iv.setSmooth(true);
//            iv.setCache(true);
//            anc_cizim.getChildren().add(iv);
//            iv.setLayoutX(event.getX());
//            iv.setLayoutY(event.getY());
//            iv.setId(iv+String.valueOf(sayi)); 
    }

    @FXML
    private void basildi(MouseEvent event) {
        anaYol.getElements().clear();
        anaYol.getElements().add(new MoveTo(event.getX(), event.getY()));
        anayol1.getElements().clear();
        anayol1.getElements().add(new MoveTo(event.getX()+15, event.getY()));        
        anayol2.getElements().clear();
        anayol2.getElements().add(new MoveTo(event.getX()+20, event.getY()));
        
    }

    @FXML
    private void gerigit(ActionEvent event) throws IOException{
        Scene c = new Scene(FXMLLoader.load(getClass().getResource("FXMLDocument.fxml")));
                    Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
                    st.setScene(c);
                    st.show();
        
    }

    @FXML
    private void yenicizim(ActionEvent event) throws IOException{
        Scene c = new Scene(FXMLLoader.load(getClass().getResource("cizim.fxml")));
                    Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
                    st.setScene(c);
                    st.show();
    }
    
    
}
