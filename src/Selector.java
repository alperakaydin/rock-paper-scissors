import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Selector extends JFrame{
    private JPanel panel1;
    private JTextField tf_name;
    private JButton btn_humanPc;
    private JButton btn_PcButton;
    private JLabel lbl_name;

    public Selector() {
        setContentPane(panel1);
        setTitle("TAS-KAGIT-MAKAS");
        setSize(260,180);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        btn_humanPc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tf_name.getText();
                JOptionPane.showMessageDialog(panel1, name);
                Kullanici alper = new Kullanici();
                alper.setOyuncuAdi(name);

                Bilgisayar pc = new Bilgisayar();
                pc.nesneSec();

                int[] secimList = {0, 1, 2, 1, 2};
                alper.nesneSec(secimList);
                setVisible(false);
                new HumanPcGUI(alper,pc);

            }
        });
        btn_PcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bilgisayar pc1 = new Bilgisayar();
                Bilgisayar pc2 = new Bilgisayar();
                pc1.nesneSec();
                pc2.nesneSec();

                setVisible(false);
                new PcPcGUI(pc1,pc2);

            }
        });
    }
}
