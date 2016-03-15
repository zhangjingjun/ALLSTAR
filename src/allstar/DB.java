package allstar;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jingjunzhang
 */
public class DB {
    private static DB database = null; 
    private ArrayList<Star> starList = new ArrayList<>();
    private ArrayList<Movie> movieList = new ArrayList<>();
    private Connection connDB;
    
    protected DB() {
        
    }
    
    public static DB getDBInstance () {
        if (database == null) {
            database = new DB();
        }
        return database;
    }
    
    public Boolean connectDB (String urlDB, String username, String password) throws SQLException {
        connDB = DriverManager.getConnection(urlDB, username, password);
        return connDB.isValid(0);
    }
    
    public Connection getconnDB () {
        return this.connDB;
    }
    
    private String generateStarQuery (String fName, 
                                      String lName, 
                                      String dob, 
                                      String gender, 
                                      String nation, 
                                      String age,
                                      String starsIn,
                                      String awardS,
                                      String awardYS) {
        String finalQuery;
        String queryCommand = "SELECT DISTINCT P.PID, P.FirstName, P.LastName, P.DoB, P.Gender, P.Nationality, P.Age FROM Person P";
        String queryCondition = " WHERE";
        if (starsIn.trim().length()!=0){
            queryCommand = queryCommand.concat(", Participate PT, Movie M");
            queryCondition = queryCondition.concat(" P.PID=PT.PID AND PT.MVID=M.MVID AND M.MName='" + starsIn + "' AND");
        }
        if ((awardYS.trim().length()!=0)&&(awardS.trim().length()!=0)) {
            queryCommand = queryCommand.concat(", PAward PA, Ceremony C");
            queryCondition = queryCondition.concat(" P.PID=PA.PID AND PA.CID=C.CID AND PA.PTitle='" + awardS + "' AND C.CYear=" + awardYS + " AND");
        } else if (awardYS.trim().length()!=0){
            queryCommand = queryCommand.concat(", PAward PA, Ceremony C");
            queryCondition = queryCondition.concat(" P.PID=PA.PID AND PA.CID=C.CID AND C.CYear=" + awardYS + " AND");        
        } else if (awardS.trim().length()!=0) {
            queryCommand = queryCommand.concat(", PAward PA");
            queryCondition = queryCondition.concat(" P.PID=PA.PID AND PA.PTitle='" + awardS + "' AND");
        }
        
        if (fName.trim().length()!=0){
            queryCondition = queryCondition.concat(" P.FirstName='"+ fName +"' AND");
        }
        if (lName.trim().length()!=0){
            queryCondition = queryCondition.concat(" P.LastName='"+ lName +"' AND");
        }
        if (dob.trim().length()!=0){
            queryCondition = queryCondition.concat(" P.DoB='"+ dob +"' AND");
        }
        if (gender.trim().length()!=0){
            queryCondition = queryCondition.concat(" P.Gender='"+ gender +"' AND");
        }
        if (nation.trim().length()!=0){
            queryCondition = queryCondition.concat(" P.Nationality='"+ nation +"' AND");
        }
        if (age.trim().length()!=0){
            queryCondition = queryCondition.concat(" P.Age="+ age +" AND");
        }
        
        finalQuery = queryCommand.concat(queryCondition);
        finalQuery = finalQuery.substring(0, finalQuery.lastIndexOf(" AND")).concat(";");
        
        System.out.println(finalQuery);
        
        return finalQuery;
    }
    
    public ArrayList<Star> getStarResult (String fName, 
                                          String lName, 
                                          String dob, 
                                          String gender, 
                                          String nation, 
                                          String age,
                                          String starsIn,
                                          String awardS,
                                          String awardYS
                                          ) throws SQLException {
        try {
            String starSearchQuery = generateStarQuery(fName, lName, dob, gender, nation, age, starsIn, awardS, awardYS);
            Statement starSearch = connDB.createStatement();
            ResultSet starResult = starSearch.executeQuery(starSearchQuery);
        
            starList.clear();
            
            while (starResult.next()) {
                starList.add(new Star(starResult.getString("PID"), 
                                      starResult.getString("FirstName"), 
                                      starResult.getString("LastName"),
                                      starResult.getString("DoB"),
                                      starResult.getString("Gender"),
                                      starResult.getString("Nationality"),
                                      starResult.getString("Age"),
                                      "", "", "", ""));
                
            }
            
            PreparedStatement starMovieState = connDB.prepareStatement("SELECT M.MName, PT.Role FROM Person P, Participate PT, Movie M WHERE P.PID=PT.PID AND PT.MVID=M.MVID AND P.PID=?;");
            PreparedStatement starAwardState = connDB.prepareStatement("SELECT PA.PTitle, PA.PIsWinner, C.CName, C.CYear FROM Person P, PAward PA, Ceremony C WHERE P.PID=PA.PID AND PA.CID=C.CID AND P.PID=?;");
                   
            for (Star s: starList) {
                starMovieState.setInt(1, Integer.parseInt(s.getPid()));
                //System.out.println(starMovieState.toString());
                ResultSet starMovies = starMovieState.executeQuery();
                while (starMovies.next()) {
                    if (starMovies.getString("Role").contains("Director")) {
                        s.setDirects(s.getDirects().concat(starMovies.getString("MName") + " "));
                    } else if (starMovies.getString("Role").contains("Act")) {
                        s.setStarsIn(s.getStarsIn().concat(starMovies.getString("MName") + " "));
                    }
                }
                
                starAwardState.setInt(1, Integer.parseInt(s.getPid()));
                //System.out.println(starAwardState.toString());
                ResultSet starAwards = starAwardState.executeQuery();
                while (starAwards.next()){
                    s.setAwardS(s.getAwardS().concat(starAwards.getString("PTitle") + " " + starAwards.getString("PIsWinner") + " in " +starAwards.getString("CName") + " " + starAwards.getString("CYear") + " "));
                    s.setAwardYS(s.getAwardYS().concat(starAwards.getString("CYear") + " "));
                }
            
            }       
            
            for (Star s : starList) {
                System.out.println(s.getPid() + " " + s.getFName() + " " + s.getLName() + " " + s.getStarsIn() + " " + s.getDirects() + " " + s.getAwardS() + " " + s.getAwardYS());
            }
            
            
            
        }
        catch (SQLException e) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        
        return starList;
    }

    
    private String generateMovieQuery (   String title, 
                                          String year, 
                                          String genres, 
                                          String lang, 
                                          String studio, 
                                          String rating,
                                          String stars,
                                          String awardM,
                                          String awardYM){
        String finalQuery;
        String queryCommand = "SELECT DISTINCT M.MVID, M.MName, M.MYear, M.Genres, M.Language M.Rating FROM MOVIE M";
        String queryCondition = " WHERE";
        
        //adding tables and conditions;
        
        finalQuery = queryCommand.concat(queryCondition);
        finalQuery = finalQuery.substring(0, finalQuery.lastIndexOf(" AND")).concat(";");
        
        System.out.println(finalQuery);
        
        return finalQuery;
    }
    
    
    public ArrayList<Movie> getMovieResult (String title, 
                                            String year, 
                                            String genres, 
                                            String lang, 
                                            String studio, 
                                            String rating,
                                            String stars,
                                            String awardM,
                                            String awardYM
                                          ) {
    
    
        
        return movieList;
    }    
    
}
