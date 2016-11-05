package br.com.testhibernate.bean;

import br.com.testhibernate.dao.PessoasDao;
import br.com.testhibernate.entity.Pessoas;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PessoasBean {

    private Pessoas pessoas = new Pessoas();
    private PessoasDao pessoasDao = new PessoasDao();

    public PessoasBean() {
    }
    public void limpaTela(){
        pessoas.setNome("");
        pessoas.setEmail("");
        pessoas.setTelefone("");
    }
    //metodo para add pessoa
    public String adicionar(){
        pessoasDao.addPessoa(pessoas);
        //limpaTela();
        return "sucesso";
    }
    public String remove(){
        pessoasDao.removePessoa(pessoas);
        return "sucesso";
    }

    public Pessoas getPessoas() {
        return pessoas;
    }

    public void setPessoas(Pessoas pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.pessoas);
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
        if (!Objects.equals(this.pessoas, other.pessoas)) {
            return false;
        }
        return true;
    }

    
}
