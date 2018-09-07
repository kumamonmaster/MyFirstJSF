package com.myjsf;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "carsBean")
@RequestScoped
public class CarsBean {

    ArrayList cars;
    Connection connection;
    
    public CarsBean() {
    }

    public ArrayList getCars() {
        cars = new ArrayList();
        open();
        search(cars);
        close();
        return cars;
    }

    public void setCars(ArrayList cars) {
        this.cars = cars;
    }
    
    //DBコネクションオープンのプライベートメソッド
    private void open(){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            //コネクション作成
            connection=(Connection)DriverManager.getConnection("jdbc:derby://localhost:1527/cars","kuma","kuma0715");
        } catch(ClassNotFoundException | SQLException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("データベースオープンエラーです"));
        }
    }

    //DBコネクションクローズのプライベートメソッド
    private void close(){
        try{
            if(connection!=null) {
                connection.close();
            }
        } catch(Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("データベースCLOSEエラーです"));
        }
    }

    //データベース検索
    private ArrayList search(ArrayList data){
        try{
            //テーブルから全てのアイテムを取得する
            try (Statement statement = (Statement) connection.createStatement()) {
                //テーブルから全てのアイテムを取得する
                String sql="SELECT * FROM KUMA.IMPORTCARS";
                try (ResultSet rs = statement.executeQuery(sql)) {
                    while(rs.next()) {
                        String brand=rs.getString("BRAND");
                        String model=rs.getString("MODEL");
                        String color=rs.getString("COLOR");
                        int price=rs.getInt("PRICE");
                        //商品名、価格でPcItemオブジェクト作成、dataへ追加
                        data.add(new Car(brand,model,color,price));
                    }
                }
            }
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("データベース検索エラーです"));
        }
        return data;
    }

    public class Car{
        String brand;
        String model;
        String color;
        int price;
        public Car(String brand,String model,String color,int price){
            this.brand=brand;
            this.model=model;
            this.color=color;
            this.price=price;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
