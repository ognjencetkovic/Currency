package newpackage;

import java.util.Scanner;

public class Labirinth {
	public static boolean gameOver = false;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String[] map = readFromFile();
		System.out.println("------AWESOME GAME-----");
		String move = "";
		
		while (!gameOver) {
			printOnConsole(map);
			move = input.next();
			map = move(map, move);
		}
		System.out.println("GAME OVER!6");
		input.close();
	}

	private static String[] move(String[] map, String move) {
		int[] coordinates = getCoordinates(map);
		int x = coordinates[0];
		int y = coordinates[1];
		switch (move) {
		case "8":
		case "w":
			if(map[x - 1].charAt(y) == ' '){
				map[x - 1] = map[x - 1].substring(0, y) + "S" + map[x - 1].substring(y + 1);
				map[x] = map[x].replace('S', ' ');
			} else if (map[x - 1].charAt(y) == 'F'){
				gameOver = true;
			}
			break;
		case "4":
		case "a":
			if(y != 0 && map[x].charAt(y - 1) == ' '){
				map[x] = map[x].replace('S', ' ');
				map[x] = map[x].substring(0, y - 1) + "S" + map[x].substring(y);
			} else if (y != 0 && map[x].charAt(y - 1) == 'F'){
				gameOver = true;
			}
			break;
		case "2":
		case "s":
			if(map[x + 1].charAt(y) == ' '){
				map[x + 1] = map[x + 1].substring(0, y) + "S" + map[x + 1].substring(y + 1);
				map[x] = map[x].replace('S', ' ');
			} else if (map[x + 1].charAt(y) == 'F'){
				gameOver = true;
			}
			break;
		case "6":
		case "d":
			if(map[x].charAt(y + 1) == ' '){
				map[x] = map[x].replace('S', ' ');
				map[x] = map[x].substring(0, y + 1) + "S" + map[x].substring(y + 2);
			} else if (map[x].charAt(y + 1) == 'F'){
				gameOver = true;
			}
			break;
		}
		return map;
	}

	private static void printOnConsole(String[] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length(); j++) {
				char[] c = map[i].toCharArray();
				System.out.print(c[j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------");
	}

	public static String[] readFromFile() {
		TextIO.readFile("src/mapa1");
		int counter = 0;
		while (!TextIO.eof()) {
			TextIO.getln();
			counter++;
		}
		String[] array = new String[counter];
		TextIO.readFile("src/mapa1");
		for (int i = 0; i < counter; i++) {
			String s = TextIO.getln();
			array[i] = s;
		}
		return array;
	}

	public static int[] getCoordinates(String[] s) {
		int[] coordinates = new int[2];
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length(); j++) {
				if (s[i].charAt(j) == 'S') {
					coordinates[0] = i;
					coordinates[1] = j;
					break;
				}
			}
		}
		return coordinates;
	}

}
