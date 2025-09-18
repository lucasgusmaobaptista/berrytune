package me.lucasgusmao.berrytuneapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.lucasgusmao.berrytuneapi.model.Album;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlbumListResponse {

    private boolean success;
    private List<Album> albums;
}
