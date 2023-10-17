import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
public class Server {
    public static void main(String args[]) throws IOException {
// Register service on port 1234
        ServerSocket s = new ServerSocket(1234);
        try {
            System.out.println("Open Server");
            Socket s1 = s.accept(); // Wait and accept a connection
// Get a communication stream associated with the socket
            OutputStream s1out = s1.getOutputStream();
            DataOutputStream dos = new DataOutputStream(s1out);
            while (true) {
// Send a string!
// Close the connection, but not the server socket
                dos.close();
                s1out.close();
                s1.close();
            }
        }
        catch (UnknownHostException e) {
            e.printStackTrace();}
        catch (IOException e) {
            e.printStackTrace();}
    }
}
