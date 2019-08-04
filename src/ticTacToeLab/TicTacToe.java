package ticTacToeLab;

import java.util.*;

public class TicTacToe {
    static int boardLen;
    static char[][] board = new char[1000][1000];
    static String[] letter = {"A", "B", "C"};
    static boolean place(int x, int y, char player) {
        if (x < 0 || x >= boardLen || y < 0 || y >= boardLen) return false;
        if (board[x][y] == ' ') {
            board[x][y] = player;
            return true;
        }
        return false;
    }
    static void print() {
        System.out.print("   ");
        for (int i = 1; i <= boardLen; i++) System.out.print((i % 10) + " ");
        System.out.println();
        for (int i = 0; i < boardLen; i++) {
            for (int j = 0; j < boardLen; j++) {
                if (j == 0) System.out.print(((i + 1) % 10) + " |");
                System.out.print(board[j][i] + "|");
            }
            System.out.println();
        }
    }
    static boolean win() {
        boolean win = true;
        for (int i = 0; i < boardLen; i++) {
            char cur = board[i][0];
            if (cur == ' ') win = false;
            for (int j = 0; j < boardLen; j++) {
                if (board[i][j] != cur) win = false;
            }
            if (win) return true;
        }
        win = true;
        for (int i = 0; i < boardLen; i++) {
            char cur = board[0][i];
            if (cur == ' ') win = false;
            for (int j = 0; j < boardLen; j++) {
                if (board[j][i] != cur) win = false;
            }
            if (win) return true;
        }
        win = true;
        for (int i = 0; i < boardLen; i++) {
            char cur = board[0][0];
            if (cur == ' ') win = false;
            if (board[i][i] != cur) win = false;
        }
        if (win) return true;
        win = true;
        for (int i = 0; i < boardLen; i++) {
            char cur = board[boardLen - 1][0];
            if (cur == ' ') win = false;
            if (board[boardLen - 1 - i][i] != cur) win = false;
        }
        if (win) return true;
        return false;
    }
    static void player(char symbol, String message) {
        boolean canPlace = false;
        System.out.print(message);
        int x = -1, y = -1;

        Scanner in = new Scanner(System.in);
        while (!canPlace) {
            x = in.nextInt() - 1;
            y = in.nextInt() - 1;
            if (place(x, y, symbol)) {
                canPlace = true;
            } else {
                System.out.print("Space invalid, choose again: ");
            }
        }
    }
    static void computer(char symbol, String message) {
        System.out.print(message);

        //test if comp can win
        for (int i = 0; i < boardLen; i++) {
            for (int j = 0; j < boardLen; j++) {
                if (board[j][i] != ' ') continue;
                board[j][i] = symbol;
                if (win()) {
                    System.out.println((j + 1) + " " + (i + 1));
                    return;
                }
                board[j][i] = ' ';
            }
        }
        //test if player can win
        char anti = ((symbol == 'X') ? 'O':'X');
        for (int i = 0; i < boardLen; i++) {
            for (int j = 0; j < boardLen; j++) {
                if (board[j][i] != ' ') continue;
                board[j][i] = anti;
                if (win()) {
                    board[j][i] = symbol;
                    System.out.println((j + 1) + " " + (i + 1));
                    return;
                }
                board[j][i] = ' ';
            }
        }

        //random
        boolean canPlace = false;
        int x = -1, y = -1;
        while (!canPlace) {
            x = (int)(Math.random() * boardLen);
            y = (int)(Math.random() * boardLen);
            if (place(x, y, symbol)) {
                canPlace = true;
            }
        }
        System.out.println((x + 1) + " " + (y + 1));
    }
    static void play() throws InterruptedException {
        for (int i = 0; i < boardLen; i++) {
            for (int j = 0; j < boardLen; j++) {
                board[i][j] = ' ';
            }
        }
        Scanner in = new Scanner(System.in);
        System.out.println("[1] Vs. Computer");
        System.out.println("[2] Vs. Player");
        System.out.println();
        System.out.print("Choose opponent (1/2): ");
        int choice = in.nextInt();
        for (int i = 0; i < boardLen * boardLen; i++) {
            if (i % 2 == 0) { //player's turn
                print();
                player('X', "Player I: ");
                if (win()) {
                    print();
                    System.out.println("Player I Wins");
                    break;
                }
            } else {
                if (choice == 1) {
                    computer('O', "Computer: ");
                    if (win()) {
                        print();
                        System.out.println("Computer Wins");
                        break;
                    }
                } else {
                    print();
                    player('O', "Player II: ");
                    if (win()) {
                        print();
                        System.out.println("Player II Wins");
                        break;
                    }
                }
            }
            Thread.sleep(1000);
        }
        System.out.println();
    }
    static void loadingScreen() throws InterruptedException {
        System.out.print("Loading");
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.print(".");
        }
        Thread.sleep(1000);
        System.out.println();
    }
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);

        System.out.println("=== Tic Tac Toe ===");
        Thread.sleep(1000);
        System.out.println("Instructions:");
        System.out.println("Rounds will alternate until board is full\nInput format is 'x' 'y'\nFirst player to get a straight line from edge to edge is the winner");


        loadingScreen();

        boolean start = true;
        while (start) {
            System.out.print("Input board length (1-1000): ");
            boardLen = in.nextInt();
            play();
            System.out.print("Restart? (y/n): ");
            String a = in.next();
            start = a.toLowerCase().equals("y");
        }
    }
}
