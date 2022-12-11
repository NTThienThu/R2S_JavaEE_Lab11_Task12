package repository;

import entity.Certification;
import entity.Employee;
import util.ConnectDBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private Connection connection;

    public EmployeeRepository() throws Exception {
        connection = ConnectDBUtil.openConnection();
    }

    public List<Employee> getListEmployee() throws Exception {
        String sql = "SELECT MaNV, Ten, Luong FROM nhanvien";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Employee> employees = new ArrayList();
            Employee employee;
            while (resultSet.next()) {
                employee = new Employee();

                employee.setId(resultSet.getString(1));
                employee.setName(resultSet.getString(2));
                employee.setSalary(resultSet.getInt(3));

                employees.add(employee);
            }
            return employees;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return null;
    }

    public void insertEmployee(String id, String name, int salary) throws Exception {
        String sql = "INSERT INTO nhanvien(MaNV, Ten, Luong)\n" +
                "VALUES('" + id + "','" + name + "'," + salary + ")";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //3.Tìm các nhân viên có lương nhỏ hơn 10,000.
    public List<Employee> request3() throws Exception {
        String sql = "SELECT MaNV, Ten, Luong FROM nhanvien WHERE Luong<10000";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Employee> employees = new ArrayList();
            while (resultSet.next()) {
                Employee employee = new Employee();

                employee.setId(resultSet.getString(1));
                employee.setName(resultSet.getString(2));
                employee.setSalary(resultSet.getInt(3));

                employees.add(employee);
            }
            return employees;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //10.Cho biết các nhân viên có thể lái máy bay có mã số 747.
    public List<Employee> request10() throws Exception {
        String sql = "SELECT nhanvien.MaNV, nhanvien.Ten, nhanvien.Luong FROM nhanvien JOIN chungnhan  \n" +
                "ON chungnhan.MaNV= nhanvien.MaNV \n" +
                "WHERE MaMB=747";

        try {
            List<Employee> employees = new ArrayList<>();
            Employee employee;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                employee = new Employee();
                employee.setId(resultSet.getString(1));
                employee.setName(resultSet.getString(2));
                employee.setSalary(resultSet.getInt(3));

                employees.add(employee);
            } return employees;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.close();
        } return null;
    }
    // 12.	Cho biết Mã số của các phi công vừa lái được Boeing vừa lái được Airbus.
    public void request12() throws Exception {
        String sql = "\n" +
                "SELECT nhanvien.MaNV FROM nhanvien WHERE nhanvien.MaNV IN\n" +
                "(SELECT DISTINCT MaNV FROM chungnhan WHERE MaMB IN\n" +
                "(SELECT MaMB FROM maybay WHERE Loai LIKE'%Airbus%'))AND nhanvien.MaNV IN\n" +
                "(SELECT DISTINCT MaNV FROM chungnhan WHERE MaMB IN(SELECT MaMB FROM maybay WHERE Loai LIKE'%Boeing%'))";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Certification> certifications = new ArrayList();
            while (resultSet.next()) {
                System.out.println("Ma nv: "+resultSet.getString(1)+ "\t Ten: "+resultSet.getString(2) );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
    }

    //15.Cho biết tên của các phi công lái máy bay Boeing.
    public void request15() throws Exception {
        String sql = "SELECT DISTINCT nv.Ten FROM NHANVIEN nv JOIN CHUNGNHAN cn\n" +
                "ON nv.MaNV = cn.MaNV \n" +
                "JOIN MAYBAY mb\n" +
                "ON mb.MaMB = cn.MaMB \n" +
                "WHERE mb.Loai LIKE '%Boeing%'";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Certification> certifications = new ArrayList();
            while (resultSet.next()) {
                System.out.println("Ten nv: "+resultSet.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
    }

    //--22.	Cho biết mã số của các phi công chỉ lái được 3 loại máy bay
    public void request22() throws Exception {
        String sql = "SELECT MaNV FROM chungnhan\n" +
                "GROUP BY MaNV\n" +
                "HAVING COUNT(MaMB)=3";

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
    //--23.	Với mỗi phi công có thể lái nhiều hơn 3 loại máy bay,
    //cho biết mã số phi công và tầm bay lớn nhất của các loại máy bay mà phi công đó có thể lái.

    public void request23() throws Exception {
        String sql = "SELECT chungnhan.MaNV , MAX(maybay.TamBay) as MaxTamBay FROM chungnhan INNER JOIN maybay \n" +
                "ON maybay.MaMB = chungnhan.MaMB\n" +
                "GROUP BY(chungnhan.MaNV) \n" +
                "HAVING COUNT(chungnhan.MaMB) > 3";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }

//--24.	Với mỗi phi công cho biết mã số phi công và tổng số loại máy bay mà phi công đó có thể lái.
    public void request24() throws Exception {
        String sql = "    SELECT nhanvien.MaNV,COUNT(chungnhan.MaMB) as total FROM nhanvien LEFT JOIN chungnhan\n" +
                "    ON chungnhan.MaNV=nhanvien.MaNV\n" +
                "    GROUP BY nhanvien.MaNV";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    //--25.	Tìm các nhân viên không phải là phi công.
    public List<Employee> request25() throws Exception {

        String sql = "SELECT MaNV, Ten, Luong FROM nhanvien WHERE nhanvien.MaNV NOT IN\n" +
                "(SELECT chungnhan.MaNV FROM chungnhan\n" +
                "GROUP BY chungnhan.MaNV)";

        try {
            List<Employee> employees = new ArrayList<>();
            Employee employee;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                employee = new Employee();
                employee.setId(resultSet.getString(1));
                employee.setName(resultSet.getString(2));
                employee.setSalary(resultSet.getInt(3));

                employees.add(employee);
            } return employees;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.close();
        } return null;
    }

//--26.	Cho biết mã số của các nhân viên có lương cao nhất.
    public void request26() throws Exception {
        String sql = "SELECT nhanvien.MaNV FROM nhanvien \n" +
                "WHERE Luong = (SELECT MAX(Luong)\n" +
                "                 FROM NHANVIEN);";
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
    //--27.	Cho biết tổng số lương phải trả cho các phi công.

    public void request27() throws Exception {
        String sql = "SELECT Sum(nhanvien.Luong) as total\n" +
                "    FROM nhanvien INNER JOIN chungnhan ON chungnhan.MaNV = nhanvien.MaNV";
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

}
