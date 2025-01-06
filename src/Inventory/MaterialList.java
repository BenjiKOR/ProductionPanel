package Inventory;

import java.util.Random;

public class MaterialList {
    Random random = new Random();
    /*
    자재 리스트 클래스
    panelWH = "0EBX11"; // 흰색판넬
    panelBL = "50E291"; // 검정판넬
    panelGY = "FF4920"; // 회색판넬
     */

    // 배열 선언(자재이름, 자재코드)
    String[][] codeName = {
            {"Panel White", "0EBX11"},
            {"Panel Black", "50E291"},
            {"Panel Gray", "FF4920"}
    };

    // 자재수량 Value
    int qtyMaterial[] = new int[codeName.length];// 기존 배열의 길이에 맞게 조정

    // 자재수량 초기값 Setting(실무에서는 기존 보유자재)
    public MaterialList() { // 0-10까지 보유자재 초기화
        for (int i = 0; i < qtyMaterial.length; i++) {
            int randomNum = random.nextInt(11);
            qtyMaterial[i] = randomNum;
        }
    }


    //--메서드--

    //자재이름 메서드
    public String getName(int i) { // 자재이름
        return codeName[i][0];
    }

    //자재코드 메서드
    public String getcode(int i) { // 자재코드
        return codeName[i][1];
    }

    //자재수량추가 메서드
    public void addQty(int i, int qty) {
        qtyMaterial[i] += qty; // Invoice 클래스에서 추가
    }
}
