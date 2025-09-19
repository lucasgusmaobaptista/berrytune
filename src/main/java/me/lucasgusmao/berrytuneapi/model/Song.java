package me.lucasgusmao.berrytuneapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Song {

    @Id
    @JsonProperty("_id")
    private String id;

    private String name;
    private String artistName;
    private String albumName;
    private String duration;
    private String imageUrl;
    private String fileUrl;
    private LocalDateTime releaseDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
