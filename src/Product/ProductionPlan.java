package Product;

import javax.swing.*;

public class ProductionPlan {
    static int[] countProduction = {10, 15, 20};
    private int numberCount = 1; // 생산계획 번호 카운터

    JTextArea logProductionPlan;
    JScrollPane planScroll;

    public void guiProductionPlan() { // 생산계획 log
        logProductionPlan = new JTextArea();
        logProductionPlan.setBounds(50, 430, 400, 200);
        logProductionPlan.setEditable(false);
        for (int i : countProduction) {
            logProductionPlan.append(numberCount + ". 모델명 : " + "(추가바람)" + " / 개수: " + i + "\n" );
            numberCount++;
        }

        planScroll = new JScrollPane(logProductionPlan);
        planScroll.setBounds(50, 430, 400, 200);
    }


}
