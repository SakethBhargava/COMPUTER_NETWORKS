import java.io.*;
import java.net.*;
public class ServerFile {
   static public void main(String... args) {
      try (ServerSocket serverSocket = new ServerSocket(900)) {
         System.out.println("Server is Starting in Port 900");
         Socket clientSocket = serverSocket.accept();
         System.out.println("Connected");
         DataInputStream in = new DataInputStream(clientSocket.getInputStream());
         DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
         String fileName = "resume.docx";
         int bytes = 0;
         FileOutputStream fout = new FileOutputStream(fileName);
         long size = in.readLong();
         byte[] buffer = new byte[4 * 1024];
         while (size > 0 && (bytes = in.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
            fout.write(buffer, 0, bytes);
            size -= bytes;
         }
         System.out.println("File is Received");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}