package myserver;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zy on 17-6-28.
 */
public class MyServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        int port = 8100;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        int[] a;
        int b;
        List<Thread> treadList = new ArrayList<Thread>();
        Thread[] tread = new Thread[10];
        while (true) {
            Socket socket = null;
            InputStream input = null;
            OutputStream outputStream = null;

            try {
                socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                treadList.add(serverThread);
                serverThread.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public static class ServerThread extends Thread {
        private Socket socket;
        public ServerThread(Socket socket) {
            this.socket = socket;
        }
        byte[] buffer = new byte[1024];
        @Override
        public void run() {
            InputStream input = null;
            OutputStream outputStream = null;

            try {
                input = this.socket.getInputStream();
                outputStream = this.socket.getOutputStream();
                System.out.println(input.getClass().getName());
                int readLength = 0;
                while ((readLength = input.read(buffer)) != -1){
                    String requestString = new String(buffer, 0, readLength);
                    System.out.println(requestString);
                    //HttpRequest httpRequest = new HttpRequest(requestString);
                    //outputStream.write(buffer);
                }
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
