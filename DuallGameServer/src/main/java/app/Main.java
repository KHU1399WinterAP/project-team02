package main.java.app;

import main.java.socket.Server;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
