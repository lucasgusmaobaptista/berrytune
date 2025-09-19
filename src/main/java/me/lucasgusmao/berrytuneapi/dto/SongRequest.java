package me.lucasgusmao.berrytuneapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SongRequest {

    private String name;
    private String artistName;
    private String albumName;
    private String duration;
    private MultipartFile imageFile;
    private MultipartFile audioFile;
    private LocalDateTime releaseDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
