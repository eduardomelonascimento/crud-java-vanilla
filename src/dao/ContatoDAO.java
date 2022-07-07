package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Factory.ConnectionFactory;
import models.Contato;

public class ContatoDAO {
    // Cria um contato
    public void save(Contato contato) throws SQLException {
        String query = "INSERT INTO CONTATOS(NOME, IDADE, CREATED_AT) VALUES(?, ?, ?)";
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) connection.prepareStatement(query);
            pstm.setString(1, contato.getNome());
            pstm.setInt(2, contato.getIdade());
            pstm.setDate(3, new Date(contato.getCreated_At().getTime()));
            pstm.execute();
            System.out.println("Contato salvo com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Lista os contatos
    public List<Contato> getContatos() throws SQLException {
        String query = "SELECT * FROM CONTATOS";
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<Contato> contatos = new ArrayList<Contato>();
        try {
            connection = ConnectionFactory.createConnectionToMySQL();
            pstm = connection.prepareStatement(query);
            rset = pstm.executeQuery();
            while (rset.next()) {
                Contato contato = new Contato(rset.getString("NOME"), rset.getInt("IDADE"), rset.getDate("CREATED_AT"));
                contato.setId(rset.getInt("ID"));
                contatos.add(contato);
            }
            System.out.println("query realizada");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return contatos;
    }

    // Atualiza um contato
    public void updateContato(Contato contato) {
        String query = "UPDATE CONTATOS SET NOME = ?, IDADE = ? WHERE ID = ?";
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) connection.prepareStatement(query);
            pstm.setString(1, contato.getNome());
            pstm.setInt(2, contato.getIdade());
            pstm.setInt(3, contato.getId());
            pstm.execute();
            System.out.println("Contato atualizdo com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Deleta um contato
    public void deleteContato(Contato contato) {
        String query = "DELETE FROM CONTATOS WHERE (ID = ?)";
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) connection.prepareStatement(query);
            pstm.setInt(1, contato.getIdade());
            pstm.execute();
            System.out.println("Contato " + contato.getNome() + " com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
