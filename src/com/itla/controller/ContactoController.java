package com.itla.controller;

import com.itla.dao.ContactoDAO;
import com.itla.dao.MySQL.MySQLContactoDAO;
import com.itla.db.DBManager;
import com.itla.modelo.Contacto;
import com.itla.vista.ContactoVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ContactoController {

    private ContactoVista vista;
    private ContactoDAO contactoDAO;
    private DBManager dbManager;
    
    
    
    public ContactoController(ContactoVista vista) {
        this.vista = vista;
        
        //DbManager
        dbManager = new DBManager();
        dbManager.conectarDB();
        
        //Obtener la conexion
        Connection conn = dbManager.getConnection();
        
        contactoDAO = new MySQLContactoDAO(conn);
        
        // Añadir listeners a los botones usando los métodos de la vista
        this.vista.addSearchIdListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarContactoPorId();
            }
        });

        this.vista.addAddContactListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarContacto();
            }
        });
        
        this.vista.addListarTodosListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarTablaContactos();
            }
        });

        
    }
    
    private void limpiarCampos(){
    // Limpiar los campos
        vista.setTxtName1("");
        vista.setTxtLastName("");
        vista.setTxtEmail("");
        vista.setTxtTel("");
        vista.setJTextCompany("");
        vista.setTxtSearchId("");
        
    }

    private void buscarContactoPorId() {
        String idText = vista.getTxtSearchId();
        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor, ingrese un ID.", "Error!" ,JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            long id = Long.parseLong(idText);
            Contacto contacto = contactoDAO.Obtener(id);
            if (contacto != null) {
                vista.setTxtName1(contacto.getNombre());
                vista.setTxtLastName(contacto.getApellidos());
                vista.setTxtEmail(contacto.getCorreo());
                vista.setTxtTel(contacto.getTelefono());
                vista.setJTextCompany(contacto.getEmpresa());
                
                actualizarTablaContactoPorId(contacto);
            } else {
                JOptionPane.showMessageDialog(vista, "No se encontró un contacto con el ID especificado.", "Error!" ,JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "El ID debe ser un número.","Error!" ,JOptionPane.ERROR_MESSAGE);
        }
        
      
    }

    private void agregarContacto() {
        String nombre = vista.getTxtName1();
        String apellidos = vista.getTxtLastName();
        String correo = vista.getTxtEmail();
        String telefono = vista.getTxtTel();
        String empresa = vista.getJTextCompany();

        if (nombre.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || telefono.isEmpty() || empresa.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Todos los campos deben ser completados.","Error!" ,JOptionPane.ERROR_MESSAGE);
            return;
        }

        Contacto nuevoContacto = new Contacto(nombre, apellidos, empresa, telefono, correo);
        contactoDAO.Insertar(nuevoContacto);
        JOptionPane.showMessageDialog(vista, "Contacto agregado exitosamente.");

        limpiarCampos();

        // Actualizar la tabla
        actualizarTablaContactos();
    }

    private void actualizarTablaContactos() {
        DefaultTableModel model = vista.getTableModel();
        model.setRowCount(0);

        for (Contacto contacto : contactoDAO.ObtenerTodosContactos()) {
            model.addRow(new Object[]{
                contacto.getIdContacto(),
                contacto.getNombre(),
                contacto.getApellidos(),
                contacto.getCorreo(),
                contacto.getTelefono(),
                contacto.getEmpresa()
            });
        }
        
        limpiarCampos();
    }
    
    private void actualizarTablaContactoPorId(Contacto contacto){
        DefaultTableModel model = vista.getTableModel();
        model.setRowCount(0);
        
        //Llenar la tabla
        if(contacto != null){
            model.addRow(new Object[]{
                contacto.getIdContacto(),
                contacto.getNombre(),
                contacto.getApellidos(),
                contacto.getCorreo(),
                contacto.getTelefono(),
                contacto.getEmpresa()
            });
        }
        
    }
}

