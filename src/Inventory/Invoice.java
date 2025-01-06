package Inventory;
import java.util.Scanner;

public class Invoice {
    // 자재수령(INVOICE) 클래스
    Scanner scanner = new Scanner(System.in);
    MaterialList materialList;// 자재코드 클래스
    InfoMessage infoMessage = new InfoMessage(materialList);

    public Invoice(MaterialList materialList) {
        this.materialList = materialList;
    }

    // Values
    boolean found = false; // 유효한 자재코드인가?

    String inputCode(String inputCode) { // 자재코드 입력
        // 자재 리스트 클래스에 있는 자재인지 확인
        for (int i = 0; i < materialList.codeName.length; i++) {
            if (inputCode.equals(materialList.getcode(i))) {
                found = true; // 자재코드 확인 완료

                // 맞는 자재인지 질문
                System.out.println("\n" + materialList.getName(i) + " 해당 자재가 맞습니까?");
                System.out.print(infoMessage.blue +"1. 예 " + infoMessage.resetText + " / " + infoMessage.red +  "2. 아니요 " + infoMessage.resetText + "(번호를 입력하세요): ");
                int inputNum = scanner.nextInt();
                scanner.nextLine(); // Buffer 삭제
                switch (inputNum) {
                    case 1:
                        invoiceMaterial(inputCode);
                        break;
                    case 2:
                        System.out.println(infoMessage.green + "초기 메뉴로 돌아갑니다." + infoMessage.resetText);
                        break;
                    default:
                        System.out.println(infoMessage.red + "올바른 값을 입력해주세요." + infoMessage.resetText);
                }
                break;
            }

        }   if (!found) { // 잘못된 자재코드 입력
                System.out.println(infoMessage.red + "잘못된 코드입니다. 다시 입력해주세요." + infoMessage.resetText);
        }
        return inputCode;
    }

    void invoiceMaterial(String inputCode) { // 자재수량 입력(인보이스)
        for (int i = 0; i < materialList.codeName.length; i++) {
            if (inputCode.equals(materialList.getcode(i))) {
                System.out.print( "\n" +materialList.getName(i) + "(" + materialList.getcode(i) + ") 자재 수량을 입력해주세요: ");
                int qty = scanner.nextInt();
                materialList.addQty(i, qty);
                System.out.println("입력수량 : " + infoMessage.green +  qty + infoMessage.resetText + ", 현재수량: " + infoMessage.blue + materialList.qtyMaterial[i] + infoMessage.resetText);
            }
        }
    }
}
