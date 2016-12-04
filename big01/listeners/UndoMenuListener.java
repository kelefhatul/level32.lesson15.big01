package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * Created by root on 12/1/2016.
 */
public class UndoMenuListener implements MenuListener {
    private View view;
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuItem;

    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem){
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }
    //10.3
    @Override
    public void menuSelected(MenuEvent e) {
        //10.3.1
        if (view.canUndo()){
            undoMenuItem.setEnabled(true);
        }
        else if (!view.canUndo()){
            undoMenuItem.setEnabled(false);
        }

        if (view.canRedo()){
            redoMenuItem.setEnabled(true);
        } else if (!view.canRedo()){
            redoMenuItem.setEnabled(false);
        }
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
