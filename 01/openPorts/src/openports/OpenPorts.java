/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openports;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Manar
 */
public class OpenPorts {

   public static void main(String[] args) throws IOException {
    	Socket tempSocket = new Socket();	
        boolean isOpened;
      	
        for (int port = 0; port < 65536; port++) {
          	
            isOpened = true;
          
            try {
                tempSocket = new Socket("127.0.0.1", port);
            }
            catch (IOException e) {
                isOpened = false;
            }
            finally {
                tempSocket.close();
            }
            if (isOpened) {
                String message = String.format("port %d is open", port);
                System.out.println(message);
            }
        }
    } 
}
