package com.entity;

public class Tops {
	
	
	/** 首页推荐类型 - 条幅 */
	public static final byte TYPE_SCROLL = 1;
	/** 首页推荐类型 - 大图 */
	public static final byte TYPE_LARGE = 2;
	/** 首页推荐类型 - 小图 */
	public static final byte TYPE_SMALL = 3;
	
	
    private Integer id;

    private Byte type;

    private Integer zuoyexxId;
    
	private Zuoyexx zuoyexx;

    public Zuoyexx getGood() {
		return zuoyexx;
	}

	public void setGood(Zuoyexx zuoyexx) {
		this.zuoyexx = zuoyexx;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getGoodId() {
        return zuoyexxId;
    }

    public void setGoodId(Integer zuoyexxId) {
        this.zuoyexxId = zuoyexxId;
    }
}