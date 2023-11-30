package com.guo.event.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
public class User {


    @NotNull
    private Integer id;

    private String username;

    @JsonIgnore
    private String password;

    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname;

    @Email
    @NotEmpty
    private String email;

    private String userPic;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
