/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glass_stepping_stones;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author 1BestCsharp
 */
public class Game_Form extends javax.swing.JFrame {

    /**
     * Creates new form Game_Form
     */
    
    // create a black border (it's actually yellow)
    Border black_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow);
    
    // get the images paths
    String footsteps = "\\/images/foot-steps.png";
    String nosteps = "\\/images/no-steps.png";
    String cracks = "\\/images/cracks.png";
    
    //jpanel component
    Component [] comp1;
    Component [] comp2;
    Random random = new Random();
    String randomImage;
    
    JLabel[][] labels;
    String[][] imagesOrder = new String[6][2];
    ArrayList<String> list = new ArrayList<>(); 
    
    int counter = 0;
    boolean won = true;
    
    
    public Game_Form() {
        initComponents();
        
        // center this form
        this.setLocationRelativeTo(null);
        
        // set borders
        jPanel_Start.setBorder(black_border);
        jPanel_Finish.setBorder(black_border);
        jLabel_PlayerStart.setBorder(black_border);
        jLabel_PlayerFinish.setBorder(black_border);
        
        // set image
        displayImage(footsteps, jLabel_PlayerStart);
        
        //add jlabels to the labels table
        labels = new JLabel[][]{{jLabel_1_1,jLabel_1_2}, {jLabel_2_1, jLabel_2_2},
                                {jLabel_3_1,jLabel_3_2}, {jLabel_4_1, jLabel_4_2},
                                {jLabel_5_1,jLabel_5_2},{jLabel_6_1,jLabel_6_2}
        
    };
    //disable all labels
    for(JLabel[] lbls:labels){
        lbls[0].setEnabled(false);
        lbls[1].setEnabled(false);
    }
    //add images to the list
    list.add(footsteps);
    list.add(cracks);
    //get component from jpanels
    comp1 = jPanel2.getComponents();
    comp2 = jPanel3.getComponents();
    //populate table with images in random order
    randomImages();
    
    //add action to jLabels
    addAction();
    }
    
    
            
    //functions we are gonna use
     
    //create a function to enable jlabels
    public void enableLabels(int index){
        if(index <= labels.length - 1){
            JLabel[] lbls = labels[index];
            lbls[0].setEnabled(true);
            lbls[1].setEnabled(true);
        }
    }
    
    //create a function to get random images
    public void randomImages(){
        for(int i = 0; i < labels.length; i++){
            
            //get random images
            randomImage = list.get(random.nextInt(list.size()));
            imagesOrder[i][0] = randomImage;
            //get a different images
            if(randomImage.equals(footsteps)){
                imagesOrder[i][1] = cracks;
                
            }else{
                imagesOrder[i][1] = footsteps;
            }
            System.out.println(imagesOrder[i][0]);
            System.out.println(imagesOrder[i][1]);
            System.out.println("...............");
        }
    }
    //a function to add action to jlabels when we click
    public void addAction(){
        enableLabels(counter);
        //jpanel2
        for(Component comp: comp1){
            if(comp instanceof JLabel){
                JLabel label = (JLabel) comp;
                label.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt){
                    if (label.isEnabled()){
                        
                        
                        displayImage(imagesOrder[counter][1], label);
                        if (imagesOrder[counter][1].equals(cracks)){
                            won = false;
                        }
                        //disable jlabel 
                        label.setEnabled(false);
                        JLabel label = (JLabel) comp2[counter];
                        label.setEnabled(false);
                        if(counter == imagesOrder.length-1 && won == true){
                            displayImage(footsteps,jLabel_PlayerFinish);
                            jLabel_message.setText("You've Won : ");
                        }
                        else if( won == false){
                            jLabel_message.setText("You've lost : ");
                        }
                        
                           
                        
                    
                        
                    
                        counter++;
                        enableLabels(counter);
                    }
                    
                }
                
                
                });
              
            }
        }
        
         //jpanel3
        for(Component comp: comp2){
            if(comp instanceof JLabel){
                JLabel label = (JLabel) comp;
                label.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt){
                    
                    if (label.isEnabled()){
                        
                    displayImage(imagesOrder[counter][0], label);
                    if (imagesOrder[counter][0].equals(cracks)){
                        won = false;
                    }
                    
                    //disable jlabel
                    label.setEnabled(false);
                    JLabel label = (JLabel) comp1[counter];
                    label.setEnabled(false);
                    if(counter == imagesOrder.length-1 && won == true){
                            displayImage(footsteps,jLabel_PlayerFinish);
                            jLabel_message.setText("You've Won : ");
                        }
                        else if( won == false){
                            jLabel_message.setText("You've lost : ");
                        }
                    counter++;
                        enableLabels(counter);
                }
                }
                
                });
              
            }
        }
        }
            
    // a function to dispaly image in jlabel
    public void displayImage(String imgPath, JLabel label)
    {
        // get the image
        ImageIcon imgIco = new ImageIcon(getClass().getResource(imgPath));
        
        // make the image fit the given jlabel
        Image image = imgIco.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        
       // set the image into the jlabel
       label.setIcon(new ImageIcon(image));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel_Start = new javax.swing.JPanel();
        jLabel_PlayerStart = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel_1_2 = new javax.swing.JLabel();
        jLabel_2_2 = new javax.swing.JLabel();
        jLabel_3_2 = new javax.swing.JLabel();
        jLabel_4_2 = new javax.swing.JLabel();
        jLabel_5_2 = new javax.swing.JLabel();
        jLabel_6_2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel_1_1 = new javax.swing.JLabel();
        jLabel_2_1 = new javax.swing.JLabel();
        jLabel_3_1 = new javax.swing.JLabel();
        jLabel_4_1 = new javax.swing.JLabel();
        jLabel_5_1 = new javax.swing.JLabel();
        jLabel_6_1 = new javax.swing.JLabel();
        jPanel_Finish = new javax.swing.JPanel();
        jLabel_PlayerFinish = new javax.swing.JLabel();
        jButton_PlayAgain_ = new javax.swing.JButton();
        jLabel_message = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel_Start.setBackground(new java.awt.Color(51, 51, 51));

        jLabel_PlayerStart.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel_StartLayout = new javax.swing.GroupLayout(jPanel_Start);
        jPanel_Start.setLayout(jPanel_StartLayout);
        jPanel_StartLayout.setHorizontalGroup(
            jPanel_StartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_StartLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_PlayerStart, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_StartLayout.setVerticalGroup(
            jPanel_StartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_StartLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel_PlayerStart, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(234, 242, 245));

        jLabel_1_2.setBackground(new java.awt.Color(168, 204, 215));
        jLabel_1_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_1_2.setOpaque(true);

        jLabel_2_2.setBackground(new java.awt.Color(168, 204, 215));
        jLabel_2_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_2_2.setOpaque(true);

        jLabel_3_2.setBackground(new java.awt.Color(168, 204, 215));
        jLabel_3_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_3_2.setOpaque(true);

        jLabel_4_2.setBackground(new java.awt.Color(168, 204, 215));
        jLabel_4_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_4_2.setOpaque(true);

        jLabel_5_2.setBackground(new java.awt.Color(168, 204, 215));
        jLabel_5_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_5_2.setOpaque(true);

        jLabel_6_2.setBackground(new java.awt.Color(168, 204, 215));
        jLabel_6_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_6_2.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_6_2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_2_2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(jLabel_1_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_3_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(jLabel_4_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(jLabel_5_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(jLabel_6_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(234, 242, 245));

        jLabel_1_1.setBackground(new java.awt.Color(168, 204, 215));
        jLabel_1_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_1_1.setOpaque(true);

        jLabel_2_1.setBackground(new java.awt.Color(168, 204, 215));
        jLabel_2_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_2_1.setOpaque(true);

        jLabel_3_1.setBackground(new java.awt.Color(168, 204, 215));
        jLabel_3_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_3_1.setOpaque(true);

        jLabel_4_1.setBackground(new java.awt.Color(168, 204, 215));
        jLabel_4_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_4_1.setOpaque(true);

        jLabel_5_1.setBackground(new java.awt.Color(168, 204, 215));
        jLabel_5_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_5_1.setOpaque(true);

        jLabel_6_1.setBackground(new java.awt.Color(168, 204, 215));
        jLabel_6_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_6_1.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_6_1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_2_1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(jLabel_1_1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(jLabel_3_1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(jLabel_4_1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(jLabel_5_1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(jLabel_6_1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel_Finish.setBackground(new java.awt.Color(51, 51, 51));

        jLabel_PlayerFinish.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel_FinishLayout = new javax.swing.GroupLayout(jPanel_Finish);
        jPanel_Finish.setLayout(jPanel_FinishLayout);
        jPanel_FinishLayout.setHorizontalGroup(
            jPanel_FinishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FinishLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_PlayerFinish, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_FinishLayout.setVerticalGroup(
            jPanel_FinishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FinishLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel_PlayerFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton_PlayAgain_.setBackground(new java.awt.Color(0, 204, 204));
        jButton_PlayAgain_.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jButton_PlayAgain_.setForeground(new java.awt.Color(51, 51, 51));
        jButton_PlayAgain_.setText("Play Again");
        jButton_PlayAgain_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PlayAgain_ActionPerformed(evt);
            }
        });

        jLabel_message.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_message.setFont(new java.awt.Font("Tekton Pro", 0, 36)); // NOI18N
        jLabel_message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel_Start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_Finish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_PlayAgain_, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                            .addComponent(jLabel_message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_Finish, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_Start, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jLabel_message)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(jButton_PlayAgain_, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_PlayAgain_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PlayAgain_ActionPerformed
        //reset everything
        randomImages();
        //remove images from jlabels
        for(JLabel[] lbls : labels){
            lbls[0].setIcon(null);
            lbls[1].setIcon(null);
        }
        jLabel_PlayerFinish.setIcon(null);
        counter = 0;
        won = true;
        jLabel_message.setText("");
        enableLabels(counter);
    }//GEN-LAST:event_jButton_PlayAgain_ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_PlayAgain_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_1_1;
    private javax.swing.JLabel jLabel_1_2;
    private javax.swing.JLabel jLabel_2_1;
    private javax.swing.JLabel jLabel_2_2;
    private javax.swing.JLabel jLabel_3_1;
    private javax.swing.JLabel jLabel_3_2;
    private javax.swing.JLabel jLabel_4_1;
    private javax.swing.JLabel jLabel_4_2;
    private javax.swing.JLabel jLabel_5_1;
    private javax.swing.JLabel jLabel_5_2;
    private javax.swing.JLabel jLabel_6_1;
    private javax.swing.JLabel jLabel_6_2;
    private javax.swing.JLabel jLabel_PlayerFinish;
    private javax.swing.JLabel jLabel_PlayerStart;
    private javax.swing.JLabel jLabel_message;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_Finish;
    private javax.swing.JPanel jPanel_Start;
    // End of variables declaration//GEN-END:variables
}
