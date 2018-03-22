
package gamelogic.challanges;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;


public class LetterGame extends JPanel implements ActionListener {
    private int iChallengeState;
    private static final String characters =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";//random charcters that loop will pick from
    private static final int StringSize = 5;//amunt of random char
    // private static final String bit = "5HpHagT65TZzG1PH3CSu63k8DbpvD8s5ip4nEB3kEsr";//pre given random string

    JPanel pane = new JPanel(new GridLayout(3,1));
    JLabel lab = new JLabel(" ");
    JTextArea inputText = new JTextArea();

    JButton but = new JButton("Press");
    JButton res = new JButton("Reset");
    //String print;


    //////////////////////////////////////////////////////////////////////////
    public LetterGame()
    {
        //getContentPane().add(pane);
        this.add(pane,new GridLayout(2,2));
        pane.add(lab);
        lab.setText(RandomStringToBeGenerated());
        pane.add(inputText);

        pane.add(but);
        pane.add(res);
        but.addActionListener(this);
        res.addActionListener(this);
       // setSize(500,500);
        //setVisible(true);
    }

    //generates random string
    public  String RandomStringToBeGenerated(){

        StringBuffer rand = new StringBuffer();
        for(int i=0; i<StringSize; i++){
            int number = getRandom();
            char ch = characters.charAt(number);
            rand.append(ch);


        }

        return rand.toString();

    }
    /////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
    //returnns random numbers
    private int getRandom() {
        int randomInt = 0;
        Random Generator = new Random();
        randomInt = Generator.nextInt(characters.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
        //////////////////////////////////////////////////////////////////////
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String contents = inputText.getText();

        if(e.getActionCommand().equals("Press"))
        {

            if(contents.equals(lab.getText()))
            {
                isCorrect();

            }
            if(!contents.equals(lab.getText()))
            {
                isWrong();

            }
        }

        if(e.getActionCommand().equals("Reset"))
        {
            resetChallenge();
        }
    }
    public void isCorrect()
    {
        iChallengeState++;
        inputText.setText("well done");
        System.out.println(iChallengeState);
    }
    void isWrong()
    {
        iChallengeState--;
        inputText.setText("wrong");
        System.out.println(iChallengeState);
    }


    public void resetChallenge()
    {
        lab.setText(RandomStringToBeGenerated());


    }
    public int getState(){
        //Return the state of challenge
        return iChallengeState;
    }
}
