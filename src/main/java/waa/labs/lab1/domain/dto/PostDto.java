package waa.labs.lab1.domain.dto;

import lombok.Data;

@Data
public class PostDto {
    long id;
    String title;
    String content;
    String author;
}
