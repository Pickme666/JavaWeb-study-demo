package JDBC.Work;

/**
 * 品牌类 Brand
 *
 * idea快捷键:
 *      Ctrl + r        查找替换
 *      Alt + 鼠标左键   整列编辑
 */

public class Brand {
    private Integer id;             // id 主键
    private String brandName;       // 品牌名称
    private String companyName;     // 企业名称
    private Integer ordered;        // 排序字段
    private String description;     // 描述信息
    private Integer status;         // 状态：0：禁用 1：启用 (int默认值0, 所以建议用包装类)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
