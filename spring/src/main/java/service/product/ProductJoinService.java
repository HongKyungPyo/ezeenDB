package service.product;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import command.ProductCommand;
import model.AuthInfo;
import model.CatDTO;
import model.ProductDTO;
import repository.ProductRepository;

public class ProductJoinService {
	@Autowired ProductRepository productRepository;
	public void prodJoin(ProductCommand productCommand, HttpSession session)
	{
		AuthInfo authInfo=(AuthInfo)session.getAttribute("authInfo");
		String EmpNo=authInfo.getGrade();
		ProductDTO dto=new ProductDTO();
		dto.setCatNum(productCommand.getCatNum());
		dto.setEmpNo(EmpNo);
		dto.setProdInfo(productCommand.getProdInfo());
		dto.setProdName(productCommand.getProdName());
		dto.setProdNo(productCommand.getProdNo());
		dto.setProdPrice(productCommand.getProdPrice());
		//파일처리
		String path="WEB-INF/view/product/upload";
		String filePath=session.getServletContext().getRealPath(path);
		System.out.println(filePath);
		String goodsImage="";
		if(productCommand.getProdImage()!=null)
		{
			for(MultipartFile mf : productCommand.getProdImage())
			{
				String original=mf.getOriginalFilename();
				
				//확장자 가져오기
				String originalExt=
						original.substring(original.lastIndexOf("."));
				String store=
						UUID.randomUUID().toString().replace("-", "")
						+originalExt;
				goodsImage+=store+",";
				
				//파일저장
				File file=new File(filePath+"/"+store);
				try {
					mf.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}//for문
		}//if
		dto.setProdImage(goodsImage);
		productRepository.prodInsert(dto);
	}
}
