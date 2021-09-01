package JDBC;

import java.sql.SQLException;
import java.util.ArrayList;

public class SqlControl {
    SqlUser sqlUser = new SqlUser("CTDC");

    public ArrayList getPword(String uname) throws SQLException, ClassNotFoundException {
        if(uname.substring(0,2).equals("yg"))
            return sqlUser.search("select PASSWORD from WorkerView where STAFF_NO='"+uname+"';");
        if(uname.substring(0,2).equals("yh"))
            return sqlUser.search("select PASSWORD from UserView where USE_ID='"+uname+"';");
        else {
            ArrayList data = new ArrayList();
            data.add("error");
            return data;
        }
    }

    public ArrayList getMenu() throws SQLException, ClassNotFoundException {
        ArrayList data = sqlUser.search("select * from 菜品表;");
        ArrayList data1 = new ArrayList();
        ArrayList temp = new ArrayList();
        int range = 2;
        for(int i=0;i<data.size();i++){
            temp.add(data.get(i));
            if(i % range == 0 && i>0) {
                data1.add(temp);
                temp = new ArrayList();
                range = range + 3;
            }
        }
        return data1;
    }

    public void addOrder(String use_id,String dish_no) throws SQLException, ClassNotFoundException {
        ArrayList price = (ArrayList) sqlUser.search("select PRICE from 菜品表 where DISH_NO ='"+dish_no+"';");
        String price1 = (String) price.get(0);
        sqlUser.insert("call addOrder('"+use_id+"','"+dish_no+"','"+price1+"');");
    }

    public ArrayList UserOrders(String use_id) throws SQLException, ClassNotFoundException {
        ArrayList data = sqlUser.search("select 订单表.DISH_NO,DIAH_NAME,USE_ID,MONEY_TO from 订单表 join 菜品表 on 菜品表.DISH_NO=订单表.DISH_NO where USE_ID='"+use_id+"' ;");
        ArrayList data1 = new ArrayList();
        ArrayList temp = new ArrayList();
        int range = 3;
        for(int i=0;i<data.size();i++){
            temp.add(data.get(i));
            if(i % range == 0 && i>0) {
                data1.add(temp);
                temp = new ArrayList();
                range = range + 4;
            }
        }
        return data1;
    }

    public ArrayList WorkerOrders( ) throws SQLException, ClassNotFoundException {
        ArrayList data = sqlUser.search("select 订单表.DISH_NO,DIAH_NAME,USE_ID,MONEY_TO from 订单表 join 菜品表 on 菜品表.DISH_NO=订单表.DISH_NO  ;");
        ArrayList data1 = new ArrayList();
        ArrayList temp = new ArrayList();
        int range = 3;
        for(int i=0;i<data.size();i++){
            temp.add(data.get(i));
            if(i % range == 0 && i>0) {
                data1.add(temp);
                temp = new ArrayList();
                range = range + 4;
            }
        }
        return data1;
    }

    public ArrayList getSelectedMenu(String dish_name) throws SQLException, ClassNotFoundException {
        ArrayList data = sqlUser.search("select * from 菜品表 where DIAH_NAME = '"+dish_name+"';");
        ArrayList data1 = new ArrayList();
        ArrayList temp = new ArrayList();
        int range = 2;
        for(int i=0;i<data.size();i++){
            temp.add(data.get(i));
            if(i % range == 0 && i>0) {
                data1.add(temp);
                temp = new ArrayList();
                range = range + 3;
            }
        }
        return data1;
    }

    public ArrayList addDish(String dish_id, String dish_name,String price) throws SQLException, ClassNotFoundException {
        ArrayList data = new ArrayList();
        data = sqlUser.search("call addDish('"+dish_id+"','"+dish_name+"','"+price+"');");
        return data;
    }

    public void deleteDish(String dish_no) throws SQLException, ClassNotFoundException {
        sqlUser.delete("delete from 菜品表 where DISH_NO='"+dish_no+"';");
    }

    public void SwitchPrice(String dish_no,String price) throws SQLException, ClassNotFoundException {
        sqlUser.update("update 菜品表 set PRICE='"+price+"' where DISH_NO='"+dish_no+"';");
    }

    public void AddNewUser(String user_id,String user_name,String pword,String phone) throws SQLException, ClassNotFoundException {
        sqlUser.insert("insert into 用户表 values('"+user_id+"','"+user_name+"','"+phone+"','"+pword+"');");
    }
}

