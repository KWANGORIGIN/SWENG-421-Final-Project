/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;

/**
 *
 * @author Kevin Wang
 */
public class OscilloscopeWindow extends javax.swing.JFrame {
    protected static WaveIF sharedWave;

    /**
     * Creates new form OscilloscopeWindow
     */
    public OscilloscopeWindow() {
        initComponents();
        this.setSize(850, 500);
        sharedWave = new SineWave();
        viewerPanel.setWave(sharedWave);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

//        viewerPanel = new javax.swing.JPanel();
        viewerPanel = new WavePanel();
        periodTextfield = new javax.swing.JTextField();
        wavelengthTextfield = new javax.swing.JTextField();
        amplitudeSlider = new javax.swing.JSlider();
        frequencySlider = new javax.swing.JSlider();
        horizontalSlider = new javax.swing.JSlider();
        verticalSlider = new javax.swing.JSlider();
        amplitudeTextfield = new javax.swing.JTextField();
        frequencyTextfield = new javax.swing.JTextField();
        verticalTextfield = new javax.swing.JTextField();
        sineButton = new javax.swing.JButton();
        cosineButton = new javax.swing.JButton();
        collaborationCheckbox = new javax.swing.JCheckBox();
        amplitudeLabel = new javax.swing.JLabel();
        scalingSlider = new javax.swing.JSlider();
        scalingTextfield = new javax.swing.JTextField();
        horizontalTextfield = new javax.swing.JTextField();
        frequencyLabel = new javax.swing.JLabel();
        horizontalShiftLabel = new javax.swing.JLabel();
        verticalShiftLabel = new javax.swing.JLabel();
        scalingLabel = new javax.swing.JLabel();
        periodLabel = new javax.swing.JLabel();
        wavelengthLabel = new javax.swing.JLabel();
        wavelengthCheckbox = new javax.swing.JCheckBox();
        ppAmplitudeCheckbox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 778, 436));
        setMaximumSize(new java.awt.Dimension(778, 436));
        setResizable(false);
        setSize(new java.awt.Dimension(778, 436));

        viewerPanel.setBackground(new java.awt.Color(255, 255, 255));
        viewerPanel.setPreferredSize(new java.awt.Dimension(420, 300));

        javax.swing.GroupLayout viewerPanelLayout = new javax.swing.GroupLayout(viewerPanel);
        viewerPanel.setLayout(viewerPanelLayout);
        viewerPanelLayout.setHorizontalGroup(
            viewerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );
        viewerPanelLayout.setVerticalGroup(
            viewerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        periodTextfield.setEditable(false);

        wavelengthTextfield.setEditable(false);

        amplitudeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                amplitudeSliderStateChanged(evt);
            }
        });

        frequencySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                frequencySliderStateChanged(evt);
            }
        });

        horizontalSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                horizontalSliderStateChanged(evt);
            }
        });

        verticalSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                verticalSliderStateChanged(evt);
            }
        });

        sineButton.setText("Sine Wave");
        sineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sineButtonActionPerformed(evt);
            }
        });

        cosineButton.setText("Cosine Wave");
        cosineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cosineButtonActionPerformed(evt);
            }
        });

        collaborationCheckbox.setText("Collaborate");
        collaborationCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collaborationCheckboxActionPerformed(evt);
            }
        });

        amplitudeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        amplitudeLabel.setText("Amplitude");

        scalingSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                scalingSliderStateChanged(evt);
            }
        });

        horizontalTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horizontalTextfieldActionPerformed(evt);
            }
        });

        frequencyLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        frequencyLabel.setText("Frequency");

        horizontalShiftLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        horizontalShiftLabel.setText("Horizontal Shift");

        verticalShiftLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        verticalShiftLabel.setText("Vertical Shift");

        scalingLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        scalingLabel.setText("Scaling");

        periodLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        periodLabel.setText("Period");

        wavelengthLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        wavelengthLabel.setText("Wavelength");

        wavelengthCheckbox.setText("Show Wavelength");

        ppAmplitudeCheckbox.setText("Show Peak to Peak Amplitude");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(viewerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(amplitudeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(amplitudeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(amplitudeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(frequencySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(frequencyTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(frequencyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(horizontalSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(horizontalTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(horizontalShiftLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(verticalSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(verticalTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(verticalShiftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scalingSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(scalingTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(scalingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cosineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wavelengthCheckbox)
                            .addComponent(ppAmplitudeCheckbox)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(periodTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(periodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(wavelengthTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(collaborationCheckbox))
                            .addComponent(wavelengthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(periodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wavelengthLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(periodTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(wavelengthTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(collaborationCheckbox)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(amplitudeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(amplitudeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(amplitudeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(frequencySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(frequencyTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(frequencyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(horizontalSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(horizontalTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(horizontalShiftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(verticalSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(verticalTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(verticalShiftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scalingSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scalingTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scalingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(sineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cosineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wavelengthCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ppAmplitudeCheckbox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void collaborationCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collaborationCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_collaborationCheckboxActionPerformed

    private void horizontalTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horizontalTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horizontalTextfieldActionPerformed

    private void amplitudeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_amplitudeSliderStateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider) evt.getSource();
        if(!source.getValueIsAdjusting()){
            AmpArg arg = new AmpArg(source.getValue());
            sharedWave.plotWave(arg);
            viewerPanel.repaint();
        }
    }//GEN-LAST:event_amplitudeSliderStateChanged

    private void frequencySliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_frequencySliderStateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider) evt.getSource();
        if(!source.getValueIsAdjusting()){
            FreqArg arg = new FreqArg(source.getValue());
            sharedWave.plotWave(arg);
            viewerPanel.repaint();
        }
    }//GEN-LAST:event_frequencySliderStateChanged

    private void horizontalSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_horizontalSliderStateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider) evt.getSource();
        if(!source.getValueIsAdjusting()){
            HorizArg arg = new HorizArg(source.getValue());
            sharedWave.plotWave(arg);
            viewerPanel.repaint();
        }
    }//GEN-LAST:event_horizontalSliderStateChanged

    private void verticalSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_verticalSliderStateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider) evt.getSource();
        if(!source.getValueIsAdjusting()){
            VertArg arg = new VertArg(source.getValue());
            sharedWave.plotWave(arg);
            viewerPanel.repaint();
        }
    }//GEN-LAST:event_verticalSliderStateChanged

    private void scalingSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_scalingSliderStateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider) evt.getSource();
        if(!source.getValueIsAdjusting()){
            ScaleArg arg = new ScaleArg(source.getValue());
            sharedWave.plotWave(arg);
            viewerPanel.repaint();
        }
    }//GEN-LAST:event_scalingSliderStateChanged

    private void sineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sineButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sineButtonActionPerformed

    private void cosineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cosineButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cosineButtonActionPerformed

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
            java.util.logging.Logger.getLogger(OscilloscopeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OscilloscopeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OscilloscopeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OscilloscopeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OscilloscopeWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amplitudeLabel;
    private javax.swing.JSlider amplitudeSlider;
    private javax.swing.JTextField amplitudeTextfield;
    private javax.swing.JCheckBox collaborationCheckbox;
    private javax.swing.JButton cosineButton;
    private javax.swing.JLabel frequencyLabel;
    private javax.swing.JSlider frequencySlider;
    private javax.swing.JTextField frequencyTextfield;
    private javax.swing.JLabel horizontalShiftLabel;
    private javax.swing.JSlider horizontalSlider;
    private javax.swing.JTextField horizontalTextfield;
    private javax.swing.JLabel periodLabel;
    private javax.swing.JTextField periodTextfield;
    private javax.swing.JCheckBox ppAmplitudeCheckbox;
    private javax.swing.JLabel scalingLabel;
    private javax.swing.JSlider scalingSlider;
    private javax.swing.JTextField scalingTextfield;
    private javax.swing.JButton sineButton;
    private javax.swing.JLabel verticalShiftLabel;
    private javax.swing.JSlider verticalSlider;
    private javax.swing.JTextField verticalTextfield;
    private WavePanel viewerPanel;
    private javax.swing.JCheckBox wavelengthCheckbox;
    private javax.swing.JLabel wavelengthLabel;
    private javax.swing.JTextField wavelengthTextfield;
    // End of variables declaration//GEN-END:variables
}
