import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;

public class MessangerUtils {
    public static boolean invalidPassword(String password){
        if(password.isBlank()){
            return true;
        }
        return false;
    }
    public static boolean usernameExists(ArrayList<User> users, String username){
        for(User user: users){
            if(user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    public static User login(ArrayList<User> users, String username, String password) {
        for (User user: users){
            if(user.getUsername().equals(username) &&
                    user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
    public static User getUserByUsername(ArrayList<User> users, String username){
        for(User user: users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
    public static void initDemo(ArrayList<User> demoUsers){
        demoUsers.add(new User("ana","ana"));
        demoUsers.add(new User("bogdan","bogdan"));
        demoUsers.add(new User("cristi","cristi"));
        demoUsers.add(new User("diana","diana"));
        demoUsers.add(new User("elena","elena"));
        for(int i=0;i<100;++i){
            Random rand = new Random();
            int fromIndex= rand.nextInt(5);
            int toIndex= rand.nextInt(5);
            Message msg=new Message(demoUsers.get(fromIndex),
								demoUsers.get(toIndex),("subiect "+i)
								,("text mesaj"+i), Instant.now());
            demoUsers.get(fromIndex).sendMessage(msg);
            demoUsers.get(toIndex).receiveMessage(msg);
        }
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
