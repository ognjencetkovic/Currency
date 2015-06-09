package newpackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Main {

	public static void main(String[] args) {
		DrawWindow w = new DrawWindow();
		draw(w);
	}

	public static void draw(DrawWindow w) {
		BufferedImage img = new BufferedImage(1200, 800,
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D) img.getGraphics();
		// **** Draw here ****

		String[] array = getArrayFromFile();

		for (int i = 0; i < array.length; i++) {
			try {
				drawTeam(g, getCommand(array[i]));
			} catch (Exception e) {
				System.out.println("Illegal command on line: " + i + 1);
			}
		}
		// *******************
		w.setImage(img);
	}

	private static void drawTeam(Graphics2D g, String[] s) {
		switch (s[0]) {
		case "L":
		case "l":
			g.drawLine(Integer.parseInt(s[1]), Integer.parseInt(s[2]),
					Integer.parseInt(s[3]), Integer.parseInt(s[4]));
			break;
		case "DR":
		case "dr":
			g.drawRect(Integer.parseInt(s[1]), Integer.parseInt(s[2]),
					Integer.parseInt(s[3]), Integer.parseInt(s[4]));
			break;
		case "FR":
		case "fr":
			g.fillRect(Integer.parseInt(s[1]), Integer.parseInt(s[2]),
					Integer.parseInt(s[3]), Integer.parseInt(s[4]));
			break;
		case "DO":
		case "do":
			g.drawRect(Integer.parseInt(s[1]), Integer.parseInt(s[2]),
					Integer.parseInt(s[3]), Integer.parseInt(s[4]));
			break;
		case "FO":
		case "fo":
			g.fillRect(Integer.parseInt(s[1]), Integer.parseInt(s[2]),
					Integer.parseInt(s[3]), Integer.parseInt(s[4]));
			break;
		case "S":
		case "s":
			g.drawString(s[1], Integer.parseInt(s[2]), Integer.parseInt(s[3]));
			break;
		case "C":
		case "c":
			g.setColor(getColor(s[1]));
			break;
		case "F":
		case "f":
			g.setFont(new Font(s[1], Integer.parseInt(s[2]), Integer
					.parseInt(s[3])));
			break;
		default:
			System.out.println("Your input non-existent command");
		}
	}

	public static String[] getCommand(String s) {
		return s.split(" ");
	}

	public static String[] getArrayFromFile() {
		String fileName = "src/vrata-2";
		try {
			TextIO.readFile(fileName);
		} catch (Exception e) {
			System.out.println("File does not exist.");
			System.exit(0);
		}
		int length = 0;
		while (!TextIO.eof()) {
			TextIO.getln();
			length++;
		}
		String[] array = new String[length];
		TextIO.readFile(fileName);
		for (int i = 0; i < array.length; i++) {
			array[i] = TextIO.getln();
		}
		return array;
	}

	public static Color getColor(String s) {

		switch (s) {
		case "RED":
			return Color.RED;
		case "BLUE":
			return Color.BLUE;
		case "GREEN":
			return Color.GREEN;
		case "YELLOW":
			return Color.YELLOW;
		case "PINK":
			return Color.PINK;
		case "ORANGE":
			return Color.ORANGE;
		case "GRAY":
			return Color.GRAY;
		case "BLACK":
			return Color.BLACK;
		}
		return Color.WHITE;
	}

}
