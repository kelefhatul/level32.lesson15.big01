package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

/**
 * Created by root on 12/1/2016.
 */
public class TextEditMenuListener implements MenuListener {
    private View view;


    public TextEditMenuListener(View view){
        this.view = view;
    }
    @Override
    public void menuSelected(MenuEvent e) {
        //13.3.1
        JMenu menu = (JMenu) e.getSource();
        Component[] comp = menu.getMenuComponents(); //13.3.2
        //13.3.3
        for (Component curItem : comp
             ) {
            curItem.setEnabled(view.isHtmlTabSelected());
        }
        

    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
