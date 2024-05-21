import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
/*
 * Author- Shuvaranjan Sarkar
 */
public class Gui implements ActionListener {
    // global
    // Main Window
    JFrame window;
    // TextArea
    JTextArea textArea;
    JScrollPane scrollPane;
    // Icon
    ImageIcon icon;
    // Top Menubar
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor, menuAbout;
    // Files Menu Item
    JMenuItem dNew, dOpen, dSave, dSaveAS, dPrint, dExit;
    // Format Menu items
    JMenuItem iwrap, iFontArial, iFontCalibri, iFontTimes_New_Roman, iFontSize8, iFontSize12, iFontSize16, iFontSize20,
            iFontSize24, iFontSize28;
    JMenu menuFont, menuFontSize;

    // colors menu item
    JMenuItem iColor1, iColor2, iColor3, iColor4, iColor5;

    // edit
    JMenuItem iundo, iredo;

    // About Section
    JMenuItem about;

    boolean wordWrapOn = false;

    FunctionFile file = new FunctionFile(this);
    FunctionFormat functionFormat = new FunctionFormat(this);
    FunctionColor functionColor = new FunctionColor(this);
    FunctionEdit functionEdit = new FunctionEdit(this);
    FunctionAbout functionAbout = new FunctionAbout(this);
    Keyhandler keyhandler = new Keyhandler(this);
    // undo and redo
    UndoManager undoManager = new UndoManager();

    public Gui() {
        // calling all method
        createWindow();
        createtextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();
        createColorMenu();
        createEditMenu();
        createAboutMenu();
        // set default font and size
        functionFormat.selectedFont = "Arial";
        functionFormat.createFont(12);

        // functionFormat.wordWrap();
        window.setVisible(true);

    }

    // define the method
    public void createWindow() {

        window = new JFrame("Notepad Application");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        icon = new ImageIcon(getClass().getResource("Images/icons8-note-50.png"));
        window.setIconImage(icon.getImage());

    }

    // define thetextArea Method which help us to write our text
    public void createtextArea() {
        textArea = new JTextArea();
        textArea.setBackground(new Color(31,31,31));
        textArea.setBorder(BorderFactory.createMatteBorder(10, 10, 25, 10, new Color(31,31,31)));
        textArea.setForeground(Color.white);
        textArea.addKeyListener(keyhandler);
        // undo, redo manager apply
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {

            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setBorder(BorderFactory.createMatteBorder(0, 0, 25, 0, new Color(74, 74, 74)));
        window.add(scrollPane);

    }

    // create a method menubar
    public void createMenuBar() {
        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(74, 74, 74));
        menuBar.setBorder(BorderFactory.createEmptyBorder());
        window.setJMenuBar(menuBar);

        // File
        menuFile = new JMenu("File");
        menuFile.setForeground(Color.WHITE);
        menuBar.add(menuFile);

        // Edit
        menuEdit = new JMenu("Edit");
        menuEdit.setForeground(Color.WHITE);
        menuBar.add(menuEdit);

        // Format
        menuFormat = new JMenu("Format");
        menuFormat.setForeground(Color.WHITE);
        menuBar.add(menuFormat);

        // Color
        menuColor = new JMenu("Color");
        menuColor.setForeground(Color.WHITE);
        menuBar.add(menuColor);

        // About
        menuAbout = new JMenu("About");
        menuAbout.setForeground(Color.WHITE);
        menuBar.add(menuAbout);

    }

    private void createFileMenu() {
        dNew = new JMenuItem("New              (Ctrl+N)");
        dNew.addActionListener(this);
        dNew.setActionCommand("New");
        menuFile.add(dNew);

        dOpen = new JMenuItem("Open              (Ctrl+O)");
        dOpen.addActionListener(this);
        dOpen.setActionCommand("Open");
        menuFile.add(dOpen);

        dSave = new JMenuItem("Save              (Ctrl+S)");
        dSave.addActionListener(this);
        dSave.setActionCommand("Save");
        menuFile.add(dSave);

        dSaveAS = new JMenuItem("Save As       (Shift+Ctrl+S)");
        dSaveAS.addActionListener(this);
        dSaveAS.setActionCommand("Save As");
        menuFile.add(dSaveAS);

        dPrint = new JMenuItem("Print              (Ctrl+P)");
        dPrint.addActionListener(this);
        dPrint.setActionCommand("Print");
        menuFile.add(dPrint);

        dExit = new JMenuItem("Exit                    (Esc)");
        dExit.addActionListener(this);
        dExit.setActionCommand("Exit");
        menuFile.add(dExit);
    }

    // create a method to create format menu
    private void createFormatMenu() {
        iwrap = new JMenuItem("Word Wrap: off");
        iwrap.addActionListener(this);
        iwrap.setActionCommand("Word Wrap");
        menuFormat.add(iwrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        // Font- Arial
        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        // Font- Calibri
        iFontCalibri = new JMenuItem("Comic Sans MS");
        iFontCalibri.setActionCommand("Comic Sans MS");
        iFontCalibri.addActionListener(this);
        menuFont.add(iFontCalibri);

        // Font- Times New Roman
        iFontTimes_New_Roman = new JMenuItem("Times New Roman");
        iFontTimes_New_Roman.addActionListener(this);
        iFontTimes_New_Roman.setActionCommand("Times New Roman");
        menuFont.add(iFontTimes_New_Roman);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("Size8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("Size12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("Size16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("Size20");
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("Size24");
        menuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("Size28");
        menuFontSize.add(iFontSize28);

    }

    public void createColorMenu() {
        iColor1 = new JMenuItem("White");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");
        menuColor.add(iColor1);

        iColor2 = new JMenuItem("Green");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Green");
        menuColor.add(iColor2);

        iColor3 = new JMenuItem("Blue");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("#2700FF");
        menuColor.add(iColor3);

        iColor4 = new JMenuItem("Red");
        iColor4.addActionListener(this);
        iColor4.setActionCommand("#FF0000");
        menuColor.add(iColor4);

        iColor4 = new JMenuItem("Black");
        iColor4.addActionListener(this);
        iColor4.setActionCommand("new Color(31, 31, 31)");
        menuColor.add(iColor4);

    }

    public void createEditMenu() {
        iundo = new JMenuItem("Undo     (Ctrl+Z)");
        iundo.addActionListener(this);
        iundo.setActionCommand("Undo");
        menuEdit.add(iundo);

        iredo = new JMenuItem("Redo     (Ctrl+Y)");
        iredo.addActionListener(this);
        iredo.setActionCommand("Redo");
        menuEdit.add(iredo);
    }

    public void createAboutMenu() {
        about = new JMenuItem("About    (Ctrl+J)");
        about.addActionListener(this);
        about.setActionCommand("About");
        menuAbout.add(about);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New":
                file.newFile();
                break;

            case "Open":
                file.newOpen();
                break;
            case "Save":
                file.newSave();
                break;
            case "Save As":
                file.saveAs();
                break;
            case "Print":
                file.Print();
                break;
            case "Exit":
                file.exit();
                break;
            case "Word Wrap":
                functionFormat.wordWrap();
                break;
            case "Arial":
                functionFormat.setFont(command);
                break;
            case "Comic Sans MS":
                functionFormat.setFont(command);
                break;
            case "Times New Roman":
                functionFormat.setFont(command);
                break;
            case "Size8":
                functionFormat.createFont(8);
                break;
            case "Size12":
                functionFormat.createFont(12);
                break;
            case "Size16":
                functionFormat.createFont(16);
                break;
            case "Size20":
                functionFormat.createFont(20);
                break;
            case "Size24":
                functionFormat.createFont(24);
                break;
            case "Size28":
                functionFormat.createFont(28);
                break;
            case "White":
                functionColor.changeColor(command);
                break;
            case "Green":
                functionColor.changeColor(command);
                break;
            case "#2700FF":
                functionColor.changeColor(command);
                break;
            case "#FF0000":
                functionColor.changeColor(command);
                break;
            case "new Color(31, 31, 31)":
                functionColor.changeColor(command);
                break;
            case "Undo":
                functionEdit.undo();
                break;
            case "Redo":
                functionEdit.redo();
                break;
            case "About":
                functionAbout.About();
                break;

        }
    }

}
