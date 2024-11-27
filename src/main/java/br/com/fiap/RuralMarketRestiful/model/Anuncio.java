package br.com.fiap.RuralMarketRestiful.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "T_ANUNCIO")
public class Anuncio implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_ANUNCIO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "T_USUARIO_CD_USUARIO", referencedColumnName = "CD_USUARIO", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private Modalidade modalidade;

    @Column(name = "DS_TITULO", nullable = false)
    private String titulo;

    @Column(name = "DS_DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "CD_LOCALIZACAO")
    private String localizacao;

    @Lob
    @Column(name = "DS_MAPA_AREA")
    private byte[] mapaArea;

    @Column(name = "DS_MAIS_DETALHES")
    private String maisDetalhes;

    @Column(name = "VL_VALOR", nullable = false)
    private BigDecimal valor;
    
	public Anuncio() {
	}

	public Anuncio( Usuario usuario, Modalidade modalidade, String titulo, String descricao, BigDecimal valor) {
		this.usuario = usuario;
		this.modalidade = modalidade;
		this.titulo = titulo;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public byte[] getMapaArea() {
		return mapaArea;
	}

	public void setMapaArea(byte[] mapaArea) {
		this.mapaArea = mapaArea;
	}

	public String getMaisDetalhes() {
		return maisDetalhes;
	}

	public void setMaisDetalhes(String maisDetalhes) {
		this.maisDetalhes = maisDetalhes;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setFavorito(Favorito favorito) {
		// TODO Auto-generated method stub
		
	}

	
}
