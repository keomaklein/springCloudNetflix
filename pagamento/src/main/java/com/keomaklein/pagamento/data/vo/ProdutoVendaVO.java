package com.keomaklein.pagamento.data.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.keomaklein.pagamento.entity.ProdutoVenda;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({"id","idProduto","quantidade","venda"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProdutoVendaVO implements Serializable {

	private static final long serialVersionUID = 8139082445203930509L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("idProduto")
	private Long idProduto;
		
	@JsonProperty("quantidade")
	private Integer quantidade;
		
	@JsonProperty("venda")
	private VendaVO vendaVO;
		
	public static ProdutoVendaVO create(ProdutoVenda produtoVenda) {
		return new ModelMapper().map(produtoVenda, ProdutoVendaVO.class);
	}
}
