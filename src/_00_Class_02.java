import java.util.Scanner;
public class _00_Class_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] title = {"이름","국어","영어","수학","합계","평균","등수"};
        String[] name = new String[5];
        String searchName = " ";
        int[][] score = new int[5][4]; //평균은 더블이기에 별도로 뺌
        int choice = 0;
        int count = 0;
        int chk=0;// 존재유무?
        int[] rank = new int[5]; // 등수 저장을 위한 배열 추가
        double[] avg = new double[5];
        loop:while (true) {
            System.out.println("[ 학생성적 저장소양간 ]");
            System.out.println("1.성적입력 2.성적출력 3.성적수정 4.등수수정 5.성적검색 0.처음으로");
            System.out.println("-----------------------------------------------------");
            System.out.println("원하는 번호를 입력");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    for (int i=count; i< name.length; i++) {
                        System.out.println(count+1 + "번째 학생의 이름을 입력하세요.(0.이전페이지 이동)");
                        name[i] = scan.next();

                        if(name[i].equals("0")) {
                            System.out.println("이전                             페이지로 이동");
                            System.out.println();
                            break ;
                        }
                        for (int j=0; j<3; j++) {
                            System.out.println(title[j+1]+ "점수를 입력하세요.");
                            score[i][j] = scan.nextInt();
                        }
                        score[i][3] = score[i][0]+score[i][1]+score[i][2]; // 합계
                        avg[i] = score[i][3] / 3.0;
                        System.out.println((count+1)+"번째 학생성적 등록");
                        System.out.println();
                        count++;
                    }
                    break; // 이 부분이 누락되어 추가하였습니다.
                case 2://성적출력
                    System.out.println(" [ 학생성적 ] ");
                    for (int i=0; i< title.length; i++) {
                        System.out.print(title[i]+"\t");
                    }
                    System.out.println("\n-------------------");
                    for (int i=0; i<count; i++) { // 'name.length'가 아닌 'count'를 사용합니다.
                        System.out.print(name[i]+"\t");
                        for (int j=0; j< score[i].length; j++) {
                            System.out.print(score[i][j]+"\t");
                        }
                        System.out.printf("%.2f\t",avg[i]);
                        System.out.printf("%d\n",rank[i]);
                    }
                    break;
                case 3://성적수정
                    System.out.println("수정할 학생의 이름을 입력하세요");
                    searchName = scan.next();
                    for (int i=0; i<count;i++) {
                        if (name[i].equals(searchName)) {
                            System.out.println("[ 수정할 학생을 찾았습니다. ]");
                            System.out.println("수정할 과목 선택하세요.");
                            System.out.println("1. 국어");
                            System.out.println("2. 영어");
                            System.out.println("3. 수학");
                            System.out.println("------");
                            System.out.println("수정할 과목을 선택하세요.");
                            choice = scan.nextInt();
                            System.out.printf("[현재 %s 점수 : %d ]\n",title[choice],score[i][choice-1]);
                            System.out.println("-------------------------");
                            System.out.println("수정할 점수를 입력하세요.>>");
                            score[i][choice-1]  = scan.nextInt();
                            score[i][3] = score[i][0]+score[i][1]+score[i][2];
                            avg[i] = score[i][3] / 3.0 ;
                            System.out.println("점수가 수정되었습니다.");
                            System.out.println();
                            chk =1;
                            break ;
                        }
                    }
                    if (chk == 0) {
                        System.out.println("해당하는 학생을 찾을 수 없습니다.");
                    }
                    break;
                case 4: // 등수 처리
                    for (int i=0; i<score.length; i++) {
                        rank[i] = 1; // 등수 초기화
                        for (int j=0; j<score.length; j++) {
                            if (score[i][3] < score[j][3]) {
                                rank[i]++; // 다른 학생의 총점이 더 높으면 등수 증가
                            }
                        }
                    }
                    System.out.println("[ 등수 처리가 완료되었습니다. ]");
                    System.out.println();
                    break;
                case 5://학생검색
                    System.out.println("[학생검색]");
                    System.out.println("검색할 학생의 이름을 입력하세요.>>");
                    searchName = scan.next();
                    chk=0;
                    for (int i=0; i< title.length; i++) {
                        System.out.print(title[i]+"\t");
                        System.out.println("\n-------------------");
                    }
                    for (int i=0; i<count; i++) {
                        //홍 -> 홍길동, 홍길순, 홍길자, 홍길구, 김구, 이순신
                        if (name[i].contains(searchName)) { //홍이 한글자라도 들어가면 true 로 해준다?
                            //이름이 출력되도록
                            System.out.print(name[i] + "\t");
                            for (int j = 0; j < score[i].length; j++) {
                                System.out.print(score[i][j] + "\t");
                            }
                            System.out.printf("%.2f\t", avg[i]);
                            System.out.printf("%d\n", rank[i]);
                            chk=1;
                        }//if
                    }//for
                    //검색할 이름이 없는 경우
                    if (chk==0) {
                        System.out.println("[ 찾고자 하는 학생이 없습니다. 다시 입력하세요 ]");
                    }
                    break ;
                case 0:
                    System.out.println(" [ 프로그램 종료 ] ");
                    break loop;
            } //switch 끝
        } //while 끝
    } //main 끝
} //class 끝