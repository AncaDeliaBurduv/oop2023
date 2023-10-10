import java.util.ArrayList;

public class User {

    private static int userCount=0;
    private final int id;
    private String username;
    private String password;
    private ArrayList<Message> inbox = new ArrayList<>();
    private ArrayList<Message> outbox = new ArrayList<>();

    public User(String username, String password){
        if(username.isBlank()){
            throw new IllegalArgumentException("Blank username");
        }
        if(MessangerUtils.invalidPassword(password)){
            throw new IllegalArgumentException("Invalid password");
        }
        this.username=username;
        this.password=password;
        ++userCount;
        id=userCount;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        if(username.isBlank()){
            throw new IllegalArgumentException("Blank username");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        if(MessangerUtils.invalidPassword(password)){
            throw new IllegalArgumentException("Invalid password");
        }
        this.password = password;
    }

    public ArrayList<Message> getInMessages(){
        return inbox;
    }
    public ArrayList<Message> getInMessages(int startIndex, int stopIndex){
        return new ArrayList<>(inbox.subList(startIndex,stopIndex));
    }
    public ArrayList<Message> getOutMessages(){
        return outbox;
    }
    public ArrayList<Message> getOutMessages(int startIndex, int stopIndex){
        return new ArrayList<>(outbox.subList(startIndex,stopIndex));
    }
    public ArrayList<Message> getMessagesNotRead(){
        ArrayList<Message> newMessages=new ArrayList<>();
        for(Message msg: inbox){
            if (!msg.wasRead()){
                newMessages.add(msg);
            }
        }
        return newMessages;
    }
    public void receiveMessage(Message message){
        inbox.add(0,message);
    }
    public  void sendMessage(Message message){
        outbox.add(0,message);
    }

    public void deleteInMessage(int msgIndex){
        inbox.remove(msgIndex);
    }
    public void deleteOutMessage(int msgIndex){
        outbox.remove(msgIndex);
    }

    public int getInMessageCount(){
        return inbox.size();
    }
    public int getOutMessageCount(){
        return outbox.size();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", inbox=" + inbox +
                ", outbox=" + outbox +
                '}';
    }
}
