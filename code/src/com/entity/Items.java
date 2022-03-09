package com.entity;

public class Items {
    private Integer id;

    private Integer banji;

    private Integer amount;

    private Integer orderId;

    private Integer zuoyexxId;

	private float total;
	
	private Zuoyexx zuoyexx;
    
    public Zuoyexx getGood() {
		return zuoyexx;
	}

	public void setGood(Zuoyexx zuoyexx) {
		this.zuoyexx = zuoyexx;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBanji() {
        return banji;
    }

    public void setBanji(Integer banji) {
        this.banji = banji;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodId() {
        return zuoyexxId;
    }

    public void setGoodId(Integer zuoyexxId) {
        this.zuoyexxId = zuoyexxId;
    }
}