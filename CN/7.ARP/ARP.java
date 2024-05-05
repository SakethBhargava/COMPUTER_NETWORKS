import java.net.*;
import java.util.Scanner;
public class ARP {
    public static void main(String[] args) {
        try {
            System.out.println("Enter the IP Address: ");
            Scanner read = new Scanner(System.in);
            String address = read.nextLine();
            InetAddress ipAddress = InetAddress.getByName(address);
            NetworkInterface netid = NetworkInterface.getByInetAddress(ipAddress);
            if (netid != null){
                byte[] mac = netid.getHardwareAddress();
                if (mac!=null){
                    System.out.print("MAC Address : ");
                    for (int i = 0; i < mac.length; i++){
                        System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
                    }
                } else{
                    System.out.println("Address exists but MAC address not found.");
                }
            } else{
                System.out.println("Network Interface for the specified address is not found");
            }
        } catch (UnknownHostException e) {
            System.out.println("Invalid IP Address: " + e.getMessage());
        } catch (SocketException e) {
            System.out.println("Error : " + e);
        }
    }
}