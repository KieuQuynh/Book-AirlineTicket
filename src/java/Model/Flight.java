/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DB.CityDAO;
import java.sql.Date;

/**
 *
 * @author admin
 */
public class Flight {
    private int ID;
    private String fromCity;
    private String toCity;
    private String depart;
    private String arrival;
    private String roundTime;
    private float price;
    private Date dateFlight;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

  

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public Date getDateFlight() {
        return dateFlight;
    }

    public void setDateFlight(Date dateFlight) {
        this.dateFlight = dateFlight;
    }

    public String getRoundTime() {
        return roundTime;
    }

    public void setRoundTime(String roundTime) {
        this.roundTime = roundTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String toString(){
        return this.fromCity +" to " +this.toCity +"--"+ this.dateFlight;
    }
    
     
    public City FromCity(){
        CityDAO db = new CityDAO();
        return db.getCity(Integer.parseInt(this.getFromCity()));
    }
    
    public City ToCity(){
        CityDAO db = new CityDAO();
        return db.getCity(Integer.parseInt(this.getToCity()));
    }
    
    
}
