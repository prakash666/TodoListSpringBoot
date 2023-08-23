package com.project.ToDoListApp.Service;


import com.project.ToDoListApp.Entity.QuoteEntity;
import com.project.ToDoListApp.Repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {

    @Autowired
    public QuoteRepository quoteRepository;
    public List<QuoteEntity> descriptions() {
        return quoteRepository.findAll();
    }

    public String Postdescriptions(QuoteEntity quoteEntity) {
        quoteRepository.save(quoteEntity);
        return "Data hase been posted";
    }
}
