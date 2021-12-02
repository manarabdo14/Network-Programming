import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static InetAddress host ;
    public static int port = 1234;
    public static void main(String[] args){
        try {
            host = InetAddress.getLocalHost();
        }catch (IOException e){
            System.out.println("Connection Failed !");
            System.exit(1);
        }
        accessServer();
    }

    private static void accessServer() {
        Socket S = null;
        try {
            S = new Socket(host , port);
            Scanner in = new Scanner(S.getInputStream());
            PrintWriter out = new PrintWriter(S.getOutputStream(),true);
            Scanner inU = new Scanner(System.in);
            String UserName , Pass , Res;
            do{
                System.out.println("***Log in***");
                System.out.println("Enter Username: ");
                UserName = inU.nextLine();
                out.println(UserName);
                System.out.println("Enter Password: ");
                Pass = inU.nextLine();
                out.println(Pass);
                Res = in.nextLine();
                System.out.println("\nSERVER> "+Res);

            } while (!UserName.equals("Close") &&!Pass.equals("Close"));

        }catch (IOException e){
            e.getStackTrace();
        }finally {
            try {
                System.out.println("Closing Con...");
                S.close();
            }catch (IOException e){
                System.out.println("Unable to Connect..");
                System.exit(1);
            }
        }
    }
}
