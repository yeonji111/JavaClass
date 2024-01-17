package yeonji.game;

import java.util.*;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        HashMap<String, Float> recordMap = new HashMap<>();
        ArrayList<Float> recordList = new ArrayList<Float>();


        Scanner scan = new Scanner(System.in);

        System.out.println("어서오세요. 미니게임에 오신걸 환영합니다.");
        System.out.println();
        System.out.println();

        while (true) {
            System.out.println("원하는 카테고리를 선택해주세요");
            System.out.println("[ 1. 회원 가입 | 2. 로그인 | 3. 2P 게임 플레이 | 4. 기록 다시보기 및 순위 | 5. 로그아웃 ]");
            System.out.print(">>> ");
            int input = Integer.parseInt(scan.nextLine());

            if (input == 1) {
                //  회원가입
                System.out.print("아이디 입력: ");
                String id = scan.nextLine();

                System.out.print("비밀번호 입력: ");
                String pw = scan.nextLine();

                Player user = new Player(id, pw);

                PlayerDB.signUp(user);


            }


            if (input == 2) {
                //  로그인
                System.out.print("아이디 입력: ");
                String id = scan.nextLine();

                System.out.print("비밀번호 입력: ");
                String pw = scan.nextLine();

                Player login = PlayerDB.singIn(id, pw);


                if (login != null) {
                    System.out.println("로그인 성공");

                } else if (login == null) {
                    System.out.println("존재하지 않는 아이디 이거나 비밀번호가 틀립니다.");
                }

            }
            if (input == 3) {
                //  게임 설명
                System.out.println("*******************************************");
                System.out.println();
                System.out.println("게임 설명: ");
                System.out.println("본 게임은 눈을 감고 감으로 10초에 근접한");
                System.out.println("     사람이 이기는 게임입니다 !!");
                System.out.println(" 게임 시작과 종료는 [엔터키]를 입력해주세요 !!");
                System.out.println();
                System.out.println("*******************************************");
                System.out.println();
                System.out.println("플레이어님의 이름을 입력해주세요.");
                System.out.print(">>>   ");
                // 플레이어A 이름 입력받기, 게임 시작& 끝 한세트
                // 플레이어A 기록 정산
                String playerA = scan.nextLine(); /* 플레이어 A */
                System.out.println(playerA + "님 환영합니다.");
                System.out.println();
                System.out.println();
                System.out.println("게임을 시작하려면 [엔터키]를 눌러주세요.");
                System.out.print(">>>> ");
                scan.nextLine();
                System.out.println();
                System.out.println();
                System.out.println(playerA + "님의 기록 측정을 시작합니다.");


                long beforeA = System.currentTimeMillis();

                System.out.println("기록 측정을 중단하고 싶으시면 [엔터키]를 눌러주세요");
                scan.nextLine();
                System.out.println();
                long afterA = System.currentTimeMillis();

                long diffA = afterA - beforeA;
                System.out.println(diffA / 1000.0 + "초 경과했습니다.");


                // 기준이랑 얼마나 차이나는지?
                float resultA = (float) Math.abs(10.000 - (diffA / 1000.0)); //
                System.out.println("===============" + "플레이어 " + playerA + "님의 결과===============");
                System.out.println("10초보다 " + resultA + "초 차이 납니다!!");
                System.out.println("====================================================");
                recordList.add(resultA);

                // 플레이어B 이름 입력받기, 게임 시작 & 끝 한세트
                // 플레이어B 기록 정산

                System.out.println("새로운 플레이어님의 이름을 입력해주세요.");
                System.out.print(">>>   ");
                String playerB = scan.nextLine(); /* 플레이어 B */
                System.out.println(playerB + "님 환영합니다.");
                System.out.println();
                System.out.println();
                System.out.println("게임을 시작하려면 [엔터키]를 눌러주세요.");
                System.out.print(">>>> ");
                scan.nextLine();
                System.out.println();
                System.out.println();
                System.out.println(playerB + "님의 기록 측정을 시작합니다.");


                long beforeB = System.currentTimeMillis();

                System.out.println("기록 측정을 중단하고 싶으시면 [엔터키]를 눌러주세요");
                scan.nextLine();
                System.out.println();
                long afterB = System.currentTimeMillis();

                long diffB = afterB - beforeB;
                System.out.println(diffB / 1000.0 + "초 경과했습니다.");


                // 기준이랑 얼마나 차이나는지?
                float resultB = (float) Math.abs(10.000 - (diffB / 1000.0)); //
                System.out.println("===============" + "플레이어 " + playerB + "님의 결과===============");
                System.out.println("10초보다 " + resultB + "초 차이 납니다!!");
                System.out.println("====================================================");
                recordList.add(resultB);

                // 플레이어 A와 B의 기록 비교 & 대결 결과 출력
                // 결과 출력 메세지를 좀 더 늦게 나오게 하고 싶음(레이싱 게임 수업했던거 참고)
                System.out.println();
                System.out.println();
                Thread.sleep(1500);
                System.out.println("-------------- 결과 -----------------");
                System.out.print(" ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡠⣄⡀⠀⠀⡠⠞⠛⢦⣠⢤⡀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⢠⠏⠀⠀⢱⡀⣸⠁⠀⡴⠋⠀⠀⣹⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡴⠋⠉⢿⢀⡤⠶⣴⠇⣯⠀⣼⠁⠀⢀⡴⠷⣄\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠞⠁⠀⣀⡾⠋⠀⠀⢹⣼⠁⢠⡇⠀⡴⠋⠀⠀⡼\n" +
                        "⠀⠀⠀⠀⢠⠊⠑⢦⠀⡴⠋⢀⣠⠞⠉⠀⠀⠀⣠⣿⠧⣄⡾⠁⡼⠁⣀⣤⠾⡁\n" +
                        "⠀⠀⠀⠀⢸⠀⠀⣨⠟⠁⢠⡞⠁⠀⠀⠀⣠⡾⠛⠁⠀⣿⠃⣰⠃⣴⠋⠀⠀⣷\n" +
                        "⠀⠀⠀⠀⣸⢠⠞⠁⠀⢠⠏⠀⠀⢀⡴⠋⠁⠀⢀⣠⡴⠿⣶⡇⢰⠇⠀⠀⢠⠇\n" +
                        "⠀⠀⠀⢠⢿⠏⠀⠀⠀⠉⠀⠀⣠⠞⠁⠀⡴⠚⠉⠁⠀⢀⡟⠀⣼⠀⠀⠀⢸⠀\n" +
                        "⠀⠀⠀⡾⣼⢀⠀⠀⠀⠀⠀⠈⠉⠀⣠⠞⠁⠀⠀⢀⡴⠋⠙⢼⠃⠀⠀⠀⣸⠀\n" +
                        "⠀⠀⠀⡇⠉⡎⠀⣰⠃⠀⠀⠀⠀⠀⠁⠀⠀⠀⡼⠉⠀⠀⠀⠘⠂⠀⠀⣠⠇⠀\n" +
                        "⠀⠀⠀⡇⢸⠀⣰⠃⠀⡴⠀⠀⠀⠀⠀⠀⣠⠞⠁⠀⠀⠀⠀⠀⠀⣠⠖⠁⠀⠀\n" +
                        "⠀⠀⢸⠁⡏⢠⠃⢀⠞⠀⠀⠀⠀⠀⠀⢸⠁⠀⠀⠀⠀⢀⣠⠖⠋⠁⠀⠀⠀⠀\n" +
                        "⠀⠀⡞⠀⠃⡎⢀⠏⠀⠀⠀⠀⠀⠀⢀⡏⠀⣀⡤⠴⠚⠉⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⡴⢺⠇⠀⠀⠀⠞⠀⠀⠀⠀⠀⠀⢀⡾⠒⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⡇⠘⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⢳⡀⠘⢦⡀⠀⠀⠀⠀⠀⠀⡰⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠳⣄⠀⠙⠲⣤⣀⣠⠴⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠈⠓⠦⣄⣀⡠⠎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
                System.out.println();
                System.out.println();
                System.out.println();
                if (resultA < resultB) { // 플레이어A가 이겼을 경우
                    System.out.println("플레이어 " + playerA + "님의 승리!!");
                } else if (resultA > resultB) {
                    System.out.println("플레이어 " + playerB + "님의 승리!!");// 플레이어B가 이겼을 경우
                }
                System.out.println("------------------------------------");

                // todo 플레이어 A,B의 기록 저장 (recordDB 클래스를 하나 새로 파서..?)
                // <플레이어 이름, 기록> 이 한 세트인 recordMap 생성

                recordMap.put(playerA, resultA);
                recordMap.put(playerB, resultB);

                // System.out.println(recordMap);


            }
            if (input == 4) {
                // todo 랭킹 조회, 기록 조회
                // 유저의 아이디(혹은 입력받은 이름)과 기록을 세트로 저장해서 배열에 저장한 후
                // 배열을 내림차순으로 정렬하고 싶은데
                // 세트로 저장을 어떻게 하는 지 모르겠어서 고민중..
                // HashMap..?
//                HashMap<Object, Object> recordmap = new HashMap<>().clone();
//                System.out.println(recordmap);
//                System.out.println("구현중,,,");

                // recordMap을 돌면서 크기 비교
                Set<Map.Entry<String, Float>> recordSet = recordMap.entrySet();

                // 결과값을 리스트에 담고
                System.out.println();
                System.out.println("***************************");
                System.out.println();
                System.out.println("플레이어의 기록");
                System.out.println(recordMap);
                System.out.println();
                System.out.println("***************************");

                // System.out.println(recordList);
                // 리스트를 정렬한 다음에

                Collections.sort(recordList);
                // 순회하면서 getKey와 recordList의 항목이 일치하는 부분 찾기
                float result = (float) 0.00;

                // Map순회용

                for (Map.Entry<String, Float> entry : recordSet) {
//                    System.out.println(entry);
//                    Collections.sort(entry.getValue());


                    for (int i = 0; i < recordList.size(); i++) { // for문만 반복하고 , while 내부로 들어가지 않고 있음..

                        // 리스트에 담긴 value = recordSet.getKeyValue와 같은 사람을 찾아서 프린트하기?
                        if (Objects.equals(recordList.get(i), entry.getValue())) {
                            System.out.println((i + 1) + "등: " + entry.getKey());
                        }
//                        while (recordList.get(i) == entry.getValue()) {
//                            System.out.println((i + 1) + "등: " + entry.getKey());
//                        }
                    }
                    //    System.out.println(entry.getValue()); --- recordList에 결과값들이 담겼고, entry.getValue랑 데이터값 일치
                }
//                System.out.println(recordList);

                System.out.println("***************************");

            }
            if (input == 5) {
                //로그아웃
                break;
            }

        }
    }
}






