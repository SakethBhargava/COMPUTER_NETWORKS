import java.net.*;
public class Host
{
   static public void main(String... args)
   {
      try
      {
         InetAddress ip = InetAddress.getLocalHost();
         System.out.println("The IP Address :" + ip.getHostAddress());
         System.out.println("The Hostname is : " + ip.getHostName());
      }
      catch(UnknownHostException e)
      {
         System.out.println("The Exception is : " + e);
      }
   }
}