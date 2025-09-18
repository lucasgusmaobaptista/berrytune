package me.lucasgusmao.berrytuneapi.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import me.lucasgusmao.berrytuneapi.dto.AlbumRequest;
import me.lucasgusmao.berrytuneapi.model.Album;
import me.lucasgusmao.berrytuneapi.repository.AlbumRepository;
import org.springframework.stereotype.Service;
import java.lang.Object;

import java.io.IOException;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final Cloudinary cloudinary;

    public Album addAlbum(AlbumRequest request) throws IOException {
        Map<String, Object> imageUploadResult = cloudinary.uploader()
                .upload(request.getImageFile().getBytes(),
                ObjectUtils.asMap("resource_type", "auto"));

        Album newAlbum = Album.builder()
                .name(request.getName())
                .description(request.getDescription())
                .bgColour(request.getBgColour())
                .imageUrl((String) imageUploadResult.get("secure_url").toString())
                .build();

        return albumRepository.save(newAlbum);
    }
}
