import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HumanPcGUI extends JFrame {
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
    private JTextField tf_hmaxEl;
    private JButton button1;
    private int el =0;
    private final Kullanici kullanici;
    private final Bilgisayar bilgisayar;
    private final OyunManager oyunManager;
    Util util = new Util();
    JButton[][] buttons = {
            {btn_oyuncu1_1, btn_oyuncu1_2, btn_oyuncu1_3, btn_oyuncu1_4, btn_oyuncu1_5},
            {btn_oyuncu2_1, btn_oyuncu2_2, btn_oyuncu2_3, btn_oyuncu2_4, btn_oyuncu2_5}
    };

    public HumanPcGUI(Kullanici kullanici, Bilgisayar bilgisayar) {
        this.kullanici = kullanici;
        this.bilgisayar = bilgisayar;

        oyunManager = new OyunManager();
        setContentPane(mainPanel);
        setTitle("TAS-KAGIT-MAKAS");
        setSize(1024, 1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        btn_oyuncu1_1.setText(kullanici.list.get(0).getClass().getName() + "\n" + kullanici.list.get(0).nesnePuaniGoster()[0]);

        btn_oyuncu1_2.setText(kullanici.list.get(1).getClass().getName() + "\n" + kullanici.list.get(1).nesnePuaniGoster()[0]);
        btn_oyuncu1_3.setText(kullanici.list.get(2).getClass().getName() + "\n" + kullanici.list.get(2).nesnePuaniGoster()[0]);
        btn_oyuncu1_4.setText(kullanici.list.get(3).getClass().getName() + "\n" + kullanici.list.get(3).nesnePuaniGoster()[0]);
        btn_oyuncu1_5.setText(kullanici.list.get(4).getClass().getName() + "\n" + kullanici.list.get(4).nesnePuaniGoster()[0]);


        btn_oyuncu2_1.setText("ComputerCard1");
        btn_oyuncu2_2.setText("ComputerCard2");
        btn_oyuncu2_3.setText("ComputerCard3");
        btn_oyuncu2_4.setText("ComputerCard4");
        btn_oyuncu2_5.setText("ComputerCard5");
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

    private void scoreUpdate() {
        lbl_skor.setText(kullanici.getOyuncuAdi() + " :  " + (100 - kullanici.skorGoster()) + "   Bilgisayar : " + (100 - bilgisayar.skorGoster()));
    }

    private void OynaHelperGui(int selectBtn) {

        int maxElSayisi = Integer.parseInt(tf_hmaxEl.getText());
        el++;
        if (maxElSayisi<=el){
            String sonuc;
            if(100-kullanici.skorGoster() > 100-bilgisayar.skorGoster()){
                sonuc = "Oyuncu1 Kazandı...";
            }else {
                sonuc = "Oyuncu2 Kazandı...";
            }
            JOptionPane.showMessageDialog(mainPanel,sonuc );
        }

        int pcSelect = util.randomNumberGenerate(bilgisayar.list.size());
        while (true){ // Ölü kartları elemek için
            if (bilgisayar.list.get(pcSelect).nesnePuaniGoster()[0] <= 0) {
                pcSelect = util.randomNumberGenerate(bilgisayar.list.size());
            }else {
                break;
            }
        }


        System.out.println(bilgisayar.list.size());
        System.out.println(kullanici.list.size());

        oyunManager.hamleYap(kullanici.list.get(selectBtn), bilgisayar.list.get(pcSelect), kullanici, bilgisayar, buttons);
        System.out.println(kullanici.list.toString() + " BUTON: " + selectBtn);
        btn_oyuncu1_select.setText(kullanici.list.get(selectBtn).getClass().getName());
        btn_oyuncu2_select.setText(bilgisayar.list.get(pcSelect).getClass().getName());

        kullanici.eliGoster();
        bilgisayar.eliGoster();
        buttonConfigure();
        buttonIconConfigure();
        scoreUpdate();
    }

    private void buttonConfigure() {
        for (int i = 0; i < kullanici.list.size(); i++) {

            buttons[0][i].setText(" D: " + kullanici.list.get(i).nesnePuaniGoster()[0] + "\n S: " + kullanici.list.get(i).nesnePuaniGoster()[1]);
        }
        for (int i = 0; i < bilgisayar.list.size(); i++) {

            buttons[1][i].setText("D: " + bilgisayar.list.get(i).nesnePuaniGoster()[0] + "\n S: " + bilgisayar.list.get(i).nesnePuaniGoster()[1]);
        }

    }
    private void buttonIconConfigure(){
        for (int i = 0; i < kullanici.list.size(); i++) {
            if (kullanici.list.get(i) instanceof AgirTas){
                buttons[0][i].setIcon(new ImageIcon("/Users/alper/IdeaProjects/deneme/src/icons/agirTas.jpeg"));
            } else if (kullanici.list.get(i) instanceof Tas) {
                buttons[0][i].setIcon(new ImageIcon("/Users/alper/IdeaProjects/deneme/src/icons/tas.jpg"));
            } else if (kullanici.list.get(i) instanceof OzelKagit) {
                buttons[0][i].setIcon(new ImageIcon("/Users/alper/IdeaProjects/deneme/src/icons/OzelKagit.jpeg"));
            } else if (kullanici.list.get(i) instanceof Kagit) {
                buttons[0][i].setIcon(new ImageIcon("/Users/alper/IdeaProjects/deneme/src/icons/kagit.jpg"));
            } else if (kullanici.list.get(i) instanceof UstaMakas) {
                buttons[0][i].setIcon(new ImageIcon("/Users/alper/IdeaProjects/deneme/src/icons/ustaMakas.jpeg"));
            }else {
                buttons[0][i].setIcon(new ImageIcon("/Users/alper/IdeaProjects/deneme/src/icons/makas.jpg"));
            }
        }

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
