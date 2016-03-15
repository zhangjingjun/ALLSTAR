/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allstar;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author jingjunzhang
 */
public class UIController implements Initializable {
    
    @FXML
    private TextField textDatabase;
    @FXML
    private TextField textUser;
    @FXML
    private PasswordField textPass;
    @FXML
    private Button buttonConnect;
    @FXML
    private Label labelMessage;
    
    @FXML
    private TextField textFName;
    @FXML
    private TextField textLName;
    @FXML
    private TextField textDob;
    @FXML
    private TextField textGender;
    @FXML
    private TextField textNation;
    @FXML
    private TextField textAge;
    @FXML
    private TextField textStarsIn;
    @FXML
    private TextField textAwardS;
    @FXML
    private TextField textAwardYS;
    @FXML
    private Button buttonSearchS;
    @FXML
    private Button buttonClearS;
    @FXML
    private TableView<Star> tableStar;
    @FXML
    private TableColumn<Star, String> colPID;
    @FXML
    private TableColumn<Star, String> colFName;
    @FXML
    private TableColumn<Star, String> colLName;
    @FXML
    private TableColumn<Star, String> colDob;
    @FXML
    private TableColumn<Star, String> colGender;
    @FXML
    private TableColumn<Star, String> colNation;
    @FXML
    private TableColumn<Star, String> colAge;
    @FXML
    private TableColumn<Star, String> colStarsIn;
    @FXML
    private TableColumn<Star, String> colDirects;
    @FXML
    private TableColumn<Star, String> colAwardS;
    @FXML
    private TableColumn<Star, String> colAwardYS;
    
    @FXML
    private TextField textTitle;
    @FXML
    private TextField textYear;
    @FXML
    private TextField textGenres;
    @FXML
    private TextField textLang;
    @FXML
    private TextField textStudio;
    @FXML
    private TextField textRating;
    @FXML
    private TextField textStars;
    @FXML
    private TextField textAwardM;
    @FXML
    private TextField textAwardYM;
    @FXML
    private Button buttonSearchM;
    @FXML
    private Button buttonClearM;
    @FXML
    private TableView<Movie> tableMovie;
    @FXML
    private TableColumn<Movie, String> colMID;
    @FXML
    private TableColumn<Movie, String> colTitle;
    @FXML
    private TableColumn<Movie, String> colYear; 
    @FXML
    private TableColumn<Movie, String> colGenres;
    @FXML
    private TableColumn<Movie, String> colLang;
    @FXML
    private TableColumn<Movie, String> colStudio;
    @FXML
    private TableColumn<Movie, String> colRating;
    @FXML
    private TableColumn<Movie, String> colStars;
    @FXML
    private TableColumn<Movie, String> colDirector;
    @FXML
    private TableColumn<Movie, String> colAwardM;
    @FXML
    private TableColumn<Movie, String> colAwardYM;
    
    
    @FXML
    private ChoiceBox choiceStar;
    @FXML
    private Button buttonShowS;
    @FXML
    private ListView listStar;
    @FXML
    private BarChart barStar;
    @FXML
    private CategoryAxis catS;
    @FXML
    private NumberAxis numS;
    
    
    @FXML
    private ChoiceBox choiceMovie;
    @FXML
    private Button buttonShowM;
    @FXML
    private ListView listMovie;
    @FXML
    private BarChart barMovie;
    @FXML
    private CategoryAxis catM;
    @FXML
    private NumberAxis numM;
    
    private DB db;
    private ObservableList<Star> starOL=FXCollections.observableArrayList();
    private ObservableList<Movie> movieOL=FXCollections.observableArrayList();
    private ArrayList<Star> starResult  = new ArrayList<>();
    private ArrayList<Movie> movieResult = new ArrayList<>();
    
    @FXML
    private void handleButtonConnectAction(ActionEvent event) {
        try {
            if (db.connectDB("jdbc:mysql://"+textDatabase.getText(), textUser.getText(),textPass.getText())) {
                labelMessage.setText("The database is connected successfully.");
            } else {
                labelMessage.setText("Connection failed, please check your input.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
            labelMessage.setText("Connection failed, please check your input.");
        }
    }
    
    @FXML
    private void handleButtonSearchSAction(ActionEvent event) throws SQLException {
        
        if (   textFName.getText().isEmpty()&&
               textLName.getText().isEmpty()&&
               textDob.getText().isEmpty()&&
               textGender.getText().isEmpty()&&
               textNation.getText().isEmpty()&&
               textAge.getText().isEmpty()&&
               textStarsIn.getText().isEmpty()&&
               textAwardS.getText().isEmpty()&&
               textAwardYS.getText().isEmpty()    ){
            //pop messagebox;
            return;
        }
        
        if (db.getconnDB()==null){
            return;
            //pop messagebox;
        }
        
        
        starResult = db.getStarResult(textFName.getText(), 
                         textLName.getText(), 
                         textDob.getText(), 
                         textGender.getText(), 
                         textNation.getText(), 
                         textAge.getText(), 
                         textStarsIn.getText(), 
                         textAwardS.getText(), 
                         textAwardYS.getText());
        if (starResult.isEmpty()) {
            return;
            //pop messagebox;
        }
        setStarTable();
        
    }
    
    @FXML
    private void handleButtonClearSAction(ActionEvent event) {
        
    }
    
    @FXML
    private void handleButtonSearchMAction(ActionEvent event) {
        
    }
    
    @FXML
    private void handleButtonClearMAction(ActionEvent event) {
        
    }
    
    @FXML
    private void handleButtonShowSAction(ActionEvent event) {
        
    }
    
    @FXML
    private void handleButtonShowMAction(ActionEvent event) {
        
    }
    
    private void choiceBoxInit (){
        this.choiceStar.getItems().addAll("Top Hard-working Stars", "Top Award Winners", "Top Hard-working Directors");
        this.choiceStar.setValue("Top Hard-working Stars");
        
        this.choiceMovie.getItems().addAll("Top Rated Movies", "Top Award-winning Movies");
        this.choiceMovie.setValue("Top Rated Movies");        
    }
    
    private void cellValueFactoryInit () {
        colPID.setCellValueFactory(new PropertyValueFactory<>("pid"));
        colFName.setCellValueFactory(new PropertyValueFactory<>("fName"));
        colLName.setCellValueFactory(new PropertyValueFactory<>("lName"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colNation.setCellValueFactory(new PropertyValueFactory<>("nation"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colStarsIn.setCellValueFactory(new PropertyValueFactory<>("starsIn"));
        colDirects.setCellValueFactory(new PropertyValueFactory<>("directs"));
        colAwardS.setCellValueFactory(new PropertyValueFactory<>("awardS"));
        colAwardYS.setCellValueFactory(new PropertyValueFactory<>("awardYS"));  
        
        tableStar.setItems(starOL); 

        colMID.setCellValueFactory(new PropertyValueFactory<>("mid"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colGenres.setCellValueFactory(new PropertyValueFactory<>("genres"));
        colLang.setCellValueFactory(new PropertyValueFactory<>("lang"));
        colStudio.setCellValueFactory(new PropertyValueFactory<>("studio"));
        colRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        colStars.setCellValueFactory(new PropertyValueFactory<>("stars"));
        colDirector.setCellValueFactory(new PropertyValueFactory<>("director"));
        colAwardM.setCellValueFactory(new PropertyValueFactory<>("awardM"));
        colAwardYM.setCellValueFactory(new PropertyValueFactory<>("awardYM"));
    
        tableMovie.setItems(movieOL); 
        
    }
    
    private void setStarTable () {
        starOL.clear();
        
        tableStar.refresh();
        for (Star s : starResult) {
            starOL.add(s);
        } 
           
    }
    
    private void setMovieTable () {
        movieOL.clear();
        tableMovie.refresh();
        for (Movie s : movieResult) {
            movieOL.add(s);
        } 
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //ToDo
        db = DB.getDBInstance();
        choiceBoxInit();
        cellValueFactoryInit();
 
     
        
    }    
    
}
