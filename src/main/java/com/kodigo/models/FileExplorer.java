package com.kodigo.models;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileExplorer {

    public String getPath (String message, int selectionMode, FileNameExtensionFilter filter) {
        //Path to File
        String filePath;

        //New instance of JFileChooser to use file explorer to retrieve path
        JFileChooser chooser = new JFileChooser();

        //Set Default Directory for JFileChooser
        chooser.setCurrentDirectory(new java.io.File(System.getProperty("user.home")));
        //Dialog for window
        chooser.setDialogTitle(message);
        //User can only pick Files or Folders
        chooser.setFileSelectionMode(selectionMode);
        //No "All Files" options available
        chooser.setAcceptAllFileFilterUsed(false);
        //Set a filter if needed
        chooser.setFileFilter(filter);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            //Path from selected file is used
            filePath = chooser.getSelectedFile().toString();
            return filePath;
        }
        return null;
    }

}
