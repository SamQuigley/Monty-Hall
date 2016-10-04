/*
 *sam quigley
 19/11/14
 *MontyHall.java
 */
import java.util.Random;
import javax.swing.JOptionPane;

public class MontyHall {

    Random gen = new Random();

    //data members
    private int door1 = 0;
    private int door2 = 0;
    private int door3 = 0;

    private int carDoor = 0;
    private int goat1 = 0;
    private int goat2 = 0;

    private int initialGuess = 0;
    private int secondGuess = 0;

    private int stayWin = 0;
    private int switchWin = 0;
    private int stayLose = 0;
    private int switchLose = 0;

    //set methods
    public void setDoors() {
        while (door1 == door2 || door2 == door3 || door1 == door3) {
            door1 = gen.nextInt(3);//num gen
            door2 = gen.nextInt(3);//num gen
            door3 = gen.nextInt(3);//num gen
        }
    }

    public void setInitialGuess() {
        initialGuess = Integer.parseInt(JOptionPane.showInputDialog(null, "What door is the car behind, 1 2 or 3??? "));
    }

    //if - how the game works, if statements.
    public int findCar() {
        if (door1 == 1) {
            carDoor = 1;
            goat1 = 2;
            goat2 = 3;
            return door1;
        } else if (door2 == 1) {
            carDoor = 2;
            goat1 = 1;
            goat2 = 3;
            return door2;
        } else {
            carDoor = 3;
            goat1 = 1;
            goat2 = 2;
            return door3;
        }
    }

    //set methods

    public void setSecondGuess() {
        if (initialGuess == carDoor) {
            JOptionPane.showMessageDialog(null, "Behind door number " + (goat1) + " is a goat. " + "Switch or Stay?");
            secondGuess = Integer.parseInt(JOptionPane.showInputDialog(null, "Please type an integer!"));
            while (secondGuess == goat1) {
			 	secondGuess = Integer.parseInt(JOptionPane.showInputDialog(null, "Don't pick that one! Give it another go"));
            }
        } else if (initialGuess == goat1) {
            JOptionPane.showMessageDialog(null, "Behind door number " + goat2 + " is a goat. " + "Switch or Stay?");
            secondGuess = Integer.parseInt(JOptionPane.showInputDialog(null, "please pick a door beteen 1 and 3 again!"));
            while (secondGuess == goat2) {
                secondGuess = Integer.parseInt(JOptionPane.showInputDialog(null, "Don't pick that one! Give it another go"));
            }
        } else if (initialGuess == goat2) {
            JOptionPane.showMessageDialog(null, "Behind door number " + goat1 + " is a goat. " + "Switch or Stay?");
            secondGuess = Integer.parseInt(JOptionPane.showInputDialog(null, "Please type an integer!"));
            while (secondGuess == goat1) {
                secondGuess = Integer.parseInt(JOptionPane.showInputDialog(null, "Don't pick that one! Give it another go"));
            }
        }

        if(secondGuess > 3 || secondGuess < 1) {
            JOptionPane.showMessageDialog(null, "You have not entered a valid door number between 1 and 3. " + "Your initial choice was " + initialGuess + ". Please Try again");
            secondGuess = Integer.parseInt(JOptionPane.showInputDialog(null, "Please guess again!"));
        }
        JOptionPane.showMessageDialog(null, "Your inital guess was door " + initialGuess + " and your second guess is " + secondGuess);
    }

    public int process() {
        if (initialGuess == carDoor && secondGuess == carDoor) {
            stayWin = 1;
            return stayWin;
        } else if (initialGuess != carDoor && secondGuess == initialGuess) {
            //JOptionPane.showMessageDialog("You stayed and lost!");
            stayLose = 2;
            return stayLose;
        } else if (initialGuess != carDoor && secondGuess == carDoor) {
            //JOptionPane.showMessageDialog("You switched and won!");
            switchWin = 3;
            return switchWin;

        } else if (initialGuess == carDoor && secondGuess != carDoor) {
            //JOptionPane.showMessageDialog("You switched and lost!");
            switchLose = 4;
            return switchLose;
        } else {
            ////JOptionPane.showMessageDialog("an error occured");
            return 5;
        }

    }
}
