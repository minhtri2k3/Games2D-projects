package ScoreBoard;

public class scoreBoard {

  private score score;
  players[] Players_list = null;
  int elements = 0;
  players p ;

  public scoreBoard(score score) {
    data data = new data();
    Players_list = data.getData();
    this.elements = 4; //data.getSize()
    sort();
    this.score = score;
  }
  public void execute() {
    for (int i = 0; i < elements; i++) {
      if (Players_list[i] != null) {
        score.text.append(" " + (i + 1) + "\t" + Players_list[i].toString());
      }
    }
  }

  public void finish(int score) {
    Players_list[elements - 1].setScore(score);
    update();
    System.out.println("done");
    System.out.println(Players_list[elements - 1].toString());
  }

  public void sort() {
    int i, j;
    boolean swapped;
    for (i = 0; i < elements - 1; i++) {
      swapped = false;
      for (j = 0; j < elements - i - 1; j++) {
        if (Players_list[j].getScore() > Players_list[j + 1].getScore()) {
          // Swap arr[j] and arr[j+1]
          players p1 = Players_list[j];
          this.Swap(Players_list[j], Players_list[j + 1]);
          swapped = true;
        }
      }      
      // If no two elements were
      // swapped by inner loop, then break
      if (swapped == false) break;
    }
  }
    public void Swap(players p1, players p2) {
    int tempScore = p1.getScore();
    String tempName = p1.getName();

    p1.setScore(p2.getScore());
    p1.setName(p2.getName());

    p2.setScore(tempScore);
    p2.setName(tempName);
  }

  public void insert1(String name, int score) {
    if (score == 0) {
      players p = new players(name, score);
      Players_list[elements] = p;
      elements++;
    } else {
      players p = new players(name, score);
      Players_list[elements] = p;
      elements++;
      sort();
    }
  }

  public void insert(String name, int score) { // put element into array
    if (score == 0) {
        p = new players(name, score);
      Players_list[elements] = p;
      elements++;
    }
   
  } // end insert(

public void update(){
     {
      int j;
      for (j = 0;j < elements;j++) 
      if ( Players_list[j].getScore() > p.getScore())
       break; // Apply (linear search)
      for (int k = elements;k > j;k--)
        Players_list[k] = Players_list[k - 1]; // move bigger ones up
        Players_list[j] = p; // insert it
    }
}

  public int rank(players p) {
    int rank = 0;
    return rank;
  }

  public void remove(players p) {
    int foundIndex = -1;
    for (int i = 0; i < elements; i++) {
      if (
        Players_list[i] != null && Players_list[i].getName().equals(p.getName())
      ) {
        // Generate shift all the value after delete
        foundIndex = i;
        break;
      }
    }
    if (foundIndex != -1) {
      for (int i = foundIndex; i < elements - 1; i++) {
        Players_list[i] = Players_list[i + 1];
      }
      Players_list[elements - 1] = null;
    } else {
      System.out.println("Player not found" + p.getName());
    }
  }


}
