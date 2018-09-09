public class Tile {

  private int xCoord;
  private int yCoord;
  private char letter;
  private boolean inWord;

  public Tile(int x, int y, char letter) {
    this.xCoord = x;
    this.yCoord = y;
    this.letter = letter;
    this.inWord = false;
  }

  public int getxCoord() {
    return xCoord;
  }

  public int getyCoord() {
    return yCoord;
  }

  public char getLetter() {
    return letter;
  }

  public boolean getInWord() {
    return inWord;
  }

  public void setInWord(boolean inWord) {
    this.inWord = inWord;
  }

}
