# Builder Pattern

> 생성자 인자가 많을 때는 Builder Pattern을 고려해봐도 좋다.

### 1. Builder Pattern 이란

- 객체가 최초 생성 후, 불변인 상황에서만 사용할 수 있다.
- 빌더 패턴은 인자가 많은 생성자(생성자의 인자가 4개 이상일 때)나 정적 패터리가 필요한 클래스를 설계할 때, 특히 대부분의 인자가 선택적 인자인 상황에 유용하다. 
- 하지만 단점으로 우선 코드량이 증가하고, 잦은 빌더 패턴 구현은 application 성능에 방해가 될 수도 있다.



### 2. Builder Pattern 구현

- [소스보기](https://goo.gl/DbPQKU)


- `Nutrition` class의 inner class로  `Builder` 를 작성한다.
- `Builder.build()` 를 호출했을 때, `Nutrition` 객체를 인스턴스화하도록 작성한다. 

```java
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
}	
```

  