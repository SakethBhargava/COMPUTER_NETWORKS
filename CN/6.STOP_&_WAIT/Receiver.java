import java.io.*;
import java.net.*;
public class Receiver
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            try (ServerSocket ss = new ServerSocket(9999);
            Socket sk = ss.accept();
            BufferedReader bf = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            PrintStream ps = new PrintStream(sk.getOutputStream()))
            {
                String line;
                while ((line = bf.readLine()) != null)
                {
                    if (line.equals("exit"))
                    {
                        System.out.println("Sender has exited. Closing connection.");
                        break;
                    }
                    String[] parts = line.split(":");
                    int frame = Integer.parseInt(parts[0]);
                    String msg = parts[1];
                    System.out.println("Received frame " + frame + " with msg: " + msg);
                    ps.println("ACK");
                }
            }
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
