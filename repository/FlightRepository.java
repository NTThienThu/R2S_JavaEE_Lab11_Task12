package repository;

import entity.Certification;
import entity.Flight;
import util.ConnectDBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FlightRepository {
    private Connection connection;

    public FlightRepository() throws Exception {
        connection = ConnectDBUtil.openConnection();
    }

    public List<Flight> getListFlight() throws Exception {
        String sql = "SELECT MaCB,GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi FROM chuyenbay";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Flight> flights = new ArrayList();
            Flight flight;
            while (resultSet.next()) {
                flight = new Flight();

                flight.setId(resultSet.getString(1));
                flight.setFrom(resultSet.getString(2));
                flight.setTo(resultSet.getString(3));
                flight.setLengthFlight(resultSet.getInt(4));
                flight.setOurGo(resultSet.getTime(5));
                flight.setOurCome(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));

                flights.add(flight);
            }
            return flights;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return null;
    }

    //1.	Cho biết các chuyến bay đi Đà Lạt (DAD).
    public List<Flight> request1() throws SQLException {
        String sql = "SELECT MaCB,GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi FROM chuyenbay WHERE GaDen='DAD'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Flight> flights = new ArrayList();
            Flight flight;
            while (resultSet.next()) {
                flight = new Flight();

                flight.setId(resultSet.getString(1));
                flight.setFrom(resultSet.getString(2));
                flight.setTo(resultSet.getString(3));
                flight.setLengthFlight(resultSet.getInt(4));
                flight.setOurGo(resultSet.getTime(5));
                flight.setOurCome(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));

                flights.add(flight);
            }
            return flights;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return null;
    }

    //4. Cho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km.
    public List<Flight> request4() throws SQLException {
        String sql = "SELECT MaCB,GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi FROM chuyenbay WHERE DoDai>8000 AND DoDai<10000";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Flight> flights = new ArrayList();
            Flight flight;
            while (resultSet.next()) {
                flight = new Flight();

                flight.setId(resultSet.getString(1));
                flight.setFrom(resultSet.getString(2));
                flight.setTo(resultSet.getString(3));
                flight.setLengthFlight(resultSet.getInt(4));
                flight.setOurGo(resultSet.getTime(5));
                flight.setOurCome(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));

                flights.add(flight);
            }
            return flights;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return null;
    }

    //5. Cho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).
    public List<Flight> request5() throws SQLException {
        String sql = "SELECT MaCB,GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi FROM chuyenbay WHERE GaDi='SGN' AND GaDen='BMV'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Flight> flights = new ArrayList();
            Flight flight;
            while (resultSet.next()) {
                flight = new Flight();

                flight.setId(resultSet.getString(1));
                flight.setFrom(resultSet.getString(2));
                flight.setTo(resultSet.getString(3));
                flight.setLengthFlight(resultSet.getInt(4));
                flight.setOurGo(resultSet.getTime(5));
                flight.setOurCome(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));

                flights.add(flight);
            }
            return flights;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return null;
    }


    //14.Cho biết các chuyến bay có thể ñược thực hiện bởi máy bay Airbus A320.
    public List<Flight> request14() throws Exception {
        String sql = "SELECT MaCB,GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi FROM chuyenbay WHERE DoDai < \n" +
                "(SELECT TamBay FROM maybay WHERE Loai = 'Airbus A320')";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Flight> flights = new ArrayList();
            Flight flight;
            while (resultSet.next()) {
                flight = new Flight();

                flight.setId(resultSet.getString(1));
                flight.setFrom(resultSet.getString(2));
                flight.setTo(resultSet.getString(3));
                flight.setLengthFlight(resultSet.getInt(4));
                flight.setOurGo(resultSet.getTime(5));
                flight.setOurCome(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));

                flights.add(flight);
            }
            return flights;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return null;
    }

    //--17.	Giả sử một hành khách muốn đi thẳng từ ga A đến ga B rồi quay trở về ga A.
    // Cho biết các đường bay nào có thể đáp ứng yêu cầu này.


    public void request17() throws Exception {
        String sql = " SELECT chuyenbay.GaDi, chuyenbay.GaDen  FROM chuyenbay as chuyenbay JOIN chuyenbay as cb \n" +
                "ON chuyenbay.GaDi = cb.GaDen AND chuyenbay.GaDen = cb.GaDi";

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

    //--18. Với mỗi ga có chuyến bay xuất phát từ đó cho biết có bao nhiêu chuyến bay khởi hành từ ga đó.
    public void request18() throws Exception {
        String sql = " SELECT GaDi, COUNT(MaCB) as sochuyenbay FROM chuyenbay GROUP BY GaDi";
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
    //--19.	Với mỗi ga có chuyến  bay xuất phát từ đó
    // cho biết tổng chi phí phải trả cho phi công lái các chuyến bay khởi hành từ ga đó.

    public void request19() throws Exception {
        String sql = "SELECT GaDi,SUM(ChiPhi) as total FROM chuyenbay GROUP BY GaDi";
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

//--21. Với mỗi địa điểm xuất phát cho biết có bao nhiêu chuyến bay có thể khởi hành trước 12:00.
    public void request20() throws Exception {
        String sql = "SELECT GaDi, COUNT(MaCB) as total_chuyenbay\n" +
                "FROM chuyenbay\n" +
                "WHERE GioDi<'12:00'\n" +
                "GROUP BY GaDi";
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

   // --28.	Tìm các chuyến bay có thể được thực hiện bởi tất cả các loại máy bay Boeing.

    public List<Flight> request28() throws Exception {
        String sql = "SELECT MaCB,GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi FROM chuyenbay WHERE chuyenbay.DoDai <\n" +
                "    (SELECT MAX(maybay.TamBay) FROM maybay\n" +
                "    WHERE maybay.Loai LIKE('%Boeing%'))";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Flight> flights = new ArrayList();
            Flight flight;
            while (resultSet.next()) {
                flight = new Flight();

                flight.setId(resultSet.getString(1));
                flight.setFrom(resultSet.getString(2));
                flight.setTo(resultSet.getString(3));
                flight.setLengthFlight(resultSet.getInt(4));
                flight.setOurGo(resultSet.getTime(5));
                flight.setOurCome(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));

                flights.add(flight);
            }
            return flights;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return null;
    }
}
