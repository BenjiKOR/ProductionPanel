package Inventory;

import java.util.Random;

public class ProdcutionPlan {
    Random random = new Random();
    // 자재재고 가져오기
    MaterialList materialList;
    ModelList modelList = new ModelList();

    InfoMessage infoMessage = new InfoMessage(materialList); // 텍스트 색깔용

    // Values (생산모델 및 생산량 변수 초기화)
    int productionPlan = 3; // 생산모델 3종
    int[] prodcutionQty;
        public ProdcutionPlan(MaterialList materialList) { // 생산량 랜덤값 부여(실무는 생산계획 담당자가 대입)
            this.materialList = materialList;
            this.prodcutionQty = new int[productionPlan];
            setRandomQty();
        }

    public void setRandomQty() { // 50-100까지 생산량 랜덤 초기화
        for (int i = 0; i < prodcutionQty.length; i++) {
            int randomNum = random.nextInt((51)) + 50;
            prodcutionQty[i] = randomNum;
        }
    }

    // 오늘의 생산계획
    public void todayPlan() { // i. 모델명 | 생산량 | 필요한 자재개수(생산량-보유량)
        System.out.println("\n" + infoMessage.green + "[3. 오늘의 생산계획]" + infoMessage.resetText);
        for (int i = 0; i < prodcutionQty.length; i++) {
            System.out.println("————————————————————————————————————————————————————————");
            System.out.print((i + 1) + ". " + modelList.getModelName(i));
            System.out.print(" | 생산계획: " + prodcutionQty[i]);
            if (checkMaterial(i) <= 0) {
                System.out.print(" | 자재현황: " + infoMessage.green + "이상없음" + infoMessage.resetText);
                System.out.print("\n자재: " + infoMessage.green + materialList.qtyMaterial[i] + infoMessage.resetText + "개");
            } else {
                System.out.print(" | 자재현황: " + materialList.getcode(i) + " " + materialList.qtyMaterial[i] + "개");
                System.out.println(infoMessage.red + " *" + checkMaterial(i) + "개 부족*" + infoMessage.resetText);
                System.out.println("T/T " + infoMessage.blue + modelList.getTime(i) + infoMessage.resetText + "초 고려, ");
                System.out.print(infoMessage.blue + materialTimeMin(i) + "분 " + materialTimeSec(i) + "초 안에 자재가 수급돼야 합니다." + infoMessage.resetText);
            }
            System.out.println();
        }
        System.out.println("————————————————————————————————————————————————————————");
    }

    public int checkMaterial(int i) {
        return prodcutionQty[i] - materialList.qtyMaterial[i];
    }

    public int materialTimeMin(int i) {
            return (int) (materialList.qtyMaterial[i] * modelList.getTime(i)) / 60;
    }

    public int materialTimeSec(int i) {
        return (int) (materialList.qtyMaterial[i] * modelList.getTime(i)) % 60;
    }
}
