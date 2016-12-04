package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by root on 12/4/2016.
 */
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) return true;
        if (!f.isDirectory()) {
            if (f.getName().toLowerCase().endsWith(".html") || f.getName().toLowerCase().endsWith(".htm")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
