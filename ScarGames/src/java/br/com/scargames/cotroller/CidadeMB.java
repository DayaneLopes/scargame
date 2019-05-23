/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scargames.cotroller;

import br.com.scargames.domain.Bandeira;
import br.com.scargames.domain.Cidade;
import br.com.scargames.domain.Genero;
import br.com.scargames.services.BandeiraService;
import br.com.scargames.services.CidadeService;
import br.com.scargames.services.GeneroService;
import br.com.scargames.util.UtilMessages;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.PrimeFaces;

@ManagedBean(name = "cidadeMB")
@SessionScoped
public class CidadeMB implements Serializable{

    private Cidade cidade;
    private List<Cidade> cidades;
    
    public CidadeMB() {
        this.listar();
    }
    
    public void listar(){
        CidadeService service = new CidadeService();
        cidades = service.listar();
    }
    
    public String novo(){
        cidade = new Cidade();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String inserir(){
        CidadeService service = new CidadeService();
        if (service.inserir(cidade)){
            UtilMessages.messageInfo("Cidade cadastrada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao cadastrar cidade!");
            return null;
        }
    }
    
    public String alterar(){
        CidadeService service = new CidadeService();
        if (service.alterar(cidade)){
            UtilMessages.messageInfo("Cidade alterada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao alterar cidade!");
            return null;
        }
    }
    
    public String carregarDados(Cidade cidade){
        this.cidade = cidade;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String excluir(Cidade cidade){
        CidadeService service = new CidadeService();
        if (service.excluir(cidade)){
            UtilMessages.messageInfo("Cidade excluída com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Erro ao excluir Cidade!");
            return null;
        }
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}