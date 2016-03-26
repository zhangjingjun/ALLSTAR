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
import javafx.scene.chart.XYChart;
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
    private BarChart<String, Number> barStar;
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
    private BarChart<String, Number> barMovie;
    @FXML
    private CategoryAxis catM;
    @FXML
    private NumberAxis numM;
    
    @FXML
    private TextField textEditPID;
    @FXML
    private TextField textEditFName;    
    @FXML
    private TextField textEditLName;
    @FXML
    private TextField textEditGender;
    @FXML
    private TextField textEditDoB;
    @FXML
    private TextField textEditNation;
    @FXML
    private TextField textEditMVID;
    @FXML
    private TextField textEditTitle;
    @FXML
    private TextField textEditMYear;
    @FXML
    private TextField textEditGenres;
    @FXML
    private TextField textEditLang;
    @FXML
    private TextField textEditStudio;
    @FXML
    private TextField textEditRating;
    @FXML
    private TextField textEditPIDPT;
    @FXML
    private TextField textEditMVIDPT;
    @FXML
    private TextField textEditRole;
    @FXML
    private TextField textEditPAID;
    @FXML
    private TextField textEditPIDPA;
    @FXML
    private TextField textEditPATitle;
    @FXML
    private TextField textEditPAIsWinner;
    @FXML
    private TextField textEditMVIDPA;
    @FXML
    private TextField textEditCNamePA;
    @FXML
    private TextField textEditCYearPA;
    @FXML
    private TextField textEditMAID;
    @FXML
    private TextField textEditMVIDMA;
    @FXML
    private TextField textEditMATitle;
    @FXML
    private TextField textEditMAIsWinner;
    @FXML
    private TextField textEditCNameMA;
    @FXML
    private TextField textEditCYearMA;
    
    @FXML
    private Button buttonEditS;
    @FXML
    private Button buttonDelS;
    @FXML
    private Button buttonEditM;
    @FXML
    private Button buttonDelM;
    @FXML
    private Button buttonEditPT;
    @FXML
    private Button buttonDelPT;
    @FXML
    private Button buttonEditPA;
    @FXML
    private Button buttonDelPA;
    @FXML
    private Button buttonEditMA;
    @FXML
    private Button buttonDelMA;
    
    private DB db;
    private ObservableList<Star> starOL=FXCollections.observableArrayList();
    private ObservableList<Movie> movieOL=FXCollections.observableArrayList();
    private ArrayList<Star> starResult  = new ArrayList<>();
    private ArrayList<Movie> movieResult = new ArrayList<>();
    private ArrayList<ChartData> chartStarResult = new ArrayList<> ();
    private ArrayList<ChartData> chartMovieResult = new ArrayList<> ();
    
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
        starResult.clear();
        starOL.clear();
        textFName.clear();
        textLName.clear();
        textDob.clear();
        textGender.clear();
        textNation.clear();
        textAge.clear();
        textStarsIn.clear();
        textAwardS.clear();
        textAwardYS.clear();
    }
    
    @FXML
    private void handleButtonSearchMAction(ActionEvent event) throws SQLException {

        if (   textTitle.getText().isEmpty()&&
               textYear.getText().isEmpty()&&
               textGenres.getText().isEmpty()&&
               textLang.getText().isEmpty()&&
               textStudio.getText().isEmpty()&&
               textRating.getText().isEmpty()&&
               textStars.getText().isEmpty()&&
               textAwardM.getText().isEmpty()&&
               textAwardYM.getText().isEmpty()    ){
            //pop messagebox;
            return;
        }
        
        if (db.getconnDB()==null){
            return;
            //pop messagebox;
        }
        
        
        movieResult = db.getMovieResult(textTitle.getText(), 
                         textYear.getText(), 
                         textGenres.getText(), 
                         textLang.getText(), 
                         textStudio.getText(), 
                         textRating.getText(), 
                         textStars.getText(), 
                         textAwardM.getText(), 
                         textAwardYM.getText());
        if (movieResult.isEmpty()) {
            return;
            //pop messagebox;
        }
        setMovieTable();        
    }
    
    @FXML
    private void handleButtonClearMAction(ActionEvent event) {
        movieResult.clear();
        movieOL.clear();
        textTitle.clear();
        textYear.clear();
        textGenres.clear();
        textLang.clear();
        textStudio.clear();
        textRating.clear();
        textStars.clear();
        textAwardM.clear();
        textAwardYM.clear();
    }
    
    @FXML
    private void handleButtonShowSAction(ActionEvent event) {
        String opt = choiceStar.getValue().toString();
        System.out.println(opt);
        switch (opt) {
            case "Top Hard-working Stars": 
                chartStarResult = db.getStarMostMovie();
                barStar.setTitle("Top Hard-working Stars");
                catS.setLabel("Name of Stars");
                numS.setLabel("Number of Movies");
                break;
            case "Top Award Winners":   
                chartStarResult = db.getStarMostAward();
                barStar.setTitle("Top Award Winners");
                catS.setLabel("Name of Stars");
                numS.setLabel("Number of Awards");
                break;
            case "Top Hard-working Directors":    
                chartStarResult = db.getDirectorMostMovie();
                barStar.setTitle("Top Hard-working Directors");
                catS.setLabel("Name of Directors");
                numS.setLabel("Number of Movies");
                break;
            default:
                break;
        }
        listStar.getItems().clear();
        barStar.getData().clear();
        XYChart.Series starDataSeries = new XYChart.Series<>();
        for (ChartData cd : chartStarResult) {
            starDataSeries.getData().add(new XYChart.Data<>(cd.getText(), cd.getNum()));
            listStar.getItems().add(cd.getText() + ": " + cd.getNum());
        }
        barStar.getData().add(starDataSeries);
    }
    
    @FXML
    private void handleButtonShowMAction(ActionEvent event) {
        String opt = choiceMovie.getValue().toString();
        System.out.println(opt);
        switch (opt) {
            case "Top Rated Movies": 
                chartMovieResult = db.getMovieHighRated();
                barMovie.setTitle("Top Rated Movies");
                catM.setLabel("Title of Movies");
                catM.setLabel("Rating of Movies");
                break;
            case "Top Award-winning Movies":   
                chartMovieResult = db.getMovieMostAward();
                barMovie.setTitle("Top Award-winning Movies");
                catM.setLabel("Title of Movies");
                catM.setLabel("Number of Awards");
                break;
            default:
                break;
        }
        barMovie.getData().clear();
        listMovie.getItems().clear();
        XYChart.Series starDataSeries = new XYChart.Series<>();
        for (ChartData cd : chartMovieResult) {
            starDataSeries.getData().add(new XYChart.Data<>(cd.getText(), cd.getNum()));
            listMovie.getItems().add(cd.getText() + ": " + cd.getNum());
        }
        barMovie.getData().add(starDataSeries);
    }
    
    @FXML
    private void handleButtonEditSAction(ActionEvent event) {
        if (db.getconnDB()==null){
            return;
            //pop messagebox;
        }
        if (textEditPID.getText().isEmpty()||
                textEditFName.getText().isEmpty()||
                textEditLName.getText().isEmpty()||
                textEditGender.getText().isEmpty()||
                textEditDoB.getText().isEmpty()||
                textEditNation.getText().isEmpty()) {
            return;
        }
        if (db.addStar(textEditPID.getText(), textEditFName.getText(), textEditLName.getText(), textEditGender.getText(), textEditDoB.getText(), textEditNation.getText())) {
            System.out.println("A star is added/edited.");
        }
        
    }
    
    @FXML
    private void handleButtonDelSAction(ActionEvent event) {
        if (db.getconnDB()==null){
            return;
            //pop messagebox;
        }
        if (textEditPID.getText().isEmpty()) {
            return;
        }
        if (db.delStar(textEditPID.getText())) {
            System.out.println("A star is deleted.");
        }
            
    }
    
    @FXML
    private void handleButtonEditMAction(ActionEvent event) {
        if (db.getconnDB()==null){
            return;
            //pop messagebox;
        }
        if (textEditMVID.getText().isEmpty()||
                textEditTitle.getText().isEmpty()||
                textEditMYear.getText().isEmpty()||
                textEditGenres.getText().isEmpty()||
                textEditLang.getText().isEmpty()||
                textEditStudio.getText().isEmpty()||
                textEditRating.getText().isEmpty()) {
            return;
        }
        if (db.addMovie(textEditMVID.getText(), textEditTitle.getText(), textEditMYear.getText(), textEditGenres.getText(), textEditLang.getText(), textEditStudio.getText(), textEditRating.getText())) {
            System.out.println("A movie is added/edited.");
        }
        
    }
    
    @FXML
    private void handleButtonDelMAction(ActionEvent event) {
        if (db.getconnDB()==null){
            return;
            //pop messagebox;
        }
        if (textEditMVID.getText().isEmpty()) {
            return;
        }
        if (db.delMovie(textEditMVID.getText())) {
            System.out.println("A movie is deleted.");
        }
    }
    
    @FXML
    private void handleButtonEditPTAction(ActionEvent event) {
    if (db.getconnDB()==null){
            return;
            //pop messagebox;
        }
        if (textEditPIDPT.getText().isEmpty()||textEditMVIDPT.getText().isEmpty()||textEditRole.getText().isEmpty()) {
            return;
        }
        if (db.addPT(textEditPIDPT.getText(), textEditMVIDPT.getText(), textEditRole.getText())) {
            System.out.println("A participation is added/edited.");
        }    
    }
    
    @FXML
    private void handleButtonDelPTAction(ActionEvent event) {
    if (db.getconnDB()==null){
            return;
            //pop messagebox;
        }
        if (textEditPIDPT.getText().isEmpty()||textEditMVIDPT.getText().isEmpty()||textEditRole.getText().isEmpty()) {
            return;
        }
        if (db.delPT(textEditPIDPT.getText(), textEditMVIDPT.getText(), textEditRole.getText())) {
            System.out.println("A participation is deleted.");
        }    
    }
    
    @FXML
    private void handleButtonEditPAAction(ActionEvent event) {
        if (db.getconnDB()==null){
            return;
            //pop messagebox;
        }
        if (textEditPAID.getText().isEmpty()||
                textEditPIDPA.getText().isEmpty()||
                textEditPATitle.getText().isEmpty()||
                textEditPAIsWinner.getText().isEmpty()||
                textEditMVIDPA.getText().isEmpty()||
                textEditCNamePA.getText().isEmpty()||
                textEditCYearPA.getText().isEmpty()) {
            return;
        }
        if (db.addPA(textEditPAID.getText(), textEditPIDPA.getText(), textEditPATitle.getText(), textEditPAIsWinner.getText(), textEditMVIDPA.getText(), textEditCNamePA.getText(), textEditCYearPA.getText())) {
            System.out.println("A personal award is added/edited.");
        }
    }
    
    @FXML
    private void handleButtonDelPAAction(ActionEvent event) {
        if (db.getconnDB()==null){
            return;
            //pop messagebox;
        }
        if (textEditPAID.getText().isEmpty()) {
            return;
        }
        if (db.delPA(textEditPAID.getText())) {
            System.out.println("A personal award is deleted.");
        }
    }
    
    @FXML
    private void handleButtonEditMAAction(ActionEvent event) {
        if (db.getconnDB()==null){
            return;
            //pop messagebox;
        }
        if (textEditMAID.getText().isEmpty()||
                textEditMVIDMA.getText().isEmpty()||
                textEditMATitle.getText().isEmpty()||
                textEditMAIsWinner.getText().isEmpty()||
                textEditCNameMA.getText().isEmpty()||
                textEditCYearMA.getText().isEmpty()) {
            return;
        }
        if (db.addMA(textEditMAID.getText(), textEditMVIDMA.getText(), textEditMATitle.getText(), textEditMAIsWinner.getText(), textEditCNameMA.getText(), textEditCYearMA.getText())) {
            System.out.println("A movie award is added/edited.");
        }
    }
    
    @FXML
    private void handleButtonDelMAAction(ActionEvent event) {
        if (db.getconnDB()==null){
            return;
            //pop messagebox;
        }
        if (textEditMAID.getText().isEmpty()) {
            return;
        }
        if (db.delMA(textEditMAID.getText())) {
            System.out.println("A movie award is deleted.");
        }
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
