import java.io.*;
import java.net.*;
public class Server
{
    static public void main(String... args)
    {
        try
        {
            while (true)
            {
                ServerSocket ss = new ServerSocket(3000);
                Socket sk = ss.accept();
                BufferedReader cin = new BufferedReader(new InputStreamReader(sk.getInputStream()));
                PrintWriter cout = new PrintWriter(sk.getOutputStream(),true);
                cout.println("Connected to the Server. Type 'stop'to close.");
                String s;
                do
                {
                    s = cin.readLine();
                    if (s!=null)
                    cout.println("Got: "+ s);
                    System.out.println (s);
                }
                while (!s.trim().equals("stop") );
                System.out.println("Connection Terminated");
                sk.close();
            }
        }
        catch (Exception err)
        {
            System.err.println(err);
        }
    }
}