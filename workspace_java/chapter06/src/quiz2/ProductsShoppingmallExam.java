package quiz2;

public class ProductsShoppingmallExam {

	public static void main(String[] args) {
		ProductsShoppingmall mall = new ProductsShoppingmall();
		
		Products p1 = new Products();
		p1.imgPath = "http://p1";
		p1.name = "우유 2.3L";
		p1.price = 6380;
		mall.insert(p1);
		
		Products p2 = new Products();
		p2.imgPath = "http://p2";
		p2.name = "두부";
		p2.price = 1800;
		mall.insert(p2);
		
		Products p3 = new Products();
		p3.imgPath = "http://p3";
		p3.name = "이오";
		p3.price = 3730;
		mall.insert(p3);
				
		mall.selectAll(); // 물품 모두 보기
		
		
		// 장바구니에 물품 추가
		mall.addCart(0);
		
		// 장바구니의 물품 모두 보기
		mall.selectCartAll();
		
		// 장바구니의 총 가격 보기
		System.out.println("** 장바구니에 담은 가격 보기 **");
		mall.cartTotalPrice();
		
		
		
	}

}
