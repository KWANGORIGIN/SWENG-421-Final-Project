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
        admin = new AdminWindow(this);
        admin.setVisible(true);
        while(!sessionThread.interrupted())
        {
            //System.err.println(sessionThread.isInterrupted());
//            try
//            {
//                Thread.sleep(10);
//            }
//            catch(InterruptedException e)
//            {
//
//            }
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

    public void interrupt()
    {
        System.err.println("Interrupted");
        sessionThread.interrupt();
    }

    public static void main(String[] args) {
        Session currentSession = new Session();
    }

}
