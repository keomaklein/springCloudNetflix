package com.keomaklein.pagamento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.keomaklein.pagamento.data.vo.ProdutoVO;
import com.keomaklein.pagamento.entity.Produto;
import com.keomaklein.pagamento.exception.ResourceNotFoundException;
import com.keomaklein.pagamento.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	private final ProdutoRepository produtoRepository;

	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {		
		this.produtoRepository = produtoRepository;
	}
	
	public ProdutoVO create(ProdutoVO produtoVO) { 
		ProdutoVO produtoVORetorno = ProdutoVO.create(produtoRepository.save(Produto.create(produtoVO)));
		return produtoVORetorno;
	}
	
	public Page<ProdutoVO> findAll(Pageable pageable){
		var page = produtoRepository.findAll(pageable);
		return page.map(this::convertToProdutoVO);
	}
	
	private ProdutoVO convertToProdutoVO(Produto produto) {
		return ProdutoVO.create(produto);
	}
	
	public ProdutoVO findById(Long id) {
		var entity = produtoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("no records found for this ID"));
		return ProdutoVO.create(entity);
	}
	
	public ProdutoVO update(ProdutoVO produtoVO) {
		final Optional<Produto> optionalProduto = produtoRepository.findById(produtoVO.getId());
		if(!optionalProduto.isPresent()) {
			new ResourceNotFoundException("no records found for this ID");
		} 
		
		return ProdutoVO.create(produtoRepository.save(Produto.create(produtoVO)));				
	}
	
	public void delete(Long id) {
		var entity = produtoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("no records found for this ID"));
		produtoRepository.delete(entity);				
	}
}
