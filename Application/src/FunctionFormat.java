import java.awt.Font;

import javax.swing.border.MatteBorder;

public class FunctionFormat {
    Gui gui;
    Font arial, calibri, timesNewRoman;
    String selectedFont;

    public FunctionFormat(Gui gui) {
        this.gui = gui;
    }

    // wordwrap method
    public void wordWrap() {
        if (gui.wordWrapOn == false) {
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.iwrap.setText("Word Wrap: On");

        } else {
            gui.wordWrapOn = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iwrap.setText("Word Wrap: Off");
        }
    }

    // font type
    public void createFont(int fontSize) {
        arial = new Font("Arial", Font.PLAIN, fontSize);
        calibri = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFont(selectedFont);

    }

    // set font type
    public void setFont(String font) {
        selectedFont = font;
        switch (selectedFont) {
            case "Arial":
                gui.textArea.setFont(arial);
                break;

            case "Comic Sans MS":
                gui.textArea.setFont(calibri);
                break;

            case "Times New Roman":
                gui.textArea.setFont(timesNewRoman);
                break;

        }
    }

  

    //
}
