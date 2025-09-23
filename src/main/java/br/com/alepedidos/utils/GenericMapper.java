package br.com.alepedidos.utils;

import br.com.alepedidos.domain.exception.MapperException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GenericMapper {

    private final ObjectMapper objectMapper;

    public <T> T map(Object source,
                     Class<T> targetClass) {
        try {
            if (source == null) {
                throw new MapperException("Erro ao converter classe.");
            }
            return objectMapper.convertValue(source,
                                             targetClass);
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException("Erro ao converter " + ex);
        }
    }

    public <T, O> List<T>   mapAll(List<O> source, Class<T> targetClass){
        var objectlist = source.stream().map(o -> objectMapper.convertValue(o, targetClass)).toList();
        return objectlist;
    }
}
