package com.reyesmagos.bancoldex.bancoldexapp.util.mocks;

import java.util.ArrayList;
import java.util.List;

import com.reyesmagos.bancoldex.bancoldexapp.modelo.Product;

public class ProductMock {

	private List<Product> arrayProduct;
	private List<Product> arrayProduct1;

	public ProductMock() {

	}

	public List<Product> getArrayProduct() {
		arrayProduct = new ArrayList<Product>();
		Product product1 = new Product();
		product1.setProductName("Liquidex COP-USD");
		product1.setProductDetail("Este producto es una compra hasta el 80% del valor de las facturas de venta, originadas en operaciones comerciales domesticas y/o exportaciones por la venta a cr�dito de bienes o servicios, amparadas bajo la p�liza de seguro de cr�dito emitida por Segurexpo de Colombia S.A. o Crediseguro S.A.");
		Product product2 = new Product();
		product2.setProductName("Liquidex cadenas productivas");
		product2.setProductDetail("Este producto es una compra hasta el 85% del valor de las facturas de venta, originadas en operaciones comerciales domesticas por la venta a cr�dito de bienes o servicios, no requiere gesti�n por parte del proveedor de la p�liza de seguro de cr�dito y requiere la vinculaci�n del comprador al programa de Liquidex cadenas productivas de Banc�ldex.");
		arrayProduct.add(product1);
		arrayProduct.add(product2);
		return arrayProduct;
	}

	public List<Product> getArrayProduct2() {
		arrayProduct1 = new ArrayList<Product>();
		Product product1 = new Product();
		Product product2 = new Product();
		Product product3 = new Product();
		Product product4 = new Product();

		product1.setProductName("L�nea Capital de trabajo-PIPE Fase III-Pesos");
		product1.setProductDetail("Este cupo de cr�dito est� dirigido a todos los tama�os de empresas  pertenecientes al sector industrial, de acuerdo con la revisi�n 4 del CIIU  publicada por el DANE en 2012, Secci�n C Industria Manufacturera, excepto la divisi�n 19. Tasa de redescuento DTF E.A + 1.25% E.A.");

		product2.setProductName("Cupo de cr�dito Itag��, Microempresas-Capital de trabajo");
		product2.setProductDetail("Este cupo de cr�dito est� dirigido a personas naturales y jur�dicas consideradas microempresas de todos los sectores econ�micos,  localizadas en el Municipio de Itag��.Tasa de redescuento DTF E.A");

		product3.setProductName("L�nea de cr�dito AECI-Capital de trabajo");
		product3.setProductDetail("Permite financiar las necesidades de capital de trabajo de microempresas de todos los sectores econ�micos, excepto el sector agropecuario, hasta por un monto de 25 S.M.L.M.V ($15.400.000).");
		
		product4.setProductName("Capital de Trabajo y Sostenimiento Empresarial-Pesos");
		product4.setProductDetail("Permite financiar necesidades de capital de trabajo y consolidaci�n de pasivos a las empresas. Plazo m�ximo 5 a�os con un  periodo de gracia de hasta 3 a�os. ");
		
		arrayProduct1.add(product1);
		arrayProduct1.add(product2);
		arrayProduct1.add(product3);
		arrayProduct1.add(product4);

		return arrayProduct1;
	}
	
	public List<String> convertProductToString(List<Product>products){
		List<String>result = new ArrayList<String>();
		
		for(int i = 0; i < products.size(); i++){
			result.add(products.get(i).getProductName());
		}
		
		return result;
	}

}
