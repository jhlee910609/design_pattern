package builder;

import builder.Product.ProductBuilder;

public class BasicBuilder {

	public static void main(String[] args) {
		// 1. static으로 만든 ProductBuilder를 작성한다.
		ProductBuilder builder = new ProductBuilder("코카콜라", 2000);
		
		// 2. 설정값을 더한 후, 추가 셋팅을 한다. 
		Product product = builder.setStatus(true).setManufacturer("Coca-Cola").build();
		
		// 3. toString 메소드를 통해 객체의 멤버변수들을 확인한다. 
		System.out.println(product.toString());
	}
}


