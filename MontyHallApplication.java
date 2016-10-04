/*
 *sam quigley
 *19/12/14
 *MontyHallApplication.java
 */
//JOptionPane
import javax.swing.JOptionPane;

//class name and main method
public class MontyHallApplication {

    public static void main(String args[]) {
        //vars
        int runAmount = 0;
        int Iterator = 1;
        int totalStayWins = 0;
        int totalStayLoss = 0;
        int totalSwitchWins = 0;
        int totalSwitchLoss = 0;

        JOptionPane.showMessageDialog(null, "Welcome to the Monty Hall Game!");
        //how many times the user will run the game
        runAmount = Integer.parseInt(JOptionPane.showInputDialog(null, "please enter the amount of times you would like to play the game using a numerical value!!"));
        while (Iterator <= runAmount) {
            MontyHall processor = new MontyHall();
            processor.setDoors();
            processor.findCar();
            processor.setInitialGuess();
            processor.setSecondGuess();

            //if statements that count your total wins and lossses, by by staying and switching!
            if (processor.process() == 1) {
                totalStayWins++;
                JOptionPane.showMessageDialog(null, " You stayed and won! ");
            } else if (processor.process() == 2) {
                totalStayLoss++;
                JOptionPane.showMessageDialog(null, " You stayed and lost! ");
            } else if (processor.process() == 3) {
                totalSwitchWins++;
                JOptionPane.showMessageDialog(null, " You switched and won! ");

            } else if (processor.process() == 4) {
                totalSwitchLoss++;
                JOptionPane.showMessageDialog(null, " You switched and lost! ");
            } else {
                JOptionPane.showMessageDialog(null, " There is an error ");
            }
            Iterator++;
            JOptionPane.showMessageDialog(null, " End of loop ");

        }

        //show total amount of times the user has won and lost,by switching and staying!
        JOptionPane.showMessageDialog(null, " Your Wins by staying are " + totalStayWins + " and your losses by staying  are " + totalStayLoss);
        JOptionPane.showMessageDialog(null, " Your Wins by switching are " + totalSwitchWins + " and your Losses by switching are " + totalSwitchLoss);
    }
}
