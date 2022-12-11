package repository;

import entity.Certification;
import entity.Employee;
import util.ConnectDBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CertificateRepository {
    private Connection connection;

    public CertificateRepository() throws Exception {
        connection = ConnectDBUtil.openConnection();
    }

    public List<Certification> getListCertificate() throws Exception {
        String sql = "SELECT MaNV, MaMB FROM chungnhan";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Certification> certifications = new ArrayList();
            Certification certification;
            while (resultSet.next()) {
                 certification = new Certification();

                certification.setIdE(resultSet.getString(1));
                certification.setIdP(resultSet.getString(2));

                certifications.add(certification);

            }
            return certifications;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return null;
    }
    //9. Cho biết mã số của các phi công lái máy báy Boeing.
    public void request9() throws Exception {
        String sql = "SELECT MaNV FROM chungnhan JOIN maybay ON chungnhan.MaMB= maybay.MaMB WHERE maybay.Loai LIKE('%Boeing%')";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.print(resultSet.getString(1)+"\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
             connection.close();
        }
    }
}
