import java.util.ArrayList;

public class Session implements Runnable{
    AdminWindow admin;
    Thread sessionThread;

    public Session(){
        sessionThread = new Thread(this);
        sessionThread.start();
    }

    @Override
    public void run(){
        admin = new AdminWindow();
        while(!admin.closed())
        {

        }
        shutdown();
    }

    public void shutdown()
    {
        ArrayList<OscilloscopeWindow> windows = admin.getOscilloscopes();

        for(OscilloscopeWindow w : windows)
        {
            w.saveImage();
        }
    }
    public static void main(String[] args) {
        Session currentSession = new Session();
    }

}
