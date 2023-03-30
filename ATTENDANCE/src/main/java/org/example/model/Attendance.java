package org.example.model;

public class Attendance {
   int class_id;
   int user_id;
   int present;

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }



    public Attendance(int class_id, int user_id, int present) {
        this.class_id = class_id;
        this.user_id = user_id;
        this.present = present;
    }




    }

