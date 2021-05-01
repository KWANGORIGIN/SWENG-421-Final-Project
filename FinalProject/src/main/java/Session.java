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
        admin.setVisible(true);
        while(!admin.closed())
        {
            try
            {
                Thread.sleep(10);
            }
            catch(InterruptedException e)
            {

            }
        }
        shutdown();
    }

    public void shutdown()
    {
        ArrayList<OscilloscopeWindow> windows = admin.getOscilloscopes();

        System.out.println("Running shutdown");
        for(OscilloscopeWindow w : windows)
        {
            w.saveImage();
        }
    }
    public static void main(String[] args) {
        Session currentSession = new Session();
    }

}
