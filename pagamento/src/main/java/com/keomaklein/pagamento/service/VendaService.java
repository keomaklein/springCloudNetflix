package com.keomaklein.pagamento.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.keomaklein.pagamento.data.vo.VendaVO;
import com.keomaklein.pagamento.entity.ProdutoVenda;
import com.keomaklein.pagamento.entity.Venda;
import com.keomaklein.pagamento.exception.ResourceNotFoundException;
import com.keomaklein.pagamento.repository.ProdutoVendaRepository;
import com.keomaklein.pagamento.repository.VendaRepository;

@Service
public class VendaService {
	private final VendaRepository vendaRepository;
	private final ProdutoVendaRepository produtoVendaRepository;

	@Autowired
	public VendaService(VendaRepository vendaRepository, ProdutoVendaRepository produtoVendaRepository) {		
		this.vendaRepository = vendaRepository;
		this.produtoVendaRepository = produtoVendaRepository;
	}
	
	public VendaVO create(VendaVO vendaVO) { 
		Venda vendaRetorno = vendaRepository.save(Venda.create(vendaVO));
		List<ProdutoVenda> produtosSalvos = new ArrayList<>();
		vendaVO.getProdutos().forEach(p ->{
			ProdutoVenda pv = ProdutoVenda.create(p);
			pv.setVenda(vendaRetorno);
			produtosSalvos.add(produtoVendaRepository.save(pv));
		});
		vendaRetorno.setProdutos(produtosSalvos);
		return VendaVO.create(vendaRetorno);
	}
	
	public Page<VendaVO> findAll(Pageable pageable){
		var page = vendaRepository.findAll(pageable);
		return page.map(this::convertToVendaVO);
	}
	
	private VendaVO convertToVendaVO(Venda venda) {
		return VendaVO.create(venda);
	}
	
	public VendaVO findById(Long id) {
		var entity = vendaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("no records found for this ID"));
		return VendaVO.create(entity);
	}
	
	public VendaVO update(VendaVO vendaVO) {
		final Optional<Venda> optionalVenda = vendaRepository.findById(vendaVO.getId());
		if(!optionalVenda.isPresent()) {
			new ResourceNotFoundException("no records found for this ID");
		} 
		
		return VendaVO.create(vendaRepository.save(Venda.create(vendaVO)));				
	}
	
	public void delete(Long id) {
		var entity = vendaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("no records found for this ID"));
		vendaRepository.delete(entity);				
	}
}
