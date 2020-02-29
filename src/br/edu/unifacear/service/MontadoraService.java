package br.edu.unifacear.service;

import br.edu.unifacear.DAO.MontadoraDAO;
import br.edu.unifacear.entidade.Montadora;
import br.edu.unifacear.exception.BusinessException;
import br.edu.unifacear.exception.BusinessExceptionCode;

public class MontadoraService {

	MontadoraDAO dao = new MontadoraDAO();

	public void inserir(Montadora montadora) throws BusinessException {

		if (montadora.getMontadora().contains("!@#$%&*")) {
			throw new BusinessException(BusinessExceptionCode.ERR004);
		}

		try {
			dao.inserir(montadora);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(BusinessExceptionCode.ERR001);
		}
	}

}
