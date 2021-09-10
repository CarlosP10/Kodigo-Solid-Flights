package com.kodigo.models;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileExplorer {

    private String message;
    private int selectionMode;
    private FileNameExtensionFilter filter;
    private boolean isNeededToOpenAFile;

    public FileExplorer (boolean isNeededToOpenAFile) {
        this.isNeededToOpenAFile = isNeededToOpenAFile;
    }

    public String getPath () {
        String filePath;

        JFileChooser chooser = new JFileChooser();

        chooser.setCurrentDirectory(new java.io.File(System.getProperty("user.home")));
        setFileExplorerDetails(this.isNeededToOpenAFile);

        chooser.setDialogTitle(this.message);
        chooser.setFileSelectionMode(this.selectionMode);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileFilter(this.filter);

        if (hasAFileBeenSelected(chooser)) {
            filePath = chooser.getSelectedFile().toString();
            return filePath;
        }
        return null;
    }

    private boolean hasAFileBeenSelected(JFileChooser chooser) {
        return chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION;
    }

    private void setFileExplorerDetails (boolean isNeededToOpenAFile) {
        this.message = "Pick The Excel File you Wish to Insert";
        this.selectionMode = 0;

        //Filter Details
        final String FILE_TYPE_DESCRIPTION = "Excel Files (.xlsx) ";
        final String EXCEL_FILE_EXTENSION = ".xlsx";
        final String EXCEL_FILE_EXTENSION_ALTERNATIVE = "xlsx";
        //Filter Details

        this.filter = new FileNameExtensionFilter(FILE_TYPE_DESCRIPTION, EXCEL_FILE_EXTENSION, EXCEL_FILE_EXTENSION_ALTERNATIVE);

        if (!isNeededToOpenAFile) {
            this.message = "Please select the folder to save the file";
            this.selectionMode = 1;
            this.filter = null;
        }
    }

}
