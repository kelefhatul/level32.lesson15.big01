package com.javarush.test.level32.lesson15.big01;

import javax.swing.text.html.HTMLDocument;
import java.io.File;

/**
 * Created by root on 11/30/2016.
 */
public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public void init(){

    }

    public void exit(){   //2.3
        System.exit(0);
    }

    public static void main(String[] args) {
        //2.2.1
        View newView = new View();
        //2.2.2
        Controller newController = new Controller(newView);
        //2.2.3
        newView.setController(newController);
        //2.2.4
        newView.init();
        //2.2.5
        newController.init();



    }
}