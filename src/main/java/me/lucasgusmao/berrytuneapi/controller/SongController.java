package me.lucasgusmao.berrytuneapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import me.lucasgusmao.berrytuneapi.dto.SongRequest;
import me.lucasgusmao.berrytuneapi.model.Song;
import me.lucasgusmao.berrytuneapi.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @PostMapping
    public ResponseEntity<?> addSong(@RequestPart("request") String requestString,
                                     @RequestPart("audio") MultipartFile audioFile,
                                     @RequestPart("image") MultipartFile imageFile) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            SongRequest songRequest = objectMapper.readValue(requestString, SongRequest.class);
            songRequest.setAudioFile(audioFile);
            songRequest.setImageFile(imageFile);
            var song = songService.addSong(songRequest);

            return ResponseEntity.status(HttpStatus.CREATED).body(song);
        } catch (Exception e) {

        }
    }
}
