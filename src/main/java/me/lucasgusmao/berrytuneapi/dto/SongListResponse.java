package me.lucasgusmao.berrytuneapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.lucasgusmao.berrytuneapi.model.Song;

import java.util.List;
import java.util.function.BinaryOperator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SongListResponse {

    private Boolean success;
    private List<Song> songs;
}
