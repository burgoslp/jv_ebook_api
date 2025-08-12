package com.leopoldo.ebook.ebook.util;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class MapToDto {

    // Convertir un objeto fuente a un DTO de destino
    // Utiliza BeanUtils para copiar propiedades del objeto fuente al objeto de destino
    public Object mapToDto(Object source, Class<?> targetClass) {
        try {
            Object target = targetClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping to DTO: " + e.getMessage(), e);
        }
    }

    public List<Object> mapToDto(List<?> sourceList, Class<?> targetClass) {
        return sourceList.stream()
                .map(source -> mapToDto(source, targetClass))
                .collect(Collectors.toList());
    }

}
