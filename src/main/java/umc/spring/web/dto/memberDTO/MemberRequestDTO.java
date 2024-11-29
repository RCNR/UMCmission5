package umc.spring.web.dto.memberDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.enums.Role;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    @Setter // 타임리프에서 사용하기 위해 추가
    public static class JoinDTO {
        @NotBlank
        String name;

        @NotBlank
        @Email
        String email;    // 이메일 필드 추가

        @NotBlank
        String password;    // 비밀번호 필드 추가

        @NotNull
        Integer gender;

        @NotNull
        Integer birthYear;

        @NotNull
        Integer birthMonth;

        @NotNull
        Integer birthDay;

        @Size(min = 5, max = 12)
        String address;

        @Size(min = 5, max = 12)
        String specAddress;

//        @ExistCategories
//        List<Long> preferCategory;

        @NotNull
        Role role;
    }
}
