package repository;

import entity.Certification;
import entity.Plane;
import util.ConnectDBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaneRepository {
    private Connection connection;

    public PlaneRepository() throws Exception {
        connection = ConnectDBUtil.openConnection();
    }

    public List<Plane> getListPlane() throws Exception {
        String sql = "SELECT MaMB,Loai,TamBay FROM maybay";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Plane> planes = new ArrayList();
            while (resultSet.next()) {
                Plane plane = new Plane();

                plane.setId(resultSet.getInt(1));
                plane.setType(resultSet.getString(2));
                plane.setFlightRange(resultSet.getInt(3));

                planes.add(plane);
            }
            return planes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //  2.	Cho biết các loại máy bay có tầm bay lớn hơn 10,000km.
    public List<Plane> request2() throws Exception {
        String sql = "SELECT MaMB,Loai,TamBay FROM maybay WHERE TamBay>10000";
        List<Plane> planes = new ArrayList();
        Plane plane;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
                plane = new Plane();
                plane.setId(resultSet.getInt(1));
                plane.setType(resultSet.getString(2));
                plane.setFlightRange(resultSet.getInt(3));

                planes.add(plane);
            }
            return planes;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return null;
    }
    //11.Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.
    public void request11() throws Exception {
        String sql = "SELECT chungnhan.MaMB FROM nhanvien JOIN chungnhan  \n" +
                "ON chungnhan.MaNV= nhanvien.MaNV \n" +
                "WHERE nhanvien.Ten LIKE('%Nguyen%')";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Certification> certifications = new ArrayList();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
    }

    //13. Cho biết các loại máy bay có thể thực hiện chuyến bay VN280.
    public void request13() throws Exception {
        String sql = "SELECT Loai FROM maybay WHERE TamBay >\n" +
                "(SELECT DoDai FROM chuyenbay WHERE MaCB = 'VN280')";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    //--16.	Với mỗi loại máy bay có phi công lái cho biết mã số, loại máy báy và tổng số phi công có thể lái loại máy bay đó.

    public void request16() throws Exception {
        String sql = "    SELECT maybay.MaMB, maybay.Loai,COUNT(chungnhan.MaNV)as total FROM maybay\n" +
                "    INNER JOIN chungnhan\n" +
                "    ON chungnhan.MaMB = maybay.MaMB\n" +
                "    GROUP BY(maybay.MaMB),maybay.Loai";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

}

