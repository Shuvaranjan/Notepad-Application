import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ViewportLayout;

/*
 * Author- Shuvaranjan Sarkar
 */
public class FunctionAbout extends JDialog{
    Gui gui;

    public FunctionAbout(Gui gui) {
        this.gui = gui;
    }

    public void About() {
        // JDialog frame = new JDialog();
        setTitle("About Notepad");
        setBounds(400, 100, 600, 500);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
   
        ImageIcon icon = new ImageIcon(getClass().getResource("Images/icons8-note-50.png"));
        setIconImage(icon.getImage());
        ImageIcon img = new ImageIcon(getClass().getResource("Images/icons8-windows-11-144.png"));
        JLabel setimg = new JLabel(img);
        setimg.setBounds(0, 0, 600, 100);
        add(setimg);

        JLabel lbvl1 = new JLabel("Windows 11");
        lbvl1.setBounds(260, 80, 120, 50);
        lbvl1.setFont(new Font("Arial", Font.BOLD, 16));
        add(lbvl1);

        JLabel headerLinLabel = new JLabel(
                "________________________________________________________________________________________________________________");
        headerLinLabel.setBounds(30, 120, 520, 20);
        add(headerLinLabel);

        ImageIcon icon2 = new ImageIcon("Application/src/Images/icons8-notepad-50.png");
        JLabel notepad = new JLabel(icon2);
        notepad.setBounds(0, 120, 100, 100);
        notepad.setForeground(Color.BLACK);
        add(notepad);

        JLabel lbvl2 = new JLabel(/*
                                   * "<html><body>Microsoft Windows<br>Version 22H2 (OS Build)<br>© Microsoft Corporation, All rights reserved.<br><br>The Windows 11 Home Single Language operating system and it's user interface are used by Core Java.<br><br>This product is licensed under the</body></html>"
                                   */
                "<html>" +
                        "<body>" +
                        "<b>Microsoft Windows</b>" +
                        "<br>Version 22H2 (OS Build 19045_3086)<br>© Microsoft Corporation, All rights reserved.<br><br>The Windows 11 Home Single Language operating system and<br>"
                        +
                        "it's user interface are used by Core Java.<br><br>This product is licensed under the <u style='color:blue;'>Micrsoft Software License <br>Terms</u> to:"
                        +
                        "<br>" +
                        " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Windows User" +
                        "</body>" +
                        "</html>"

        );

        lbvl2.setBounds(80, 90, 520, 350);
        lbvl2.setFont(new Font("Calibri", Font.PLAIN, 18));
        add(lbvl2);

        JButton button = new JButton("OK");
        button.setBounds(480, 420, 80, 25);
        button.setBackground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        button.setForeground(Color.BLACK);

        button.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.decode("#EFEFEF"));
                button.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
                button.setBackground(Color.WHITE);
            }

        });
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                FunctionAbout.this.dispose();

            }

        });
        add(button);

    }

}
