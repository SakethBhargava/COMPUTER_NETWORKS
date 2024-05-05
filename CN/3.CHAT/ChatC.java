import java.net.*;
import java.io.*;
public class ChatC
{
public static void main(String... args) throws Exception
{
    Socket sk=new Socket("127.0.0.1",2000);
    BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
    PrintStream sout=new PrintStream(sk.getOutputStream());
    BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
    String s;
    while ( true )
    {
        System.out.print("Client : ");
        s=cin.readLine();
        sout.println(s);
        s=sin.readLine();
        System.out.print("Server : "+s+"\n");
        if ( s.equalsIgnoreCase("BYE") )
        {
            break;
        }
    }
    System.out.println("Connection Terminated");
    sk.close();
    sin.close();
    sout.close();
    cin.close();
    }
}
