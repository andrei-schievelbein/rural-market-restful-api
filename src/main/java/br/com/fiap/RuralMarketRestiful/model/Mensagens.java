package br.com.fiap.RuralMarketRestiful.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "t_mensagens")
public class Mensagens {

    @Id
	@SequenceGenerator(name="feedbacks", sequenceName ="sq_tb_feedback", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="feedbacks")
    @Column(name = "cd_feedback")
    private Integer cdFeedback;

    @ManyToOne
    @JoinColumn(name = "t_usuario_cd_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "t_anuncio_cd_anuncio")
    private Anuncio anuncio;

    @Column(name = "ds_mensagem")
    private String mensagem;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_data")
    private Date data;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_time")
    private Date time;

	public Mensagens() {
	}
    
	public Mensagens(Usuario usuario, Anuncio anuncio, String mensagem, Date data, Date time) {
		this.usuario = usuario;
		this.anuncio = anuncio;
		this.mensagem = mensagem;
		this.data = data;
		this.time = time;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
