package book.dao;

import book.bean.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends DAO {
    
    public List<Product> search(String keyword) throws Exception {
        ArrayList<Product> products = new ArrayList<>();
        Connection connection = getConnection();

        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM test.product WHERE name LIKE ?"
        );
        
        statement.setString(1, "%" + keyword + "%");
        ResultSet resultSet = statement.executeQuery();
        
        while (resultSet.next()) {
            Product product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setPrice(resultSet.getInt("price"));
            products.add(product);
        }
        
        statement.close();
        connection.close();
        
        return products;
    }
    
    public int insert(Product product) throws Exception {
        Connection connection = getConnection();

        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO test.product (name, price) VALUES (?, ?)"
        );
        
        statement.setString(1, product.getName());
        statement.setInt(2, product.getPrice());

        int line = statement.executeUpdate();
        
        statement.close();
        connection.close();
        
        return line;
    }
}
