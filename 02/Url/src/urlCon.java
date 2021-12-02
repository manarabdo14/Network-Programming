
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class urlCon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a url: ");
        String url = scanner.nextLine();
        accessWebsite(url);
    }

    private static void accessWebsite(String url) {
       File file = new File("link.txt");
        try {
            URL my_url = new URL(url);
            URLConnection urlConnection = my_url.openConnection();
            InputStream isr = urlConnection.getInputStream();
            OutputStream os = new FileOutputStream(file);

            int data;
            while ((data = isr.read()) != -1) {
                os.write(data);
            }
            isr.close();
            os.close();
        } catch (IOException exception) {
            System.out.println("\n Cannot access URL");
            System.exit(1);
        } finally {
            System.out.println("\n Closing the connection");

                System.exit(1);

        }
    }
}
