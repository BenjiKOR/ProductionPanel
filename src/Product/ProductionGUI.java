package Product;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ProductionGUI {
    ProductionPlan productionPlan = new ProductionPlan();
    int planListLength = productionPlan.getPlanLength().toArray().length;

    final int[] i = {0};
    final int[] j = {1};

    private int inputCount = 0;      // 투입수량
    private int assemblyCount = 0; // 조립공정 수량
    private int packingcount = 0; // 포장공정 수량
    private final int objectQty = productionPlan.calculateObjectQty();// 목표 수량
    private int productionCount = 0; // 생산된 수량
    private int resultCount = objectQty - productionCount; // 생산 실적

    private JLabel productionLabel;
    private JLabel resultLabel;
    private JTextArea resultArea;


    public void gui() {
        frameLabel();

        Timer timer = new Timer();
        int interval = 500;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (i[0] >= planListLength) {
                    timer.cancel();
                    return;
                }

                if (j[0] <= productionPlan.getPlannedQty(i[0])) {
                    resultUpdate();
                    productionCount++;
                    resultCount = objectQty - productionCount;
                    productionCountUpdate();
                    resultCountUpdate();
                    j[0]++;
                } else if (j[0] > productionPlan.getPlannedQty(i[0])) {
                    j[0] = 1;
                    i[0]++;
                }

            }
        }, 0, interval);
    }

    private void resultUpdate() {
        resultArea.append(getTimestamp() + productionPlan.getModelSerialNum(i[0]) + "생산 완료\n");
    }

    private void productionCountUpdate() {
        productionLabel.setText("생산수량: " + productionCount);
    }

    private void resultCountUpdate() {
        resultLabel.setText("남은수량: " + resultCount);
    }


    private void frameLabel() {
        // JFrame 설정
        JFrame frame = new JFrame("생산 현황 시스템");
        frame.setSize(500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // 수량 표시 라벨
        JLabel qtyLabel = new JLabel("[공정별 현황]", SwingConstants.LEFT);
        qtyLabel.setBounds(50, 30, 400, 30);
        qtyLabel.setFont(FontSet.bold);

        JLabel inputLabel = new JLabel("투입 수량: " + inputCount);
        inputLabel.setBounds(50, 50, 200, 30);

        JLabel assemblyLabel = new JLabel("조립 공정 수량: " + assemblyCount);
        assemblyLabel.setBounds(50, 70, 200, 30);

        productionLabel = new JLabel("생산완료 수량: " + productionCount);
        productionLabel.setBounds(50, 90, 200, 30);

        JLabel objectLabel = new JLabel("목표수량: " + objectQty);
        objectLabel.setBounds(50, 110, 200, 30);

        resultLabel = new JLabel("남은수량: " + resultCount);
        resultLabel.setBounds(50, 130, 200, 30);

        // 실적log
        JLabel resultLogLabel = new JLabel("[생산현황]", SwingConstants.LEFT);
        resultLogLabel.setBounds(50, 170, 400, 30);
        resultLogLabel.setFont(FontSet.bold);

        resultArea = new JTextArea();
        resultArea.setBounds(50, 200, 400, 200);
        resultArea.setEditable(false);
        JScrollPane resultScroll = new JScrollPane(resultArea);
        resultScroll.setBounds(50, 200, 400, 200);

        JLabel productionPlanLabel = new JLabel("[금일 생산계획]", SwingConstants.LEFT);
        productionPlanLabel.setBounds(50, 400, 400, 30);
        productionPlanLabel.setFont(FontSet.bold);
        productionPlan.guiProductionPlan(); // 생산계획 log

        // 구성 요소 추가
        frame.add(qtyLabel);
        frame.add(inputLabel);
        frame.add(assemblyLabel);
        frame.add(productionLabel);
        frame.add(objectLabel);
        frame.add(resultLabel);
        // 생산현황판
        frame.add(resultScroll);
        frame.add(resultLogLabel);
        //생산계획
        frame.add(productionPlanLabel);
        frame.add(productionPlan.planScroll);

        // 창 활성화
        frame.setVisible(true);
    }
        private String getTimestamp () {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss ");
            return sdf.format(new Date());
        }
    }

