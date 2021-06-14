package main.java.app;

import main.java.model.User;
import main.java.socket.ClientHandler;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;


public class GameManger {

    private static ArrayList<User> joiningUsers = new ArrayList<>();
    private static ArrayList<User> hostUsers = new ArrayList<>();

    private static final ArrayList<ClientHandler> CLIENT_HANDLERS = new ArrayList();

    public static void addSocket(Socket socket) throws IOException {
        ClientHandler clientHandler = new ClientHandler(socket);
        CLIENT_HANDLERS.add(clientHandler);
        clientHandler.start();
    }

    public static void addHost(User host) {
        hostUsers.add(host);
    }

    public static void addJoiningUser(User joiningUser) {
        joiningUsers.add(joiningUser);
    }

    public static boolean searchHost(String hostName) {

        for (var host : hostUsers) {

            if (host.getName().equalsIgnoreCase(normalize(hostName))) {

                return true;
            }
        }
        return false;


    }

    public static String normalize(String text) {
        text = text.replaceAll(" +", " ");
        return text.trim();
    }

    public static void sendShotPosition(String opponent, int x, int y) {
        for (int i = 0; i < CLIENT_HANDLERS.size(); i++) {
            if (CLIENT_HANDLERS.get(i).user.getName().equalsIgnoreCase(opponent)) {

                try {
                    CLIENT_HANDLERS.get(i).DATA_OUTPUT_STREAM.writeUTF("FIRE");
                    CLIENT_HANDLERS.get(i).DATA_OUTPUT_STREAM.writeUTF(String.valueOf(x));
                    CLIENT_HANDLERS.get(i).DATA_OUTPUT_STREAM.writeUTF(String.valueOf(y));
                    System.out.println("giving fir to : " + opponent + " done");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public static void sendOpponentName(String firstOne, String lastOne) {
        for (int i = 0; i < CLIENT_HANDLERS.size(); i++) {
            if (CLIENT_HANDLERS.get(i).user.getName().equalsIgnoreCase(lastOne)) {

                try {
                    CLIENT_HANDLERS.get(i).DATA_OUTPUT_STREAM.writeUTF(firstOne);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    public static void informWinner(String winnerName) {
        for (int i = 0; i < CLIENT_HANDLERS.size(); i++) {
            if (CLIENT_HANDLERS.get(i).user.getName().equalsIgnoreCase(winnerName)) {

                try {
                    CLIENT_HANDLERS.get(i).DATA_OUTPUT_STREAM.writeUTF("WON");
                    System.out.println("giving " + winnerName + " won");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
