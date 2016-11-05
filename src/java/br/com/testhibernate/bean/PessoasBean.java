package br.com.testhibernate.bean;

import br.com.testhibernate.dao.PessoasDao;
import br.com.testhibernate.entity.Pessoas;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PessoasBean {

    private Pessoas pessoa = new Pessoas();
    private PessoasDao pessoasDao = new PessoasDao();
    private List<Pessoas>listarPessoas;
    
    public PessoasBean() {
    }
    public void limpaTela(){
//        pessoas.setNome(null);
//        pessoas.setEmail(null);
//        pessoas.setTelefone(null);
    }
    //metodo para add pessoa
    public String adicionarPessoa(){
        pessoasDao.addPessoa(pessoa);
        //limpaTela();
        pessoa.setNome(null);
        pessoa.setEmail(null);
        pessoa.setTelefone(null);
        return "index";
    }
    public String remove(Pessoas p){
        this.pessoa = p;
        pessoasDao.removePessoa(this.pessoa);
        return "index";
    }
    public List listarPessoas(){
        listarPessoas = pessoasDao.getList();
        return  this.listarPessoas;
    }

    public Pessoas getPessoas() {
        return pessoa;
    }

    public void setPessoas(Pessoas pessoas) {
        this.pessoa = pessoas;
    }

    public PessoasDao getPessoasDao() {
        return pessoasDao;
    }

    public void setPessoasDao(PessoasDao pessoasDao) {
        this.pessoasDao = pessoasDao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.pessoa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PessoasBean other = (PessoasBean) obj;
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return true;
    }

    
}
