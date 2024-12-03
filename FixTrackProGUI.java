import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class FixTrackProGUI extends JFrame implements ActionListener{
    final int WIDTH = 700;
    final int HEIGHT = 400;

    JPanel header = new JPanel();
    JLabel title = new JLabel("FixTrack Pro");
    JButton menu = new JButton();

    Icon menuIcon = new ImageIcon("menu.png");

    Font headerFont = new Font("SansSerif", Font.BOLD, 34);
    Font subHeaderFont = new Font("SansSerif", Font.BOLD, 25);
    Font textFont = new Font("SansSerif", Font.BOLD, 20);

    JLayeredPane bodyFrame = new JLayeredPane();
    
    JPanel body = new JPanel();

    JPanel menuFrame = new JPanel();

    JButton notification = new JButton("Notification");
    JButton home = new JButton("Home");
    JButton logIn = new JButton("Log in");
    JButton logOut = new JButton("Log out");

    JPanel dashboard = new JPanel();
    JPanel textPanel = new JPanel();
    JLabel text1 = new JLabel("Welcome!");
    JLabel text2 = new JLabel("Choose a service of choice.");
    JPanel buttonChoice = new JPanel();
    JButton repair = new JButton("REPAIR");
    JButton maintenance = new JButton("MAINTENANCE");
    
    JPanel appliancePanel = new JPanel();
    JPanel applianceFrame = new JPanel();
    JButton phone = new JButton();
    JButton computer = new JButton();
    JButton laptop = new JButton();
    JButton tv = new JButton();

    FixTrackProGUI() {        
        SwingUtilities.invokeLater(() -> {
            setSize(WIDTH, HEIGHT);
            setLocationRelativeTo(null);
            setTitle("FixTrack Pro");
            setLayout(new BorderLayout());
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            header.setPreferredSize(new Dimension(WIDTH, 50));
            header.setLayout(new BorderLayout());
            header.setBackground(Color.pink);

            title.setFont(headerFont);

            menu.setIcon(menuIcon);
            header.add(menu, BorderLayout.LINE_END);

            add(header, BorderLayout.PAGE_START);
            menu.setBackground(Color.pink);
            menu.setBorder(BorderFactory.createEmptyBorder(0, 20 ,0 , 20));
            menu.setFocusPainted(false);
            menu.addActionListener(this);

            header.add(title, BorderLayout.LINE_START);

            //Body
            bodyFrame.setBounds(0,0 , 700,0);
            
            body.setBounds(0,0, 700, 350);

            menuFrame.setBounds(400, 0, 300, 350);
            menuFrame.setBackground(Color.pink);
            menuFrame.setVisible(false);
            menuFrame.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.gray));
            menuFrame.setLayout(new BoxLayout(menuFrame, BoxLayout.Y_AXIS));

            home.setFont(subHeaderFont);
            home.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
            home.setBackground(Color.PINK);
            home.setFocusPainted(false);
            home.addActionListener(this);
            menuFrame.add(home);

            notification.setFont(subHeaderFont);
            notification.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
            notification.setBackground(Color.PINK);
            home.setFocusPainted(false);
            menuFrame.add(notification);

            logIn.setFont(subHeaderFont);
            logIn.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
            logIn.setBackground(Color.PINK);
            logIn.setFocusPainted(false);
            menuFrame.add(logIn);

            logOut.setFont(subHeaderFont);
            logOut.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
            logOut.setBackground(Color.PINK);
            logOut.setFocusPainted(false);
            menuFrame.add(logOut);

            dashboard();
            bodyFrame.add(body, JLayeredPane.DEFAULT_LAYER);
            bodyFrame.add(menuFrame, JLayeredPane.PALETTE_LAYER);

            add(bodyFrame, BorderLayout.CENTER);
        });
    }

    public void dashboard() {
        dashboard.setLayout(new BoxLayout(dashboard, BoxLayout.Y_AXIS));
        dashboard.setBounds(0, 0, WIDTH, 350);

        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setPreferredSize(new Dimension(WIDTH, 100));

        text1.setFont(subHeaderFont);
        text1.setBorder(new EmptyBorder(20, 0 ,0 ,0));
        text1.setAlignmentX(Component.CENTER_ALIGNMENT);
        text2.setFont(textFont);
        text2.setAlignmentX(Component.CENTER_ALIGNMENT);

        textPanel.add(text1);
        textPanel.add(text2);

        dashboard.add(textPanel);

        buttonChoice.setBounds(0, 0, 700, 100);
        buttonChoice.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));

        repair.setFont(subHeaderFont);
        repair.setFocusPainted(false);
        repair.setPreferredSize(new Dimension(200, 50));
        repair.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        repair.addActionListener(this);
        buttonChoice.add(repair);

        maintenance.setFont(subHeaderFont);
        maintenance.setFocusPainted(false);
        maintenance.setPreferredSize(new Dimension(200, 50));
        maintenance.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        maintenance.addActionListener(this);
        buttonChoice.add(maintenance);

        dashboard.add(buttonChoice);

        body.add(dashboard, JLayeredPane.DEFAULT_LAYER);
    }

    public void applianceMenu() {
        appliancePanel.setBounds(0, 0, WIDTH, 350);
       
        applianceFrame.setBounds(0, 0, 650, 350);
        applianceFrame.setLayout(new GridLayout(2, 2, 10, 10));
        
        
        applianceFrame.add(phone);
        applianceFrame.add(computer);
        applianceFrame.add(laptop);
        applianceFrame.add(tv);
        
        appliancePanel.add(applianceFrame);
        body.add(appliancePanel, JLayeredPane.DEFAULT_LAYER);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menu){
            menuFrame.setVisible(!menuFrame.isVisible());
        }
        
        if(e.getSource() == home) {
            body.removeAll();
            dashboard();
            body.revalidate();
            body.repaint();
        }
        if(e.getSource() == maintenance) {
            body.removeAll(); 
            applianceMenu();
            body.revalidate();
            body.repaint();
        }

        if(e.getSource() == repair) {
            bodyFrame.removeAll();
            applianceMenu(); 
            bodyFrame.revalidate();
            bodyFrame.repaint();
        }
    }
} 
