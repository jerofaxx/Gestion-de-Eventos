package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPiramide extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel base, altura, apotema, volumen, superficie, imagenLabel;
    private JTextField campoBase, campoAltura, campoApotema;
    private JButton calcular;

    public VentanaPiramide() {
        setTitle("Pirámide");
        setSize(450, 580);
        setLocationRelativeTo(null);
        setResizable(false);
        inicio();
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        base = new JLabel("Base (cm):");
        base.setBounds(20, 20, 135, 23);
        campoBase = new JTextField();
        campoBase.setBounds(120, 20, 135, 23);

        altura = new JLabel("Altura (cm):");
        altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(120, 50, 135, 23);
        
        apotema = new JLabel("Apotema (cm):");
        apotema.setBounds(20, 80, 135, 23);
        campoApotema = new JTextField();
        campoApotema.setBounds(120, 80, 135, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(120, 110, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm³):");
        volumen.setBounds(20, 140, 200, 23);

        superficie = new JLabel("Superficie (cm²):");
        superficie.setBounds(20, 170, 200, 23);

        try {
            java.net.URL imgURL = getClass().getResource("Piramide.png");
            if (imgURL != null) {
                ImageIcon icono = new ImageIcon(imgURL);
                imagenLabel = new JLabel(icono);
                imagenLabel.setBounds(50, 200, icono.getIconWidth(), icono.getIconHeight());
                contenedor.add(imagenLabel);
            } else {
                throw new Exception("Imagen no encontrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
        }

        contenedor.add(base);
        contenedor.add(campoBase);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(apotema);
        contenedor.add(campoApotema);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    public void actionPerformed(ActionEvent event) {
        boolean error = false;
        double base = 0, altura = 0, apotema = 0;
        try {
            base = Double.parseDouble(campoBase.getText());
            altura = Double.parseDouble(campoAltura.getText());
            apotema = Double.parseDouble(campoApotema.getText());
            Piramide piramide = new Piramide(base, altura, apotema);
            volumen.setText("Volumen (cm³): " + String.format("%.2f", piramide.calcularVolumen()));
            superficie.setText("Superficie (cm²): " + String.format("%.2f", piramide.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        } finally {
            if (error) {
                JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
