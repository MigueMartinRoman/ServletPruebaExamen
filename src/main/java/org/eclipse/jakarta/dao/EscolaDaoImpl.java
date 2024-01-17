package org.eclipse.jakarta.dao;

import org.eclipse.jakarta.config.MysqlConfig;
import org.eclipse.jakarta.model.Escola;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EscolaDaoImpl implements EscolaDao{
    @Override
    public List<Escola> findAll() {
        System.out.println("Entra en el findAll");
        try {
            MysqlConfig mysqlConfig = new MysqlConfig();
            String sql = "select * from escola";

            PreparedStatement preparedStatement = mysqlConfig.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Escola> result = new ArrayList<>();

            while (resultSet.next()){
                Escola escola = new Escola();
                escola.setId(resultSet.getLong("idescola"));
                escola.setNom(resultSet.getString("nom"));

                result.add(escola);
            }
            System.out.println("Ha pasado");
            return result;

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Escola getById(Long id) {
        try {

            MysqlConfig connection = new MysqlConfig();
            /* no ponemos  los parametro en la query sino ponemos '?' */
            String sql = "select * from escola where  idescola=?";

            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            //1- Crear object a retornar
            //List<Escola> resultat = new ArrayList<>();

            //2- Recorrem ResultSet i emplenam la llista
            while (resultSet.next()){//patron iterator
                Escola escola = new Escola();
                escola.setNom(resultSet.getString("nom"));
                escola.setId(resultSet.getLong("idescola"));
                // resultat.add(escola);
                return  escola;
            }

        }catch (Exception e){
            System.out.println("ERROR UserDao : "+e.getMessage());
            return  null;
        }
        return null;
    }
}
