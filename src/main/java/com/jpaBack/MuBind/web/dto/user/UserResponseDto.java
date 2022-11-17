package com.jpaBack.MuBind.web.dto.user;

import com.jpaBack.MuBind.domain.MatchingStatus;
import com.jpaBack.MuBind.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto {
    private Long id;

    private Long userId;
    private String imgUrl;
    private String name;
    private String email;

    private String genre;

    private MatchingStatus approvalStatus;

    public UserResponseDto(User user) {
        BeanUtils.copyProperties(user, this);
        this.userId = user.getId();
        this.imgUrl = user.getPicture();
        this.name = user.getName();
        this.email = user.getEmail();
        this.genre = user.getGenre();

    }
}