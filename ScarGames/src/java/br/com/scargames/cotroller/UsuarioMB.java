package br.com.scargames.cotroller;

import br.com.scargames.domain.Usuario;
import br.com.scargames.services.UsuarioService;
import java.io.Serializable;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "usuarioMB")
@RequestScoped
public class UsuarioMB implements Serializable{
    
    private Usuario usuario;
    private String email;
    private String senha;

    public UsuarioMB() {
        
    }
    public void inicializarHibernate(){
        UsuarioService service = new UsuarioService();
        service.inicializarHibernate();
    }
    
    public String autenticar(){
        UsuarioService service = new UsuarioService();
        usuario = new Usuario(email, senha);
        if(service.atenticar(usuario)){
            return "/private/index.xhtmll?faces-redirect=true";
        }else{
            return null; 
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
      
    
}
