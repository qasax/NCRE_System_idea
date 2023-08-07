package com.example.ncre_system_idea.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @ExcelProperty("用户ID")
    private int userID;
    @ExcelProperty("用户名ID")
    private String username;
    @ExcelProperty("密码（AES加密）")
    private String password;
    @ExcelProperty("用户类型")
    private String userType;
    @ExcelProperty("加密盐")
    private String aesKey;
}
