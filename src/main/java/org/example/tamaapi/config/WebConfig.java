package org.example.tamaapi.config;

import org.example.tamaapi.dto.requestDto.MySort;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Sort;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToMySortConverter());
    }

    private class StringToMySortConverter implements Converter<String, MySort> {

        //MyBadRequestException 발생하면 MethodArgumentNotValidException가 먼저 실행됨. 에러 메시지 전달 불가
        //검증은 SortValidator에서 함
        @Override
        public MySort convert(String source) {
            String[] parts = source.split(",");
            MySort mySort = new MySort(null, null);
            switch (parts.length){
                case 1 -> mySort = new MySort(parts[0], null);
                case 2 -> mySort = new MySort(parts[0], Sort.Direction.fromString(parts[1]));
            }
            return mySort;
        }
    }


}
