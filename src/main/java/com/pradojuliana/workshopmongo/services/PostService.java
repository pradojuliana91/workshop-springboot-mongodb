package com.pradojuliana.workshopmongo.services;

import com.pradojuliana.workshopmongo.domain.Post;
import com.pradojuliana.workshopmongo.domain.User;
import com.pradojuliana.workshopmongo.dto.UserDTO;
import com.pradojuliana.workshopmongo.repository.PostRepository;
import com.pradojuliana.workshopmongo.repository.UserRepository;
import com.pradojuliana.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }
    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }
}
