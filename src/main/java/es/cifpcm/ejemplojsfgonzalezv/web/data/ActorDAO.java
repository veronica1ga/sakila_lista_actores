package es.cifpcm.ejemplojsfgonzalezv.web.data;

import java.util.List;

import es.cifpcm.ejemplojsfgonzalezv.web.model.Actor;

public interface ActorDAO {
	Actor insert(Actor actor);
    List<Actor> selectAll();
}
