import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final int MESSAGES_PER_PAGE=5;
    private static ArrayList<User> users=new ArrayList<>();

    public static void main(String[] args) {

        MessangerUtils.initDemo(users);

        Scanner sc= new Scanner(System.in);

        int option=0;

        while(option!=3){
            MessangerUtils.clearScreen();
            System.out.println("Main menu:");
            System.out.println("1. Log in");
            System.out.println("2. Sign up");
            System.out.println("3. Exit");
            option= sc.nextInt();
            if(option==1){
                System.out.print("username: ");
                sc.nextLine();
                String username=sc.nextLine();
                if(!MessangerUtils.usernameExists(users,username)){
                    System.out.println("Username does not exist");
                    continue;
                }
                System.out.print("password: ");
                String password= sc.nextLine();
                User currentUser=MessangerUtils.login(users,username,password);
                if(currentUser==null){
                    System.out.println("Wrong password or username");
                    continue;
                }
                int userOption=0;
                while(userOption!=6){
                    MessangerUtils.clearScreen();
                    System.out.println("What would you like to do?");
                    System.out.println("1. View inbox");
                    System.out.println("2. View outbox");
                    System.out.println("3. Write message");
                    System.out.println("4. Change username");
                    System.out.println("5. Change password");
                    System.out.println("6. Log out");
                    userOption=sc.nextInt();
                    if(userOption==1){
                        int msgCount=currentUser.getInMessageCount();
                        int startIndex=0;
                        int stopIndex;
                        int inboxOption=0;
                        while(inboxOption!=4) {
                            MessangerUtils.clearScreen();
                            System.out.println("You have received "+msgCount+" message(s).");
                            stopIndex = Math.min(startIndex + MESSAGES_PER_PAGE, msgCount);
                            for (int i = startIndex; i < stopIndex; ++i) {
                                Message msg = currentUser.getInMessages().get(i);
                                System.out.println();
                                System.out.println("Message " + (i+1));
                                System.out.println(msg.getTimeSent());
                                System.out.println("From: " +
                                        msg.getFrom().getUsername());
                                System.out.println("Subject: " + msg.getSubject());
                            }
                            System.out.println("1. See next page");
                            System.out.println("2. See previous page");
                            System.out.println("3. View a message");
                            System.out.println("4. Exit inbox");
                            inboxOption=sc.nextInt();
                            if (inboxOption==1){
                                if(stopIndex>=msgCount){
                                    System.out.println("No next page");
                                    sc.nextLine();
                                    sc.nextLine();
                                }
                                else{
                                    startIndex+=MESSAGES_PER_PAGE;
                                }
                            }
                            else if (inboxOption==2) {
                                if(startIndex<=0){
                                    System.out.println("No previous page");
                                    sc.nextLine();
                                    sc.nextLine();
                                }
                                else{
                                    startIndex-=MESSAGES_PER_PAGE;
                                }
                            }
                            else if (inboxOption==3) {
								MessangerUtils.clearScreen();
                                System.out.print("Message number: ");
                                int msgIndex=sc.nextInt();
                                --msgIndex;
                                if(msgIndex>=msgCount){
                                    System.out.println("Message not found");
                                    sc.nextLine();
                                    sc.nextLine();
                                }
                                else{
                                    Message msg=currentUser.getInMessages().get(msgIndex);
                                    System.out.println(msg.getTimeSent());
                                    System.out.println("From: " +
                                            msg.getFrom().getUsername());
                                    System.out.println("Subject: " + msg.getSubject());
                                    System.out.println("Text: " + msg.getText());
                                    msg.read();
                                    sc.nextLine();
                                    sc.nextLine();
                                }
                            }
                            else if (inboxOption!=4) {
                                System.out.println("Invalid option");
                            }
                        }
                    }
                    else if (userOption==2) {
                        int msgCount=currentUser.getOutMessageCount();
                        int startIndex=0;
                        int stopIndex;
                        int outboxOption=0;
                        while(outboxOption!=4) {
                            MessangerUtils.clearScreen();
                            System.out.println("You have sent "+msgCount+" message(s).");
                            stopIndex = Math.min(startIndex + MESSAGES_PER_PAGE, msgCount);
                            for (int i = startIndex; i < stopIndex; ++i) {
                                Message msg = currentUser.getOutMessages().get(i);
                                System.out.println();
                                System.out.println("Message " + i);
                                System.out.println(msg.getTimeSent());
                                System.out.println("To: " +
                                        msg.getTo().getUsername());
                                System.out.println("Subject: " + msg.getSubject());
                            }
                            System.out.println("1. See next page");
                            System.out.println("2. See previous page");
                            System.out.println("3. View a message");
                            System.out.println("4. Exit outbox");
                            outboxOption=sc.nextInt();
                            if (outboxOption==1){
                                if(stopIndex>=msgCount){
                                    System.out.println("No next page");
                                    sc.nextLine();
                                    sc.nextLine();
                                }
                                else{
                                    startIndex+=MESSAGES_PER_PAGE;
                                }
                            }
                            else if (outboxOption==2) {
                                if(startIndex<=0){
                                    System.out.println("No previous page");
                                    sc.nextLine();
                                    sc.nextLine();
                                }
                                else{
                                    startIndex-=MESSAGES_PER_PAGE;
                                }
                            }
                            else if (outboxOption==3) {
								MessangerUtils.clearScreen();
                                System.out.print("Message number: ");
                                int msgIndex=sc.nextInt();
                                if(msgIndex>=msgCount){
                                    System.out.println("Message not found");
                                    sc.nextLine();
                                    sc.nextLine();
                                }
                                else{
                                    Message msg=currentUser.getOutMessages().get(msgIndex);
                                    System.out.println(msg.getTimeSent());
                                    System.out.println("To: " +
                                            msg.getTo().getUsername());
                                    System.out.println("Subject: " + msg.getSubject());
                                    System.out.println("Text: " + msg.getText());
                                    sc.nextLine();
                                    sc.nextLine();
                                }
                            }
                            else if (outboxOption!=4) {
                                System.out.println("Invalid option");
                            }
                        }
                    }
                    else if (userOption==3) {
                        MessangerUtils.clearScreen();
                        System.out.print("To: ");
                        sc.nextLine();
                        String to=sc.nextLine();
                        while(!MessangerUtils.usernameExists(users,to)){
                            System.out.println("User "+to+" does not " +
                                    "exist. Try again? (y/n)");
                            char yn = sc.next().charAt(0);
                            if(yn=='y'){
                                System.out.print("To: ");
                                sc.nextLine();
                                to=sc.nextLine();
                            }
                            else{
                                break;
                            }
                        }
                        if(!MessangerUtils.usernameExists(users,to)){
                            continue;
                        }
                        System.out.print("Subject: ");
                        String subject=sc.nextLine();
                        System.out.println("Text: ");
                        String text=sc.nextLine();
                        System.out.println("Send message?");
                        System.out.println("To: "+to);
                        System.out.println("Subject: "+subject);
                        System.out.println("Text: "+text);
                        System.out.println("(y/n)");
                        char yn = sc.next().charAt(0);
                        if(yn=='y'){
                            User toUser=MessangerUtils.getUserByUsername(users,to);
                            Message msg=new Message(currentUser,toUser,
                                    subject,text, Instant.now());
                            currentUser.sendMessage(msg);
                            toUser.receiveMessage(msg);
                        }

                    }
                    else if (userOption==4) {
                        MessangerUtils.clearScreen();
                        System.out.print("New username: ");
                        sc.nextLine();
                        String newUsername=sc.nextLine();
                        if (MessangerUtils.usernameExists(users,newUsername)){
                            System.out.println("Username already exists");
                        }
                        else{
                            currentUser.setUsername(newUsername);
                        }
                    }
                    else if (userOption==5) {
                        MessangerUtils.clearScreen();
                        System.out.print("New password: ");
                        sc.nextLine();
                        String newPassword=sc.nextLine();
                        if (MessangerUtils.invalidPassword(newPassword)){
                            System.out.println("Invalid password");
                        }
                        else{
                            currentUser.setPassword(newPassword);
                        }
                    }
                    else if (userOption!=6) {
                        System.out.println("Invalid option");
                    }
                }
            }
            else if (option==2) {
                MessangerUtils.clearScreen();
                System.out.print("Username: ");
                sc.nextLine();
                String username=sc.nextLine();
                if(username.isBlank()){
                    System.out.println("Username cannot be blank");
                }
                else if(MessangerUtils.usernameExists(users,username)){
                    System.out.println("Username already exists");
                }
                else{
                    System.out.print("Password: ");
                    String password= sc.nextLine();
                    if (MessangerUtils.invalidPassword(password)){
                        System.out.println("Invalid password");
                    }
                    else{
                        users.add(new User(username,password));
                    }
                }

            } else if (option!=3) {
                System.out.println("Invalid option");
            }
        }
    }


}