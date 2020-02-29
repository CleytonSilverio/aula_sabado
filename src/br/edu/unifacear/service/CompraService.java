package br.edu.unifacear.service;

import br.edu.unifacear.DAO.ClienteDAO;
import br.edu.unifacear.entidade.Carro;
import br.edu.unifacear.entidade.Cliente;
import br.edu.unifacear.exception.BusinessException;
import br.edu.unifacear.exception.BusinessExceptionCode;

public class CompraService {

	ClienteDAO dao = new ClienteDAO();

	public void comprar(int cliente, int carro) throws BusinessException {

		try {
			dao.comprar(cliente, carro);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(BusinessExceptionCode.ERR001);
		}
	}


}
