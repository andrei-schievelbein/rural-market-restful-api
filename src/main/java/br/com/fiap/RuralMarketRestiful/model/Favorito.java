package br.com.fiap.RuralMarketRestiful.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_FAVORITO")
public class Favorito {

    @Id
    @SequenceGenerator(name="favoritos", sequenceName ="sq_tb_favorito", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="favoritos")
    @Column(name = "CD_FAVORITO")
    private Long id;

    // Outros campos e associações, se necessário
    
    
    public Favorito(Long id) {
		super();
		this.id = id;
	}
    
    
    // Getters and setters
    
    

    public Long getId() {
        return id;
    }


	public void setId(Long id) {
        this.id = id;
    }

    // Outros getters e setters, se necessário
}
