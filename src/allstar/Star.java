/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allstar;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author jingjunzhang
 */
public class Star {
    private StringProperty pid;
    private StringProperty fName;
    private StringProperty lName;
    private StringProperty dob;
    private StringProperty gender;
    private StringProperty nation;
    private StringProperty age;
    private StringProperty starsIn;
    private StringProperty directs;
    private StringProperty awardS;
    private StringProperty awardYS;

    public Star(String pid, String fName, String lName, String dob, String gender, String nation, String age, String starsIn, String directs, String awardS, String awardYS) {
        this.pid = new SimpleStringProperty(pid);
        this.fName = new SimpleStringProperty(fName);
        this.lName = new SimpleStringProperty(lName);
        this.dob = new SimpleStringProperty(dob);
        this.gender = new SimpleStringProperty(gender);
        this.nation = new SimpleStringProperty(nation);
        this.age = new SimpleStringProperty(age);
        this.starsIn = new SimpleStringProperty(starsIn);
        this.directs = new SimpleStringProperty(directs);
        this.awardS = new SimpleStringProperty(awardS);
        this.awardYS = new SimpleStringProperty(awardYS);
    }

    public StringProperty pidProperty () {
        return pid;
    }
    
    public String getPid() {
        return pid.get();
    }

    public void setPid(String pid) {
        this.pid.set(pid);
    }

    public StringProperty fNameProperty () {
        return fName;
    }
    
    public String getFName() {
        return fName.get();
    }

    public void setFName(String fName) {
        this.fName.set(fName);
    }

    public StringProperty lNameProperty () {
        return lName;
    }
    
    public String getLName() {
        return lName.get();
    }

    public void setLName(String lName) {
        this.lName.set(lName);
    }

    public StringProperty dobProperty () {
        return dob;
    }
    
    public String getDob() {
        return dob.get();
    }

    public void setDob(String dob) {
        this.dob.set(dob);
    }

    public StringProperty genderProperty () {
        return gender;
    }
    
    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public StringProperty nationProperty () {
        return nation;
    }
    
    public String getNation() {
        return nation.get();
    }

    public void setNation(String nation) {
        this.nation.set(nation);
    }

    public StringProperty ageProperty () {
        return age;
    }
    
    public String getAge() {
        return age.get();
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public StringProperty starsInProperty () {
        return starsIn;
    }
    
    public String getStarsIn() {
        return starsIn.get();
    }

    public void setStarsIn(String starsIn) {
        this.starsIn.set(starsIn);
    }

    public StringProperty directsProperty () {
        return directs;
    }
    
    public String getDirects() {
        return directs.get();
    }

    public void setDirects(String directs) {
        this.directs.set(directs);
    }

    public StringProperty awardSProperty () {
        return awardS;
    }
    
    public String getAwardS() {
        return awardS.get();
    }

    public void setAwardS(String awardS) {
        this.awardS.set(awardS);
    }

    public StringProperty awardYSProperty () {
        return awardYS;
    }
    
    public String getAwardYS() {
        return awardYS.get();
    }

    public void setAwardYS(String awardYS) {
        this.awardYS.set(awardYS);
    }
    
    
    
}
