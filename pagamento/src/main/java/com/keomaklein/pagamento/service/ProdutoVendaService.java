package com.keomaklein.pagamento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.keomaklein.pagamento.data.vo.ProdutoVendaVO;
import com.keomaklein.pagamento.entity.ProdutoVenda;
import com.keomaklein.pagamento.exception.ResourceNotFoundException;
import com.keomaklein.pagamento.repository.ProdutoVendaRepository;


@Service
public class ProdutoVendaService {

	private final ProdutoVendaRepository produtoVendaRepository;

	@Autowired
	public ProdutoVendaService(ProdutoVendaRepository produtoVendaRepository) {		
		this.produtoVendaRepository = produtoVendaRepository;
	}
	
	public ProdutoVendaVO create(ProdutoVendaVO produtoVendaVO) { 
		ProdutoVendaVO produtoVendaVORetorno = ProdutoVendaVO.create(produtoVendaRepository.save(ProdutoVenda.create(produtoVendaVO)));
		return produtoVendaVORetorno;
	}
	
	public Page<ProdutoVendaVO> findAll(Pageable pageable){
		var page = produtoVendaRepository.findAll(pageable);
		return page.map(this::convertToProdutoVendaVO);
	}
	
	private ProdutoVendaVO convertToProdutoVendaVO(ProdutoVenda produtoVenda) {
		return ProdutoVendaVO.create(produtoVenda);
	}
	
	public ProdutoVendaVO findById(Long id) {
		var entity = produtoVendaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("no records found for this ID"));
		return ProdutoVendaVO.create(entity);
	}
	
	public ProdutoVendaVO update(ProdutoVendaVO produtoVendaVO) {
		final Optional<ProdutoVenda> optionalProdutoVenda = produtoVendaRepository.findById(produtoVendaVO.getId());
		if(!optionalProdutoVenda.isPresent()) {
			new ResourceNotFoundException("no records found for this ID");
		} 
		
		return ProdutoVendaVO.create(produtoVendaRepository.save(ProdutoVenda.create(produtoVendaVO)));				
	}
	
	public void delete(Long id) {
		var entity = produtoVendaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("no records found for this ID"));
		produtoVendaRepository.delete(entity);				
	}
}
