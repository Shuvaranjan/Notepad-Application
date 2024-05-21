import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

public class FunctionColor {
    Gui gui;
     
    public FunctionColor(Gui gui) {
        this.gui = gui;
        
    }
    public void changeColor(String color){
        switch (color) {
            case "White":
                gui.window.getContentPane().setBackground(Color.WHITE);
                gui.textArea.setBackground(Color.WHITE);
                gui.textArea.setForeground(Color.BLACK);
                gui.textArea.setBorder(BorderFactory.createMatteBorder(10, 10, 25, 10, Color.WHITE));
                break;

            case "Green":
                gui.window.getContentPane().setBackground(Color.GREEN);
                gui.textArea.setBackground(Color.GREEN);
                gui.textArea.setForeground(Color.BLACK);
                gui.textArea.setBorder(BorderFactory.createMatteBorder(10, 10, 25, 10, Color.GREEN));
                break;

            case "#2700FF":
                gui.window.getContentPane().setBackground(Color.decode("#2700FF"));
                gui.textArea.setBackground(Color.decode("#2700FF"));
                gui.textArea.setForeground(Color.WHITE);
                gui.textArea.setBorder(BorderFactory.createMatteBorder(10, 10, 25, 10, Color.decode("#2700FF")));
                break;

            case "#FF0000":
                gui.window.getContentPane().setBackground(Color.decode("#FF0000"));
                gui.textArea.setBackground(Color.decode("#FF0000"));
                gui.textArea.setForeground(Color.WHITE);
                gui.textArea.setBorder(BorderFactory.createMatteBorder(10, 10, 25, 10, Color.decode("#FF0000")));
                break;

            case "new Color(31, 31, 31)":
                gui.window.getContentPane().setBackground(new Color(31, 31, 31));
                gui.textArea.setBackground(new Color(31, 31, 31));
                gui.textArea.setForeground(Color.WHITE);
                gui.textArea.setBorder(BorderFactory.createMatteBorder(10, 10, 25, 10, new Color(31, 31, 31)));
                break;
             
        }

    }
    
}
