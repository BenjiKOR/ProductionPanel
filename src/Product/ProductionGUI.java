package Product;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ProductionGUI {
    Font boldFont = new Font(Font.SANS_SERIF, Font.BOLD, 14);
    private int productionCount = 0; // 생산된 수량
    private int inputCount = 0;      // 투입수량
    private int assemblyCount = 0; // 조립공정 수량
    private int objectCount = ProductionPlan.countProduction[0]; // 목표 수량
    private int resultCount = objectCount - productionCount; // 생산 실적

    private JLabel productionLabel;
    private JLabel resultLabel;
    private JTextArea resultArea;


    public void gui() {

        frameLabel();

        // Timer
        Timer timer = new Timer();

        // 1. 제품 투입 (1초마다 실행)
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                productionCount++;
                productionLabel.setText("생산완료 수량: " + productionCount);
                resultArea.append(getTimestamp() + " 생산 완료\n");

                //실적 변경
                resultLabel.setText("남은수량: " + (objectCount-productionCount));
            }
        }, 0, 1000);
    }

    private void frameLabel() {
        // JFrame 설정
        JFrame frame = new JFrame("생산 현황 시스템");
        frame.setSize(500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // 수량 표시 라벨
        JLabel inputLabel = new JLabel("투입 수량: " + inputCount);
        inputLabel.setBounds(50, 50, 200, 30);

        JLabel assemblyLabel = new JLabel("조립 공정 수량: " + assemblyCount);
        assemblyLabel.setBounds(50, 70, 200, 30);

        productionLabel = new JLabel("생산완료 수량: " + productionCount);
        productionLabel.setBounds(50, 90, 200, 30);

        JLabel objectLabel = new JLabel("목표수량: " + objectCount);
        objectLabel.setBounds(50, 110, 200, 30);

        resultLabel = new JLabel("남은수량: " + resultCount);
        resultLabel.setBounds(50, 130, 200, 30);

        // 실적log
        JLabel resultLogLabel = new JLabel("[생산현황]", SwingConstants.LEFT);
        resultLogLabel.setBounds(50, 170, 400, 30);
        resultLogLabel.setFont(boldFont);

        resultArea = new JTextArea();
        resultArea.setBounds(50, 200, 400, 200);
        resultArea.setEditable(false);
        JScrollPane resultScroll = new JScrollPane(resultArea);
        resultScroll.setBounds(50, 200, 400, 200);

        ProductionPlan productionPlan = new ProductionPlan();
        productionPlan.guiProductionPlan(); // 생산계획 log

        // 구성 요소 추가
        frame.add(inputLabel);
        frame.add(assemblyLabel);
        frame.add(productionLabel);
        frame.add(objectLabel);
        frame.add(resultLabel);
        frame.add(resultScroll); // 생산현황판
        frame.add(resultLogLabel);
        frame.add(productionPlan.planScroll); // 생산계획 스크롤

        // 창 보이기
        frame.setVisible(true);
    }
        private String getTimestamp () {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            return sdf.format(new Date());
        }
    }

