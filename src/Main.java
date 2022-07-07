import dao.ContatoDAO;
import models.Contato;

import java.sql.SQLException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SQLException {
        
        //CREATE
        ContatoDAO dao = new ContatoDAO();
        Contato c1 = new Contato("Eduardo", 31, new Date());
        dao.save(c1);
        
        //READ
        for (Contato c : dao.getContatos()) {
            System.out.println("ID: " + c.getId() + " " + "Nome: " + c.getNome() + " Idade: " + c.getIdade()
                    + " Criado em: " + c.getCreated_At());
        }

        //UPDATE
        c1.setNome("Eduardo Melo");
        c1.setId(dao.getContatos().size());
        dao.updateContato(c1);

        //READ
        for (Contato c : dao.getContatos()) {
            System.out.println("ID: " + c.getId() + " " + "Nome: " + c.getNome() + " Idade: " + c.getIdade()
                    + " Criado em: " + c.getCreated_At());
        }

        //DELETE
        dao.deleteContato(c1);
        
        //SHOW EMPTY TABLE
        for (Contato c : dao.getContatos()) {
            System.out.println("ID: " + c.getId() + " " + "Nome: " + c.getNome() + " Idade: " + c.getIdade()
                    + " Criado em: " + c.getCreated_At());
        }
    }
}