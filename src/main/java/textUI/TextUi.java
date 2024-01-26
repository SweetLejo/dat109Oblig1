package textUI;

import java.util.Scanner;

public class TextUi {

    private String menu = "=========="
            + "1. start new game: \n"
            + "2.  continue game \n"
            + "3. delete game \n"
            + "==========";

    public void printUi(){
        System.out.println(menu);
    }

    public void registerInput(){
        Scanner in = new Scanner(System.in);
        this.printUi();
        String answer = in.nextLine();
        switch (answer){
            case "1" -> startNewGame();
            case "2" -> loadGame();
            case "3" -> deleteData();
            default -> System.out.println("nothing selected now exiting");
        }
    }

    private void startNewGame(){

    }

    private void loadGame(){

    }

    private void deleteData(){

    }

}