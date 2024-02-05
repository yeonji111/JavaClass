package ch15_stream;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FileBasic {

    public static void main(String[] args) {
        // 현재 디렉토리의 경로 가져오기
        String path = System.getProperty("user.dir");
        System.out.println(path);

        // 경로는 어지간하면 직접 적는 게 아니라 메소드 등을 통해 불러오는 형태를 취함
        // String hardCode = "C:\\Users\\user\\IdeaProjects\\JavaStudy";

        // JavaStudy 내 src 폴더를 자바 단의 File 객체로 불러오기
//        File src = new File("C:\\Users\\user\\IdeaProjects\\JavaStudy\\src"); -- 주소를 직접 입력하는 하드코딩은 지양해야하므로
        File src = new File(path + "\\src"); // path 메소드에 문자열 "\\src" 추가, \\ 는 이스케이프 문자라서 두개
        // 해당 File 객체가 바라보고 있는 파일의 풀경로가 출력됨
        // 여기서 말하는 파일은 폴더도 해당됨
        System.out.println(src);

        // 해당 파일이 폴더인지 확인 , 폴더면 true, 파일이면 false 출력
        // .isDirectory()
        System.out.println(src.isDirectory());

        // 해당 파일이 폴더라면
        // 폴더 내에 있는 파일들의 목록을 배열로 꺼내기
        // .listFiles()
        File[] fileArray = src.listFiles();
        System.out.println(fileArray); // [] 배열이므로 메모리 힙주소를 출력

        for (int i = 0; i < fileArray.length; i++){ // 배열을 for문을 돌려서 데이터 모두 출력
            System.out.println(fileArray[i]); // 풀경로(파일의 주소)
            System.out.println(fileArray[i].getName()); // 파일명만 출력
        }

        // ch01_start 폴더
        System.out.println(fileArray[1]);

        // ch_01 start\HelloWorld.java 가져오기
        File helloWorld = new File(fileArray[1] + "\\HelloWorld.java");
        System.out.println(helloWorld);
        System.out.println(helloWorld.getName());

        // 존재하지 않는 경로의 파일명에 대해서도 File 객체는 만들어진다.
        File faker = new File(fileArray[1] + "\\faker.java");
        System.out.println(faker);

        // File 객체가 실제로 존재하는 파일을 가르키고 있는지 확인
        // .exists()
        System.out.println(helloWorld.exists());    // true
        System.out.println(faker.exists());         // false

        // 실제 파일에 대한 정보 보기
        // .length() 파일 크기 리턴(byte)
        // 1kb = 1024 byte
        // 1mb = 1024 kb
        // 1gb = 1024 mb
        // 1tb = 1024 gb

        System.out.println(helloWorld.length());

        // .lastModified() 마지막 수정 날짜
        System.out.println(helloWorld.lastModified()); // date 타입으로 리턴 1702884862699
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
        System.out.println(sdf.format(helloWorld.lastModified()));

        // 존재하지 않는 파일을 생성하기
        // 실제로 해당 경로에 파일이 생성됨
        // .createNewFile()
        try {
            if (!faker.exists()){
            faker.createNewFile(); // 파이썬같은 경우에는 에러를 일으키므로 조건문 추가해준다.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // File 객체를 통해 폴더 만들기
        // src\\files 폴더 만들기
        // .mkdir()
        File folder = new File(path + "\\src\\files");
        folder.mkdir();

        System.out.println("\n============================\n");

        ArrayList<String> stuList = new ArrayList<>();

        stuList.add("태완");
        stuList.add("정현");
        stuList.add("건희");
        stuList.add("용석");
        stuList.add("성구");
        stuList.add("승환");
        stuList.add("미승");
        stuList.add("의철");
        stuList.add("연지");
        stuList.add("형구");

        // src\\files 폴더 내부에
        // 각 학생들 이름으로 구성된 폴더를 만들어보기
        for (int i = 0; i < stuList.size(); i++){
            File fold = new File(path + "\\src\\files\\"+stuList.get(i));
            fold.mkdir();
        }


        // 각 학생들 폴더 내부에 id.txt 파일을 하나씩 추가하기

        // 선생님 버전) 조금 더 복잡한 버전
        File[] stuArray = folder.listFiles();
        for (int i = 0; i < stuArray.length; i++){
            File temp = new File(stuArray[i] + "\\id.txt");
            try {
                if (!temp.exists())
                temp.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 내 버전) 반복문 돌려서 경로에 냅다 때려박아
//        for (int i = 0; i < stuList.size(); i++){
//            File student = new File( path + "\\src\\files\\"+stuList.get(i)+ "\\id.txt");
//            try {
//                if (!student.exists())
//                student.createNewFile(); // 파이썬같은 경우에는 에러를 일으키므로 조건문 추가해준다.
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }












    }
}
