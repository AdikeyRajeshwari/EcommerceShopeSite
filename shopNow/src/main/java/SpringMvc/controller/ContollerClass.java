package SpringMvc.controller;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.jdbc.Blob;

import SpringMvc.dao.BookNowClass;
import SpringMvc.dao.CartItemStatusClass;
import SpringMvc.dao.DaoClassImpl;
import SpringMvc.dao.LoginClass;
import SpringMvc.dao.retriveProductInfo;
import SpringMvc.model.ProductInfo;
import SpringMvc.model.UserInfo;

@Controller
public class ContollerClass {

	
	 @RequestMapping(value="/reg", method=RequestMethod.POST)
		//public ModelAndView reg(@RequestParam("name") String name, @RequestParam("phnno") String phnno, @RequestParam("email") String email, @RequestParam("password") String password )
		public ModelAndView reg(@ModelAttribute("anyIdentifier") UserInfo info)
		{
			
			boolean status = new DaoClassImpl().regDBConnection(info);

			if(status)
			{
				String msg = "Registration Successful";
				//ModelAndView modelAndView = new ModelAndView("index", "identi", msg);
				ModelAndView modelAndView = new ModelAndView("login");
				return modelAndView;
			}
			return null;
			
			
		}
		
		@RequestMapping(value="/log", method=RequestMethod.POST)
		
		public ModelAndView reg(HttpSession session,@RequestParam("phnno") String phnno, @RequestParam("email") String email, ProductInfo info, ArrayList<ProductInfo> list)
		{
			
			
			boolean status=new LoginClass().login(phnno, email);
			
			 System.out.println(status);
			 
			 session.setAttribute("email", email);
			 if(status)
			 {
				 boolean status1=new retriveProductInfo().demo(info, list, session);
				 if(status1)
				 {
					 
					 ModelAndView mav= new ModelAndView("home2","list",list);
			    return mav; 
				 }
				 else
				 {
					 System.out.println("home unssecussefull ");
					 ModelAndView mav= new ModelAndView("index");
					    return mav;
				 }
				
			 }
			 else {
				 System.out.println("log controller2");
				 ModelAndView mav= new ModelAndView("login");
				    return mav; 
			 }
			
		}
		
		
		
		 @RequestMapping("/viewCartIteams")
		public ModelAndView viewCartIteams(HttpServletRequest request, HttpServletResponse response, @RequestParam("email") String email,HttpSession session, ProductInfo info, ArrayList<ProductInfo> list1 ) throws Exception
		 {
		 System.out.println("view carts"+email);
		 boolean status=new CartItemStatusClass().viewCart(email, info, list1);
		 if(status)
		 {
			 ModelAndView mav= new ModelAndView("viewCartDetails","list1",list1);
			    return mav;
		 }
		 else {
			 ModelAndView mav= new ModelAndView("home2","list",list1);
			    return mav;
		 }
		 }
		 
		 
		 @RequestMapping("/productDetails")
			public ModelAndView productDetails(HttpServletRequest request, HttpServletResponse response, @RequestParam("productId") int productId,HttpSession session, ProductInfo info, ArrayList<ProductInfo> list ) throws Exception
		 {
		
		 boolean status1=new retriveProductInfo().demo(info, list, session);
		 if(status1)
		 {
			 System.out.println("line1");
			
				
				
			 int id=0;
			 for(ProductInfo pi : list){
				 System.out.println("line1");
					if (pi.getProductId() == productId) {
						System.out.println("line1");
						 id=productId;
						String image= pi.getBase64Image();
						session.setAttribute("image", image);
						session.setAttribute("productid", id);
					}
				}
				
				int productId1=  (Integer) session.getAttribute("productid");
				System.out.println("line1");
				
				//blob1 = prodinfo.getBase64Image();
				
				System.out.println(id);

				ModelAndView modelAndView = new ModelAndView("item","productId", productId1);
				System.out.println("line1");
				
				//ModelAndView modelAndView = new ModelAndView("item","base64Image", blob1);
				return modelAndView;
		 }
		 else
		 {
			 ModelAndView modelAndView = new ModelAndView("index");
				return modelAndView;
		 }
	
			}

		
		 
		 
		 
		 @RequestMapping("/OnGender")
			public ModelAndView OnGender(@RequestParam("type") String type,HttpSession session, ProductInfo info, ArrayList<ProductInfo> list ) throws Exception
		 {
			 System.out.println("based on gender"+type);
			 boolean status=new retriveProductInfo().iteamsBasedOnGender(type, list, info,session);
			 if(status)
			 {
				 
				
				
				 System.out.println("log controller1");
				 System.out.println("list of itemas are : "+list);
				
				 ModelAndView mav= new ModelAndView("BasedOnGender","list",list);
		    return mav; 
			 }
			 else
			 {
				 System.out.println("home unssecussefull ");
				 ModelAndView mav= new ModelAndView("index");
				    return mav;
			 }
		 
		 }
		 
		
		
		
		 @RequestMapping(value="/addCart", method=RequestMethod.POST)
		 public ModelAndView addcart(@RequestParam("productIdFromUser") int productIdFromUser, String userId)
			{
				System.out.println("well come to registration controller");
				boolean status = new CartItemStatusClass().cartStatus(productIdFromUser,userId);

				if(status)
				{
					String msg = "Registration Successful";
					ModelAndView modelAndView = new ModelAndView("index", "identi", msg);
					
					return modelAndView;
				}
				return null;
				
				
			}
		 
		
				 
		
		/* @RequestMapping(value="/particularIteam",params="action1",method=RequestMethod.POST)
		    public void action1(HttpSession session)
		    {
			 int userId=(Integer) session.getAttribute("userId");
		        System.out.println("Action1 block called");
		    }
		 
		 */
		 
		 @RequestMapping("/buy")
		 public ModelAndView buy(@RequestParam("productId") int productIdFromUser,HttpSession session, ArrayList<ProductInfo> list ) throws Exception
		 {
			String email= (String) session.getAttribute("email");
			 System.out.println("by now"+productIdFromUser+","+email);
			 System.out.println("well come to registration controller");
				boolean status = new CartItemStatusClass().cartStatus(productIdFromUser,email);

				if(status)
				{
					String msg = "Successful iteam added in cart";
					ModelAndView modelAndView = new ModelAndView("index", "msg", msg);
					
					return modelAndView;
				}
				return null;		 }
		 
		 @RequestMapping("/purches")
		 public ModelAndView purches(@RequestParam("productId") int productIdFromUser,HttpSession session, ArrayList<ProductInfo> list ) throws Exception
		 {
			String email= (String) session.getAttribute("email");
			 System.out.println("by now"+productIdFromUser+","+email);
			 System.out.println("well come to registration controller");
				boolean status = new BookNowClass().purches(productIdFromUser, email);

				if(status)
				{
					String msg = "Successful book you are iteam ";
					ModelAndView modelAndView = new ModelAndView("index", "msg", msg);
					
					return modelAndView;
				}
				return null;		 }
		 
				 
}
