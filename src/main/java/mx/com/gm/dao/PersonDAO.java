package mx.com.gm.dao;
import mx.com.gm.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonDAO extends CrudRepository<Person, Long> { //ya no necesito la notación Repository en una clase
    // que implemente esta interface, sino
    // que mi interface extiende de esta interface CrudRepository y así no tengo que agregar los métodos para un crud.
    // Como es un tipo genérico que puedo ussar en cualquier clase de tipo DAO, especifico el tipo de entidad que va a
    // manejar, que son objetos de tipo persona, y también el tipo de llave primaria con que trabajo, en este caso Long

    //debo inyectar esta clase en el controlador
}
