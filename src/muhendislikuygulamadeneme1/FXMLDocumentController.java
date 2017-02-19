/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhendislikuygulamadeneme1;

import classlar.araba;
import classlar.viraj;
import classlar.vtprocess;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.lang.Math;
import java.text.DecimalFormat;
import javafx.beans.binding.Bindings;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;

/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btn_giris;
    
    public static final double yercekim_ivmesi = 9.8;
    double yaricap;
    double surtunme_katsayisi;
    double hiz_ms;
    double hiz_kmh;
    double sonuc;
    double egimacisi;
    double egim;
    double devrilme_hizi;
    double teker_yuksekligi;
    double araba_genisligi;
    
    @FXML
    private TableView<araba> tbl_arabalar;
    @FXML
    private TableColumn<araba, String> col_arabamarka;
    @FXML
    private TableColumn<araba, Double> col_arabauzunluk;
    @FXML
    private TableColumn<araba, Double> col_tekeryukseklik;
    @FXML
    private TableView<viraj> tbl_virajlar;
    @FXML
    private TableColumn<viraj, String> col_virajad;
    @FXML
    private TableColumn<viraj, Double> col_surtunmekatsayisi;
    @FXML
    private TableColumn<viraj, Double> col_egim;
    @FXML
    private TableColumn<viraj, Double> col_yaricap;
    @FXML
    private Button btn_hesapla;
    @FXML
    private Button btn_virajekle;
    @FXML
    private Button btn_arabaekle;
    @FXML
    private TableColumn<araba, Double> col_arabagenislik;
    @FXML
    private TableColumn<araba, Integer> col_arabaid;
    @FXML
    private TableColumn<viraj,Integer > col_virajid;
    @FXML
    private Label lbl_yazi;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Callback<TableColumn<araba,String>, TableCell<araba,String>> cellFactory =
             new Callback<TableColumn<araba,String>, TableCell<araba,String>>() {
                 public TableCell call(TableColumn p) {
                    return new EditingCell();
                 }
             }; 
        col_arabaid.setCellValueFactory(new PropertyValueFactory<araba, Integer>("arabaid"));
        col_arabamarka.setCellValueFactory(new PropertyValueFactory<araba, String>("marka"));
        col_arabamarka.setCellFactory(cellFactory);
        col_arabamarka.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<araba, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<araba, String> t) {
                ((araba) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setMarka(t.getNewValue());
                        vtprocess vt = new vtprocess();
                        vt.arabaGuncelle(tbl_arabalar.getSelectionModel().getSelectedItem().getArabaid(), tbl_arabalar.getSelectionModel().getSelectedItem().getMarka(), tbl_arabalar.getSelectionModel().getSelectedItem().getUzunluk(),
                               tbl_arabalar.getSelectionModel().getSelectedItem().getTekeruzunlugu() , tbl_arabalar.getSelectionModel().getSelectedItem().getArabagenisligi());
            }
        });
        col_arabauzunluk.setCellValueFactory(new PropertyValueFactory<araba, Double>("uzunluk"));
        col_arabagenislik.setCellValueFactory(new PropertyValueFactory<araba, Double>("arabagenisligi"));
        col_tekeryukseklik.setCellValueFactory(new PropertyValueFactory<araba, Double>("tekeruzunlugu"));
        col_virajid.setCellValueFactory(new PropertyValueFactory<viraj, Integer>("virajid"));
        col_virajad.setCellValueFactory(new PropertyValueFactory<viraj, String>("virajad"));
        col_surtunmekatsayisi.setCellValueFactory(new PropertyValueFactory<viraj, Double>("surtunmekatsayisi"));
        col_egim.setCellValueFactory(new PropertyValueFactory<viraj, Double>("egim"));
        col_yaricap.setCellValueFactory(new PropertyValueFactory<viraj, Double>("yaricap"));
       
        vtprocess vt = new vtprocess();
        tbl_arabalar.setItems(vt.arabalaricek());
        tbl_virajlar.setItems(vt.virajlaricek());
        
        tbl_arabalar.setRowFactory(new Callback<TableView<araba>, TableRow<araba>>() {
            @Override
            public TableRow<araba> call(TableView<araba> param) {
            final TableRow<araba> row = new TableRow<>();
            final ContextMenu contextMenu = new ContextMenu();
            final MenuItem menuItem = new MenuItem("Sil");
            menuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                 tbl_arabalar.getItems().remove(row.getItem());
                 vt.arabaSil(row.getItem().getMarka());
                }
            });
            contextMenu.getItems().add(menuItem);
            row.contextMenuProperty().bind(Bindings.when(row.emptyProperty()).then((ContextMenu)null).otherwise(contextMenu));
            return row;
            }
            
        });
        tbl_virajlar.setRowFactory(new Callback<TableView<viraj>,TableRow<viraj>>(){
        @Override
            public TableRow<viraj> call(TableView<viraj> param) {
            final TableRow<viraj> row = new TableRow<>();
            final ContextMenu contextMenu = new ContextMenu();
            final MenuItem menuItem = new MenuItem("Sil");
            menuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                 tbl_virajlar.getItems().remove(row.getItem());
                 vt.virajSil(row.getItem().getVirajad());
                }
            });
            contextMenu.getItems().add(menuItem);
            row.contextMenuProperty().bind(Bindings.when(row.emptyProperty()).then((ContextMenu)null).otherwise(contextMenu));
            return row;
            }
    });
           
    }    

    @FXML
    private void girisyap(ActionEvent event) throws IOException {
         Scene c = new Scene(FXMLLoader.load(getClass().getResource("cizim.fxml")));
                    Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
                    st.setScene(c);
                    st.show();
        
    }

 
    @FXML
    private void hesapla(ActionEvent event) {
        try {
            egimacisi=tbl_virajlar.getSelectionModel().getSelectedItem().getEgim();
            surtunme_katsayisi = tbl_virajlar.getSelectionModel().getSelectedItem().getSurtunmekatsayisi();
            yaricap = tbl_virajlar.getSelectionModel().getSelectedItem().getYaricap();
            araba_genisligi=tbl_arabalar.getSelectionModel().getSelectedItem().getArabagenisligi();
            teker_yuksekligi=tbl_arabalar.getSelectionModel().getSelectedItem().getTekeruzunlugu();
                egim = Math.toRadians(egimacisi);
                egim=Math.tan(egim);
                sonuc=((egim+surtunme_katsayisi)/(1-surtunme_katsayisi*egim))*yaricap*yercekim_ivmesi;
                hiz_ms=Math.sqrt(sonuc);
                hiz_kmh=hiz_ms*3.6;
                devrilme_hizi=yercekim_ivmesi*yaricap*(teker_yuksekligi/araba_genisligi*egim+0.5)/(teker_yuksekligi/araba_genisligi-0.5*egim);
                devrilme_hizi=Math.sqrt(devrilme_hizi)*3.6;
                JOptionPane.showMessageDialog(null, "Dışa Kayma Yaşamamanız İçin En Yüksek Hızınız : "+new DecimalFormat("####.####").format(hiz_kmh)+" Km/s Olmalıdır.\n"
                        + "Dışa Devrilme Yaşamamanız İçin En Yüksek Hızınız : "+new DecimalFormat("####.####").format(devrilme_hizi)+" Km/s Olmalıdır.");
                
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lütfen Seçim Yapınız");
        }
    }

    @FXML
    private void virajekle(ActionEvent event) throws IOException {
        Scene c = new Scene(FXMLLoader.load(getClass().getResource("virajFXML.fxml")));
                    Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
                    st.setScene(c);
                    st.show();
    }

    @FXML
    private void arabaekle(ActionEvent event) throws IOException {
        Scene c = new Scene(FXMLLoader.load(getClass().getResource("arabaFXML.fxml")));
                    Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
                    st.setScene(c);
                    st.show();
    }
    
}
