package com.leopoldo.ebook.ebook.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.mappers.NationalityMapper;
import com.leopoldo.ebook.ebook.models.Nationality;
import com.leopoldo.ebook.ebook.repositories.INationalityRepository;
import com.leopoldo.ebook.ebook.services.interfaces.INationalityServices;

@Service
public class NationalityService implements INationalityServices{

    @Autowired
    private INationalityRepository nr;

    @Autowired
    private NationalityMapper nm;

    @Override
    public JsonApiResponse findAll() {
        

        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(nm.nationalityToNationalityDetailsDtos((List<Nationality>)nr.findAll()))
                .build();
    }


}
