package com.cajadeahorro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cajadeahorro.component.CajaConverter;
import com.cajadeahorro.entity.Caja;
import com.cajadeahorro.model.CajaModel;
import com.cajadeahorro.repository.CajaRepository;
import com.cajadeahorro.service.CajaService;

// TODO: Auto-generated Javadoc
/**
 * The Class CajaServiceImpl.
 */
@Service("cajaServiceImpl")
public class CajaServiceImpl implements CajaService {
	
	/** The caja repository. */
	@Autowired
	@Qualifier("cajaRepository")
	private CajaRepository cajaRepository;
	
	/** The caja converter. */
	@Autowired
	@Qualifier("cajaConverter")
	private CajaConverter cajaConverter;

	/* (non-Javadoc)
	 * @see com.cajadeahorro.service.CajaService#findByTipo(java.lang.String)
	 */
	@Override
	public Caja findByTipo(String tipo) {
		return cajaRepository.findByTipo(tipo);
	}

	/* (non-Javadoc)
	 * @see com.cajadeahorro.service.CajaService#findByTipoModel(java.lang.String)
	 */
	@Override
	public CajaModel findByTipoModel(String tipo) {
		Caja caja = cajaRepository.findByTipo(tipo);

		return caja != null ? cajaConverter.entity2Model(caja) : null;
	}

	/* (non-Javadoc)
	 * @see com.cajadeahorro.service.CajaService#findByAll()
	 */
	@Override
	public List<CajaModel> findByAll() {
		List<Caja> tipos = cajaRepository.findAll();
		List<CajaModel> tiposModels = new ArrayList<CajaModel>();

		for (Caja tipo : tipos) {
			tiposModels.add(cajaConverter.entity2Model(tipo));
		}

		return tiposModels;
	}

}
