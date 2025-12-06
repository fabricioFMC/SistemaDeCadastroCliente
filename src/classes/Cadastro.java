/*
    Atividade 01:

    Projetista: Fabricio Ramos Malvar Cabral CPF 025.885.415-42
    
    Objetivo:
    1. Criação de objetos para manipulação dos dados do software com o bancos de dados. 
    
    Versão: 1.0     Data: 05/12/2025
*/
package classes;


public class Cadastro {
    
    private int id;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String cpf;
    private String endereco;
 
    
    public Cadastro()
    {
        
    }
    
    public Cadastro(String nome, String sobrenome, String telefone, String cpf, String endereco)
    {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
    }        

 
    public void setId(int id)
    {
        this.id = id;
    }
    
    public int getId()
    {
        return id;        
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public void setSobrenome(String sobrenome)
    {
        this.sobrenome = sobrenome;
    }
    
    public String getSobrenome()
    {
        return sobrenome;
    }
    
    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }
    
    public String getTelefone()
    {
        return telefone;
    }
    
    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }
    
    public String getCpf()
    {
        return cpf;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }
    
    public String getEndereco()
    {
        return endereco;
    }
}
