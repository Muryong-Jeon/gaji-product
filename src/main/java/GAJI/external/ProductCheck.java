package GAJI.external;

public class ProductCheck {

    private Long id;
    private Long productId;
    private String status;
    private String checkFlag;
    public String getCheckFlag() {
        return checkFlag;
    }
    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
