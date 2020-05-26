/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectovehiculos.vista;

import com.sun.imageio.plugins.jpeg.JPEG;
import java.awt.Color;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectovehiculos.abstracta.AbstractVehiculo;
import proyectovehiculos.excepciones.ExcepcionVehiculo;
import proyectovehiculos.getionar.GestionUsuario;
import proyectovehiculos.getionar.GestionVehiculo;
import proyectovehiculos.modelo.AlquilarVehiculo;
import proyectovehiculos.modelo.Coche;
import proyectovehiculos.modelo.Furgoneta;
import proyectovehiculos.modelo.Moto;
import proyectovehiculos.modelo.Usuario;
import proyectovehiculos.utilidades.ArchivoPDF;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Daniel Quintero
 */
public class MdiVehiculos extends javax.swing.JFrame {

    private GestionUsuario gestionLogin;
    private Usuario usuarioAutenticado;
    private GestionUsuario gestionListarUsuario;
    private GestionVehiculo gestionListaVehiculo;

    /**
     * Creates new form MdiVehiculos
     */
    public MdiVehiculos() {
        initComponents();
    }

    private void iniciarMenus(boolean estado) {
        mnuUsuario.setVisible(estado);
        mnuVehiculo.setVisible(estado);
        mnuAlquila.setVisible(estado);
        mnuCrearVehiculo.setVisible(estado);
        mnuListarVehiculo.setVisible(estado);
        mnuListadoGeneralVehiculo.setVisible(estado);
        mnuListarCoches.setVisible(estado);
        mnuListarFurgonetas.setVisible(estado);
        mnuListarMotos.setVisible(estado);
        mnuCrearUsuario.setVisible(estado);
        mnuListarUsuario.setVisible(estado);
        mnuAlaquilarVehiculo.setVisible(estado);
        mnuListaAlquiler.setVisible(estado);

    }

    private void gestionarPermisosMenu() {

        switch (usuarioAutenticado.getTipoUsuario().getCodigo()) {
            ///administrador
            case "0":
                iniciarMenus(true);
                break;
            ///usuario
            case "1":
                iniciarMenus(false);
                mnuUsuario.setVisible(true);
                mnuVehiculo.setVisible(true);
                mnuListarVehiculo.setVisible(true);
                mnuListarUsuario.setVisible(true);
                mnuListaAlquiler.setVisible(true);

                break;

        }
    }

    public void validarBotonVehiculo() {
        if (rdMoto.isSelected()) {
            chbxCasco.setEnabled(true);

        } else {
            chbxCasco.setEnabled(false);
        }
        if (rdCoche.isSelected()) {
            chbxExtras.setEnabled(true);
        } else {
            chbxExtras.setEnabled(false);
        }
        if (rdFurgoneta.isSelected()) {
            spnCapFurgoneta.setEnabled(true);
        } else {
            spnCapFurgoneta.setEnabled(false);
        }

    }

    public void validarBotonUsuario() {
        if (rbAdministrador.isSelected()) {
            txtCrearCorreo.setEnabled(true);
            txtCrearPassword.setEnabled(true);
        } else {
            txtCrearCorreo.setEnabled(false);
            txtCrearPassword.setEnabled(false);
        }
        if (rbUsuario.isSelected()) {
            txtCrearCorreo.setEnabled(true);
            txtCrearPassword.setEnabled(true);
        } else {
            txtCrearCorreo.setEnabled(false);
            txtCrearPassword.setEnabled(false);
        }
        if (rbCliente.isSelected()) {
            txtCrearCorreo.setEnabled(false);
            txtCrearPassword.setEnabled(false);
        } else {
            txtCrearCorreo.setEnabled(true);
            txtCrearPassword.setEnabled(true);
        }
    }

    public void llenarComboMatricula() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbxMatriculas.getModel();
        model.removeAllElements();
        for (AbstractVehiculo vehiculo : gestionListaVehiculo.vehiculos) {
            model.addElement(vehiculo);

        }
        cbxMatriculas.setModel(model);
    }

    public void llenarComboCliente() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbxClientes.getModel();
        model.removeAllElements();
        for (Usuario usuario : gestionListarUsuario.getUsuarios()) {
            if (usuario.tipoUsuario.getCodigo().compareTo("2") == 0) {
                model.addElement(usuario);
            }
        }
        cbxClientes.setModel(model);
    }

    Date fechaActual = new Date(Calendar.getInstance().getTimeInMillis());
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
 

    //if (vehiculo.getMatricula().compareTo(cbxMatriculas.getItemListeners().toString()) == 0) {
    // return;
    //} else {
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgVehiculos = new javax.swing.ButtonGroup();
        bgUsuarios = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jfrmAcceder = new javax.swing.JInternalFrame();
        JLtitulo = new javax.swing.JLabel();
        jlCorreo = new javax.swing.JLabel();
        jlcontraseña = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtCorreo = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        jfrmListarVehiculos = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jfrmListarUsuarios = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        btnUsuariosPDF = new javax.swing.JButton();
        jfrmCrearVehiculos = new javax.swing.JInternalFrame();
        txtMatricula = new javax.swing.JTextField();
        txtKm = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        chbxEstado = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        chbxCasco = new javax.swing.JCheckBox();
        chbxExtras = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        spnCapFurgoneta = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        btnCrearVehiculo = new javax.swing.JButton();
        rdMoto = new javax.swing.JRadioButton();
        rdCoche = new javax.swing.JRadioButton();
        rdFurgoneta = new javax.swing.JRadioButton();
        jfrmCrearUsuarios = new javax.swing.JInternalFrame();
        rbCliente = new javax.swing.JRadioButton();
        rbAdministrador = new javax.swing.JRadioButton();
        rbUsuario = new javax.swing.JRadioButton();
        txtCrearCedula = new javax.swing.JTextField();
        txtCrearNombre = new javax.swing.JTextField();
        txtCrearCorreo = new javax.swing.JTextField();
        txtCrearPassword = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnCrearUsuario = new javax.swing.JButton();
        jfrmListadoGeneralVehiculo = new javax.swing.JInternalFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGeneralVehiculos = new javax.swing.JTable();
        btnGeneralPDF = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jfrmListadoCoche = new javax.swing.JInternalFrame();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCoche = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jfrmListadoMoto = new javax.swing.JInternalFrame();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblMoto = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jfrmListadoFurgoneta = new javax.swing.JInternalFrame();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblFurgoneta = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jfrmAlquilar = new javax.swing.JInternalFrame();
        cbxMatriculas = new javax.swing.JComboBox<>();
        cbxClientes = new javax.swing.JComboBox<>();
        jdateAlquiler = new com.toedter.calendar.JDateChooser();
        jDateDevolucion = new com.toedter.calendar.JDateChooser();
        btnAlquilar = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnDevolver = new javax.swing.JButton();
        jfrmDevolver = new javax.swing.JInternalFrame();
        jLabel24 = new javax.swing.JLabel();
        txtKmFinal = new javax.swing.JTextField();
        btnFinalizar = new javax.swing.JButton();
        jfrmListaAlquilados = new javax.swing.JInternalFrame();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblAlquilados = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        btnAlquilerPDF = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mnuCerrarSesion = new javax.swing.JMenuItem();
        mnuVehiculo = new javax.swing.JMenu();
        mnuListarVehiculo = new javax.swing.JMenu();
        mnuListarMotos = new javax.swing.JMenuItem();
        mnuListarCoches = new javax.swing.JMenuItem();
        mnuListarFurgonetas = new javax.swing.JMenuItem();
        mnuListadoGeneralVehiculo = new javax.swing.JMenuItem();
        mnuCrearVehiculo = new javax.swing.JMenuItem();
        mnuUsuario = new javax.swing.JMenu();
        mnuCrearUsuario = new javax.swing.JMenuItem();
        mnuListarUsuario = new javax.swing.JMenuItem();
        mnuAlquila = new javax.swing.JMenu();
        mnuListaAlquiler = new javax.swing.JMenuItem();
        mnuAlaquilarVehiculo = new javax.swing.JMenuItem();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jfrmAcceder.setVisible(true);

        JLtitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JLtitulo.setText("ACCERDER");

        jlCorreo.setText("CORREO ELECTRONICO *");

        jlcontraseña.setText("CONTRASEÑA *");

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jfrmAccederLayout = new javax.swing.GroupLayout(jfrmAcceder.getContentPane());
        jfrmAcceder.getContentPane().setLayout(jfrmAccederLayout);
        jfrmAccederLayout.setHorizontalGroup(
            jfrmAccederLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmAccederLayout.createSequentialGroup()
                .addGroup(jfrmAccederLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jfrmAccederLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(JLtitulo))
                    .addGroup(jfrmAccederLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jlcontraseña))
                    .addGroup(jfrmAccederLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jlCorreo))
                    .addGroup(jfrmAccederLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(btnIngresar))
                    .addGroup(jfrmAccederLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jfrmAccederLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCorreo)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jfrmAccederLayout.setVerticalGroup(
            jfrmAccederLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmAccederLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(JLtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jlCorreo)
                .addGap(18, 18, 18)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jlcontraseña)
                .addGap(18, 18, 18)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btnIngresar)
                .addContainerGap(476, Short.MAX_VALUE))
        );

        jfrmListarVehiculos.setClosable(true);
        jfrmListarVehiculos.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jfrmListarVehiculos.setIconifiable(true);
        jfrmListarVehiculos.setMaximizable(true);
        jfrmListarVehiculos.setResizable(true);
        jfrmListarVehiculos.setVisible(false);

        tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Km", "Estado", "Valor de Alquiler", "Tipo de Vehiculo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblVehiculos);

        jLabel13.setText("LISTA DE VEHICULOS");

        javax.swing.GroupLayout jfrmListarVehiculosLayout = new javax.swing.GroupLayout(jfrmListarVehiculos.getContentPane());
        jfrmListarVehiculos.getContentPane().setLayout(jfrmListarVehiculosLayout);
        jfrmListarVehiculosLayout.setHorizontalGroup(
            jfrmListarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmListarVehiculosLayout.createSequentialGroup()
                .addGroup(jfrmListarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jfrmListarVehiculosLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jfrmListarVehiculosLayout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jLabel13)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jfrmListarVehiculosLayout.setVerticalGroup(
            jfrmListarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jfrmListarVehiculosLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jfrmListarUsuarios.setClosable(true);
        jfrmListarUsuarios.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jfrmListarUsuarios.setIconifiable(true);
        jfrmListarUsuarios.setMaximizable(true);
        jfrmListarUsuarios.setResizable(true);
        jfrmListarUsuarios.setVisible(false);

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cedula", "Correo ", "Tipo Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUsuario);

        jLabel14.setText("LISTA USUARIOS");

        btnUsuariosPDF.setText("Exportar");
        btnUsuariosPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jfrmListarUsuariosLayout = new javax.swing.GroupLayout(jfrmListarUsuarios.getContentPane());
        jfrmListarUsuarios.getContentPane().setLayout(jfrmListarUsuariosLayout);
        jfrmListarUsuariosLayout.setHorizontalGroup(
            jfrmListarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmListarUsuariosLayout.createSequentialGroup()
                .addGroup(jfrmListarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jfrmListarUsuariosLayout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jLabel14))
                    .addGroup(jfrmListarUsuariosLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jfrmListarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jfrmListarUsuariosLayout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addComponent(btnUsuariosPDF)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jfrmListarUsuariosLayout.setVerticalGroup(
            jfrmListarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmListarUsuariosLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUsuariosPDF)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jfrmCrearVehiculos.setClosable(true);
        jfrmCrearVehiculos.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jfrmCrearVehiculos.setIconifiable(true);
        jfrmCrearVehiculos.setMaximizable(true);
        jfrmCrearVehiculos.setVisible(false);

        chbxEstado.setText("Disponible");
        chbxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbxEstadoActionPerformed(evt);
            }
        });

        jLabel1.setText("Matricula");

        jLabel2.setText("Kilometraje");

        jLabel3.setText("Valor del Alquiler");

        jLabel4.setText("Estado del Vehiculo");

        jLabel5.setText("Tipo de Vehiculo");

        chbxCasco.setText("Disponible");
        chbxCasco.setEnabled(false);
        chbxCasco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbxCascoActionPerformed(evt);
            }
        });

        chbxExtras.setText("Disponible");
        chbxExtras.setEnabled(false);
        chbxExtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbxExtrasActionPerformed(evt);
            }
        });

        jLabel6.setText("Casco");

        jLabel7.setText("Extras");

        spnCapFurgoneta.setEnabled(false);

        jLabel8.setText("capacidad");

        btnCrearVehiculo.setText("Crear");
        btnCrearVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearVehiculoActionPerformed(evt);
            }
        });

        bgVehiculos.add(rdMoto);
        rdMoto.setText("Moto");
        rdMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdMotoActionPerformed(evt);
            }
        });

        bgVehiculos.add(rdCoche);
        rdCoche.setText("Coche");
        rdCoche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdCocheActionPerformed(evt);
            }
        });

        bgVehiculos.add(rdFurgoneta);
        rdFurgoneta.setText("Furgoneta");
        rdFurgoneta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdFurgonetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jfrmCrearVehiculosLayout = new javax.swing.GroupLayout(jfrmCrearVehiculos.getContentPane());
        jfrmCrearVehiculos.getContentPane().setLayout(jfrmCrearVehiculosLayout);
        jfrmCrearVehiculosLayout.setHorizontalGroup(
            jfrmCrearVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jfrmCrearVehiculosLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jfrmCrearVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jfrmCrearVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jfrmCrearVehiculosLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jfrmCrearVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chbxEstado)
                            .addGroup(jfrmCrearVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMatricula)
                                .addComponent(txtKm)
                                .addComponent(txtValor, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))))
                    .addComponent(chbxCasco)
                    .addComponent(chbxExtras)
                    .addComponent(spnCapFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jfrmCrearVehiculosLayout.createSequentialGroup()
                        .addGroup(jfrmCrearVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCrearVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jfrmCrearVehiculosLayout.createSequentialGroup()
                                .addComponent(rdMoto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdCoche)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdFurgoneta)))
                .addContainerGap())
        );
        jfrmCrearVehiculosLayout.setVerticalGroup(
            jfrmCrearVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmCrearVehiculosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jfrmCrearVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jfrmCrearVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jfrmCrearVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jfrmCrearVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(chbxEstado))
                .addGap(18, 18, 18)
                .addGroup(jfrmCrearVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rdMoto)
                    .addComponent(rdCoche)
                    .addComponent(rdFurgoneta))
                .addGap(21, 21, 21)
                .addGroup(jfrmCrearVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(chbxCasco))
                .addGap(18, 18, 18)
                .addGroup(jfrmCrearVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(chbxExtras))
                .addGap(18, 18, 18)
                .addGroup(jfrmCrearVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(spnCapFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCrearVehiculo)
                .addContainerGap())
        );

        jfrmCrearUsuarios.setClosable(true);
        jfrmCrearUsuarios.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jfrmCrearUsuarios.setIconifiable(true);
        jfrmCrearUsuarios.setMaximizable(true);
        jfrmCrearUsuarios.setResizable(true);
        jfrmCrearUsuarios.setVisible(false);

        bgUsuarios.add(rbCliente);
        rbCliente.setText("Cliente");
        rbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbClienteActionPerformed(evt);
            }
        });

        bgUsuarios.add(rbAdministrador);
        rbAdministrador.setText("Administrador");
        rbAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAdministradorActionPerformed(evt);
            }
        });

        bgUsuarios.add(rbUsuario);
        rbUsuario.setText("Usuario");
        rbUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbUsuarioActionPerformed(evt);
            }
        });

        txtCrearCorreo.setEnabled(false);

        txtCrearPassword.setEnabled(false);
        txtCrearPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCrearPasswordActionPerformed(evt);
            }
        });

        jLabel9.setText("Cedula");

        jLabel10.setText("Nombre");

        jLabel11.setText("Correo Electronico");

        jLabel12.setText("Password");

        btnCrearUsuario.setText("Crear");
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jfrmCrearUsuariosLayout = new javax.swing.GroupLayout(jfrmCrearUsuarios.getContentPane());
        jfrmCrearUsuarios.getContentPane().setLayout(jfrmCrearUsuariosLayout);
        jfrmCrearUsuariosLayout.setHorizontalGroup(
            jfrmCrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmCrearUsuariosLayout.createSequentialGroup()
                .addGroup(jfrmCrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jfrmCrearUsuariosLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jfrmCrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)))
                    .addGroup(jfrmCrearUsuariosLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(rbCliente)))
                .addGroup(jfrmCrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jfrmCrearUsuariosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jfrmCrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jfrmCrearUsuariosLayout.createSequentialGroup()
                                .addComponent(btnCrearUsuario)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jfrmCrearUsuariosLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jfrmCrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCrearCedula)
                                    .addComponent(txtCrearNombre)
                                    .addComponent(txtCrearCorreo)
                                    .addComponent(txtCrearPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                                .addGap(53, 53, 53))))
                    .addGroup(jfrmCrearUsuariosLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(rbAdministrador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbUsuario)
                        .addGap(32, 32, 32))))
        );
        jfrmCrearUsuariosLayout.setVerticalGroup(
            jfrmCrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmCrearUsuariosLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jfrmCrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbCliente)
                    .addComponent(rbAdministrador)
                    .addComponent(rbUsuario))
                .addGap(31, 31, 31)
                .addGroup(jfrmCrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCrearCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jfrmCrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCrearNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jfrmCrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCrearCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jfrmCrearUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCrearPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCrearUsuario)
                .addGap(32, 32, 32))
        );

        jfrmListadoGeneralVehiculo.setClosable(true);
        jfrmListadoGeneralVehiculo.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jfrmListadoGeneralVehiculo.setIconifiable(true);
        jfrmListadoGeneralVehiculo.setMaximizable(true);
        jfrmListadoGeneralVehiculo.setResizable(true);
        jfrmListadoGeneralVehiculo.setVisible(false);

        tblGeneralVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Kilometraje", "Estado", "Valor de Alquiler", "Tipo de Vehiculo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblGeneralVehiculos);

        btnGeneralPDF.setText("Exportar");
        btnGeneralPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneralPDFActionPerformed(evt);
            }
        });

        jLabel15.setText("LISTADO GENERAL DE VEHICULOS");

        javax.swing.GroupLayout jfrmListadoGeneralVehiculoLayout = new javax.swing.GroupLayout(jfrmListadoGeneralVehiculo.getContentPane());
        jfrmListadoGeneralVehiculo.getContentPane().setLayout(jfrmListadoGeneralVehiculoLayout);
        jfrmListadoGeneralVehiculoLayout.setHorizontalGroup(
            jfrmListadoGeneralVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmListadoGeneralVehiculoLayout.createSequentialGroup()
                .addGroup(jfrmListadoGeneralVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jfrmListadoGeneralVehiculoLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel15))
                    .addGroup(jfrmListadoGeneralVehiculoLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(btnGeneralPDF))
                    .addGroup(jfrmListadoGeneralVehiculoLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jfrmListadoGeneralVehiculoLayout.setVerticalGroup(
            jfrmListadoGeneralVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmListadoGeneralVehiculoLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGeneralPDF)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jfrmListadoCoche.setClosable(true);
        jfrmListadoCoche.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jfrmListadoCoche.setIconifiable(true);
        jfrmListadoCoche.setMaximizable(true);
        jfrmListadoCoche.setResizable(true);
        jfrmListadoCoche.setVisible(false);

        tblCoche.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Kilometraje", "Estado", "Valor de Alquiler", "Extras"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblCoche);

        jLabel16.setText("LISTADO DE COCHES");

        javax.swing.GroupLayout jfrmListadoCocheLayout = new javax.swing.GroupLayout(jfrmListadoCoche.getContentPane());
        jfrmListadoCoche.getContentPane().setLayout(jfrmListadoCocheLayout);
        jfrmListadoCocheLayout.setHorizontalGroup(
            jfrmListadoCocheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmListadoCocheLayout.createSequentialGroup()
                .addGroup(jfrmListadoCocheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jfrmListadoCocheLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jfrmListadoCocheLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel16)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jfrmListadoCocheLayout.setVerticalGroup(
            jfrmListadoCocheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmListadoCocheLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jfrmListadoMoto.setClosable(true);
        jfrmListadoMoto.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jfrmListadoMoto.setIconifiable(true);
        jfrmListadoMoto.setMaximizable(true);
        jfrmListadoMoto.setResizable(true);
        jfrmListadoMoto.setVisible(false);

        tblMoto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Kilometraje", "Estado", "Valor de Alquiler", "Casco"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblMoto);

        jLabel17.setText("LISTADO MOTOS");

        javax.swing.GroupLayout jfrmListadoMotoLayout = new javax.swing.GroupLayout(jfrmListadoMoto.getContentPane());
        jfrmListadoMoto.getContentPane().setLayout(jfrmListadoMotoLayout);
        jfrmListadoMotoLayout.setHorizontalGroup(
            jfrmListadoMotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmListadoMotoLayout.createSequentialGroup()
                .addGroup(jfrmListadoMotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jfrmListadoMotoLayout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jLabel17))
                    .addGroup(jfrmListadoMotoLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jfrmListadoMotoLayout.setVerticalGroup(
            jfrmListadoMotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jfrmListadoMotoLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        jfrmListadoFurgoneta.setClosable(true);
        jfrmListadoFurgoneta.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jfrmListadoFurgoneta.setIconifiable(true);
        jfrmListadoFurgoneta.setMaximizable(true);
        jfrmListadoFurgoneta.setResizable(true);
        jfrmListadoFurgoneta.setVisible(false);

        tblFurgoneta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Kilometraje", "Estado", "Valor de Alquiler", "Capacidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Double.class, java.lang.Short.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblFurgoneta);

        jLabel18.setText("LISTADO FURGONETAS");

        javax.swing.GroupLayout jfrmListadoFurgonetaLayout = new javax.swing.GroupLayout(jfrmListadoFurgoneta.getContentPane());
        jfrmListadoFurgoneta.getContentPane().setLayout(jfrmListadoFurgonetaLayout);
        jfrmListadoFurgonetaLayout.setHorizontalGroup(
            jfrmListadoFurgonetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmListadoFurgonetaLayout.createSequentialGroup()
                .addGroup(jfrmListadoFurgonetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jfrmListadoFurgonetaLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jfrmListadoFurgonetaLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel18)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jfrmListadoFurgonetaLayout.setVerticalGroup(
            jfrmListadoFurgonetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmListadoFurgonetaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jfrmAlquilar.setClosable(true);
        jfrmAlquilar.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jfrmAlquilar.setIconifiable(true);
        jfrmAlquilar.setMaximizable(true);
        jfrmAlquilar.setResizable(true);
        jfrmAlquilar.setVisible(false);

        cbxMatriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMatriculasActionPerformed(evt);
            }
        });

        btnAlquilar.setText("Alquilar");
        btnAlquilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlquilarActionPerformed(evt);
            }
        });

        jLabel20.setText("Vehiculos disponibles");

        jLabel21.setText("Clientes");

        jLabel22.setText("Fecha de alquiler");

        jLabel23.setText("Fecha de devolucion");

        btnDevolver.setText("Devolver");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        jfrmDevolver.setClosable(true);
        jfrmDevolver.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jfrmDevolver.setIconifiable(true);
        jfrmDevolver.setMaximizable(true);
        jfrmDevolver.setResizable(true);
        jfrmDevolver.setVisible(false);

        jLabel24.setText("Kilometraje final");

        txtKmFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKmFinalActionPerformed(evt);
            }
        });
        txtKmFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKmFinalKeyTyped(evt);
            }
        });

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jfrmDevolverLayout = new javax.swing.GroupLayout(jfrmDevolver.getContentPane());
        jfrmDevolver.getContentPane().setLayout(jfrmDevolverLayout);
        jfrmDevolverLayout.setHorizontalGroup(
            jfrmDevolverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmDevolverLayout.createSequentialGroup()
                .addGroup(jfrmDevolverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jfrmDevolverLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel24))
                    .addGroup(jfrmDevolverLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(btnFinalizar))
                    .addGroup(jfrmDevolverLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(txtKmFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jfrmDevolverLayout.setVerticalGroup(
            jfrmDevolverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmDevolverLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtKmFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnFinalizar)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jfrmAlquilarLayout = new javax.swing.GroupLayout(jfrmAlquilar.getContentPane());
        jfrmAlquilar.getContentPane().setLayout(jfrmAlquilarLayout);
        jfrmAlquilarLayout.setHorizontalGroup(
            jfrmAlquilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmAlquilarLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(96, 96, 96))
            .addGroup(jfrmAlquilarLayout.createSequentialGroup()
                .addGroup(jfrmAlquilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jfrmAlquilarLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jfrmAlquilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdateAlquiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)))
                    .addGroup(jfrmAlquilarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbxMatriculas, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jfrmAlquilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jfrmAlquilarLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jfrmAlquilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jfrmAlquilarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
            .addGroup(jfrmAlquilarLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(btnAlquilar)
                .addGap(67, 67, 67)
                .addComponent(btnDevolver)
                .addGap(18, 18, 18)
                .addComponent(jfrmDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jfrmAlquilarLayout.setVerticalGroup(
            jfrmAlquilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmAlquilarLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jfrmAlquilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jfrmAlquilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxMatriculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jfrmAlquilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jfrmAlquilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdateAlquiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jfrmAlquilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jfrmAlquilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDevolver)
                        .addComponent(btnAlquilar))
                    .addComponent(jfrmDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jfrmListaAlquilados.setClosable(true);
        jfrmListaAlquilados.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jfrmListaAlquilados.setIconifiable(true);
        jfrmListaAlquilados.setMaximizable(true);
        jfrmListaAlquilados.setResizable(true);
        jfrmListaAlquilados.setVisible(false);

        tblAlquilados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula Vehiculo", "Cliente", "Fecha de Alquiler", "Fecha de Devolucion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tblAlquilados);

        jLabel19.setText("LISTA DE ALQUILER");

        btnAlquilerPDF.setText("Exportar");
        btnAlquilerPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlquilerPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jfrmListaAlquiladosLayout = new javax.swing.GroupLayout(jfrmListaAlquilados.getContentPane());
        jfrmListaAlquilados.getContentPane().setLayout(jfrmListaAlquiladosLayout);
        jfrmListaAlquiladosLayout.setHorizontalGroup(
            jfrmListaAlquiladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmListaAlquiladosLayout.createSequentialGroup()
                .addGroup(jfrmListaAlquiladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jfrmListaAlquiladosLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jfrmListaAlquiladosLayout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel19))
                    .addGroup(jfrmListaAlquiladosLayout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(btnAlquilerPDF)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jfrmListaAlquiladosLayout.setVerticalGroup(
            jfrmListaAlquiladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfrmListaAlquiladosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAlquilerPDF)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(jfrmAcceder, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jfrmListarVehiculos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jfrmListarUsuarios, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jfrmCrearVehiculos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jfrmCrearUsuarios, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jfrmListadoGeneralVehiculo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jfrmListadoCoche, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jfrmListadoMoto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jfrmListadoFurgoneta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jfrmAlquilar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jfrmListaAlquilados, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jfrmCrearVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jfrmListarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jfrmAlquilar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jfrmListaAlquilados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jfrmCrearUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jfrmListadoGeneralVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jfrmAcceder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(732, 732, 732)
                    .addComponent(jfrmListarVehiculos, 0, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addComponent(jfrmListadoCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(638, Short.MAX_VALUE)))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jfrmListadoMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(145, Short.MAX_VALUE)))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jfrmListadoFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(145, Short.MAX_VALUE)))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jfrmAcceder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jfrmListarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jfrmCrearVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(153, 153, 153)
                                .addComponent(jfrmListadoGeneralVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jfrmCrearUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jfrmAlquilar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jfrmListaAlquilados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(198, Short.MAX_VALUE))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addComponent(jfrmListarVehiculos, 0, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(858, Short.MAX_VALUE)))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(206, 206, 206)
                    .addComponent(jfrmListadoCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(750, Short.MAX_VALUE)))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jfrmListadoMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(719, Short.MAX_VALUE)))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jfrmListadoFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(719, Short.MAX_VALUE)))
        );

        mnuArchivo.setText("Menu");
        mnuArchivo.setEnabled(false);

        mnuCerrarSesion.setText("Cerrar Sesion");
        mnuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCerrarSesionActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuCerrarSesion);

        mnuVehiculo.setText("Vehiculos");

        mnuListarVehiculo.setText("Listar Vehiculos");

        mnuListarMotos.setText("Lista de Motos");
        mnuListarMotos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListarMotosActionPerformed(evt);
            }
        });
        mnuListarVehiculo.add(mnuListarMotos);

        mnuListarCoches.setText("Lista de Coches");
        mnuListarCoches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListarCochesActionPerformed(evt);
            }
        });
        mnuListarVehiculo.add(mnuListarCoches);

        mnuListarFurgonetas.setText("Lista de Furgonetas");
        mnuListarFurgonetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListarFurgonetasActionPerformed(evt);
            }
        });
        mnuListarVehiculo.add(mnuListarFurgonetas);

        mnuListadoGeneralVehiculo.setText("Listado General");
        mnuListadoGeneralVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListadoGeneralVehiculoActionPerformed(evt);
            }
        });
        mnuListarVehiculo.add(mnuListadoGeneralVehiculo);

        mnuVehiculo.add(mnuListarVehiculo);

        mnuCrearVehiculo.setText("Crear Vehiculo");
        mnuCrearVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCrearVehiculoActionPerformed(evt);
            }
        });
        mnuVehiculo.add(mnuCrearVehiculo);

        mnuArchivo.add(mnuVehiculo);

        mnuUsuario.setText("Usuarios");

        mnuCrearUsuario.setText("Crear Usuarios");
        mnuCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCrearUsuarioActionPerformed(evt);
            }
        });
        mnuUsuario.add(mnuCrearUsuario);

        mnuListarUsuario.setText("Listar Usuarios");
        mnuListarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListarUsuarioActionPerformed(evt);
            }
        });
        mnuUsuario.add(mnuListarUsuario);

        mnuArchivo.add(mnuUsuario);

        mnuAlquila.setText("Alquiler");

        mnuListaAlquiler.setText("Lista de alquiler");
        mnuListaAlquiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListaAlquilerActionPerformed(evt);
            }
        });
        mnuAlquila.add(mnuListaAlquiler);

        mnuAlaquilarVehiculo.setText("Alquilar Vehiculo");
        mnuAlaquilarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAlaquilarVehiculoActionPerformed(evt);
            }
        });
        mnuAlquila.add(mnuAlaquilarVehiculo);

        mnuArchivo.add(mnuAlquila);

        jMenuBar1.add(mnuArchivo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        if (txtCorreo.getText() == null || txtCorreo.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(this,
                    "Debe diligenciar el correo", "Datos Faltantes", 2);
        } else if (txtPassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this,
                    "Debe diligenciar la contraseña", "Datos Faltantes", 2);
        } else {
            gestionLogin = new GestionUsuario();

            //Significa que diligencio correo y contraseña
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
            Matcher matcher = pattern.matcher(txtCorreo.getText());

            if (matcher.find() == true) {
                usuarioAutenticado = gestionLogin.encontrarUsuario(txtCorreo.getText(), txtPassword.getText());
                if (usuarioAutenticado == null) {
                    JOptionPane.showMessageDialog(this,
                            "El usuario Ingresado no existe", "Datos Erróneos", 0);
                } else {
                    gestionListarUsuario = new GestionUsuario();
                    gestionListaVehiculo = new GestionVehiculo();

                    JOptionPane.showMessageDialog(this,
                            "Bienvenido " + usuarioAutenticado.toString1(), "Bienvenido", 1);
                    mnuArchivo.setEnabled(true);
                    gestionarPermisosMenu();
                    jfrmAcceder.hide();
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "El correo no tiene un formato válido", "Datos Erróneos", 0);

            }

        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void llenarUsuario() {
        DefaultTableModel model = (DefaultTableModel) tblUsuario.getModel();
        model.getDataVector().removeAllElements();
        for (Usuario usuario : gestionListarUsuario.getUsuarios()) {
            model.addRow(usuario.obtenerArregloObjeto());
        }
        tblUsuario.setModel(model);

    }

    private void llenarAlquiler() {
        DefaultTableModel model = (DefaultTableModel) tblAlquilados.getModel();
        model.getDataVector().removeAllElements();
        for (AlquilarVehiculo alquilar : gestionListaVehiculo.getVehiculosAlquilados()) {
            model.addRow(alquilar.obtenerArregloObjeto());
        }
        tblAlquilados.setModel(model);

    }

    private void listarMotos() {
        DefaultTableModel model = (DefaultTableModel) tblMoto.getModel();
        model.getDataVector().removeAllElements();

        for (AbstractVehiculo moto : gestionListaVehiculo.obtenerVehiculo("Moto")) {
            model.addRow(moto.obtenerArregloObjeto());
        }
        tblMoto.setModel(model);
    }

    private void listarCoches() {
        DefaultTableModel model = (DefaultTableModel) tblCoche.getModel();
        model.getDataVector().removeAllElements();

        for (AbstractVehiculo coche : gestionListaVehiculo.obtenerVehiculo("Coche")) {
            model.addRow(coche.obtenerArregloObjeto());
        }
        tblCoche.setModel(model);
    }

    private void listarFurgonetas() {
        DefaultTableModel model = (DefaultTableModel) tblFurgoneta.getModel();
        model.getDataVector().removeAllElements();

        for (AbstractVehiculo furgoneta : gestionListaVehiculo.obtenerVehiculo("Furgoneta")) {
            model.addRow(furgoneta.obtenerArregloObjeto());
        }
        tblFurgoneta.setModel(model);
    }

    private void listadoGeneral() {
        DefaultTableModel model = (DefaultTableModel) tblGeneralVehiculos.getModel();
        model.getDataVector().removeAllElements();

        for (AbstractVehiculo general : gestionListaVehiculo.obtenerVehiculo("")) {
            model.addRow(general.obtenerArregloObjeto());
        }
        tblGeneralVehiculos.setModel(model);
    }
    private void chbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbxEstadoActionPerformed

    private void chbxCascoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbxCascoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbxCascoActionPerformed

    private void chbxExtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbxExtrasActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_chbxExtrasActionPerformed

    private void btnCrearVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearVehiculoActionPerformed
        // TODO add your handling code here:
        if (txtMatricula.getText() == null || txtMatricula.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(this,
                    "Debe diligenciar la matricula del vehiculo", "Datos Faltantes", 2);
        } else if (txtKm.getText() == null || txtKm.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(this,
                    "Debe diligenciar el Kilometraje del Vehiculo", "Datos Faltantes", 2);
        } else if (txtValor.getText() == null || txtValor.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(this,
                    "Debe diligenciar el valor de Alquiler del Vehiculo", "Datos Faltantes", 2);
        } else if (rdCoche.isSelected() == false && rdMoto.isSelected() == false
                && rdFurgoneta.isSelected() == false) {
            JOptionPane.showMessageDialog(null,
                    "Debe seleccionar un tipo de vehiculo", "Datos Faltantes", 2);
        } else {
            if (rdMoto.isSelected() == true) {
                Moto mot = new Moto(chbxCasco.isSelected(), txtMatricula.getText(), Integer.parseInt(txtKm.getText()),
                        chbxEstado.isSelected(), Double.parseDouble(txtValor.getText()));
                try {
                    gestionListaVehiculo.adicionarVehiculo(mot);
                    listarMotos();
                    listadoGeneral();
                } catch (ExcepcionVehiculo ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "error en vehiculo", 0);
                }
            } else if (rdCoche.isSelected() == true) {
                Coche coh = new Coche(chbxExtras.isSelected(), txtMatricula.getText(),
                        Integer.parseInt(txtKm.getText()), chbxEstado.isSelected(), Double.parseDouble(txtValor.getText()));
                try {
                    gestionListaVehiculo.adicionarVehiculo(coh);
                    listarCoches();
                    listadoGeneral();
                } catch (ExcepcionVehiculo ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "error en vehiculo", 0);
                }
            } else if (rdFurgoneta.isSelected() == true) {
                Furgoneta fur = new Furgoneta(Short.parseShort(spnCapFurgoneta.getValue().toString()), txtMatricula.getText(),
                        Integer.parseInt(txtKm.getText()), chbxEstado.isSelected(), Double.parseDouble(txtValor.getText()));
                try {
                    gestionListaVehiculo.adicionarVehiculo(fur);
                    listarFurgonetas();
                    listadoGeneral();
                    llenarComboMatricula();
                    JOptionPane.showMessageDialog(this, "correcto");
                } catch (ExcepcionVehiculo ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "error en vehiculo", 0);
                }
            }

        }

    }//GEN-LAST:event_btnCrearVehiculoActionPerformed

    private void rdMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdMotoActionPerformed
        validarBotonVehiculo();
    }//GEN-LAST:event_rdMotoActionPerformed

    private void rdCocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCocheActionPerformed
        validarBotonVehiculo();
    }//GEN-LAST:event_rdCocheActionPerformed

    private void rdFurgonetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFurgonetaActionPerformed
        validarBotonVehiculo();
    }//GEN-LAST:event_rdFurgonetaActionPerformed

    private void txtCrearPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCrearPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCrearPasswordActionPerformed

    private void rbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbClienteActionPerformed
        validarBotonUsuario();
    }//GEN-LAST:event_rbClienteActionPerformed

    private void rbAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAdministradorActionPerformed
        validarBotonUsuario();
    }//GEN-LAST:event_rbAdministradorActionPerformed

    private void rbUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbUsuarioActionPerformed
        validarBotonUsuario();
    }//GEN-LAST:event_rbUsuarioActionPerformed

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        // TODO add your handling code here:
        int tipo = 0;
        boolean bandera = false;
        if (rbAdministrador.isSelected() == false && rbCliente.isSelected() == false
                && rbUsuario.isSelected() == false) {
            JOptionPane.showMessageDialog(this,
                    "Debe seleccionar un tipo de usuario", "Datos Faltantes", 2);
        } else if (rbAdministrador.isSelected() == true || rbUsuario.isSelected() == true) {
            if (txtCrearCedula.getText() == null || txtCrearCedula.getText().compareTo("") == 0) {
                JOptionPane.showMessageDialog(this,
                        "Debe diligenciar una cedula", "Datos Faltantes", 2);
            } else if (txtCrearNombre.getText() == null || txtCrearNombre.getText().compareTo("") == 0) {
                JOptionPane.showMessageDialog(this,
                        "Debe diligenciar el nombre", "Datos Faltantes", 2);
            } else if (txtCrearCorreo.getText() == null || txtCrearCorreo.getText().compareTo("") == 0) {
                JOptionPane.showMessageDialog(this,
                        "Debe diligenciar el correo", "Datos Faltantes", 2);
            } else if (txtCrearPassword.getText() == null || txtCrearPassword.getText().compareTo("") == 0) {
                JOptionPane.showMessageDialog(this,
                        "Debe seleccionar la contraseña", "Datos Faltantes", 2);
            } else {
                bandera = true;
            }

        } else if (rbCliente.isSelected() == true) {
            if (txtCrearCedula.getText() == null || txtCrearCedula.getText().compareTo("") == 0) {
                JOptionPane.showMessageDialog(this,
                        "Debe diligenciar una cedula", "Datos Faltantes", 2);
            } else if (txtCrearNombre.getText() == null || txtCrearNombre.getText().compareTo("") == 0) {
                JOptionPane.showMessageDialog(this,
                        "Debe diligenciar el nombre", "Datos Faltantes", 2);
            } else {
                bandera = true;
            }
        }
        if (bandera) {

            if (rbAdministrador.isSelected() == true) {
                tipo = 0;

            } else if (rbUsuario.isSelected() == true) {
                tipo = 1;
            } else {
                tipo = 2;
            }
            Usuario us = new Usuario(txtCrearCedula.getText(), txtCrearNombre.getText(), txtCrearCorreo.getText(), txtCrearPassword.getPassword().toString(), gestionListarUsuario.getTipoUsuarios()[tipo]);
            try {

                gestionListarUsuario.adicionarUsuario(us);
                llenarUsuario();
                llenarComboCliente();
                JOptionPane.showMessageDialog(this, "correcto");
            } catch (ExcepcionVehiculo ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "error en usuario", 0);
            }
        }


    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    private void mnuListarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListarUsuarioActionPerformed
        // TODO add your handling code here:
        llenarUsuario();
        jfrmListarUsuarios.repaint();
        jfrmListarUsuarios.show();
        if (jfrmListarUsuarios.isIcon()) {
            try {
                jfrmListarUsuarios.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mnuListarUsuarioActionPerformed

    private void mnuCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCrearUsuarioActionPerformed
        // TODO add your handling code here:
        jfrmCrearUsuarios.repaint();
        jfrmCrearUsuarios.show();
        if (jfrmCrearUsuarios.isIcon()) {
            try {
                jfrmCrearUsuarios.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mnuCrearUsuarioActionPerformed

    private void mnuCrearVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCrearVehiculoActionPerformed
        // TODO add your handling code here:
        jfrmCrearVehiculos.repaint();
        jfrmCrearVehiculos.show();
        if (jfrmCrearVehiculos.isIcon()) {
            try {
                jfrmCrearVehiculos.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mnuCrearVehiculoActionPerformed

    private void mnuListadoGeneralVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListadoGeneralVehiculoActionPerformed
        // TODO add your handling code here:
        listadoGeneral();
        jfrmListadoGeneralVehiculo.repaint();
        jfrmListadoGeneralVehiculo.show();
        if (jfrmListadoGeneralVehiculo.isIcon()) {
            try {
                jfrmListadoGeneralVehiculo.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mnuListadoGeneralVehiculoActionPerformed

    private void mnuListarFurgonetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListarFurgonetasActionPerformed
        // TODO add your handling code here:
        listarFurgonetas();
        jfrmListadoFurgoneta.repaint();
        jfrmListadoFurgoneta.show();
        if (jfrmListadoFurgoneta.isIcon()) {
            try {
                jfrmListadoFurgoneta.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mnuListarFurgonetasActionPerformed

    private void mnuListarCochesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListarCochesActionPerformed
        // TODO add your handling code here:
        listarCoches();
        jfrmListadoCoche.repaint();
        jfrmListadoCoche.show();
        if (jfrmListadoCoche.isIcon()) {
            try {
                jfrmListadoCoche.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mnuListarCochesActionPerformed

    private void mnuListarMotosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListarMotosActionPerformed
        // TODO add your handling code here:

        listarMotos();
        jfrmListadoMoto.repaint();
        jfrmListadoMoto.show();
        if (jfrmListadoMoto.isIcon()) {
            try {
                jfrmListadoMoto.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mnuListarMotosActionPerformed

    private void mnuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCerrarSesionActionPerformed
        // TODO add your handling code here:
        mnuArchivo.setEnabled(false);
        txtCorreo.setText("");
        txtPassword.setText("");
        usuarioAutenticado = null;
        iniciarMenus(false);
        jfrmAcceder.show();
    }//GEN-LAST:event_mnuCerrarSesionActionPerformed

    private void mnuAlaquilarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAlaquilarVehiculoActionPerformed
        // TODO add your handling code here:
        llenarComboMatricula();
        llenarComboCliente();
        cbxMatriculas.setEnabled(true);
        cbxClientes.setEnabled(true);
        btnAlquilar.setEnabled(true);
        jdateAlquiler.setEnabled(true);
        jDateDevolucion.setEnabled(true);
        jfrmAlquilar.show();
        if (jfrmAlquilar.isIcon()) {
            try {
                jfrmAlquilar.setMaximum(true);

            } catch (PropertyVetoException ex) {
                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mnuAlaquilarVehiculoActionPerformed

    private void cbxMatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMatriculasActionPerformed
        // TODO add your handling code here:        
    }//GEN-LAST:event_cbxMatriculasActionPerformed

    private void btnAlquilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlquilarActionPerformed
        // TODO add your handling code here:
        if (jdateAlquiler.getDate() == null) {
            JOptionPane.showMessageDialog(this, "debe seleccionar una fecha de alquiler");
        } else if (jDateDevolucion.getDate() == null) {
            JOptionPane.showMessageDialog(this, "debe seleccionar una fecha de devolucion");
        } else if (jdateAlquiler.getDate().compareTo(jDateDevolucion.getDate()) > 0) {
            JOptionPane.showMessageDialog(this, "La fecha de alquiler debe ser anterior a la fecha de devolucion");
        } else if (fechaActual.compareTo(jdateAlquiler.getDate()) >= 0) {
            JOptionPane.showMessageDialog(this, "la fecha de Alquiler debe ser vigente");

        } else {

            Usuario cliente = (Usuario) cbxClientes.getSelectedItem();
            AbstractVehiculo vehiculoAlquilado = (AbstractVehiculo) cbxMatriculas.getSelectedItem();
            if (vehiculoAlquilado.isEstado() == false) {
                JOptionPane.showMessageDialog(this, "El vehiculo selecionado esta ocupado ");
            } else {
                JOptionPane.showMessageDialog(this, vehiculoAlquilado.mostrarDatos());
                int dias = gestionListaVehiculo.contarDias(jdateAlquiler, jDateDevolucion);
                double valor = vehiculoAlquilado.calcularAlquiler(dias);
                JOptionPane.showMessageDialog(this, "el alquiler durante " + dias + "tiene un precio de " + valor);
                vehiculoAlquilado.alquilar();
                llenarComboMatricula();
                listadoGeneral();
                listarCoches();
                listarFurgonetas();
                listarMotos();

                AlquilarVehiculo alquilarVehiculo = new AlquilarVehiculo(vehiculoAlquilado, cliente,
                        jdateAlquiler.getDate(), jDateDevolucion.getDate());

                gestionListaVehiculo.adicionarVehiculoAlquilado(alquilarVehiculo);
                llenarAlquiler();
                JOptionPane.showMessageDialog(this, "Alquilado al cliente " + cliente);

            }
        }
    }//GEN-LAST:event_btnAlquilarActionPerformed


    private void mnuListaAlquilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListaAlquilerActionPerformed
        // TODO add your handling code here:
        llenarAlquiler();
        jfrmListaAlquilados.repaint();
        jfrmListaAlquilados.show();
        if (jfrmListaAlquilados.isIcon()) {
            try {
                jfrmListaAlquilados.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mnuListaAlquilerActionPerformed

    private void btnAlquilerPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlquilerPDFActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            ArchivoPDF alquilerPDF = new ArchivoPDF();
            alquilerPDF.crearDocumentoPdfVehiculosAlquilados("./src/archivospdf/tablas.pdf",
                    gestionListaVehiculo.getVehiculosAlquilados());
            alquilerPDF.abrirDocumento("./src/archivospdf/tablas.pdf");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnAlquilerPDFActionPerformed

    private void btnGeneralPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneralPDFActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            ArchivoPDF VehiculosPDF = new ArchivoPDF();
            VehiculosPDF.crearDocumentoPdfVehiculosGeneral("./src/archivospdf/tablas.pdf",
                    gestionListaVehiculo.getVehiculos());
            VehiculosPDF.abrirDocumento("./src/archivospdf/tablas.pdf");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnGeneralPDFActionPerformed

    private void btnUsuariosPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosPDFActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            ArchivoPDF usuariosPDF = new ArchivoPDF();
            usuariosPDF.crearDocumentoPdfUsuarios("./src/archivospdf/tablas.pdf",
                    gestionListarUsuario.getUsuarios());
            usuariosPDF.abrirDocumento("./src/archivospdf/tablas.pdf");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnUsuariosPDFActionPerformed

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        // TODO add your handling code here:
        AbstractVehiculo vehiculoDevolucion = (AbstractVehiculo) cbxMatriculas.getSelectedItem();
        if (vehiculoDevolucion.isEstado() == true) {
            JOptionPane.showMessageDialog(this, "El vehiculo selecionado esta disponible ");
        } else {

            for (AlquilarVehiculo devolverVehiculo : gestionListaVehiculo.getVehiculosAlquilados()) {
                if (devolverVehiculo.getVehiculo().equals(vehiculoDevolucion)) {
                    if (formatter.format(fechaActual).compareTo(formatter.format(devolverVehiculo.getFechaDevolucion())) < 0) {
                        JOptionPane.showMessageDialog(this, "el vehiculo esta alquilado hasta " + devolverVehiculo.getFechaDevolucion());

                    } else {
                        cbxMatriculas.setEnabled(false);
                        cbxClientes.setEnabled(false);
                        btnAlquilar.setEnabled(false);
                        jdateAlquiler.setEnabled(false);
                        jDateDevolucion.setEnabled(false);
                        jfrmDevolver.show();
                        if (jfrmDevolver.isIcon()) {
                            try {
                                jfrmDevolver.setMaximum(true);
                            } catch (PropertyVetoException ex) {
                                Logger.getLogger(MdiVehiculos.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            }
        }

    }//GEN-LAST:event_btnDevolverActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        // TODO add your handling code here:
        AbstractVehiculo vehiculoDevolucion = (AbstractVehiculo) cbxMatriculas.getSelectedItem();
        if (txtKmFinal.getText() == null || txtKmFinal.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(this,
                    "Debe digitar el Kilometraje de devolucion del vehiculo", "Datos Faltantes", 2);

        } else {
            int kmFin = Integer.parseInt(txtKmFinal.getText());
            vehiculoDevolucion.debolver(kmFin);
            llenarComboMatricula();
            listarMotos();
            listadoGeneral();
            listarCoches();
            listarFurgonetas();
            for (AlquilarVehiculo devolverVehiculo : gestionListaVehiculo.getVehiculosAlquilados()) {
                if (devolverVehiculo.getVehiculo().equals(vehiculoDevolucion)) {
                    gestionListaVehiculo.getVehiculosAlquilados().remove(devolverVehiculo);
                }
                llenarAlquiler();
                cbxMatriculas.setEnabled(true);
                cbxClientes.setEnabled(true);
                btnAlquilar.setEnabled(true);
                jdateAlquiler.setEnabled(true);
                jDateDevolucion.setEnabled(true);
                jfrmDevolver.hide();
            }
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void txtKmFinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKmFinalKeyTyped
        // TODO add your handling code here:

        char validarKm = evt.getKeyChar();
        if (!Character.isDigit(validarKm)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Debe digitar un valor en Kilometros");
        }
    }//GEN-LAST:event_txtKmFinalKeyTyped

    private void txtKmFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKmFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKmFinalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MdiVehiculos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MdiVehiculos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MdiVehiculos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MdiVehiculos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MdiVehiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLtitulo;
    private javax.swing.ButtonGroup bgUsuarios;
    private javax.swing.ButtonGroup bgVehiculos;
    private javax.swing.JButton btnAlquilar;
    private javax.swing.JButton btnAlquilerPDF;
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JButton btnCrearVehiculo;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnGeneralPDF;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnUsuariosPDF;
    private javax.swing.JComboBox<String> cbxClientes;
    private javax.swing.JComboBox<String> cbxMatriculas;
    private javax.swing.JCheckBox chbxCasco;
    private javax.swing.JCheckBox chbxEstado;
    private javax.swing.JCheckBox chbxExtras;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateDevolucion;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private com.toedter.calendar.JDateChooser jdateAlquiler;
    private javax.swing.JInternalFrame jfrmAcceder;
    private javax.swing.JInternalFrame jfrmAlquilar;
    private javax.swing.JInternalFrame jfrmCrearUsuarios;
    private javax.swing.JInternalFrame jfrmCrearVehiculos;
    private javax.swing.JInternalFrame jfrmDevolver;
    private javax.swing.JInternalFrame jfrmListaAlquilados;
    private javax.swing.JInternalFrame jfrmListadoCoche;
    private javax.swing.JInternalFrame jfrmListadoFurgoneta;
    private javax.swing.JInternalFrame jfrmListadoGeneralVehiculo;
    private javax.swing.JInternalFrame jfrmListadoMoto;
    private javax.swing.JInternalFrame jfrmListarUsuarios;
    private javax.swing.JInternalFrame jfrmListarVehiculos;
    private javax.swing.JLabel jlCorreo;
    private javax.swing.JLabel jlcontraseña;
    private javax.swing.JMenuItem mnuAlaquilarVehiculo;
    private javax.swing.JMenu mnuAlquila;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenuItem mnuCerrarSesion;
    private javax.swing.JMenuItem mnuCrearUsuario;
    private javax.swing.JMenuItem mnuCrearVehiculo;
    private javax.swing.JMenuItem mnuListaAlquiler;
    private javax.swing.JMenuItem mnuListadoGeneralVehiculo;
    private javax.swing.JMenuItem mnuListarCoches;
    private javax.swing.JMenuItem mnuListarFurgonetas;
    private javax.swing.JMenuItem mnuListarMotos;
    private javax.swing.JMenuItem mnuListarUsuario;
    private javax.swing.JMenu mnuListarVehiculo;
    private javax.swing.JMenu mnuUsuario;
    private javax.swing.JMenu mnuVehiculo;
    private javax.swing.JRadioButton rbAdministrador;
    private javax.swing.JRadioButton rbCliente;
    private javax.swing.JRadioButton rbUsuario;
    private javax.swing.JRadioButton rdCoche;
    private javax.swing.JRadioButton rdFurgoneta;
    private javax.swing.JRadioButton rdMoto;
    private javax.swing.JSpinner spnCapFurgoneta;
    private javax.swing.JTable tblAlquilados;
    private javax.swing.JTable tblCoche;
    private javax.swing.JTable tblFurgoneta;
    private javax.swing.JTable tblGeneralVehiculos;
    private javax.swing.JTable tblMoto;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTable tblVehiculos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCrearCedula;
    private javax.swing.JTextField txtCrearCorreo;
    private javax.swing.JTextField txtCrearNombre;
    private javax.swing.JPasswordField txtCrearPassword;
    private javax.swing.JTextField txtKm;
    private javax.swing.JTextField txtKmFinal;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables

}
