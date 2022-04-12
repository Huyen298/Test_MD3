package dao;

import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO{
    public ProductDAO() {
    }
    protected Connection getConnection(){
        Connection connection =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/product",
                    "root",
                    "Huyen2002@123"
            );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insert(Product product) throws SQLException {

    }

    @Override
    public Product selectByID(int id) {
        Product product = null;
        Category category = null;
        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("select product.id as id,product.name as name,product.price as price,product.quality as quality,product.color as color,product.category_id,c.category as category from product join product.category c on c.id = product.category_id where id=?;")
                ){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quality = resultSet.getInt("quality");
                String color = resultSet.getString("color");
                int category_id = resultSet.getInt("category_id");
                String category1 = resultSet.getString("category");
                category = new Category(category_id,category1);
                product = new Product(id,name,price,quality,color,category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;

    }

    @Override
    public List<Product> selectAll() {
        List<Product> products = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select product.id as id,product.name as name,product.price as price,product.quality as quality,product.color as color,product.category_id,c.category as category from product join product.category c on c.id = product.category_id;")
        ) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quality = resultSet.getInt("quality");
                String color = resultSet.getString("color");
                int category_id = resultSet.getInt("category_id");
                String category = resultSet.getString("category");
                Category category1 = new Category(category_id,category);
                Product product = new Product(id,name,price,quality,color,category1);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        return false;
    }
}
