import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MiConversor {

    private JFrame frame;
    private JTextField txt;
    private JLabel lbl;
    private JComboBox<String> cmb;
    private JButton btn;

    private static final Map<String, Double> conversionRates = new HashMap<>();
    static {
        conversionRates.put("Quetzales a Dólares", 0.13);
        conversionRates.put("Quetzales a Pesos MX", 2.17);
        conversionRates.put("Quetzales a Pesos Arg", 44.43);
        conversionRates.put("Quetzales a Reales BR", 0.62);
        conversionRates.put("Dólares a Quetzales", 7.88);
        conversionRates.put("Dólares a Pesos MX", 17.08);
        conversionRates.put("Dólares a Pesos Arg", 349.96);
        conversionRates.put("Dólares a Reales BR", 4.87);
        conversionRates.put("Pesos MX a Quetzales", 0.46);
        conversionRates.put("Pesos MX a Pesos Arg", 20.49);
        conversionRates.put("Pesos MX a Dólares", 0.059);
        conversionRates.put("Pesos MX a Reales BR", 0.28);
        conversionRates.put("Pesos Arg a Quetzales", 0.023);
        conversionRates.put("Pesos Arg a Dólares", 0.0029);
        conversionRates.put("Pesos Arg a Pesos MX", 0.049);
        conversionRates.put("Pesos Arg a Reales BR", 0.014);
        conversionRates.put("Reales BR a Quetzales", 1.62);
        conversionRates.put("Reales BR a Dólares", 0.21);
        conversionRates.put("Reales BR a Pesos MX", 3.51);
        conversionRates.put("Reales BR a Pesos Arg", 71.90);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MiConversor window = new MiConversor();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MiConversor() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        txt = new JTextField();
        txt.setBounds(21, 30, 145, 39);
        frame.getContentPane().add(txt);
        txt.setColumns(10);

        lbl = new JLabel("New label");
        lbl.setBounds(223, 31, 115, 36);
        frame.getContentPane().add(lbl);

        cmb = new JComboBox<>(conversionRates.keySet().toArray(new String[0]));
        cmb.setBounds(21, 101, 145, 39);
        frame.getContentPane().add(cmb);

        btn = new JButton("Convertir");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Convertir();
            }
        });
        btn.setBounds(217, 101, 121, 39);
        frame.getContentPane().add(btn);
    }

    private void Convertir() {
        if (Validar(txt.getText())) {
            String selectedCurrency = (String) cmb.getSelectedItem();
            double conversionRate = conversionRates.get(selectedCurrency);
            double result = valorInput * conversionRate;
            lbl.setText(Redondear(result));
        }
    }

    private double valorInput = 0.00;

    private String Redondear(double valor) {
        DecimalFormat df = new DecimalFormat("00.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(valor);
    }

    private boolean Validar(String texto) {
        try {
            double x = Double.parseDouble(texto);
            if (x > 0) {
                valorInput = x;
                return true;
            } else {
                lbl.setText("Solo números positivos");
                return false;
            }
        } catch (NumberFormatException e) {
            lbl.setText("Solamente números");
            return false;
        }
    }
}
