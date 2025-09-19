package me.lucasgusmao.berrytuneapi.repository;

import me.lucasgusmao.berrytuneapi.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends MongoRepository<Song, String> {
}
