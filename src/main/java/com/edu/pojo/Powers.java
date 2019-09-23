package com.edu.pojo;

import lombok.Data;

/**
 * @Auther: 王玺瑞
 * @Date: 2019/9/16 20:28
 * @Description:
 */
@Data
public class Powers {
    private int poId;
    private String poName;
    private String address;

    public Powers() {
    }

    public Powers(int poId, String poName,String address) {
        this.poId = poId;
        this.poName = poName;
        this.address = address;
    }
}
