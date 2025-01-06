package Inventory;
import java.util.Scanner;

public class InfoMessage {
    //폰트색상
    String resetText = "\u001B[0m";
    String red = "\u001B[31m";
    String green = "\u001B[32m";
    String blue = "\u001B[34m";

    // 메시지 클래스
    Scanner scanner = new Scanner(System.in);
    MaterialList materialList; // 자재 리스트 클래스
    int inputNum;

    public InfoMessage(MaterialList materialList) {
        this.materialList = materialList;
    }

    int infoMessage() { // 메뉴 선택 메시지
        System.out.println("\n= 자재수령 및 재고확인 System =");
        System.out.println("1. 자재수령(INVOICE) | 2. 재고확인 | 3. 오늘의 생산계획 | 4. 종료");
        System.out.print("원하시는 번호를 입력해주세요: "); // 1. 자재수령, 2. 재고확인, 3. 오늘의 생산계획, 4. 종료
        inputNum = scanner.nextInt();
        scanner.nextLine(); // Buffer 삭제
        return inputNum;
    }

    String materialInfo() { // 1. 자재수령(INVOICE)
        // Input Material
        System.out.println("\n" + green + "[1. 자재수령]" + resetText);
        System.out.println("=== Material List ===");
        for (int i = 0; i < materialList.codeName.length; i++) {
            System.out.println((i + 1) + ". 자재명: " + materialList.getName(i) + "(코드: " + materialList.getcode(i) + ")");
        }
        System.out.println("=====================");
        System.out.print("자재코드를 입력해주세요: ");
        String inputCode = scanner.nextLine();
        return inputCode;
    }


}
