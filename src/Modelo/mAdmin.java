package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class mAdmin {
    
    private final Conexion miConexion = new Conexion();
    
    public DefaultTableModel avionConsulta(String[] condicion) {
        DefaultTableModel model = new DefaultTableModel();
        Connection connection = null;
        String condicionFinal = "";
        try {
            connection = miConexion.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = null;
            //Si el arreglo está vacío//
            if(condicion[0].equals("") && condicion[1].equals("") && condicion[2].equals("")){
                rS = st.executeQuery(
                        "SELECT a.`idAvion`, a.`NombreAvion`, a.`Capacidad`, a.`Estatus`\n" +
                        "FROM avion AS a;");
            }
            //Si al menos una posición del arreglo tiene algo//
            else{
                if(!condicion[0].equals("") && !condicion[1].equals("") && !condicion[2].equals("")){
                    condicionFinal = "a.`idAvion`="+condicion[0]+" && a.`NombreAvion` LIKE '%"+condicion[1]+"%' && a.`Estatus`="+condicion[2]+"";
                }
                else if(!condicion[0].equals("") && !condicion[1].equals("")){
                    condicionFinal = "a.`idAvion`="+condicion[0]+" && a.`NombreAvion` LIKE '%"+condicion[1]+"%'";
                }
                else if(!condicion[0].equals("") && !condicion[2].equals("")){
                    condicionFinal = "a.`idAvion`="+condicion[0]+" && a.`Estatus`="+condicion[2]+"";
                }
                else if(!condicion[1].equals("") && !condicion[2].equals("")){
                    condicionFinal = "a.`NombreAvion` LIKE '%"+condicion[1]+"%' && a.`Estatus`="+condicion[2]+"";
                }
                else if(!condicion[0].equals("")){
                    condicionFinal = "a.`idAvion`="+condicion[0]+"";
                }
                else if(!condicion[1].equals("")){
                    condicionFinal = "a.`NombreAvion` LIKE '%"+condicion[1]+"%'";
                }
                else if(!condicion[2].equals("")){
                    condicionFinal = "a.`Estatus`="+condicion[2]+"";
                }
                rS = st.executeQuery(
                        "SELECT a.`idAvion`, a.`NombreAvion`, a.`Capacidad`, a.`Estatus`\n" +
                        "FROM avion a\n" +
                        "WHERE "+condicionFinal+";");
            }
            
            ResultSetMetaData rSMd = rS.getMetaData();
            
            model.addColumn("Número");
            model.addColumn("Nombre");
            model.addColumn("Capacidad");
            model.addColumn("Estatus");
            
            while(rS.next()) {
                Object[] x = new Object[rSMd.getColumnCount()];
                for(int i=0; i<rSMd.getColumnCount(); i++) {
                    x[i] = rS.getObject(i + 1);
                }
                model.addRow(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            miConexion.cerrarConexion(connection);
        }
        return model;
    }
    
    public boolean avionAgregar(String Nombre, int Capacidad, int Estatus)
    {   
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Para ejecutar la consulta ---//
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "INSERT INTO avion (NombreAvion, Capacidad, Estatus) values('"+Nombre+"', "+Capacidad+", "+Estatus+");");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            System.out.println("No agregado");
            return false;
        }
    }
    
    public boolean editarAvion(int idAvion, String Nombre, int Capacidad, int Estatus){
        System.out.println(idAvion);
        System.out.println(Nombre);
        System.out.println(Capacidad);
        System.out.println(Estatus);
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Para ejecutar la consulta ---//
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
                "UPDATE avion a SET a.`NombreAvion`='"+Nombre+"', a.`Capacidad`="+Capacidad+", a.`Estatus`="+Estatus+"\n" +
                "WHERE a.`idAvion`="+idAvion+";");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean eliminarAvion(int idAvion)
    {
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Para ejecutar la consulta ---//
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "delete from avion where idAvion = "+idAvion+";");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public String[] avionConsultaEspecifica(int idBuscar){
        String[] datos = new String[4];
        String idAvion = "", NombreAvion = "", Capacidad = "", Estatus = "";
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            ResultSet resultado = s.executeQuery(
                    "SELECT a.`idAvion`, a.`NombreAvion`, a.`Capacidad`, a.`Estatus`\n" +
                    "FROM avion a\n" +
                    "WHERE a.`idAvion`="+idBuscar+";");
            
            resultado.next();
            
            idAvion = resultado.getString("idAvion");
            NombreAvion = resultado.getString("NombreAvion");
            Capacidad = resultado.getString("Capacidad");
            Estatus = resultado.getString("Estatus");
            
            datos[0] = idAvion;
            datos[1] = NombreAvion;
            datos[2] = Capacidad;
            datos[3] = Estatus;
            
            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
    public DefaultTableModel usuariosConsulta(String[] condicion) {
        DefaultTableModel model = new DefaultTableModel();
        Connection connection = null;
        String condicionFinal = "";
        try {
            connection = miConexion.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = null;
            if(condicion[0].equals("") && condicion[1].equals("") && condicion[2].equals("")){
                rS = st.executeQuery(
                        "SELECT idCliente, NombreCli, CiudadCli, NacionalidadCli, Tipo "
                        + "FROM cliente "
                        + "WHERE Tipo > 0 "
                        + "ORDER BY idCliente;");
            }
            else{
                if(!condicion[0].equals("") && !condicion[1].equals("") && !condicion[2].equals("")){
                    condicionFinal = "`NombreCli` LIKE '%"+condicion[0]+"%' && `NacionalidadCli` LIKE '%"+condicion[1]+"%' && `Tipo` = "+Integer.parseInt(condicion[2])+"";
                }
                else if(!condicion[0].equals("") && !condicion[1].equals("")){
                    condicionFinal = "`NombreCli` LIKE '%"+condicion[0]+"%' && `NacionalidadCli` LIKE '%"+condicion[1]+"%'";
                }
                else if(!condicion[0].equals("") && !condicion[2].equals("")){
                    condicionFinal = "`NombreCli` LIKE '%"+condicion[0]+"%' && `Tipo` = "+Integer.parseInt(condicion[2])+"";
                }
                else if(!condicion[1].equals("") && !condicion[2].equals("")){
                    condicionFinal = "`NacionalidadCli` LIKE '%"+condicion[1]+"%' && `Tipo` = "+Integer.parseInt(condicion[2])+"";
                }
                else if(!condicion[0].equals("")){
                    condicionFinal = "`NombreCli` LIKE '%"+condicion[0]+"%'";
                }
                else if(!condicion[1].equals("")){
                    condicionFinal = "`NacionalidadCli` LIKE '%"+condicion[1]+"%'";
                }
                else if(!condicion[2].equals("")){
                    condicionFinal = "`Tipo` = "+Integer.parseInt(condicion[2])+"";
                }
                rS = st.executeQuery("SELECT idCliente, NombreCli, CiudadCli, NacionalidadCli, Tipo "
                    + "FROM cliente "
                    + "WHERE Tipo > 0 AND "+condicionFinal+" "
                    + "ORDER BY idCliente;");
            }
            
            ResultSetMetaData rSMd = rS.getMetaData();
            
            model.addColumn("Código");
            model.addColumn("Nombre");
            model.addColumn("Ciudad");
            model.addColumn("Nacionalidad");
            model.addColumn("Tipo");
            
            while(rS.next()) {
                Object[] x = new Object[rSMd.getColumnCount()];
                for(int i=0; i<rSMd.getColumnCount(); i++) {
                    x[i] = rS.getObject(i + 1);
                }
                if(x[4].toString().equals("1"))
                    x[4] = "Admin";
                else if(x[4].toString().equals("2"))
                    x[4] = "Trabajador";
                else
                    x[4] = "Cliente";
                model.addRow(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            miConexion.cerrarConexion(connection);
        }
        return model;
    }
    
    public boolean usuarioAgregar(String NombreCli, String NacionalidadCli, String CiudadCli, String FechaNac, String Usuario, String Contra, int Tipo)
    {
        LocalDate fechaNac, ahora;
        Period periodo = null;
        try {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
            fechaNac = LocalDate.parse(FechaNac, fmt);
            ahora = LocalDate.now();

            periodo = Period.between(fechaNac, ahora);
            
        } catch (DateTimeParseException e) {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
            fechaNac = LocalDate.parse(FechaNac, fmt);
            ahora = LocalDate.now();

            periodo = Period.between(fechaNac, ahora);
        }
        
        int edad = periodo.getYears();
        
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Para ejecutar la consulta ---//
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "INSERT INTO cliente (NombreCli, NacionalidadCli, CiudadCli, FechaNac, Edad, Usuario, Contra, Tipo) "
                    + "values('"+NombreCli+"', '"+NacionalidadCli+"', '"+CiudadCli+"', '"+fechaNac+"', "+edad+", '"+Usuario+"', '"+Contra+"', "+Tipo+");");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            System.out.println("No agregado");
            return false;
        }
    }
    
    public boolean editarUsuario(int idCliente, String NombreCli, String NacionalidadCli, String CiudadCli, String FechaNac, String Usuario, String Contra, int Tipo){
        LocalDate fechaNac, ahora;
        Period periodo = null;
        try {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
            fechaNac = LocalDate.parse(FechaNac, fmt);
            ahora = LocalDate.now();

            periodo = Period.between(fechaNac, ahora);
            
        } catch (DateTimeParseException e) {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
            fechaNac = LocalDate.parse(FechaNac, fmt);
            ahora = LocalDate.now();

            periodo = Period.between(fechaNac, ahora);
        }
        
        int edad = periodo.getYears();
        
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Para ejecutar la consulta ---//
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "update cliente set NombreCli = '"+NombreCli+"', NacionalidadCli = '"+NacionalidadCli+"', CiudadCli = '"+CiudadCli+"', FechaNac = '"+fechaNac+"', Edad = "+edad+", Usuario = '"+Usuario+"', Contra = '"+Contra+"', Tipo = "+Tipo
                    + " where idCliente = "+idCliente+";");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            System.out.println("No agregado");
            return false;
        }
    }
    
    public boolean eliminarUsuario(int idCliente)
    {
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "delete from cliente where idCliente = "+idCliente+";");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    public String[] consultaUsuarioEspecifico(int idBuscar){
        String[] datos = new String[9];
        String idCliente = "", NombreCli = "", NacionalidadCli = "", CiudadCli = "", FechaNac = "", Edad = "", Usuario = "", Contra = "", Tipo = "";
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            ResultSet resultado = s.executeQuery("SELECT * FROM cliente WHERE idCliente = "+idBuscar+";");
            
            resultado.next();
            
            idCliente = resultado.getString("idCliente");
            NombreCli = resultado.getString("NombreCli");
            NacionalidadCli = resultado.getString("NacionalidadCli");
            CiudadCli = resultado.getString("CiudadCli");
            FechaNac = resultado.getString("FechaNac");
            Edad = resultado.getString("Edad");
            Usuario = resultado.getString("Usuario");
            Contra = resultado.getString("Contra");
            Tipo = resultado.getString("Tipo");
            
            datos[0] = idCliente;
            datos[1] = NombreCli;
            datos[2] = NacionalidadCli;
            datos[3] = CiudadCli;
            datos[4] = FechaNac;
            datos[5] = Edad;
            datos[6] = Usuario;
            datos[7] = Contra;
            datos[8] = Tipo;
            
            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
    public DefaultTableModel VentasConsulta(String[] condicion) {
        DefaultTableModel model = new DefaultTableModel();
        Connection connection = null;
        String condicionFinal = "";
        try {
            connection = miConexion.abrirConexion();
            Statement st = connection.createStatement();//ID, Nombre, Pago
            ResultSet rS = null;
            if(condicion[0].equals("") && condicion[1].equals("") && condicion[2].equals("")){
                rS = st.executeQuery("SELECT v.`idVenta`, c.`NombreCli`, v.`FechaVenta`, v.`MetodoPago`, v.`Total` "
                    + "FROM ventas v "
                    + "INNER JOIN cliente c ON v.`idCliente` = c.`idCliente` ");
            }
            else{
                if(!condicion[0].equals("") && !condicion[1].equals("") && !condicion[2].equals("")){
                    condicionFinal = "v.`idVenta` = "+condicion[0]+" && c.`NombreCli` LIKE '%"+condicion[1]+"%' && v.`MetodoPago` = '"+condicion[2]+"'";
                }
                else if(!condicion[0].equals("") && !condicion[1].equals("")){
                    condicionFinal = "v.`idVenta` = "+condicion[0]+" && c.`NombreCli` LIKE '%"+condicion[1]+"%'";
                }
                else if(!condicion[0].equals("") && !condicion[2].equals("")){
                    condicionFinal = "v.`idVenta` = "+condicion[0]+" && v.`MetodoPago` = '"+condicion[2]+"'";
                }
                else if(!condicion[1].equals("") && !condicion[2].equals("")){
                    condicionFinal = "c.`NombreCli` LIKE '%"+condicion[1]+"%' && v.`MetodoPago` = '"+condicion[2]+"'";
                }
                else if(!condicion[0].equals("")){
                    condicionFinal = "v.`idVenta` = "+condicion[0]+"";
                }
                else if(!condicion[1].equals("")){
                    condicionFinal = "c.`NombreCli` LIKE '%"+condicion[1]+"%'";
                }
                else if(!condicion[2].equals("")){
                    condicionFinal = "v.`MetodoPago` = '"+condicion[2]+"'";
                }
                rS = st.executeQuery("SELECT v.`idVenta`, c.`NombreCli`, v.`FechaVenta`, v.`MetodoPago`, v.`Total` "
                    + "FROM ventas v "
                    + "INNER JOIN cliente c ON v.`idCliente` = c.`idCliente` "
                    + "WHERE "+condicionFinal+";");
            }
            
            ResultSetMetaData rSMd = rS.getMetaData();
            
            model.addColumn("Código");
            model.addColumn("Nombre");
            model.addColumn("Fecha");
            model.addColumn("Pago");
            model.addColumn("$MXN$");
            
            while(rS.next()) {
                Object[] x = new Object[rSMd.getColumnCount()];
                for(int i=0; i<rSMd.getColumnCount(); i++) {
                    x[i] = rS.getObject(i + 1);
                }
                model.addRow(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            miConexion.cerrarConexion(connection);
        }
        return model;
    }
    
    public String[] bestVentas() {
        String[] ventas = new String[6];
        Connection connection = null;
        try {
            connection = miConexion.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet resultado = st.executeQuery("SELECT vu.`CiuDestino`, COUNT(CONCAT(vu.`CiuOrigen`,' - ', vu.`CiuDestino`)) AS cantidad "
                    + "FROM ventas v "
                    + "INNER JOIN boleto b ON v.`idVenta` = b.`idVenta` "
                    + "INNER JOIN vuelo vu ON vu.`idVuelo` = b.`idVuelo` "
                    + "WHERE vu.`CiuOrigen` LIKE '%Mazatlan%' "
                    + "GROUP BY vu.`CiuDestino` "
                    + "ORDER BY cantidad DESC, vu.`CiuDestino` ASC "
                    + "LIMIT 3;");
            
            if(resultado.next()){
                ventas[0] = resultado.getString("CiuDestino");
                ventas[1] = resultado.getString("cantidad");
                if(resultado.next()){
                    ventas[2] = resultado.getString("CiuDestino");
                    ventas[3] = resultado.getString("cantidad");
                    if(resultado.next()){
                        ventas[4] = resultado.getString("CiuDestino");
                        ventas[5] = resultado.getString("cantidad");
                    }
                    else{
                        for (int i = 4; i < 6; i++) 
                            ventas[i] = "";
                    }
                }
                else{
                    for (int i = 2; i < 6; i++) 
                        ventas[i] = "";
                }
            }
            else{
                for (int i = 0; i < 6; i++) 
                    ventas[i] = "";
            }
            
            return ventas;
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            miConexion.cerrarConexion(connection);
        }
        return ventas;
    }
    
    public DefaultTableModel vuelosConsulta(String[] condicion) {
        DefaultTableModel model = new DefaultTableModel();
        Connection connection = null;
        String condicionFinal = "";
        try {
            connection = miConexion.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = null;
            if(condicion[0].equals("") && condicion[1].equals("")){
                rS = st.executeQuery("SELECT v.`idVuelo`, CONCAT(v.`CiuOrigen`, ' - ', v.`CiuDestino`), v.`Fecha`, v.`HoraSalida` "
                    + "FROM vuelo v;");
            }
            else {
                if(!condicion[0].equals("") && !condicion[1].equals("")){
                    condicionFinal = "v.`idVuelo` = "+condicion[0]+" && (v.`CiuOrigen` LIKE '%"+condicion[1]+"%' || v.`CiuDestino` LIKE '%"+condicion[1]+"%')";
                }
                else if(!condicion[0].equals("")){
                    condicionFinal = "v.`idVuelo` = "+condicion[0]+"";
                }
                else if(!condicion[1].equals("")){
                    condicionFinal = "(v.`CiuOrigen` LIKE '%"+condicion[1]+"%' || v.`CiuDestino` LIKE '%"+condicion[1]+"%')";
                }
                rS = st.executeQuery("SELECT v.`idVuelo`, CONCAT(v.`CiuOrigen`, ' - ', v.`CiuDestino`), v.`Fecha`, v.`HoraSalida` "
                    + "FROM vuelo v "
                    + "WHERE "+condicionFinal+";");
            }

            
            ResultSetMetaData rSMd = rS.getMetaData();
            
            model.addColumn("Número");
            model.addColumn("Vuelo");
            model.addColumn("Fecha");
            model.addColumn("Hora de salida");
            
            while(rS.next()) {
                Object[] x = new Object[rSMd.getColumnCount()];
                for(int i=0; i<rSMd.getColumnCount(); i++) {
                    x[i] = rS.getObject(i + 1);
                }
                model.addRow(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            miConexion.cerrarConexion(connection);
        }
        return model;
    }
    
    public DefaultTableModel avionConsulta() {
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            try {
                ResultSet resultado = s.executeQuery("SELECT idAvion FROM avion ORDER BY idAvion ASC;");
                modelo = new DefaultTableModel();
                ResultSetMetaData resultadoMd = resultado.getMetaData();
                int cantidadColumnas = resultadoMd.getColumnCount();
                
                modelo.addColumn("Avión");
                
                while (resultado.next()) {                    
                    Object[] fila = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i] = resultado.getObject(i+1);
                    }
                    modelo.addRow(fila);
                }
                return modelo;
            } finally {
                miConexion.cerrarConexion(con);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public DefaultTableModel datosAvionConsulta(int idAvion) {
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            try {
                ResultSet resultado = s.executeQuery("SELECT NombreAvion, Capacidad FROM avion WHERE idAvion = "+idAvion+";");
                modelo = new DefaultTableModel();
                ResultSetMetaData resultadoMd = resultado.getMetaData();
                int cantidadColumnas = resultadoMd.getColumnCount();
                
                modelo.addColumn("Nombre");
                modelo.addColumn("Capacidad");
                
                while (resultado.next()) {                    
                    Object[] fila = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i] = resultado.getObject(i+1);
                    }
                    modelo.addRow(fila);
                }
                return modelo;
            } finally {
                miConexion.cerrarConexion(con);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public DefaultTableModel tripulacionConsulta() {
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            try {
                ResultSet resultado = s.executeQuery("SELECT DISTINCT numTripulacion FROM tripulacion WHERE numTripulacion > 0");
                modelo = new DefaultTableModel();
                ResultSetMetaData resultadoMd = resultado.getMetaData();
                int cantidadColumnas = resultadoMd.getColumnCount();
                
                modelo.addColumn("Tripulación");
                
                while (resultado.next()) {                    
                    Object[] fila = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i] = resultado.getObject(i+1);
                    }
                    modelo.addRow(fila);
                }
                return modelo;
            } finally {
                miConexion.cerrarConexion(con);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public DefaultTableModel datosTripulacionConsulta(int numTripulacion) {
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            try {
                ResultSet resultado = s.executeQuery("SELECT Puesto, Nombre FROM tripulacion  WHERE numTripulacion="+numTripulacion+" ORDER BY Puesto DESC;");
                modelo = new DefaultTableModel();
                ResultSetMetaData resultadoMd = resultado.getMetaData();
                int cantidadColumnas = resultadoMd.getColumnCount();
                
                modelo.addColumn("Puesto");
                modelo.addColumn("Nombre");
                
                while (resultado.next()) {                    
                    Object[] fila = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i] = resultado.getObject(i+1);
                    }
                    modelo.addRow(fila);
                }
                return modelo;
            } finally {
                miConexion.cerrarConexion(con);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean vueloAgregar(String CiuOrigen, String CiuDestino, String Escala, int idTripulacion, String Fecha, String HoraSalida, String HoraLlegada, double precio)
    {
        int idEscalas;
        //===No se agregaron escalas===//
        if(Escala.equals("0") || Escala.equals("")){
            idEscalas = 0;
        }
        //===Sí se agregaron escalas===//
        else{
            agregarEscala(Escala);
            idEscalas = ultimaEscala();
        }
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "INSERT INTO vuelo (CiuOrigen, CiuDestino, idEscalas, idTripulacion, Fecha, HoraSalida, HoraLlegada, Precio) values('"+CiuOrigen+"', '"+CiuDestino+"', "+idEscalas+", "+idTripulacion+", '"+Fecha+"', '"+HoraSalida+"', '"+HoraLlegada+"', " + precio + ");");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    //===Para agregar la escala a la BD===//
    public void agregarEscala(String nombreEscala){
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "INSERT INTO escalas (Ciudad) values('"+nombreEscala+"');");
            miConexion.cerrarConexion(con);
        } catch (SQLException ex) {
            System.out.println("Escala no agregada");
        }
    }
    //===Para elegir la última escala agregada===//
    public int ultimaEscala(){
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            ResultSet resultado = s.executeQuery("SELECT * FROM escalas ORDER BY idEscalas DESC LIMIT 1;");
            
            while (resultado.next()) {                    
                Object fila = new Object();
                int id = 0;
                id = resultado.getInt(1);//Selecciona el número de la columna en la BD
                return id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    //===Para elegir el vuelo que se va a editar===//
    public String[] consultaVueloEspecifico(int idBuscar){
        System.out.println("Entra");
        String[] datos = new String[10];
        String idVuelo = "", CiuOrigen = "", CiuDestino = "", idEscalas = "", idTripulacion = "", 
                Fecha = "", HoraSalida = "", HoraLlegada = "", nomEscala = "", precio = "";
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            ResultSet resultado = s.executeQuery("SELECT * FROM vuelo WHERE idVuelo = "+idBuscar+";");
            
            resultado.next();
            
            idVuelo = resultado.getString("idVuelo");
            CiuOrigen = resultado.getString("CiuOrigen");
            CiuDestino = resultado.getString("CiuDestino");
            idEscalas = resultado.getString("idEscalas");
            if(resultado.getString("idTripulacion")!=null) 
                idTripulacion = resultado.getString("idTripulacion");
            else 
                idTripulacion = "Not found";
            
            Fecha = resultado.getString("Fecha");
            HoraSalida = resultado.getString("HoraSalida");
            HoraLlegada = resultado.getString("HoraLlegada");
            precio = resultado.getString("precio");
            if(!idEscalas.equals("0")){
                nomEscala = consultaEscalaEspecifico(Integer.parseInt(idEscalas));
            }
            
            datos[0] = idVuelo;
            datos[1] = CiuOrigen;
            datos[2] = CiuDestino;
            datos[3] = idEscalas;
            datos[4] = idTripulacion;
            datos[5] = Fecha;
            datos[6] = HoraSalida;
            datos[7] = HoraLlegada;
            datos[8] = nomEscala;
            datos[9] = precio;
            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    //===Para elegir la escala del vuelo que se va a editar===//
    public String consultaEscalaEspecifico(int idEscalas){
        String dato = "";
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            ResultSet resultado = s.executeQuery("SELECT * FROM escalas WHERE idEscalas = "+idEscalas+";");
            
            if(resultado.next())
                dato = resultado.getString("Ciudad");
            else
                dato = "Not Found";
            
            return dato;
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dato;
    }
    
    //===Para editar un vuelo específico===//
    public boolean vueloEditar(int tipoEditar, int idVuelo, int idEscalas, String CiuOrigen, String CiuDestino, String Escala, int idTripulacion, String Fecha, String HoraSalida, String HoraLlegada)
    {
        //===No tenía escala originalmente===//
        if(tipoEditar == 0){
            //===No tenía escala, y sigue sin tener escala===//
            if(Escala.equals("0")){
               idEscalas = 0; 
            }
            //===No tenía escala, pero ahora ya tiene===//
            else{
                agregarEscala(Escala);
                idEscalas = ultimaEscala();
            }
        }
        //===Sí tenía escala originalmente===//
        else if(tipoEditar ==1){
            //===Sí tenía escala, pero ahora ya no tiene===//
            if(Escala.equals("0")){
                escalaEliminar(idEscalas);
                idEscalas = 0;
            }
            //===Sí tenía escala, y sigue teniendo===//
            else{
                editarEscala(Escala, idEscalas);
            }
        }
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "update vuelo set CiuOrigen = '"+CiuOrigen+"', CiuDestino = '"+CiuDestino+"', idEscalas = '"+idEscalas+"', idTripulacion = '"+idTripulacion+"', Fecha = '"+Fecha+"', HoraSalida = '"+HoraSalida+"', HoraLlegada = '"+HoraLlegada+"'"
                    + "where idVuelo = "+idVuelo+";");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    //===Para editar la escala de un vuelo específico===//
    public void editarEscala(String nombreEscala, int idEscalas){
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "update escalas set Ciudad = '"+nombreEscala+"'"
                    + "where idEscalas = "+idEscalas+";");
            miConexion.cerrarConexion(con);
        } catch (SQLException ex) {
        }
    }
    
    public boolean vueloEliminar(int tipoEliminar, int idVuelo, int idEscalas)
    {
        //===Sí tenía escala===//
        if(tipoEliminar == 1)
                escalaEliminar(idEscalas);
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "delete from vuelo where idVuelo = "+idVuelo+";");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    //===Para eliminar la escala de un vuelo específico===//
    public void escalaEliminar(int idEscala)
    {
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "delete from escalas where idEscalas = "+idEscala+";");
            miConexion.cerrarConexion(con);
        } catch (SQLException ex) {
        }
    }
    
    public DefaultTableModel tripulacionConsulta(String[] condicion) {
        DefaultTableModel model = new DefaultTableModel();
        Connection connection = null;
        String condicionFinal = "";
        try {
            connection = miConexion.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = null;
            if(condicion[0].equals("") && condicion[1].equals("") && condicion[2].equals("")){
                rS = st.executeQuery("SELECT * "
                    + "FROM tripulacion t;");
            }
            else{
                if(!condicion[0].equals("") && !condicion[1].equals("") && !condicion[2].equals("")){
                    condicionFinal = "t.`idTripulacion` = "+condicion[1]+" && t.`Nombre` LIKE '%"+condicion[1]+"%' && t.`Puesto` LIKE '%"+condicion[2]+"%'";
                }
                else if(!condicion[0].equals("") && !condicion[1].equals("")){
                    condicionFinal = "t.`idTripulacion` = "+condicion[0]+" && t.`Nombre` LIKE '%"+condicion[1]+"%'";
                }
                else if(!condicion[0].equals("") && !condicion[2].equals("")){
                    condicionFinal = "t.`idTripulacion` = "+condicion[0]+" && t.`Puesto` LIKE '%"+condicion[2]+"%'";
                }
                else if(!condicion[1].equals("") && !condicion[2].equals("")){
                    condicionFinal = "t.`Nombre` LIKE '%"+condicion[1]+"%' && t.`Puesto` LIKE '%"+condicion[2]+"%'";
                }
                else if(!condicion[0].equals("")){
                    condicionFinal = "t.`idTripulacion` = "+condicion[0]+"";
                }
                else if(!condicion[1].equals("")){
                    condicionFinal = "t.`Nombre` LIKE '%"+condicion[1]+"%'";
                }
                else if(!condicion[2].equals("")){
                    condicionFinal = "t.`Puesto` LIKE '%"+condicion[2]+"%'";
                }
                rS = st.executeQuery("SELECT * "
                    + "FROM tripulacion t "
                    + "WHERE "+condicionFinal+";");
            }
            
            ResultSetMetaData rSMd = rS.getMetaData();
            
            model.addColumn("Código");
            model.addColumn("Nombre");
            model.addColumn("Puesto");
            model.addColumn("No. vuelo");
            model.addColumn("No. tripulación");
            
            while(rS.next()) {
                Object[] x = new Object[rSMd.getColumnCount()];
                for(int i=0; i<rSMd.getColumnCount(); i++) {
                    x[i] = rS.getObject(i + 1);
                }
                model.addRow(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            miConexion.cerrarConexion(connection);
        }
        return model;
    }
    
    public boolean tripulacionAgregar(String Nombre, String Puesto, int numTripulacion)
    {   
        int idVuelo = consultaVueloTripulacion(numTripulacion);
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "INSERT INTO tripulacion (Nombre, Puesto, idVuelo, numTripulacion) values('"+Nombre+"', '"+Puesto+"', "+idVuelo+", "+numTripulacion+");");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            System.out.println("No agregado");
            return false;
        }
    }
    
    public int consultaVueloTripulacion(int idBuscar){
        int idVuelo = 0;
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            ResultSet resultado = s.executeQuery("SELECT * FROM tripulacion WHERE numTripulacion = "+idBuscar+" && idVuelo > 0;");
            
            if(resultado.next())
                idVuelo = resultado.getInt("idVuelo");
            else
                idVuelo = 0;
            
            return idVuelo;
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idVuelo;
    }
    
    public String[] consultaTripulacionEspecifico(int idBuscar){
        String[] datos = new String[5];
        String idTripulacion = "", Nombre = "", Puesto = "", idVuelo = "", numTripulacion = "";
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            ResultSet resultado = s.executeQuery("SELECT * FROM tripulacion WHERE idTripulacion = "+idBuscar+";");
            
            resultado.next();
            
            idTripulacion = resultado.getString("idTripulacion");
            Nombre = resultado.getString("Nombre");
            Puesto = resultado.getString("Puesto");
            idVuelo = resultado.getString("idVuelo");
            numTripulacion = resultado.getString("numTripulacion");
            
            datos[0] = idTripulacion;
            datos[1] = Nombre;
            datos[2] = Puesto;
            datos[3] = idVuelo;
            datos[4] = numTripulacion;
            
            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    //===Para editar miembro de tripulación específico===//
    public boolean editarTripulacion(int idTripulacion, String Nombre, String Puesto, int numTripulacion){
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "update tripulacion set Nombre = '"+Nombre+"', Puesto = '"+Puesto+"', numTripulacion = '"+numTripulacion+"'"
                    + "where idTripulacion = "+idTripulacion+";");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean tripulacionEliminar(int idTripulacion)
    {
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "delete from tripulacion where idTripulacion = "+idTripulacion+";");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
}
