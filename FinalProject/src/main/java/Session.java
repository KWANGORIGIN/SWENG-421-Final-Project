import java.util.ArrayList;

public class Session implements Runnable{
    private AdminWindow admin;
    private Thread sessionThread;

    public Session(){
        sessionThread = new Thread(this);
        sessionThread.start();
    }

    @Override
    public void run(){
        admin = new AdminWindow(this);
        admin.setVisible(true);
        while(!sessionThread.interrupted())
        { }
        shutdown();
    }

    public void shutdown()
    {
        ArrayList<OscilloscopeWindow> windows = admin.getOscilloscopes();

        System.out.println("System Shutdown");
        for(OscilloscopeWindow w : windows)
        {
            w.saveImage();
        }
    }

    public void interrupt()
    {
        sessionThread.interrupt();
    }

    public static void main(String[] args) {
        Session currentSession = new Session();
    }

}
