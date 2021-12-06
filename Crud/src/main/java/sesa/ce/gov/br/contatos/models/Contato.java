package sesa.ce.gov.br.contatos.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contato")
public class Contato implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9035435129309292984L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_contato")
	private Integer idContato;

	@Column(name = "valor")
	private String valor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "id_pessoa")
	@JsonIgnore
	private Pessoa pessoa;
	
	@Column(name = "tipo_contato")
	@Enumerated(EnumType.STRING)
	private TipoContato tipoContato;

}
