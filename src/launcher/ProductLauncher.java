package launcher;

import dto.Product;

public class ProductLauncher {

    public static final String DB_URL = "jdbc:mysql://db4free.net:3306/lits_cv_java_2";
    public static final String DB_USER = "java_2_user";
    public static final String DB_PASSWORD = "java_2_password";

public static void main(String[] args){
    initializeDriver();
//    selectData();
//
//    Product productToInsert = new Product();
//    insertData(productToInsert);
//    selectData();
//
//    int idValueToUpdate = 11;
//    updateData(idValueToUpdate);
//    selectData();
//
//    deleteData(idValueToUpdate);
//    selectData();
//


}

    public static void initializeDriver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
