package Snail;
import java.util.Scanner;
public class snailArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.printf("Input a number to determine the size of the array (number * number) :");

        while(!sc.hasNextInt()){
            sc.next();
            System.err.printf("That is not number!! \n Input number again :");
        }

        String ArrRule_0 = sc.next();
        ArrRule_0 = ArrRule_0.replaceAll(" ","");
        int ArrRule = Integer.parseInt(ArrRule_0); // 배열에 입력되는 값의 갯수 규칙 변수(+크기지정) ex) 배열 크기(5) 5-4-4-3-3-2-2-1-1

        int printingValue = ArrRule; // 변수 a = 배열 출력시 사용 할 변수

        System.out.println("Check Input : "+ArrRule+"\n"); // ArrRule 값 확인

        //배열 만들기
        int Array[][] = new int[ArrRule][ArrRule]; //입력받은 ArrRule 크기로 2차원 배열 생성

        //변수 생성 및 초기화
        int arrayValue=0; //배열내의 원소 값
        int wave =1;  //행과 열 index 의 증가 및 감소에 필요한 변수 1과 -1 진동
        int R =0;  // 행의 index 변화 값
        int C= -1; // 열의 index 변화 값

        /*전체 틀 반복 while문 */
        while(true) {
            /*열의 반복문 */
            for(int i=0; i < ArrRule; i++) {

                arrayValue +=1; //배열에 들어갈 값 1부터 시작

                C += wave; //열이 wave=1 일때 1씩 증가 , wave=-1일때 1씩 감소

                Array[R][C]=arrayValue; // Array R행 C열에 arrayValue 값 대입

            }// Ending for문

            ArrRule -=1; //2번목적-달팽이 규칙 arrayValue 값을 달팽이 규칙에 맞추기 위한 ArrRule값

            //ArrRule=0 일시 모든 배열에 원소값이 입력되었기에 빠져나감
            if(ArrRule==0) {
                break;
            }//Ending if

            /*행의 반복문*/
            for(int j=0; j < ArrRule; j++) {
                arrayValue +=1; // 위의 열의 반복문 plus_Value 값 을 그대로 받아서 +1씩 증가

                R+=wave; // 행의 index 변화

                Array[R][C] = arrayValue; //배열 R행 C열에 plus_num값 대입
            }//Ending for문

            wave *= (-1); // 행과 열이 감소/증가 가 교대로 진행되기 위한  Wave의 1과 -1 교대
        }// Ending while

        /*배열의 출력문*/
        // ArrRule = 0 이기되었기 때문에  printingValue 를 사용한다.
        for (int k = 0; k < printingValue; k++) { //행의 출력

            for(int l = 0; l < printingValue; l++) { // 열의 출력
                System.out.printf(" %3d ",Array[k][l]); // 행의 출력 변수 k,  열의 출력 변수 l
            }// Ending 열의 for
            System.out.printf("\n"); //줄바꿈
        }//Ending 행의 for
    } // Ending main
} // Ending class