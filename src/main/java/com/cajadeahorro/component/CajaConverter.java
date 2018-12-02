package com.cajadeahorro.component;

import org.springframework.stereotype.Component;

import com.cajadeahorro.entity.Caja;
import com.cajadeahorro.model.CajaModel;

// TODO: Auto-generated Javadoc
/**
 * The Class CajaConverter.
 */
@Component("cajaConverter")
public class CajaConverter {
	
	/**
	 * Model 2 entity.
	 *
	 * @param cajaModel the caja model
	 * @return the caja
	 */
	public Caja model2Entity(CajaModel cajaModel) {
		Caja caja = new Caja();

		caja.setTipo(cajaModel.getTipo());
		caja.setCantidad(cajaModel.getCantidad());

		return caja;
	}

	/**
	 * Entity 2 model.
	 *
	 * @param caja the caja
	 * @return the caja model
	 */
	public CajaModel entity2Model(Caja caja) {
		CajaModel cajaModel = new CajaModel();

		cajaModel.setTipo(cajaModel.getTipo());
		cajaModel.setCantidad(caja.getCantidad());

		return cajaModel;
	}
}
