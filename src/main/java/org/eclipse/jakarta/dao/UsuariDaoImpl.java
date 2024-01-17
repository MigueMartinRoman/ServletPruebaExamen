package org.eclipse.jakarta.dao;

import org.eclipse.jakarta.config.MysqlConfig;
import org.eclipse.jakarta.model.Escola;
import org.eclipse.jakarta.model.Usuari;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariDaoImpl implements UsuariDao{


    @Override
    public List<Usuari> findAll() {
        try {

            MysqlConfig mysqlConfig = new MysqlConfig();
            /* no ponemos  los parametro en la query sino ponemos '?' */
            String sql = "select * from user";

            PreparedStatement preparedStatement = mysqlConfig.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            //1- Crear object a retornar
            List<Usuari> resultat = new ArrayList<>();

            //2- Recorrem ResultSet i emplenam la llista
            while (resultSet.next()){//patron iterator
                Usuari usuari = new Usuari();
                usuari.setUsername(resultSet.getString("username"));
                usuari.setPassword(resultSet.getString("password"));
                usuari.setId_escola(resultSet.getLong("idescola"));
                usuari.setRol(resultSet.getString("rol"));
                resultat.add(usuari);
            }
            return resultat;
        }catch (Exception e){
            System.out.println("ERROR UserDao : "+e.getMessage());
            return  null;
        }
    }

    @Override
    public Usuari findByUsernamePasswordEscola(String usuari, String password, Long escola) {
        System.out.println("lo que me esta pasando "+usuari+password+escola);
        try {
            MysqlConfig mysqlConfig = new MysqlConfig();
            /* no ponemos  los parametro en la query sino ponemos '?' */
            String sql = "select * from user where username=? and password=? and escola_idescola=?";

            PreparedStatement preparedStatement = mysqlConfig.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,usuari);
            preparedStatement.setString(2,password);
            // como que eso seria una escuela pues escola.getID()
            // preparedStatement.setLong(escola.getID());
            preparedStatement.setString(3, String.valueOf(escola));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){//patron iterator
                Usuari user = new Usuari();
                user.setUsername(resultSet.getString("username"));
                //NO HACE FALTA GUARDAR EL PASSWORD
                user.setPassword(resultSet.getString("password"));
                user.setRol(resultSet.getString("rol"));
                user.setId_escola(resultSet.getLong("escola_idescola"));
                //USUARI.SETESCOLA(ESCOLA);
                System.out.println("el user es "+usuari);
                return user;
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
