package Inventory;

public class Inventroy {
    //재고확인 클래스
    MaterialList materialList;
    InfoMessage infoMessage = new InfoMessage(materialList);

    public Inventroy(MaterialList materialList) {
        this.materialList = materialList;
    }

    void inventoryStatus() {
        System.out.println("\n" + infoMessage.green + "[2. 재고확인]" + infoMessage.resetText);
        for (int i = 0; i < materialList.codeName.length; i++) {
            System.out.println((i + 1) + ". " + infoMessage.blue + materialList.getName(i) + infoMessage.resetText + "(코드: " + materialList.getcode(i) + ")" + " 자재 수량: " + infoMessage.green + materialList.qtyMaterial[i] + infoMessage.resetText);
        }

    }
}
