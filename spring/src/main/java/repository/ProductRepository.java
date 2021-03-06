package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.CartDTO;
import model.CatDTO;
import model.ProductCartDTO;
import model.ProductDTO;

public class ProductRepository {
	@Autowired SqlSession sqlsession;
	private final String namespace="mappers.productMapper";
	private String statement;
	public void cartQtyDown(CartDTO dto)
	{
		statement=namespace + ".cartQtyDown";
		sqlsession.update(statement,dto);
	}
	public ProductCartDTO cartList(CartDTO dto)
	{
		statement=namespace + ".cartList";
		return sqlsession.selectOne(statement,dto);
	}
	public List<String> memCart(String membId)
	{
		statement=namespace + ".memCart";
		return sqlsession.selectList(statement,membId);
	}
	public void cartAdd(CartDTO dto)
	{
		statement=namespace + ".prodInsert";
		sqlsession.insert(statement,dto);
	}
	public void prodDel(String prodNo)
	{
		statement=namespace + ".prodDelete";
		sqlsession.delete(statement,prodNo);
	}
	public void prodUpdate(ProductDTO dto)
	{
		statement=namespace + ".prodUpdate";
		sqlsession.insert(statement,dto);
	}
	public ProductDTO prodInfo(String prodNo)
	{
		statement=namespace + ".prodInfo";
		return sqlsession.selectOne(statement,prodNo);
	}
	public List<ProductDTO> prodList()
	{
		statement=namespace + ".prodList";
		return sqlsession.selectList(statement);
	}
	public void prodInsert(ProductDTO dto)
	{
		statement=namespace + ".prodInsert";
		sqlsession.insert(statement,dto);
	}
	public List <CatDTO> catList()
	{
		statement=namespace + ".catList";
		return sqlsession.selectList(statement);
	}
	
	public String autoNum()
	{	statement=namespace + ".autoNum";
		return sqlsession.selectOne(statement);
	}
}
