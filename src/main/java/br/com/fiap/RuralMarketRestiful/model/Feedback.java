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
@Table(name = "t_feedback")
public class Feedback {

    @Id
    @SequenceGenerator(name="feedbacks", sequenceName ="sq_tb_feedback", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="feedbacks")
    @Column(name = "cd_feedback")
    private Integer cdFeedback;

    @ManyToOne
    @JoinColumn(name = "t_anuncio_cd_anuncio")
    private Anuncio anuncio;

    @ManyToOne
    @JoinColumn(name = "t_usuario_cd_usuario")
    private Usuario usuario;

    @Column(name = "ds_comentario", nullable = false)
    private String comentario;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_data", nullable = false)
    private Date data;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_time", nullable = false)
    private Date time;

	public Feedback() {
	}

	public Feedback(Anuncio anuncio, Usuario usuario, String comentario, Date data, Date time) {
		super();
		this.anuncio = anuncio;
		this.usuario = usuario;
		this.comentario = comentario;
		this.data = data;
		this.time = time;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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


