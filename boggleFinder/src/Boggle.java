import java.util.Stack;
import java.util.Vector;

public class Boggle {

  private Stack<String> constructedWords;
  private Stack<Tile> tilesToCheck;

  public Boggle() {
    constructedWords = new Stack<String>();
    tilesToCheck = new Stack<Tile>();
  }


  public Boolean doesExist(String inputWord) {
    Tile [][] board = setupExampleBoard();

    String blankWord = "";

    //Start by pushing all the tiles to the list of tiles to check, with no word to start
    for (int x = board.length - 1; x > -1; x--) {
      for (int y = board[x].length - 1; y > -1; y--) {
        Tile thisTile = board[x][y];
        tilesToCheck.push(thisTile);
        constructedWords.push(blankWord);
      }
    }

    //while there are still tiles to check
    while (tilesToCheck.size() > 0) {
      Tile tileToCheck = tilesToCheck.pop();
      String wordToCheck = constructedWords.pop();

      //Check the Tile at the top of the Stack, and the associated word so far
      StringBuilder wordBuilder = new StringBuilder(wordToCheck);

      int constructedWordLength = wordToCheck.length();
      char nextNeededLetter = inputWord.charAt(constructedWordLength);
      char tileLetter = tileToCheck.getLetter();

      if (tileLetter == nextNeededLetter && !tileToCheck.getInWord()) {
        wordBuilder.append(tileLetter);
        tileToCheck.setInWord(true);

        if (wordBuilder.toString().equals(inputWord)) {
          return true;
        }

        Stack<Tile> nextPossibleTiles = getTileNeighbors(board,tileToCheck);

        int numberOfNeighbors = nextPossibleTiles.size();

        for (int i = 0; i < numberOfNeighbors; i++) {
          constructedWords.push(wordBuilder.toString());
        }
        tilesToCheck.addAll(nextPossibleTiles);
      }
      //tileToCheck.setInWord(false);
    }
    return false;
  }


  /**
   * Sets up a board of boggle, with the following orientation:
   * |P|Q|G|P|
   * |F|A|R|M|
   * |A|R|E|R|
   * |S|B|E|S|
   * @returns a 2D Tile array
   */
  private Tile[][] setupExampleBoard() {

    Tile[][] board = new Tile[4][4];

    board[0][0] = new Tile(0,0, 'P');
    board[0][1] = new Tile(0,1, 'Q');
    board[0][2] = new Tile(0,2, 'G');
    board[0][3] = new Tile(0,3, 'P');

    board[1][0] = new Tile(1,0, 'F');
    board[1][1] = new Tile(1,1, 'A');
    board[1][2] = new Tile(1,2, 'R');
    board[1][3] = new Tile(1,3, 'M');


    board[2][0] = new Tile(2,0, 'A');
    board[2][1] = new Tile(2,1, 'R');
    board[2][2] = new Tile(2,2, 'E');
    board[2][3] = new Tile(2,3, 'R');


    board[3][0] = new Tile(3,0, 'S');
    board[3][1] = new Tile(3,1, 'B');
    board[3][2] = new Tile(3,2, 'E');
    board[3][3] = new Tile(3,3, 'S');

    //System.out.println(board.length);
    return board;
  }

  //returns a Stack of all the Tile's that neighbor the input tile
  private Stack<Tile> getTileNeighbors(Tile[][] board, Tile thisTile) {

    int xMax = board.length;
    int yMax = board[0].length;

    Stack<Tile> neighborStack = new Stack<Tile>();
    int thisX = thisTile.getxCoord();
    int thisY = thisTile.getyCoord();

    boolean[] directionsToCheck = getValidDirections(xMax, yMax, thisTile);

    // if checking above
    if (directionsToCheck[0]) {
      Tile tileAbove = board[thisX][thisY - 1];
      neighborStack.push(tileAbove);

      // if also checking left, check topLeft
      if (directionsToCheck[2]) {
        Tile topLeftTile = board[thisX - 1][thisY - 1];
        neighborStack.push(topLeftTile);
      }

      // if also checking right, check topRight
      if (directionsToCheck[3]) {
        Tile topRightTile = board[thisX + 1][thisY - 1];
        neighborStack.push(topRightTile);
      }
    }

    // if checking below
    if (directionsToCheck[1]) {
      Tile tileBelow = board[thisX][thisY + 1];
      neighborStack.push(tileBelow);

      // if also checking left, check bottomLeft
      if (directionsToCheck[2]) {
        Tile bottomLeftTile = board[thisX - 1][thisY + 1];
        neighborStack.push(bottomLeftTile);
      }

      // if also checking right, check bottomRight
      if (directionsToCheck[3]) {
        Tile bottomRightTile = board[thisX + 1][thisY + 1];
        neighborStack.push(bottomRightTile);
      }
    }

    // add left, right Tile to stack as needed
    if (directionsToCheck[2]) {
      Tile leftTile = board[thisX - 1][thisY];
      neighborStack.push(leftTile);
    }
    if (directionsToCheck[3]) {
      Tile rightTile = board[thisX + 1][thisY];
      neighborStack.push(rightTile);
    }

    return neighborStack;
  }

  //returns whether or not to check a direction as a bool array
  // in the format [up, down, left, right]
  private boolean[] getValidDirections(int xMax, int yMax, Tile inputTile) {

    boolean checkAbove = true;
    boolean checkBelow = true;
    boolean checkRight = true;
    boolean checkLeft = true;

    int thisX = inputTile.getxCoord();
    int thisY = inputTile.getyCoord();

    //if top row, then can't check above
    if (thisY == 0) {
      checkAbove = false;
    }

    //if bottom row, then can't check below
    if (thisY == yMax - 1) {
      checkBelow = false;
    }

    //if left most row, then can't check left
    if (thisX == 0) {
      checkLeft = false;
    }

    //if right most row, then can't check right
    if (thisX == xMax - 1) {
      checkRight = false;
    }

    boolean[] outputArray = new boolean[4];
    outputArray[0] = checkAbove;
    outputArray[1] = checkBelow;
    outputArray[2] = checkLeft;
    outputArray[3] = checkRight;

    return outputArray;
  }


}
