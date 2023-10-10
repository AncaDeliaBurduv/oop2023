import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Message {
    private final User from;
    private final User to;
    private final String subject;
    private String text;
    private final Instant timeSent;
    private boolean read;

    public Message(User from, User to, String subject, String text,
                   Instant timeSent) {
        if(from==null || to==null){
            throw new RuntimeException("User does not exist");
        }
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.text = text;
        this.timeSent=timeSent;
        read=false;
    }

    public User getFrom() {
        return from;
    }
    public User getTo() {
        return to;
    }
    public String getSubject() {
        return subject;
    }
    public String getText() {
        return text;
    }
    public Instant getTimeSent() {
        return timeSent;
    }

    public boolean wasRead(){
        return read;
    }
    public void read(){
        read=true;
    }

    @Override
    public String toString() {
        return "Message{" +
                "from=" + from +
                ", to=" + to +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", timeSent=" + timeSent +
                ", read=" + read +
                '}';
    }
/*
    public String toString() {
        //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return "Message{" +
                "from=" + from.getUsername() +" ("+from.getId()+")"+
                " to=" + to.getUsername() +" ("+from.getId()+")"+
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", timeSent=" + sdf.format(Date.from(timeSent)) +
                '}';
    }
    */
}
