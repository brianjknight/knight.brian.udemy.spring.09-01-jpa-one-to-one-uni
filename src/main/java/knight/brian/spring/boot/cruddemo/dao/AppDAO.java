package knight.brian.spring.boot.cruddemo.dao;

import knight.brian.spring.boot.cruddemo.entity.Instructor;


public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
