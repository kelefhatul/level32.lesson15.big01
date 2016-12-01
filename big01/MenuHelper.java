package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by root on 12/1/2016.
 */
public class MenuHelper {

    //7.1
    public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener){
        //7.1.1
        JMenuItem menuItem = new JMenuItem(text);
        //7.1.2
        menuItem.addActionListener(actionListener);
        //7.1.3
        parent.add(menuItem);
        //7.1.4
        return menuItem;
    }

    //7.2
    public static JMenuItem addMenuItem(JMenu parent, Action action){
        JMenuItem newMenuItem = new JMenuItem(action);
        parent.add(newMenuItem);

        return newMenuItem;
    }

    //7.3
    public static JMenuItem addMenuItem(JMenu parent, String text, Action action){
        JMenuItem newMenuItem = addMenuItem(parent,action);
        newMenuItem.setText(text);

        return newMenuItem;
    }
    public static void initHelpMenu(View view, JMenuBar menuBar){ // - инициализация меню помощи.

    }
    public static void initFontMenu(View view, JMenuBar menuBar){ // - инициализация меню выбора

    }
    public static void initColorMenu(View view, JMenuBar menuBar){ // - инициализация меню выбора цвета.

    }
    public static void initAlignMenu(View view, JMenuBar menuBar){ // - инициализация меню выравнивания.

    }

    public static void initStyleMenu(View view, JMenuBar menuBar){ // - инициализация меню выбора стиля текста.

    }

    public static void initEditMenu(View view, JMenuBar menuBar) { // - инициализация меню редактирования текста.

    }
    public static void initFileMenu(View view, JMenuBar menuBar){ // - инициализация меню Файл.

    }
}
