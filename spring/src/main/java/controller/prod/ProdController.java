package controller.prod;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import command.ProductCommand;
import service.product.ProductAutoNumberService;
import service.product.ProductJoinService;
@Controller
@RequestMapping("prod")
public class ProdController {
	@Autowired ProductAutoNumberService productAutoNumberService;
		@RequestMapping("prodList")
		public String ProdList()
		{
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