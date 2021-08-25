package net.msj0319.api.user.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.List;

//UserDTO 컨테이너를 만들어 중요 정보를 감싼다.프론트 단으로 넘길 내용
@Data
@Component
public class UserDto {
    @ApiModelProperty(position = 0)
    private long userId;
    @ApiModelProperty(position = 1)
    private String username;
    @ApiModelProperty(position = 2)
    private String password;
    @ApiModelProperty(position = 3)
    private String name;
    @ApiModelProperty(position = 4)
    private String email;
    @ApiModelProperty(position = 5)
    private String regDate;
    @ApiModelProperty(position = 6)
    private String token;
    @ApiModelProperty(position = 7)
    private List<Role> roles;
}
