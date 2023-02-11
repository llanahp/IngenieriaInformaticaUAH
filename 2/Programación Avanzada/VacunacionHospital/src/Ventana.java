
import java.awt.Color;
import java.rmi.Naming;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana extends JFrame {

    ArrayList<String> cierreDePuestos = new ArrayList<>(10);
    ArrayList<JButton> botonesCerrarPuestos = new ArrayList<>(10);
    ArrayList<JLabel> listaLabelPuestosObsarvacion = new ArrayList<>(20);

    public Ventana() {
        initComponents();
        for (int i = 0; i < 10; i++) {
            cierreDePuestos.add("");
        }
        HiloActualizarVentana hiloActualizarVentana = new HiloActualizarVentana(this);
        hiloActualizarVentana.start();
        insertarBotonesArray();
        insertarLabelArray();
    }

    private void insertarBotonesArray() {
        botonesCerrarPuestos.add(jButton1);
        botonesCerrarPuestos.add(jButton2);
        botonesCerrarPuestos.add(jButton3);
        botonesCerrarPuestos.add(jButton4);
        botonesCerrarPuestos.add(jButton5);
        botonesCerrarPuestos.add(jButton6);
        botonesCerrarPuestos.add(jButton7);
        botonesCerrarPuestos.add(jButton8);
        botonesCerrarPuestos.add(jButton9);
        botonesCerrarPuestos.add(jButton10);
    }

    private void insertarLabelArray() {
        listaLabelPuestosObsarvacion.add(jLabel12);
        listaLabelPuestosObsarvacion.add(jLabel13);
        listaLabelPuestosObsarvacion.add(jLabel14);
        listaLabelPuestosObsarvacion.add(jLabel16);
        listaLabelPuestosObsarvacion.add(jLabel18);
        listaLabelPuestosObsarvacion.add(jLabel17);
        listaLabelPuestosObsarvacion.add(jLabel15);
        listaLabelPuestosObsarvacion.add(jLabel19);
        listaLabelPuestosObsarvacion.add(jLabel20);
        listaLabelPuestosObsarvacion.add(jLabel21);
        listaLabelPuestosObsarvacion.add(jLabel29);
        listaLabelPuestosObsarvacion.add(jLabel26);
        listaLabelPuestosObsarvacion.add(jLabel30);
        listaLabelPuestosObsarvacion.add(jLabel22);
        listaLabelPuestosObsarvacion.add(jLabel31);
        listaLabelPuestosObsarvacion.add(jLabel23);
        listaLabelPuestosObsarvacion.add(jLabel24);
        listaLabelPuestosObsarvacion.add(jLabel27);
        listaLabelPuestosObsarvacion.add(jLabel25);
        listaLabelPuestosObsarvacion.add(jLabel28);
    }

    private void limpiarPuestos(Informacion info) {
        for (int i = 0; i < cierreDePuestos.size(); i++) {
            cierreDePuestos.set(i, "");

        }
        if (info.puestosVacunacion != null) {
            for (int i = 0; i < info.puestosVacunacion.size(); i++) {
                if (!info.puestosVacunacion.get(i).equals("") && !info.puestosVacunacion.get(i).equals(null) && !info.puestosVacunacion.get(i).equals("Inoperativo")) {
                    if (!botonesCerrarPuestos.get(i).isEnabled()) {
                        botonesCerrarPuestos.get(i).setEnabled(true);
                    }
                }
            }
        }
    }

    public void ActualizarVentana() {

        try {

            InterfacInformacion obj = (InterfacInformacion) Naming.lookup("//127.0.0.1/ObjetoSaluda");

            Informacion info = obj.getInformacion(cierreDePuestos);
            limpiarPuestos(info);
            jLabel32.setText("Vacunas disponibles: " + info.vacunasDisponibles);
            jTextField3.setText(info.puestoAuxiliarVacunas);
            jTextField2.setText(info.puestoAuxiliarEntrada);
            jTextArea2.setText(info.salaDescando);
            jTextField1.setText(info.pacienteEntrada);
            jTextArea1.setText(info.colaEntrada);

            for (int i = 0; i < info.puestoNecesitanSanitario.size(); i++) {
                if (info.puestoNecesitanSanitario.get(i) == true) {
                    listaLabelPuestosObsarvacion.get(i).setForeground(new Color(255, 0, 0));
                } else {
                    listaLabelPuestosObsarvacion.get(i).setForeground(Color.black);

                }
            }
            //cambiamos el color del puestoXX
            if (info.puestosVacunacion != null) {
                jTextField10.setText(info.puestosVacunacion.get(0));
                jTextField4.setText(info.puestosVacunacion.get(1));
                jTextField5.setText(info.puestosVacunacion.get(2));
                jTextField8.setText(info.puestosVacunacion.get(3));
                jTextField6.setText(info.puestosVacunacion.get(4));
                jTextField9.setText(info.puestosVacunacion.get(5));
                jTextField7.setText(info.puestosVacunacion.get(6));
                jTextField11.setText(info.puestosVacunacion.get(7));
                jTextField13.setText(info.puestosVacunacion.get(8));
                jTextField12.setText(info.puestosVacunacion.get(9));
            }
            if (info.puestosObservacion != null) {
                jTextField20.setText(info.puestosObservacion.get(0));
                jTextField14.setText(info.puestosObservacion.get(1));
                jTextField15.setText(info.puestosObservacion.get(2));
                jTextField18.setText(info.puestosObservacion.get(3));
                jTextField16.setText(info.puestosObservacion.get(4));
                jTextField19.setText(info.puestosObservacion.get(5));
                jTextField17.setText(info.puestosObservacion.get(6));
                jTextField21.setText(info.puestosObservacion.get(7));
                jTextField23.setText(info.puestosObservacion.get(8));
                jTextField22.setText(info.puestosObservacion.get(9));
                jTextField24.setText(info.puestosObservacion.get(10));
                jTextField27.setText(info.puestosObservacion.get(11));
                jTextField26.setText(info.puestosObservacion.get(12));
                jTextField29.setText(info.puestosObservacion.get(13));
                jTextField25.setText(info.puestosObservacion.get(14));
                jTextField33.setText(info.puestosObservacion.get(15));
                jTextField32.setText(info.puestosObservacion.get(16));
                jTextField31.setText(info.puestosObservacion.get(17));
                jTextField30.setText(info.puestosObservacion.get(18));
                jTextField28.setText(info.puestosObservacion.get(19));
            }
        } catch (Exception e) {
            System.out.println("Excepción : " + e.getMessage());
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 310, 95));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 74, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 74, -1));

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 310, 90));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 32, -1));

        jTextField4.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField4.setEnabled(false);
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 90, -1));

        jTextField5.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField5.setEnabled(false);
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 90, -1));

        jTextField6.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField6.setEnabled(false);
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, 90, -1));

        jTextField7.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField7.setEnabled(false);
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 90, -1));

        jTextField8.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField8.setEnabled(false);
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 90, -1));

        jTextField9.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField9.setEnabled(false);
        getContentPane().add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 90, -1));

        jTextField10.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField10.setEnabled(false);
        getContentPane().add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 80, -1));

        jTextField11.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField11.setEnabled(false);
        getContentPane().add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 90, -1));

        jTextField12.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField12.setEnabled(false);
        getContentPane().add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 200, 90, -1));

        jTextField13.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField13.setEnabled(false);
        getContentPane().add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 200, 90, -1));

        jLabel2.setText("Puesto 1");
        jLabel2.setEnabled(false);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));

        jLabel3.setText("Puesto 2");
        jLabel3.setEnabled(false);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, -1));

        jLabel4.setText("Puesto 3");
        jLabel4.setEnabled(false);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, -1, -1));

        jLabel5.setText("Puesto 7");
        jLabel5.setEnabled(false);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, -1, -1));

        jLabel6.setText("Puesto 4");
        jLabel6.setEnabled(false);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, -1, -1));

        jLabel7.setText("Puesto 6");
        jLabel7.setEnabled(false);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, -1));

        jLabel8.setText("Puesto 5");
        jLabel8.setEnabled(false);
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, -1, -1));

        jLabel9.setText("Puesto 8");
        jLabel9.setEnabled(false);
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, -1, -1));

        jLabel10.setText("Puesto 9");
        jLabel10.setEnabled(false);
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, -1, -1));

        jLabel11.setText("Puesto 10");
        jLabel11.setEnabled(false);
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 180, -1, -1));

        jTextField14.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField14.setEnabled(false);
        getContentPane().add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, 90, -1));

        jTextField15.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField15.setEnabled(false);
        getContentPane().add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 360, 90, -1));

        jTextField16.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField16.setEnabled(false);
        getContentPane().add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 360, 90, -1));

        jTextField17.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField17.setEnabled(false);
        getContentPane().add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 360, 90, -1));

        jTextField18.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField18.setEnabled(false);
        getContentPane().add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, 90, -1));

        jTextField19.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField19.setEnabled(false);
        getContentPane().add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 360, 90, -1));

        jTextField20.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField20.setEnabled(false);
        getContentPane().add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 90, -1));

        jTextField21.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField21.setEnabled(false);
        getContentPane().add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, 90, -1));

        jTextField22.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField22.setEnabled(false);
        getContentPane().add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 90, -1));

        jTextField23.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField23.setEnabled(false);
        getContentPane().add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, 90, -1));

        jLabel12.setText("Puesto 1");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, -1, -1));

        jLabel13.setText("Puesto 2");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, -1, -1));

        jLabel14.setText("Puesto 3");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, -1, -1));

        jLabel15.setText("Puesto 7");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 340, -1, -1));

        jLabel16.setText("Puesto 4");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, -1, -1));

        jLabel17.setText("Puesto 6");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 340, -1, -1));

        jLabel18.setText("Puesto 5");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 340, -1, -1));

        jLabel19.setText("Puesto 8");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 60, -1));

        jLabel20.setText("Puesto 9");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, 60, -1));

        jLabel21.setText("Puesto 10");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, -1, -1));

        jTextField24.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField24.setEnabled(false);
        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField24ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, 90, -1));

        jLabel22.setText("Puesto 14");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 400, -1, -1));

        jLabel23.setText("Puesto 16");
        jLabel23.setEnabled(false);
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, -1, -1));

        jLabel24.setText("Puesto 17");
        jLabel24.setEnabled(false);
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 470, -1, -1));

        jTextField25.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField25.setEnabled(false);
        getContentPane().add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, 90, -1));

        jTextField26.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField26.setEnabled(false);
        getContentPane().add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 420, 90, -1));

        jLabel25.setText("Puesto 19");
        jLabel25.setEnabled(false);
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 470, -1, -1));

        jTextField27.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField27.setEnabled(false);
        getContentPane().add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 420, 90, -1));

        jTextField28.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField28.setEnabled(false);
        getContentPane().add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 490, 90, -1));

        jTextField29.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField29.setEnabled(false);
        getContentPane().add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 420, 90, -1));

        jLabel26.setText("Puesto 12");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 400, -1, -1));

        jLabel27.setText("Puesto 18");
        jLabel27.setEnabled(false);
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 470, -1, -1));

        jLabel28.setText("Puesto 20");
        jLabel28.setEnabled(false);
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 470, -1, -1));

        jTextField30.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField30.setEnabled(false);
        getContentPane().add(jTextField30, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 490, 90, -1));

        jTextField31.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField31.setEnabled(false);
        getContentPane().add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 490, 90, -1));

        jLabel29.setText("Puesto 11");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, -1, -1));

        jTextField32.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField32.setEnabled(false);
        getContentPane().add(jTextField32, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 490, 90, -1));

        jLabel30.setText("Puesto 13");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 400, -1, -1));

        jTextField33.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField33.setEnabled(false);
        getContentPane().add(jTextField33, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, 90, -1));

        jLabel31.setText("Puesto 15");
        jLabel31.setEnabled(false);
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, -1, -1));

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, -1, -1));

        jButton2.setText("Cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, -1));

        jButton3.setText("Cerrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, -1, -1));

        jButton4.setText("Cerrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, -1, -1));

        jButton5.setText("Cerrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, -1, -1));

        jButton6.setText("Cerrar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, -1, -1));

        jButton7.setText("Cerrar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, -1, -1));

        jButton8.setText("Cerrar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, -1, -1));

        jButton9.setText("Cerrar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, -1, -1));

        jButton10.setText("Cerrar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 230, -1, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setText("Vacunas disponibles: 0");
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, -1, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("SALA VACUNACIÓN");
        jLabel33.setToolTipText("");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 150, 40));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("RECEPCIÓN");
        jLabel34.setToolTipText("");
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 100, 40));

        jLabel35.setText(" ");
        getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, 50, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("SALA OBSERVACIÓN");
        jLabel36.setToolTipText("");
        getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 150, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed


    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cierreDePuestos.set(2, ".");
        jButton3.setEnabled(false);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cierreDePuestos.set(0, ".");
        jButton1.setEnabled(false);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cierreDePuestos.set(1, ".");
        jButton2.setEnabled(false);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cierreDePuestos.set(3, ".");
        jButton4.setEnabled(false);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        cierreDePuestos.set(4, ".");
        jButton5.setEnabled(false);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        cierreDePuestos.set(5, ".");
        jButton6.setEnabled(false);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        cierreDePuestos.set(6, ".");
        jButton7.setEnabled(false);

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        cierreDePuestos.set(7, ".");
        jButton8.setEnabled(false);

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        cierreDePuestos.set(8, ".");
        jButton9.setEnabled(false);

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        cierreDePuestos.set(9, ".");
        jButton10.setEnabled(false);

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField24ActionPerformed
    }//GEN-LAST:event_jTextField24ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables

}
