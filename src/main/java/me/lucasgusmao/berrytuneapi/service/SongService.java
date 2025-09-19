package me.lucasgusmao.berrytuneapi.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import me.lucasgusmao.berrytuneapi.dto.SongRequest;
import me.lucasgusmao.berrytuneapi.model.Song;
import me.lucasgusmao.berrytuneapi.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;
    private final Cloudinary cloudinary;

    public Song addSong(SongRequest request) throws IOException {
        Map<String, Object> audioUploadResult = cloudinary.uploader()
                .upload(request.getAudioFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "video"));
        Map<String, Object> imageUploadResult = cloudinary.uploader()
                .upload(request.getImageFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "image"));
        Double durationInSeconds = (Double) audioUploadResult.get("duration");
        String duration = formatDuration(durationInSeconds);

        LocalDateTime releaseDate = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();

        Song newSong = Song.builder()
                .name(request.getName())
                .albumName(request.getAlbumName())
                .artistName(request.getArtistName())
                .imageUrl(imageUploadResult.get("secure_url").toString())
                .fileUrl(audioUploadResult.get("secure_url").toString())
                .duration(duration)
                .releaseDate(releaseDate)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();

        return songRepository.save(newSong);
    }

    public void teste() {

    }

    private String formatDuration(Double durationInSeconds) {
        if (durationInSeconds == null) {
            return "00:00";
        }
        int minutes = (int) (durationInSeconds / 60);
        int seconds = (int) (durationInSeconds % 60);
        return String.format("%02d:%02d", minutes, seconds);
    }
}
