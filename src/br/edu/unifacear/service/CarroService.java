package br.edu.unifacear.service;

import br.edu.unifacear.DAO.CarroDAO;
import br.edu.unifacear.entidade.Carro;
import br.edu.unifacear.exception.BusinessException;
import br.edu.unifacear.exception.BusinessExceptionCode;

public class CarroService {

	CarroDAO dao = new CarroDAO();

	public void inserir(Carro carro) throws BusinessException {

		if (carro.getModelo().contains("!@#$%&*")) {
			throw new BusinessException(BusinessExceptionCode.ERR003);
		}

		try {
			dao.inserir(carro);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(BusinessExceptionCode.ERR001);
		}
	}
}
