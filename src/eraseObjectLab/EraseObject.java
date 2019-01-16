package eraseObjectLab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EraseObject {
    private static int MAX_SIDE = 20;
    private static char[][] map;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    static void read() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\eraseObjectLab\\coordIn.txt"));
        map = new char[MAX_SIDE][MAX_SIDE];
        for (int i = 0; i < MAX_SIDE; i++) {
            for (int j = 0; j < MAX_SIDE; j++) {
                map[i][j] = '.';
            }
        }
        int coordCount = Integer.parseInt(in.readLine());
        for (int i = 0; i < coordCount; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int column = Integer.parseInt(st.nextToken()) - 1;
            map[row][column] = '#';
        }
    }
    static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < MAX_SIDE; i++) {
            System.out.print((i + 1) % 10 + " ");
        }
        System.out.println();

        for (int i = 0; i < MAX_SIDE; i++) {
            System.out.print(((i + 1) % 10) + " ");
            for (int j = 0; j < MAX_SIDE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void eraseBFS(int row, int column) {
        Queue<Coord> q = new LinkedList<>();
        q.add(new Coord(column, row));
        while (!q.isEmpty()) {
            Coord curr = q.remove();
            if (curr.x < 0 || curr.x >= MAX_SIDE || curr.y < 0 || curr.y >= MAX_SIDE) continue;
            if (map[curr.y][curr.x] == '.') continue;
            map[curr.y][curr.x] = '.';
            for (int i = 0; i < 4; i++) {
                q.add(new Coord(curr.x + dx[i], curr.y + dy[i]));
            }
        }
    }
    static void eraseDFS(Coord curr) {
        if (curr.x < 0 || curr.x >= MAX_SIDE || curr.y < 0 || curr.y >= MAX_SIDE) return;
        if (map[curr.x][curr.y] == '.') return;
        map[curr.x][curr.y] = '.';
        for (int i = 0; i < 4; i++) {
            eraseDFS(new Coord(curr.x + dx[i], curr.y + dy[i]));
        }
    }
    public static void main(String[] args) throws IOException {
        read();
        printMap();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String strIn = "";
        while (!strIn.equals("Q")) {
            strIn = in.readLine();
            StringTokenizer st = new StringTokenizer(strIn);
            eraseDFS(new Coord(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1));
            printMap();

            for (int i = 0; i < MAX_SIDE; i++) System.out.print("==");
            System.out.println();
        }
    }
    static class Coord {
        int x, y;
        Coord(int a, int b) {
            x = a;
            y = b;
        }
    }
}
