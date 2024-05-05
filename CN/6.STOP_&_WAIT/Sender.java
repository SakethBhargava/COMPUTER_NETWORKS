import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Sender
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number of frames to be sent:");
            int n = sc.nextInt();
            try (Socket socket = new Socket("localhost", 9999);
            PrintStream myps = new PrintStream(socket.getOutputStream());
            BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream())))
            {
                for (int i = 0; i < n;)
                {
                    System.out.println("Enter message for frame " + i + ":");
                    String message = sc.next();
                    System.out.println("Frame no " + i + " with message '" + message + "' is sent");
                    myps.println(i + ":" + message);
                    String ack = bf.readLine();
                    if (ack != null && ack.equals("ACK"))
                    {
                        System.out.println("Acknowledgement received from receiver");
                        i++;
                        Thread.sleep(4000);
                    }
                    else
                    {
                        System.out.println("Acknowledgement not received for frame " + i + ", resending...");
                    }
                }
                myps.println("exit");
                System.out.println("All frames sent. Closing connection.");
            }
        } 
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
