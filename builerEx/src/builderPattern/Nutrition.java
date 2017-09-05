package builderPattern;

public class Nutrition {
	
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;
	
	// static Builder class 작성 
	public static class Builder{
		
		// 1. 필수 인자 final로 작성한다.
		// 1.1. final 변수의 경우, 생성자에서만 값을 저장할 수 있다.
		private final int servingSize;
		private final int servings;
		
		// 2.선택 인자
		private int calories = 0;
		private int fat = 0;
		private int sodium = 0;
		private int carbohydrate = 0;
		
		// 3. 필수 인자 생성자를 통해 초기화 
		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}
		
		// 4. 선택 인자를 셋팅한다. 
		public Builder calories(int val) {
			calories = val;
			return this;	
		}
		
		public Builder fat(int val) {
			fat = val;
			return this;
		}
		
		public Builder sodium(int val) {
			sodium = val;
			return this;
		}
		
		public Builder carbohydrate(int val) {
			carbohydrate = val;
			return this;
		}
		
		// 5. build 메소드 호출 시, Nutrition 객체를 인스턴스화한다.
		// 5.1. 이때 중요한 것은 인자로 자기 자신을 넘겨준다는 것이다.
		public Nutrition build() {
			return new Nutrition(this);
		}
	}
	
	private Nutrition (Builder builder) {
		this.servings = builder.servings;
		this.servingSize = builder.servingSize;
		this.calories = builder.calories;
		this.fat = builder.fat;
		this.sodium = builder.sodium;
		this.carbohydrate = builder.carbohydrate;
	}

	@Override
	public String toString() {
		return "Nutritions [servingSize=" + servingSize + ", servings=" + servings + ", calories=" + calories + ", fat="
				+ fat + ", sodium=" + sodium + ", carbohydrate=" + carbohydrate + "]";
	}	
}
