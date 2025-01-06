package Inventory;

public class ModelList {
    // 모델 리스트 클래스

    /*
    WA3353AW: 흰색 세탁기
    WF8800AB: 검정 세탁기
    DVG6000AG: 회색 건조기
    W: White | B: Black | G: Gray
     */

    // 모델 리스트 및 T/T
    String[] modelList = {"WA3350AW", "WF8800AB", "DVG6000AG"};
    double[] tTime = {12.5, 11, 13.5};

    public String getModelName(int i) { //모델명 메서드
        return modelList[i];
    }

    public double getTime(int i) { // T/T 메서드
        return tTime[i];
    }

}
