package clg;

import java.net.*;
import java.util.Scanner;

public class ClientSide {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        Scanner scanner = new Scanner(System.in);
        try {
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            byte[] sendData;
            System.out.print("Enter date format (e.g., yyyy-MM-dd HH:mm:ss): ");
            String formatRequested = scanner.nextLine();
            sendData = formatRequested.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                    serverAddress, 9876);
            socket.send(sendPacket);
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server Response: " + serverResponse);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
            scanner.close();
        }
    }
}