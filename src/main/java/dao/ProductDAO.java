package dao;

import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO{

    public static final String SELECT_ALL_PRODUCT = "select product.id as id,product.name as name,product.price as price,product.quality as quality,product.color as color,product.category_id,c.category as category from product join product.category c on c.id = product.category_id ";
    public static final String CREATE_PRODUCT = "insert into product(name, price, quality, color, category_id) value (?,?,?,?,?);";
    public static final String DELETE_PRODUCT = "delete from product where id=?";
    public static final String EDIT_PRODUCT = "update product set name=?, set price=?, set quality=?, set color=?,set category_id=? where id=?";
    public static final String SELECT_PRODUCT_BY_ID = "select product.id as id,product.name as name,product.price as price,product.quality as quality,product.color as color,product.category_id,c.category as category from product join product.category c on c.id = product.category_id where id=?";

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
        System.out.println(CREATE_PRODUCT);
        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT);
                ){
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuality());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setInt(5,product.getCategory().getId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Product selectByID(int id) {
        Product product = null;
        Category category = null;
        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)
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
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(EDIT_PRODUCT);) {
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setInt(3, product.getQuality());
            statement.setString(4,product.getColor());
            statement.setInt(5,product.getCategory().getId());
            statement.setString(6,product.getCategory().getCategory());
            statement.setInt(7, product.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
