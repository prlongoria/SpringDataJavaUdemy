package mx.com.gm.service;
//Esta es la capa de servicio
import mx.com.gm.dao.PersonDAO;
import mx.com.gm.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service//Para poder inyectar esta clase como implementación de la interface en el controlador de Spring
public class PersonServiceImp implements PersonService{
    @Autowired
    private PersonDAO personDAO; //Mi controlador va a usar la capa de servicio(esta clase)


    @Override
    @Transactional(readOnly = true) //Porque solo lee información de la bbdd. OJO, importarla de spring
    public List<Person> readPersons() {
        return (List<Person>) personDAO.findAll();//Tuve que hacer un cast automáticamente
    }

    @Override
    @Transactional
    public void save(Person person) {
    personDAO.save(person);
    }

    @Override
    @Transactional
    public void delete(Person person) {
    personDAO.delete(person);
    }

    @Override
    @Transactional(readOnly = true)
    public Person findPerson(Person person) {
        return personDAO.findById(person.getIdPerson()).orElse(null);
    }
}
//Cuando estoy en capa DAO, se maneja el concepto de transacciones, cualquier operacion con la bbdd se hará un rollback
// o un commit si no hay errores, pero cuando trabajo con las clases de servicio, puedo estar usando varios objetos de
// tipoDao desde una misma clase de servicio, y podría estar realizando distintas operaciones sobre distintas tablas de
// la bbdd y estos métodos, por tanto, debo marcarlos como transaccionales