package main.java.socket;

import main.java.app.GameManger;

import java.io.IOException;
import java.net.ServerSocket;

public class Server extends Thread {
    private final int PORT = 5000;
    private ServerSocket LISTENER = null;

    public Server() {
        try {
            this.LISTENER = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true) {
            try {
                System.out.println("Listening on port " + PORT + " ...");
                GameManger.addSocket(LISTENER.accept());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
