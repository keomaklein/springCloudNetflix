package com.keomaklein.pagamento.data.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.keomaklein.pagamento.entity.Produto;
import com.keomaklein.pagamento.entity.ProdutoVenda;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({"id","data","produtos","valorTotal"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class VendaVO extends RepresentationModel<VendaVO> implements Serializable {

	private static final long serialVersionUID = 1216540807347877226L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("data")
	private Date data;
		
	@JsonProperty("produtos")
	private List<ProdutoVenda> produtos;
		
	@JsonProperty("valorTotal")
	private Double valorTotal;
		
	public static VendaVO create(Produto produto) {
		return new ModelMapper().map(produto, VendaVO.class);
	}
}
