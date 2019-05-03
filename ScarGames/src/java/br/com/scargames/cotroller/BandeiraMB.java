package br.com.scargames.cotroller;

import br.com.scargames.domain.Bandeira;
import br.com.scargames.domain.Usuario;
import br.com.scargames.services.BandeiraService;
import br.com.scargames.services.UsuarioService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "bandeiraMB")
@SessionScoped
public class BandeiraMB implements Serializable{
    
    private Bandeira bandeira;       
    private List<Bandeira> bandeiras;

    public BandeiraMB() {
       this.listar();
    }

    public void listar() {
        BandeiraService service = new BandeiraService();
        bandeiras = service.listar();
    } 
    
      public String novo(){
        bandeira = new Bandeira();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String inserir(){
        BandeiraService service = new BandeiraService();
        if(service.inserir(bandeira)){
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    public String excluir(Bandeira bandeira){
      BandeiraService service = new BandeiraService();
        if(service.excluir(bandeira)){
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    
    
    public String carregarDados(Bandeira bandeira){
        this.bandeira = bandeira;
        return"alter.xhtml?faces-redirect=true";
    }
    public String alterar(){
        BandeiraService service = new BandeiraService();
        if(service.alterar(bandeira)){
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    
   public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
   
   public Bandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }
    
    public List<Bandeira> getBandeiras() {
        return bandeiras;
    }

    public void setBandeiras(List<Bandeira> bandeiras) {
        this.bandeiras = bandeiras;
    }
    
    
}
