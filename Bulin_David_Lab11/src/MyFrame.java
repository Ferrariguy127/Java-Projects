//David Bulin
//Lab 11
//November 17th 2023

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenu helpMenu;
    JMenuItem newItem;
    JMenuItem saveItem;
    JMenuItem printItem;
    JMenuItem exitItem;
    JMenuItem NewWindow;
    JMenuItem undoItem;
    JMenuItem cutItem;
    JMenuItem copyItem;
    JMenuItem pasteItem;
    JMenuItem deleteItem;
    JMenuItem aboutNotepad;

    MyFrame(){
        this.setTitle("Lab11!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(new FlowLayout());

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        newItem = new JMenuItem("New");
        saveItem = new JMenuItem("Save");
        printItem = new JMenuItem("Print");
        exitItem = new JMenuItem("Exit");
        NewWindow = new JMenuItem("New Window");

        undoItem = new JMenuItem("Undo");
        cutItem = new JMenuItem("Cut");
        copyItem = new JMenuItem("Copy");
        pasteItem = new JMenuItem("Paste");
        deleteItem = new JMenuItem("Delete");

        aboutNotepad = new JMenuItem("About Notepad");

        newItem.addActionListener(this);
        saveItem.addActionListener(this);
        printItem.addActionListener(this);
        exitItem.addActionListener(this);
        NewWindow.addActionListener(this);

        undoItem.addActionListener(this);
        cutItem.addActionListener(this);
        copyItem.addActionListener(this);
        pasteItem.addActionListener(this);
        deleteItem.addActionListener(this);
        aboutNotepad.addActionListener(this);

        fileMenu.add(newItem);
        fileMenu.add(NewWindow);
        fileMenu.add(saveItem);
        fileMenu.add(printItem);
        fileMenu.add(exitItem);

        editMenu.add(undoItem);
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.add(deleteItem);

        helpMenu.add(aboutNotepad);


        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==newItem) {
            JOptionPane.showMessageDialog(null,"You created a new file");
        }
        if(e.getSource()==saveItem) {
            JOptionPane.showMessageDialog(null,"You have successfully saved a file");
        }
        if(e.getSource()==printItem) {
            JOptionPane.showMessageDialog(null,"Successfully printed");
        }
        if(e.getSource()==exitItem) {
            JOptionPane.showMessageDialog(null,"Exited the Item");
        }
        if (e.getSource()==NewWindow){
            LaunchPage LaunchPage = new LaunchPage();
        }
        if(e.getSource()==undoItem) {
            JOptionPane.showMessageDialog(null,"Nobody saw that mistake, it didn't happen.");
        }
        if(e.getSource()==cutItem) {
            JOptionPane.showMessageDialog(null,"The selected item has been cut.");
        }
        if(e.getSource()==copyItem) {
            JOptionPane.showMessageDialog(null,"That has been copied");
        }
        if(e.getSource()==pasteItem) {
            JOptionPane.showMessageDialog(null,"This has been pasted all pretty like.");
        }
        if(e.getSource()==deleteItem) {
            LaunchButtonPage LaunchButtonPage = new LaunchButtonPage();
        }
        if (e.getSource()==aboutNotepad) {
            LaunchTextPage LaunchTextPage = new LaunchTextPage();
        }

    }
}
