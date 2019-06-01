/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scargames.cotroller;

import br.com.scargames.domain.Jogo;
import br.com.scargames.services.JogoService;
import br.com.scargames.util.UtilMessages;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "jogoMB")
@SessionScoped
public class JogoMB implements Serializable{
    
    private Jogo jogo;       
    private List<Jogo> jogos;

    public JogoMB() {
       this.listar();
    }

    public void listar() {
        JogoService service = new JogoService();
        jogos = service.listar();
    } 
    
      public String novo(){
        jogo = new Jogo();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String inserir(){
        JogoService service = new JogoService();
        if(service.inserir(jogo)){
            UtilMessages.messageInfo("Jogo cadastrada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao cadastrar a jogo!");
            return null;
        }
    }
    public String excluir(Jogo jogo){
      JogoService service = new JogoService();
        if(service.excluir(jogo)){
             UtilMessages.messageInfo("Jogo excluida com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao excluir a jogo!");
            return null;
        }
    }
    
    
    public String carregarDados(Jogo jogo){
        this.jogo = jogo;
        return"alter.xhtml?faces-redirect=true";
    }
    public String alterar(){
        JogoService service = new JogoService();
        if(service.alterar(jogo)){
             UtilMessages.messageInfo("Jogo alterada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao alterar a jogo!");
            return null;
        }
    }
    
   public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }
   
}