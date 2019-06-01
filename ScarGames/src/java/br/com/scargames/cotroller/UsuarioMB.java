package br.com.scargames.cotroller;

import br.com.scargames.domain.Produtora;
import br.com.scargames.domain.Usuario;
import br.com.scargames.services.JogoService;
import br.com.scargames.services.UsuarioService;
import br.com.scargames.util.UtilMessages;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "usuarioMB")
@SessionScoped
public class UsuarioMB implements Serializable{
    
    private Usuario usuario;
    private String email;
    private String senha;
    private List<Usuario> usuarios;
    
    public UsuarioMB() {
        this.listar();
    }

    public void listar() {
        UsuarioService service = new UsuarioService();
        usuarios = service.listar();
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
            UtilMessages.messageError("Dados inválidos!");
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
      
    
}
