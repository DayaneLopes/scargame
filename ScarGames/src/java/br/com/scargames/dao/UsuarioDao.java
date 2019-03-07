package br.com.scargames.dao;

import br.com.scargames.domain.Usuario;
import br.com.scargames.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class UsuarioDao {
    
    public List<Usuario> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            List<Usuario> lista = session.createQuery("from Usuario order by nome asc").list();
            session.getTransaction().commit();
            return lista;
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }   
        return new ArrayList();
    }
    
    public Usuario consultar(Integer id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            Usuario produtora = (Usuario)session.createQuery("from Usuario where id = " + id).uniqueResult();
            session.getTransaction().commit();
            return produtora;
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }   
    }
    
    public Boolean inserir (Usuario usuario){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();  
        session.beginTransaction();
        try{
            session.save(usuario);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
                e.printStackTrace();
            return false;
        }       
    }
    
    
    public Boolean alterar (Usuario usuario){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();  
        session.beginTransaction();
        try{
            session.update(usuario);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
                e.printStackTrace();
            return false;
        }      
    }
    
    public Boolean excluir (Usuario usuario){
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();  
        session.beginTransaction();
        try{
            session.delete(usuario);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
                e.printStackTrace();
            return false;
        }      
    }
    
   
}
