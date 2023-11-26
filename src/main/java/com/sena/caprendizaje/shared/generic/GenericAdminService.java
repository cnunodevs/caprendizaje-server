package com.sena.caprendizaje.shared.generic;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Esta interfaz representa un servicio genérico para la administración de
 * entidades.
 *
 * @param <Pojo>   el tipo de objeto de entidad.
 * @param <IdType> el tipo de datos para el identificador de la entidad.
 */
public interface GenericAdminService<Pojo, IdType> {

    /**
     * Obtiene una lista de todas las entidades.
     *
     * @return una lista de objetos de entidad.
     */
    List<Pojo> handleFindAll();

    /**
     * Actualiza una entidad existente.
     *
     * @param pojo el objeto de entidad a actualizar.
     */
    Pojo handleUpdate(Pojo pojo);

    /**
     * Elimina una entidad existente.
     *
     * @param pojo el objeto de entidad a eliminar.
     */
    void handleDelete(Pojo pojo);

    /**
     * Elimina una entidad por su identificador.
     *
     * @param id el identificador de la entidad a eliminar.
     */
    Boolean handleDeleteById(IdType id);

    /**
     * Obtiene una página de entidades que coinciden con el ejemplo proporcionado.
     *
     * @param example  el ejemplo de entidad para la búsqueda.
     * @param pageable la información de paginación.
     * @return una página de objetos de entidad.
     */
    Page<Pojo> handleFindAllPaginateByExample(Example<Pojo> example, Pageable pageable);

    /**
     * Obtiene una lista de entidades que coinciden con el ejemplo proporcionado.
     *
     * @param example el ejemplo de entidad para la búsqueda.
     * @return una lista de objetos de entidad.
     */
    List<Pojo> handleFindAllByExample(Example<Pojo> example);

    /**
     * Obtiene una página de todas las entidades paginadas.
     *
     * @param pageable la información de paginación.
     * @return una página de objetos de entidad.
     */
    Page<Pojo> handleFindAllPaginate(Pageable pageable);

    /**
     * Verifica si una entidad ya existe en el sistema.
     *
     * @param pojo el objeto de entidad a verificar.
     * @return true si la entidad ya existe, false en caso contrario.
     */
    Boolean handleAlreadyExist(Pojo pojo);

    /**
     * Verifica si una entidad con el identificador dado ya existe en el sistema.
     *
     * @param id el identificador de la entidad a verificar.
     * @return true si la entidad ya existe, false en caso contrario.
     */
    Boolean handleAlreadyExistById(IdType id);

    /**
     * Crea un nuevo registro de entidad.
     *
     * @param pojo el objeto de entidad a crear.
     * @return el objeto de entidad creado.
     */
    Pojo handleCreateNewRegister(Pojo pojo);

    /**
     * Crea una nueva lista de registros de entidad.
     *
     * @param list la lista de objetos de entidad a crear.
     */
    List<Pojo> handleCreateNewListOfRegisters(List<Pojo> list);

    void handleChangeState(Integer id, boolean state);

}
