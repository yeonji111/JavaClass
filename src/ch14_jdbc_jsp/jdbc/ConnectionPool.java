package ch14_jdbc_jsp.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

// 미리 Connection 객체들을 생성해서 보관하는 클래스
public class ConnectionPool {

    // Connection 객체들을 보관하는 리스트
    // ArrayList 는 동기화 지원하지 않음
    // Vector 는 동기화를 지원하는 List(= ArrayList 와 사용법이 같음)
    // ArrayList<Connection>pool = new ArrayList<>();
    private Vector<Connection>pool = new Vector<>();

    private ConnectionPool(){
        // ConnectionFactory 로부터 Connection 객체를
        // maxConn 개수만큼 가져와서 pool에 담기
        ConnectionFactory cf = ConnectionFactory.getInstance();


        for (int i = 0; i < cf.getMaxConn(); i++){
            try {
                pool.add(cf.getConnection());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

    private static ConnectionPool instance = new ConnectionPool();

    public static ConnectionPool getInstance() {
        return instance;
    }

    // 쿼리문 사용할때마다 pool 안에 있는 Connection 객체를 가져다 씀
    // pool 안에 있는 Connection 객체 하나를 넘겨주는 메소드
    public synchronized Connection getConnection(){

        // pool에 Connection 객체가 없다면 wait 시키기
        if (pool.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        Connection conn = pool.get(0);
        pool.remove(0);
        return conn;
    }

    // Connection 을 꺼내서 사용 후 반납 받을 수 있는 메소드
    public synchronized void returnConnection(Connection conn){
        pool.add(conn);
        notify(); // getConnection에서 빌릴 수 있는 객체가 없다면 wait 시켰으니 반납이 완료된 후에는 깨우기
                  // 빌려가고 반납하고가 유기적으로 연결되어있어야하므로 synchronized 추가
    }


}
