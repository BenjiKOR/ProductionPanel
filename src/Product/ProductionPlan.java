package Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ProductionPlan {
    private final List<ProductionEntry> productionEntries; // 생산계획 항목
    private int numberCount = 1; // 생산계획 번호 카운터

    //GUI
    JTextArea logProductionPlan;
    JScrollPane planScroll;

    // 생산계획 입력
    public ProductionPlan() {
        productionEntries = new ArrayList<>();

        // 모델, 생산량 추가
        productionEntries.add(new ProductionEntry(ProductStore.getModel(0), new ProdcutionQty(5)));
        productionEntries.add(new ProductionEntry(ProductStore.getModel(1), new ProdcutionQty(5)));
        productionEntries.add(new ProductionEntry(ProductStore.getModel(2), new ProdcutionQty(5)));
    }

    public List<ProductionEntry> getPlanLength() {
        return productionEntries;
    }

    // 생산계획 총량 계산
    public int calculateObjectQty() {
        int objectlQty = 0;
        for (ProductionEntry productionEntry : productionEntries) {
            objectlQty += productionEntry.getProdcutionQty().getQuantity();
        }
        return objectlQty;
    }

    // 모델명, 시리얼 넘버 출력 - ex. Motor A(MA2025)
    public String getModelSerialNum(int i) {
        return  "모델명: " + productionEntries.get(i).getModel().getName() // 모델명
                + "(" + productionEntries.get(i).getModel().getSerialNum() + ")"; // 시리얼 넘버
    }

    // 생산계획 수량 반환
    public int getPlannedQty(int i) {
        return productionEntries.get(i).getProdcutionQty().getQuantity();
    }

    // 생산계획 log
    public void guiProductionPlan() {
        logProductionPlan = new JTextArea();
        logProductionPlan.setBounds(50, 430, 400, 200);
        logProductionPlan.setEditable(false);

        // 생산계획 출력
        for (ProductionEntry productionEntry : productionEntries) {
            Model model = productionEntry.getModel();
            ProdcutionQty prodcutionQty = productionEntry.getProdcutionQty();

            logProductionPlan.append(numberCount + ". 모델명 : " + model.getName()
                    + "(" + model.getSerialNum() + ")"
                    + " / " + "수량: " + prodcutionQty.getQuantity()
                    + "\n"
            );
            numberCount++; // 생산계획 번호
        }

        planScroll = new JScrollPane(logProductionPlan);
        planScroll.setBounds(50, 430, 400, 200);
    }


}
