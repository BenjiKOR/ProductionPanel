package Product;

// 모델 데이터 저장
public class Model {
    private String name;
    private String serialNum;

    public Model(String name, String serialNum) {
        this.name = name;
        this.serialNum = serialNum;
    }

    public String getName() {
        return name;
    }

    public String getSerialNum() {
        return serialNum;
    }

/*    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", serialNum='" + serialNum + '\'' +
                '}';
    }*/
}
