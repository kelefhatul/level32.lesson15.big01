package com.javarush.test.level32.lesson15.big01;

import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

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

    //16
    public void setPlainText(String text){
        resetDocument(); //16.1
        StringReader stringReader = new StringReader(text); //16.2
        //16.3
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            try {
                htmlEditorKit.read(stringReader, document, 0);
            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }
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