package Reversi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Game {
    private int boardSize;
    private String player1Color;
    private String player2Color;
    private String openPlayer;

    /**
     *
     * @return the board size.
     */
    public int getBoardSize() {
        return boardSize;
    }

    /**
     *
     * @return player 1 color.
     */
    public String getPlayer1Color() {
        return player1Color;
    }

    /**
     *
     * @return player 2 color.
     */
    public String getPlayer2Color() {
        return player2Color;
    }

    /**
     *
     * @return the open player.
     */
    public String getOpenPlayer() {
        return openPlayer;
    }


    public Game(String fileName) {
        BufferedReader br = null;
        FileReader fr = null;
        Map<String, String> settingsMap = new HashMap<String, String>();
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] parts = sCurrentLine.split(" : ");
                settingsMap.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        openPlayer = settingsMap.get("open player");
        player1Color = settingsMap.get("player 1 color");
        player2Color = settingsMap.get("player 2 color");
        String size = settingsMap.get("board size");
        String[] parts = size.split("x");
        boardSize = Integer.parseInt(parts[0]);
    }

}
