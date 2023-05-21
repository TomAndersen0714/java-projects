package lesson3.network.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author TomAndersen
 */
public class SocketDemo {
    public static void main(String[] args) throws IOException {
        int port = 8090;

        // using try-with-resource statement to handle the connection automatically
        try (
            // create a socket server
            ServerSocket serverSocket = new ServerSocket(port);) {

            System.out.println("Waiting for the connection...");

            // listen the port, and block to wait a connection
            Socket clientSocket = serverSocket.accept();

            // read the data stream from client
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            // packing the input and output stream with buffer
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));

            // close the connection
            clientSocket.close();
        }
    }
}
