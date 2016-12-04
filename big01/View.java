package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;
import com.javarush.test.level32.lesson15.big01.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
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

    private UndoManager undoManager = new UndoManager(); //11.1
    private UndoListener undoListener = new UndoListener(undoManager);//11.4


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
        //9.1.1 + 9.1.2
        JMenuBar jMenuBar = new JMenuBar();

        MenuHelper.initFileMenu(this,jMenuBar);
        MenuHelper.initEditMenu(this,jMenuBar);
        MenuHelper.initStyleMenu(this,jMenuBar);
        MenuHelper.initAlignMenu(this,jMenuBar);
        MenuHelper.initColorMenu(this,jMenuBar);
        MenuHelper.initFontMenu(this,jMenuBar);
        MenuHelper.initHelpMenu(this,jMenuBar);
        //9.1.3
        getContentPane().add(jMenuBar,BorderLayout.NORTH);
    }
    //9.2
    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        } catch (InstantiationException e) {
            ExceptionHandler.log(e);
        } catch (IllegalAccessException e) {
            ExceptionHandler.log(e);
        } catch (UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);
        }

    }

    public void initEditor(){
        //6.1
        htmlTextPane.setContentType("text/html");
        //6.2 - 6.3
        tabbedPane.addTab("HTML", new JScrollPane(htmlTextPane));
        //6.4 - 6.5
        tabbedPane.addTab("Текст", new JScrollPane(plainTextPane));
        //6.6
        tabbedPane.setPreferredSize(new Dimension(500,500));
        //6.7
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        //6.8
        getContentPane().add(tabbedPane, BorderLayout.CENTER);

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
    public boolean canUndo(){
        return undoManager.canUndo();  //11.5.3
    }
    public boolean canRedo(){
        return undoManager.canRedo(); //11.5.3
    }
    //11.5.4
    public UndoListener getUndoListener() {
        return undoListener;
    }

    //11.5.1
    public void undo(){
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            ExceptionHandler.log(e);
        }
    }
    //11.5.2
    public void redo(){
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            ExceptionHandler.log(e);
        }
    }
    public void resetUndo(){
        try {
            undoManager.discardAllEdits();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }
    //13.1
    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex() == 0;
    }
    //14.1
    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0); //14.1.1
        resetUndo();

    }
    //14.3
    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }
    //14.4
    public void showAbout(){
        JOptionPane.showMessageDialog(this, "text1", "text2", JOptionPane.INFORMATION_MESSAGE);
    }
}