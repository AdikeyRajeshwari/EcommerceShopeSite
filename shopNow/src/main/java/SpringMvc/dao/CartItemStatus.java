package SpringMvc.dao;

import java.util.ArrayList;

import SpringMvc.model.ProductInfo;

public interface CartItemStatus {
	public Boolean cartStatus(int productIdFromUser,String userId);
	public Boolean viewCart(String email, ProductInfo info, ArrayList<ProductInfo> list);

}
