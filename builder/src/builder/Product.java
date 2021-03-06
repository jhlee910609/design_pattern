package builder;

public class Product {
	 
	 private String name;
	 private int price;
	 private boolean isSold = false;
	 private String manufacturer;
	 
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public boolean getStatus() {
		return this.isSold;
	}
	
	public String toString() {
		String result = "name : " + this.name +", price : " + this.price 
				 + ", manufacturer : " + this.manufacturer + ", status : " + this.isSold;
		return result;
	}
	
	// 3. 생성자를 private으로 만들고, 파라미터로 ProductBuilder를 받는다.
	// 3.1. 아래 private 생성자에서 기본값들을 셋팅한다. 
	private Product(ProductBuilder builder) {
		this.name = builder.name;
		this.price = builder.price;
		this.isSold = builder.isSold;
		this.manufacturer = builder.manufacturer;
	}
	
	// 2. static으로 빌더 패턴을 적용한다. 
	public static class ProductBuilder{
		private String name;
		private int price;
		private boolean isSold =false;
		private String manufacturer;
		
		public ProductBuilder(String name, int price) {
			this.name = name;
			this.price = price;
		}
		
		public ProductBuilder setStatus(boolean isSold) {
			this.isSold = isSold;
			return this;	
		}
		
		public ProductBuilder setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
			return this;
		}
		
		// 2. builder() 메소드 호출 시, Product를 new한다.
		public Product build() {
			return new Product(this);
		}
	}
}