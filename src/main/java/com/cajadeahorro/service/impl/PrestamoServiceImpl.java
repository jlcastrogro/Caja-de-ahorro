package com.cajadeahorro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cajadeahorro.component.PrestamoConverter;
import com.cajadeahorro.entity.Prestamo;
import com.cajadeahorro.model.PrestamoModel;
import com.cajadeahorro.repository.PrestamoRepository;
import com.cajadeahorro.service.PrestamoService;

// TODO: Auto-generated Javadoc
/**
 * The Class PrestamoServiceImpl.
 */
@Service("prestamoServiceImpl")
public class PrestamoServiceImpl implements PrestamoService {
	
	/** The prestamo repository. */
	@Autowired
	@Qualifier("prestamoRepository")
	private PrestamoRepository prestamoRepository;
	
	/** The prestamo converter. */
	@Autowired
	@Qualifier("prestamoConverter")
	private PrestamoConverter prestamoConverter;

	/* (non-Javadoc)
	 * @see com.cajadeahorro.service.PrestamoService#findByIdModel(int)
	 */
	@Override
	public PrestamoModel findByIdModel(int id) {
		Prestamo prestamo = prestamoRepository.findById(id);

		return prestamo != null ? prestamoConverter.entity2Model(prestamo) : null;
	}

	/* (non-Javadoc)
	 * @see com.cajadeahorro.service.PrestamoService#findById(int)
	 */
	@Override
	public Prestamo findById(int id) {
		return prestamoRepository.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.cajadeahorro.service.PrestamoService#delete(int)
	 */
	@Override
	public void delete(int id) {
		prestamoRepository.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.cajadeahorro.service.PrestamoService#findAll()
	 */
	@Override
	public List<PrestamoModel> findAll() {
		List<Prestamo> prestamos = prestamoRepository.findAll();
		List<PrestamoModel> prestamoModels = new ArrayList<>();

		for (Prestamo prestamo : prestamos) {
			prestamoModels.add(prestamoConverter.entity2Model(prestamo));
		}

		return prestamoModels;
	}

	/* (non-Javadoc)
	 * @see com.cajadeahorro.service.PrestamoService#findByCliente(java.lang.String)
	 */
	@Override
	public List<PrestamoModel> findByCliente(String cliente) {
		List<Prestamo> prestamos = prestamoRepository.findByCliente(cliente);
		List<PrestamoModel> prestamoModels = new ArrayList<>();

		for (Prestamo prestamo : prestamos) {
			prestamoModels.add(prestamoConverter.entity2Model(prestamo));
		}

		return prestamoModels;
	}

}
