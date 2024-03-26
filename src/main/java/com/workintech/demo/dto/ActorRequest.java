package com.workintech.demo.dto;


import com.workintech.demo.entity.Actor;
import com.workintech.demo.entity.Movie;
import lombok.Data;

import java.util.List;

@Data
public class ActorRequest {
    private List<Movie> movies;
    private Actor actor;
}