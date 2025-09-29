package server_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerSocket {
    public static void main(String[] args) {
        try (java.net.ServerSocket servidor = new java.net.ServerSocket(4444)) {
            System.out.println("Servidor aguardando cliente...");
            try (Socket socket = servidor.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                System.out.println("Cliente conectado: " + socket.getInetAddress().getHostAddress());

                String mensagem;
                while ((mensagem = in.readLine()) != null) {
                    System.out.println("Cliente: " + mensagem);
                }
            }
        } catch (IOException e) {
            System.err.println("Problemas de IO: " + e.getMessage());
        }
    }
}
