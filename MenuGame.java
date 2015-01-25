import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuGame {
	private static boolean gameStatus = true;
	public static int clics;

	public void setGameStatus(boolean gameStatus) {
		this.gameStatus = gameStatus;
	}

	public static void sumaClics() {
		if (clics > 7) {
			System.out.println("\tYou Win!");
			MenuGame meGame = new MenuGame();
			meGame.exit();
		}

	}

	public void exit() {
		setGameStatus(false);

	}

	public static void mesage() {
		System.out.println("\tFor exit pres q");
	}

	public static void checkOnExit(String s) {
		if (s.equals("q")) {
			System.out.println("Good bye!");
			System.exit(0);
		} else {

		}
	}

	public static void main(String[] args) {

		PlayingField playingField = new PlayingField();
		playingField.fillField();
		playingField.showField();
		Scanner scanner = new Scanner(System.in);
		while (gameStatus) {
			mesage();
			System.out.print("Enter X:");
			String inputValueX = scanner.next();
			checkOnExit(inputValueX);
			try {
				int coordinateX = Integer.parseInt(inputValueX);
				clics++;
				System.out.println("Enter Y:");
				String inputValueY = scanner.next();
				int coordinateY = Integer.parseInt(inputValueY);
				clics++;
				Point point = new Point(coordinateX, coordinateY);
				playingField.playerMove(point);
				sumaClics();
			} catch (NumberFormatException e) {
			}
		}

	}
}
