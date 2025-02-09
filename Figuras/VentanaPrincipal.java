package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JButton cilindro, esfera, pirámide, cubo, prisma, cono;

    public VentanaPrincipal() {
        inicio();
        setTitle("Figuras");
        setSize(330, 160);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        cilindro = new JButton("Cilindro");
        cilindro.setBounds(20, 50, 80, 23);
        cilindro.addActionListener(this);
        contenedor.add(cilindro);

        esfera = new JButton("Esfera");
        esfera.setBounds(110, 50, 80, 23);
        esfera.addActionListener(this);
        contenedor.add(esfera);

        pirámide = new JButton("Pirámide");
        pirámide.setBounds(200, 50, 100, 23);
        pirámide.addActionListener(this);
        contenedor.add(pirámide);

        cubo = new JButton("Cubo");
        cubo.setBounds(110, 90, 80, 23);
        cubo.addActionListener(this);
        contenedor.add(cubo);

        prisma = new JButton("Prisma");
        prisma.setBounds(20, 90, 80, 23);
        prisma.addActionListener(this);
        contenedor.add(prisma);

        cono = new JButton("Cono");
        cono.setBounds(210, 90, 80, 23);
        cono.addActionListener(this);
        contenedor.add(cono);
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == esfera) {
            VentanaEsfera ventana = new VentanaEsfera();
            ventana.setVisible(true);
        } else if (evento.getSource() == cilindro) {
            VentanaCilindro ventana = new VentanaCilindro();
            ventana.setVisible(true);
        } else if (evento.getSource() == pirámide) {
            VentanaPiramide ventana = new VentanaPiramide();
            ventana.setVisible(true);
        } else if (evento.getSource() == cubo) {
            VentanaCubo ventana = new VentanaCubo();
            ventana.setVisible(true);
        } else if (evento.getSource() == prisma) {
            VentanaPrisma ventana = new VentanaPrisma();
            ventana.setVisible(true);
        } else if (evento.getSource() == cono) {
            VentanaCono ventana = new VentanaCono();
            ventana.setVisible(true);
        }
    }
}