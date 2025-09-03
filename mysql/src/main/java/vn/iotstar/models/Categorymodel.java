package vn.iotstar.models;

public class Categorymodel {
    private Integer id; // cate_id
    private String name; // cate_name
    private String icon; // icons
    private Long userId; // khóa ngoại đến User.id

    public Categorymodel() {
    }

    public Categorymodel(Integer id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    public Categorymodel(Integer id, String name, String icon, Long userId) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
