import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServer {
    public static ServerSocket serverSocket ;
    public static int port = 1234;

    public static void main(String[] args) {
        System.out.println("Waiting For Client Connection .....");
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Port Opened !");

        }catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }

        do{
            handelClient();
        }while (true);
    }

    private static void handelClient() {
        Socket S = null;
        try {
            S = serverSocket.accept();
            Scanner input = new Scanner(S.getInputStream());
            PrintWriter out = new PrintWriter(S.getOutputStream(), true); //Don't Forget Auto Flush
            String UserName = input.nextLine();
            String Pass = input.nextLine();
            while (!UserName.equals("Close") &&!Pass.equals("Close")) {
                users check = new users(UserName, Pass);
                if (check.auth()) {
                    System.out.println("You are logged in");
                    out.println(" ***Welcome***\n UserName: " + UserName + "\nPassword: " + Pass);
                }else {
                    out.println("Invalid Try Again!");
                }
                 UserName = input.nextLine();
                 Pass = input.nextLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                System.out.println("Connection Closed !");
                S.close();
            }catch (IOException e){
                System.out.println("Unable to Connect");
                System.exit(1);
            }
        }
    }
}
class users {
    private String username;
    private String password;
    private String[][] accounts = {{"manar", "123"},{"abdo", "456"}};

    public users(String user, String pass){
        username = user;
        password = pass;
    }

    public boolean auth(){
        if((username.equals(accounts[0][0])) && (password.equals(accounts[0][1])))
            return true;
        else
            return false;
    }

}
