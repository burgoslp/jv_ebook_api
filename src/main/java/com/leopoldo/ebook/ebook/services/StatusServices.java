package com.leopoldo.ebook.ebook.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.mappers.StatusMapper;
import com.leopoldo.ebook.ebook.models.Status;
import com.leopoldo.ebook.ebook.repositories.IStatusRepository;
import com.leopoldo.ebook.ebook.services.interfaces.IStatusServices;

@Service
public class StatusServices implements IStatusServices {

    @Autowired
    private IStatusRepository sr;

    @Autowired
    private StatusMapper sm;

    @Override
    public JsonApiResponse findAll() {
        return JsonApiResponse.builder()
                .message(HttpStatus.OK.getReasonPhrase())
                .code( HttpStatus.OK.value())
                .data(sm.statusToSumaryDto((List<Status>)sr.findAll()))
                .build();
    }

}
