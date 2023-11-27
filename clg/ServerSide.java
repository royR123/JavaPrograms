package clg;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ServerSide {
 public static void main(String[] args) {
 DatagramSocket socket = null;
 try {
 socket = new DatagramSocket(9876);
 byte[] receiveData = new byte[1024];
 while (true) {
 DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
 socket.receive(receivePacket);
 String formatRequested = new String(receivePacket.getData(), 0,
receivePacket.getLength());
 SimpleDateFormat sdf;
 try {
 sdf = new SimpleDateFormat(formatRequested);
 } catch (IllegalArgumentException e) {
 sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 }
 String formattedDate = sdf.format(new Date());
 byte[] sendData = formattedDate.getBytes();
 InetAddress clientAddress = receivePacket.getAddress();
 int clientPort = receivePacket.getPort();
 DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
clientAddress, clientPort);
 socket.send(sendPacket);
 }
 } catch (Exception e) {
 e.printStackTrace();
 } finally {
 if (socket != null && !socket.isClosed()) {
 socket.close();
 }
 }
 }
}
