/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author admin
 */
public class Booking {
    private int ID;
    private int userID;
    private String reservationCode;
    private int flight1ID;
    private int flight2ID;
    private String timeBook;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    public int getFlight1ID() {
        return flight1ID;
    }

    public void setFlight1ID(int flight1ID) {
        this.flight1ID = flight1ID;
    }

    public int getFlight2ID() {
        return flight2ID;
    }

    public void setFlight2ID(int flight2ID) {
        this.flight2ID = flight2ID;
    }

  

    public String getTimeBook() {
        return timeBook;
    }

    public void setTimeBook(String timeBook) {
        this.timeBook = timeBook;
    }
    
}
