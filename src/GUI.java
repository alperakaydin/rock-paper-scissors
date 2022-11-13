import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame{
    private JPanel mainPanel;
    private JButton btn_oyuncu1_1;
    private JButton btn_oyuncu1_2;
    private JButton btn_oyuncu1_3;
    private JButton btn_oyuncu1_4;
    private JButton btn_oyuncu1_5;
    private JButton btn_oyuncu2_1;
    private JButton btn_oyuncu2_2;
    private JButton btn_oyuncu2_3;
    private JButton btn_oyuncu2_4;
    private JButton btn_oyuncu2_5;
    private JLabel lbl_orta;
    private JButton btn_oyuncu1_select;
    private JButton btn_oyuncu2_select;
    private JLabel lbl_skor;
    private JButton button1;

    private final Oyuncu oyuncu1;
    private final Oyuncu oyuncu2;
    private final OyunManager oyunManager;
    Util util = new Util();
    JButton[][] buttons = {
            {btn_oyuncu1_1,btn_oyuncu1_2,btn_oyuncu1_3,btn_oyuncu1_4,btn_oyuncu1_5},
            {btn_oyuncu2_1,btn_oyuncu2_2,btn_oyuncu2_3,btn_oyuncu2_4,btn_oyuncu2_5}
    };
    public GUI(Oyuncu oyuncu1, Oyuncu oyuncu2){
        this.oyuncu1 = oyuncu1;
        this.oyuncu2 = oyuncu2;

        oyunManager = new OyunManager();
        setContentPane(mainPanel);
        setTitle("TAS-KAGIT-MAKAS");
        setSize(1024,1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);



        btn_oyuncu1_1.setText(oyuncu1.list.get(0).getClass().getName() +"\n"+oyuncu1.list.get(0).nesnePuaniGoster()[0]);
        btn_oyuncu1_2.setText(oyuncu1.list.get(1).getClass().getName() +"\n"+oyuncu1.list.get(1).nesnePuaniGoster()[0]);
        btn_oyuncu1_3.setText(oyuncu1.list.get(2).getClass().getName() +"\n"+oyuncu1.list.get(2).nesnePuaniGoster()[0]);
        btn_oyuncu1_4.setText(oyuncu1.list.get(3).getClass().getName() +"\n"+oyuncu1.list.get(3).nesnePuaniGoster()[0]);
        btn_oyuncu1_5.setText(oyuncu1.list.get(4).getClass().getName() +"\n"+oyuncu1.list.get(4).nesnePuaniGoster()[0]);

        btn_oyuncu2_1.setText(oyuncu2.list.get(0).getClass().getName());
        btn_oyuncu2_2.setText(oyuncu2.list.get(1).getClass().getName());
        btn_oyuncu2_3.setText(oyuncu2.list.get(2).getClass().getName());
        btn_oyuncu2_4.setText(oyuncu2.list.get(3).getClass().getName());
        btn_oyuncu2_5.setText(oyuncu2.list.get(4).getClass().getName());
        btn_oyuncu1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OynaHelperGui(0);
            }
        });
        btn_oyuncu1_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OynaHelperGui(1);
            }
        });
        btn_oyuncu1_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OynaHelperGui(2);
            }
        });
        btn_oyuncu1_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OynaHelperGui(3);
            }
        });
        btn_oyuncu1_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OynaHelperGui(4);
            }
        });


    }
    private void scoreUpdate(){
        lbl_skor.setText( " Oyuncu1 : " + oyuncu1.skorGoster() + "   Oyuncu2 : " + oyuncu2.skorGoster());
    }
    private void OynaHelperGui(int selectBtn){

        int pcSelect = util.randomNumberGenerate(oyuncu1.list.size());


        oyunManager.hamleYap(oyuncu1.list.get(selectBtn),oyuncu2.list.get(pcSelect));

        btn_oyuncu1_select.setText(oyuncu1.list.get(selectBtn).getClass().getName());
        btn_oyuncu2_select.setText(oyuncu2.list.get(pcSelect).getClass().getName());

        oyunManager.hamleController(oyuncu1,oyuncu2);
        oyuncu1.eliGoster();
        oyuncu2.eliGoster();
        buttonConfigure();
        scoreUpdate();
    }

    private void buttonConfigure(){
        for (int i = 0; i<5; i++){
            if (oyuncu1.list.get(i).nesnePuaniGoster()[0] <=0){
                buttons[0][i].setVisible(false);
            }
        }
        btn_oyuncu1_1.setText(oyuncu1.list.get(0).getClass().getName() +"\n"+oyuncu1.list.get(0).nesnePuaniGoster()[0]);
        btn_oyuncu1_2.setText(oyuncu1.list.get(1).getClass().getName() +"\n"+oyuncu1.list.get(1).nesnePuaniGoster()[0]);
        btn_oyuncu1_3.setText(oyuncu1.list.get(2).getClass().getName() +"\n"+oyuncu1.list.get(2).nesnePuaniGoster()[0]);
        btn_oyuncu1_4.setText(oyuncu1.list.get(3).getClass().getName() +"\n"+oyuncu1.list.get(3).nesnePuaniGoster()[0]);
        btn_oyuncu1_5.setText(oyuncu1.list.get(4).getClass().getName() +"\n"+oyuncu1.list.get(4).nesnePuaniGoster()[0]);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
