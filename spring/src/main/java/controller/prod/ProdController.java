package controller.prod;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.ProductCommand;
import service.product.CartAddService;
import service.product.CartListService;
import service.product.ProductAutoNumberService;
import service.product.ProductDeleteService;
import service.product.ProductInfoService;
import service.product.ProductJoinService;
import service.product.ProductListService;
import service.product.ProductModifyService;
@Controller
@RequestMapping("prod")
public class ProdController {
	@Autowired ProductAutoNumberService productAutoNumberService;
	@Autowired ProductListService productListService;
	@Autowired ProductInfoService productInfoService;
	@Autowired ProductModifyService productModifyService;
	@Autowired ProductDeleteService productDeleteService;
	@Autowired CartAddService cartAddService;
	@Autowired CartListService cartListService;
		@RequestMapping("cartAdd")
		public String cartAdd(@RequestParam(value="prodNo") String prodNo,
			@RequestParam(value="cartQty") String cartQty,
			@RequestParam(value="prodPrice") String prodPrice,
			@RequestParam(value="catNum") String catNum,
			Model model,HttpSession session)
		{	cartAddService.cartAdd(prodNo, cartQty, prodPrice, catNum,session);
			return "redirect:cartList";
		}
		@RequestMapping("cartList")
		public String cartList(HttpSession session,Model model)
		{	cartListService.cartList(session,model);
			return "product/cartList";
		}
		@RequestMapping("prodInfo")
		public String prodInfo(@RequestParam(value="prodNo") String prodNo, Model model)
		{	productInfoService.prodInfo(model,prodNo);
			return "product/prodInfo";
		}
		@RequestMapping("prodDel")
		public String prodDel(@RequestParam(value="prodNo")String prodNo,
								HttpSession session)
		{	productDeleteService.prodDel(prodNo,session);
			return "redirect:prodList";
		}
		@RequestMapping(value="prodModifyOk",method=RequestMethod.POST)
		public String prodModifyOk(ProductCommand productCommand)
		{	productModifyService.prodUpdate(productCommand);
			return "redirect:prodList";
		}
		@RequestMapping("prodUpdate")
		public String prodUpdate(@RequestParam(value="prodNo")String prodNo,Model model)
		{	productInfoService.prodInfo(model,prodNo);
			return "product/prodModify";
		}
		@RequestMapping("prodList")
		public String ProdList(Model model)
		{	productListService.prodList(model);
			return "product/productList";
		}
		
		@RequestMapping("prodJoin")
		public String prodJoin(Model model)
		{	productAutoNumberService.autoNum(model);
			return "product/productForm";//join했을때 상품페이지로 가야하므로 주소가 옴
		}
		@Autowired ProductJoinService productJoinService;
		@RequestMapping("prodJoinOk")
		public String prodJoinOk(ProductCommand productCommand, HttpSession session)
		{	productJoinService.prodJoin(productCommand,session);
			return"redirect:prodList";
		}
		
		
		
}