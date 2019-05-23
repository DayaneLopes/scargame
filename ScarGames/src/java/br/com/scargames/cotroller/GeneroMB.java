/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scargames.cotroller;

import br.com.scargames.domain.Bandeira;
import br.com.scargames.domain.Genero;
import br.com.scargames.services.BandeiraService;
import br.com.scargames.services.GeneroService;
import br.com.scargames.util.UtilMessages;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Windows
 */
@ManagedBean(name = "generoMB")
@ViewScoped
public class GeneroMB implements Serializable{

    private Genero genero = new Genero();
    private List<Genero> generos;
    private GeneroService service;
    
    
    public GeneroMB() {
        service = new GeneroService();
        generos = service.listar();
    }
    
    public void novo(){
        genero = new Genero();
    }
    
    public void inserir(){
        if(service.inserir(genero)){
            UtilMessages.messageInfo("Gênero cadastrada com sucesso!");
            generos = service.listar();    
            PrimeFaces current = PrimeFaces.current();
            current.executeScript("PF('gestaoGenero').hide();");
            
        }else{
            UtilMessages.messageError("Ocorreu um erro ao cadastrar a gênero!");
        }
    }
    
    public void carregarDados(Genero genero){
        this.genero = genero;
        
    }
    
    public void excluir(Genero genero){
       if(service.excluir(genero)){
            UtilMessages.messageInfo("Gênero excluida com sucesso!");
            generos = service.listar();
            PrimeFaces current = PrimeFaces.current();
            current.executeScript("PF('gestaoGenero').hide();");
        }else{
            UtilMessages.messageError("Ocorreu um erro ao excluir a gênero!");
            
        }
    }
    
        public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public GeneroService getGeneroService() {
        return service;
    }

    public void setGeneroService(GeneroService generoService) {
        this.service = generoService;
    }
    
    
}
