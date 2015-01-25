import java.util.Random;

public class PlayingField {

	String field[][] = new String[5][5];
	MenuGame menuGame = new MenuGame();
	String boardX[] = { "Y", "0", "1", "2", "3", "4", "  : X" };

	public void fillField() {
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field.length; j++) {
				field[i][j] = "*";
			}
		}
	}

	public void showBoard() {
		for (int i = 0; i < boardX.length; i++) {
			System.out.print(boardX[i] + " ");
		}
	}

	public void showField() {
		showBoard();
		System.out.println();
		for (int i = 0; i < field.length; i++) {
			System.out.print(i + " ");

			for (int j = 0; j < field.length; j++) {
				System.out.print(field[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean equalsPointWithBomb(Point p, Bomb b) {
		if (p.getPositionX() == b.getPositionX()
				&& p.getPositionY() == b.getPositionY()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkPointAndBomb(Point point) {

		Random rand = new Random();
		int positionX1 = rand.nextInt(4);
		int positionY1 = rand.nextInt(4);
		Bomb bomb1 = new Bomb(positionX1, positionY1);
		if (equalsPointWithBomb(point, bomb1)) {
			System.out.println("You Lose!");
			field[positionX1][positionY1] = "!";
			menuGame.exit();
			return true;

		} else {
			return false;
		}
	}

	public void playerMove(Point p) {
		if (checkPointAndBomb(p)) {
		} else {
			int positionOnFieldX = p.getPositionX();
			int positionOnFieldY = p.getPositionY();
			try {
				field[positionOnFieldX][positionOnFieldY] = "0";
			} catch (ArrayIndexOutOfBoundsException e) {
				System.err.println("\nYou went over the brink! \n");
			}
		}
		showField();
	}
}
