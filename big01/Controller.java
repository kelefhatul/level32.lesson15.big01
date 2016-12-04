package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

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
        //20.2
        createNewDocument();
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

    //17
    public String getPlainText(){
        StringWriter stringWriter = new StringWriter();
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
            htmlEditorKit.write(stringWriter,document,0,document.getLength());
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }

    public void createNewDocument() {
        //20
        view.selectHtmlTab(); //20.1.1
        resetDocument(); //20.1.2
        view.setTitle("HTML редактор"); //20.1.3
        view.resetUndo(); //20.1.4
        currentFile = null; //20.1.5
    }

    public void openDocument() {
    }

    public void saveDocument() {

    }

    public void saveDocumentAs() {
        //22
        view.selectHtmlTab();//22.1
        JFileChooser fileChooser =  new JFileChooser(); //22.2
        fileChooser.setFileFilter(new HTMLFileFilter()); //22.3
        int tmp = fileChooser.showSaveDialog(view); //22.4
        //22.5
        if (tmp == JFileChooser.APPROVE_OPTION){
            currentFile = fileChooser.getSelectedFile(); //22.5.1
            view.setTitle(currentFile.getName()); //22.5.2
            try(FileWriter fileWrite = new FileWriter(currentFile)) { //22.5.3
                HTMLEditorKit editorKit= new HTMLEditorKit();
                try {
                    editorKit.write(fileWrite,document,0,document.getLength());
                } catch (BadLocationException e) {
                    ExceptionHandler.log(e);
                }
            } catch (IOException e) {
                ExceptionHandler.log(e);
            }
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