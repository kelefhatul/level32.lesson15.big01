package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by root on 11/30/2016.
 */
public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane(); //panel with two tabs
    private JTextPane htmlTextPane = new JTextPane(); //component for visual html redacting
    private JEditorPane plainTextPane = new JEditorPane(); //component for text html redacting

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
        initGui(); //4.3.1
        //4.3.2
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        //4.3.3
        setVisible(true);


    }
    //4.1 start
    public void initMenuBar(){

    }

    public void initEditor(){

    }
    //4.1 end
    //4.2
    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }


    public void selectedTabChanged() {

    }
}