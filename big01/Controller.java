package com.javarush.test.level32.lesson15.big01;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;

/**
 * Created by root on 11/30/2016.
 */
public class Controller {
    private View view;
    private File currentFile;
    private HTMLDocument document;

    //14.2
    public HTMLDocument getDocument() {
        return document;
    }

    public Controller(View view) {
        this.view = view;
    }

    public void init(){

    }

    public void exit(){   //2.3
        System.exit(0);
    }

    //15
    public void resetDocument(){
        //15.1
        if (document != null){
            document.removeUndoableEditListener(view.getUndoListener());
        }
        //15.2
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        //15.3
        document.addUndoableEditListener(view.getUndoListener());
        //15.4
        view.update();

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