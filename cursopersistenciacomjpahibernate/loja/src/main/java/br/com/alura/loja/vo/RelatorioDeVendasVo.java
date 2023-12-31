package br.com.alura.loja.vo;

import java.time.LocalDate;

public class RelatorioDeVendasVo {
	private String nomeProduto;
	private Long quantidadeVendida;
	private LocalDate dateUltimaVenda;
	 
	public RelatorioDeVendasVo(String nomeProduto, Long quantidadeVendida, LocalDate dateUltimaVenda) {
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.dateUltimaVenda = dateUltimaVenda;
	}
	
	
	@Override
	public String toString() {
		return "RelatorioDeVendasVo [nomeProduto=" + nomeProduto + ", quantidadeVendida=" + quantidadeVendida
				+ ", dateUltimaVenda=" + dateUltimaVenda + "]";
	}


	public String getNomeProduto() {
		return nomeProduto;
	}

	public Long getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public LocalDate getDateUltimaVenda() {
		return dateUltimaVenda;
	}
	
}
