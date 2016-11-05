package br.com.testhibernate.dao;

import br.com.testhibernate.entity.Pessoas;
import br.com.testhibernate.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PessoasDao {

    private Session sessao;
    private Transaction trans;
    private List<Pessoas>list;

    public List<Pessoas> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Pessoas.class);
        this.list = cri.list(); 
        return list;
    }

    public void addPessoa(Pessoas p) {
        try {
            //Inicaia e abre a sessao
            sessao = HibernateUtil.getSessionFactory().openSession();
            //Inicializa
            trans = sessao.beginTransaction();
            //Passando uma referencia e carregando os params
            Pessoas pessoa = new Pessoas();
            pessoa.setNome(p.getNome());
            pessoa.setEmail(p.getEmail());
            pessoa.setTelefone(p.getTelefone());
            sessao.save(pessoa);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //finalizando a sessao 
            sessao.close();
        }

    }
    public void removePessoa(Pessoas p){
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            sessao.delete(p);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sessao.close();
        }
    }
}
