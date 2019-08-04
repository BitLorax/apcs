
package ticTacToeGUILab;

// ============================================================================
//     Taken From: http://programmingnotes.org/
// ============================================================================
import com.sun.org.apache.bcel.internal.generic.Select;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener
{
    // setting up ALL the variables
    JFrame window = new JFrame("Kenneth's Tic Tac Toe Game");

    JMenuBar mnuMain = new JMenuBar();
    JMenuItem   mnuNewGame = new JMenuItem("  New Game"), 
    mnuGameTitle = new JMenuItem("|Tic Tac Toe|  "),
    mnuStartingPlayer = new JMenuItem(" Starting Player"),
    mnuSetSize = new JMenuItem(" Set Size"),
    mnuSetOppo = new JMenuItem(" Set Opponent"),
    mnuExit = new JMenuItem("    Quit");

    JButton btnEmpty[] = new JButton[100 * 100 + 1];
    int size = 3;

    JPanel  pnlNewGame = new JPanel(),
    pnlNorth = new JPanel(),
    pnlSouth = new JPanel(),
    pnlTop = new JPanel(),
    pnlBottom = new JPanel(),
    pnlPlayingField = new JPanel();
    JPanel radioPanel = new JPanel();
    JPanel oppoPanel = new JPanel();

    boolean playingPlayer = true;

    private JRadioButton SelectX = new JRadioButton("User Plays X", false);
    private  JRadioButton SelectO = new JRadioButton("User Plays O", false);
    private JRadioButton SelectPlayer = new JRadioButton("Player", false);
    private  JRadioButton SelectComp = new JRadioButton("Computer", false);
    private ButtonGroup radioGroup;
    private ButtonGroup setOppoGroup;
    private  String startingPlayer= "";
    final int X = 800, Y = 480, color = 190; // size of the game window
    private boolean inGame = false;
    private boolean win = false;
    private boolean btnEmptyClicked = false;
    private boolean setTableEnabled = false;
    private String message;
    private Font font = new Font("Rufscript", Font.BOLD, 100);
    private int remainingMoves = 1;

    //===============================  GUI  ========================================//
    private void initialize() {
        //Setting window properties:
        window.setSize(X, Y);
        window.setLocation(300, 180);
        window.setResizable(true);
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //------------  Sets up Panels and text fields  ------------------------//
        // setting Panel layouts and properties
        pnlNorth.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlSouth.setLayout(new FlowLayout(FlowLayout.CENTER));

        pnlNorth.setBackground(new Color(70, 70, 70));
        pnlSouth.setBackground(new Color(color, color, color));

        pnlTop.setBackground(new Color(color, color, color));
        pnlBottom.setBackground(new Color(color, color, color));

        pnlTop.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlBottom.setLayout(new FlowLayout(FlowLayout.CENTER));

        radioPanel.setBackground(new Color(color, color, color));
        oppoPanel.setBackground(new Color(color, color, color));
        pnlBottom.setBackground(new Color(color, color, color));
        radioPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Who Goes First?"));
        oppoPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Choose Opponent"));

        // adding menu items to menu bar
        mnuMain.add(mnuGameTitle);
        mnuGameTitle.setEnabled(false);
        mnuGameTitle.setFont(new Font("Purisa",Font.BOLD,18));
        mnuMain.add(mnuNewGame);
        mnuNewGame.setFont(new Font("Purisa",Font.BOLD,18));
        mnuMain.add(mnuStartingPlayer);
        mnuStartingPlayer.setFont(new Font("Purisa",Font.BOLD,18));
        mnuMain.add(mnuSetSize);
        mnuSetSize.setFont(new Font("Purisa",Font.BOLD,18));
        mnuMain.add(mnuSetOppo);
        mnuSetOppo.setFont(new Font("Purisa",Font.BOLD,18));
        mnuMain.add(mnuExit);
        mnuExit.setFont(new Font("Purisa",Font.BOLD,18));//---->Menu Bar Complete

        // adding X & O options to menu
        SelectX.setFont(new Font("Purisa",Font.BOLD,18));
        SelectO.setFont(new Font("Purisa",Font.BOLD,18));
        SelectPlayer.setFont(new Font("Purisa",Font.BOLD,18));
        SelectComp.setFont(new Font("Purisa",Font.BOLD,18));
        radioGroup = new ButtonGroup(); // create ButtonGroup
        radioGroup.add(SelectX); // add plain to group
        radioGroup.add(SelectO);
        radioPanel.add(SelectX);
        radioPanel.add(SelectO);
        setOppoGroup = new ButtonGroup();
        setOppoGroup.add(SelectPlayer); // add plain to group
        setOppoGroup.add(SelectComp);
        oppoPanel.add(SelectPlayer);
        oppoPanel.add(SelectComp);

        // adding Action Listener to all the Buttons and Menu Items
        mnuNewGame.addActionListener(this);
        mnuExit.addActionListener(this);
        mnuStartingPlayer.addActionListener(this);
        mnuSetSize.addActionListener(this);
        mnuSetOppo.addActionListener(this);

        // setting up the playing field
        pnlPlayingField.setLayout(new GridLayout(size, size, 2, 2));
        pnlPlayingField.setBackground(Color.black);
        for(int x=1; x < size * size + 1; ++x)
        {
            btnEmpty[x] = new JButton();
            btnEmpty[x].setBackground(new Color(220, 220, 220));
            btnEmpty[x].addActionListener(this);
            pnlPlayingField.add(btnEmpty[x]);
            btnEmpty[x].setEnabled(setTableEnabled);
        }

        // adding everything needed to pnlNorth and pnlSouth
        pnlNorth.add(mnuMain);
        BusinessLogic.ShowGame(pnlSouth,pnlPlayingField);

        // adding to window and Showing window
        window.add(pnlNorth, BorderLayout.NORTH);
        window.add(pnlSouth, BorderLayout.CENTER);
        window.setVisible(true);
    }
    public GUI() //This is the constructor
    {
        initialize();
    }// End GUI

    // ===========  Start Action Performed  ===============//
    public void actionPerformed(ActionEvent click)  
    {
        // get the mouse click from the user
        Object source = click.getSource();

        // check if a button was clicked on the gameboard
        for(int currentMove=1; currentMove < size * size + 1; ++currentMove)
        {
            if(source == btnEmpty[currentMove] && remainingMoves < size * size + 1)
            {
                btnEmptyClicked = true;
                BusinessLogic.GetMove(currentMove, remainingMoves, font,
                    btnEmpty, startingPlayer);
                btnEmpty[currentMove].setEnabled(false);
                pnlPlayingField.requestFocus();
                if (!playingPlayer) botMove();
                remainingMoves++;
            }
        }

        // if a button was clicked on the gameboard, check for a winner
        if(btnEmptyClicked) 
        {
            inGame = true;
            CheckWin();
            btnEmptyClicked = false;
            if (win) {
                if (remainingMoves % 2 == 0) {
                    JOptionPane.showMessageDialog(null, startingPlayer + " wins");
                } else {
                    JOptionPane.showMessageDialog(null, ((startingPlayer.equals("X") ) ? "O" : "X") + " wins");
                }
            }
        }

        // check if the user clicks on a menu item
        if(source == mnuNewGame)    
        {
            System.out.println(startingPlayer);
            BusinessLogic.ClearPanelSouth(pnlSouth,pnlTop,pnlNewGame,
                pnlPlayingField,pnlBottom,radioPanel);
            if(startingPlayer.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Select a Starting Player", 
                    "Oops..", JOptionPane.ERROR_MESSAGE);
                BusinessLogic.ShowGame(pnlSouth,pnlPlayingField);
            }
            else
            {
                if(inGame)  
                {
                    int option = JOptionPane.showConfirmDialog(null, "If you start a new game," +
                            " your current game will be lost..." + "n" +"Are you sure you want to continue?"
                        , "New Game?" ,JOptionPane.YES_NO_OPTION);
                    if(option == JOptionPane.YES_OPTION)    
                    {
                        inGame = false;
                        startingPlayer = "";
                        setTableEnabled = false;
                    }
                    else
                    {
                        BusinessLogic.ShowGame(pnlSouth,pnlPlayingField);
                    }
                }
                // redraw the gameboard to its initial state
                if(!inGame) 
                {
                    RedrawGameBoard();
                }
            }       
        }       
        // exit button
        else if(source == mnuExit)  
        {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", 
                    "Quit" ,JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
        }
        else if (source == mnuSetSize) {
            if (inGame) {
                JOptionPane.showMessageDialog(null, "Currently in game, finish to resize", "Game In Session..", JOptionPane.INFORMATION_MESSAGE);
                BusinessLogic.ShowGame(pnlSouth,pnlPlayingField);
            } else {
                String str = JOptionPane.showInputDialog("New Size: ");
                size = Integer.parseInt(str);
                pnlPlayingField.removeAll();
                initialize();
            }
        }
        else if (source == mnuSetOppo) {
            if (inGame) {
                JOptionPane.showMessageDialog(null, "Currently in game, finish to change opponent", "Game In Session..", JOptionPane.INFORMATION_MESSAGE);
                BusinessLogic.ShowGame(pnlSouth,pnlPlayingField);
            } else {
                setTableEnabled = true;
                BusinessLogic.ClearPanelSouth(pnlSouth,pnlTop,pnlNewGame,
                        pnlPlayingField,pnlBottom,oppoPanel);

                SelectPlayer.addActionListener(new RadioListener2());
                SelectComp.addActionListener(new RadioListener2());
                oppoPanel.setLayout(new GridLayout(2,1));

                oppoPanel.add(SelectPlayer);
                oppoPanel.add(SelectComp);
                pnlSouth.setLayout(new GridLayout(2, 1, 2, 1));
                pnlSouth.add(oppoPanel);
                pnlSouth.add(pnlBottom);
            }
        }
        // select X or O player 
        else if(source == mnuStartingPlayer)  
        {
            if(inGame)  
            {
                JOptionPane.showMessageDialog(null, "Cannot select a new Starting "+
                    "Player at this time.nFinish the current game, or select a New Game "+
                    "to continue", "Game In Session..", JOptionPane.INFORMATION_MESSAGE);
                BusinessLogic.ShowGame(pnlSouth,pnlPlayingField);
            }
            else
            {
                setTableEnabled = true;
                BusinessLogic.ClearPanelSouth(pnlSouth,pnlTop,pnlNewGame,
                    pnlPlayingField,pnlBottom,radioPanel);

                SelectX.addActionListener(new RadioListener());
                SelectO.addActionListener(new RadioListener());
                radioPanel.setLayout(new GridLayout(2,1));

                radioPanel.add(SelectX);
                radioPanel.add(SelectO);
                pnlSouth.setLayout(new GridLayout(2, 1, 2, 1));
                pnlSouth.add(radioPanel);
                pnlSouth.add(pnlBottom);
            }
        }
        pnlSouth.setVisible(false); 
        pnlSouth.setVisible(true);  
    }// End Action Performed

    // ===========  Start RadioListener  ===============//  
    private class RadioListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent event) 
        {
            JRadioButton theButton = (JRadioButton)event.getSource();
            if(theButton.getText().equals("User Plays X")) 
            {
                startingPlayer = "X";
            }
            if(theButton.getText().equals("User Plays O"))
            {
                startingPlayer = "O";
            }

            // redisplay the gameboard to the screen
            pnlSouth.setVisible(false); 
            pnlSouth.setVisible(true);          
            RedrawGameBoard();
        }
    }// End RadioListener
    private class RadioListener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            JRadioButton theButton = (JRadioButton)event.getSource();
            if(theButton.getText().equals("Player"))
            {
                playingPlayer = true;
            }
            if(theButton.getText().equals("Computer"))
            {
                playingPlayer = false;
            }

            // redisplay the gameboard to the screen
            pnlSouth.setVisible(false);
            pnlSouth.setVisible(true);
            RedrawGameBoard();
        }
    }// End RadioListener
    /*
    ----------------------------------
    Start of all the other methods. |
    ----------------------------------
     */
    private void RedrawGameBoard()  
    {
        BusinessLogic.ClearPanelSouth(pnlSouth,pnlTop,pnlNewGame,
            pnlPlayingField,pnlBottom,radioPanel);
        BusinessLogic.ClearPanelSouth(pnlSouth,pnlTop,pnlNewGame,
                pnlPlayingField,pnlBottom,oppoPanel);
        BusinessLogic.ShowGame(pnlSouth,pnlPlayingField);       

        remainingMoves = 1;

        for(int x=1; x < size * size + 1; ++x)
        {
            btnEmpty[x].setText("");
            btnEmpty[x].setEnabled(setTableEnabled);
        }

        win = false;        
    }

    private boolean CheckWin()
    {   
        int len = size * size;
        for (int i = 1; i <= size; i++) {
            String ll = btnEmpty[i].getText();
            if (ll.equals("")) continue;
            for (int j = 0; j < size; j++) {
                if (!btnEmpty[i + j * size].getText().equals(ll)) break;
                if (j == size - 1) win = true;
            }
        }
        for (int i = 1; i <= len; i += size) {
            System.out.println(i);
            String ll = btnEmpty[i].getText();
            if (ll.equals("")) continue;
            for (int j = 0; j < size; j++) {
                if (!btnEmpty[i + j].getText().equals(ll)) break;
                if (j == size - 1) win = true;
            }
        }
        String ll = btnEmpty[1].getText();
        if (!ll.equals("")) {
            for (int i = 1; i <= size; i++) {
                if (!btnEmpty[i + (i - 1) * 3].getText().equals(ll)) break;
                if (i == size) win = true;
            }
        }
        ll = btnEmpty[len].getText();
        if (!ll.equals("")) {
            for (int i = 1; i <= size; i++) {
                if (!btnEmpty[(size + 1 - i) + (i - 1) * 3].getText().equals(ll)) break;
                if (i == size) win = true;
            }
        }
        return win;
    }
    private void botMove() {
        for (int i = 1; i <= size * size; i++) {
            if (btnEmpty[i].getText().equals("")) {
                BusinessLogic.GetMove(i, remainingMoves, font,
                        btnEmpty, ((startingPlayer == "X")? "O" : "X"));
                if (CheckWin()) {
                    btnEmpty[i].setEnabled(false);
                    ++remainingMoves;
                    return;
                } else {
                    btnEmpty[i].setText("");
                }
            }
        }
        while (true) {
            int i = (int)(Math.random() * size * size + 1);
            if (btnEmpty[i].getText().equals("")) {
                BusinessLogic.GetMove(i, remainingMoves, font,
                        btnEmpty, ((startingPlayer == "X")? "O" : "X"));
                btnEmpty[i].setEnabled(false);
                ++remainingMoves;
                return;
            }
        }
    }
}	
