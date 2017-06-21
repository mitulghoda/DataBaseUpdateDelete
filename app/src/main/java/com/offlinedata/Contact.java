package com.offlinedata;

/**
 * Created by abc on 01-06-2017.
 */
public class Contact {

    //private variables
    int _id;
    String _name;


    String client_id;
    String image;

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    String homework;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // Empty constructor
    public Contact(){

    }
    // constructor
    public Contact(int id, String name,String image,String homework, String client_id){
        this._id = id;
        this._name = name;
        this.image = image;
        this.homework = homework;
        this.client_id = client_id;
    }

    // constructor
    public Contact(String name,String image, String homework,String client_id){
        this._name = name;
        this.image = image;
        this.homework = homework;
        this.client_id = client_id;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting phone number
    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

}
