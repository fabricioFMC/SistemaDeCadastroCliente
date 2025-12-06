/*
    Atividade 01:

    Projetista: Fabricio Ramos Malvar Cabral CPF 025.885.415-42
    
    Objetivo:
    1. Criação da conexão e desconexão do software com o banco de dados.
    2. Criação de instruções Inclusão, Consulta, Atualização, Exclusão 
    
    Versão: 1.1     Data: 05/12/2025
*/

package classes;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class CadastroDAO 
{
    
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    
    public String       url =       "jdbc:mysql://localhost:3306/cadastro"; //Nome da base de dados
    public String       user =      "root";                                 //nome do usuário do MySQL
    public String       password =  "1234";                                 //senha do MySQL

    public boolean conectar()
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            return true;
        } 
        catch (ClassNotFoundException | SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,"Erro ao conectar: " + ex.getMessage());
            //System.out.println("Erro ao conectar: " + ex.getMessage());
            return false;
        }
    }

    public int salvar(Cadastro cadastro)
    {   
        int status;
        try 
        {
            st = conn.prepareStatement("INSERT INTO cadastro (cpf, nome, sobrenome, telefone, endereco) VALUES (?, ?, ?, ?, ?)");
            st.setString(1, cadastro.getCpf());
            st.setString(2, cadastro.getNome());
            st.setString(3, cadastro.getSobrenome());
            st.setString(4, cadastro.getTelefone());
            st.setString(5, cadastro.getEndereco());
        
            status = st.executeUpdate();
            return status; //retornar 1
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,"Erro ao conectar: " + ex.getMessage());
            //System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }

    public Cadastro consultarId (int id)
    {
        try 
        {
            Cadastro cadastro = new Cadastro();
            st = conn.prepareStatement("SELECT * from cadastro WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            //verificar se a consulta encontrou o funcionário com a matrícula informada
            
            if(rs.next())
            { // se encontrou o funcionário, vamos carregar os dados
                
                cadastro.setId(rs.getInt("id"));
                cadastro.setCpf(rs.getString("cpf"));
                cadastro.setNome(rs.getString("nome"));
                cadastro.setSobrenome(rs.getString("sobrenome"));
                cadastro.setTelefone(rs.getString("telefone"));
                cadastro.setTelefone(rs.getString("telefone"));
                
                return cadastro;
            }
            else
            {
                return null;
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,"Erro ao conectar: " + ex.getMessage());
            //System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }
    }
    
    public boolean excluir(int id)
    {
        try 
        {
            st = conn.prepareStatement("DELETE FROM cadastro WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        } 
        catch (SQLException ex) 
        {
            return false;
        }
    }

    public int atualizar(Cadastro cadastro)
    {
        int status;
        try 
        {
            st = conn.prepareStatement("UPDATE cadastro SET cpf = ?, nome = ?, sobrenome = ?, telefone = ?, endereco = ? where id = ?");
            
            st.setString(1, cadastro.getCpf());
            st.setString(2, cadastro.getNome());
            st.setString(3, cadastro.getSobrenome());
            st.setString(4, cadastro.getTelefone());
            st.setString(5, cadastro.getEndereco());
            st.setInt(6, cadastro.getId());
            
            status = st.executeUpdate();
            return status; //retornar 1
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar: " + ex.getErrorCode());
            //System.out.println(ex.getErrorCode());
            return ex.getErrorCode();
        }
    }
    
    public void desconectar()
    {
        try 
        {
            conn.close();
        } 
        catch (SQLException ex) 
        {
            //pode-se deixar vazio para evitar uma mensagem de erro desnecessária ao usuário
        }
    }
    
    public List<Cadastro> getCadastro() 
    {
    
        String sql = "SELECT * FROM cadastro";
        
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            
            rs = stmt.executeQuery();
            
            List<Cadastro> listaCadastro = new ArrayList<>();
            
            while (rs.next()) 
            { //.next retorna verdadeiro caso exista uma próxima posição dentro do array
            
                Cadastro cadastro = new Cadastro();
                
                
                cadastro.setId(rs.getInt("id"));
                cadastro.setCpf(rs.getString("cpf"));
                cadastro.setNome(rs.getString("nome"));
                cadastro.setSobrenome(rs.getString("sobrenome"));
                cadastro.setTelefone(rs.getString("telefone"));
                cadastro.setEndereco(rs.getString("endereco"));
                                
                listaCadastro.add(cadastro);
            }
        
            return listaCadastro;
            //Se o método entrar no "Catch" quer dizer que não encontrou nenhuma empresa, então damos um "return null"
        } 
        catch (Exception e) 
        {
            return null;
        }
    }
    
    /*
    public List<Cadastro> getCadastro2(String categoria) 
    {
        
        String sql = "SELECT * FROM cenaflix.cadastro WHERE categoria LIKE ?";
        
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            stmt.setString(1,"%" + categoria + "%");
            
            ResultSet rs = stmt.executeQuery();
            
            List<Cadastro> listaCadastro = new ArrayList<>();
            
            while (rs.next()) 
            { //.next retorna verdadeiro caso exista uma próxima posição dentro do array
            
                Cadastro cadastro = new Cadastro();
                
                cadastro.setId(rs.getInt("id"));
                cadastro.setNome(rs.getString("nome"));
                cadastro.setData(rs.getString("dataLancamento"));
                cadastro.setCategoria(rs.getString("categoria"));
                
                listaCadastro.add(cadastro);
            }
        
            return listaCadastro;
            //Se o método entrar no "Catch" quer dizer que não encontrou nenhuma empresa, então damos um "return null"
        } 
        catch (Exception e) 
        {
            return null;
        }
    }
    
    */
    
}
