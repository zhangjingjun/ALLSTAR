package allstar;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    private ArrayList<Integer> sidFullList = new ArrayList<> ();
    private ArrayList<Integer> midFullList = new ArrayList<> ();
    private ArrayList<ChartData> chartStarList = new ArrayList<> ();
    private ArrayList<ChartData> chartMovieList = new ArrayList<> ();
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
        getSidFullList();
        getMidFullList();
        return connDB.isValid(0);
    }
    
    public Connection getconnDB () {
        return this.connDB;
    }
    
    private void getSidFullList () {
        try {
            Statement getSidFullState = connDB.createStatement();
            ResultSet getSidFullResult = getSidFullState.executeQuery("SELECT P.PID FROM Person P;");
            sidFullList.clear();
            while (getSidFullResult.next()) {
                sidFullList.add(getSidFullResult.getInt("PID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void getMidFullList () {
        try {
            Statement getMidFullState = connDB.createStatement();
            ResultSet getMidFullResult = getMidFullState.executeQuery("SELECT M.MVID FROM Movie M;");
            midFullList.clear();
            while (getMidFullResult.next()) {
                midFullList.add(getMidFullResult.getInt("MVID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Integer getAge (String bDay) {
        Integer age;
        //check format of bDay;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(Calendar.getInstance().getTime());
        
        String [] bList = bDay.split("-");
        String [] tList = today.split("-");
        age = Integer.parseInt(tList[0])-Integer.parseInt(bList[0]);
        
        if (Integer.parseInt(tList[1])<Integer.parseInt(bList[1])) {
            age--;
        } else if ((Integer.parseInt(tList[1])==Integer.parseInt(bList[1]))&&(Integer.parseInt(tList[2])<Integer.parseInt(bList[2]))) {
            age--;
        }
        
        return age;
    }
    
    private Integer getSid (String sName) {
        Integer sid=-1;
        try {
            Statement getSidState = connDB.createStatement();
            ResultSet sidResult = getSidState.executeQuery("SELECT S.SID FROM Studio S WHERE S.SName='" + sName + "';");
            if (sidResult.next()) {
                sid = sidResult.getInt("SID");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sid;
    }
    
    private Integer createStudio (String sName) {
        Integer sid=-1;
        try {
            Statement createStudioState = connDB.createStatement();
            sid=createStudioState.executeUpdate("INSERT INTO Studio (SName, Country) VALUES ('" + sName+ "', 'US');");
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sid;
        
    }
    
    private Integer getCid (String ceremony, String year) {
        Integer cid=-1;
        try {
            Statement getCidState = connDB.createStatement();
            ResultSet cidResult = getCidState.executeQuery("SELECT C.CID FROM Ceremony C WHERE C.CName='" + ceremony + "' AND C.CYear='" + year + "';");
            if (cidResult.next()) {
                cid = cidResult.getInt("CID");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cid;
        
    }
    
    private Integer createCeremony (String ceremony, String year) {
        Integer cid = -1;
        try {
            Statement createCeremonyState = connDB.createStatement();
            cid = createCeremonyState.executeUpdate("INSERT INTO Ceremony (CName, CYear) VALUES ('" + ceremony+ "', '" + year + "');");
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cid;
    } 
    
    private Boolean existPT (String pid, String mvid, String role) {
        Boolean exist = false;
        try {
            Statement checkPTState = connDB.createStatement();
            ResultSet ptResult = checkPTState.executeQuery("SELECT COUNT(*) FROM Participate PT WHERE PT.PID='" + pid + "' AND PT.MVID='" + mvid + "' AND PT.Role='" + role +  "';");
            if (ptResult.next()) {
                if (ptResult.getInt("COUNT(*)")==1) {
                exist = true;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return exist;
    }
    
    private Boolean existPA (String paid) {
        Boolean exist = false;
        try {
            Statement checkPAState = connDB.createStatement();
            ResultSet paResult = checkPAState.executeQuery("SELECT COUNT(*) FROM PAward PA WHERE PA.PAID='" + paid + "';");
            if (paResult.next()) {
                if (paResult.getInt("COUNT(*)")==1) {
                exist = true;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exist;
    }
    
    private Boolean existMA (String maid) {
        Boolean exist = false;
        try {
            Statement checkMAState = connDB.createStatement();
            ResultSet maResult = checkMAState.executeQuery("SELECT COUNT(*) FROM MAward MA WHERE MA.MAID='" + maid + "';");
            if (maResult.next()) {
                if (maResult.getInt("COUNT(*)")==1) {
                exist = true;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exist;
    }
    
    public Boolean addStar (String pid, String fName, String lName, String gender, String dob, String nation) {
        Boolean success = false;
        int temp;
        try {
           
            Statement editStarState = connDB.createStatement();
            
            if (sidFullList.contains(Integer.parseInt(pid))) {
                temp = editStarState.executeUpdate("UPDATE Person SET FirstName='" + fName + "', LastName='" + lName + "', Gender='" + gender + "', DoB='"  + dob + "', Nationality='" + nation + "', Age='" + getAge(dob) + "' WHERE PID=" + pid+ ";");
                if (temp==1) success=true;
            } else {
                
                temp = editStarState.executeUpdate("INSERT INTO Person VALUES (" + pid + ", '" + fName + "', '" + lName + "', '" + gender + "', '" + dob + "', '" + nation + "', '" + getAge(dob) + "');");
                if (temp==1) success=true;
            }
            
            getSidFullList();
            
            return success;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
    
    public Boolean delStar (String pid) {
        Boolean success = false;
        int temp;
        try {
            
            Statement delStarState = connDB.createStatement();
            //check record if the information from user matches
            temp = delStarState.executeUpdate("DELETE FROM Person WHERE PID='" + pid + "';");
            if (temp==1) success=true;
            
            getSidFullList();
            
            return success;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
    
    public Boolean addMovie (String mvid, String title, String year, String genres, String lang, String studio, String rating) {
        Boolean success = false;
        int temp;
        try {
           
            Statement editMovieState = connDB.createStatement();
            
            if (midFullList.contains(Integer.parseInt(mvid))) {
                temp = editMovieState.executeUpdate("UPDATE Movie SET MName='" + title + "', MYear='" + year + "', Genres='" + genres + "', Language='"  + lang + "', SID='" + getSid(studio) + "', Rating='" + rating + "' WHERE MVID=" + mvid+ ";");
                if (temp==1) success=true;
            } else {
                
                temp = editMovieState.executeUpdate("INSERT INTO Movie VALUES (" + mvid + ", '" + title + "', '" + year + "', '" + genres + "', '" + lang + "', '" + getSid(studio) + "', '" + rating + "');");
                if (temp==1) success=true;
            }
            
            getMidFullList();
            
            return success;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
    
    public Boolean delMovie (String mvid) {
        Boolean success = false;
        int temp;
        try {
            
            Statement delMovieState = connDB.createStatement();
            //check record if the information from user matches
            temp = delMovieState.executeUpdate("DELETE FROM Movie WHERE MVID='" + mvid + "';");
            if (temp==1) success=true;
            
            getMidFullList();
            
            return success;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return success;
    }
    
    public Boolean addPT (String pid, String mvid, String role) {
        Boolean success = false;
        int temp;
        try {
            if ( midFullList.contains(Integer.parseInt(mvid)) && sidFullList.contains(Integer.parseInt(pid)) && !existPT(pid, mvid, role)) {
                
                Statement editPTState = connDB.createStatement(); 
                temp = editPTState.executeUpdate("INSERT INTO Participate VALUES ('" + pid + "', '" + mvid + "', '" + role + "');");
                if (temp==1) success=true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return success;
    }
    
    public Boolean delPT (String pid, String mvid, String role) {
        Boolean success = false;
        int temp;
        try {
            if ( midFullList.contains(Integer.parseInt(mvid)) && sidFullList.contains(Integer.parseInt(pid)) && existPT(pid, mvid, role)) {
                Statement delPTState = connDB.createStatement();
                //check record if the information from user matches
                temp = delPTState.executeUpdate("DELETE FROM Participate WHERE MVID='" + mvid + "' AND PID='" + pid + "' AND Role='" + role + "';");
                if (temp==1) success=true;
            }
            return success;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return success;
    }
    
    public Boolean addPA (String paid, String pid, String title, String isWinner, String mvid, String ceremony, String year ) {
        Boolean success = false;
        int temp;
        try {
           
            if (midFullList.contains(Integer.parseInt(mvid)) && sidFullList.contains(Integer.parseInt(pid))) {
                Statement editPAState = connDB.createStatement();
                if (existPA(paid)) {
                    Integer cid = getCid(ceremony, year);
                    if (cid<=0) {
                        createCeremony(ceremony, year);
                        cid = getCid(ceremony, year);
                    }
                    temp = editPAState.executeUpdate("UPDATE PAward SET PAID='" + paid + "', PID='" + pid + "', PTitle='" + title + "', PIsWinner='"  + isWinner + "', MVID='" + mvid + "', CID='" + cid + "' WHERE PAID=" + paid+ ";");
                    if (temp==1) success=true;
                } else {
                    Integer cid = getCid(ceremony, year);
                    if (cid<=0) {
                        createCeremony(ceremony, year);
                        cid = getCid(ceremony, year);
                    }
                    temp = editPAState.executeUpdate("INSERT INTO PAward VALUES (" + paid + ", '" + pid + "', '" + cid + "', '" + title + "', '" + isWinner + "', '" + mvid + "');");
                    if (temp==1) success=true;
                }
            }
            
            return success;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return success;
    }
    
    public Boolean delPA (String paid) {
        Boolean success = false;
        int temp;
        try {
            if (existPA(paid)) {
            Statement delPAState = connDB.createStatement();
            //check record if the information from user matches
            temp = delPAState.executeUpdate("DELETE FROM PAward WHERE PAID='" + paid + "';");
            if (temp==1) success=true;
            }
            return success;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return success;
    }
    
    public Boolean addMA (String maid, String mvid, String title, String isWinner, String ceremony, String year ) {
        Boolean success = false;
        int temp;
        try {
           
            if (midFullList.contains(Integer.parseInt(mvid))) {
                Statement editMAState = connDB.createStatement();
                if (existMA(maid)) {
                    Integer cid = getCid(ceremony, year);
                    if (cid<=0) {
                        createCeremony(ceremony, year);
                        cid = getCid(ceremony, year);
                    }
                    temp = editMAState.executeUpdate("UPDATE MAward SET MVID='" + mvid + "', MTitle='" + title + "', MIsWinner='" + isWinner + "', CID='"  + cid + "' WHERE MAID=" + maid+ ";");
                    if (temp==1) success=true;
                } else {
                    Integer cid = getCid(ceremony, year);
                    if (cid<=0) {
                        createCeremony(ceremony, year);
                        cid = getCid(ceremony, year);
                    }
                    temp = editMAState.executeUpdate("INSERT INTO MAward VALUES (" + maid + ", '" + cid + "', '" + mvid + "', '" + title + "', '" + isWinner + "');");
                    if (temp==1) success=true;
                }
            }
            
            return success;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return success;
    }
    
    public Boolean delMA (String maid ) {
        Boolean success = false;
        try {
            if (existMA(maid)) {
            Statement delMAState = connDB.createStatement();
            //check record if the information from user matches
            int temp = delMAState.executeUpdate("DELETE FROM MAward WHERE MAID='" + maid + "';");
            if (temp==1) success=true;
            }
            return success;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return success;
    }
    
    public ArrayList<ChartData> getStarMostMovie () {
        try {
            Statement getTopStarState = connDB.createStatement();
            ResultSet topResult = getTopStarState.executeQuery("SELECT CONCAT(P.FirstName, ' ', P.LastName) AS Name, COUNT(*) AS Count FROM Person P, Participate PT WHERE P.PID=PT.PID AND PT.Role IN ('Actor', 'Actress') GROUP BY P.PID ORDER BY COUNT(*) DESC LIMIT 10;");
            chartStarList.clear();
            while (topResult.next()) {
                chartStarList.add(new ChartData(topResult.getString("Name"), topResult.getInt("Count")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return chartStarList;
    }
    
    public ArrayList<ChartData> getDirectorMostMovie () {
        try {
            Statement getTopStarState = connDB.createStatement();
            ResultSet topResult = getTopStarState.executeQuery("SELECT CONCAT(P.FirstName, ' ', P.LastName) AS Name, COUNT(*) AS Count FROM Person P, Participate PT WHERE P.PID=PT.PID AND PT.Role='Director' GROUP BY P.PID ORDER BY COUNT(*) DESC LIMIT 10;");
            chartStarList.clear();
            while (topResult.next()) {
                chartStarList.add(new ChartData(topResult.getString("Name"), topResult.getInt("Count")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return chartStarList;
    }
    
    public ArrayList<ChartData> getStarMostAward () {
        try {
            Statement getTopStarState = connDB.createStatement();
            ResultSet topResult = getTopStarState.executeQuery("SELECT CONCAT(P.FirstName, ' ', P.LastName) AS Name, COUNT(*) AS Count FROM Person P, PAward PA WHERE P.PID=PA.PID GROUP BY P.PID ORDER BY COUNT(*) DESC LIMIT 10;");
            chartStarList.clear();
            while (topResult.next()) {
                chartStarList.add(new ChartData(topResult.getString("Name"), topResult.getInt("Count")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return chartStarList;
    }
    
    public ArrayList<ChartData> getMovieHighRated () {
        try {
            Statement getTopMovieState = connDB.createStatement();
            ResultSet topResult = getTopMovieState.executeQuery("SELECT M.MName, M.Rating FROM Movie M ORDER BY M.Rating DESC LIMIT 10;");
            chartMovieList.clear();
            while (topResult.next()) {
                chartMovieList.add(new ChartData(topResult.getString("MName"), topResult.getDouble("Rating")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return chartMovieList;
    }
    
    public ArrayList<ChartData> getMovieMostAward () {
        try {
            Statement getTopMovieState = connDB.createStatement();
            ResultSet topResult = getTopMovieState.executeQuery("SELECT M.MName, COUNT(*) AS Count FROM Movie M, MAward MA WHERE M.MVID=MA.MVID GROUP BY M.MVID ORDER BY COUNT(*) DESC LIMIT 10;");
            chartMovieList.clear();
            while (topResult.next()) {
                chartMovieList.add(new ChartData(topResult.getString("MName"), topResult.getInt("Count")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return chartMovieList;
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
                    
            starList.clear();
            
            if (!connDB.isValid(0)) {
                return starList;
            }
            
            String starSearchQuery = generateStarQuery(fName, lName, dob, gender, nation, age, starsIn, awardS, awardYS);
            Statement starSearch = connDB.createStatement();
            ResultSet starResult = starSearch.executeQuery(starSearchQuery);

            
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
                    s.setAwardS(s.getAwardS().concat(starAwards.getString("PTitle") + " " + starAwards.getString("PIsWinner") + " in " +starAwards.getString("CName") + " " + starAwards.getString("CYear").substring(0, 4) + " "));
                    s.setAwardYS(s.getAwardYS().concat(starAwards.getString("CYear").substring(0, 4) + " "));
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
        String queryCommand = "SELECT DISTINCT M.MVID, M.MName, M.MYear, M.Genres, M.Language, M.Rating FROM MOVIE M";
        String queryCondition = " WHERE";
        
        if (stars.trim().length()!=0){
            String[] sname = stars.trim().split("///s");
            queryCommand = queryCommand.concat(", Participate PT, Person P");
            queryCondition = queryCondition.concat(" P.PID=PT.PID AND PT.MVID=M.MVID AND P.FirstName='" + sname[0] + "' AND P.LastName='" + sname[1] + "' AND");
        }
        if ((awardYM.trim().length()!=0)&&(awardM.trim().length()!=0)) {
            queryCommand = queryCommand.concat(", MAward MA, Ceremony C");
            queryCondition = queryCondition.concat(" M.MVID=MA.MVID AND MA.CID=C.CID AND MA.MTitle='" + awardM + "' AND C.CYear=" + awardYM + " AND");
        } else if (awardYM.trim().length()!=0){
            queryCommand = queryCommand.concat(", MAward MA, Ceremony C");
            queryCondition = queryCondition.concat(" M.MVID=MA.MVID AND MA.CID=C.CID AND C.CYear=" + awardYM + " AND");        
        } else if (awardM.trim().length()!=0) {
            queryCommand = queryCommand.concat(", MAward MA");
            queryCondition = queryCondition.concat(" M.MVID=MA.MVID AND MA.MTitle='" + awardM + "' AND");
        }
        
        if (title.trim().length()!=0){
            queryCondition = queryCondition.concat(" M.MName='"+ title +"' AND");
        }
        if (year.trim().length()!=0){
            queryCondition = queryCondition.concat(" M.MYear='"+ year +"' AND");
        }
        if (genres.trim().length()!=0){
            queryCondition = queryCondition.concat(" M.Genres='"+ genres +"' AND");
        }
        if (lang.trim().length()!=0){
            queryCondition = queryCondition.concat(" M.Language='"+ lang +"' AND");
        }
        if (studio.trim().length()!=0){
            queryCommand = queryCommand.concat(", Studio S");
            queryCondition = queryCondition.concat(" M.SID=S.SID AND S.SName='"+ studio +"' AND");
        }
        if (rating.trim().length()!=0){
            queryCondition = queryCondition.concat(" M.Rating>="+ rating +" AND");
        }
        
        
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
                                          ) throws SQLException {
        try {   
            movieList.clear();
            
            if (!connDB.isValid(0)) {
                return movieList;
            }
            
            String movieSearchQuery = generateMovieQuery(title, year, genres, lang, studio, rating, stars, awardM, awardYM);
            Statement movieSearch = connDB.createStatement();
            ResultSet movieResult = movieSearch.executeQuery(movieSearchQuery);
        
            while (movieResult.next()) {
                movieList.add(new Movie(movieResult.getString("MVID"), 
                                        movieResult.getString("MName"), 
                                        movieResult.getString("MYear").substring(0, 4),
                                        movieResult.getString("Genres"),
                                        movieResult.getString("Language"),
                                        "",
                                        movieResult.getString("Rating"), 
                                        "", //Star
                                        "", //Director
                                        "", ""));    
            }
            PreparedStatement movieStarState = connDB.prepareStatement("SELECT P.FirstName, P.LastName, PT.Role FROM Person P, Participate PT, Movie M WHERE P.PID=PT.PID AND PT.MVID=M.MVID AND M.MVID=?;");
            PreparedStatement movieAwardState = connDB.prepareStatement("SELECT MA.MTitle, MA.MIsWinner, C.CName, C.CYear FROM Movie M, MAward MA, Ceremony C WHERE M.MVID=MA.MVID AND MA.CID=C.CID AND M.MVID=?;");
                      
            for (Movie m: movieList) {
                movieStarState.setInt(1, Integer.parseInt(m.getMid()));
                //System.out.println(starMovieState.toString());
                ResultSet movieStars = movieStarState.executeQuery();
                while (movieStars.next()) {
                    if (movieStars.getString("Role").contains("Director")) {
                        m.setDirector(m.getDirector().concat(movieStars.getString("FirstName") + " " + movieStars.getString("LastName") + ", "));
                    } else if (movieStars.getString("Role").contains("Act")) {
                        m.setStars(m.getStars().concat(movieStars.getString("FirstName") + " " + movieStars.getString("LastName") + ", "));
                    }
                }
                
                movieAwardState.setInt(1, Integer.parseInt(m.getMid()));
                //System.out.println(starAwardState.toString());
                ResultSet movieAwards = movieAwardState.executeQuery();
                while (movieAwards.next()){
                    m.setAwardM(m.getAwardM().concat(movieAwards.getString("MTitle") + " " + movieAwards.getString("MIsWinner") + " in " +movieAwards.getString("CName") + " " + movieAwards.getString("CYear").substring(0, 4) + " "));
                    m.setAwardYM(m.getAwardYM().concat(movieAwards.getString("CYear").substring(0, 4) + " "));
                }
            
            }       
            
            for (Movie m : movieList) {
                System.out.println(m.getMid() + " " + m.getTitle() + " " + m.getYear() + " " + m.getStars() + " " + m.getDirector() + " " + m.getAwardM() + " " + m.getAwardYM());
            }
            
        }
        catch (SQLException e) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, e);
        }
        return movieList;
    }    
    
}
