package main.java.socket;

import main.java.app.GameManger;
import main.java.model.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static main.java.app.GameManger.normalize;

public class ClientHandler extends Thread {
    private final Socket SOCKET;
    public final DataInputStream DATA_INPUT_STREAM;
    public final DataOutputStream DATA_OUTPUT_STREAM;
    private final String FOUND_HOST = "FOUND";
    private final String HOST_NOT_FOUND = "NOT_FOUND";
    public User user;

    public ClientHandler(Socket socket) throws IOException {

        this.SOCKET = socket;
        this.DATA_INPUT_STREAM = new DataInputStream(SOCKET.getInputStream());
        this.DATA_OUTPUT_STREAM = new DataOutputStream(SOCKET.getOutputStream());

        user = null;
    }

    @Override
    public void run() {

        while (true) {

            try {


                var command = DATA_INPUT_STREAM.readUTF();
                String name;

                switch (command) {
                    case "HOST":
                        name = DATA_INPUT_STREAM.readUTF();
                        user = new User(name);

                        GameManger.addHost(user);

                        break;
                    case "JOIN":
                        name = DATA_INPUT_STREAM.readUTF();
                        user = new User(name);

                        GameManger.addJoiningUser(user);

                        String hostName = DATA_INPUT_STREAM.readUTF();

                        // var message = DATA_INPUT_STREAM.readUTF();

                        if (GameManger.searchHost(hostName)) {

                            DATA_OUTPUT_STREAM.writeUTF(FOUND_HOST);

                            GameManger.sendOpponentName(name, normalize(hostName));
                            GameManger.sendOpponentName(normalize(hostName), name);
                        } else {
                            DATA_OUTPUT_STREAM.writeUTF(HOST_NOT_FOUND);
                        }
                        break;

                    case "FIRE":
                        System.out.println("getting fire...");
                        String opponent = DATA_INPUT_STREAM.readUTF();

                        int x = Integer.parseInt(DATA_INPUT_STREAM.readUTF());
                        int y = Integer.parseInt(DATA_INPUT_STREAM.readUTF());
                        GameManger.sendShotPosition(opponent, x, y);
                        System.out.println("getting fire done");


                        break;

                    case "WON":
                        String winnerName = DATA_INPUT_STREAM.readUTF();
                        GameManger.informWinner(winnerName);

                }


            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }


}
