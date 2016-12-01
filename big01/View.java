package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by root on 11/30/2016.
 */
public class View extends JFrame implements ActionListener {
    private Controller controller;

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void exit(){
        controller.exit();
    }

    public void init(){

    }
}