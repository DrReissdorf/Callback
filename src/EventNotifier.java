import java.util.ArrayList;

public class EventNotifier {
    private static EventNotifier instance;
    private ArrayList<InterestingEvent> interestingEvents;

    private EventNotifier() {
        interestingEvents = new ArrayList<>();
        new Hello().start();
    }

    public static EventNotifier getInstance() {
        if(instance == null) instance = new EventNotifier();
        return instance;
    }

    public void addCallBack(InterestingEvent ie) {
        if(!interestingEvents.contains(ie)) interestingEvents.add(ie);
    }

    public void notifyCallbacks() {
        for(InterestingEvent ie : interestingEvents) ie.interestingEvent ();
    }

    private class Hello extends Thread {
        public void run() {
            while (true) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notifyCallbacks();

            }
        }
    }
}