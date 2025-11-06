package lab_02c;

import javax.swing.JOptionPane;

public class IncGoalDiaBox {
    public static void main(String[] args) {
        String userName = JOptionPane.showInputDialog("Enter your name: ");
        double userIncomeGoal = Double.parseDouble(JOptionPane.showInputDialog("Now your income: "));

        String msg = String.format(
            "%s, I hope you manage to achieve $%,.2f soon!!!", userName, userIncomeGoal
        );

        JOptionPane.showMessageDialog(null, msg);
        
        System.exit(0);

    }

}

