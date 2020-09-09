package GAJI;

import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Product_table")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String productName;
    private Long memberId;
    private String status = "In stock";

    @PostPersist
    public void onPostPersist(){
        Registered registered = new Registered();
        BeanUtils.copyProperties(this, registered);
        registered.publishAfterCommit();

        GAJI.external.ProductCheck productCheck = new GAJI.external.ProductCheck();
        // mappings goes here
        productCheck.setProductId(this.getId());
        productCheck.setCheckFlag("X");

        ProductApplication.applicationContext.getBean(GAJI.external.ProductCheckService.class)
                .requestCheck(productCheck);

    }

    @PostUpdate
    public void onPostUpdate(){
        StatusChanged statusChanged = new StatusChanged();
        BeanUtils.copyProperties(this, statusChanged);
        statusChanged.publishAfterCommit();


    }

    @PostRemove
    public void onPostRemove(){
        Deleted deleted = new Deleted();
        BeanUtils.copyProperties(this, deleted);
        deleted.publishAfterCommit();


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
