import javax.swing.*;
import java.awt.*;

public class WavePanel extends JPanel {
    private WaveIF wave;

    public WavePanel(){
        wave = new SineWave();
    }

    public void setWave(WaveIF newWave){
        this.wave = newWave;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

//        System.out.println("Painting..." + wave.getWaveImage());
        g.drawImage(wave.getWaveImage(), 0, 0, this.getWidth(), this.getHeight(), null);
    }

}
