import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try {
            Socket s = new Socket("localhost", 1234);
            DataOutputStream o = new DataOutputStream(s.getOutputStream()); // Write to Server
            while (true) {
                DataInputStream i = new DataInputStream(s.getInputStream());
                String msg = (String) i.readUTF();
                System.out.println(msg);
                Scanner scan = new Scanner(System.in);
                String msgscan = scan.nextLine();
                o.writeUTF(msgscan);
                if (msg.equals("exit")) {
                    break;
                }
                o.flush();
                s.close();
                o.close();
            }
        }
        catch(IOException e){
                e.printStackTrace();
            }

    }
}
