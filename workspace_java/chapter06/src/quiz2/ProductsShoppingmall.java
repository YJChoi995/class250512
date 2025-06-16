package quiz2;

import java.util.ArrayList;

public class ProductsShoppingmall {
	
	ArrayList productTable = new ArrayList();
	ArrayList cartTable = new ArrayList();
	
	// products에 물품 수동 추가
	// 메소드명 : insert
	// 전달인자 : Products
	// 리턴타입 : X
	void insert(Products product) {
		productTable.add(product);
	}
	
	// 물품 모두 출력
	void selectAll() {
		for (int i=0; i<productTable.size(); i++) {
			Products product = (Products)productTable.get(i);
			System.out.println(i + "번째 상품-----------------");
			System.out.println(product.imgPath);
			System.out.println(product.name);
			System.out.println(product.price);
		}
	}
	
	// 1) 물품 하나 추출하기
	// 메소드명 : selectOne
	// 전달인자 : int index
	// 리턴타입 : Products // 선택된 물품 돌려주기
	Products selectOne(int index) {
		return (Products)productTable.get(index);
	}
	
	
	// 2) 장바구니에 물품 추가
	// 메소드명 : addCart
	// 전달인자 : int index
	// 리턴타입 : void
	void addCart(int index) {
		Products product = selectOne(index);
		this.cartTable.add(product);
	}
	
	// 장바구니 모두 출력
	// 메소드명 : selectCartAll
	void selectCartAll() {
		System.out.println("** 장바구니 **");
		for (int i=0; i<cartTable.size(); i++) {
			Products product = (Products)cartTable.get(i);
			System.out.println(i + "번째 상품-----------------");
			System.out.println(product.imgPath);
			System.out.println(product.name);
			System.out.println(product.price);
		}
	}
	
	// 장바구니의 총 가격 출력
	int cartTotalPrice() {
		int total = 0;
		for (int i=0; i<cartTable.size(); i++) {
			Products product = (Products)cartTable.get(i);
			total += product.price;
		}
		return total;
	}
	
	
}
