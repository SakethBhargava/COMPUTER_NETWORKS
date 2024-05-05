import java.net.*;
import java.io.*;
public class DNS
{
    public static void main(String [] args)
    {
        int n;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do
        {
            System.out.println("\n***Choose Any Option***");
            System.out.println("1.DNS\n2.Reverse DNS\n3.EXIT");
            System.out.println("\nEnter Choice :");
            n = Integer.parseInt(System.console().readLine());
            if(n==1)
            {
                try
                {
                    System.out.println("Enter host name : ");
                    String hname = in.readLine();
                    InetAddress address = InetAddress.getByName(hname);
                    System.out.println("Host name :"+address.getHostName());
                    System.out.println("IP :"+address.getHostAddress());
                }
                catch(IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
            if(n==2)
            {

                try
                {
                    System.out.println("Enter IP address :");
                    String ipstr = in.readLine();
                    InetAddress ia = InetAddress.getByName(ipstr);
                    System.out.println("IP : "+ipstr);
                    System.out.println("Host Name : " + ia.getHostName());
                }
                catch(IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
        }
        while(!(n==3));
    }
}