/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

import app.AppManager;
import constants.KEY;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import templates.BackgroundTemplates;
import templates.PlayerClass;
import templates.PlayerRace;
import templates.Templates;
import util.Bundle;
import util.Power;
import util.PowerRating;
import util.PowerRating.Playstyle;
import util.PowerRating.PowerStat;
import util.RacePower;
import util.SwingHelper;

/**
 *
 * @author Kendrick-Laptop
 */
public class BuilderFrame extends javax.swing.JFrame {

    public static String FROM_BUILDER = "FromBuilder";
    
    private BuilderClassCard classCard;
    private BuilderRaceCard raceCard;
    private BuilderBackgroundCard backCard;
    private final BuilderDeck deck;
    public static final String CARD_CLASS = "Building Class";
    public static final String CARD_RACE =  "Building Race";
    public static final String CARD_BACKGROUND = "Building Background";
    
    private static final int NONE = 0;
    private static final int MALE = 1;
    private static final int FEMALE = 2;
    private int sex;

    void updateValues() {
        PlayerClass cl = classCard.getSelectedClass();
        PlayerRace ra = raceCard.getSelectedRace();
        BackgroundTemplates.Background ba = backCard.getSelectedBackground();
        
        processClass(cl);
        processRace(ra);
        processBackground(ba);
        sex = MALE;
        processScore(cl, ra);
    }

    private void processClass(PlayerClass cl) {
        if(cl == null){
            classCard.resetComponents();
        }
        else{
            classCard.updateComponents(cl);
        }
    }

    private void processRace(PlayerRace ra) {
        if(ra == null)
            raceCard.resetComponents();
        else{
            raceCard.updateComponents(ra);
            if(ra.hasImagePath())
                setImage(ra.imagePath());
        }
            
    }

    private void processBackground(BackgroundTemplates.Background ba) {
        if(ba == null)
            backCard.resetComponents();
        else
            backCard.updateComponents(ba);
    }

    private void setImage(String imagePath) {
        if(imagePath != null){
            try {
                imagePath += getGender();
                String filePath = "/img/" + imagePath + ".png";
                File f = new File(getClass().getResource(filePath).getPath());
                BufferedImage buf = ImageIO.read(f);
                ImageIcon img = new ImageIcon(buf);
                Image image = img.getImage(); // transform it
                Image newimg = image.getScaledInstance(250, 600,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                ImageIcon photo = new ImageIcon(newimg);  // transform it back
                char_img.setIcon(photo);
            } catch (IOException ex) {
                Logger.getLogger(BuilderFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getGender() {
        switch(sex){
            case MALE:return "-m";
            case FEMALE:return "-f";
        }
        return "-m";
    }

    private void updateImage() {
        PlayerRace ra = raceCard.getSelectedRace();
        if(ra != null){
            setImage(ra.imagePath());
        }
    }

    private void processScore(PlayerClass cl, PlayerRace ra) {
        if(cl == null || ra == null){
            return;
        }
        
        Power cp = cl.powerLevel();
        RacePower rp = ra.powerLevel();
        
        if(cp != null && rp != null){
            PowerRating powerRating = PowerRating.analyze(cp, rp);
            PowerStat magic = powerRating.magic();
            PowerStat martial = powerRating.martial();
            Playstyle playstyle = powerRating.playstyle();
            if(magic != null){
                int off = magic.offensive();
                int def = magic.defensive();
                int util = magic.utility();

                bar_off_magic.setValue(off*10);
                bar_def_magic.setValue(def*10);
                bar_util_magic.setValue(util*10);
            }
            if(martial != null){
                int off = martial.offensive();
                int def = martial.defensive();
                int util = martial.utility();
                
                bar_off_martial.setValue(off*10);
                bar_def_martial.setValue(def*10);
                bar_util_martial.setValue(util*10);
            }
            if(playstyle != null){
                int ranged = playstyle.ranged();
                int melee = playstyle.melee();
                
                bar_style_ranged.setValue(ranged*10);
                bar_style_melee.setValue(melee*10);
            }
            txt_area_description.setText(powerRating.getDescription());
            SwingHelper.setScrollPositionToTop(scroll_desc);
        }
    }
    
    private static class BuilderDeck extends Deck{

        private final JButton next;
        private final JButton previous;
        
        public BuilderDeck(JPanel holder, JButton next, JButton previous) {
            super(holder);
            previous.setEnabled(false);
            this.next = next;
            this.previous = previous;
            current_item = 0;
        }

        @Override
        public void nextCard() {
            if(!tail(current_item)){
                current_item++;
                previous.setEnabled(true);
                if(tail(current_item)){
                    next.setEnabled(false);
                }
                revealCard();
            }
        }

        @Override
        public void previousCard() {
            if(!head(current_item)){
                current_item--;
                next.setEnabled(true);
                if(head(current_item)){
                    previous.setEnabled(false);
                }
                revealCard();
            }
        }

        private boolean tail(int current_item) {
            return (panels.size()-1) == current_item;
        }
        
        private boolean head(int current_item){
            return (current_item == 0);
        }
        
       
        
    }

    private static BuilderFrame frame;
    
    public static void createInstance(Bundle templates){
        frame = new BuilderFrame(templates);
    }
    
    public static boolean instanceNotNull(){
        return frame != null;
    }
    
    public static BuilderFrame getInstance(){
        return frame;
    }
    
    private BuilderFrame(Bundle templates) {
        initComponents();
        classCard = new BuilderClassCard();
        classCard.putTemplate(templates.getTemplate(Templates.TYPE.T_CLASS));
        raceCard = new BuilderRaceCard();
        raceCard.putTemplate(templates.getTemplate(Templates.TYPE.T_RACE));
        backCard = new BuilderBackgroundCard();
        backCard.putTemplate(templates.getTemplate(Templates.TYPE.T_BACKGROUND));
        deck = new BuilderDeck(pan_deck, btn_next_card, btn_previous_card);
        deck.add(raceCard, BuilderFrame.CARD_RACE);
        deck.add(classCard, BuilderFrame.CARD_CLASS);
        deck.add(backCard, BuilderFrame.CARD_BACKGROUND);
        
        classCard.updateComponents(classCard.getSelectedClass());
        raceCard.updateComponents(raceCard.getSelectedRace());
        backCard.updateComponents(backCard.getSelectedBackground());
        updateImage();
        updateValues();
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                AppManager manager = AppManager.getInstance();
                manager.goToMainMenu();
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pan_container = new javax.swing.JPanel();
        pan_deck_holder = new javax.swing.JPanel();
        pan_deck_controller = new javax.swing.JPanel();
        btn_next_card = new javax.swing.JButton();
        btn_previous_card = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btn_random = new javax.swing.JButton();
        pan_deck = new javax.swing.JPanel();
        panel_deck_stats = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        char_img = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        ico_male = new javax.swing.JLabel();
        ico_female = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pan_stats_offense = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_off_magic = new javax.swing.JLabel();
        bar_off_magic = new javax.swing.JProgressBar();
        bar_off_martial = new javax.swing.JProgressBar();
        lbl_off_martial = new javax.swing.JLabel();
        pan_stats_defense = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        bar_def_martial = new javax.swing.JProgressBar();
        lbl_def_martial = new javax.swing.JLabel();
        lbl_def_magic = new javax.swing.JLabel();
        bar_def_magic = new javax.swing.JProgressBar();
        pan_stats_utility = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        bar_util_martial = new javax.swing.JProgressBar();
        lbl_util_martial = new javax.swing.JLabel();
        lbl_util_magic = new javax.swing.JLabel();
        bar_util_magic = new javax.swing.JProgressBar();
        pan_stats_ranged_melee = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        bar_style_melee = new javax.swing.JProgressBar();
        lbl_style_melee = new javax.swing.JLabel();
        lbl_style_ranged = new javax.swing.JLabel();
        bar_style_ranged = new javax.swing.JProgressBar();
        pan_stats_flavor_text = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        scroll_desc = new javax.swing.JScrollPane();
        txt_area_description = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Character Builder");
        setResizable(false);

        pan_container.setBackground(new java.awt.Color(0, 51, 102));
        pan_container.setPreferredSize(new java.awt.Dimension(800, 600));
        pan_container.setLayout(new java.awt.BorderLayout());

        pan_deck_holder.setBackground(new java.awt.Color(0, 51, 102));
        pan_deck_holder.setPreferredSize(new java.awt.Dimension(300, 600));
        pan_deck_holder.setLayout(new java.awt.BorderLayout());

        pan_deck_controller.setBackground(new java.awt.Color(0, 51, 102));
        pan_deck_controller.setLayout(new java.awt.BorderLayout());

        btn_next_card.setBackground(new java.awt.Color(255, 255, 255));
        btn_next_card.setText("Next");
        btn_next_card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_next_cardActionPerformed(evt);
            }
        });
        pan_deck_controller.add(btn_next_card, java.awt.BorderLayout.LINE_END);

        btn_previous_card.setBackground(new java.awt.Color(255, 255, 255));
        btn_previous_card.setText("Previous");
        btn_previous_card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_previous_cardActionPerformed(evt);
            }
        });
        pan_deck_controller.add(btn_previous_card, java.awt.BorderLayout.LINE_START);

        jButton1.setBackground(new java.awt.Color(255, 204, 0));
        jButton1.setText("BUILD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pan_deck_controller.add(jButton1, java.awt.BorderLayout.CENTER);

        btn_random.setBackground(java.awt.Color.green);
        btn_random.setText("Randomize Character!");
        btn_random.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_randomActionPerformed(evt);
            }
        });
        pan_deck_controller.add(btn_random, java.awt.BorderLayout.PAGE_END);

        pan_deck_holder.add(pan_deck_controller, java.awt.BorderLayout.PAGE_END);

        pan_deck.setBackground(new java.awt.Color(0, 51, 102));
        pan_deck.setLayout(new java.awt.CardLayout());
        pan_deck_holder.add(pan_deck, java.awt.BorderLayout.CENTER);

        pan_container.add(pan_deck_holder, java.awt.BorderLayout.LINE_START);

        panel_deck_stats.setBackground(new java.awt.Color(0, 25, 102));
        panel_deck_stats.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        char_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/portrait_unknown.png"))); // NOI18N
        jPanel1.add(char_img, java.awt.BorderLayout.CENTER);

        jPanel9.setLayout(new java.awt.GridLayout(1, 2));

        ico_male.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ico_male.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_male.png"))); // NOI18N
        ico_male.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ico_male.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ico_maleMouseClicked(evt);
            }
        });
        jPanel9.add(ico_male);

        ico_female.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ico_female.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_female.png"))); // NOI18N
        ico_female.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ico_female.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ico_femaleMouseClicked(evt);
            }
        });
        jPanel9.add(ico_female);

        jPanel1.add(jPanel9, java.awt.BorderLayout.PAGE_END);

        panel_deck_stats.add(jPanel1, java.awt.BorderLayout.LINE_END);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Character Analyzer");
        jPanel2.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        pan_stats_offense.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Offense");
        pan_stats_offense.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setPreferredSize(new java.awt.Dimension(250, 103));
        jPanel4.setLayout(null);

        lbl_off_magic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_magic.png"))); // NOI18N
        lbl_off_magic.setText("Magic");
        jPanel4.add(lbl_off_magic);
        lbl_off_magic.setBounds(10, 10, 80, 30);
        jPanel4.add(bar_off_magic);
        bar_off_magic.setBounds(90, 14, 140, 20);
        jPanel4.add(bar_off_martial);
        bar_off_martial.setBounds(90, 60, 140, 20);

        lbl_off_martial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_crossed_swords.png"))); // NOI18N
        lbl_off_martial.setText("Martial");
        jPanel4.add(lbl_off_martial);
        lbl_off_martial.setBounds(10, 60, 80, 30);

        pan_stats_offense.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel3.add(pan_stats_offense);

        pan_stats_defense.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Defense");
        pan_stats_defense.add(jLabel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setPreferredSize(new java.awt.Dimension(250, 103));
        jPanel5.setLayout(null);
        jPanel5.add(bar_def_martial);
        bar_def_martial.setBounds(90, 60, 140, 20);

        lbl_def_martial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_crossed_swords.png"))); // NOI18N
        lbl_def_martial.setText("Martial");
        jPanel5.add(lbl_def_martial);
        lbl_def_martial.setBounds(10, 60, 80, 30);

        lbl_def_magic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_magic.png"))); // NOI18N
        lbl_def_magic.setText("Magic");
        jPanel5.add(lbl_def_magic);
        lbl_def_magic.setBounds(10, 10, 80, 30);
        jPanel5.add(bar_def_magic);
        bar_def_magic.setBounds(90, 14, 140, 20);

        pan_stats_defense.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel3.add(pan_stats_defense);

        pan_stats_utility.setLayout(new java.awt.BorderLayout());

        jLabel5.setText("Utility");
        pan_stats_utility.add(jLabel5, java.awt.BorderLayout.PAGE_START);

        jPanel6.setPreferredSize(new java.awt.Dimension(250, 103));
        jPanel6.setLayout(null);
        jPanel6.add(bar_util_martial);
        bar_util_martial.setBounds(90, 60, 140, 20);

        lbl_util_martial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_crossed_swords.png"))); // NOI18N
        lbl_util_martial.setText("Martial");
        jPanel6.add(lbl_util_martial);
        lbl_util_martial.setBounds(10, 60, 80, 30);

        lbl_util_magic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_magic.png"))); // NOI18N
        lbl_util_magic.setText("Magic");
        jPanel6.add(lbl_util_magic);
        lbl_util_magic.setBounds(10, 10, 80, 30);
        jPanel6.add(bar_util_magic);
        bar_util_magic.setBounds(90, 14, 140, 20);

        pan_stats_utility.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel3.add(pan_stats_utility);

        pan_stats_ranged_melee.setLayout(new java.awt.BorderLayout());

        jLabel6.setText("Playstyle");
        pan_stats_ranged_melee.add(jLabel6, java.awt.BorderLayout.PAGE_START);

        jPanel7.setPreferredSize(new java.awt.Dimension(250, 103));
        jPanel7.setLayout(null);
        jPanel7.add(bar_style_melee);
        bar_style_melee.setBounds(90, 60, 140, 20);

        lbl_style_melee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_crossed_swords.png"))); // NOI18N
        lbl_style_melee.setText("Melee");
        jPanel7.add(lbl_style_melee);
        lbl_style_melee.setBounds(10, 60, 80, 30);

        lbl_style_ranged.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_bow_and_arrow.png"))); // NOI18N
        lbl_style_ranged.setText("Ranged");
        jPanel7.add(lbl_style_ranged);
        lbl_style_ranged.setBounds(10, 10, 80, 30);
        jPanel7.add(bar_style_ranged);
        bar_style_ranged.setBounds(90, 14, 140, 20);

        pan_stats_ranged_melee.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel3.add(pan_stats_ranged_melee);

        pan_stats_flavor_text.setLayout(new java.awt.BorderLayout());

        jLabel7.setText("Description");
        pan_stats_flavor_text.add(jLabel7, java.awt.BorderLayout.PAGE_START);

        jPanel8.setPreferredSize(new java.awt.Dimension(250, 103));
        jPanel8.setLayout(new java.awt.BorderLayout());

        txt_area_description.setEditable(false);
        txt_area_description.setText("This character is a mysterious one... There must be more information about them.");
        scroll_desc.setViewportView(txt_area_description);

        jPanel8.add(scroll_desc, java.awt.BorderLayout.CENTER);

        pan_stats_flavor_text.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel3.add(pan_stats_flavor_text);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        panel_deck_stats.add(jPanel2, java.awt.BorderLayout.CENTER);

        pan_container.add(panel_deck_stats, java.awt.BorderLayout.CENTER);

        getContentPane().add(pan_container, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_next_cardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_next_cardActionPerformed
        deck.nextCard();
    }//GEN-LAST:event_btn_next_cardActionPerformed

    private void btn_previous_cardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_previous_cardActionPerformed
        deck.previousCard();
    }//GEN-LAST:event_btn_previous_cardActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PlayerClass cl = classCard.getSelectedClass();
        PlayerRace ra = raceCard.getSelectedRace();
        BackgroundTemplates.Background ba = backCard.getSelectedBackground();
        
        Bundle character_info = new Bundle();
        if(cl != null){
            classCard.storeInfo(character_info);
        }
        if(ra != null){
            raceCard.storeInfo(character_info);
            if(ra.hasImagePath()){
                String path = "/img/profile-"+ra.imagePath() + getGender() + ".png";
                URL url = getClass().getResource(path);
                if(url != null){
                    character_info.putString(KEY.K_IMAGE_PATH, url.getPath());
                }
                
            }
                 
        if(ba != null){
            backCard.storeInfo(character_info);
        }
        
        AppManager manager = AppManager.getInstance();
        character_info.putBoolean(BuilderFrame.FROM_BUILDER, true);
        setVisible(false);
        manager.startUpCharacterFrame(character_info);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_randomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_randomActionPerformed
        raceCard.randomize();
        classCard.randomize();
        backCard.randomize();
    }//GEN-LAST:event_btn_randomActionPerformed

    private void ico_maleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ico_maleMouseClicked
        sex = MALE;
        updateImage();
    }//GEN-LAST:event_ico_maleMouseClicked

    private void ico_femaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ico_femaleMouseClicked
        sex = FEMALE;
        updateImage();
    }//GEN-LAST:event_ico_femaleMouseClicked

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar bar_def_magic;
    private javax.swing.JProgressBar bar_def_martial;
    private javax.swing.JProgressBar bar_off_magic;
    private javax.swing.JProgressBar bar_off_martial;
    private javax.swing.JProgressBar bar_style_melee;
    private javax.swing.JProgressBar bar_style_ranged;
    private javax.swing.JProgressBar bar_util_magic;
    private javax.swing.JProgressBar bar_util_martial;
    private javax.swing.JButton btn_next_card;
    private javax.swing.JButton btn_previous_card;
    private javax.swing.JButton btn_random;
    private javax.swing.JLabel char_img;
    private javax.swing.JLabel ico_female;
    private javax.swing.JLabel ico_male;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_def_magic;
    private javax.swing.JLabel lbl_def_martial;
    private javax.swing.JLabel lbl_off_magic;
    private javax.swing.JLabel lbl_off_martial;
    private javax.swing.JLabel lbl_style_melee;
    private javax.swing.JLabel lbl_style_ranged;
    private javax.swing.JLabel lbl_util_magic;
    private javax.swing.JLabel lbl_util_martial;
    private javax.swing.JPanel pan_container;
    private javax.swing.JPanel pan_deck;
    private javax.swing.JPanel pan_deck_controller;
    private javax.swing.JPanel pan_deck_holder;
    private javax.swing.JPanel pan_stats_defense;
    private javax.swing.JPanel pan_stats_flavor_text;
    private javax.swing.JPanel pan_stats_offense;
    private javax.swing.JPanel pan_stats_ranged_melee;
    private javax.swing.JPanel pan_stats_utility;
    private javax.swing.JPanel panel_deck_stats;
    private javax.swing.JScrollPane scroll_desc;
    private javax.swing.JTextPane txt_area_description;
    // End of variables declaration//GEN-END:variables
}
