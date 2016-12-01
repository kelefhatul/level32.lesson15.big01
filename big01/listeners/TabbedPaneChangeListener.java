package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by root on 12/1/2016.
 */
public class TabbedPaneChangeListener implements ChangeListener {
    private View view;
    //5.1.1
    public TabbedPaneChangeListener(View view) {
        this.view = view;
    }



    @Override
    public void stateChanged(ChangeEvent e) {
        //5.1.2
            view.selectedTabChanged();
    }
}
