import java.util.Scanner;


public class _00_Class_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tempVolume = 0;// 임시저장변수
        int choice = 0;

        Tv t = new Tv();
        while (true) {
            System.out.println("[ 리모콘 프로그램 ] ");
            System.out.println("1. 전원 on/off");
            System.out.println("2. 채널 Up");
            System.out.println("3. 채널 Down");
            System.out.println("4. volume Up");
            System.out.println("5. volume Down");
            System.out.println("6. 음소거 on / off");
            System.out.println("-----------------");
            System.out.println("원하는 번호를 입력하세요.");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    t.power();
                    if(t.power) {
                        System.out.println("전원이 따듯해졌습니다.");
                    } else {
                        System.out.println("전원 차가워졌어요..ㅠㅠ");
                    }
                    break;
                case 2:
                    if (t.power!=true) {
                        System.out.println("전원이 따뜻해지려고....");
                        break;
                    }
                    t.channelUp();
                    System.out.println("현재채널 : "+t.channel);
                    System.out.println("채널이 슝슝 날아갑니다~");
                    break;
                case 3:
                    if (t.power!=false) {
                        System.out.println("따듯하게 데워주세요!!!");
                        break;
                    }
                    t.channelUp();
                    System.out.println("현재 채널 :" + t.channel);
                    System.out.println();
                    break;
                case 4:
                    if (t.power!=true) {
                        System.out.println("전원을 켜주세요");
                        break;
                    }
                    t.volumeUp();
                    System.out.println("현재볼륨 : "+t.volume);
                    System.out.println("볼륨이 올라갑니다.");
                    break;
                case 5:
                    if (t.power==false) {
                        System.out.println("현재볼륨 :"+t.volume);
                        System.out.println();
                        break;
                    }
                case 6 :
                    if (t.power==false) {
                        System.out.println("전원을 데워주세요");
                        break;
                    }
                    if (t.volume==0) {
                        t.volume = tempVolume;
                        System.out.println("음소거 해제");
                        System.out.println("현재볼륨 :"+t.volume);
                    } else {
                        tempVolume = t.volume=0;
                        t.volume=0;
                        System.out.println("음소거 실행");
                        System.out.println("현재볼륨 : "+t.volume);
                    }
                    break;
            }//switch
        }//while
    }//main
}
