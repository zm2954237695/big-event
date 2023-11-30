package com.guo.event.pojo;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
public class Category {

    private Integer id;

    @NotEmpty
    private String categoryName;

    @NotEmpty
    private String categoryAlias;

    private Integer createUser;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
