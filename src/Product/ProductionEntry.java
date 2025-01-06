package Product;


//생산계획 항목
public class ProductionEntry {
    private Model model; // 모델 객체
    private ProdcutionQty prodcutionQty; // 생산량 객체

    //생성자
    public ProductionEntry(Model model, ProdcutionQty prodcutionQty) {
        this.model = model;
        this.prodcutionQty = prodcutionQty;
    }

    // 모델 객체 반환
    public Model getModel() {
        return model;
    }

    // 생산량 객체 반환

    public ProdcutionQty getProdcutionQty() {
        return prodcutionQty;
    }
}
