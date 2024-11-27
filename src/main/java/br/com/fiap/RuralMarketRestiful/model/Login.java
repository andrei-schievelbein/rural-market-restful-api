package br.com.fiap.RuralMarketRestiful.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_LOGIN")
public class Login {

    @Id
    @SequenceGenerator(name="logins", sequenceName ="sq_tb_login", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="logins")
    @Column(name = "CD_LOGIN")
    private Long id;

    @Column(name = "USUARIO", nullable = false)
    private String usuario;

    @Column(name = "SENHA", nullable = false)
    private String senha;

    
    public Login() {
	}
    
    public Login( String usuario, String senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
	}
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
