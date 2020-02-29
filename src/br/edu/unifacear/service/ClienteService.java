package br.edu.unifacear.service;

import br.edu.unifacear.DAO.ClienteDAO;
import br.edu.unifacear.entidade.Cliente;
import br.edu.unifacear.exception.BusinessException;
import br.edu.unifacear.exception.BusinessExceptionCode;

public class ClienteService {
	
	ClienteDAO dao = new ClienteDAO();
	
	public void inserir(Cliente cliente) throws BusinessException{
		
		if(cliente.getLogin().contains("!@#$%&*")) {
			throw new BusinessException(BusinessExceptionCode.ERR002);
		}
		
		try {
			dao.inserir(cliente);
		}catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(BusinessExceptionCode.ERR001);
		}
	}

}
