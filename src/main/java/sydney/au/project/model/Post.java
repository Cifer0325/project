package sydney.au.project.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name = "post")
@Entity
public class Post {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer pid;
    private String pname;
    private String image;
    private String pdesc;
    private Integer is_hot;
    private Date pdate;

    // 二级分类的外键:使用二级分类的对象.
    @JoinColumn(name = "csid")
    @ManyToOne
    private CategorySecond categorySecond;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public Integer getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(Integer is_hot) {
        this.is_hot = is_hot;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date date) {
        this.pdate = date;
    }

    public CategorySecond getCategorySecond() {
        return categorySecond;
    }

    public void setCategorySecond(CategorySecond categorySecond) {
        this.categorySecond = categorySecond;
    }

    @Override
    public String toString() {
        return "Product [pid=" + pid + ", pname=" + pname +", image=" + image + ", pdesc=" + pdesc + ", is_hot=" + is_hot + ", pdate=" + pdate
                + ", categorySecond=" + categorySecond + "]";
    }
}

