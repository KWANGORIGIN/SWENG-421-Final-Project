/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 *
 * @author Kevin Wang
 */
public class OscilloscopeWindow extends javax.swing.JFrame implements ObserverIF {
    protected volatile static WaveIF sharedWave;
    protected WaveIF localWave;
    protected CompositeWave compositeWave;
    protected WaveIF savedWave;
    private final Object updateLock = new Object();

    /**
     * Creates new form OscilloscopeWindow
     */
    public OscilloscopeWindow() {
        initComponents();
        this.setSize(1025, 500);
        if(sharedWave == null){
            sharedWave = new SineWave();
        }
        localWave = new SineWave();
        this.compositeWave = new CompositeWave();
        viewerPanel.setWave(localWave);
       // savedWave = new SineWave();

        this.updateAmpOutput(localWave.getArg("Amplitude").toString());
        this.updateFreqOutput(localWave.getArg("Frequency").toString());
        this.updateHorizOutput(localWave.getArg("Horizontal Shift").toString());
        this.updateVertOutput(localWave.getArg("Vertical Shift").toString());
        this.updateScaleOutput(localWave.getArg("Scale").toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewerPanel = new WavePanel();
        amplitudeSlider = new javax.swing.JSlider(0, 100, 0);
        frequencySlider = new javax.swing.JSlider(0, 100, 0);
        horizontalSlider = new javax.swing.JSlider(-50, 50, 0);
        verticalSlider = new javax.swing.JSlider(-50, 50, 0);
        amplitudeTextfield = new javax.swing.JTextField();
        frequencyTextfield = new javax.swing.JTextField();
        verticalTextfield = new javax.swing.JTextField();
        sineButton = new javax.swing.JButton();
        cosineButton = new javax.swing.JButton();
        amplitudeCheckbox = new javax.swing.JCheckBox();
        amplitudeLabel = new javax.swing.JLabel();
        scalingSlider = new javax.swing.JSlider(0, 250, 42);
        scalingTextfield = new javax.swing.JTextField();
        horizontalTextfield = new javax.swing.JTextField();
        frequencyLabel = new javax.swing.JLabel();
        horizontalShiftLabel = new javax.swing.JLabel();
        verticalShiftLabel = new javax.swing.JLabel();
        scalingLabel = new javax.swing.JLabel();
        wavelengthCheckbox = new javax.swing.JCheckBox();
        ppAmplitudeCheckbox = new javax.swing.JCheckBox();
        observeLabel = new javax.swing.JLabel();
        frequencyCheckbox = new javax.swing.JCheckBox();
        parametersLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        saveImageButton = new javax.swing.JButton();
        addToCompositeButton = new javax.swing.JButton();
        compositeToggleButton = new javax.swing.JToggleButton();
        resetCompositeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        amplitudeCheckbox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        amplitudeCheckbox.setText("Observe Amplitude");
        amplitudeCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amplitudeCheckboxActionPerformed(evt);
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

        wavelengthCheckbox.setText("Show Wavelength");
        wavelengthCheckbox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                wavelengthCheckboxStateChanged(evt);
            }
        });

        ppAmplitudeCheckbox.setText("Show Peak to Peak Amplitude");
        ppAmplitudeCheckbox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ppAmplitudeCheckboxStateChanged(evt);
            }
        });

        observeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        observeLabel.setText("Observe:");

        frequencyCheckbox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        frequencyCheckbox.setText("Observe Frequency");
        frequencyCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frequencyCheckboxActionPerformed(evt);
            }
        });

        parametersLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        parametersLabel.setText("Parameters:");

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleLabel.setText("Oscilloscope Viewer created by William Hemminger and Kevin Wang");

        saveImageButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        saveImageButton.setText("SAVE IMAGE");
        saveImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveImageButtonActionPerformed(evt);
            }
        });

        addToCompositeButton.setText("Add to Composite");
        addToCompositeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCompositeButtonActionPerformed(evt);
            }
        });

        compositeToggleButton.setText("Show Composite Wave");
        compositeToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compositeToggleButtonActionPerformed(evt);
            }
        });

        resetCompositeButton.setText("Reset Composite Wave");
        resetCompositeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetCompositeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(wavelengthCheckbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ppAmplitudeCheckbox)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
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
                            .addComponent(parametersLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(observeLabel)
                            .addComponent(frequencyCheckbox)
                            .addComponent(amplitudeCheckbox))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cosineButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sineButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addToCompositeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(compositeToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scalingSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(scalingTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(scalingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(verticalShiftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetCompositeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(parametersLabel)
                            .addComponent(observeLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(amplitudeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(amplitudeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(amplitudeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(amplitudeCheckbox)))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(frequencySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(frequencyTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(frequencyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(frequencyCheckbox)))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(horizontalSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(horizontalTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                    .addComponent(scalingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(horizontalShiftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addToCompositeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cosineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(compositeToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveImageButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(wavelengthCheckbox)
                        .addComponent(ppAmplitudeCheckbox))
                    .addComponent(resetCompositeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void horizontalTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horizontalTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horizontalTextfieldActionPerformed

    private WaveArgIF createArg(String type, String className, double value, boolean checkmark){
        WaveArgIF arg = null;
        try {
            Class<?> c = Class.forName(className);
            Constructor<?> construct = c.getConstructor(double.class);
            arg = (WaveArgIF) construct.newInstance(value);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Failed to create arg " + className + "...");
            e.printStackTrace();
        }

//        System.out.println(arg.getType() + " " + value);

        if(checkmark){
            arg.setShared();
            sharedWave.changeArg(arg);
        }
        return arg;
    }

    private void amplitudeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_amplitudeSliderStateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider) evt.getSource();
        AmpArg arg = (AmpArg) createArg("Amplitude", "AmpArg", source.getValue() / 10.0, amplitudeCheckbox.isSelected());
        this.updateAmpOutput(arg.toString());

        if(!source.getValueIsAdjusting()){
            paintWithWorker(arg);
        }
    }//GEN-LAST:event_amplitudeSliderStateChanged

    private void frequencySliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_frequencySliderStateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider) evt.getSource();
        FreqArg arg = (FreqArg) createArg("Frequency", "FreqArg", source.getValue(), frequencyCheckbox.isSelected());
        this.updateFreqOutput(arg.toString());

        if(!source.getValueIsAdjusting()){
            paintWithWorker(arg);
        }
    }//GEN-LAST:event_frequencySliderStateChanged

    private void horizontalSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_horizontalSliderStateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider) evt.getSource();
        HorizArg arg = new HorizArg(source.getValue()  * (421 / (double) (100) * localWave.getData().get("Scale").getValue()));
        this.updateHorizOutput(arg.toString());

        if(!source.getValueIsAdjusting()){
//            System.out.println("Horizontal source: " + source.getValue());
//            int sourceValue = source.getValue();
            paintWithWorker(arg);
        }
    }//GEN-LAST:event_horizontalSliderStateChanged

    private void verticalSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_verticalSliderStateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider) evt.getSource();
        VertArg arg = new VertArg(source.getValue() * (301 / (double) 100 * localWave.getData().get("Scale").getValue()));

        this.updateVertOutput(arg.toString());

        if(!source.getValueIsAdjusting()){
            paintWithWorker(arg);
        }
    }//GEN-LAST:event_verticalSliderStateChanged

    private void scalingSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_scalingSliderStateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider) evt.getSource();
        ScaleArg arg = new ScaleArg((source.getValue() * 0.0001)  * (1000.0 / 301));
        this.updateScaleOutput(arg.toString());

        if(!source.getValueIsAdjusting()){
            paintWithWorker(arg);
        }
    }//GEN-LAST:event_scalingSliderStateChanged

    private void sineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sineButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sineButtonActionPerformed

    private void cosineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cosineButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cosineButtonActionPerformed

    private void amplitudeCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amplitudeCheckboxActionPerformed
        // TODO add your handling code here:
        WaveArgIF arg = sharedWave.getArg("Amplitude");
        if(amplitudeCheckbox.isSelected()){
            arg.addObserver(this);

            if(arg.getValue() != 0){
                this.updateAmpOutput(arg.toString());
                amplitudeSlider.setValue((int) (arg.getValue() * 10));
                localWave.plotWave(arg);
                viewerPanel.repaint();
            }
        }
        else{
            arg.removeObserver(this);
        }
    }//GEN-LAST:event_amplitudeCheckboxActionPerformed

    private void frequencyCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frequencyCheckboxActionPerformed
        // TODO add your handling code here:
        WaveArgIF arg = sharedWave.getArg("Frequency");
        if(frequencyCheckbox.isSelected()){
            arg.addObserver(this);

            if(arg.getValue() != 0){
                this.updateFreqOutput(arg.toString());
                frequencySlider.setValue((int) arg.getValue());
                localWave.plotWave(arg);
                viewerPanel.repaint();
            }
        }
        else{
            arg.removeObserver(this);
        }
    }//GEN-LAST:event_frequencyCheckboxActionPerformed

    private void ppAmplitudeCheckboxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ppAmplitudeCheckboxStateChanged
        // TODO add your handling code here:
        if(ppAmplitudeCheckbox.isSelected())
        {
            this.localWave = new WaveDecorator(new PPAmplitude(), this.localWave.cloneWave());
            viewerPanel.setWave(localWave);
            viewerPanel.repaint();

            System.out.println(((WaveDecorator)localWave).sourceWave);

            System.out.println(((WaveDecorator) localWave).getSourceWave().getArg("Amplitude").getValue());
        }
    }//GEN-LAST:event_ppAmplitudeCheckboxStateChanged

    private void wavelengthCheckboxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_wavelengthCheckboxStateChanged
        // TODO add your handling code here:
        if(wavelengthCheckbox.isSelected())
        {
            this.localWave = new WaveDecorator(new Wavelength(), this.localWave.cloneWave());
            viewerPanel.setWave(localWave);
            viewerPanel.repaint();

            System.out.println(((WaveDecorator)localWave).sourceWave);

            System.out.println(((WaveDecorator) localWave).getSourceWave().getArg("Amplitude").getValue());
        }
    }//GEN-LAST:event_wavelengthCheckboxStateChanged

    private void saveImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveImageButtonActionPerformed
        // TODO add your handling code here:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        File outputFile = new File("wave" + dtf.format(now) + ".png");
        if(compositeToggleButton.isSelected()){
            try{
                ImageIO.write(compositeWave.getWaveImage(), "png", outputFile);
            }catch(IOException e){
                System.out.println("Failed to save image...");
            }
        }
        else{
            try{
                ImageIO.write(localWave.getWaveImage(), "png", outputFile);
            }catch(IOException e){
                System.out.println("Failed to save image...");
            }
        }
    }//GEN-LAST:event_saveImageButtonActionPerformed

    private void addToCompositeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCompositeButtonActionPerformed
        // TODO add your handling code here:
        WaveIF temp = localWave.cloneWave();
        this.compositeWave.addWave((WaveIF) localWave.cloneWave());


    }//GEN-LAST:event_addToCompositeButtonActionPerformed

    private void compositeToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compositeToggleButtonActionPerformed
        // TODO add your handling code here:
        if(compositeToggleButton.isSelected())
        {
            //this.savedWave = (WaveIF) this.localWave.cloneWave();
            this.localWave = this.compositeWave;
            this.addToCompositeButton.setEnabled(false);
        }
        else
        {
            this.localWave = this.compositeWave.getLast().cloneWave();
            this.addToCompositeButton.setEnabled(true);
        }
        this.viewerPanel.setWave(this.localWave);
        viewerPanel.repaint();


    }//GEN-LAST:event_compositeToggleButtonActionPerformed

    private void resetCompositeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetCompositeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetCompositeButtonActionPerformed

    public void paintWithWorker(WaveArgIF arg){
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                localWave.plotWave(arg);
                return null;
            }

            @Override
            protected void done(){
                viewerPanel.repaint();
            }
        };
        worker.execute();
    }

    @Override
    public void update(WaveArgIF argChanged) {
        String type = argChanged.getType();
        if(type.equals("Amplitude")){
            this.updateAmpOutput(argChanged.toString());
            amplitudeSlider.setValue((int) (argChanged.getValue() * 10));
        }
        else if(type.equals("Frequency")){
            this.updateFreqOutput(argChanged.toString());
            frequencySlider.setValue((int) argChanged.getValue());
        }

        localWave.plotWave(argChanged);
        viewerPanel.repaint();
//        System.out.println("Update yeet");
    }

    public void updateAmpOutput(String a)
    {
        synchronized(updateLock)
        {
            this.amplitudeTextfield.setText(a);
        }

    }

    public void updateFreqOutput(String f)
    {
        synchronized(updateLock)
        {
            this.frequencyTextfield.setText(f);
        }

    }

    public void updateHorizOutput(String h)
    {
        synchronized(updateLock)
        {
            this.horizontalTextfield.setText(h);
        }

    }

    public void updateVertOutput(String v)
    {
        synchronized(updateLock)
        {
            this.verticalTextfield.setText(v);
        }

    }

    public void updateScaleOutput(String s)
    {
        synchronized(updateLock)
        {
            this.scalingTextfield.setText(s);
        }

    }

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
    private javax.swing.JButton addToCompositeButton;
    private javax.swing.JCheckBox amplitudeCheckbox;
    private javax.swing.JLabel amplitudeLabel;
    private javax.swing.JSlider amplitudeSlider;
    private javax.swing.JTextField amplitudeTextfield;
    private javax.swing.JToggleButton compositeToggleButton;
    private javax.swing.JButton cosineButton;
    private javax.swing.JCheckBox frequencyCheckbox;
    private javax.swing.JLabel frequencyLabel;
    private javax.swing.JSlider frequencySlider;
    private javax.swing.JTextField frequencyTextfield;
    private javax.swing.JLabel horizontalShiftLabel;
    private javax.swing.JSlider horizontalSlider;
    private javax.swing.JTextField horizontalTextfield;
    private javax.swing.JLabel observeLabel;
    private javax.swing.JLabel parametersLabel;
    private javax.swing.JCheckBox ppAmplitudeCheckbox;
    private javax.swing.JButton resetCompositeButton;
    private javax.swing.JButton saveImageButton;
    private javax.swing.JLabel scalingLabel;
    private javax.swing.JSlider scalingSlider;
    private javax.swing.JTextField scalingTextfield;
    private javax.swing.JButton sineButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel verticalShiftLabel;
    private javax.swing.JSlider verticalSlider;
    private javax.swing.JTextField verticalTextfield;
    private WavePanel viewerPanel;
    private javax.swing.JCheckBox wavelengthCheckbox;
    // End of variables declaration//GEN-END:variables
}
