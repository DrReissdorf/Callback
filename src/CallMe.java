public class CallMe implements InterestingEvent {
    private EventNotifier en;

    public CallMe () {
        // Create the event notifier and pass ourself to it.
        EventNotifier.getInstance().addCallBack(this);
    }

    // Define the actual handler for the event.
    @Override
    public void interestingEvent () {
        System.out.println("WOW, SOMETHING HAPPENED!");
    }
}