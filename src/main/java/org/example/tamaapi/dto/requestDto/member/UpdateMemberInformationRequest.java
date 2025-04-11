package org.example.tamaapi.dto.requestDto.member;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UpdateMemberInformationRequest {

    @NotNull
    private Integer height;

    @NotNull
    private Integer weight;

}
