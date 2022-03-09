package com.entity;

public class Zuoyexx {
    private Integer id;

    private String name;

    private String cover;

    private String image1;

    private String image2;

    private Integer banji;

    private String intro;
    
    private String teachername;

    private Integer renshu;

    private Integer typeId;
    
    private Integer shuliang;
    
	// 首页推荐标记
	private boolean topScroll; // 条幅推荐
	private boolean topLarge; // 大图推荐
	private boolean topSmall; // 小图推荐
	
 
	private Types type;
	
	private Teacher teacher;

    public Types getType() {
		return type;
	}

	public void setType(Types type) {
		this.type = type;
	}

	public boolean isTopScroll() {
		return topScroll;
	}

	public void setTopScroll(boolean topScroll) {
		this.topScroll = topScroll;
	}

	public boolean isTopLarge() {
		return topLarge;
	}

	public void setTopLarge(boolean topLarge) {
		this.topLarge = topLarge;
	}

	public boolean isTopSmall() {
		return topSmall;
	}

	public void setTopSmall(boolean topSmall) {
		this.topSmall = topSmall;
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
        this.name = name == null ? null : name.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1 == null ? null : image1.trim();
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2 == null ? null : image2.trim();
    }

    public Integer getBanji() {
        return banji;
    }

    public void setBanji(Integer banji) {
        this.banji = banji;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public Integer getRenshu() {
        return renshu;
    }

    public void setRenshu(Integer renshu) {
        this.renshu = renshu;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Integer getShuliang() {
		return shuliang;
	}

	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
}