/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fnc;
import org.netbeans.lib.awtextra.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author PERSONAL
 */
public class Interface extends javax.swing.JDialog {

    /**
     * Creates new form Interface
     */
    public Interface(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new AbsoluteLayout()); 
        getContentPane().setBackground(new java.awt.Color(55,197, 211));
        
        setBounds(new Rectangle(50, 50, 500, 500));
        
        jLabel2 = new JLabel("Forma Normal Conjuntiva");
        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        
        jText1 = new JTextField();
        
        jButton1 = new JButton("Aceptar");
        
        jTable1 = new JTable();
        
        jScrollPane1 = new JScrollPane();
        
        jLabel2.setFont(new Font("Baskerville Old Face", 1, 26));
        jLabel2.setForeground(new Color(0,0,0));
        getContentPane().add(jLabel2,
                new AbsoluteConstraints(10,5, 440, 50));
        
        jLabel3.setText("Digite el número de variables booleanas");
        jLabel3.setFont(new Font("Baskerville Old Face", 1, 16));
        jLabel3.setForeground(new Color(0,0,0));
        getContentPane().add(jLabel3,
                new AbsoluteConstraints(10,60, 340, 50));
        
        jText1.setFont(new Font("Baskerville Old Face", 1, 16));
        getContentPane().add(jText1,
                new AbsoluteConstraints(10,110, 50, 50));
        
        jButton1.setFont(new Font("Baskerville Old Face", 1, 16));
        getContentPane().add(jButton1,
                new AbsoluteConstraints(210,110, 200, 50));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        jLabel4.setText("Visualice una FNC aleatoria");
        jLabel4.setFont(new Font("Baskerville Old Face", 1, 16));
        jLabel4.setForeground(new Color(0,0,0));
        getContentPane().add(jLabel4,
                new AbsoluteConstraints(10,170, 240, 50));
        
        jTable1.setFont(new Font("Baskerville Old Face", 1, 26));
        jTable1.setForeground(new Color(0,0,0));
        jTable1.setAutoResizeMode(0);
        jScrollPane1.setViewportView( jTable1 );
        getContentPane().add(jScrollPane1,
                new AbsoluteConstraints(10,230, 400, 200));
        
        
        jLabel1.setIcon(new ImageIcon(Interface.class.getResource("/fnc/Images/matematicas-discretas-demostraciones.jpg"))); // NOI18N
        getContentPane().add(jLabel1,
                new AbsoluteConstraints(0,0, 500, 500));

        
        pack();
        
    }// </editor-fold>
    
    private void jButton1ActionPerformed(ActionEvent evt) {
        String data = jText1.getText();
        Integer value = null;
        try{
            value = Integer.parseInt(data);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Digite valores validos");
            return;
        }
        
        SingleConjuntion sc = FormaNormalConjuntiva.getRandomFNC(value);
        
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column)
                {
                    return false;//This causes all cells to be not editable
                }
        };
        for( int i = 0; i < value; i ++)
            modelo.addColumn(String.valueOf(i));
        
        int pos = 0;
        for( Disjunction dis : sc.getArr()){
            String[] arr = new String[value];
            Boolean[] bin = dis.binary_expression;
            for(int i = 0; i < value; i ++){
                arr[i] = ( (bin[i]) ? "x\u0305" : "x" ) + String.valueOf(i);
            }
            modelo.addRow( arr );
        }
        
        jTable1.setModel(modelo);
        jTable1.setRowHeight(50);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Interface inter = new Interface(null, false);
        inter.setVisible(true);
        
    }

    // Variables declaration - do not modify
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    
    private JTextField jText1;
    
    private JButton jButton1;
    
    private JTable jTable1;
    
    private JScrollPane jScrollPane1;
    
    // End of variables declaration
}