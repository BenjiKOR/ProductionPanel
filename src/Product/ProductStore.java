package Product;

import java.util.ArrayList;
import java.util.List;

public class ProductStore {

    // 모터명, 시리얼번호
    private static List<Model> modelList = new ArrayList<>();

    static {
        modelList.add(new Model("MotorA", "MA2025"));
        modelList.add(new Model("MotorB", "MB2025"));
        modelList.add(new Model("MotorC", "MC2025"));
    }

    public static Model getModel(int i){
        return modelList.get(i);
    }

}
