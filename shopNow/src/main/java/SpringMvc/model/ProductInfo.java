package SpringMvc.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class ProductInfo {
	
	private int productId;
	 private String productName;
	 private int productPrice;
	 private String base64Image;
	  private String description;
	    private String tyepe;
	    private int count;
	    private ArrayList list;
	    
	    
		
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public ArrayList getList() {
			return list;
		}
		public void setList(ArrayList list) {
			this.list = list;
		}
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public int getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(int productPrice) {
			this.productPrice = productPrice;
		}
		public String getBase64Image() {
			return base64Image;
		}
		public void setBase64Image(String base64Image) {
			this.base64Image = base64Image;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getTyepe() {
			return tyepe;
		}
		public void setTyepe(String tyepe) {
			this.tyepe = tyepe;
		}
		@Override
		public String toString() {
			return "ProductInfo [productId=" + productId + ", productName=" + productName + ", productPrice="
					+ productPrice + ",  description=" + description + ", tyepe="
					+ tyepe + ", list=" + list + "]";
		}
	

}
