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
		product1.setProductDetail("Este producto es una compra hasta el 80% del valor de las facturas de venta, originadas en operaciones comerciales domesticas y/o exportaciones por la venta a crédito de bienes o servicios, amparadas bajo la póliza de seguro de crédito emitida por Segurexpo de Colombia S.A. o Crediseguro S.A.");
		Product product2 = new Product();
		product2.setProductName("Liquidex cadenas productivas");
		product2.setProductDetail("Este producto es una compra hasta el 85% del valor de las facturas de venta, originadas en operaciones comerciales domesticas por la venta a crédito de bienes o servicios, no requiere gestión por parte del proveedor de la póliza de seguro de crédito y requiere la vinculación del comprador al programa de Liquidex cadenas productivas de Bancóldex.");
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

		product1.setProductName("Línea Capital de trabajo-PIPE Fase III-Pesos");
		product1.setProductDetail("Este cupo de crédito está dirigido a todos los tamaños de empresas  pertenecientes al sector industrial, de acuerdo con la revisión 4 del CIIU  publicada por el DANE en 2012, Sección C Industria Manufacturera, excepto la división 19. Tasa de redescuento DTF E.A + 1.25% E.A.");

		product2.setProductName("Cupo de crédito Itagüí, Microempresas-Capital de trabajo");
		product2.setProductDetail("Este cupo de crédito está dirigido a personas naturales y jurídicas consideradas microempresas de todos los sectores económicos,  localizadas en el Municipio de Itagüí.Tasa de redescuento DTF E.A");

		product3.setProductName("Línea de crédito AECI-Capital de trabajo");
		product3.setProductDetail("Permite financiar las necesidades de capital de trabajo de microempresas de todos los sectores económicos, excepto el sector agropecuario, hasta por un monto de 25 S.M.L.M.V ($15.400.000).");
		
		product4.setProductName("Capital de Trabajo y Sostenimiento Empresarial-Pesos");
		product4.setProductDetail("Permite financiar necesidades de capital de trabajo y consolidación de pasivos a las empresas. Plazo máximo 5 años con un  periodo de gracia de hasta 3 años. ");
		
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
