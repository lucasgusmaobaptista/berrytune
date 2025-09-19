package me.lucasgusmao.berrytuneapi.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import me.lucasgusmao.berrytuneapi.dto.AlbumListResponse;
import me.lucasgusmao.berrytuneapi.dto.AlbumRequest;
import me.lucasgusmao.berrytuneapi.model.Album;
import me.lucasgusmao.berrytuneapi.repository.AlbumRepository;
import org.springframework.stereotype.Service;
import java.lang.Object;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


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

    public AlbumListResponse getAllAlbums() {
        return new AlbumListResponse(true, albumRepository.findAll());
    }

    public Boolean deleteAlbum(String id) {
        Album existingAlbum = albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album não encontrado!"));

        albumRepository.delete(existingAlbum);
    }
