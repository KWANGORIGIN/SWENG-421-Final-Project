import javax.swing.*;
import java.awt.*;

public class WavePanel extends JPanel {
    private WaveIF wave;

    public WavePanel(){
        wave = new SineWave();
        System.out.println("Default wave: " + wave);
    }

    public void setWave(WaveIF newWave){
        this.wave = newWave;
        System.out.println("New wave: " + wave);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        System.out.println("Painting..." + wave.getWaveImage() + " from: " + wave);
        g.drawImage(wave.getWaveImage(), 0, 0, this.getWidth(), this.getHeight(), null);
    }

}
