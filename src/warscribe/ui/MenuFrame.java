package warscribe.ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.UIManager;

public class MenuFrame extends javax.swing.JFrame {


    public MenuFrame() {
        initComponents();
        setBounds(100,100, getWidth(), getHeight());
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (dim.width - this.getSize().width)/2;
        int y = (dim.height - this.getSize().height)/2;
    
        this.setLocation(x, y);
        
    }


    private void initComponents() {

        dmBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        playerBtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WarScribe v2.0.2");
        setResizable(false);

        dmBtn.setFont(new java.awt.Font("Sylfaen", 2, 18));
        dmBtn.setText("Dungeon Master");
        dmBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dmBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dmBtnMouseExited(evt);
            }
        });
        dmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dmBtnActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        playerBtn.setFont(new java.awt.Font("Sylfaen", 2, 18));
        playerBtn.setText("Player");
        playerBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                playerBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                playerBtnMouseExited(evt);
            }
        });
        playerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerBtnActionPerformed(evt);
            }
        });

        infoTextArea.setBackground(new java.awt.Color(239, 235, 188));
        infoTextArea.setColumns(20);
        infoTextArea.setEditable(false);
        infoTextArea.setFont(new java.awt.Font("Sylfaen", 0, 16));
        infoTextArea.setRows(5);
        infoTextArea.setText("Welcome, adventurer!");
        infoTextArea.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));
        jScrollPane1.setViewportView(infoTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(dmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(playerBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    private void playerBtnActionPerformed(java.awt.event.ActionEvent evt) {
        PlayerFrame.main();
        dispose();
    }

    private void dmBtnActionPerformed(java.awt.event.ActionEvent evt) {
        DMFrame.main();
        dispose();
    }

    private void playerBtnMouseEntered(java.awt.event.MouseEvent evt) {
        infoTextArea.setText("");
        infoTextArea.append("The player menu will allow you to:\n");
        infoTextArea.append("     -Keep track of your current and maximum health\n");
        infoTextArea.append("     -Roll for skill checks\n");
        infoTextArea.append("     -Allow you to calculate XP and currency gain\n");
        infoTextArea.append("     -Roll for abilities/attacks\n");
    }

    private void dmBtnMouseEntered(java.awt.event.MouseEvent evt) {
        infoTextArea.setText("");
        infoTextArea.append("The dungeon master menu will allow you to:\n");
        infoTextArea.append("     -Keep track of monsters in an encounter\n");
        infoTextArea.append("     -Roll for attack and damage of NPCs\n");
        infoTextArea.append("     -Automatically calculate XP gain form an encounter\n");
        infoTextArea.append("     -Instantly roll for initiative during/before an encounter.\n");
        infoTextArea.append("     -Add new/custom monsters into the database\n");
}

    private void playerBtnMouseExited(java.awt.event.MouseEvent evt) {
        infoTextArea.setText("Welcome, adventurer!");
    }

    private void dmBtnMouseExited(java.awt.event.MouseEvent evt) {
        infoTextArea.setText("Welcome, adventurer!");
    }


    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch (Exception e){
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception exception) { }
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MenuFrame().setVisible(true);
            }
        });
    }
    public static javax.swing.JButton dmBtn;
    public static javax.swing.JTextArea infoTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JButton playerBtn;
}
