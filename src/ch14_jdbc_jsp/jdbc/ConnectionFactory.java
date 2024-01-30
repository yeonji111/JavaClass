package ch14_jdbc_jsp.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// DB 연결 정보 (설정파일로부터 읽어옴)
// DB와 연결된 Connection를 생성해주는 메소드
public class ConnectionFactory {
    public int getMaxConn() {
        return maxConn;
    }

    private String url;
    private String id;
    private String pw;
    private int maxConn; /* 미리 연결지어놓을 Connection 객체의 개수 */


    private ConnectionFactory(){ // 기본 생성자 안에서 드라이버 로드 실행 (드라이버는 1회 실행하면 되는데,
                                 // 메소드에 넣으면 메소드 사용할때마다 로드하므로)

        // .properties 파일을 읽을 수 있는 객체 생성
        Properties prop = new Properties();

        // config 폴더 내 context-db.properties 파일을 읽어오기(텍스트)
        InputStream input = getClass().getClassLoader().getResourceAsStream("config/context-db.properties");

        // input의 텍스트 내용을 기반으로 Key = Value 쌍의 데이터를
        // 사용할 수 있도록 세팅
        try {
            prop.load(input);

            System.out.println(prop.getProperty("driver"));

            String driver = prop.getProperty("driver");
            Class.forName(driver);
            System.out.println("드라이버 로드 성공");

            System.out.println(prop.getProperty("url"));
            this.url = prop.getProperty("url");

            System.out.println(prop.getProperty("id"));
            this.id = prop.getProperty("id");

            System.out.println(prop.getProperty("pw"));
            this.pw = prop.getProperty("pw");

            System.out.println(prop.getProperty("maxConn"));
            this.maxConn = Integer.parseInt(prop.getProperty("maxConn"));


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
            System.exit(0); // 프로그램 종료
        }

    }

    private static ConnectionFactory instance = new ConnectionFactory();

    public static ConnectionFactory getInstance(){
        return instance;
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@nextit.or.kr:1521:xe";
        String id = "std115";
        String pw = "oracle21c";

        return DriverManager.getConnection(url, id, pw); // getConnection 메소드를 꺼내는 쪽에서 try~catch구문 사용하도록



    }


}
