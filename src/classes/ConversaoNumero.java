
package classes;

import javax.swing.JOptionPane;

public class ConversaoNumero {
    
    private String data;
    private String hora;
    private String telefone;
    private String cpf;
    
    
    public void setTelefone (String telefone)
    {
        this.telefone = telefone;
    }
    
    public String getTelefone ()
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
    
    public void setData(String data)
    {        
        this.data = data;
    }
    
    public String getData()
    {
        return data;
    }
    
    public void setHora(String hora)
    {        
        this.hora = hora;
    }
    
    public String getHora()
    {
        return hora;
    }
    
    // Função
    public void conversaoTelefone(String telefone)
    {        
        String parte1, parte2, parte3, numeroFormatado;
        boolean testeTelefone;
        
        testeTelefone = telefone.matches("[0-9]{2}[-][0-9]{5}[-][0-9]{4}");
        
        if(testeTelefone == true)
        {
            setTelefone(telefone);
        }
        else if (telefone.length() == 11) 
        {
            parte1 = telefone.substring(0, 2);
            parte2 = telefone.substring(2, 7);
            parte3 = telefone.substring(7, 11);
                        
            numeroFormatado = String.format("%s-%s-%s", parte1, parte2, parte3);
            
            setTelefone(numeroFormatado);
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "TELEFONE precisa esta no formato: xx-xxxxx-xxxx", "ERRO", JOptionPane.WARNING_MESSAGE);
        }
    }


    
    public void conversaoCpf(String cpf)
    {        
        String parte1, parte2, parte3, parte4, numeroFormatado;
        boolean testeCpf;
        
        testeCpf = cpf.matches("[0-9]{3}[.][0-9]{3}[.][0-9]{3}[-][0-9]{2}");
        
        if(testeCpf == true)
        {
            setCpf(cpf);
        }
        else if (cpf.length() == 11) 
        {
            parte1 = cpf.substring(0, 3);
            parte2 = cpf.substring(3, 6);
            parte3 = cpf.substring(6, 9);
            parte4 = cpf.substring(9, 11);
            
            numeroFormatado = String.format("%s.%s.%s-%s", parte1, parte2, parte3, parte4);
            
            setCpf(numeroFormatado);
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "CPF precisa esta no formato: xxx.xxx.xxx-xx", "ERRO", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    
    
    public void conversaoHora(String hora)
    {        
        String parte1, parte2, numeroFormatado;
        boolean testeHora;
        
        testeHora = hora.matches("[0-9]{2}[:][0-9]{2}");
        
        if(testeHora == true)
        {
            setHora(hora);
        }
        else if (hora.length() == 4) 
        {
            
            parte1 = hora.substring(0, 2);
            parte2 = hora.substring(2, 4);
            
            numeroFormatado = String.format("%s:%s", parte1, parte2);
            
            setHora(numeroFormatado);
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "HORA precisa esta no formato: xx:xx", "ERRO", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void conversaoData(String data)
    {        
        String dia, mes, ano, numeroFormatado;
        boolean testeData;
        
        testeData = data.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}");
        
        if(testeData == true)
        {
            setData(data);
        }
        else if (data.length() == 8) 
        {
            dia = data.substring(0, 2);
            mes = data.substring(2, 4);
            ano = data.substring(4, 8);
            
            numeroFormatado = String.format("%s/%s/%s", dia, mes, ano);
            
            setData(numeroFormatado);
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "DATA precisa esta no formato: xx/xx/xxxx", "ERRO", JOptionPane.WARNING_MESSAGE);
        }
    }
}