package github.victtorribeiro.service;

import github.victtorribeiro.domain.entity.Numbers;
import org.apache.commons.collections4.ListUtils;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class NumbersService {



    public List<Double> searchNumbers(Integer page){
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();

        Numbers numbers = restTemplate.getForObject("http://challenge.dienekes.com.br/api/numbers?page=" + page, Numbers.class);
        return sortList(numbers.getNumbers());
    }

    public List<Double> sortList(List<Double> numbersList){
        double aux;
        for (int i = 0; i < numbersList.size();  i++){
            for (int j = 0; j < numbersList.size() - 1; j++){
                if(numbersList.get(j) > numbersList.get(j + 1)) {
                    aux = numbersList.get(j);
                    numbersList.set(j, numbersList.get(j + 1));
                    numbersList.set(j + 1, aux);

                }
            }
        }

        return numbersList;
    }



}