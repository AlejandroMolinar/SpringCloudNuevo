package com.microservices.app.course.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.microservices.app.course.models.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Long>{
    
    /***************************************************************************************************************
     * Diferencias: *                                                                                              *
     * Join        -> Solo extrae los elementos de esa base de datos.                                              *
     * Join fetch  -> Esta extrae los elemento de la base de datos y las bases de datos asociada al requerimiento. *
     ***************************************************************************************************************/

    @Query("select c from Course c join fetch c.student st where st.id = ?1")
    public Course findCourseByStudentId(Long studentId);


}