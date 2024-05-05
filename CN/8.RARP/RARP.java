import java.net.*;
import java.util.Enumeration;
import java.util.Scanner;
public class RARP {
    private static String ipAddress() throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface netid = interfaces.nextElement();
            if (!netid.isLoopback() && netid.isUp()) {
                Enumeration<InetAddress> addresses = netid.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    if (address instanceof Inet4Address) {
                        return address.getHostAddress();
                    }
                }
            }
        }
        return null;
    }
    private static String getIpAddressForMac(String macAddress) throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface netid = interfaces.nextElement();
            byte[] mac = netid.getHardwareAddress();
            if (mac != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < mac.length; i++) {
                    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                }
                if (sb.toString().equalsIgnoreCase(macAddress)) {
                    return ipAddress();
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the MAC Address: ");
            String macAddress = scanner.nextLine();
            String ipAddress = getIpAddressForMac(macAddress);
            if (ipAddress != null) {
                System.out.println("IP Address corresponding to MAC : " + ipAddress);
            } else {
                System.out.println("IP Address not found for MAC in the current connected network.");
            }
        } catch (SocketException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
