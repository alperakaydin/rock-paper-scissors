import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PcPcGUI extends JFrame {
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

    private JButton btn_basla;
    private JTextField tf_maxEl;

    private final Oyuncu oyuncu1;
    private final Oyuncu oyuncu2;
    private final OyunManager oyunManager;
    Util util = new Util();
    private int el = 0;
    JButton[][] buttons = {
            {btn_oyuncu1_1, btn_oyuncu1_2, btn_oyuncu1_3, btn_oyuncu1_4, btn_oyuncu1_5},
            {btn_oyuncu2_1, btn_oyuncu2_2, btn_oyuncu2_3, btn_oyuncu2_4, btn_oyuncu2_5}
    };

    public PcPcGUI(Oyuncu oyuncu1, Oyuncu oyuncu2) {
        this.oyuncu1 = oyuncu1;
        this.oyuncu2 = oyuncu2;

        oyunManager = new OyunManager();
        setContentPane(mainPanel);
        setTitle("TAS-KAGIT-MAKAS");
        setSize(1024, 1400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        {
            btn_oyuncu1_1.setText(oyuncu1.list.get(0).getClass().getName() + "\n" + oyuncu1.list.get(0).nesnePuaniGoster()[0]);
            btn_oyuncu1_2.setText(oyuncu1.list.get(1).getClass().getName() + "\n" + oyuncu1.list.get(1).nesnePuaniGoster()[0]);
            btn_oyuncu1_3.setText(oyuncu1.list.get(2).getClass().getName() + "\n" + oyuncu1.list.get(2).nesnePuaniGoster()[0]);
            btn_oyuncu1_4.setText(oyuncu1.list.get(3).getClass().getName() + "\n" + oyuncu1.list.get(3).nesnePuaniGoster()[0]);
            btn_oyuncu1_5.setText(oyuncu1.list.get(4).getClass().getName() + "\n" + oyuncu1.list.get(4).nesnePuaniGoster()[0]);

            btn_oyuncu2_1.setText(oyuncu2.list.get(0).getClass().getName());
            btn_oyuncu2_2.setText(oyuncu2.list.get(1).getClass().getName());
            btn_oyuncu2_3.setText(oyuncu2.list.get(2).getClass().getName());
            btn_oyuncu2_4.setText(oyuncu2.list.get(3).getClass().getName());
            btn_oyuncu2_5.setText(oyuncu2.list.get(4).getClass().getName());
        }

        btn_oyuncu1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btn_oyuncu1_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btn_oyuncu1_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btn_oyuncu1_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btn_oyuncu1_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        btn_basla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int maxElSayisi = Integer.parseInt(tf_maxEl.getText());
                el++;
                if (maxElSayisi<=el){
                    String sonuc;
                    if(100-oyuncu1.skorGoster() > 100-oyuncu2.skorGoster()){
                        sonuc = "Oyuncu1 Kazandı...";
                    }else {
                        sonuc = "Oyuncu2 Kazandı...";
                    }
                    JOptionPane.showMessageDialog(mainPanel,sonuc );
                }
                int pc1Select = util.randomNumberGenerate(oyuncu1.list.size());
                while (true) { // Ölü kartları elemek için
                    if (oyuncu1.list.get(pc1Select).nesnePuaniGoster()[0] <= 0) {
                        pc1Select = util.randomNumberGenerate(oyuncu1.list.size());
                    } else {
                        break;
                    }
                }
                int pc2Select = util.randomNumberGenerate(oyuncu2.list.size());
                while (true) { // Ölü kartları elemek için
                    if (oyuncu2.list.get(pc2Select).nesnePuaniGoster()[0] <= 0) {
                        pc2Select = util.randomNumberGenerate(oyuncu2.list.size());
                    } else {
                        break;
                    }
                }

                oyunManager.hamleYap(oyuncu1.list.get(pc1Select), oyuncu2.list.get(pc2Select), oyuncu1, oyuncu2, buttons);
                btn_oyuncu1_select.setText(oyuncu1.list.get(pc1Select).getClass().getName());
                btn_oyuncu2_select.setText(oyuncu2.list.get(pc2Select).getClass().getName());

                buttonIconConfigure();
                oyuncu1.eliGoster();
                oyuncu2.eliGoster();
                buttonConfigure();
                scoreUpdate();
            }


        });
    }

    private void scoreUpdate() {
        lbl_skor.setText(" Oyuncu1 : " + (100-oyuncu1.skorGoster()) + "   Oyuncu2 : " + (100-oyuncu2.skorGoster()));
    }

    private void OynaHelperGui(int selectBtn) {

        int pcSelect = util.randomNumberGenerate(oyuncu1.list.size());


        oyunManager.hamleYap(oyuncu1.list.get(selectBtn), oyuncu2.list.get(pcSelect), oyuncu1, oyuncu2, buttons);

        btn_oyuncu1_select.setText(oyuncu1.list.get(selectBtn).getClass().getName());
        btn_oyuncu2_select.setText(oyuncu2.list.get(pcSelect).getClass().getName());

        oyunManager.hamleController(oyuncu1, oyuncu2);
        oyuncu1.eliGoster();
        oyuncu2.eliGoster();
        buttonConfigure();
        scoreUpdate();
    }

    private void buttonConfigure() {
        for (int i = 0; i < oyuncu1.list.size(); i++) {

            buttons[0][i].setText(" D: " + oyuncu1.list.get(i).nesnePuaniGoster()[0] + "\n S: " + oyuncu1.list.get(i).nesnePuaniGoster()[1]);
        }
        for (int i = 0; i < oyuncu2.list.size(); i++) {

            buttons[1][i].setText("D: " + oyuncu2.list.get(i).nesnePuaniGoster()[0] + "\n S: " + oyuncu2.list.get(i).nesnePuaniGoster()[1]);
        }
    }

    private void buttonIconConfigure() {
        for (int i = 0; i < oyuncu1.list.size(); i++) {
            if (oyuncu1.list.get(i) instanceof AgirTas) {
                buttons[0][i].setIcon(new ImageIcon("/Users/alper/IdeaProjects/deneme/src/icons/agirTas.jpeg"));
            } else if (oyuncu1.list.get(i) instanceof Tas) {
                buttons[0][i].setIcon(new ImageIcon("/Users/alper/IdeaProjects/deneme/src/icons/tas.jpg"));
            } else if (oyuncu1.list.get(i) instanceof OzelKagit) {
                buttons[0][i].setIcon(new ImageIcon("/Users/alper/IdeaProjects/deneme/src/icons/OzelKagit.jpeg"));
            } else if (oyuncu1.list.get(i) instanceof Kagit) {
                buttons[0][i].setIcon(new ImageIcon("/Users/alper/IdeaProjects/deneme/src/icons/kagit.jpg"));
            } else if (oyuncu1.list.get(i) instanceof UstaMakas) {
                buttons[0][i].setIcon(new ImageIcon("/Users/alper/IdeaProjects/deneme/src/icons/ustaMakas.jpeg"));
            } else {
                buttons[0][i].setIcon(new ImageIcon("/Users/alper/IdeaProjects/deneme/src/icons/makas.jpg"));
            }
        }
        for (int i = 0; i < oyuncu2.list.size(); i++) {
            if (oyuncu2.list.get(i) instanceof AgirTas) {
                buttons[1][i].setIcon(new ImageIcon("/Users/alper/IdeaProjects/deneme/src/icons/agirTas.jpeg"));
            } else if (oyuncu2.list.get(i) instanceof Tas) {
                buttons[1][i].setIcon(new ImageIcon("/Users/alper/IdeaProjects/deneme/src/icons/tas.jpg"));
            } else if (oyuncu2.list.get(i) instanceof OzelKagit) {
                buttons[1][i].setIcon(new ImageIcon("/Users/alper/IdeaProjects/deneme/src/icons/OzelKagit.jpeg"));
            } else if (oyuncu2.list.get(i) instanceof Kagit) {
                buttons[1][i].setIcon(new ImageIcon("/Users/alper/IdeaProjects/deneme/src/icons/kagit.jpg"));
            } else if (oyuncu2.list.get(i) instanceof UstaMakas) {
                buttons[1][i].setIcon(new ImageIcon("/Users/alper/IdeaProjects/deneme/src/icons/ustaMakas.jpeg"));
            } else {
                buttons[1][i].setIcon(new ImageIcon("/Users/alper/IdeaProjects/deneme/src/icons/makas.jpg"));
            }
        }

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
