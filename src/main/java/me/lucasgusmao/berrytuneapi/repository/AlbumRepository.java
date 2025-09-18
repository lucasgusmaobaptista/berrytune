package me.lucasgusmao.berrytuneapi.repository;

import me.lucasgusmao.berrytuneapi.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends MongoRepository<Album, String> {
}
