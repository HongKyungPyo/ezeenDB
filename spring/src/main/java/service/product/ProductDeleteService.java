package service.product;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import model.ProductDTO;
import repository.ProductRepository;

public class ProductDeleteService {
	@Autowired ProductRepository productRepository;
	public void prodDel(String prodNo,HttpSession session)
	{	ProductDTO dto=productRepository.prodInfo(prodNo);
		String [ ] files=dto.getProdImage().split(",");
		String path="WEB-INF/view/product/upload";
		String realPath=session.getServletContext().getRealPath(path);
		System.out.println(realPath);
		if(files.length>0)
		{	for(String fileName : files)
			{	//파일 경로 가져오기
				String filePath=realPath+"/"+fileName;
				
				//파일 객체생성
				File f=new File(filePath);
				
				//파일 삭제
				if(f.exists()) f.delete();			
			}//for
		productRepository.prodDel(prodNo);
		}//if
	}
}
