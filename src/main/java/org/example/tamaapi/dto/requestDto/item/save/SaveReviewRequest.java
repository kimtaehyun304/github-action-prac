package org.example.tamaapi.dto.requestDto.item.save;

import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SaveReviewRequest {

    @NotNull @Positive
    private Long orderItemId;

    @NotNull @Positive
    private Integer rating;

    @NotBlank
    private String comment;

    private Integer height;

    private Integer weight;

}
