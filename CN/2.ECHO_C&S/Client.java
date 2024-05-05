import java.io.*;
import java.net.*;
public class Client
{
    public static void main(String[] args)
    {
        try
        {
            Socket sk = new Socket("127.0.0.1", 3000);
            BufferedReader sin = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            PrintWriter sout = new PrintWriter(sk.getOutputStream(), true);
            BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
            String s;
            System.out.println("Waiting for Server...");
            do
            {
                s = sin.readLine();
                if (s!= null)
                System.out.println(s);
                s = cin.readLine();
                sout.println(s);
            }
            while ( !s.trim().equals("stop") );
        }
        catch (Exception err)
        {
            System.err.println(err);
        }
    }
}