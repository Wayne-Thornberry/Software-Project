package game.challanges;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ChallengePicture extends JPanel implements ActionListener {//class start
    private int iChallengeState;
    //pannels
    JPanel paneLabel = new JPanel(new GridLayout(1,2));//north
    JPanel paneButtons = new JPanel(new GridLayout(1,5));//center
    JPanel paneSouth = new JPanel(new GridLayout(1,3));//south



    //center panel buttons that contain images
    private JButton bImgOne;
    private JButton bImgTwo;
    private JButton bImgThree;
    private JButton bImgFour;
    private JButton bImgFive;
    //top label (north) labe ldisplaying question
    private JLabel lTopLabel;
    // south label and button displaying correct/wrong and button to restart
    private JLabel lBottomLabel;
    private JButton bRessetButton;
    private JButton bSendButton;


    //not sure how im gonna implentnt boolean state as of yet
    private boolean bPicOne;
    private boolean bPicTwo;
    private boolean bPicThree;
    private boolean bPicFour;
    private boolean bPicFive;

    private static BorderLayout cLayout;

    ImageIcon correct = new ImageIcon("correct.jpg");
    ImageIcon wrong = new ImageIcon("wrong.png");

    //correct and wrong images for buttons
    ImageIcon red = new ImageIcon("red.jpg");
    ImageIcon blue = new ImageIcon("blue.jpg");
    //yellow and black
    ImageIcon yellow = new ImageIcon("yellow.jpg");
    ImageIcon black = new ImageIcon("black.png");

    public ChallengePicture(int iNumber)
    {//testImgChall start
        add(paneLabel);
       add(paneButtons);
       add(paneSouth);
        this.setBorder(BorderFactory.createEtchedBorder());
        //adding panels to the frame
        this.add(paneLabel,BorderLayout.PAGE_START);
        this.add(paneButtons,BorderLayout.CENTER);
        this.add(paneSouth,BorderLayout.PAGE_END);
//adding img buttoms to the panel
        bImgOne = new JButton("red", new ImageIcon("red.jpg"));
        paneButtons.add(bImgOne);
        bImgOne.addActionListener(this);
        bImgTwo = new JButton("blue", new ImageIcon("blue.jpg"));
        paneButtons.add(bImgTwo);
        bImgTwo.addActionListener(this);
        bImgThree = new JButton("red1", new ImageIcon("red.jpg"));
        paneButtons.add(bImgThree);
        bImgThree.addActionListener(this);
        bImgFour = new JButton("blue1", new ImageIcon("blue.jpg"));
        paneButtons.add(bImgFour);
        bImgFour.addActionListener(this);
        bImgFive = new JButton("red2", new ImageIcon("red.jpg"));
        paneButtons.add(bImgFive);
        bImgFive.addActionListener(this);
//adding north label to the panel
        lTopLabel = new JLabel("CLICK ON RED IMAGE!!!");
        paneLabel.add(lTopLabel);
        lTopLabel.setPreferredSize(new Dimension(200, 100));
// adding south label and button to the panel
        lBottomLabel = new JLabel(" ");
        paneSouth.add(lBottomLabel);
        lBottomLabel.setPreferredSize(new Dimension(200, 100));
        bRessetButton = new JButton("RESTART");
        paneSouth.add(bRessetButton);
        bRessetButton.addActionListener(this);
        bRessetButton.setPreferredSize(new Dimension(200, 100));
        bSendButton = new JButton("SEND");
        paneSouth.add(bSendButton);
        bSendButton.addActionListener(this);
        bSendButton.setPreferredSize(new Dimension(200, 100));

// setting visible and size of the frame
       // setSize(300,300);
        //setVisible(true);

    }//testImgChall end

  /*public static void main(String []args)
    {
		ChallengePicture nna = new ChallengePicture();
	}*/
   @Override
    public void actionPerformed(ActionEvent e)
    {//action performed start

        //one
        if (e.getActionCommand().equals ("red")){
            bPicOne=true;
            bImgOne.setIcon(correct);
            lBottomLabel.setText("Well done!!!");
        }

        else
        {
            bPicOne=false;
        }
        //three
        if (e.getActionCommand().equals ("red1")){
            bPicThree=true;
            bImgThree.setIcon(correct);
            lBottomLabel.setText("Well done!!!");
        }
        else
        {
            bPicThree=false;
        }
        //five
        if (e.getActionCommand().equals ("red2")){
            bPicFive=true;
            bImgFive.setIcon(correct);
            lBottomLabel.setText("Well done!!!");
        }
        else
        {
            bPicFive=false;
        }
        //two
        if (e.getActionCommand().equals ("blue")){
            bPicTwo=true;
            //createChallenge();
            bImgTwo.setIcon(wrong);
            lBottomLabel.setText("Wrong!!!");

        }
        else
        {
            bPicTwo=false;
        }
        //four
        if (e.getActionCommand().equals ("blue1")){
            bPicFour=true;
            //createChallenge();
            bImgFour.setIcon(wrong);
            lBottomLabel.setText("Wrong!!!");
        }
        else
        {
            bPicFour=false;
        }
        if(e.getActionCommand().equals ("RESTART"))
        {
            //createChallenge();
            lBottomLabel.setText(" ");

        }
        if(e.getActionCommand().equals("SEND"))
        {
            isCorrect();
            iChallengeState++;
        }
    }//action performed end

    //second action performed for new colors
  /*  public void actionPerformed2(ActionEvent c)
    {
        if (c.getActionCommand().equals ("red")){
            bPicOne=true;
            bImgOne.setIcon(correct);
            lBottomLabel.setText("Well done!!!");
        }

        else
        {
            bPicOne=false;
        }
        //three
        if (c.getActionCommand().equals ("red1")){
            bPicThree=true;
            bImgThree.setIcon(correct);
            lBottomLabel.setText("Well done!!!");
        }
        else
        {
            bPicThree=false;
        }
        //five
        if (c.getActionCommand().equals ("red2")){
            bPicFive=true;
            bImgFive.setIcon(correct);
            lBottomLabel.setText("Well done!!!");
        }
        else
        {
            bPicFive=false;
        }
        //two
        if (c.getActionCommand().equals ("blue")){
            bPicTwo=true;
            createChallenge();
            bImgTwo.setIcon(wrong);
            lBottomLabel.setText("Wrong!!!");

        }
        else
        {
            bPicTwo=false;
        }
        //four
        if (c.getActionCommand().equals ("blue1")){
            bPicFour=true;
            createChallenge();
            bImgFour.setIcon(wrong);

            lBottomLabel.setText("Wrong!!!");

        }
        else
        {
            bPicFour=false;
        }
        if(c.getActionCommand().equals ("RESTART"))
        {
            createChallenge();
            lBottomLabel.setText(" ");

        }
    }*/


    private boolean isCorrect(){
        // Return if your pattern or task is correct

            lBottomLabel.setText(" WOW AREN'T YOU AMAZING");


        return true;
    }

    public void resetChallenge(int iNumber)
    {
        bImgOne.setIcon(red);
        bImgTwo.setIcon(blue);
        bImgThree.setIcon(red);
        bImgFour.setIcon(blue);
        bImgFive.setIcon(red);

    }

    public void setStickerNo(int test){

    }

    public int getState(){
        return iChallengeState;
    }

    public void setState(int state) {
        iChallengeState = state;
    }
}//class end
