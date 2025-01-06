package Inventory;

public class InvoiceMain {

    public static void main(String[] args) {
        MaterialList materialList = new MaterialList(); // 자재 리스트 공통 객체로 사용하기
        InfoMessage infoMessage = new InfoMessage(materialList); // 입력 안내문 클래스
        Invoice invoice = new Invoice(materialList); // 자재수령 클래스
        Inventroy inventroy = new Inventroy(materialList); // 재고확인 클래스
//        ProdcutionPlan prodcutionPlan = new ProdcutionPlan(materialList); // 생산계획 클래스


        while (true) {
            int optionNum = infoMessage.infoMessage();// 메뉴 입력 메시지(1. 자재수령, 2. 재고확인, 3. 종료)
            switch (optionNum) {
                case 1:
                    String inputCode = infoMessage.materialInfo(); // 자재 목록 메시지
                    invoice.inputCode(inputCode); // 자재코드 입력
                    break;
                case 2:
                    inventroy.inventoryStatus();
                    break;
                case 3:
//                    prodcutionPlan.todayPlan();
                    break;
                case 4:
                    System.out.println(infoMessage.red + "프로그램을 종료합니다." + infoMessage.resetText);
                    return;
                default:
                    System.out.println(infoMessage.red + "올바르지 않은 입력값입니다." + infoMessage.resetText);
            }
        }
    }
}
